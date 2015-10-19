package com.yxtar.server.dto.cassandra;

import java.util.Date;
import java.util.Set;
import java.util.UUID;

import org.springframework.data.cassandra.mapping.CassandraType;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import com.datastax.driver.core.DataType.Name;
import com.yxtar.app.base.model.map.BaseMap;
import com.yxtar.server.dto.BaseDto;

@Table("platform_location")
public class PlatformLocation extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub

	}

	// @PrimaryKeyColumn(ordinal = 0, type = PrimaryKeyType.PARTITIONED)
	@PrimaryKey
	private UUID locationId;
	// @PrimaryKeyColumn(ordinal = 1, type = PrimaryKeyType.CLUSTERED)
	private String province;
	// @PrimaryKeyColumn(ordinal = 2, type = PrimaryKeyType.CLUSTERED)
	private String city;
	// @PrimaryKeyColumn(ordinal = 3, type = PrimaryKeyType.CLUSTERED)
	private String district;
	// @PrimaryKeyColumn(ordinal = 4, type = PrimaryKeyType.CLUSTERED)
	private String street;

	private String locationName;
	private String detailAddr;

	@CassandraType(type = Name.SET)
	private Set<String> tag;
	private Date createTime;
	private Integer reachRate;
	private Integer status;
	private Set<Integer> dcampLst;

	public UUID getLocationId() {
		return locationId;
	}

	public void setLocationId(UUID locationId) {
		this.locationId = locationId;
	}

	public String getProvince() {
		return province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getLocationName() {
		return locationName;
	}

	public void setLocationName(String locationName) {
		this.locationName = locationName;
	}

	public String getDetailAddr() {
		return detailAddr;
	}

	public void setDetailAddr(String detailAddr) {
		this.detailAddr = detailAddr;
	}

	public Set<String> getTag() {
		return tag;
	}

	public void setTag(Set<String> tag) {
		this.tag = tag;
	}

	public Date getCreateTime() {
		return createTime;
	}

	public void setCreateTime(Date createTime) {
		this.createTime = createTime;
	}

	public Integer getReachRate() {
		return reachRate;
	}

	public void setReachRate(Integer reachRate) {
		this.reachRate = reachRate;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<Integer> getDcampLst() {
		return dcampLst;
	}

	public void setDcampLst(Set<Integer> dcampLst) {
		this.dcampLst = dcampLst;
	}

}
