package com.yxtar.server.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CompleteMultipartUploadRequest;
import com.aliyun.oss.model.CompleteMultipartUploadResult;
import com.aliyun.oss.model.InitiateMultipartUploadRequest;
import com.aliyun.oss.model.InitiateMultipartUploadResult;
import com.aliyun.oss.model.ObjectMetadata;
import com.aliyun.oss.model.PartETag;
import com.aliyun.oss.model.UploadPartRequest;
import com.aliyun.oss.model.UploadPartResult;

public class AliyunOssUtils {
	private String bucketName;
	private int uploadObjectCach = 0;
	@Autowired
	private OSSClient ossClient;

	public boolean multipartUpload(String key, MultipartFile item) throws IOException{
		System.out.println("AliyunOssUtils multipartUpload - start - item size ="+item.getSize()+" key =" +key);

		//check to see if the object key is used, if it is used, return false and do nothing
		if(this.getObjectMeta(key)!=null){
			System.out.println("AliyunOssUtils multipartUpload - file existed already  ");
			return false;
		}
		
		try{
			// 创建上传Object的Metadata
			ObjectMetadata meta = new ObjectMetadata();
			meta.setCacheControl("max-age="+uploadObjectCach);

			// 开始Multipart Upload
			InitiateMultipartUploadRequest initiateMultipartUploadRequest = new InitiateMultipartUploadRequest(bucketName, key, meta);
			InitiateMultipartUploadResult initiateMultipartUploadResult = ossClient.initiateMultipartUpload(initiateMultipartUploadRequest);

			// 设置每块为 5M
			final int partSize = 1024 * 1024 * 5;

			// 计算分块数目
			int partCount = (int) (item.getSize() / partSize);
			if (item.getSize() % partSize != 0){
				partCount++;
			}

			// 新建一个List保存每个分块上传后的ETag和PartNumber
			List<PartETag> partETags = new ArrayList<PartETag>();
			for(int i = 0; i < partCount; i++){
				// 获取文件流
				InputStream fis = item.getInputStream();
				// 跳到每个分块的开头
				long skipBytes = partSize * i;
				fis.skip(skipBytes);
				// 计算每个分块的大小
				long size = partSize < item.getSize() - skipBytes ?
						partSize : item.getSize()  - skipBytes;
				// 创建UploadPartRequest，上传分块
				UploadPartRequest uploadPartRequest = new UploadPartRequest();
				uploadPartRequest.setBucketName(bucketName);
				uploadPartRequest.setKey(key);
				uploadPartRequest.setUploadId(initiateMultipartUploadResult.getUploadId());
				uploadPartRequest.setInputStream(fis);
				uploadPartRequest.setPartSize(size);
				uploadPartRequest.setPartNumber(i + 1);

				UploadPartResult uploadPartResult = ossClient.uploadPart(uploadPartRequest);

				// 将返回的PartETag保存到List中。
				partETags.add(uploadPartResult.getPartETag());
			}

			CompleteMultipartUploadRequest completeMultipartUploadRequest =
					new CompleteMultipartUploadRequest(bucketName,key, initiateMultipartUploadResult.getUploadId(), partETags);

			// 完成分块上传
			CompleteMultipartUploadResult completeMultipartUploadResult =
					ossClient.completeMultipartUpload(completeMultipartUploadRequest);

			// 打印Object的ETag
			System.out.println("AliyunOssUtils multipartUpload - complete - "+completeMultipartUploadResult.getETag());
			return true;
		}catch(Exception e){
			System.out.println("AliyunOssUtils multipartUpload  - exception - "+e.getMessage());
			return false;
		}

	}

	public void removeObject(String key){
		// 删除Object
		ossClient.deleteObject(bucketName, key);
	}
	
	public ObjectMetadata getObjectMeta(String key){
		try{
			return ossClient.getObjectMetadata(bucketName, key);
		}catch(Exception e){
			return null;
		}
	}

	public String getBucketName() {
		return bucketName;
	}

	public void setBucketName(String bucketName) {
		this.bucketName = bucketName;
	}

	public int getUploadObjectCach() {
		return uploadObjectCach;
	}

	public void setUploadObjectCach(int uploadObjectCach) {
		this.uploadObjectCach = uploadObjectCach;
	}

	public OSSClient getOssClient() {
		return ossClient;
	}

	public void setOssClient(OSSClient ossClient) {
		this.ossClient = ossClient;
	}
	
	


}
