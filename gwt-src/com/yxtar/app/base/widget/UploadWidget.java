package com.yxtar.app.base.widget;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.dom.client.ChangeEvent;
import com.google.gwt.event.dom.client.ChangeHandler;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.user.client.DOM;
import com.google.gwt.user.client.Element;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.FileUpload;
import com.google.gwt.user.client.ui.FormPanel;
import com.google.gwt.user.client.ui.FormPanel.SubmitCompleteEvent;
import com.google.gwt.user.client.ui.FormPanel.SubmitEvent;
import com.google.gwt.user.client.ui.HorizontalPanel;
import com.yxtar.app.base.constants.WidgetsConstants;

/**
 * upload widget
 * @paramater action loaction, image:upload/img.do documents:upload/doc.do
 */
public class UploadWidget extends Composite {
	private WidgetsConstants constants = GWT.create(WidgetsConstants.class);
	private HorizontalPanel rootPanel = new HorizontalPanel();
	private FormPanel form = new FormPanel();
	private FileUpload upload = new FileUpload();
	private UploadDocWidgetHandler handler = null;
	private Button button = new Button(constants.upload());

	public UploadWidget(final String action) {
		initWidget(rootPanel);
		rootPanel.add(form);
		rootPanel.add(button);
		form.setEncoding(FormPanel.ENCODING_MULTIPART);
		form.setMethod(FormPanel.METHOD_POST);
		form.setAction(action);
		form.setWidget(upload);
		DOM.setElementProperty(upload.getElement(), "multiple", "multiple");
		upload.setName("uploadFormElement");

		rootPanel.setBorderWidth(0);
		rootPanel.setStyleName("upload_doc_widget_rootPanel");
		upload.setStyleName("upload_doc_widget_rootPanel_upload");
		button.addClickHandler(new ClickHandler() {

			@Override
			public void onClick(ClickEvent event) {
				jsClickUpload(upload.getElement());
			}
		});
		form.addSubmitHandler(new FormPanel.SubmitHandler() {

			@Override
			public void onSubmit(SubmitEvent event) {
				if (upload.getFilename().length() != 0) {
					if (validationFile(action,upload.getFilename().toLowerCase())) {
						if (handler != null) {
							handler.onSubmit();
						}
					}
				}
			}
		});

		form.addSubmitCompleteHandler(new FormPanel.SubmitCompleteHandler() {

			@Override
			public void onSubmitComplete(SubmitCompleteEvent event) {
				String result = event.getResults();
				if (!result.contains("Fail")) {
					if (!result.contains("MaxUploadSizeExceededException")) {
						String[] str = result.split("/\\*--\\*/");
						if (str != null && str.length > 0) {
							int sumsize = 0;
							List<String> idlist = new ArrayList<String>();
							for (int i = 0; i < str.length; i++) {
								String[] ids = str[i].split(";");
								if (ids != null && ids.length > 0) {
									idlist.add(ids[0]);
								}
							}
							if (handler != null && idlist.size() != 0) {
								handler.onComplete(idlist, String.valueOf(sumsize));
							}
						}
					} else {
						if (handler != null) {
							form.reset();
							handler.error(constants.uploadmaxsizeError());
						}
					}
				}
			}
		});

		upload.addChangeHandler(new ChangeHandler() {

			@Override
			public void onChange(ChangeEvent event) {

				if (upload.getFilename().length() != 0) {
					form.submit();
					form.reset();
				}
			}
		});

	}

	/**
	 * 
	 * @param action:image or doc action 
	 * 	for example: "upload/doc.do","upload/img.do"
	 * @param fileName file name :test.txt
	 * @return
	 */
	private boolean validationFile(String action,String fileName){
		boolean fileIsOK=false;
		List<String> formatName=new ArrayList<String>();
		if (action.contains("img")) {
			/**
			 * image upload
			 */
			for (UploadPictureFormatEnum format : UploadPictureFormatEnum.values()) {
				if (!fileIsOK) {
					if (fileName.endsWith("."+format.name())) {
						fileIsOK=true;
						break;
					}
					formatName.add(format.name());
				}
			}
			if (!fileIsOK) {
				handler.error("image format is error ( only "+formatName.toString()+" can be accepted )");
			}
		}else if(action.contains("doc")) {
			/**
			 * file upload
			 */
			for (UploadDocFormatEnum format : UploadDocFormatEnum.values()) {
				if (!fileIsOK) {
					if (fileName.endsWith("."+format.name())) {
						fileIsOK=true;
						break;
					}
					formatName.add(format.name());
				}
			}
			if (!fileIsOK) {
				handler.error("file format is error( only ( "+formatName.toString()+" ) can be accepted)");
			}
		}
		return fileIsOK;
	}
	public void setCssStyle(String style) {
		rootPanel.getElement().setAttribute("style", style);
	}

	private native void jsClickUpload(Element pElement) /*-{
		pElement.click();
	}-*/;

	private void onClick() {
		jsClickUpload(upload.getElement());
	}

	public void setUploadImageWidgetHandler(UploadDocWidgetHandler handler) {
		this.handler = handler;
	}
	public interface UploadDocWidgetHandler {

		/**
		 * submit complete
		 */
		public void onComplete(List<String> id,String sumsize);
		
		public void onSubmit();
		
		public void error(String msg);
		
	}
	
	/**
	 *all fromat  of  can be upload Picture 
	 */
	public enum UploadPictureFormatEnum {
		png(0), jpg(1), jpeg(2), gif(3),bmp(4),tiff(5);
		private Integer type;

		UploadPictureFormatEnum(Integer type) {
			this.type = type;
		}

		public Integer getType() {
			return type;
		}

		public void setType(Integer type) {
			this.type = type;
		}
		
	}
	/**
	 * all fromat of can be upload Document
	 */
	public enum UploadDocFormatEnum {
		zip(0), rar(1), 
		doc(2), docx(3), xls(4), xlsx(5), pdf(6), txt(7), ppt(8),pptx(9),
		jar(10),mp3(11),mp4(12),rmvb(13),mkv(14),mov(15),avi(16),
		apk(17),
		pages(18), numbers(19), key(20)
		;
		private Integer type;
		
		UploadDocFormatEnum(Integer type) {
			this.type = type;
		}
		
		public Integer getType() {
			return type;
		}
		
		public void setType(Integer type) {
			this.type = type;
		}
	}
}
