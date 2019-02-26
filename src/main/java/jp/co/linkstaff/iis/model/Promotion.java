package jp.co.linkstaff.iis.model;

import java.util.Date;
import javax.persistence.Id;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class Promotion {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
    private Long promotionId;
	@Column(nullable = false, unique = true)
	private String promotionName;
	private String caregoryTitle;
	private String urlTitle;
	private Integer orderFulltime;
	private Integer orderParttime;
	private Integer orderSpot;
	private Integer orderMedicheck;
	private Date importedAt;
	@Column(nullable = false, updatable = false)
   	@CreationTimestamp
	private Date createdAt;
	private Date updatedAt;
	private Date deletedAt;
	
	public Promotion() {}
	
	public Long getPromotionId() {
		return promotionId;
	}
	public void setPromotionId(Long promotionId) {
		this.promotionId = promotionId;
	}

	public String getPromotionName() {
		return promotionName;
	}

	public void setPromotionName(String promotionName) {
		this.promotionName = promotionName;
	}

	public String getCaregoryTitle() {
		return caregoryTitle;
	}

	public void setCaregoryTitle(String caregoryTitle) {
		this.caregoryTitle = caregoryTitle;
	}

	public String getUrlTitle() {
		return urlTitle;
	}

	public void setUrlTitle(String urlTitle) {
		this.urlTitle = urlTitle;
	}

	public Integer getOrderFulltime() {
		return orderFulltime;
	}

	public void setOrderFulltime(Integer orderFulltime) {
		this.orderFulltime = orderFulltime;
	}

	public Integer getOrderParttime() {
		return orderParttime;
	}

	public void setOrderParttime(Integer orderParttime) {
		this.orderParttime = orderParttime;
	}

	public Integer getOrderSpot() {
		return orderSpot;
	}

	public void setOrderSpot(Integer orderSpot) {
		this.orderSpot = orderSpot;
	}

	public Integer getOrderMedicheck() {
		return orderMedicheck;
	}

	public void setOrderMedicheck(Integer orderMedicheck) {
		this.orderMedicheck = orderMedicheck;
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
	
}
