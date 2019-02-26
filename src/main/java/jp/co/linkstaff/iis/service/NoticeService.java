package jp.co.linkstaff.iis.service;

import java.util.List;
import org.apache.logging.log4j.Logger;
import jp.co.linkstaff.iis.model.Notice;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.repository.NoticeRepository;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
 * @author .....
 *
 */
@Service
public class NoticeService {	
	private static final Logger logger = LogManager.getLogger(NoticeService .class);
	@Autowired
	private NoticeRepository noticeRepository;
	/**
	 * add new instance of Notice using save method
	 * @param notice
	 */
	public Notice addNewNotice(Notice notice) {
		try {
			return noticeRepository.save(notice);
		} catch (Exception e) {
			logger.error("NoticeService.'\n' Method: addNewNotice() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}		
	}
	/**
	 * get all notice list including soft delete
	 * @return list
	 */
	public List<Notice> getAllNotice() {
		List<Notice> list = (List<Notice>) noticeRepository.findAll();
		return list;
	}
    /**
     * get those notice which is not deleted
     * @return notices
     */
	public List<Notice> getAllOriginalNotice(){
		List<Notice> notices = null;
		try {
			notices = noticeRepository.findByIsDeleted(false); 
		} catch (Exception e) {			
			throw new ServerErrorException("Exception occured at Service in getAllOriginalNotice(). "+e);	
		}
		
		return notices;
	}
	/**
	 * we can get notice against noticeId
	 * @param noticeId
	 * @return notice
	 */
	public Notice getNotice(Long noticeId) {
		Notice notice = null;
		try {
			notice = noticeRepository.findById(noticeId).get();
		} catch (Exception e) {
			logger.error("NoticeService.'\n' Method: getNotice() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
		return notice;
	}
	/**
	 * we can update single instance against noticeId
	 * @param notice
	 * @param noticeId
	 */
	public Notice updateNotice(Notice notice, Long noticeId){		
		try {
			notice.setNoticeId(noticeId);
			return noticeRepository.save(notice);
		} catch (Exception e) {
			logger.error("NoticeService.\n Method: updateNotice() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * we will no delete any data permanently
	 * first get all notice list which is not deleted
	 * after that set isDeleted field = true(for our understanding that this data is deleted)
	 * @param noticeId
	 */
	public void deleteNotice(Long noticeId) {		
		Notice notice = null;
		try {
			
			notice = noticeRepository.findByIsDeletedAndNoticeId(false, noticeId);				
		} catch (Exception e) {
			throw new ServerErrorException("Exception occured at Service in deleteNotice(). "+e);
		}
		if(notice != null) {
			notice.setDeleted(true);
			try {				
				 noticeRepository.save(notice);				
			} catch(Exception e) {
				throw new ServerErrorException("Exception occured at Service in deleteNotice(). "+e);
			}			
		} else {
			logger.error(String.format("Notice by id: %d is not found.\nHence, cannot be deleted.", noticeId));
		}		
	}
}
