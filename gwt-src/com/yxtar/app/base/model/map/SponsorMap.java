package com.yxtar.app.base.model.map;

import java.util.List;



public class SponsorMap extends BaseMap {
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
	private Integer companyIntrodPageNum;
	private String companyHtmlIntrod;
	private String companyWebSite;
	private Integer status;
	private Double accountBalance;
	private Double effortMonthly;
	private Double effortYearly;
	private List<CampSponsorRelationMap> campSponsorRelations;

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

	public Integer getCompanyIntrodPageNum() {
		return companyIntrodPageNum;
	}

	public void setCompanyIntrodPageNum(Integer companyIntrodPageNum) {
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

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Double getAccountBalance() {
		return accountBalance;
	}

	public void setAccountBalance(Double accountBalance) {
		this.accountBalance = accountBalance;
	}

	public Double getEffortMonthly() {
		return effortMonthly;
	}

	public void setEffortMonthly(Double effortMonthly) {
		this.effortMonthly = effortMonthly;
	}

	public Double getEffortYearly() {
		return effortYearly;
	}

	public void setEffortYearly(Double effortYearly) {
		this.effortYearly = effortYearly;
	}

	public List<CampSponsorRelationMap> getCampSponsorRelations() {
		return campSponsorRelations;
	}

	public void setCampSponsorRelations(List<CampSponsorRelationMap> campSponsorRelations) {
		this.campSponsorRelations = campSponsorRelations;
	}

}
