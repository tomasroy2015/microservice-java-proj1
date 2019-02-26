package jp.co.linkstaff.iis.service;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.Nullable;
import org.apache.logging.log4j.LogManager;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import jp.co.linkstaff.iis.model.JobFulltime;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import jp.co.linkstaff.iis.repository.JobFulltimeRepository;
/**
 * 
 * @author Roy
 *
 */
@Service
public class JobFulltimeService {
	private static final Logger logger = LogManager.getLogger(JobFulltimeService.class);
	private JobFulltimeRepository jobRepository;
	/**
	 * 
	 * @param jobRepository
	 */
	@Autowired
    public JobFulltimeService(JobFulltimeRepository jobRepository) {
    	this.jobRepository = jobRepository;
    }
	
	/**
	 * save job info
	 * @param job
	 */
	public void addNewJob(JobFulltime job){
		jobRepository.save(job);
	}	
	/**
	 * Get complete list of FullTimeJobs
	 * @return List<JobFulltime
	 */
	public List<JobFulltime> getAllJobs() {
		List<JobFulltime> list = (List<JobFulltime>)jobRepository.findAll();
		return list;
		}	
	/**
	 * Get single instance of FullTimeJobs matching id
	 * @param Long id
	 * @return full
	 */
	public JobFulltime getJobFulltime(Long id) {
		boolean isDataExist = false;
		JobFulltime full = null;
		try {
			isDataExist = jobRepository.findById(id).isPresent();
			full = isDataExist ? jobRepository.findById(id).get() : null;
		} catch (Exception e) {
			logger.error("JobFulltimeService.'\n' Method: getJobFulltime() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
		return full;
	}
	/**
	 * Update a single instance
	 * @param job
	 * @param id
	 */
	public void updateJob(JobFulltime job, Long id) {		
		try {
			job.setFulltimeJobId(id);
			jobRepository.save(job);
		} catch (Exception e) {
			logger.error("JobFulltimeService.\n Method: updateJob() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * Delete a single instance
	 * @param id
	 */
	public void deleteJob(Long id) {		
		try {
			jobRepository.deleteById(id);
		} catch (Exception e) {
			logger.error("JobFulltimeService.\n Method: deleteJob() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
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
	 * @param pageable
	 * @return jobs
	 */
	public Page<JobFulltime> searchJobs(@Nullable String keyword,@Nullable String[] stations, @Nullable String[] prefs, @Nullable String contents, @Nullable String subjects,
	      boolean ispublic, Pageable pageable) {
			Collection<String> station = null, pref = null;
			String content = null, subject = null;
	
			Page<JobFulltime> jobs = null;
	
			if (stations != null) {
				station = Arrays.asList(stations);// QueryHelper.CreateQuery("", OperationType.TSVECTOR, stations);
			}
			if (prefs != null) {
				pref = Arrays.asList(prefs);// QueryHelper.CreateQuery("",OperationType.TSVECTOR, prefs);
			}
			if (contents != null) {
				content = contents; //QueryHelper.CreateQuery("", OperationType.LIKE, contents);
			}
			if (subjects != null) {
				subject = subjects; //QueryHelper.CreateQuery("", OperationType.LIKE, subjects);
			}
			
		try { 
			jobs = jobRepository.searchJobsCustom(keyword,station, pref,content,subject,ispublic,pageable);
		}
		catch(Exception ex) {
			logger.error("JobFulltimeService.'\n' Method: searchJobs(..) '\n' Error Details:" + ex.getMessage());
			throw new ServerErrorException(ex.getMessage());
		}
		return jobs;
	}
}
