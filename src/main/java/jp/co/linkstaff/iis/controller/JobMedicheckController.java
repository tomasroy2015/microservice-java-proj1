package jp.co.linkstaff.iis.controller;

import java.util.List;
import org.springframework.lang.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.PageRequest;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.model.JobMedicheck;
import jp.co.linkstaff.iis.utils.ObjectNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import jp.co.linkstaff.iis.service.JobMedicheckService;
/**
 * 
 * @author Roy
 *
 */
@RequestMapping(value = "/jobinfo/medicheck")
@RestController
public class JobMedicheckController {
	@Autowired
	private JobMedicheckService service;
	/**
	 * 
	 * @param service
	 */
//	@Autowired
//	public JobMedicheckController(JobMedicheckService service) {
//		this.service = service;
//	}
	/**
	 * add a new job info
	 * @param job
	 */
	@RequestMapping(method=RequestMethod.POST,value="/add")
	public void addJob(@RequestBody JobMedicheck job) {
		service.addNewJob(job);		
	}	
	/**
	 * fetch job list of medicheck
	 * @return List<JobMedicheck
	 */
	@RequestMapping(value = "/list")
	public List<JobMedicheck> getList() {
		return service.getAllJobs();
	}	
	/**
	 * get a single instance of medicheck job matching id
	 * @param id
	 * @return medi
	 */
	@RequestMapping(value = "/{id}")
	public JobMedicheck getMedicheck (@PathVariable Long id) {
		JobMedicheck medi = service.getJobMedicheck(id);
		return medi;
	}
	/**
	 * update job info according job id
	 * @param job
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void updateJob(@RequestBody JobMedicheck job, @PathVariable Long id) {
		try {
			service.updateJob(job, id);
		} catch (Exception ex) {
			throw new ServerErrorException(ex.getMessage());
		}
	}
	/**
	 * delete medicheck job info against particular job id
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
	@RequestMapping(method = RequestMethod.GET,value = "/search/medicheck/{ispublic}/{page}/{pageSize}")
	public Page<JobMedicheck> searchJobs(@RequestParam(value="stations") @Nullable String[] stations,@RequestParam(value="prefs") @Nullable String[] prefs,
			@RequestParam(value="contents") @Nullable String[] contents,@RequestParam(value="subjects") @Nullable String[] subjects,
			@RequestParam(value="keyword") @Nullable String keyword,
			@RequestParam(value="shiftpatterns") @Nullable String[] shiftpatterns,
			@RequestParam(value="workdates") @Nullable String[] workdates,
			@RequestParam(value="workdays") @Nullable String[] workdays,
			boolean ispublic,@PathVariable int page,@PathVariable int pageSize) {
		Page<JobMedicheck> jobs = null;
		Pageable pageable = new PageRequest(page, pageSize);
		jobs = service.searchJobs(stations, prefs, contents,subjects,keyword,shiftpatterns,workdates,workdays,ispublic, pageable);		   
	    if(!jobs.hasContent()) {
		   throw new ObjectNotFoundException("Jobs not found under this search criteria.");
	    }
	   return jobs;
	}
}