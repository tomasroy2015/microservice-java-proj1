package jp.co.linkstaff.iis.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.CreationTimestamp;
/**
 * @author tomas
 *contents of work for job
 */
@Entity
public class WorkContent {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
    private Long workcontentId;
	private String contentName;
	@Column(nullable = false, unique = true)
	private String code;
	
	@ColumnDefault("true")
	private Boolean visibleToFulltimeJob;
	@ColumnDefault("true")
	private Boolean visibleToParttimeJob;
	@ColumnDefault("true")
	private Boolean visibleToSpotJob;
	@ColumnDefault("true")
	private Boolean visibleToMedicheckJob; 

	private Date importedAt;
	@Column(nullable = false, updatable = false)
   	@CreationTimestamp
	private Date createdAt;
	private Date updatedAt;
	private Date deletedAt;
	
	public WorkContent() {}
	
	public Long getWorkcontentId() {
		return workcontentId;
	}
	public void setWorkcontentId(Long workcontentId) {
		this.workcontentId = workcontentId;
	}

	public String getContentName() {
		return contentName;
	}

	public void setContentName(String contentName) {
		this.contentName = contentName;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public Date getImportedAt() {
		return importedAt;
	}

	public void setImportedAt(Date importedAt) {
		this.importedAt = importedAt;
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

	/**
	 * @return the visibleToFulltimeJob
	 */
	public Boolean getVisibleToFulltimeJob() {
		return visibleToFulltimeJob;
	}

	/**
	 * @param visibleToFulltimeJob the visibleToFulltimeJob to set
	 */
	public void setVisibleToFulltimeJob(Boolean visibleToFulltimeJob) {
		this.visibleToFulltimeJob = visibleToFulltimeJob;
	}

	/**
	 * @return the visibleToParttimeJob
	 */
	public Boolean getVisibleToParttimeJob() {
		return visibleToParttimeJob;
	}

	/**
	 * @param visibleToParttimeJob the visibleToParttimeJob to set
	 */
	public void setVisibleToParttimeJob(Boolean visibleToParttimeJob) {
		this.visibleToParttimeJob = visibleToParttimeJob;
	}

	/**
	 * @return the visibleToSpotJob
	 */
	public Boolean getVisibleToSpotJob() {
		return visibleToSpotJob;
	}

	/**
	 * @param visibleToSpotJob the visibleToSpotJob to set
	 */
	public void setVisibleToSpotJob(Boolean visibleToSpotJob) {
		this.visibleToSpotJob = visibleToSpotJob;
	}

	/**
	 * @return the visibleToMedicheckJob
	 */
	public Boolean getVisibleToMedicheckJob() {
		return visibleToMedicheckJob;
	}

	/**
	 * @param visibleToMedicheckJob the visibleToMedicheckJob to set
	 */
	public void setVisibleToMedicheckJob(Boolean visibleToMedicheckJob) {
		this.visibleToMedicheckJob = visibleToMedicheckJob;
	}
	

}
