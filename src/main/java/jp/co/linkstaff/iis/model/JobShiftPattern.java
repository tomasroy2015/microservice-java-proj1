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
public class JobShiftPattern extends ResourceSupport{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	/**
	 * Primary Key
	 */
	private Long jobShiftPatternId;
	/**
	 * jobShiftPattern unique code
	 */
	@Column(nullable = false, unique = true)
	private String jobShiftPatternCode;
	/**
	 * shift type name
	 */
	private String jobShiftPatternName;
	/**
	 * short name of shift pattern
	 */
	private String amPm;
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
	
	/**
	 * empty constructor
	 */
	
	public JobShiftPattern() {
	}
	/**
	 * single instance's jobShiftPatternId
	 * @return jobShiftPatternId
	 */
	public Long getJobShiftPatternId() {
		return jobShiftPatternId;
	}
	/**
	 * jobShiftPatternId is a single instance
	 * @param jobShiftPatternId
	 */
	public void setJobShiftPatternId(Long jobShiftPatternId) {
		this.jobShiftPatternId = jobShiftPatternId;
	}
	/**
	 * single instance's jobShiftPatternCode
	 * @return jobShiftPatternCode
	 */
	public String getJobShiftPatternCode() {
		return jobShiftPatternCode;
	}
	/**
	 * jobShiftPatternCode is a single instance
	 * @param jobShiftPatternCode
	 */
	public void setJobShiftPatternCode(String jobShiftPatternCode) {
		this.jobShiftPatternCode = jobShiftPatternCode;
	}
	/**
	 * single instance's jobShiftPatternName
	 * @return jobShiftPatternName
	 */
	public String getJobShiftPatternName() {
		return jobShiftPatternName;
	}
	/**
	 * jobShiftPatternName is a single instance
	 * @param jobShiftPatternName
	 */
	public void setJobShiftPatternName(String jobShiftPatternName) {
		this.jobShiftPatternName = jobShiftPatternName;
	}
	/**
	 * single instance's amPm
	 * @return amPm
	 */
	public String getAmPm() {
		return amPm;
	}
	/**
	 * amPm is a single instance
	 * @param amPm
	 */
	public void setAmPm(String amPm) {
		this.amPm = amPm;
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
}
