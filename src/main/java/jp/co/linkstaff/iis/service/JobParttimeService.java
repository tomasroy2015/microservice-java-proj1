package jp.co.linkstaff.iis.service;

import java.util.Arrays;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.springframework.lang.Nullable;
import org.apache.logging.log4j.LogManager;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import jp.co.linkstaff.iis.utils.QueryHelper;
import jp.co.linkstaff.iis.model.JobParttime;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.utils.OperationType;
import org.springframework.beans.factory.annotation.Autowired;
import jp.co.linkstaff.iis.repository.JobParttimeRepository;
/**
 * 
 * @author Roy
 *
 */
@Service
public class JobParttimeService {
	private static final Logger logger = LogManager.getLogger(JobParttimeService .class);
	@Autowired
	private JobParttimeRepository jobRepository;
	
	/**
	 * 
	 * @param jobRepository
	 */
//	@Autowired
//    public JobParttimeService(JobParttimeRepository jobRepository) {
//    	this.jobRepository = jobRepository;
//    }
	/**
	 * save job info
	 * @param job
	 */
	public void addNewJob(JobParttime job){
		jobRepository.save(job);
	}
	/**
	 * Get complete list of ParttimeJobs
	 * @return List<JobParttime
	 */
	public List<JobParttime> getAllJobs() {
		List<JobParttime> list = (List<JobParttime>)jobRepository.findAll();
		return list;
		}	
	/**
	 * 
	 * @param id
	 * @return part
	 */
	public JobParttime getJobParttime(Long id) {
		boolean isDataExist = false;
		JobParttime part = null;
		try {
			isDataExist = jobRepository.findById(id).isPresent();
			part = isDataExist ? jobRepository.findById(id).get() : null;
		} catch (Exception e) {
			logger.error("JobParttimeService.'\n' Method: getParttime() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
		return part;
	}
	/**
	 * Update a single instance
	 * @param job
	 * @param id
	 */
	public void updateJob(JobParttime job, Long id) {		
		try {
			job.setParttimeJobId(id);
			jobRepository.save(job);
		} catch (Exception e) {
			logger.error("JobParttimeService.\n Method: updateJob() \n Error Details:" + e.getMessage());
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
			logger.error("JobParttimeService.\n Method: deleteJob() \n Error Details:" + e.getMessage());
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
	public Page<JobParttime> searchJobs(@Nullable String[] stations,@Nullable String[] prefs,
            @Nullable String[] contents,@Nullable String[] subjects,
            @Nullable String keyword,@Nullable String[] hospitalSystems,@Nullable String[] emergencies,
            @Nullable String[] shiftpatterns,@Nullable String[] workdays, boolean ispublic, Pageable pageable) {
			List<String> station = null,pref = null;
			String content = null,subject = null,shiftpattern = null,
					workday = null,hospitalSystem = null,emergency = null;

			Page<JobParttime> jobs = null;
			
			if(stations != null) {
				station = Arrays.asList(stations);//QueryHelper.CreateQuery("", OperationType.TSVECTOR, stations);
			}
			if(prefs != null) {
				pref = Arrays.asList(prefs);//QueryHelper.CreateQuery("",OperationType.TSVECTOR, prefs);
			}
			if(contents != null) {
				content = QueryHelper.CreateQuery("",OperationType.TSVECTOR, contents);
			}
			if(subjects != null) {
				subject = QueryHelper.CreateQuery("",OperationType.TSVECTOR, subjects);
			}
			if(hospitalSystems != null) {
				hospitalSystem = QueryHelper.CreateQuery("",OperationType.TSVECTOR, hospitalSystems);;//QueryHelper.CreateQuery("h.hospital_system",OperationType.LIKE, hospitalSystems);
			}
			if(emergencies != null) {
				emergency = QueryHelper.CreateQuery("",OperationType.TSVECTOR, emergencies);//QueryHelper.CreateQuery("",OperationType.TSVECTOR, subjects);
			}
			if(shiftpatterns != null) {
				shiftpattern = QueryHelper.CreateQuery("",OperationType.TSVECTOR, shiftpatterns);
			}
			if(workdays != null) {
				workday = QueryHelper.CreateQuery("",OperationType.TSVECTOR, workdays);//QueryHelper.CreateQuery("",OperationType.TSVECTOR, subjects);
			}
			if(keyword != null) {
				keyword = QueryHelper.CreateQuery("",OperationType.TSVECTOR, keyword.split(" "));
			}
			
		try { 
			jobs = jobRepository.searchJobs(keyword,station, pref,content,subject,hospitalSystem,emergency,shiftpattern,workday, pageable);
		}
		catch(Exception ex) {
			logger.error("JobParttimeService.'\n' Method: searchJobs(..) '\n' Error Details:" + ex.getMessage());
			throw new ServerErrorException(ex.getMessage());
		}
		return jobs;
	}
}