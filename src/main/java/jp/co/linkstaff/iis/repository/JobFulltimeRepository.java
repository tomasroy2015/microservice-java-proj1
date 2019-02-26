package jp.co.linkstaff.iis.repository;

import java.util.Collection;
import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import jp.co.linkstaff.iis.model.JobFulltime;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * 
 * @author Roy
 *
 */
@Repository
public interface JobFulltimeRepository extends JpaRepository<JobFulltime,Long>,JobFulltimeRepositoryCustom{
//	@Query("SELECT * FROM job_fulltime")
//	Page<JobFulltime> findAll( @Param("station") String station,@Param("pref") String pref,
//			@Param("content") String content,@Param("subject") String subject,
//			@Param("keyword") String keyword,@Param("ispublic") boolean ispublic, Pageable pageable);
	//Page<JobFulltime> findAll(Pageable pageable);	
	@Query(value = "select * from job_fulltime  where work_address1 like %?1%",nativeQuery = true)
	/**
	 * 
	 * @param workaddress1
	 * @returnsearchCustomJobs
	 */
	List<JobFulltime> findByWorkAddress1Containing(String workaddress1); 
	//OR  work_station_code1 IN (?2)
	@Query(value = "select j.*,h.* from job_parttime j "
			     +" left join hospital h ON j.hospital_code = h.hospital_code where "
			     + " to_tsvector(j.search_keyword) @@ to_tsquery(:keyword) "  
			     + " OR  j.work_station_code1 IN (:station) "
			     + " OR  j.work_address1 IN (:pref) " 
			     + " OR  to_tsvector(j.work_content) @@ to_tsquery(:content) "
				 + " OR  to_tsvector(j.subject) @@ to_tsquery(:subject) "
				 + " OR  j.is_public = :ispublic ",
		   nativeQuery = true)
	Page<JobFulltime> searchJobs(@Param("keyword") String keyword,@Param("station") Collection<String> station,
			@Param("pref") Collection<String> pref,@Param("content") String content,@Param("subject") String subject,boolean ispublic, Pageable pageable);
}
