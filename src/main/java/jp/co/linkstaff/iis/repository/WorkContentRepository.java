package jp.co.linkstaff.iis.repository;

import org.springframework.data.domain.Page;
import jp.co.linkstaff.iis.model.WorkContent;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
/**
 * <WorkContent,Long> class name and type of primary key
 * @author .....
 *
 */
@Repository
public interface WorkContentRepository extends CrudRepository<WorkContent,Long> {
	Page<WorkContent> findAll(Pageable pageable);

}
