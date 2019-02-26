package jp.co.linkstaff.iis.service;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;
import jp.co.linkstaff.iis.model.JobShiftPattern;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import jp.co.linkstaff.iis.repository.JobShiftPatternRepository;
/**
 * 
 * @author .....
 *
 */
@Service
public class JobShiftPatternService {
	
	private static final Logger logger = LogManager.getLogger(JobShiftPatternService.class);
	@Autowired
	private JobShiftPatternRepository jobShiftPatternRepository;
	/**
	 * add new instance of jobShiftPattern using save method
	 * @param jobShiftPattern
	 */
	public JobShiftPattern addNewJobShiftPattern(JobShiftPattern jobShiftPattern) {
		try {
			return jobShiftPatternRepository.save(jobShiftPattern);
		} catch (Exception e) {
			logger.error("JobShiftPatternService.'\n' Method: addNewJobShiftPattern() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}		
	}
	/**
	 * get all JobShiftPattern list including soft delete
	 * @return list
	 */
	public List<JobShiftPattern> getAllJobShiftPattern() {
		List<JobShiftPattern> list = (List<JobShiftPattern>) jobShiftPatternRepository.findAll();
		return list;
	}
	 /**
     * get those JobShiftPattern which is not deleted
     * @return shift
     */
	public List<JobShiftPattern> getAllOriginalJobShiftPattern(){
		List<JobShiftPattern> shift = null;
		try {
			shift = jobShiftPatternRepository.findByIsDeleted(false); 
		} catch (Exception e) {			
			throw new ServerErrorException("Exception occured at Service in getAllOriginalJobShiftPattern(). "+e);	
		}		
		return shift;
	}
	/**
	 * we can get jobShiftPattern against jobShiftPatternId
	 * @param jobShiftPatternId
	 * @return jobShiftPattern
	 */
	public JobShiftPattern getJobShiftPattern(Long jobShiftPatternId) {
		JobShiftPattern jobShiftPattern = null;
		try {
			jobShiftPattern = jobShiftPatternRepository.findById(jobShiftPatternId).get();
		} catch (Exception e) {
			logger.error("JobShiftPatternService.'\n' Method: getHospitalBed() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
		return jobShiftPattern;
	}
	/**
	 * we can update single instance against jobShiftPatternId
	 * @param jobShiftPattern
	 * @param jobShiftPatternId
	 */
	public JobShiftPattern updateJobShiftPattern(JobShiftPattern jobShiftPattern, Long jobShiftPatternId){		
		try {
			jobShiftPattern.setJobShiftPatternId(jobShiftPatternId);
			return jobShiftPatternRepository.save(jobShiftPattern);
		} catch (Exception e) {
			logger.error("JobShiftPatternService.\n Method: updateJobShiftPattern() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * we will no delete any data permanently
	 * first get all ShiftPattern list which is not deleted
	 * after that set isDeleted field = true(for our understanding that this data is deleted)
	 * @param jobShiftPatternId
	 */
	public void deleteJobShiftPattern(Long jobShiftPatternId) {		
		JobShiftPattern jobShiftPattern = null;
		try {		
			jobShiftPattern = jobShiftPatternRepository.findByIsDeletedAndJobShiftPatternId(false, jobShiftPatternId);				
		} catch (Exception e) {
			throw new ServerErrorException("Exception occured at Service in deleteJobShiftPattern(). "+e);
		}
		if( jobShiftPattern != null) {
			jobShiftPattern.setIsDeleted(true);
			try {				
				jobShiftPatternRepository.save(jobShiftPattern);				
			} catch(Exception e) {
				throw new ServerErrorException("Exception occured at Service in deleteJobShiftPattern (). "+e);
			}			
		} else {
			logger.error(String.format("JobShiftPattern by id: %d is not found.\nHence, cannot be deleted.", jobShiftPatternId));
		}		
	}

}
