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
 * 
 * @author .....
 *
 */
@Entity
public class Area extends ResourceSupport{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	/**
	 * Primary Key
	 */
	private Long areaId;	
	@Column(nullable = false, unique = true)
	/**
	 * areaCode is unique
	 */
    private String areaCode;
	/**
	 * area name 
	 */
    private String name;
	/**
	 * In this system nothing is deleted permanently. 
	 * This flag is kept to marked a data deleted.
	 * Default value is false that means do not delete permanently.
	 */
	private Boolean isDeleted = false;
	/**
	 * imported date(data imported by excel or csv)
	 */
	private Date importedAt;	
	@Column(nullable = false, updatable = false)
	@CreationTimestamp
	 /**
     * entry date into database
     */
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
	public Area() {}
	/**
	 * single instance's AreaId
	 * @return areaId
	 */
	public Long getAreaId() {
		return areaId;
	}
	/**
	 * areaId is a single instance
	 * @param areaId
	 */
	public void setAreaId(Long areaId) {
		this.areaId = areaId;
	}
	/**
	 * single instance's AreaCode
	 * @return areaCode
	 */
	public String getAreaCode() {
		return areaCode;
	}
	/**
	 * areaCode is a single instance
	 * @param areaCode
	 */
	public void setAreaCode(String areaCode) {
		this.areaCode = areaCode;
	}
	/**
	 * single instance's ImportedAt
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
	 * single instance's CreatedAt
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
	 * single instance's UpdatedAt
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
	 * single instance's DeletedAt
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
	 * single instance's hospitalBedId
	 * @return hospitalBedId
	 */
	public String getName() {
		return name;
	}
	/**
	 * name is a single instance
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * single instance's hospitalBedId
	 * @return hospitalBedId
	 */
	 public Boolean getIsDeleted() {
		return isDeleted;
	}
	/**
	 * single instance's isDeleted
	 * @return isDeleted
	*/
	 public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
