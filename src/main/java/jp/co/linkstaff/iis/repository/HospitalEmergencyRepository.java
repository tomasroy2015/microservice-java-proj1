package jp.co.linkstaff.iis.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import jp.co.linkstaff.iis.model.HospitalEmergency;
import org.springframework.data.repository.CrudRepository;
/**
 * 
 * @author .....
 *
 */
@Repository
public interface HospitalEmergencyRepository extends CrudRepository<HospitalEmergency,Long> {	
	/**
	 * 
	 * @param isDeleted
	 * @return HospitalEmergency list(here have no deleted data)
	 */
	List<HospitalEmergency> findByIsDeleted(boolean isDeleted);
	/**
	 * 
	 * @param isDeleted
	 * @param hospitalEmergencyId
	 * @return those hospitalEmergency which is not deleted
	 */
	HospitalEmergency findByIsDeletedAndHospitalEmergencyId(boolean isDeleted, Long hospitalEmergencyId);
	/**
	 * 
	 * @param pageable
	 * @return total HospitalEmergency list
	 */
	Page<HospitalEmergency> findAll(Pageable pageable);
}
