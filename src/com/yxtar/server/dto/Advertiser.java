package com.yxtar.server.dto;

import java.util.Set;

import com.yxtar.app.base.model.map.BaseMap;

public class Advertiser extends BaseDto {

	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub
	}

	@Override
	public void generateMapProcess(Object object) {

	}

	private Integer id;
	private String cpersonFname;
	private String cpersonLname;
	private String cpersonEmail;
	private String cpersonMobile;
	private String loginId;
	private String password;
	private String companyName;
	private String horiLogoPhoto;
	private String vertLogoPhoto;
	private String squareLogoPhoto;
	private String introBackgroundPhoto;
	private String companyLongIntrod;
	private String companyShortIntrod;
	private String companyIntrodPageNum;
	private String companyHtmlIntrod;
	private String companyWebSite;
	private Double accBalance;
	private Integer status;
	private Set<CharityCamp> charityCamps;
	private Set<MoneyInRecord> moneyInRecords;

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

	public String getCompanyName() {
		return companyName;
	}

	public void setCompanyName(String companyName) {
		this.companyName = companyName;
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

	public String getCompanyLongIntrod() {
		return companyLongIntrod;
	}

	public void setCompanyLongIntrod(String companyLongIntrod) {
		this.companyLongIntrod = companyLongIntrod;
	}

	public String getCompanyShortIntrod() {
		return companyShortIntrod;
	}

	public void setCompanyShortIntrod(String companyShortIntrod) {
		this.companyShortIntrod = companyShortIntrod;
	}

	public String getCompanyIntrodPageNum() {
		return companyIntrodPageNum;
	}

	public void setCompanyIntrodPageNum(String companyIntrodPageNum) {
		this.companyIntrodPageNum = companyIntrodPageNum;
	}

	public String getCompanyHtmlIntrod() {
		return companyHtmlIntrod;
	}

	public void setCompanyHtmlIntrod(String companyHtmlIntrod) {
		this.companyHtmlIntrod = companyHtmlIntrod;
	}

	public String getCompanyWebSite() {
		return companyWebSite;
	}

	public void setCompanyWebSite(String companyWebSite) {
		this.companyWebSite = companyWebSite;
	}

	public Double getAccBalance() {
		return accBalance;
	}

	public void setAccBalance(Double accBalance) {
		this.accBalance = accBalance;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Set<CharityCamp> getCharityCamps() {
		return charityCamps;
	}

	public void setCharityCamps(Set<CharityCamp> charityCamps) {
		this.charityCamps = charityCamps;
	}

	public Set<MoneyInRecord> getMoneyInRecords() {
		return moneyInRecords;
	}

	public void setMoneyInRecords(Set<MoneyInRecord> moneyInRecords) {
		this.moneyInRecords = moneyInRecords;
	}

}
