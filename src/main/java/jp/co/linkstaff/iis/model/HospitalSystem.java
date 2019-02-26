package jp.co.linkstaff.iis.model;

import javax.persistence.Id;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.hateoas.ResourceSupport;
/**
 * 
 * @author .....
 *
 */
@Entity
public class HospitalSystem extends ResourceSupport{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	/**
	 * Primary Key
	 */
	private Long hospitalSystemId;
	/**
	 * hospital system unique code
	 */
	@Column(nullable = false, unique = true)
	private String hospitalSystemCode;
	/**
	 * hospital system name
	 */
	private String hospitalSystemName;
	/**
	 * if there is any other hospital name
	 */
	private String hospitalSystemOtherName;
	/**
	 * hospital system description
	 */
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
	private String hospitalSystemDescription;
	/**
	 * In this system nothing is deleted permanently. 
	 * This flag is kept to marked a data deleted.
	 * Default value is false that means do not delete permanently.
	 */
	private Boolean isDeleted = false;
	/**
	 * empty constructor
	 */
	public HospitalSystem() {
	}
	/**
	 * single instance's hospitalSystemId
	 * @return hospitalSystemId
	 */
	public Long getHospitalSystemId() {
		return hospitalSystemId;
	}
	/**
	 * hospitalSystemId is a single instance
	 * @param hospitalSystemId
	 */
	public void setHospitalSystemId(Long hospitalSystemId) {
		this.hospitalSystemId = hospitalSystemId;
	}
	/**
	 * single instance's code
	 * @return hospitalSystemCode
	 */
	public String getHospitalSystemCode() {
		return hospitalSystemCode;
	}
	/**
	 * hospitalSystemCode is single instance
	 * @param hospitalSystemCode
	 */
	public void setHospitalSystemCode(String hospitalSystemCode) {
		this.hospitalSystemCode = hospitalSystemCode;
	}
	/**
	 * single instance's name
	 * @return hospitalSystemName
	 */
	public String getHospitalSystemName() {
		return hospitalSystemName;
	}
	/**
	 * hospitalSystemName
	 * @param hospitalSystemName
	 */
	public void setHospitalSystemName(String hospitalSystemName) {
		this.hospitalSystemName = hospitalSystemName;
	}
	/**
	 * 
	 * @return hospitalSystemOtherName
	 */
	public String getHospitalSystemOtherName() {
		return hospitalSystemOtherName;
	}
	/**
	 * hospitalSystemOtherName is a single instance
	 * @param hospitalSystemOtherName
	 */
	public void setHospitalSystemOtherName(String hospitalSystemOtherName) {
		this.hospitalSystemOtherName = hospitalSystemOtherName;
	}
	/**
	 * 
	 * @return hospitalSystemDescription
	 */
	public String getHospitalSystemOtherDescription() {
		return hospitalSystemDescription;
	}
	/**
	 * hospitalSystemOtherDescription is a single instance
	 * @param hospitalSystemOtherDescription
	 */
	public void setHospitalSystemOtherDescription(String hospitalSystemOtherDescription) {
		this.hospitalSystemDescription = hospitalSystemOtherDescription;
	}
	/**
	 * 
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
}
