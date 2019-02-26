package jp.co.linkstaff.iis.repository;
import jp.co.linkstaff.iis.model.Subject;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;
/**
 * <Subject,Long> class name and type of primary key
 * @author .....
 *
 */
@Repository
public interface SubjectRepository extends CrudRepository<Subject,Long> {
	Page<Subject> findAll(Pageable pageable);
	List<Subject> findByIsDeleted(boolean isDeleted);
}