package com.yxtar.app.base.model.map;

import java.util.List;



public class CharityOrgMap extends BaseMap {
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
	private List<CharityFundMap> charityFunds;

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

	public List<CharityFundMap> getCharityFunds() {
		return charityFunds;
	}

	public void setCharityFunds(List<CharityFundMap> charityFunds) {
		this.charityFunds = charityFunds;
	}

}
