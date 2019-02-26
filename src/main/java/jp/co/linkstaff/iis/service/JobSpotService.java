package jp.co.linkstaff.iis.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;

import jp.co.linkstaff.iis.model.JobSpot;
import jp.co.linkstaff.iis.repository.JobSpotRepository;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.utils.Util;
import java.util.Date;
/**
 * 
 * @author Roy
 *
 */
@Service
public class JobSpotService {
	private static final Logger logger = LogManager.getLogger(JobSpotService.class);
	private JobSpotRepository jobRepository;

	/**
	 * 
	 * @param jobRepository
	 */
	@Autowired
	public JobSpotService(JobSpotRepository jobRepository) {
		this.jobRepository = jobRepository;
	}

	/**
	 * save job info
	 * 
	 * @param job
	 */
	public void addNewJob(JobSpot job) {
		jobRepository.save(job);
	}

	/**
	 * Get complete list of spotJobs
	 * 
	 * @return List<JobSpot
	 */
	public List<JobSpot> getAllJobs() {
		List<JobSpot> list = (List<JobSpot>) jobRepository.findAll();
		return list;
	}

	/**
	 * Get single instance of spot matching id
	 * 
	 * @param id
	 * @return spot
	 */
	public JobSpot getJobSpot(Long id) {
		boolean isDataExist = false;
		JobSpot spot = null;
		try {
			isDataExist = jobRepository.findById(id).isPresent();
			spot = isDataExist ? jobRepository.findById(id).get() : null;
		} catch (Exception e) {
			logger.error("JobSpotService.'\n' Method: getJobSpot() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
		return spot;
	}

	/**
	 * Update a single instance
	 * 
	 * @param job
	 * @param id
	 */
	public void updateJob(JobSpot job, Long id) {
		try {
			job.setSpotJobId(id);
			jobRepository.save(job);
		} catch (Exception e) {
			logger.error("JobSpotService.\n Method: updateJob() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}

	/**
	 * Delete a single instance
	 * 
	 * @param id
	 */
	public void deleteJob(Long id) {
		try {
			jobRepository.deleteById(id);
		} catch (Exception e) {
			logger.error("JobSpotService.\n Method: deleteJob() \n Error Details:" + e.getMessage());
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
	public Page<JobSpot> searchJobs(@Nullable String[] stations, @Nullable String[] prefs, @Nullable String contents,
			@Nullable String subjects, @Nullable String keyword, @Nullable String[] hospitalSystems,
			@Nullable String[] emergencies, @Nullable String shiftpatterns, @Nullable String[] spotdates,
			boolean ispublic, Pageable pageable) {
		Collection<String> station = null, pref = null;
		Collection<Date> spotdate = null;
		String content = null, subject = null, shiftpattern = null, hospitalSystem = null, emergency = null;

		Page<JobSpot> jobs = null;

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
		// if (hospitalSystems != null) {
		// 	hospitalSystem = QueryHelper.CreateQuery("", OperationType.TSVECTOR, hospitalSystems);
		// 	// QueryHelper.CreateQuery("h.hospital_system",OperationType.LIKE,
		// 		// hospitalSystems);
		// }
		// if (emergencies != null) {
		// 	emergency = QueryHelper.CreateQuery("", OperationType.TSVECTOR, emergencies);// QueryHelper.CreateQuery("",OperationType.TSVECTOR,
		// 																					// subjects);
		// }
		if (shiftpatterns != null) {
			shiftpattern = shiftpatterns;//QueryHelper.CreateQuery("", OperationType.LIKE, shiftpatterns);
		}
		if (spotdates != null) {
			// workday = QueryHelper.CreateQuery("",OperationType.TSVECTOR,
			// workdays);//QueryHelper.CreateQuery("",OperationType.TSVECTOR, subjects);
			spotdate = new ArrayList<Date>();
			for (String t : spotdates) {
				spotdate.add(Util.getFormatedDate(t));
			}
			// spotdate = Arrays.asList(spotdates);
		}
		// if (keyword != null) {
		// 	keyword = QueryHelper.CreateQuery("", OperationType.TSVECTOR, keyword.split(" "));
		// }else{
		// 	keyword = "";
		// }

		try {
			jobs = jobRepository.searchJobsCustom(ispublic,keyword, station, pref, content, subject,shiftpattern, spotdate, pageable);
		    //jobs = jobRepository.findBySearchKeywordLikeOrWorkStationCode1In(keyword,station);
		} catch (Exception ex) {
			logger.error("JobSpotService.'\n' Method: searchJobs(..) '\n' Error Details:" + ex.getMessage());
			throw new ServerErrorException(ex.getMessage());
		}
		return jobs;
	}
}