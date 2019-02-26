package jp.co.linkstaff.iis.repository;

import java.util.List;
import jp.co.linkstaff.iis.model.Area;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
/**
 * <Area,Long> class name and type of primary key
 * @author .....
 *
 */
@Repository
public interface AreaRepository extends CrudRepository<Area,Long> {
    /**
	 * @param pageable
	 * @return total Area list
	 */
	Page<Area> findAll(Pageable pageable);
	/**
	 * @param isDeleted
	 * @return Original Area list(here have no deleted data)
	 */
	List<Area> findByIsDeleted(boolean isDeleted);
}