package jp.co.linkstaff.iis.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;

import jp.co.linkstaff.iis.model.JobSpot;
/**
 * 
 * @author Roy
 *
 */
@Repository
public interface JobSpotRepository extends JpaRepository<JobSpot,Long>,JobSpotRepositoryCustom{
//	@Query("SELECT * FROM job_spot")
//	Page<JobSpot> findAll( @Param("station") String station,@Param("pref") String pref,
//			@Param("content") String content,@Param("subject") String subject,
//			@Param("keyword") String keyword,@Param("ispublic") boolean ispublic, Pageable pageable);
	Page<JobSpot> findAll(Pageable pageable);	
	/**
	 * 
	 * @param workaddress1
	 * @return
	 */
	@Query(value = "select * from job_spot  where work_address1 like %?1%",nativeQuery = true)
	List<JobSpot> findByWorkAddress1Containing(String workaddress1); 
	//OR  work_station_code1 IN (?2)
	/**
	 * @param keyword
	 * @param station
	 * @param pref
	 * @param content
	 * @param subject
	 * @param hospitalSystem
	 * @param emergency
	 * @param shiftpattern
	 * @param workday
	 * @return parttimejobs with paging data 
	 * */
	@Query(value = "select * from job_spot j where "
		     + "   to_tsvector(search_keyword) @@ to_tsquery(:keyword) "  
		     + "   OR  work_station_code1 IN (:station) "
		     + "   OR  work_address1 IN (:pref) " 
		     + "   OR  to_tsvector(work_content) @@ to_tsquery(:content) "
		     + "   OR  to_tsvector(subject) @@ to_tsquery(:subject) "
		    //  + "   OR  to_tsvector(h.hospital_system) @@ to_tsquery(:hospitalsystem) "
		    //  + "   OR  to_tsvector(h.emergency) @@ to_tsquery(:emergency) "
		     + "   OR  to_tsvector(shift_pattern) @@ to_tsquery(:shiftpattern)  "
		     + "   OR  date_trunc('day', spot_date) IN (:spotdate) ",
		     
	   nativeQuery = true)
    Page<JobSpot> searchJobs(@Param("keyword") @Nullable String keyword,@Param("station") @Nullable List<String> station,
		@Param("pref") @Nullable List<String> pref,@Param("content") @Nullable String content,@Param("subject") @Nullable String subject,
		@Param("shiftpattern") @Nullable String shiftpattern,@Param("spotdate") @Nullable List<Date>  spotdate,Pageable pageable);

	 Page<JobSpot> findBySearchKeywordLikeOrWorkStationCode1InOrWorkAddress1InOrWorkContentInOrSubjectInOrShiftPatternInOrSpotDateIn(String searchKeyword, Collection<String> workStationCode1,Collection<String> workAddress1,
																			 Collection<String> workContent, Collection<String> subject,Collection<String> shiftPattern,Collection<Date> spotDate,Pageable pageable);
	 List<JobSpot> findBySearchKeywordLikeOrWorkStationCode1In(@Nullable String searchKeyword, @Nullable Collection<String> workStationCode1);																		 
	}
