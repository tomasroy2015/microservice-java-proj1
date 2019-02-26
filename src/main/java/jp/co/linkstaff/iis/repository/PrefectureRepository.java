package jp.co.linkstaff.iis.repository;
import jp.co.linkstaff.iis.model.Prefecture;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
/**
 * <Prefecture,Long> class name and type of primary key
 * @author .....
 *
 */
@Repository
public interface PrefectureRepository extends CrudRepository<Prefecture,Long> {
	Page<Prefecture> findAll(Pageable pageable);
	List<Prefecture> findByIsDeleted(boolean isDeleted);
//	@Query(value = "select prefecture_id,prefecture_code,name,area_id,created_at,updated_at,deleted_at "
//			+ " from prefecture  ",nativeQuery = true)
//	List<Prefecture> findAll();
}