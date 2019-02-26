package jp.co.linkstaff.iis.model;

import java.util.Date;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
@Entity
public class Prefecture {
	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
	private Long prefectureId;
	@ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "area_id")	
    private Area area;
	@Column(nullable = false, unique = true)
    private String prefectureCode;
	public String getPrefectureCode() {
		return prefectureCode;
	}

	public void setPrefectureCode(String prefectureCode) {
		this.prefectureCode = prefectureCode;
	}
	@Column(nullable = false, updatable = false)
   	@CreationTimestamp
    private Date createdAt;
    private Date updatedAt;
    private Date importedAt;
    private String name;
	private Date deletedAt;
	private Boolean isDeleted = false;
	public Boolean getIsDeleted() {
		return isDeleted;
	}

	public void setIsDeleted(Boolean isDeleted) {
		this.isDeleted = isDeleted;
	}

	public Prefecture() {

	}
	
	public Long getPrefectureId() {
		return prefectureId;
	}
	public void setPrefectureId(Long prefectureId) {
		this.prefectureId = prefectureId;
	}
	
//  @ManyToOne(fetch = FetchType.EAGER,cascade = {
//                    CascadeType.MERGE,
//                    CascadeType.REFRESH
//                })
	
	public Area getArea() {
		return area;
	}
	
	public void setArea(Area area) {
		this.area = area;
	}	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	public Date getImportedAt() {
		return importedAt;
	}

	public void setImportedAt(Date importedAt) {
		this.importedAt = importedAt;
	}

	public Date getDeletedAt() {
		return deletedAt;
	}

	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((area == null) ? 0 : area.hashCode());
		result = prime * result + ((createdAt == null) ? 0 : createdAt.hashCode());
		result = prime * result + ((deletedAt == null) ? 0 : deletedAt.hashCode());
		result = prime * result + ((importedAt == null) ? 0 : importedAt.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + ((prefectureCode == null) ? 0 : prefectureCode.hashCode());
		result = prime * result + ((prefectureId == null) ? 0 : prefectureId.hashCode());
		result = prime * result + ((updatedAt == null) ? 0 : updatedAt.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Prefecture other = (Prefecture) obj;
		if (area == null) {
			if (other.area != null)
				return false;
		} else if (!area.equals(other.area))
			return false;
		if (createdAt == null) {
			if (other.createdAt != null)
				return false;
		} else if (!createdAt.equals(other.createdAt))
			return false;
		if (deletedAt == null) {
			if (other.deletedAt != null)
				return false;
		} else if (!deletedAt.equals(other.deletedAt))
			return false;
		if (importedAt == null) {
			if (other.importedAt != null)
				return false;
		} else if (!importedAt.equals(other.importedAt))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (prefectureCode == null) {
			if (other.prefectureCode != null)
				return false;
		} else if (!prefectureCode.equals(other.prefectureCode))
			return false;
		if (prefectureId == null) {
			if (other.prefectureId != null)
				return false;
		} else if (!prefectureId.equals(other.prefectureId))
			return false;
		if (updatedAt == null) {
			if (other.updatedAt != null)
				return false;
		} else if (!updatedAt.equals(other.updatedAt))
			return false;
		return true;
	}


	
}