package jp.co.linkstaff.iis.model;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.hateoas.ResourceSupport;
@Entity
public class HospitalBed extends ResourceSupport{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	/**
	 * Primary Key
	 */
	private Long hospitalBedId;
	/**
	 * hospital bed unique code
	 */
	@Column(nullable = false, unique = true)
	private String hospitalBedCode;
	/**
	 * minimum bed Number
	 */
	private Integer minBed;
	/**
	 * maximum bed Number
	 */
	private Integer maxBed;
	/**
	 * In this system nothing is deleted permanently. 
	 * This flag is kept to marked a data deleted.
	 * Default value is false that means do not delete permanently.
	 */
	private Boolean isDeleted = false;
	 /**
     * entry date into database
     */
    @Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdAt;
    /**
     * modification date
     */
	private Date updatedAt;
	/**
	 * date for isDeleted = true
	 */
	private Date deletedAt;
	/**
	 * hospital Bed description
	 */
	private String hospitalBedDescription;
	/**
	 * Number of beds: general
	 * 病床数：一般  
	 */
	private Integer bedGeneral;
	/**
	 * Number of beds: rehabilitation period rehabilitation
	 * 病床数：回復期リハ
	 */
	private Integer bedRehabilitation;
	/**
	 * 病床数：療養
	 * Number of sick beds: medical treatment
	 */
	private Integer bedMedicalTreat;
	/**
	 * Number of beds: spirit
	 * 	病床数：精神
	 */
	private Integer bedPsychologist;
	/**
	 * Number of beds: Other
	 * 病床数：その他
	 */
	private Integer bedOther;
	/**
	 * 病床数合計
	 * Total Number of beds
	 */
	private Integer bedTotal;
	/**
	 * 病床数内訳
	 * Number of beds breakdown
	 */
	private Integer bedBreakdown;
	/**
	 * empty constructor
	 */
	public HospitalBed() {
	}
	/**
	 * single instance's hospitalBedId
	 * @return hospitalBedId
	 */
	public Long getHospitalBedId() {
		return hospitalBedId;
	}
	/**
	 * hospitalBedId is a single instance
	 * @param hospitalBedId
	 */
	public void setHospitalBedId(Long hospitalBedId) {
		this.hospitalBedId = hospitalBedId;
	}
	/**
	 * single instance's hospitalBedCode
	 * @return hospitalBedCode
	 */
	public String getHospitalBedCode() {
		return hospitalBedCode;
	}
	/**
	 * hospitalBedCode is a single instance
	 * @param hospitalBedCode
	 */
	public void setHospitalBedCode(String hospitalBedCode) {
		this.hospitalBedCode = hospitalBedCode;
	}
	/**
	 * single instance's minBedInteger
	 * @return minBedInteger
	 */
	public Integer getMinBed() {
		return minBed;
	}
	/**
	 * minBed is a single instance
	 * @param minBed
	 */
	public void setMinBed(Integer minBed) {
		this.minBed = minBed;
	}
	/**
	 * single instance's maxBed
	 * @return maxBed
	 */
	public Integer getMaxBed() {
		return maxBed;
	}
	/**
	 * maxBed is a single instance
	 * @param maxBed
	 */
	public void setMaxBedInteger(Integer maxBed) {
		this.maxBed = maxBed;
	}
	/**
	 * single instance's isDeleted
	 * @return isDeleted
	 */
	public Boolean getIsDeleted() {
		return isDeleted;
	}
	/**
	 * isDeleted is a single instance
	 * @param isDeleted
	 */
	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * single instance's createdAt
	 * @return createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * createdAt is a single instance
	 * @param createdAt
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	/**
	 * single instance's updatedAt
	 * @return updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * updatedAt is a single instance
	 * @param updatedAt
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	/**
	 * single instance's deletedAt
	 * @return deletedAt
	 */
	public Date getDeletedAt() {
		return deletedAt;
	}
	/**
	 * deletedAt is a single instance
	 * @param deletedAt
	 */
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	/**
	 * single instance's hospitalBedDescription
	 * @return hospitalBedDescription
	 */
	public String getHospitalBedDescription() {
		return hospitalBedDescription;
	}
	/**
	 * hospitalBedDescription is a single instance
	 * @param hospitalBedDescription
	 */
	public void setHospitalBedDescription(String hospitalBedDescription) {
		this.hospitalBedDescription = hospitalBedDescription;
	}
	/**
	 * single instance's bedGeneral
	 * @return bedGeneral
	 */
	public Integer getBedGeneral() {
		return bedGeneral;
	}
	/**
	 * bedGeneral is a single instance
	 * @param bedGeneral
	 */
	public void setBedGeneral(Integer bedGeneral) {
		this.bedGeneral = bedGeneral;
	}
	/**
	 * single instance's bedRehabilitation
	 * @return bedRehabilitation
	 */
	public Integer getBedRehabilitation() {
		return bedRehabilitation;
	}
	/**
	 * bedRehabilitation is a single instance
	 * @param bedRehabilitation
	 */
	public void setBedRehabilitation(Integer bedRehabilitation) {
		this.bedRehabilitation = bedRehabilitation;
	}
	/**
	 * single instance's bedMedicalTreat
	 * @return bedMedicalTreat
	 */
	public Integer getBedMedicalTreat() {
		return bedMedicalTreat;
	}
	/**
	 * bedMedicalTreat is a single instance
	 * @param bedMedicalTreat
	 */
	public void setBedMedicalTreat(Integer bedMedicalTreat) {
		this.bedMedicalTreat = bedMedicalTreat;
	}
	/**
	 * single instance's bedPsychologist
	 * @return bedPsychologist
	 */
	public Integer getBedPsychologist() {
		return bedPsychologist;
	}
	/**
	 * bedPsychologist is a single instance
	 * @param bedPsychologist
	 */
	public void setBedPsychologist(Integer bedPsychologist) {
		this.bedPsychologist = bedPsychologist;
	}
	/**
	 * single instance's bedOther
	 * @return bedOther
	 */
	public Integer getBedOther() {
		return bedOther;
	}
	/**
	 * bedOther is a single instance
	 * @param bedOther
	 */
	public void setBedOther(Integer bedOther) {
		this.bedOther = bedOther;
	}
	/**
	 * single instance's bedTotal
	 * @return bedTotal
	 */
	public Integer getBedTotal() {
		return bedTotal;
	}
	/**
	 * bedTotal is a single instance
	 * @param bedTotal
	 */
	public void setBedTotal(Integer bedTotal) {
		this.bedTotal = bedTotal;
	}
	/**
	 * single instance's bedBreakdown
	 * @return bedBreakdown
	 */
	public Integer getBedBreakdown() {
		return bedBreakdown;
	}
	/**
	 * bedBreakdown is a single instance
	 * @param bedBreakdown
	 */
	public void setBedBreakdown(Integer bedBreakdown) {
		this.bedBreakdown = bedBreakdown;
	} 
}
