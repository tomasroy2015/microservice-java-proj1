package jp.co.linkstaff.iis.model;


import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;
import org.springframework.hateoas.ResourceSupport;
/**
 * 
 * @author roy
 *
 */ 
@Entity
public class Inquiry extends ResourceSupport {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	private Long inquiryId; //Primary Key
	
	private String name; //name of person who Inquiries
	private String nameKana; //name of person in Japanese who inquiries 
	private String inquiryType;
	private String companyName;
	
	@Column(nullable = false)
	private String jobCode;
	
	private String email;
	private String tel;
	private String details;
	
	/**
	 * In this system nothing is deleted permanently. 
	 * This flag is kept to marked a data deleted.
	 * Default value is false.
	 */
	private boolean isDeleted = false;
	
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	private Date createdAt;
	
	private Date updatedAt;
	private Date deletedAt;
	
	public Inquiry() {}
	
	/*~~~~~~~~~~~~~~~~~Getter:Setter~~~~~~~~~~~~~~~*/
	//Getter, Setter: id
	/**
	 * Getter: single isntance's InquiryId;
	 * @return Long Inquiry.inquiryId
	 */
	public Long getInquiryId() {
		return inquiryId;
	}
	
	public void setNameKana(String nameKana) {
		this.nameKana = nameKana;
	}

	/**
	 * Setter: single instance's inquiryId
	 * @param Long inquiryId
	 */
	public void setInquiryId(Long inquiryId) {
		this.inquiryId = inquiryId;
	}
	
	//Getter, Setter: name
	/**
	 * getter: single instance's 'name'
	 * @return name
	 */
	public String getName() {
		return name;
	}
	/**
	 * Setter: 'name' of a single instance.
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	//Getter, Setter: inquiryType
	/**
	 * getter: single instance's inquiryType
	 * @return inquiryType
	 */
	public String getInquiryType() {
		return inquiryType;
	}
	/**
	 * Setter: 'inquiryType' of a single instance.
	 * @param inquiryType
	 */
	public void setInquiryType(String inquiryType) {
		this.inquiryType = inquiryType;
	}
	
	//Getter, Setter: CompanyName
	/**
	 * Getter: single instance's 'companyName'
	 * @return comapanyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * Setter: 'companyName' of a single instance.
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	//Getter, Setter: email
	/**
	 * Getter: single instance's 'email'.
	 * @return email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * Setter: 'email' of a single instance.
	 * @param email
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	
	//Getter, Setter: Telephone
	/**
	 * Getter: single instance's 'tel'
	 * @return tel
	 */
	public String getTel() {
		return tel;
	}
	/**
	 * Setter: 'tel' of a single instance.
	 * @param tel
	 */
	public void setTel(String tel) {
		this.tel = tel;
	}
	
	//Getter, Setter: Details
	/**
	 * Getter: single instance's 'details'
	 * @return details
	 */
	public String getDetails() {
		return details;
	}
	/**
	 * Setter: 'details' of a single instance.
	 * @param details
	 */
	public void setDetails(String details) {
		this.details = details;
	}
	//Getter, Setter: UpdateAt Date
	/**
	 * Getter: single instance's 'updatedAt'
	 * @return updateAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * Setter: 'updatedAt' of a single instance.
	 * @param updatedAt
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	//Getter, Setter: CreatedAt Date
	/**
	 * Getter: single instance's 'createdAt'
	 * @return
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * Setter: 'createdAt' of a single instance.
	 * @param createdAt
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	//Getter, Setter: DeletedAt Date
	/**
	 * Getter: single instance's 'deleteAt'
	 * @return
	 */
	public Date getDeletedAt() {
		return deletedAt;
	}
	/**
	 * Setter: 'deleteAt' of a single instance.
	 * @param deletedAt
	 */
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	//Getter, Setter: nameKana
	/**
	 * Getter: single instance's 'nameKana'
	 * @return the nameKana
	 */
	public String getNameKana() {
		return nameKana;
	}
	/**
	 * Setter: single instance's 'nameKana'
	 * @param String nameKana
	 */
	public void setNamKana(String nameKana) {
		this.nameKana = nameKana;
	}
	
	//Getter, Setter: jobCode
	/**
	 * Getter: single instance's jobCode
	 * @return String jobCode
	 */
	public String getJobCode() {
		return jobCode;
	}
	/**
	 * @param String jobCode
	 */
	public void setJobCode(String jobCode) {
		this.jobCode = jobCode;
	}
	

	//Getter, Setter: isDelete
	/**
	 * Get boolean value of isDelete
	 * @return the isDelete
	 */
	public boolean isDeleted() {
		return isDeleted;
	}

	/**
	 * @param isDelete the isDelete to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}	
}
