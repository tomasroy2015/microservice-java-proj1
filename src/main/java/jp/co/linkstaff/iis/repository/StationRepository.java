package jp.co.linkstaff.iis.repository;


import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.linkstaff.iis.model.Station;

/**
 * CrudRepository is Spring Interface.
 * With @Repository annotation spring can auto detect implementation class (wrapper class).
 * Hence StationRepository class can extends an interface.
 */
@Repository
public interface StationRepository extends CrudRepository<Station,Long> {
	
	List<Station> findByIsDeleted(boolean isDeleted);
	Station findByIsDeletedAndStationId(boolean isDeleted, Long id);
	
	Page<Station>findByIsDeleted(boolean isDeleted, PageRequest pageable);
	
	/**
	 * To be implemented to find single instance/ list of Station object matching 'name'.
	 * JPA Method Query. Implemented automatically on Wrapper class for CrudRepository interface.
	 * @param stationName
	 * @return
	 */
	Station findOneByIsDeletedAndStationNameIgnoreCase(boolean isDeleted, String stationName);
	/*
	 * But it's best practice use JPQL. take a look on it...
	 * https://stackoverflow.com/questions/37167422/how-to-fetch-only-selected-attributes-of-an-entity-using-spring-jpa
	 */
	
	
	/**
	 * To be implemented to find single instance/ list of Station object matching 'code'.
	 * JPA Method Query. Implemented automatically on Wrapper class for CrudRepository interface.
	 * @param stationCode
	 * @return
	 */
	Station findOneByIsDeletedAndStationCode(boolean isDeleted, String stationCode);
	
	/**
	 * To be implemented to find single instance/ list of Station object matching both 'latitude' and 'longitude'.
	 * JPA Method Query. Implemented automatically on Wrapper class for CrudRepository interface.
	 * @param latitude
	 * @param longitude
	 * @return
	 */
	Station findByIsDeletedAndLatitudeAndLongitudeIgnoreCase(boolean isDeleted, String latitude, String longitude);
	
	/**
	 * To be implemented to find list of Station matching prefCode ignoring case.
	 * JPA Method Query. Implemented automatically on Wrapper class for CrudRepository interface.
	 * @param prefCode
	 * @return
	 */
	List<Station> findByIsDeletedAndPrefCodeIgnoreCase(boolean isDeleted, String prefCode);
	
		
	//@Modifying
	@Query("UPDATE Station station SET station.isDeleted = true where station.stationId = :stationId")
	void deleteStation(@Param("stationId") Long stationId);
	
}