package jp.co.linkstaff.iis.service;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.data.domain.Page;
import jp.co.linkstaff.iis.model.WorkContent;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.repository.WorkContentRepository;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
 * @author Roy
 *
 */
@Service
public class WorkContentService {
	private static final Logger logger = LogManager.getLogger(WorkContentService.class);	
	@Autowired
	private WorkContentRepository workRepository;
	/**
	 * 
	 * @param workRepository
	 */
	// @Autowired
	// public WorkContentService(WorkContentRepository workRepository) {
	// 	this.workRepository = workRepository;
	// }
	/**
	 * add new work content 
	 * @param work
	 */
	public WorkContent addNewWork(WorkContent work) {
		try {
			return workRepository.save(work);
		} catch (Exception e) {
			logger.error("WorkContentService.'\n' Method: addNewWork() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * fetch work content list
	 * @return List<WorkContent
	 */
	public List<WorkContent>getAllWork() {
		List<WorkContent> list = (List<WorkContent>) workRepository.findAll();
		return list;
	}
	/**
	 * fetch single work content info according id
	 * @param id
	 * @return work
	 */
	public WorkContent getWork(Long workcontentId) {
		//boolean isDataExist = false;
		WorkContent work = null;
		try {
			//isDataExist = areaRepository.findById(id).isPresent();
			work = workRepository.findById(workcontentId).get();
		} catch (Exception e) {
			logger.error("WorkContentService.'\n' Method: getWork() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
		return work;
	}
	
	
	/**
	 * update work content info
	 * @param work
	 * @param id
	 */
	public WorkContent updateWork(WorkContent work, Long workcontentId) {		
		try {
			work.setWorkcontentId(workcontentId);
			return workRepository.save(work); 
		} catch (Exception e) {
			logger.error("WorkContentService.\n Method: updateWork() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * delete a particular work content info according id 
	 * @param id
	 */
	public void deleteWork(Long workcontentId) {		
		try {
			workRepository.deleteById(workcontentId);
		} catch (Exception e) {
			logger.error("WorkContentService.\n Method: deleteWork() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * 
	 * @param pageable
	 * @return work content list
	 */
	public Page<WorkContent> searchJobs(Pageable pageable) {
		return workRepository.findAll(pageable);
	}
}
