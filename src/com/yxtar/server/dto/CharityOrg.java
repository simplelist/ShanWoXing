package com.yxtar.server.dto;

import java.util.Set;

import com.yxtar.app.base.model.map.BaseMap;


public class CharityOrg extends BaseDto{

	private Integer id;
	private String cpersonFname;
	private String cpersonLname;
	private String cpersonEmail;
	private String cpersonMobile;
	private String loginId;
	private String password;
	private String name;
	private String horiLogoPhoto;
	private String vertLogoPhoto;
	private String squareLogoPhoto;
	private String introBackgroundPhoto;
	private String longIntrod;
	private String shortIntrod;
	private Integer introdPageNum;
	private String htmlIntrod;
	private Integer status;
	private Set<CharityFund> charityFunds;
	private Integer amountPerSupport;
	private Double longitude;
	private Double latitude;
	
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getCpersonFname() {
		return cpersonFname;
	}

	public void setCpersonFname(String cpersonFname) {
		this.cpersonFname = cpersonFname;
	}

	public String getCpersonLname() {
		return cpersonLname;
	}

	public void setCpersonLname(String cpersonLname) {
		this.cpersonLname = cpersonLname;
	}

	public String getCpersonEmail() {
		return cpersonEmail;
	}

	public void setCpersonEmail(String cpersonEmail) {
		this.cpersonEmail = cpersonEmail;
	}

	public String getCpersonMobile() {
		return cpersonMobile;
	}

	public void setCpersonMobile(String cpersonMobile) {
		this.cpersonMobile = cpersonMobile;
	}

	public String getLoginId() {
		return loginId;
	}

	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getHoriLogoPhoto() {
		return horiLogoPhoto;
	}

	public void setHoriLogoPhoto(String horiLogoPhoto) {
		this.horiLogoPhoto = horiLogoPhoto;
	}

	public String getVertLogoPhoto() {
		return vertLogoPhoto;
	}

	public void setVertLogoPhoto(String vertLogoPhoto) {
		this.vertLogoPhoto = vertLogoPhoto;
	}

	public String getSquareLogoPhoto() {
		return squareLogoPhoto;
	}

	public void setSquareLogoPhoto(String squareLogoPhoto) {
		this.squareLogoPhoto = squareLogoPhoto;
	}

	public String getIntroBackgroundPhoto() {
		return introBackgroundPhoto;
	}

	public void setIntroBackgroundPhoto(String introBackgroundPhoto) {
		this.introBackgroundPhoto = introBackgroundPhoto;
	}

	public String getLongIntrod() {
		return longIntrod;
	}

	public void setLongIntrod(String longIntrod) {
		this.longIntrod = longIntrod;
	}

	public String getShortIntrod() {
		return shortIntrod;
	}

	public void setShortIntrod(String shortIntrod) {
		this.shortIntrod = shortIntrod;
	}

	public Integer getIntrodPageNum() {
		return introdPageNum;
	}

	public void setIntrodPageNum(Integer introdPageNum) {
		this.introdPageNum = introdPageNum;
	}

	public String getHtmlIntrod() {
		return htmlIntrod;
	}

	public void setHtmlIntrod(String htmlIntrod) {
		this.htmlIntrod = htmlIntrod;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	@Override
	public void generateMapProcess(Object object) {
		// TODO Auto-generated method stub
		
	}

	public Set<CharityFund> getCharityFunds() {
		return charityFunds;
	}

	public void setCharityFunds(Set<CharityFund> charityFunds) {
		this.charityFunds = charityFunds;
	}

	@Override
	public void copyFromMapProcess(BaseMap map) {
//		if (null!=map) {
//			List<CharityFundMap> cList=((CharityOrgMap) map).getCharityFunds();
//			if (null!=cList&&!cList.isEmpty()) {
//				for (CharityFundMap c : cList) {
//					this.charityFunds.add(this.getCharityFunds().copyFromMap(c));
//				}
//			}
//		}
	}

	public Integer getAmountPerSupport() {
		return amountPerSupport;
	}

	public void setAmountPerSupport(Integer amountPerSupport) {
		this.amountPerSupport = amountPerSupport;
	}

	public Double getLongitude() {
		return longitude;
	}

	public void setLongitude(Double longitude) {
		this.longitude = longitude;
	}

	public Double getLatitude() {
		return latitude;
	}

	public void setLatitude(Double latitude) {
		this.latitude = latitude;
	}

}
