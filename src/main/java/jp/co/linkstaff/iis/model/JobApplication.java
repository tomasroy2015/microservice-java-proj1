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
public class JobApplication extends ResourceSupport {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long jobApplicationId;
	private String jobCode;
	private String jobHospitalName;
	private String jobHospitalAddress;
	private String jobEmail;
	private String jobUrl;
	private String name;
	private String nameKana;
	private String sex;
	private String zipCode;
	private String address1;
	private String address2;
	private String email;
	private String tel;
	private String details;
	
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdAt;	
	public Long getJobApplicationId() {
		return jobApplicationId;
	}
	public void setJobApplicationId(Long jobApplicationId) {
		this.jobApplicationId = jobApplicationId;
	}
	public String getJobCode() {
		return jobCode;
	}
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	public String getJobHospitalName() {
		return jobHospitalName;
	}
	public void setJobHospitalName(String jobHospitalName) {
		this.jobHospitalName = jobHospitalName;
	}
	public String getJobHospitalAddress() {
		return jobHospitalAddress;
	}
	public void setJobHospitalAddress(String jobHospitalAddress) {
		this.jobHospitalAddress = jobHospitalAddress;
	}
	public String getJobEmail() {
		return jobEmail;
	}
	public void setJobEmail(String jobEmail) {
		this.jobEmail = jobEmail;
	}
	public String getJobUrl() {
		return jobUrl;
	}
	public void setJobUrl(String jobUrl) {
		this.jobUrl = jobUrl;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNameKana() {
		return nameKana;
	}
	public void setNameKana(String nameKana) {
		this.nameKana = nameKana;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public String getZipCode() {
		return zipCode;
	}
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress1() {
		return address1;
	}
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	public String getAddress2() {
		return address2;
	}
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}
	public String getDetails() {
		return details;
	}
	public void setDetails(String details) {
		this.details = details;
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
	public Date getDeletedAt() {
		return deletedAt;
	}
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	private Date updatedAt;
	private Date deletedAt;
	
}
