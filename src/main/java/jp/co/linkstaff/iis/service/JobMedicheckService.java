package jp.co.linkstaff.iis.service;

import java.util.Arrays;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import jp.co.linkstaff.iis.model.JobMedicheck;
import jp.co.linkstaff.iis.repository.JobMedicheckRepository;
import jp.co.linkstaff.iis.utils.OperationType;
import jp.co.linkstaff.iis.utils.QueryHelper;
import jp.co.linkstaff.iis.utils.ServerErrorException;
/**
 * 
 * @author Roy
 *
 */
@Service
public class JobMedicheckService {
	private static final Logger logger = LogManager.getLogger(JobMedicheckService.class);
	private JobMedicheckRepository jobRepository;
	/**
	 * 
	 * @param jobRepository
	 */
	@Autowired
    public JobMedicheckService(JobMedicheckRepository jobRepository) {
    	this.jobRepository = jobRepository;
    }

	/**
	 * persist job info according job instance
	 * @param job
	 */
	public void addNewJob(JobMedicheck job){
		jobRepository.save(job);
	}
	/**
	 * Get complete list of medicheckjob
	 * @return List<JobMedicheck
	 */
	public List<JobMedicheck> getAllJobs() {
		List<JobMedicheck> list = (List<JobMedicheck>)jobRepository.findAll();
		return list;
		}
	/**
	 * Get single instance of medicheck job info matching id
	 * @param id
	 * @return medi jobs
	 */
	public JobMedicheck getJobMedicheck(Long id) {
		boolean isDataExist = false;
		JobMedicheck medi = null;
		try {
			isDataExist = jobRepository.findById(id).isPresent();
			medi = isDataExist ? jobRepository.findById(id).get() : null;
		} catch (Exception e) {
			logger.error("JobMedicheckService.'\n' Method: getJobMedicheck() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
		return medi;
	}
	/**
	 * Update a single instance
	 * @param job
	 * @param id
	 */
	public void updateJob(JobMedicheck job, Long id) {		
		try {
			job.setMedicheckJobId(id);
			jobRepository.save(job);
		} catch (Exception e) {
			logger.error("JobMedicheckService.\n Method: updateJob() \n Error Details:" + e.getMessage());
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
			logger.error("JobMedicheckService.\n Method: deleteJob() \n Error Details:" + e.getMessage());
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
	public Page<JobMedicheck> searchJobs(@Nullable String[] stations,@Nullable String[] prefs,
            @Nullable String[] contents,@Nullable String[] subjects,
			@Nullable String keyword,@Nullable String[] shiftpatterns,
			@Nullable String[] workdates,@Nullable String[] workdays,
			boolean ispublic, Pageable pageable) {
				List<String> station = null,pref = null,workdate = null;
				String content = null,subject = null,workday = null,shiftpattern = null;
					 
	
				Page<JobMedicheck> jobs = null;
				
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
				
				if(shiftpatterns != null) {
					shiftpattern = QueryHelper.CreateQuery("",OperationType.TSVECTOR, shiftpatterns);
				}
				if(workdays != null) {
					workday = QueryHelper.CreateQuery("",OperationType.TSVECTOR, workdays);//QueryHelper.CreateQuery("",OperationType.TSVECTOR, subjects);
				}
				if(workdates != null) {
					//workday = QueryHelper.CreateQuery("",OperationType.TSVECTOR, workdays);//QueryHelper.CreateQuery("",OperationType.TSVECTOR, subjects);
					workdate = Arrays.asList(workdates);
				}
				if(workdays != null) {
					workday = QueryHelper.CreateQuery("",OperationType.TSVECTOR, workdays);//QueryHelper.CreateQuery("",OperationType.TSVECTOR, subjects);
				}
				if(keyword != null) {
					keyword = QueryHelper.CreateQuery("",OperationType.TSVECTOR, keyword.split(" "));
				}
				
			try { 
				jobs = jobRepository.searchJobs(keyword,station, pref,content,subject,shiftpattern,workdate,workday, pageable);
			}
			catch(Exception ex) {
				logger.error("JobSpotService.'\n' Method: searchJobs(..) '\n' Error Details:" + ex.getMessage());
				throw new ServerErrorException(ex.getMessage());
			}
			return jobs;
	}
}
