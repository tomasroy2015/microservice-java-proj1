package jp.co.linkstaff.iis.model;

import java.util.Arrays;
import java.util.Date;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class JobParttime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
    private Long parttimeJobId;

	@Column(nullable = false, unique = true)
    private String jobCode;
    private String hospitalCode;

	private String jobType; //Change datatype to String
	private Boolean isPublic;
    private String displayType;
    private Date displayStartdate;   
	private Date displayEnddate;
    private Date displayDate;
	private String jobTitle;
	private String jobTitleOther;
    private String jobStatus;
    private String jobDescription;
    private String jobUrl;
//    private String anonymousType;
//    private String anonymousTypeCode;   
	private String hurriedly;
    private Double salary;
    private String salaryUnit;
    private String salaryComment;
    private String salaryPaymentClosing;
    private String salaryPaymentDay;
    private Double experienceYear;
    private String workAddress1;
    private String workAddress2;
    private String workAddress3;
    private String workZip;
    private Date spotDate;
    private Date workStartdate;
    private Date workEnddate;
    private String workDay;
    private String workDayComment;
    private String workComment;
    private String shiftPattern;
    private String ampm;
    private String shiftPatternComment;
    private String workTime;
    private Boolean workTimeTalk;
    private Boolean workTimeTalkFree;
    private String workSelection;
    private String workSelectionMedi;
    private String contactTel;
    private String contactEmail;
    private String contactFax;
    private String workTel;
    private String workFax;
    private String jobTimeFComment;
    private String jobChallengeDesc;
    private String jobServerity;
    private String promotionCategory;
    private String age; //Change datatype to int
    private String transportation;
    private String transportationDetail;
    private Boolean carCommuting;
    private Boolean biweeklyWork;
    private Boolean oneWorkMonth;
    private Boolean oneWorkWeek;
    private String shift;
    private String naht;
    private String intubation;
    private String paracentesis;
    private String laboratoryTechnician;
    private String bedDialysis;
    private String xrayTechnician;
    private Boolean oncall;
	private String nursery;
	private String nurseryType;
    private String dutyMeal;
    private String dutyThreeMeals;
    private String dutyTv;
    private String dutyInternet;
    private String dutyRefrigerator;
    private String dutyBath;
    private String dutyPot;
    private String appAllowance;
    private String salaryHanded;
    private String supplement;
    private String portalComment;
    private String pic1NameKana;
    private String pic1Name;
    private String pic1Position;
    private String messageProvider;
    private String messageText;
    private String messageLinkstaff;
    private String linkstaffTel;
    private String workStationCode1;
    private String workStationCode2;
    private String workStationCode3;
	private String workTransLine;
    private String workTransStation;
    private Integer workTransWalkingTime;
    private String workTransWalkingComment;
    private Integer workTransBusTime;
    private String workTransBusComment;
    private String searchKeyword;
    private String workContent;
    private String subject;

	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}

	@Column(nullable = false, updatable = false)
   	@CreationTimestamp
    private Date createdAt;
    private Date updatedAt;
    private Boolean isDeleted = false;
    public JobParttime() {}

    @PreUpdate
	@PrePersist
    void updateSearchKeyword() {
	final String fullSearchString = String.join(" ",(Iterable<? extends CharSequence>) Arrays.asList(jobCode,
               (workAddress1 == null ? "":workAddress1),
               (workAddress2 == null ? "":workAddress2),
               (workAddress3 == null ? "":workAddress3),
               (jobTitle == null ? "":jobTitle),
               (jobDescription == null ? "":jobDescription),
               (workContent == null ? "":workContent),
               (workStationCode1 == null ? "":workStationCode1)));
      this.searchKeyword = fullSearchString;
   }
	
	public Long getParttimeJobId() {
		return parttimeJobId;
	}
	public void setParttimeJobId(Long parttimeJobId) {
		this.parttimeJobId = parttimeJobId;
	}

	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getHospitalCode() {
		return hospitalCode;
	}
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	public String getJobType() {
		return jobType;
	}
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	public String getDisplayType() {
		return displayType;
	}
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	public Date getDisplayStartdate() {
		return displayStartdate;
	}
	public void setDisplayStartdate(Date displayStartdate) {
		this.displayStartdate = displayStartdate;
	}
	public Date getDisplayEnddate() {
		return displayEnddate;
	}
	public void setDisplayEnddate(Date displayEnddate) {
		this.displayEnddate = displayEnddate;
	}
	public Date getDisplayDate() {
		return displayDate;
	}
	public void setDisplayDate(Date displayDate) {
		this.displayDate = displayDate;
	}
	public String getJobTitle() {
		return jobTitle;
	}
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	public String getJobTitleOther() {
		return jobTitleOther;
	}
	public void setJobTitleOther(String jobTitleOther) {
		this.jobTitleOther = jobTitleOther;
	}
	public String getJobStatus() {
		return jobStatus;
	}
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	public String getJobDescription() {
		return jobDescription;
	}
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	public String getJobUrl() {
		return jobUrl;
	}
	public void setJobUrl(String jobUrl) {
		this.jobUrl = jobUrl;
	}
//	public String getAnonymousType() {
//		return anonymousType;
//	}
//	public void setAnonymousType(String anonymousType) {
//		this.anonymousType = anonymousType;
//	}
//	public String getAnonymousTypeCode() {
//		return anonymousTypeCode;
//	}
//	public void setAnonymousTypeCode(String anonymousTypeCode) {
//		this.anonymousTypeCode = anonymousTypeCode;
//	}
	public String getHurriedly() {
		return hurriedly;
	}
	public void setHurriedly(String hurriedly) {
		this.hurriedly = hurriedly;
	}
	public Double getSalary() {
		return salary;
	}
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	public String getSalaryUnit() {
		return salaryUnit;
	}
	public void setSalaryUnit(String salaryUnit) {
		this.salaryUnit = salaryUnit;
	}
	public String getSalaryComment() {
		return salaryComment;
	}
	public void setSalaryComment(String salaryComment) {
		this.salaryComment = salaryComment;
	}
	public String getSalaryPaymentClosing() {
		return salaryPaymentClosing;
	}
	public void setSalaryPaymentClosing(String salaryPaymentClosing) {
		this.salaryPaymentClosing = salaryPaymentClosing;
	}
	public String getSalaryPaymentDay() {
		return salaryPaymentDay;
	}
	public void setSalaryPaymentDay(String salaryPaymentDay) {
		this.salaryPaymentDay = salaryPaymentDay;
	}
	public Double getExperienceYear() {
		return experienceYear;
	}
	public void setExperienceYear(Double experienceYear) {
		this.experienceYear = experienceYear;
	}
	public String getWorkAddress1() {
		return workAddress1;
	}
	public void setWorkAddress1(String workAddress1) {
		this.workAddress1 = workAddress1;
	}
	public String getWorkAddress2() {
		return workAddress2;
	}
	public void setWorkAddress2(String workAddress2) {
		this.workAddress2 = workAddress2;
	}
	public String getWorkAddress3() {
		return workAddress3;
	}
	public void setWorkAddress3(String workAddress3) {
		this.workAddress3 = workAddress3;
	}
	public String getWorkZip() {
		return workZip;
	}
	public void setWorkZip(String workZip) {
		this.workZip = workZip;
	}
	public Date getSpotDate() {
		return spotDate;
	}
	public void setSpotDate(Date spotDate) {
		this.spotDate = spotDate;
	}
	public Date getWorkStartdate() {
		return workStartdate;
	}
	public void setWorkStartdate(Date workStartdate) {
		this.workStartdate = workStartdate;
	}
	public Date getWorkEnddate() {
		return workEnddate;
	}
	public void setWorkEnddate(Date workEnddate) {
		this.workEnddate = workEnddate;
	}
	public String getWorkDay() {
		return workDay;
	}
	public void setWorkDay(String workDay) {
		this.workDay = workDay;
	}
	public String getWorkDayComment() {
		return workDayComment;
	}
	public void setWorkDayComment(String workDayComment) {
		this.workDayComment = workDayComment;
	}
	public String getWorkComment() {
		return workComment;
	}
	public void setWorkComment(String workComment) {
		this.workComment = workComment;
	}
	public String getShiftPattern() {
		return shiftPattern;
	}
	public void setShiftPattern(String shiftPattern) {
		this.shiftPattern = shiftPattern;
	}
	public String getAmpm() {
		return ampm;
	}
	public void setAmpm(String ampm) {
		this.ampm = ampm;
	}
	public String getShiftPatternComment() {
		return shiftPatternComment;
	}
	public void setShiftPatternComment(String shiftPatternComment) {
		this.shiftPatternComment = shiftPatternComment;
	}
	public String getWorkTime() {
		return workTime;
	}
	public void setWorkTime(String workTime) {
		this.workTime = workTime;
	}
	public Boolean getWorkTimeTalk() {
		return workTimeTalk;
	}
	public void setWorkTimeTalk(Boolean workTimeTalk) {
		this.workTimeTalk = workTimeTalk;
	}
	public Boolean getWorkTimeTalkFree() {
		return workTimeTalkFree;
	}
	public void setWorkTimeTalkFree(Boolean workTimeTalkFree) {
		this.workTimeTalkFree = workTimeTalkFree;
	}
	public String getWorkSelection() {
		return workSelection;
	}
	public void setWorkSelection(String workSelection) {
		this.workSelection = workSelection;
	}
	public String getWorkSelectionMedi() {
		return workSelectionMedi;
	}
	public void setWorkSelectionMedi(String workSelectionMedi) {
		this.workSelectionMedi = workSelectionMedi;
	}
	public String getContactTel() {
		return contactTel;
	}
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	public String getContactEmail() {
		return contactEmail;
	}
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	public String getContactFax() {
		return contactFax;
	}
	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}
	public String getWorkTel() {
		return workTel;
	}
	public void setWorkTel(String workTel) {
		this.workTel = workTel;
	}
	public String getWorkFax() {
		return workFax;
	}
	public void setWorkFax(String workFax) {
		this.workFax = workFax;
	}
	public String getJobTimeFComment() {
		return jobTimeFComment;
	}
	public void setJobTimeFComment(String jobTimeFComment) {
		this.jobTimeFComment = jobTimeFComment;
	}
	public String getJobChallengeDesc() {
		return jobChallengeDesc;
	}
	public void setJobChallengeDesc(String jobChallengeDesc) {
		this.jobChallengeDesc = jobChallengeDesc;
	}
	public String getJobServerity() {
		return jobServerity;
	}
	public void setJobServerity(String jobServerity) {
		this.jobServerity = jobServerity;
	}
	public String getPromotionCategory() {
		return promotionCategory;
	}
	public void setPromotionCategory(String promotionCategory) {
		this.promotionCategory = promotionCategory;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getTransportation() {
		return transportation;
	}
	public void setTransportation(String transportation) {
		this.transportation = transportation;
	}
	public String getTransportationDetail() {
		return transportationDetail;
	}
	public void setTransportationDetail(String transportationDetail) {
		this.transportationDetail = transportationDetail;
	}
	public Boolean getCarCommuting() {
		return carCommuting;
	}
	public void setCarCommuting(Boolean carCommuting) {
		this.carCommuting = carCommuting;
	}
	public Boolean getBiweeklyWork() {
		return biweeklyWork;
	}
	public void setBiweeklyWork(Boolean biweeklyWork) {
		this.biweeklyWork = biweeklyWork;
	}
	public Boolean getOneWorkMonth() {
		return oneWorkMonth;
	}
	public void setOneWorkMonth(Boolean oneWorkMonth) {
		this.oneWorkMonth = oneWorkMonth;
	}
	public Boolean getOneWorkWeek() {
		return oneWorkWeek;
	}
	public void setOneWorkWeek(Boolean oneWorkWeek) {
		this.oneWorkWeek = oneWorkWeek;
	}
	public String getShift() {
		return shift;
	}
	public void setShift(String shift) {
		this.shift = shift;
	}
	public String getNaht() {
		return naht;
	}
	public void setNaht(String naht) {
		this.naht = naht;
	}
	public String getIntubation() {
		return intubation;
	}
	public void setIntubation(String intubation) {
		this.intubation = intubation;
	}
	public String getParacentesis() {
		return paracentesis;
	}
	public void setParacentesis(String paracentesis) {
		this.paracentesis = paracentesis;
	}
	public String getLaboratoryTechnician() {
		return laboratoryTechnician;
	}
	public void setLaboratoryTechnician(String laboratoryTechnician) {
		this.laboratoryTechnician = laboratoryTechnician;
	}
	public String getBedDialysis() {
		return bedDialysis;
	}
	public void setBedDialysis(String bedDialysis) {
		this.bedDialysis = bedDialysis;
	}
	public String getXrayTechnician() {
		return xrayTechnician;
	}
	public void setXrayTechnician(String xrayTechnician) {
		this.xrayTechnician = xrayTechnician;
	}
	public Boolean getOncall() {
		return oncall;
	}
	public void setOncall(Boolean oncall) {
		this.oncall = oncall;
	}
	public String getNursery() {
		return nursery;
	}
	public void setNursery(String nursery) {
		this.nursery = nursery;
	}
	public String getNurseryType() {
		return nurseryType;
	}
	public void setNurseryType(String nurseryType) {
		this.nurseryType = nurseryType;
	}
	public String getDutyMeal() {
		return dutyMeal;
	}
	public void setDutyMeal(String dutyMeal) {
		this.dutyMeal = dutyMeal;
	}
	public String getDutyThreeMeals() {
		return dutyThreeMeals;
	}
	public void setDutyThreeMeals(String dutyThreeMeals) {
		this.dutyThreeMeals = dutyThreeMeals;
	}
	public String getDutyTv() {
		return dutyTv;
	}
	public void setDutyTv(String dutyTv) {
		this.dutyTv = dutyTv;
	}
	public String getDutyInternet() {
		return dutyInternet;
	}
	public void setDutyInternet(String dutyInternet) {
		this.dutyInternet = dutyInternet;
	}
	public String getDutyRefrigerator() {
		return dutyRefrigerator;
	}
	public void setDutyRefrigerator(String dutyRefrigerator) {
		this.dutyRefrigerator = dutyRefrigerator;
	}
	public String getDutyBath() {
		return dutyBath;
	}
	public void setDutyBath(String dutyBath) {
		this.dutyBath = dutyBath;
	}
	public String getDutyPot() {
		return dutyPot;
	}
	public void setDutyPot(String dutyPot) {
		this.dutyPot = dutyPot;
	}
	public String getAppAllowance() {
		return appAllowance;
	}
	public void setAppAllowance(String appAllowance) {
		this.appAllowance = appAllowance;
	}
	public String getSalaryHanded() {
		return salaryHanded;
	}
	public void setSalaryHanded(String salaryHanded) {
		this.salaryHanded = salaryHanded;
	}
	public String getSupplement() {
		return supplement;
	}
	public void setSupplement(String supplement) {
		this.supplement = supplement;
	}
	public String getPortalComment() {
		return portalComment;
	}
	public void setPortalComment(String portalComment) {
		this.portalComment = portalComment;
	}
	public String getPic1NameKana() {
		return pic1NameKana;
	}
	public void setPic1NameKana(String pic1NameKana) {
		this.pic1NameKana = pic1NameKana;
	}
	public String getPic1Name() {
		return pic1Name;
	}
	public void setPic1Name(String pic1Name) {
		this.pic1Name = pic1Name;
	}
	public String getPic1Position() {
		return pic1Position;
	}
	public void setPic1Position(String pic1Position) {
		this.pic1Position = pic1Position;
	}
	public String getMessageProvider() {
		return messageProvider;
	}
	public void setMessageProvider(String messageProvider) {
		this.messageProvider = messageProvider;
	}
	public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public String getMessageLinkstaff() {
		return messageLinkstaff;
	}
	public void setMessageLinkstaff(String messageLinkstaff) {
		this.messageLinkstaff = messageLinkstaff;
	}
	public String getLinkstaffTel() {
		return linkstaffTel;
	}
	public void setLinkstaffTel(String linkstaffTel) {
		this.linkstaffTel = linkstaffTel;
	}
	public String getWorkStationCode1() {
		return workStationCode1;
	}
	public void setWorkStationCode1(String workStationCode1) {
		this.workStationCode1 = workStationCode1;
	}
	public String getWorkStationCode2() {
		return workStationCode2;
	}
	public void setWorkStationCode2(String workStationCode2) {
		this.workStationCode2 = workStationCode2;
	}
	public String getWorkStationCode3() {
		return workStationCode3;
	}
	public void setWorkStationCode3(String workStationCode3) {
		this.workStationCode3 = workStationCode3;
	}
	public String getWorkTransLine() {
		return workTransLine;
	}
	public void setWorkTransLine(String workTransLine) {
		this.workTransLine = workTransLine;
	}
	public String getWorkTransStation() {
		return workTransStation;
	}
	public void setWorkTransStation(String workTransStation) {
		this.workTransStation = workTransStation;
	}
	public Integer getWorkTransWalkingTime() {
		return workTransWalkingTime;
	}
	public void setWorkTransWalkingTime(Integer workTransWalkingTime) {
		this.workTransWalkingTime = workTransWalkingTime;
	}
	public String getWorkTransWalkingComment() {
		return workTransWalkingComment;
	}
	public void setWorkTransWalkingComment(String workTransWalkingComment) {
		this.workTransWalkingComment = workTransWalkingComment;
	}
	public Integer getWorkTransBusTime() {
		return workTransBusTime;
	}
	public void setWorkTransBusTime(Integer workTransBusTime) {
		this.workTransBusTime = workTransBusTime;
	}
	public String getWorkTransBusComment() {
		return workTransBusComment;
	}
	public void setWorkTransBusComment(String workTransBusComment) {
		this.workTransBusComment = workTransBusComment;
	}
	public String getSearchKeyword() {
		return searchKeyword;
	}
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	public String getWorkContent() {
		return workContent;
	}
	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	/**
	 * @return the isPublic
	 */
	public Boolean getIsPublic() {
		return isPublic;
	}

	/**
	 * @param isPublic the isPublic to set
	 */
	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}

}
