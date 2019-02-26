package jp.co.linkstaff.iis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.hateoas.ResourceSupport;

@Entity
public class FavouriteJobs extends ResourceSupport{
	
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)	
	private Long favJobId; //Primary key: favourite job id.
	
	@Column(nullable = false)
	private Long doctorId; 
	
	@Column(nullable = false)
	private String jobCode;
	
	@Column(nullable = false)
	private String hospitalCode;
	
	private String hospitalName;
	
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdAt;
	
	private Date updatedAt;
	private Date deletedAt;
	
	/*~~~~~~~~~~~~~Getters, Setters~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	//Getter, Setters: favJobId	
	/**
	 * Getter: favJobId
	 * @return Long favJobId
	 */
	public Long getFavJobId() {
		return favJobId;
	}
	
	/**
	 * Setter: favJobId
	 * @param Long favJobId to set favJobId
	 */
	public void setFavJobId(Long favJobId) {
		this.favJobId = favJobId;
	}
	
	//Getter, Setters: favJobCode
	/**
	 * Getter: JobCode
	 * @return String jobCode
	 */
	public String getJobCode() {
		return jobCode;
	}
	
	/**
	 * Setter: jobCode
	 * @param String jobCode to set jobCode
	 */
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	
	//Getter, Setters: hospitalCode
	/**
	 * Getter: hospitalCode
	 * @return String hospitalCode
	 */
	public String getHospitalCode() {
		return hospitalCode;
	}
	
	/**
	 * Setter: hospitalCode
	 * @param String hospitalCode to set hospitalCode 
	 */
	public void setHospitalCode(String hospitalCode) {
		this.hospitalCode = hospitalCode;
	}
	
	//Getter, Setters: hospitalName
	/**
	 * Getter: hospitalName
	 * @return String hospitalName
	 */
	public String getHospitalName() {
		return hospitalName;
	}
	
	/**
	 * Setter: hospitalName
	 * @param String hopitalName the hopitalName to set
	 */
	public void setHospitalName(String hopitalName) {
		this.hospitalName = hopitalName;
	}
	
	//Getter, Setters: updateAt
	/**
	 * Getter: updateAt
	 * @return Date updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	
	/**
	 * Setter: updateAt
	 * @param Date updatedAt to set updatedAt 
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	//Getter, Setters: createdAt
	/**
	 * Getter: createdAt
	 * @return Date createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	
	/**
	 * Setter: createdAt
	 * @param Date createdAt to set createdAt
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	//Getter, Setters: deletedAt
	/**
	 * Getter: deleteAt
	 * @return Date deletedAt
	 */
	public Date getDeletedAt() {
		return deletedAt;
	}
	
	/**
	 * Setter: deleteAt
	 * @param Date deletedAt to set deletedAt
	 */
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	//Getter, Setters: doctorId
	/**
	 * Getter: doctorId
	 * @return Long doctorId
	 */
	public Long getDoctorId() {
		return doctorId;
	}
	
	/**
	 * Setter: doctorId
	 * @param Long doctorId to set doctorId 
	 */
	public void setDoctorId(Long doctorId) {
		this.doctorId = doctorId;
	}	
}
