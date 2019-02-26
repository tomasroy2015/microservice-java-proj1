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
public class Notice extends ResourceSupport{	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
	/**
	 * Primary Key
	 */
	private Long noticeId;
	/**
	 * notice title
	 */
	private String name;
	/**
	 * details of notice
	 */
	private String description;
	/**
	 * publication date
	 */
	private Date displayStartdate;
	/**
	 * stop publication
	 */
    private Date displayEnddate;
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
	 *  private or public.
	 *  if public then public(everyone can see)
	 *  if private then doctor can see
	 */
	@Column(nullable = false)
	private String type;
	/**
	 * In this system nothing is deleted permanently. 
	 * This flag is kept to marked a data deleted.
	 * Default value is false.
	 */
	private Boolean isDeleted = false;
	/**
	 * default value true that's mean show in home page 
	 */
	private Boolean isActive = true;
	/**
	 * empty Constructor 
	 */
	public Notice() {}
	
	// Getter and Setter
	
	/**
	 * single instance's noticeId
	 * @return noticeId
	 */
	public Long getNoticeId() {
		return noticeId;
	}
	/**
	 * noticeId is a single instance
	 * @param noticeId
	 */
	public void setNoticeId(Long noticeId) {
		this.noticeId = noticeId;
	}
	/**
	 * single instance's name
	 * @return name
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
	 * single instance's description
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	/**
	 * description is a single instance
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	/**
	 * single instance's displayStartdate
	 * @return displayStartdate
	 */
	public Date getDisplayStartdate() {
		return displayStartdate;
	}
	/**
	 * displayStartdate is a single instance
	 * @param displayStartdate
	 */
	public void setDisplayStartdate(Date displayStartdate) {
		this.displayStartdate = displayStartdate;
	}
	/**
	 * single instance's displayEnddate
	 * @return displayEnddate
	 */
	public Date getDisplayEnddate() {
		return displayEnddate;
	}
	/**
	 * displayEnddate is a single instance
	 * @param displayEnddate
	 */
	public void setDisplayEnddate(Date displayEnddate) {
		this.displayEnddate = displayEnddate;
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
	 * single instance's type
	 * @return type
	 */
	public String getType() {
		return type;
	}
	/**
	 * type is a single instance
	 * @param type
	 */
	public void setType(String type) {
		this.type = type;
	}
	/**
	 * single instance's isDeleted
	 * @return isDeleted
	 */
	public Boolean isDeleted() {
		return isDeleted;
	}
	/**
	 * isDeleted is a single instance
	 * @param isDeleted
	 */
	public void setDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
	/**
	 * single instance's isActive
	 * @return isActive
	 */
	public Boolean getIsActive() {
		return isActive;
	}
	/**
	 * isActive is a single instance
	 * @param isActive
	 */
	public void setIsActive(Boolean isActive) {
		this.isActive = isActive;
	}
}
