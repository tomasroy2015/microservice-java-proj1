package jp.co.linkstaff.iis.controller;

import java.util.List;

import org.springframework.hateoas.Link;
import jp.co.linkstaff.iis.model.Notice;
import jp.co.linkstaff.iis.service.NoticeService;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.utils.ObjectNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
/**
 * 
 * @author ....
 *
 */
@RequestMapping(value = "/notice")
@EnableHypermediaSupport(type = HypermediaType.HAL)
@RestController
@CrossOrigin
public class NoticeController {	
	@Autowired
	private NoticeService noticeService;
	/**
	 * add new instance of Notice
	 * confirm that this notice private or public(type = private/public)
	 * @param notice
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public Notice addNotice(@RequestBody Notice notice) {
		try {
		   return noticeService.addNewNotice(notice);
		} catch (Exception ex) {
			throw new ServerErrorException(ex.getMessage());
		}
	}	
	/**
	 * total list of notice 
	 * @return notices
	 */
	@RequestMapping(value = "/list",method = RequestMethod.GET, produces = { "application/hal+json" })
	public List<Notice> getList() {
		  List<Notice> notices = noticeService.getAllNotice();
		  for (Notice notice : notices) {
			  Long noticeId = notice.getNoticeId();
	          Link selfLink = linkTo(NoticeController.class).slash(noticeId).withSelfRel();
	          notice.add(selfLink);
	      }
		  return notices;
	}
	/**
	 * get those notice which is not deleted
	 * @return notices
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/original/list")
	public List<Notice> getNoticeOriginalList(){
		List<Notice> notices =  null;
		
		try {
			notices = noticeService.getAllOriginalNotice();		
		} catch (Exception e) {
			throw new ServerErrorException(e.getMessage());
		}
		
		return notices;
	}
	/**
	 * we can get notice against noticeId
	 * @param noticeId
	 * @return notice
	 */
	@RequestMapping(value = "/{noticeId}")
	public Notice getNotice(@PathVariable Long noticeId) {
		Notice notice = noticeService.getNotice(noticeId);

		if (notice == null)
			throw new ObjectNotFoundException(" Notice not found of id-" + noticeId);
		return notice;
	}	
	/**
	 * we can update single instance against noticeId
	 * @param notice
	 * @param noticeId
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/{noticeId}")
	public Notice updateNotice(@RequestBody Notice notice, @PathVariable Long noticeId) {

		try {
			return noticeService.updateNotice(notice, noticeId);
		} catch (Exception ex) {
			throw new ServerErrorException(ex.getMessage());
		}
	}	
	/**
	 * we will no delete any data permanently 
	 * if we want to delete single instance then just update isDeleted = true
	 * @param noticeId
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/del/{noticeId}")
	public void deleteNotice(@PathVariable Long noticeId) {
		try {
			noticeService.deleteNotice(noticeId);
		} catch(Exception ex) {
			throw new ServerErrorException(ex.getMessage());
		}
	}	
}
