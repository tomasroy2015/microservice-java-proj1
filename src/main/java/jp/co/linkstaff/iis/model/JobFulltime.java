/*
 * NOTE: 
 * 	1. why to use JsonDeserialize
 * 	2. what should be the datatype of 'age'
 */

package jp.co.linkstaff.iis.model;

import java.util.Arrays;
import java.util.Date;
import org.hibernate.annotations.CreationTimestamp;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
//import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;

@Entity
public class JobFulltime {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long fulltimeJobId;
	
	@Column(nullable = false, unique = true)
    private String jobCode;
	
    private String hospitalCode;
	private Boolean isPublic;
	private String jobType; // data type?
	private String displayType;
	private Date displayStartdate;
	private Date displayEnddate;
	private Date displayDate;
	// private String anonymousType;
	// private String anonymousTypeCode;
	private String jobTitle;
	private String jobTitleOther;
	private String jobStatus;
	private String jobDescription;
	private Double salary;
	private Double experienceYear;
	private String workAddress1;
	private String workAddress2;
	private String workAddress3;
	private String workZip;
	private String contactTel;
	private String contactEmail;
	private String contactFax;
	private String workTel;
	private String workFax;
	private String jobTimeComment;
	private String jobChallengeDesc;
	private String jobServerity;
	private String promotionCategory;
	private String salary5year;
	private String salary5yearOther;
	private String salary10year;
	private String salary10yearOther;
	private String salaryOther;
	private Double salaryMax;
	private Double salaryMin;
	private String age; // data type? is it necessary(here, age wont change even though time passby)?
	private String nightDuty;
	private String nightDutyWm;
	private Integer nightDutyTime;
	private String nightDutyOther;
	private String nightDutySalary;
	private String nightDutySalaryYen;
	private String nightDutySystem;
	private String salaryBonus;
	private String salaryCommission;
	private String salaryRaise;
	private String salaryAssessment;
	private String salarySeverance;
	private String trial;
	private Integer trialMonth;
	private String dorm;
	private String dormFeePayment;
	private String dormFeeRate;
	private String dormFeeYen;
	private String dormFeeOther;
	private String holiday;
	private String holidayDayHalf;
	private String holidayOther;
	private String holidayComment;
	private String vacationYearend;
	private String vacationSummer;
	private String vacationSalaried;
	private String vacationOther;
	private String vacationYearendText;
	private String vacationSummerText;
	private String vacationSalariedText;
	private String vacationComment;
	private String research;
	private String researchFree1;
	private String researchFree2;
	private String society;
	private String societyDay;
	private String societyTime;
	private String societyOther;
	private String societyPaid;
	private String societyPaidYen;
	private String societyPaidOther;
	private String appAllowance;
	private String appAllowanceFree;
	private String appAllowanceYen;
	private String policy;
	private String portalComment;
	private String pic1NameKana;
	private String pic1Name;
	private String pic1Position;
	private String pic2NameKana;
	private String pic2Name;
	private String pic2Position;
	private String pic3NameKana;
	private String pic3Name;
	private String pic3Position;
	private String messageProvider;
	private String messageText;
	private String messageLinkstaff;
	private String workStationCode1;
	private String workStationCode2;
	private String workStationCode3;
	private String workTransLine;
	private String workTransStation;
	private Integer workTransWalkingTime;
	private String workTransWalkingComment;
	private Integer workTransBusTime;
	private String workTransBusComment;
	@Column(name = "search_keyword")
	private String searchKeyword;

	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdAt;

	private Date updatedAt;
	private Date deletedAt;
	private Boolean isDeleted = false;

	private String jobUrl;
	private String subject;
	private String subjectOther;
	private String workContent;

	/*
	 * ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Constructors~~~~~~~~~~~~~~~~~~~~~~~~~~~~
	 * ~~~~~~~
	 */
	public JobFulltime() {
		// Zero argument empty constructor
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

	@PreUpdate
	@PrePersist
   void updateSearchKeyword() {
      final String fullSearchString = String.join(" ",Arrays.asList(
              jobCode,
              (workAddress1 == null ? "":workAddress1),
              (workAddress1 == null ? "":workAddress2),
              (workAddress3 == null ? "":workAddress3),
              (jobTitle == null ? "":jobTitle),
              (jobDescription == null ? "":jobDescription),
              (workContent == null ? "":workContent),
              (workStationCode1 == null ? "":workStationCode1)));
      this.searchKeyword = fullSearchString;
   }
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Getters & Setters~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	public Long getFulltimeJobId() {
		return fulltimeJobId;
	}
	public void setFulltimeJobId(Long fulltimeJobId) {
		this.fulltimeJobId = fulltimeJobId;
	}
	/**
	 * @return the jobCode
	 */
	public String getJobCode() {
		return jobCode;
	}
	/**
	 * @param jobCode the jobCode to set
	 */
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	/**
	 * @return the hospitalCode
	 */
	public String getHospitalCode() {
		return hospitalCode;
	}
	/**
	 * @param hospitalCode the hospitalCode to set
	 */
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	/**
	 * @return the jobType
	 */
	public String getJobType() {
		return jobType;
	}
	/**
	 * @param jobType the jobType to set
	 */
	public void setJobType(String jobType) {
		this.jobType = jobType;
	}
	/**
	 * @return the displayType
	 */
	public String getDisplayType() {
		return displayType;
	}
	/**
	 * @param displayType the displayType to set
	 */
	public void setDisplayType(String displayType) {
		this.displayType = displayType;
	}
	/**
	 * @return the displayStartdate
	 */
	//@JsonDeserialize
	public Date getDisplayStartdate() {
		return displayStartdate;
	}
	/**
	 * @param displayStartdate the displayStartdate to set
	 */
	public void setDisplayStartdate(Date displayStartdate) {
		this.displayStartdate = displayStartdate;
	}
	/**
	 * @return the displayEnddate
	 */
	//@JsonDeserialize
	public Date getDisplayEnddate() {
		return displayEnddate;
	}
	/**
	 * @param displayEnddate the displayEnddate to set
	 */
	public void setDisplayEnddate(Date displayEnddate) {
		this.displayEnddate = displayEnddate;
	}
	/**
	 * @return the displayDate
	 */
	//@JsonDeserialize
	public Date getDisplayDate() {
		return displayDate;
	}
	/**
	 * @param displayDate the displayDate to set
	 */
	public void setDisplayDate(Date displayDate) {
		this.displayDate = displayDate;
	}
//	/**
//	 * @return the anonymousType
//	 */
//	public String getAnonymousType() {
//		return anonymousType;
//	}
//	/**
//	 * @param anonymousType the anonymousType to set
//	 */
//	public void setAnonymousType(String anonymousType) {
//		this.anonymousType = anonymousType;
//	}
//	/**
//	 * @return the anonymousTypeCode
//	 */
//	public String getAnonymousTypeCode() {
//		return anonymousTypeCode;
//	}
//	/**
//	 * @param anonymousTypeCode the anonymousTypeCode to set
//	 */
//	public void setAnonymousTypeCode(String anonymousTypeCode) {
//		this.anonymousTypeCode = anonymousTypeCode;
//	}
	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	/**
	 * @return the jobTitleOther
	 */
	public String getJobTitleOther() {
		return jobTitleOther;
	}
	/**
	 * @param jobTitleOther the jobTitleOther to set
	 */
	public void setJobTitleOther(String jobTitleOther) {
		this.jobTitleOther = jobTitleOther;
	}
	/**
	 * @return the jobStatus
	 */
	public String getJobStatus() {
		return jobStatus;
	}
	/**
	 * @param jobStatus the jobStatus to set
	 */
	public void setJobStatus(String jobStatus) {
		this.jobStatus = jobStatus;
	}
	/**
	 * @return the jobDescription
	 */
	public String getJobDescription() {
		return jobDescription;
	}
	/**
	 * @param jobDescription the jobDescription to set
	 */
	public void setJobDescription(String jobDescription) {
		this.jobDescription = jobDescription;
	}
	/**
	 * @return the salary
	 */
	public Double getSalary() {
		return salary;
	}
	/**
	 * @param salary the salary to set
	 */
	public void setSalary(Double salary) {
		this.salary = salary;
	}
	/**
	 * @return the experienceYear
	 */
	public Double getExperienceYear() {
		return experienceYear;
	}
	/**
	 * @param experienceYear the experienceYear to set
	 */
	public void setExperienceYear(Double experienceYear) {
		this.experienceYear = experienceYear;
	}
	/**
	 * @return the workAddress1
	 */
	public String getWorkAddress1() {
		return workAddress1;
	}
	/**
	 * @param workAddress1 the workAddress1 to set
	 */
	public void setWorkAddress1(String workAddress1) {
		this.workAddress1 = workAddress1;
	}
	/**
	 * @return the workAddress2
	 */
	public String getWorkAddress2() {
		return workAddress2;
	}
	/**
	 * @param workAddress2 the workAddress2 to set
	 */
	public void setWorkAddress2(String workAddress2) {
		this.workAddress2 = workAddress2;
	}
	/**
	 * @return the workAddress3
	 */
	public String getWorkAddress3() {
		return workAddress3;
	}
	/**
	 * @param workAddress3 the workAddress3 to set
	 */
	public void setWorkAddress3(String workAddress3) {
		this.workAddress3 = workAddress3;
	}
	/**
	 * @return the workZip
	 */
	public String getWorkZip() {
		return workZip;
	}
	/**
	 * @param workZip the workZip to set
	 */
	public void setWorkZip(String workZip) {
		this.workZip = workZip;
	}
	/**
	 * @return the contactTel
	 */
	public String getContactTel() {
		return contactTel;
	}
	/**
	 * @param contactTel the contactTel to set
	 */
	public void setContactTel(String contactTel) {
		this.contactTel = contactTel;
	}
	/**
	 * @return the contactEmail
	 */
	public String getContactEmail() {
		return contactEmail;
	}
	/**
	 * @param contactEmail the contactEmail to set
	 */
	public void setContactEmail(String contactEmail) {
		this.contactEmail = contactEmail;
	}
	/**
	 * @return the contactFax
	 */
	public String getContactFax() {
		return contactFax;
	}
	/**
	 * @param contactFax the contactFax to set
	 */
	public void setContactFax(String contactFax) {
		this.contactFax = contactFax;
	}
	/**
	 * @return the workTel
	 */
	public String getWorkTel() {
		return workTel;
	}
	/**
	 * @param workTel the workTel to set
	 */
	public void setWorkTel(String workTel) {
		this.workTel = workTel;
	}
	/**
	 * @return the workFax
	 */
	public String getWorkFax() {
		return workFax;
	}
	/**
	 * @param workFax the workFax to set
	 */
	public void setWorkFax(String workFax) {
		this.workFax = workFax;
	}
	/**
	 * @return the jobTimeComment
	 */
	public String getJobTimeComment() {
		return jobTimeComment;
	}
	/**
	 * @param jobTimeComment the jobTimeComment to set
	 */
	public void setJobTimeComment(String jobTimeComment) {
		this.jobTimeComment = jobTimeComment;
	}
	/**
	 * @return the jobChallengeDesc
	 */
	public String getJobChallengeDesc() {
		return jobChallengeDesc;
	}
	/**
	 * @param jobChallengeDesc the jobChallengeDesc to set
	 */
	public void setJobChallengeDesc(String jobChallengeDesc) {
		this.jobChallengeDesc = jobChallengeDesc;
	}
	/**
	 * @return the jobServerity
	 */
	public String getJobServerity() {
		return jobServerity;
	}
	/**
	 * @param jobServerity the jobServerity to set
	 */
	public void setJobServerity(String jobServerity) {
		this.jobServerity = jobServerity;
	}
	/**
	 * @return the promotionCategory
	 */
	public String getPromotionCategory() {
		return promotionCategory;
	}
	/**
	 * @param promotionCategory the promotionCategory to set
	 */
	public void setPromotionCategory(String promotionCategory) {
		this.promotionCategory = promotionCategory;
	}
	/**
	 * @return the salary5year
	 */
	public String getSalary5year() {
		return salary5year;
	}
	/**
	 * @param salary5year the salary5year to set
	 */
	public void setSalary5year(String salary5year) {
		this.salary5year = salary5year;
	}
	/**
	 * @return the salary5yearOther
	 */
	public String getSalary5yearOther() {
		return salary5yearOther;
	}
	/**
	 * @param salary5yearOther the salary5yearOther to set
	 */
	public void setSalary5yearOther(String salary5yearOther) {
		this.salary5yearOther = salary5yearOther;
	}
	/**
	 * @return the salary10year
	 */
	public String getSalary10year() {
		return salary10year;
	}
	/**
	 * @param salary10year the salary10year to set
	 */
	public void setSalary10year(String salary10year) {
		this.salary10year = salary10year;
	}
	/**
	 * @return the salary10yearOther
	 */
	public String getSalary10yearOther() {
		return salary10yearOther;
	}
	/**
	 * @param salary10yearOther the salary10yearOther to set
	 */
	public void setSalary10yearOther(String salary10yearOther) {
		this.salary10yearOther = salary10yearOther;
	}
	/**
	 * @return the salaryOther
	 */
	public String getSalaryOther() {
		return salaryOther;
	}
	/**
	 * @param salaryOther the salaryOther to set
	 */
	public void setSalaryOther(String salaryOther) {
		this.salaryOther = salaryOther;
	}
	/**
	 * @return the salaryMax
	 */
	public Double getSalaryMax() {
		return salaryMax;
	}
	/**
	 * @param salaryMax the salaryMax to set
	 */
	public void setSalaryMax(Double salaryMax) {
		this.salaryMax = salaryMax;
	}
	/**
	 * @return the salaryMin
	 */
	public Double getSalaryMin() {
		return salaryMin;
	}
	/**
	 * @param salaryMin the salaryMin to set
	 */
	public void setSalaryMin(Double salaryMin) {
		this.salaryMin = salaryMin;
	}
	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * @return the nightDuty
	 */
	public String getNightDuty() {
		return nightDuty;
	}
	/**
	 * @param nightDuty the nightDuty to set
	 */
	public void setNightDuty(String nightDuty) {
		this.nightDuty = nightDuty;
	}
	/**
	 * @return the nightDutyWm
	 */
	public String getNightDutyWm() {
		return nightDutyWm;
	}
	/**
	 * @param nightDutyWm the nightDutyWm to set
	 */
	public void setNightDutyWm(String nightDutyWm) {
		this.nightDutyWm = nightDutyWm;
	}
	/**
	 * @return the nightDutyTime
	 */
	public Integer getNightDutyTime() {
		return nightDutyTime;
	}
	/**
	 * @param nightDutyTime the nightDutyTime to set
	 */
	public void setNightDutyTime(Integer nightDutyTime) {
		this.nightDutyTime = nightDutyTime;
	}
	/**
	 * @return the nightDutyOther
	 */
	public String getNightDutyOther() {
		return nightDutyOther;
	}
	/**
	 * @param nightDutyOther the nightDutyOther to set
	 */
	public void setNightDutyOther(String nightDutyOther) {
		this.nightDutyOther = nightDutyOther;
	}
	/**
	 * @return the nightDutySalary
	 */
	public String getNightDutySalary() {
		return nightDutySalary;
	}
	/**
	 * @param nightDutySalary the nightDutySalary to set
	 */
	public void setNightDutySalary(String nightDutySalary) {
		this.nightDutySalary = nightDutySalary;
	}
	/**
	 * @return the nightDutySalaryYen
	 */
	public String getNightDutySalaryYen() {
		return nightDutySalaryYen;
	}
	/**
	 * @param nightDutySalaryYen the nightDutySalaryYen to set
	 */
	public void setNightDutySalaryYen(String nightDutySalaryYen) {
		this.nightDutySalaryYen = nightDutySalaryYen;
	}
	/**
	 * @return the nightDutySystem
	 */
	public String getNightDutySystem() {
		return nightDutySystem;
	}
	/**
	 * @param nightDutySystem the nightDutySystem to set
	 */
	public void setNightDutySystem(String nightDutySystem) {
		this.nightDutySystem = nightDutySystem;
	}
	/**
	 * @return the salaryBonus
	 */
	public String getSalaryBonus() {
		return salaryBonus;
	}
	/**
	 * @param salaryBonus the salaryBonus to set
	 */
	public void setSalaryBonus(String salaryBonus) {
		this.salaryBonus = salaryBonus;
	}
	/**
	 * @return the salaryCommission
	 */
	public String getSalaryCommission() {
		return salaryCommission;
	}
	/**
	 * @param salaryCommission the salaryCommission to set
	 */
	public void setSalaryCommission(String salaryCommission) {
		this.salaryCommission = salaryCommission;
	}
	/**
	 * @return the salaryRaise
	 */
	public String getSalaryRaise() {
		return salaryRaise;
	}
	/**
	 * @param salaryRaise the salaryRaise to set
	 */
	public void setSalaryRaise(String salaryRaise) {
		this.salaryRaise = salaryRaise;
	}
	/**
	 * @return the salaryAssessment
	 */
	public String getSalaryAssessment() {
		return salaryAssessment;
	}
	/**
	 * @param salaryAssessment the salaryAssessment to set
	 */
	public void setSalaryAssessment(String salaryAssessment) {
		this.salaryAssessment = salaryAssessment;
	}
	/**
	 * @return the salarySeverance
	 */
	public String getSalarySeverance() {
		return salarySeverance;
	}
	/**
	 * @param salarySeverance the salarySeverance to set
	 */
	public void setSalarySeverance(String salarySeverance) {
		this.salarySeverance = salarySeverance;
	}
	/**
	 * @return the trial
	 */
	public String getTrial() {
		return trial;
	}
	/**
	 * @param trial the trial to set
	 */
	public void setTrial(String trial) {
		this.trial = trial;
	}
	/**
	 * @return the trialMonth
	 */
	public Integer getTrialMonth() {
		return trialMonth;
	}
	/**
	 * @param trialMonth the trialMonth to set
	 */
	public void setTrialMonth(Integer trialMonth) {
		this.trialMonth = trialMonth;
	}
	/**
	 * @return the dorm
	 */
	public String getDorm() {
		return dorm;
	}
	/**
	 * @param dorm the dorm to set
	 */
	public void setDorm(String dorm) {
		this.dorm = dorm;
	}
	/**
	 * @return the dormFeePayment
	 */
	public String getDormFeePayment() {
		return dormFeePayment;
	}
	/**
	 * @param dormFeePayment the dormFeePayment to set
	 */
	public void setDormFeePayment(String dormFeePayment) {
		this.dormFeePayment = dormFeePayment;
	}
	/**
	 * @return the dormFeeRate
	 */
	public String getDormFeeRate() {
		return dormFeeRate;
	}
	/**
	 * @param dormFeeRate the dormFeeRate to set
	 */
	public void setDormFeeRate(String dormFeeRate) {
		this.dormFeeRate = dormFeeRate;
	}
	/**
	 * @return the dormFeeYen
	 */
	public String getDormFeeYen() {
		return dormFeeYen;
	}
	/**
	 * @param dormFeeYen the dormFeeYen to set
	 */
	public void setDormFeeYen(String dormFeeYen) {
		this.dormFeeYen = dormFeeYen;
	}
	/**
	 * @return the dormFeeOther
	 */
	public String getDormFeeOther() {
		return dormFeeOther;
	}
	/**
	 * @param dormFeeOther the dormFeeOther to set
	 */
	public void setDormFeeOther(String dormFeeOther) {
		this.dormFeeOther = dormFeeOther;
	}
	/**
	 * @return the holiday
	 */
	public String getHoliday() {
		return holiday;
	}
	/**
	 * @param holiday the holiday to set
	 */
	public void setHoliday(String holiday) {
		this.holiday = holiday;
	}
	/**
	 * @return the holidayDayHalf
	 */
	public String getHolidayDayHalf() {
		return holidayDayHalf;
	}
	/**
	 * @param holidayDayHalf the holidayDayHalf to set
	 */
	public void setHolidayDayHalf(String holidayDayHalf) {
		this.holidayDayHalf = holidayDayHalf;
	}
	/**
	 * @return the holidayOther
	 */
	public String getHolidayOther() {
		return holidayOther;
	}
	/**
	 * @param holidayOther the holidayOther to set
	 */
	public void setHolidayOther(String holidayOther) {
		this.holidayOther = holidayOther;
	}
	/**
	 * @return the holidayComment
	 */
	public String getHolidayComment() {
		return holidayComment;
	}
	/**
	 * @param holidayComment the holidayComment to set
	 */
	public void setHolidayComment(String holidayComment) {
		this.holidayComment = holidayComment;
	}
	/**
	 * @return the vacationYearend
	 */
	public String getVacationYearend() {
		return vacationYearend;
	}
	/**
	 * @param vacationYearend the vacationYearend to set
	 */
	public void setVacationYearend(String vacationYearend) {
		this.vacationYearend = vacationYearend;
	}
	/**
	 * @return the vacationSummer
	 */
	public String getVacationSummer() {
		return vacationSummer;
	}
	/**
	 * @param vacationSummer the vacationSummer to set
	 */
	public void setVacationSummer(String vacationSummer) {
		this.vacationSummer = vacationSummer;
	}
	/**
	 * @return the vacationSalaried
	 */
	public String getVacationSalaried() {
		return vacationSalaried;
	}
	/**
	 * @param vacationSalaried the vacationSalaried to set
	 */
	public void setVacationSalaried(String vacationSalaried) {
		this.vacationSalaried = vacationSalaried;
	}
	/**
	 * @return the vacationOther
	 */
	public String getVacationOther() {
		return vacationOther;
	}
	/**
	 * @param vacationOther the vacationOther to set
	 */
	public void setVacationOther(String vacationOther) {
		this.vacationOther = vacationOther;
	}
	/**
	 * @return the vacationYearendText
	 */
	public String getVacationYearendText() {
		return vacationYearendText;
	}
	/**
	 * @param vacationYearendText the vacationYearendText to set
	 */
	public void setVacationYearendText(String vacationYearendText) {
		this.vacationYearendText = vacationYearendText;
	}
	/**
	 * @return the vacationSummerText
	 */
	public String getVacationSummerText() {
		return vacationSummerText;
	}
	/**
	 * @param vacationSummerText the vacationSummerText to set
	 */
	public void setVacationSummerText(String vacationSummerText) {
		this.vacationSummerText = vacationSummerText;
	}
	/**
	 * @return the vacationSalariedText
	 */
	public String getVacationSalariedText() {
		return vacationSalariedText;
	}
	/**
	 * @param vacationSalariedText the vacationSalariedText to set
	 */
	public void setVacationSalariedText(String vacationSalariedText) {
		this.vacationSalariedText = vacationSalariedText;
	}
	/**
	 * @return the vacationComment
	 */
	public String getVacationComment() {
		return vacationComment;
	}
	/**
	 * @param vacationComment the vacationComment to set
	 */
	public void setVacationComment(String vacationComment) {
		this.vacationComment = vacationComment;
	}
	/**
	 * @return the research
	 */
	public String getResearch() {
		return research;
	}
	/**
	 * @param research the research to set
	 */
	public void setResearch(String research) {
		this.research = research;
	}
	/**
	 * @return the researchFree1
	 */
	public String getResearchFree1() {
		return researchFree1;
	}
	/**
	 * @param researchFree1 the researchFree1 to set
	 */
	public void setResearchFree1(String researchFree1) {
		this.researchFree1 = researchFree1;
	}
	/**
	 * @return the researchFree2
	 */
	public String getResearchFree2() {
		return researchFree2;
	}
	/**
	 * @param researchFree2 the researchFree2 to set
	 */
	public void setResearchFree2(String researchFree2) {
		this.researchFree2 = researchFree2;
	}
	/**
	 * @return the society
	 */
	public String getSociety() {
		return society;
	}
	/**
	 * @param society the society to set
	 */
	public void setSociety(String society) {
		this.society = society;
	}
	/**
	 * @return the societyDay
	 */
	public String getSocietyDay() {
		return societyDay;
	}
	/**
	 * @param societyDay the societyDay to set
	 */
	public void setSocietyDay(String societyDay) {
		this.societyDay = societyDay;
	}
	/**
	 * @return the societyTime
	 */
	public String getSocietyTime() {
		return societyTime;
	}
	/**
	 * @param societyTime the societyTime to set
	 */
	public void setSocietyTime(String societyTime) {
		this.societyTime = societyTime;
	}
	/**
	 * @return the societyOther
	 */
	public String getSocietyOther() {
		return societyOther;
	}
	/**
	 * @param societyOther the societyOther to set
	 */
	public void setSocietyOther(String societyOther) {
		this.societyOther = societyOther;
	}
	/**
	 * @return the societyPaid
	 */
	public String getSocietyPaid() {
		return societyPaid;
	}
	/**
	 * @param societyPaid the societyPaid to set
	 */
	public void setSocietyPaid(String societyPaid) {
		this.societyPaid = societyPaid;
	}
	/**
	 * @return the societyPaidYen
	 */
	public String getSocietyPaidYen() {
		return societyPaidYen;
	}
	/**
	 * @param societyPaidYen the societyPaidYen to set
	 */
	public void setSocietyPaidYen(String societyPaidYen) {
		this.societyPaidYen = societyPaidYen;
	}
	/**
	 * @return the societyPaidOther
	 */
	public String getSocietyPaidOther() {
		return societyPaidOther;
	}
	/**
	 * @param societyPaidOther the societyPaidOther to set
	 */
	public void setSocietyPaidOther(String societyPaidOther) {
		this.societyPaidOther = societyPaidOther;
	}
	/**
	 * @return the appAllowance
	 */
	public String getAppAllowance() {
		return appAllowance;
	}
	/**
	 * @param appAllowance the appAllowance to set
	 */
	public void setAppAllowance(String appAllowance) {
		this.appAllowance = appAllowance;
	}
	/**
	 * @return the appAllowanceFree
	 */
	public String getAppAllowanceFree() {
		return appAllowanceFree;
	}
	/**
	 * @param appAllowanceFree the appAllowanceFree to set
	 */
	public void setAppAllowanceFree(String appAllowanceFree) {
		this.appAllowanceFree = appAllowanceFree;
	}
	/**
	 * @return the appAllowanceYen
	 */
	public String getAppAllowanceYen() {
		return appAllowanceYen;
	}
	/**
	 * @param appAllowanceYen the appAllowanceYen to set
	 */
	public void setAppAllowanceYen(String appAllowanceYen) {
		this.appAllowanceYen = appAllowanceYen;
	}
	/**
	 * @return the policy
	 */
	public String getPolicy() {
		return policy;
	}
	/**
	 * @param policy the policy to set
	 */
	public void setPolicy(String policy) {
		this.policy = policy;
	}
	/**
	 * @return the portalComment
	 */
	public String getPortalComment() {
		return portalComment;
	}
	/**
	 * @param portalComment the portalComment to set
	 */
	public void setPortalComment(String portalComment) {
		this.portalComment = portalComment;
	}
	/**
	 * @return the pic1NameKana
	 */
	public String getPic1NameKana() {
		return pic1NameKana;
	}
	/**
	 * @param pic1NameKana the pic1NameKana to set
	 */
	public void setPic1NameKana(String pic1NameKana) {
		this.pic1NameKana = pic1NameKana;
	}
	/**
	 * @return the pic1Name
	 */
	public String getPic1Name() {
		return pic1Name;
	}
	/**
	 * @param pic1Name the pic1Name to set
	 */
	public void setPic1Name(String pic1Name) {
		this.pic1Name = pic1Name;
	}
	/**
	 * @return the pic1Position
	 */
	public String getPic1Position() {
		return pic1Position;
	}
	/**
	 * @param pic1Position the pic1Position to set
	 */
	public void setPic1Position(String pic1Position) {
		this.pic1Position = pic1Position;
	}
	/**
	 * @return the pic2NameKana
	 */
	public String getPic2NameKana() {
		return pic2NameKana;
	}
	/**
	 * @param pic2NameKana the pic2NameKana to set
	 */
	public void setPic2NameKana(String pic2NameKana) {
		this.pic2NameKana = pic2NameKana;
	}
	/**
	 * @return the pic2Name
	 */
	public String getPic2Name() {
		return pic2Name;
	}
	/**
	 * @param pic2Name the pic2Name to set
	 */
	public void setPic2Name(String pic2Name) {
		this.pic2Name = pic2Name;
	}
	/**
	 * @return the pic2Position
	 */
	public String getPic2Position() {
		return pic2Position;
	}
	/**
	 * @param pic2Position the pic2Position to set
	 */
	public void setPic2Position(String pic2Position) {
		this.pic2Position = pic2Position;
	}
	/**
	 * @return the pic3NameKana
	 */
	public String getPic3NameKana() {
		return pic3NameKana;
	}
	/**
	 * @param pic3NameKana the pic3NameKana to set
	 */
	public void setPic3NameKana(String pic3NameKana) {
		this.pic3NameKana = pic3NameKana;
	}
	/**
	 * @return the pic3Name
	 */
	public String getPic3Name() {
		return pic3Name;
	}
	/**
	 * @param pic3Name the pic3Name to set
	 */
	public void setPic3Name(String pic3Name) {
		this.pic3Name = pic3Name;
	}
	/**
	 * @return the pic3Position
	 */
	public String getPic3Position() {
		return pic3Position;
	}
	/**
	 * @param pic3Position the pic3Position to set
	 */
	public void setPic3Position(String pic3Position) {
		this.pic3Position = pic3Position;
	}
	/**
	 * @return the messageProvider
	 */
	public String getMessageProvider() {
		return messageProvider;
	}
	/**
	 * @param messageProvider the messageProvider to set
	 */
	public void setMessageProvider(String messageProvider) {
		this.messageProvider = messageProvider;
	}
	/**
	 * @return the messageText
	 */
	public String getMessageText() {
		return messageText;
	}
	/**
	 * @param messageText the messageText to set
	 */
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	/**
	 * @return the messageLinkstaff
	 */
	public String getMessageLinkstaff() {
		return messageLinkstaff;
	}
	/**
	 * @param messageLinkstaff the messageLinkstaff to set
	 */
	public void setMessageLinkstaff(String messageLinkstaff) {
		this.messageLinkstaff = messageLinkstaff;
	}
	/**
	 * @return the workStationCode1
	 */
	public String getWorkStationCode1() {
		return workStationCode1;
	}
	/**
	 * @param workStationCode1 the workStationCode1 to set
	 */
	public void setWorkStationCode1(String workStationCode1) {
		this.workStationCode1 = workStationCode1;
	}
	/**
	 * @return the workStationCode2
	 */
	public String getWorkStationCode2() {
		return workStationCode2;
	}
	/**
	 * @param workStationCode2 the workStationCode2 to set
	 */
	public void setWorkStationCode2(String workStationCode2) {
		this.workStationCode2 = workStationCode2;
	}
	/**
	 * @return the workStationCode3
	 */
	public String getWorkStationCode3() {
		return workStationCode3;
	}
	/**
	 * @param workStationCode3 the workStationCode3 to set
	 */
	public void setWorkStationCode3(String workStationCode3) {
		this.workStationCode3 = workStationCode3;
	}
	/**
	 * @return the workTransLine
	 */
	public String getWorkTransLine() {
		return workTransLine;
	}
	/**
	 * @param workTransLine the workTransLine to set
	 */
	public void setWorkTransLine(String workTransLine) {
		this.workTransLine = workTransLine;
	}
	/**
	 * @return the workTransStation
	 */
	public String getWorkTransStation() {
		return workTransStation;
	}
	/**
	 * @param workTransStation the workTransStation to set
	 */
	public void setWorkTransStation(String workTransStation) {
		this.workTransStation = workTransStation;
	}
	/**
	 * @return the workTransWalkingTime
	 */
	public Integer getWorkTransWalkingTime() {
		return workTransWalkingTime;
	}
	/**
	 * @param workTransWalkingTime the workTransWalkingTime to set
	 */
	public void setWorkTransWalkingTime(Integer workTransWalkingTime) {
		this.workTransWalkingTime = workTransWalkingTime;
	}
	/**
	 * @return the workTransWalkingComment
	 */
	public String getWorkTransWalkingComment() {
		return workTransWalkingComment;
	}
	/**
	 * @param workTransWalkingComment the workTransWalkingComment to set
	 */
	public void setWorkTransWalkingComment(String workTransWalkingComment) {
		this.workTransWalkingComment = workTransWalkingComment;
	}
	/**
	 * @return the workTransBusTime
	 */
	public Integer getWorkTransBusTime() {
		return workTransBusTime;
	}
	/**
	 * @param workTransBusTime the workTransBusTime to set
	 */
	public void setWorkTransBusTime(Integer workTransBusTime) {
		this.workTransBusTime = workTransBusTime;
	}
	/**
	 * @return the workTransBusComment
	 */
	public String getWorkTransBusComment() {
		return workTransBusComment;
	}
	/**
	 * @param workTransBusComment the workTransBusComment to set
	 */
	public void setWorkTransBusComment(String workTransBusComment) {
		this.workTransBusComment = workTransBusComment;
	}
	/**
	 * @return the searchKeyword
	 */
	public String getSearchKeyword() {
		return searchKeyword;
	}
	/**
	 * @param searchKeyword the searchKeyword to set
	 */
	public void setSearchKeyword(String searchKeyword) {
		this.searchKeyword = searchKeyword;
	}
	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * @return the updatedAt
	 */
	//@JsonDeserialize
	public Date getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	/**
	 * @return the deletedAt
	 */
	public Date getDeletedAt() {
		return deletedAt;
	}
	/**
	 * @param deletedAt the deletedAt to set
	 */
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	/**
	 * @return the isDeleted
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * @return the jobUrl
	 */
	public String getJobUrl() {
		return jobUrl;
	}
	/**
	 * @param jobUrl the jobUrl to set
	 */
	public void setJobUrl(String jobUrl) {
		this.jobUrl = jobUrl;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the subjectOther
	 */
	public String getSubjectOther() {
		return subjectOther;
	}
	/**
	 * @param subjectOther the subjectOther to set
	 */
	public void setSubjectOther(String subjectOther) {
		this.subjectOther = subjectOther;
	}
	/**
	 * @return the workContent
	 */
	public String getWorkContent() {
		return workContent;
	}
	/**
	 * @param workContent the workContent to set
	 */
	public void setWorkContent(String workContent) {
		this.workContent = workContent;
	}
}
