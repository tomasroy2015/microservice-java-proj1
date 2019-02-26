package jp.co.linkstaff.iis.repository;


import java.util.List;
import jp.co.linkstaff.iis.model.Notice;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;


/**
 * 
 * @author .....
 *
 */
@Repository
public interface NoticeRepository extends CrudRepository<Notice,Long> {	
	/**
	 * 
	 * @param isDeleted
	 * @return notice list(here have no deleted data)
	 */
	List<Notice> findByIsDeleted(boolean isDeleted);
	/**
	 * 
	 * @param isDeleted
	 * @param noticeId
	 * @return those notice which is not deleted
	 */
	Notice findByIsDeletedAndNoticeId(boolean isDeleted, Long noticeId);
	/**
	 * 
	 * @param pageable
	 * @return total notice list
	 */
	Page<Notice> findAll(Pageable pageable);
}
