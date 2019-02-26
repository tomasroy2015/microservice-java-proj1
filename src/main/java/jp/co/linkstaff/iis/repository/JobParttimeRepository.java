package jp.co.linkstaff.iis.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import jp.co.linkstaff.iis.model.JobParttime;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
/**
 * 
 * @author .....
 *
 */
@Repository
public interface JobParttimeRepository extends CrudRepository<JobParttime,Long>{
	
Page<JobParttime> findAll(Pageable pageable);
	
	/**
	 * 
	 * @param workaddress1
	 * @return
	 */
	@Query(value = "select * from job_parttime  where work_address1 like %?1%",nativeQuery = true)
	List<JobParttime> findByWorkAddress1Containing(String workaddress1); 
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
	@Query(value = "select j.*,h.id as hospitalId,h.hospital_system,h.emergency from job_parttime j "
			 +" left join hospital h ON j.hospital_code = h.hospital_code where "
		     + " to_tsvector(j.search_keyword) @@ to_tsquery(:keyword) "  
		     + " OR  j.work_station_code1 IN (:station) "
		     + " OR  j.work_address1 IN (:pref) " 
		     + " OR  to_tsvector(j.work_content) @@ to_tsquery(:content) "
		     + " OR  to_tsvector(j.subject) @@ to_tsquery(:subject) "
		     + " OR  to_tsvector(h.hospital_system) @@ to_tsquery(:hospitalsystem)  "
		     + " OR  to_tsvector(h.emergency) @@ to_tsquery(:emergency)  "
		     + " OR  to_tsvector(j.shift_pattern) @@ to_tsquery(:shiftpattern)  "
		     + " OR  to_tsvector(j.work_day) @@ to_tsquery(:workday)  ",
		     
	   nativeQuery = true)
    Page<JobParttime> searchJobs(@Param("keyword") String keyword,@Param("station") List<String> station,
		@Param("pref") List<String> pref,@Param("content") String content,@Param("subject") String subject,
		@Param("hospitalsystem") String hospitalsystem,@Param("emergency") String emergency,
		@Param("shiftpattern") String shiftpattern,@Param("workday") String workday,Pageable pageable);
	
}
