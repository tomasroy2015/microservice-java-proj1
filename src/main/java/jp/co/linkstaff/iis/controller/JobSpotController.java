package jp.co.linkstaff.iis.controller;

import java.util.List;
import org.springframework.lang.Nullable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;

import jp.co.linkstaff.iis.model.JobSpot;
import org.springframework.data.domain.PageRequest;
import jp.co.linkstaff.iis.service.JobSpotService;
import jp.co.linkstaff.iis.utils.ObjectNotFoundException;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
 * @author Roy
 *
 */
@RequestMapping(value = "/jobinfo/spot")
@RestController
public class JobSpotController {
	@Autowired
	private JobSpotService service;

	/**
	 * get all the instance of spot job.
	 * @return List<JobSpot
	 */
	@RequestMapping(value = "/list")
	public List<JobSpot> getList() {
		return service.getAllJobs();
	}	
	/**
	 * get a single instance of spot job matching id;
	 * @param id
	 * @return spot
	 */
	@RequestMapping(value = "/{id}")
	public JobSpot getSpot(@PathVariable Long id) {
		JobSpot spot = service.getJobSpot(id);
		return spot;
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
	@RequestMapping(method = RequestMethod.GET,value = "/search/{ispublic}/{page}/{pageSize}")
	public Page<JobSpot> searchJobs(@RequestParam(value="stations",required = false) @Nullable String[] stations,
	        @RequestParam(value="prefs",required = false) @Nullable String[] prefs,
			@RequestParam(value="contents",required = false) @Nullable String contents,
			@RequestParam(value="subjects",required = false) @Nullable String subjects,
			@RequestParam(value="keyword",required = false) @Nullable String keyword,
			@RequestParam(value="hospitalsystems",required = false) @Nullable String[] hospitalsystems,
			@RequestParam(value="emergencies",required = false) @Nullable String[] emergencies,
			@RequestParam(value="shiftpatterns",required = false) @Nullable String shiftpatterns,
			@RequestParam(value="spotdates",required = false) @Nullable String[] spotdates,
			@PathVariable boolean ispublic,@PathVariable int page,@PathVariable int pageSize) {
		Page<JobSpot> jobs = null;
		Pageable pageable = PageRequest.of(page, pageSize,Direction.DESC,"job_code");
		jobs = service.searchJobs(stations, prefs, contents,subjects,keyword,hospitalsystems,emergencies,shiftpatterns,spotdates,ispublic, pageable);	
		
		if(!jobs.hasContent()) {
		   throw new ObjectNotFoundException("Jobs not found under this search criteria.");
		}
		   
	    return jobs;
	}
}