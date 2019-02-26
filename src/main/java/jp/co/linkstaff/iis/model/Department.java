package jp.co.linkstaff.iis.model;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.hateoas.ResourceSupport;
/**
 * @author tomas
 * department for subject/special field
 *
 */
@Entity
public class Department extends ResourceSupport{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	/**
	 * Primary Key
	 */
    private Long departmentId;
	/**
	 * department name
	 */
    private String departmentName;
    /**
	 * departmentCode is unique
	 */
    @Column(nullable = false, unique = true)
    private String departmentCode;
    /**
     * imported date (such as excel or csv)
     */
	private Date importedAt;
	/**
     * entry date into database
     */
	@Column(nullable = false, updatable = false)
   	@CreationTimestamp
	private Date createdAt;
	/**
	 * updated date
	 */
	private Date updatedAt;
	/**
	 * date for isDeleted = true
	 * data is not deleted permanently
	 */
	private Date deletedAt;
	/**
	 * In this system nothing is deleted permanently. 
	 * This flag is kept to marked a data deleted.
	 * Default value is false that means do not delete permanently.
	 */
	private Boolean isDeleted = false;
	/**
	 * empty constructor
	 */
	public Department() {}
	/**
	 * single instance's departmentId
	 * @return departmentId
	 */
	public Long getDepartmentId() {
		return departmentId;
	}
	/**
	 * departmentId is a single instance
	 * @param departmentId
	 */
	public void setDepartmentId(Long departmentId) {
		this.departmentId = departmentId;
	}
	/**
	 * single instance's departmentName
	 * @return departmentName
	 */
	public String getDepartmentName() {
		return departmentName;
	}
	/**
	 * departmentName is a single instance
	 * @param departmentName
	 */
	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}
	/**
	 * single instance's departmentCode
	 * @return departmentCode
	 */
	public String getDepartmentCode() {
		return departmentCode;
	}
	/**
	 * departmentCode is a single instance
	 * @param departmentCode
	 */
	public void setDepartmentCode(String departmentCode) {
		this.departmentCode = departmentCode;
	}
	/**
	 * single instance's importedAt
	 * @return importedAt
	 */
	public Date getImportedAt() {
		return importedAt;
	}
	/**
	 * importedAt is a single instance
	 * @param importedAt
	 */
	public void setImportedAt(Date importedAt) {
		this.importedAt = importedAt;
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
	 * single instance's DepartmentId
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
}
