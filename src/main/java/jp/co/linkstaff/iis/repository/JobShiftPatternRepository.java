package jp.co.linkstaff.iis.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import jp.co.linkstaff.iis.model.JobShiftPattern;
import org.springframework.data.repository.CrudRepository;
/**
* 
* @author .....
*
*/
@Repository
public interface JobShiftPatternRepository extends CrudRepository<JobShiftPattern,Long> {	
			/**
			 * 
			 * @param isDeleted
			 * @return JobShiftPattern list(here have no deleted data)
			 */
            List<JobShiftPattern> findByIsDeleted(boolean isDeleted);
        	/**
        	 * 
        	 * @param isDeleted
        	 * @param jobShiftPatternId
        	 * @return those JobShiftPattern which is not deleted
        	 */
            JobShiftPattern findByIsDeletedAndJobShiftPatternId(boolean isDeleted, Long jobShiftPatternId);
            /**
        	 * 
        	 * @param pageable
        	 * @return total HospitalBed list
        	 */
            Page<JobShiftPattern> findAll(Pageable pageable);
}
