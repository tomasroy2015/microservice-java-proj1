package jp.co.linkstaff.iis.repository;

import java.util.List;
import org.springframework.data.domain.Page;
import jp.co.linkstaff.iis.model.HospitalSystem;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
/**
 * 
 * @author .....
 *
 */
@Repository
public interface HospitalSystemRepository extends CrudRepository<HospitalSystem,Long> {	
	/**
	 * 
	 * @param isDeleted
	 * @return HospitalSystem list(here have no deleted data)
	 */
	List<HospitalSystem> findByIsDeleted(boolean isDeleted);
	/**
	 * 
	 * @param isDeleted
	 * @param hospitalSystemId
	 * @return those hospitalSystem which is not deleted
	 */
	HospitalSystem findByIsDeletedAndHospitalSystemId(boolean isDeleted, Long hospitalSystemId);
	/**
	 * 
	 * @param pageable
	 * @return total HospitalSystem list
	 */
	Page<HospitalSystem> findAll(Pageable pageable);
}
