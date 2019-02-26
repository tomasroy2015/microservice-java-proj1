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
public class HospitalEmergency extends ResourceSupport{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	/**
	 * Primary Key
	 */
	private Long hospitalEmergencyId;
	/**
	 * hospital Emergency unique code
	 */
	@Column(nullable = false, unique = true)
	private String hospitalEmergencyCode; 
	/**
	 * hospital Emergency name
	 */
	private String hospitalEmergencyName;
	/**
	 * hospital Emergency description
	 */
	private String hospitalEmergencyDescription;
	/**
	 * hospital Emergency Comment
	 */
	private String hospitalEmergencyComment;
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
	 * empty constructor
	 */
	public HospitalEmergency() {
	}
	/**
	 * single instance's hospitalEmergencyId
	 * @return hospitalEmergencyId
	 */
	public Long getHospitalEmergencyId() {
		return hospitalEmergencyId;
	}
	/**
	 * hospitalEmergencyId is a single instance
	 * @param hospitalEmergencyId
	 */
	public void setHospitalEmergencyId(Long hospitalEmergencyId) {
		this.hospitalEmergencyId = hospitalEmergencyId;
	}
	/**
	 * single instance's hospitalEmergencyCode
	 * @return hospitalEmergencyCode
	 */
	public String getHospitalEmergencyCode() {
		return hospitalEmergencyCode;
	}
	/**
	 * hospitalEmergencyCode is a single instance
	 * @param hospitalEmergencyCode
	 */
	public void setHospitalEmergencyCode(String hospitalEmergencyCode) {
		this.hospitalEmergencyCode = hospitalEmergencyCode;
	}
	/**
	 * single instance's hospitalEmergencyName
	 * @return hospitalEmergencyName
	 */
	public String getHospitalEmergencyName() {
		return hospitalEmergencyName;
	}
	/**
	 * hospitalEmergencyName is a single instance
	 * @param hospitalEmergencyName
	 */
	public void setHospitalEmergencyName(String hospitalEmergencyName) {
		this.hospitalEmergencyName = hospitalEmergencyName;
	}
	/**
	 * single instance's hospitalEmergencyDescription
	 * @return hospitalEmergencyDescription
	 */
	public String getHospitalEmergencyDescription() {
		return hospitalEmergencyDescription;
	}
	/**
	 * hospitalEmergencyDescription is a single instance
	 * @param hospitalEmergencyDescription
	 */
	public void setHospitalEmergencyDescription(String hospitalEmergencyDescription) {
		this.hospitalEmergencyDescription = hospitalEmergencyDescription;
	}
	/**
	 * single instance's hospitalEmergencyComment
	 * @return hospitalEmergencyComment
	 */
	public String getHospitalEmergencyComment() {
		return hospitalEmergencyComment;
	}
	/**
	 *  hospitalEmergencyComment is a single instance
	 * @param hospitalEmergencyComment
	 */
	public void setHospitalEmergencyComment(String hospitalEmergencyComment) {
		this.hospitalEmergencyComment = hospitalEmergencyComment;
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
