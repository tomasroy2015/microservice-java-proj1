package jp.co.linkstaff.iis.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import jp.co.linkstaff.iis.model.HospitalBed;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
/**
* 
* @author .....
*
*/
@Repository
public interface HospitalBedRepository extends CrudRepository<HospitalBed,Long> {	
			/**
			 * 
			 * @param isDeleted
			 * @return HospitalBed list(here have no deleted data)
			 */
            List<HospitalBed> findByIsDeleted(boolean isDeleted);
        	/**
        	 * 
        	 * @param isDeleted
        	 * @param hospitalBedId
        	 * @return those hospitalBed which is not deleted
        	 */
            HospitalBed findByIsDeletedAndHospitalBedId(boolean isDeleted, Long hospitalBedId);
            /**
        	 * 
        	 * @param pageable
        	 * @return total HospitalBed list
        	 */
            Page<HospitalBed> findAll(Pageable pageable);
}
