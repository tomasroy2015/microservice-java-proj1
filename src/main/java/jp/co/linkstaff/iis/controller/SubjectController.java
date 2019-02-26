package jp.co.linkstaff.iis.controller;

import java.util.List;

import jp.co.linkstaff.iis.model.Subject;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import jp.co.linkstaff.iis.service.SubjectService;
import org.springframework.data.domain.PageRequest;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.utils.ObjectNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
/**
 * 
 * @author .....
 *
 */
@RequestMapping(value = "/subject")
@EnableHypermediaSupport(type = HypermediaType.HAL)
@RestController
public class SubjectController {	
	@Autowired
	private SubjectService subjectService;
	/**
	 * 
	 * @param subjectservice
	 */
//	@Autowired
//	public SubjectController(SubjectService subjectservice) {
//		this.subjectService = subjectservice;
//	}

	/**
	 * add a new subject
	 * @param subject
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public void addSubject(@RequestBody Subject subject) {
		try {
			subjectService.addNewSubject(subject);
		} catch (Exception ex) {
			throw new ServerErrorException(ex.getMessage());
		}
	}
	/**
	 * 
	 * @return total subject list
	 */
	@RequestMapping(value = "/list")
	public List<Subject> getList() {
		return subjectService.getAllSubject();
	}
	/**
	 * fetch particular subject according subject id 
	 * @param id
	 * @return subject
	 */
	@RequestMapping(value = "/{subjectId}")
	public Subject getSubject(@PathVariable Long subjectId) {
		Subject subject = subjectService.getSubject(subjectId);
		if (subject == null)
			throw new ObjectNotFoundException("Subject not found of id-" + subjectId);
		return subject;
	}
	/**
	 * update subject info against subjectId
	 * @param subject
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/{subjectId}")
	public void updateSubject(@RequestBody Subject subject, @PathVariable Long subjectId) {
		try {
			subjectService.updateSubject(subject, subjectId);
		} catch (Exception ex) {
			throw new ServerErrorException(ex.getMessage());
		}
	}

	/**
	 * delete a particular subject according id
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{subjectId}")
	public void deleteSubject(@PathVariable Long subjectId) {
		try {
			subjectService.deleteSubject(subjectId);
		} catch (Exception ex) {
			throw new ServerErrorException(ex.getMessage());
		}
	}
	/**
	 * 
	 * @param page
	 * @param pageSize
	 * @return jobs
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(method = RequestMethod.GET,value = "/search/{page}/{pageSize}")
	public Page<Subject> searchJobList(@PathVariable int page,@PathVariable int pageSize) {
	    Pageable pageable = new PageRequest(page, pageSize);
	    Page<Subject> jobs = subjectService.searchJobs(pageable);
	    return jobs;
	}
}