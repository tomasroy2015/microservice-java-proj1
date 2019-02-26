package jp.co.linkstaff.iis.service;

import org.apache.logging.log4j.Logger;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;

import jp.co.linkstaff.iis.model.FavouriteJobs;
import jp.co.linkstaff.iis.repository.FavouriteJobsRepository;


@Service
public class FavouriteJobsService {
	private static final Logger logger = LogManager.getLogger(FavouriteJobsService.class);
	private FavouriteJobsRepository favJobsRepository;
	
	public FavouriteJobsService(FavouriteJobsRepository favJobsRepository) {
		this.favJobsRepository  = favJobsRepository;
	}

	/**
	 * Get single instance of FavouriteJobs matching id
	 * @param id
	 * @return FavouriteJobs favJob
	 */
	public FavouriteJobs getFavJobById(Long id) {
		FavouriteJobs favJob = null;
		
		try {
			favJob = favJobsRepository.findById(id).get();
		} catch(Exception e) {
			//TODO: Handle exception
		}
		
		return favJob; 
	}

	/**
	 * Find List of favourite jobs by doctorId
	 * @param Long id
	 * @return List<favouriteJobs>
	 */
	public List<FavouriteJobs> getFavJobsByDocId(Long id) {
		List<FavouriteJobs> favJobs = null;
		
		try {
			favJobs = (List<FavouriteJobs>) favJobsRepository.findByDoctorId(id);
		} catch(Exception e) {
			//TODO: Handle exception
		}
		
		return favJobs; 		
	}
	
	/**
	 * Get a list of FavouriteJobs matching jobCode with ignoring case.
	 * @param String jobCode
	 * @return
	 */
	public List<FavouriteJobs> getFavJobsByJobCode(String jobCode){
		List<FavouriteJobs> favJobs = null;
		
		try {
			favJobs = (List<FavouriteJobs>) favJobsRepository.findByJobCodeIgnoreCase(jobCode);
		} catch(Exception e) {
			//TODO: handle Exception
		}
		
		return favJobs;
	}
	
	/**
	 * Get a list of FavouriteJobs matching hospitalCode with ignoring case.
	 * @param hospitalCode
	 * @return List<FavouriteJobs> favJobs
	 */
	public List<FavouriteJobs> getFavJobsByHospitalCode(String hospitalCode){
		List<FavouriteJobs> favJobs = null;
		
		try {
			favJobs = (List<FavouriteJobs>) favJobsRepository.findByHospitalCodeIgnoreCase(hospitalCode);
		} catch(Exception e) {
			//TODO: handle Exception
		}
		
		return favJobs;
	}
	
	/**
	 * Get a list of FavouriteJobs matching hospitalCode with ignoring case.
	 * @param hospitalName
	 * @return List<FavouriteJobs> favJobs
	 */
	public List<FavouriteJobs> getFavJobsByHospitalName(String hospitalName){
		List<FavouriteJobs> favJobs = null;
		
		try {
			favJobs = (List<FavouriteJobs>) favJobsRepository.findByHospitalNameIgnoreCase(hospitalName);
		} catch(Exception e) {
			//TODO: handle Exception
		}
		
		return favJobs;
	}

	/**
	 * Get complete list of FavouriteJobs.
	 * @return List<FavouriteJobs> favJobsList
	 */
	public List<FavouriteJobs> getAllFavJobs() {		
		List<FavouriteJobs> favJobsList = null;
		
		try {
			favJobsList = (List<FavouriteJobs>) favJobsRepository.findAll();
		} catch(Exception e) {
			//TODO: Handle Exception
		}
		
		return favJobsList;
	}

	/**
	 * Insert a single instance of FavouriteJobs.
	 * @param FavouriteJobs favJob
	 */
	public void addNewFavouriteJob(FavouriteJobs favJob) {
		try {
			favJobsRepository.save(favJob);
		} catch(Exception e) {
			logger.error("FavouriteJobsService.'\n' Method: addNewFavouriteJob(..) '\n' Error Details:" + e.getMessage());
		}	
	}
	
	/**
	 * Update a single instance of FavouriteJobs of give favJobId.
	 * Check ORM if the given instance exist and try to update.
	 * if not possible produces error message.
	 * @param favJobId
	 * @param favJob
	 */
	public void updateFavouriteJob(Long favJobId, FavouriteJobs favJob) {
		if(favJobsRepository.findById(favJobId).isPresent()) {
			favJob.setFavJobId(favJobId);		
			try {
				favJobsRepository.save(favJob);
			} catch (Exception e) {
				logger.error("FavouriteJobsService.'\n' Method: updateFavouriteJob(..) '\n' Error Details:" + e.getMessage());
			}			
		} else {
			logger.error(String.format("FavouriteJob by id: %d is not found.\nHence, cannot be updated.", favJobId));
		}
	}
	
	/**
	 * Delete a single instance of FavouriteJobs of give favJobId.
	 * Check ORM if the given instance exist and try to delete.
	 * if not possible produces error message.
	 * @param favJobId
	 */
	public void deleteFavouriteJob(Long favJobId) {
		
		if (favJobsRepository.findById(favJobId).isPresent()) {
			try {
				favJobsRepository.deleteById(favJobId);				
			} catch (Exception e) {
				logger.error("FavouriteJobsService.'\n' Method: delete() '\n' Error Details:" + e.getMessage());
			}			
		} else {
			logger.error(String.format("FavouriteJob by id: %d is not found.\nHence, cannot be deleted.", favJobId));
		}
	}
}//End of the class
