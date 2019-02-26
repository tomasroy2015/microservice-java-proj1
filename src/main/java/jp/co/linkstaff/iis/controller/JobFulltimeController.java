package jp.co.linkstaff.iis.controller;

import java.util.List;
import org.springframework.lang.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.PageRequest;
import jp.co.linkstaff.iis.model.JobFulltime;
import jp.co.linkstaff.iis.utils.ObjectNotFoundException;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import jp.co.linkstaff.iis.service.JobFulltimeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Roy
 *
 */
@RequestMapping(value = "/jobinfo/fulltime")
@RestController
public class JobFulltimeController {
	@Autowired
	private JobFulltimeService service;

	/**
	 * get all the instance of FullTimeJob.
	 * @return List <JobFulltime
	 */
	@RequestMapping(value = "/list")
	public List<JobFulltime> getList() {
		return service.getAllJobs();
	}	
	/**
	 * get a single instance of FullTimeJob matching id;
	 * @param Long id
	 * @return full
	 */
	@RequestMapping(value ="/{id}", method = RequestMethod.GET, produces = { "application/hal+json" })
	public JobFulltime getFulltime(@PathVariable Long id) {
		JobFulltime full = service.getJobFulltime(id);
		return full;
	}

	/**
	 * Get all jobs by search in home page
	 * @param stations
	 * @param prefs
	 * @param contents
	 * @param subjects
	 * @param keyword
	 * @param ispublic
	 * @param page
	 * @param pageSize
	 * @return jobs list with paging
	 */
	@RequestMapping(method = RequestMethod.GET,value = "/search/{ispublic}/{page}/{pageSize}")
	public Page<JobFulltime> searchJobs(@RequestParam(value="keyword",required = false) @Nullable String keyword,
	                                @RequestParam(value="stations",required = false) @Nullable String[] stations,
									@RequestParam(value="prefs",required = false) @Nullable String[] prefs,
									@RequestParam(value="contents",required = false) @Nullable String contents,
									@RequestParam(value="subjects",required = false) @Nullable String subjects,
									@PathVariable boolean ispublic,
									@PathVariable int page,@PathVariable int pageSize) {
		Page<JobFulltime> jobs = null;
		Pageable pageable = PageRequest.of(page, pageSize,Direction.DESC,"job_code");
		jobs = service.searchJobs(keyword,stations, prefs, contents,subjects,ispublic, pageable);	
		
	    if(!jobs.hasContent()) {
		   throw new ObjectNotFoundException("Jobs not found under this search criteria.");
	    }
	   return jobs;
	}
}
