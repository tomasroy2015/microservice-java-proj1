package jp.co.linkstaff.iis.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import jp.co.linkstaff.iis.utils.ObjectNotFoundException;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.model.FavouriteJobs;
import jp.co.linkstaff.iis.service.FavouriteJobsService;



@EnableHypermediaSupport(type = HypermediaType.HAL)
@RestController //Please annotate @RestControllerafter @EnableHypermediaSupport
@RequestMapping(value = "/favouriteJobs") //not sure if camel case on URI supports
public class FavouriteJobsController { //A funny bug is occurring. Bug name: "ওরা আসে, খায়, চলে যায়" Error Message: "No constructor with 0 arguments defined in class 'org.springframework.hateoas.config.ConverterRegisteringWebMvcConfigurer'"
	@Autowired
	private FavouriteJobsService favJobService;
	
	/**
	 * Constructor: Instantiate FavouriteJobs object inside (has a relation)
	 * @param FavouriteJobs instance.
	 */
//	@Autowired
//	public FavouriteJobsController(FavouriteJobsService favJobService) {
//		this.favJobService = favJobService;
//	}
	
	/**
	 * get a single instance of FavouriteJob matching id;
	 * @param Long id
	 * @return FavouriteJobs favJob;
	 */
	@RequestMapping(value ="/{id}", method = RequestMethod.GET, produces = { "application/hal+json" })
	public FavouriteJobs getFavJob(@PathVariable Long id) {
		FavouriteJobs favJob = null;
		try {
			favJob = favJobService.getFavJobById(id);
		} catch(Exception e) {
			throw new ObjectNotFoundException("FavouriteJob is  not found by id"+id);
		}
		
		if(favJob != null) {
			Link selfLink = linkTo(FavouriteJobsController.class).slash(favJob.getFavJobId()).withSelfRel();
			favJob.add(selfLink);
		}
		
		return favJob;
	}
	

	/**
	 * get a List of FavouriteJob matching doctorId;
	 * @param Long id
	 * @return List<FavouriteJobs> favJob;
	 */
	@RequestMapping(value ="/doctorId/{docId}", method = RequestMethod.GET, produces = { "application/hal+json" })
	public List<FavouriteJobs> getFavJobsByDocId(@PathVariable Long docId) {
		List<FavouriteJobs> favJobs = null;
		try {
			favJobs = favJobService.getFavJobsByDocId(docId);
		} catch(Exception e) {
			throw new ObjectNotFoundException("FavouriteJob is not found by doctor Id: "+ docId);
		}		
		
		if(favJobs.isEmpty() || favJobs != null) {			
			for(FavouriteJobs favJob: favJobs) {
				Link selfLink = linkTo(FavouriteJobsController.class).slash(favJob.getFavJobId()).withSelfRel();
				favJob.add(selfLink);
			}
		}
		
		return favJobs;
	}
	
	/**
	 * get a list of FavouriteJob matching jobCode but ignoring case.
	 * @param String jobCode
	 * @return List<FavouriteJobs> favJobs;
	 */
	@RequestMapping(value ="/jobCode/{jobCode}", method = RequestMethod.GET, produces = { "application/hal+json" })
	public List<FavouriteJobs> getFavJobsByJobCode(@PathVariable String jobCode) {
		List<FavouriteJobs> favJobs = null;
		try {
			favJobs = favJobService.getFavJobsByJobCode(jobCode);
		} catch(Exception e) {
			throw new ObjectNotFoundException("FavouriteJob is not found by job code: " +jobCode);
		}		
		
		if( favJobs.isEmpty() || favJobs != null) {
			
			for(FavouriteJobs favJob: favJobs) {
				Link selfLink = linkTo(FavouriteJobsController.class).slash(favJob.getFavJobId()).withSelfRel();
				favJob.add(selfLink);
			}
		}
		
		return favJobs;
	}
	
	/**
	 * get a list of FavouriteJob matching hospitalCode but ignoring case.
	 * @param String hospitalCode
	 * @return List<FavouriteJobs> favJobs;
	 */
	@RequestMapping(value ="/hospitalCode/{hospitalCode}", method = RequestMethod.GET, produces = { "application/hal+json" })
	public List<FavouriteJobs> getFavJobsByHospitalCode(@PathVariable String hospitalCode) {
		List<FavouriteJobs> favJobs = null;
		try {
			favJobs = favJobService.getFavJobsByHospitalCode(hospitalCode);
		} catch(Exception e) {
			throw new ObjectNotFoundException("FavouriteJob is found by hospital code: " + hospitalCode);
		}		
		
		if(favJobs.isEmpty() || favJobs != null) {
			
			for(FavouriteJobs favJob: favJobs) {
				Link selfLink = linkTo(FavouriteJobsController.class).slash(favJob.getFavJobId()).withSelfRel();
				favJob.add(selfLink);
			}
		}
		
		return favJobs;
	}
	
	/**
	 * get a list of FavouriteJob matching hospitalName but ignoring case
	 * @param String hospitalName
	 * @return List<FavouriteJobs> favJobs;
	 */
	@RequestMapping(value ="/hospitalName/{hospitalName}", method = RequestMethod.GET, produces = { "application/hal+json" })
	public List<FavouriteJobs> getFavJobsByHospitalName(@PathVariable String hospitalName) {
		List<FavouriteJobs> favJobs = null;
		try {
			favJobs = favJobService.getFavJobsByHospitalName(hospitalName);
		} catch(Exception e) {
			throw new ObjectNotFoundException("FavouriteJob is found by hospital name: " + hospitalName);
		}		
		
		if(favJobs.isEmpty() || favJobs != null) {
			
			for(FavouriteJobs favJob: favJobs) {
				Link selfLink = linkTo(FavouriteJobsController.class).slash(favJob.getFavJobId()).withSelfRel();
				favJob.add(selfLink);
			}
		}
		
		return favJobs;
	}
	
	/**
	 * get all the instance of FavouriteJob.
	 * @return list<Favourite
	 */
	@RequestMapping(value = "/list/", method = RequestMethod.GET, produces = {"application/hal+json"})
	public List<FavouriteJobs> getAllFavJobs(){
		List<FavouriteJobs> favJobsList = null;
		try {
			favJobsList = favJobService.getAllFavJobs();
		} catch(Exception e) {
			//TODO: Exception Handle
		}
		
		return favJobsList;
	}
	
	/**
	 * Insert a single instance of FavouriteJob.
	 * @param FavouriteJobs favJob
	 */
	@RequestMapping(value = "/add", method = RequestMethod.POST)
	public void addFavouriteJob(@RequestBody FavouriteJobs favJob) {
		try {
			favJobService.addNewFavouriteJob(favJob);
		} catch(Exception e) {
			throw new ServerErrorException(e.getMessage());
		}
	}
	
	/**
	 * Update Method: update a single instance of FavouriteJobs of given favJobId with given valid data. 
	 * @param Long favJobId
	 * @param FavouriteJobs favJob
	 */
	@RequestMapping(value = "/update/{favJobId}/", method = RequestMethod.PUT)
	public void updateFavouriteJob(@PathVariable Long favJobId, @RequestBody FavouriteJobs favJob) {
		try {
			favJobService.updateFavouriteJob(favJobId, favJob);
		} catch(Exception e) {
			//TODO: Exception to be handle
		}
	}
	
	/**
	 * Delete Method: delete a single instance of FavouriteJobs of given favJobId with given valid data.
	 * @param favJobId
	 */
	@RequestMapping(value = "/delete/{favJobId}", method = RequestMethod.DELETE)
	public void deleteFavouriteJob(@PathVariable Long favJobId) {
		try {
			favJobService.deleteFavouriteJob(favJobId);
		} catch(Exception e) {
			//TODO: Exception to be handle
		}
	}	
}//End of the class
