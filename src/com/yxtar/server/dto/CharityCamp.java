package com.yxtar.server.dto;

import com.yxtar.app.base.model.map.BaseMap;

import java.util.Date;
import java.util.Set;

public class CharityCamp extends BaseDto {
	@Override
	public void copyFromMapProcess(BaseMap map) {
		// TODO Auto-generated method stub

	}

	private Integer id;
	private Advertiser advertisers;
	private String title;
	private String smallHorPhoto;
	private String smallVertPhoto;
	private String introMainPhoto;
	private String eventUsagePhoto;
	private String introdLong;
	private String introdShort;
	private Integer introdPageNum;
	private String htmlIntrod;
	private Integer campType;
	private Integer cycleNumber;
	private Integer cycleNoofdate;
	private Integer currentCycle;
	private Date startDate;
	private Date endDate;
	private String province;
	private String city;
	private String district;
	private Integer actionType;
	private String actionAdvPhoto;
	private String actionQuestion;
	private String actionAnswer;
	private Boolean isPublic;
	private Integer targetType;
	private Integer numOfTarget;
	private Integer numPeopleTOne;
	private Integer numPeopleTTwo;
	private Integer numPeopleTThree;
	private Integer donationTOne;
	private Integer donationTTwo;
	private Integer donationTThree;

	private Double amountPerSupport;
	private Double longitude;
	private Double latitude;
	
	private Integer status;
	private Integer periodNum;
	private CharityCampReport reportId;

	private Set<CampSponsorRelation> campSponsorRelations;
	private Set<CharityFund> charityFunds;
	private Set<CharityCampHistory> charityCampHistories;

	public CharityCampReport getReportId() {
		return reportId;
	}

	public void setReportId(CharityCampReport reportId) {
		this.reportId = reportId;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getSmallHorPhoto() {
		return smallHorPhoto;
	}

	public void setSmallHorPhoto(String smallHorPhoto) {
		this.smallHorPhoto = smallHorPhoto;
	}

	public String getSmallVertPhoto() {
		return smallVertPhoto;
	}

	public void setSmallVertPhoto(String smallVertPhoto) {
		this.smallVertPhoto = smallVertPhoto;
	}

	public String getIntroMainPhoto() {
		return introMainPhoto;
	}

	public void setIntroMainPhoto(String introMainPhoto) {
		this.introMainPhoto = introMainPhoto;
	}

	public String getEventUsagePhoto() {
		return eventUsagePhoto;
	}

	public void setEventUsagePhoto(String eventUsagePhoto) {
		this.eventUsagePhoto = eventUsagePhoto;
	}

	public String getIntrodLong() {
		return introdLong;
	}

	public void setIntrodLong(String introdLong) {
		this.introdLong = introdLong;
	}

	public String getIntrodShort() {
		return introdShort;
	}

	public void setIntrodShort(String introdShort) {
		this.introdShort = introdShort;
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

	public Integer getCampType() {
		return campType;
	}

	public void setCampType(Integer campType) {
		this.campType = campType;
	}

	public Integer getCycleNumber() {
		return cycleNumber;
	}

	public void setCycleNumber(Integer cycleNumber) {
		this.cycleNumber = cycleNumber;
	}

	public Integer getCycleNoofdate() {
		return cycleNoofdate;
	}

	public void setCycleNoofdate(Integer cycleNoofdate) {
		this.cycleNoofdate = cycleNoofdate;
	}

	public Integer getCurrentCycle() {
		return currentCycle;
	}

	public void setCurrentCycle(Integer currentCycle) {
		this.currentCycle = currentCycle;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
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

	public Integer getActionType() {
		return actionType;
	}

	public void setActionType(Integer actionType) {
		this.actionType = actionType;
	}

	public String getActionAdvPhoto() {
		return actionAdvPhoto;
	}

	public void setActionAdvPhoto(String actionAdvPhoto) {
		this.actionAdvPhoto = actionAdvPhoto;
	}

	public String getActionQuestion() {
		return actionQuestion;
	}

	public void setActionQuestion(String actionQuestion) {
		this.actionQuestion = actionQuestion;
	}

	public String getActionAnswer() {
		return actionAnswer;
	}

	public void setActionAnswer(String actionAnswer) {
		this.actionAnswer = actionAnswer;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

	public Integer getTargetType() {
		return targetType;
	}

	public void setTargetType(Integer targetType) {
		this.targetType = targetType;
	}

	public Integer getNumOfTarget() {
		return numOfTarget;
	}

	public void setNumOfTarget(Integer numOfTarget) {
		this.numOfTarget = numOfTarget;
	}

	public Integer getNumPeopleTOne() {
		return numPeopleTOne;
	}

	public void setNumPeopleTOne(Integer numPeopleTOne) {
		this.numPeopleTOne = numPeopleTOne;
	}

	public Integer getNumPeopleTTwo() {
		return numPeopleTTwo;
	}

	public void setNumPeopleTTwo(Integer numPeopleTTwo) {
		this.numPeopleTTwo = numPeopleTTwo;
	}

	public Integer getNumPeopleTThree() {
		return numPeopleTThree;
	}

	public void setNumPeopleTThree(Integer numPeopleTThree) {
		this.numPeopleTThree = numPeopleTThree;
	}

	public Integer getDonationTOne() {
		return donationTOne;
	}

	public void setDonationTOne(Integer donationTOne) {
		this.donationTOne = donationTOne;
	}

	public Integer getDonationTTwo() {
		return donationTTwo;
	}

	public void setDonationTTwo(Integer donationTTwo) {
		this.donationTTwo = donationTTwo;
	}

	public Integer getDonationTThree() {
		return donationTThree;
	}

	public void setDonationTThree(Integer donationTThree) {
		this.donationTThree = donationTThree;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Integer getPeriodNum() {
		return periodNum;
	}

	public void setPeriodNum(Integer periodNum) {
		this.periodNum = periodNum;
	}

	public Set<CampSponsorRelation> getCampSponsorRelations() {
		return campSponsorRelations;
	}

	public void setCampSponsorRelations(Set<CampSponsorRelation> campSponsorRelations) {
		this.campSponsorRelations = campSponsorRelations;
	}

	public Set<CharityFund> getCharityFunds() {
		return charityFunds;
	}

	public void setCharityFunds(Set<CharityFund> charityFunds) {
		this.charityFunds = charityFunds;
	}

	@Override
	public void generateMapProcess(Object object) {

	}

	public Advertiser getAdvertisers() {
		return advertisers;
	}

	public void setAdvertisers(Advertiser advertisers) {
		this.advertisers = advertisers;
	}

	public Set<CharityCampHistory> getCharityCampHistories() {
		return charityCampHistories;
	}

	public void setCharityCampHistories(Set<CharityCampHistory> charityCampHistories) {
		this.charityCampHistories = charityCampHistories;
	}

	public Double getAmountPerSupport() {
		return amountPerSupport;
	}

	public void setAmountPerSupport(Double amountPerSupport) {
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
