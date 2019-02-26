package jp.co.linkstaff.iis.controller;

import java.util.List;
import jp.co.linkstaff.iis.model.WorkContent;
import jp.co.linkstaff.iis.service.WorkContentService;
import jp.co.linkstaff.iis.utils.ObjectNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = "/workcontent")
@EnableHypermediaSupport(type = HypermediaType.HAL)
@RestController
public class WorkContentController {	
	@Autowired
	private WorkContentService workService;
	
	/**
	 * 
	 * @return list of work content
	 */

	@RequestMapping(value = "/list")
	public List<WorkContent>getList() {
		return workService.getAllWork();
	}
	
	//#62 
	/**
	 * 
	 * @param id
	 * @return  work
	 */
	@RequestMapping(value = "/{workcontentId}")
	public WorkContent getWork(@PathVariable Long workcontentId) {
		WorkContent work = workService.getWork(workcontentId);
		if (work == null)
			throw new ObjectNotFoundException("Work not found of id-" + workcontentId);
		return work;
	}
	
}
