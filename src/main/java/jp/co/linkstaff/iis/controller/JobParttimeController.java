package jp.co.linkstaff.iis.controller;

import java.util.List;
import org.springframework.lang.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.PageRequest;
import jp.co.linkstaff.iis.model.JobParttime;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.utils.ObjectNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import jp.co.linkstaff.iis.service.JobParttimeService;

/**
 * 
 * @author Roy
 *
 */
@RequestMapping(value = "/jobinfo/parttime")
@RestController
public class JobParttimeController{
	@Autowired
	private JobParttimeService service;

	/**
	 * 
	 * @param service
	 */
//	@Autowired
//	public JobParttimeController(JobParttimeService service) {
//		this.service = service;
//	}
	/**
	 * Insert job info
	 * @param job
	 */
	@RequestMapping(method=RequestMethod.POST,value="/add")
	public void addJob(@RequestBody JobParttime job) {
		service.addNewJob(job);		
	}	
	/**
	 * get all the instance of PartrtimeJob.
	 * @return List<JobParttime
	 */
	@RequestMapping(value = "/list")
	public List<JobParttime> getList() {
		return service.getAllJobs();
	}
	
	/**
	 * get a single instance of PartrtimeJob matching id;
	 * @param id
	 * @return part
	 */
	@RequestMapping(value = "/{id}")
	public JobParttime getParttime(@PathVariable Long id) {
		JobParttime part = service.getJobParttime(id);
		return part;
	}
	/**
	 * update job info according job id
	 * @param job
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void updateJob(@RequestBody JobParttime job, @PathVariable Long id) {
		try {
			service.updateJob(job, id);
		} catch (Exception ex) {
			throw new ServerErrorException(ex.getMessage());
		}
	}
	/**
	 * delete particular job according job id
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void deleteJob(@PathVariable Long id) {
		try {
			service.deleteJob(id);
		} catch (Exception ex) {
			throw new ServerErrorException(ex.getMessage());
		}
	}	
	/**
	 * 
	 * @param stations
	 * @param prefs
	 * @param contents
	 * @param subjects
	 * @param keyword
	 * @param ispublic
	 * @param page
	 * @param pageSize
	 * @return jobs
	 */
	@SuppressWarnings("deprecation")
	@RequestMapping(method = RequestMethod.GET,value = "/search/{ispublic}/{page}/{pageSize}")
	public Page<JobParttime> searchJobs(@RequestParam(value="stations") @Nullable String[] stations,@RequestParam(value="prefs") @Nullable String[] prefs,
			@RequestParam(value="contents") @Nullable String[] contents,@RequestParam(value="subjects") @Nullable String[] subjects,
			@RequestParam(value="keyword") @Nullable String keyword,
			@RequestParam(value="hospitalsystems") @Nullable String[] hospitalsystems,
			@RequestParam(value="emergencies") @Nullable String[] emergencies,
			@RequestParam(value="shiftpatterns") @Nullable String[] shiftpatterns,
			@RequestParam(value="workdays") @Nullable String[] workdays,
			@PathVariable boolean ispublic,@PathVariable int page,@PathVariable int pageSize) {
		Page<JobParttime> jobs = null;
		Pageable pageable = new PageRequest(page, pageSize,new Sort(Direction.DESC,"job_code"));
		jobs = service.searchJobs(stations, prefs, contents,subjects,keyword,hospitalsystems,emergencies,
				                     shiftpatterns,workdays, ispublic, pageable);		   
	    if(!jobs.hasContent()) {
		   throw new ObjectNotFoundException("Jobs not found under this search criteria.");
	    }
	   return jobs;
	}		
}