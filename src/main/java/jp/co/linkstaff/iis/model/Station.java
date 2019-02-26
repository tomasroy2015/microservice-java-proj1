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
 * @author khaliddhali (ls-215)
 *
 */
@Entity
public class Station extends ResourceSupport{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(columnDefinition = "serial")
    private Long stationId; //Primary Key
	
	private Integer lineCode;
	private String lineName;
	private String lineNameKana;
	private String companyName;
	private String companyNameKana;
	
	@Column(nullable = false, unique = true)
	private String stationCode;
	
	@Column(nullable = false)
	private String stationName;
	
	private String stationNameKana;
	private String prefCode;
	private String address;
	private String zip;
	private Integer number;
	private Date importedAt;
	private String latitude;
	private String longitude;
	
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
	
	public Station() {}
	
	/*~~~~~~~~~~~~~~~~~~Getters & Setters~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	//Getter, Setter: latitude
	/**
	 * Get single instance of latitude
	 * @return String latitude
	 */
	public String getLatitude() {
		return latitude;
	}
	/**
	 * Set single instance of latitude
	 * @param latitude
	 */
	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}
	
	//Getter, Setter: longitude
	/**
	 * Get single instance of longitude
	 * @return String longitude
	 */
	public String getLongitude() {
		return longitude;
	}
	/**
	 * Set single instance of longitude
	 * @param longitude
	 */
	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
	//Getter, Setter: id
	/**
	 * Get single instance of id
	 * @return Long id
	 */
	public Long getStationId() {
		return stationId;
	}
	/**
	 * Set single intance's 'id'
	 * @param id
	 */
	public void setId(Long statoionId) {
		this.stationId = statoionId;
	}
	
	//Getter, Setter: lineCode
	/**
	 * Get single instance of LineCode
	 * @return Integer lineCode
	 */
	public Integer getLinCode() {
		return lineCode;
	}
	/**
	 * set single instance's 'lineCode'
	 * @param lineCode
	 */
	public void setLineCode(Integer lineCode) {
		this.lineCode = lineCode;
	}
	
	//Getter, Setter: lineName
	/**
	 * Get single instance's 'LineName'
	 * @return String lineName
	 */
	public String getLineName() {
		return lineName;
	}
	/**
	 * Set single instance's 'lineName'
	 * @param lineName
	 */
	public void setLineName(String lineName) {
		this.lineName = lineName;
	}
	
	//Getter, Setter: lineNameKana
	/**
	 * Get single instance's 'LineNameKana'
	 * @return String 'LineNameKana'
	 */
	public String getLineNameKana() {
		return lineNameKana;
	}
	/**
	 * Set single instance's 'lineNameKana'
	 * @param lineNameKana
	 */
	public void setLineNameKana(String lineNameKana) {
		this.lineNameKana = lineNameKana;
	}
	
	//Getter, Setter: companyName
	/**
	 * Get single instance's 'CompanyName'
	 * @return String CompanyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * Set single instance's 'CopanyName'
	 * @param companyName
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	
	//Getter, Setter: companyNameKana
	/**
	 * Get single instance's 'CompanyNameKana'
	 * @return String companyNameKana
	 */
	public String getCompanyNameKana() {
		return companyNameKana;
	}
	/**
	 * Set single instance's 'companyNameKana'
	 * @param String companyNameKana
	 */
	public void setCompanyNameKana(String companyNameKana) {
		this.companyNameKana = companyNameKana;
	}
	
	//Getter, Setter: stationCode
	/**
	 * Get single instance's 'stationCode'
	 * @return Integer stationCode
	 */
	public String getStationCode() {
		return stationCode;
	}
	/**
	 * Set single instance's 'stationCode'
	 * @param stationCode
	 */
	public void setStationCode(String stationCode) {
		this.stationCode = stationCode;
	}
	
	//Getter, Setter: stationName
	/**
	 * Get single instance's 'StationName'
	 * @return String stationName
	 */
	public String getStationName() {
		return stationName;
	}
	/**
	 * Set single instance's 'stationName'
	 * @param stationName
	 */
	public void setStationName(String stationName) {
		this.stationName = stationName;
	}
	
	//Getter, Setter: stationNameKana
	/**
	 * Get single instance's 'stationNameKana'
	 * @return String stationNameKana
	 */
	public String getStationNameKana() {
		return stationNameKana;
	}
	/**
	 * Set single instance's 'stationNameKana'
	 * @param stationNameKana
	 */
	public void setStationNameKana(String stationNameKana) {
		this.stationNameKana = stationNameKana;
	}
	
	//Getter, Setter: prefCode
	/**
	 * Get single instance's 'prefCode'
	 * @return prefCode;
	 */
	public String getPrefCode() {
		return prefCode;
	}
	/**
	 * Set single instance's 'prefCode'
	 * @param prefCode
	 */
	public void setPrefCode(String prefCode) {
		this.prefCode = prefCode;
	}
	
	//Getter, Setter: address
	/**
	 * Get single instance's 'address'
	 * @return String address
	 */
	public String getAddress() {
		return address;
	}
	/**
	 * Set single instance's 'address'
	 * @param address
	 */
	public void setAddress(String address) {
		this.address = address;
	}
	
	//Getter, Setter: zip
	/**
	 * Get single instance's 'zip'
	 * @return String zip
	 */
	public String getZip() {
		return zip;
	}
	/**
	 * Set single instance's 'zip'
	 * @param zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}
	
	//Getter, Setter: number
	/**
	 * Get single instance's 'number'
	 * @return Integer number
	 */
	public Integer getNumber() {
		return number;
	}
	/**
	 * Set single instance's 'number'
	 * @param number
	 */
	public void setNumber(Integer number) {
		this.number = number;
	}
	
	//Getter, Setter: importedAt
	/**
	 * Get single instance's 'importedAt'
	 * @return Date importedAt
	 */
	public Date getImportedAt() {
		return importedAt;
	}
	/**
	 * set single instance's 'importedAt'
	 * @param importedAt
	 */
	public void setImportedAt(Date importedAt) {
		this.importedAt = importedAt;
	}
	
	//Getter, Setter: createdAt
	/**
	 * Get single instance's 'createdAt'
	 * @return Date createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}
	/**
	 * Set single instance's 'createdAt'
	 * @param createdAt
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	//Getter, Setter:  updateAt
	/**
	 * get single instance's '
	 * @return Date updatedAt;
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}
	/**
	 * Set single instance's 'updatedAt'
	 * @param updatedAt
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	
	//Getter, Setter: deletedAt
	/**
	 * Get single instance's 'deletedAt'
	 * @return Date deletedAt
	 */
	public Date getDeletedAt() {
		return deletedAt;
	}
	/**
	 * Set single instance's 'deletedAt'
	 * @param deletedAt
	 */
	public void setDeletedAt(Date deletedAt) {
		this.deletedAt = deletedAt;
	}
	
	//Getter, Setter: isDeleted
	/**
	 * Get boolean value of isDelete
	 * @return the isDelete
	 */
	public boolean isDeleted() {
		return isDeleted;
	}
	
	/**
	 * @param isDeleted the isDeleted to set
	 */
	public void setDeleted(boolean isDeleted) {
		this.isDeleted = isDeleted;
	}
}
