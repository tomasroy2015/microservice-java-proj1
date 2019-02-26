package jp.co.linkstaff.iis.service;

import java.util.List;
import org.apache.logging.log4j.Logger;
import jp.co.linkstaff.iis.model.Subject;
import org.apache.logging.log4j.LogManager;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.repository.SubjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
 * @author Roy
 *
 */
@Service
public class SubjectService {
	private static final Logger logger = LogManager.getLogger(SubjectService.class);
	@Autowired
	private SubjectRepository subjectRepository;
	/**
	 * 
	 * @param subjectRepository
	 */
	// @Autowired
	// public SubjectService( SubjectRepository subjectRepository) {
	// 	this.subjectRepository = subjectRepository;
	// }
	/**
	 * add a new subject info 
	 * @param subject
	 */
	public Subject addNewSubject(Subject subject) {
		try {
			return subjectRepository.save(subject);
		 } catch (Exception e) {
		 	logger.error("SubjectService.'\n' Method: addNewSubject() '\n' Error Details:" + e.getMessage());
		 	throw new ServerErrorException(e.getMessage());
		 }
	}	
	/**
	 * fetch total subject list
	 * @return list
	 */
	public List<Subject> getAllSubject() {
		List<Subject> list = (List<Subject>) subjectRepository.findAll();
		return list;
	}
	/**
	 * fetch subject info according subject subjectId 
	 * @param id
	 * @return subject
	 */
	public Subject getSubject(Long subjectId) {
		boolean isDataExist = false;
		Subject subject = null;
		try {
			isDataExist = subjectRepository.findById(subjectId).isPresent();
			subject = isDataExist ? subjectRepository.findById(subjectId).get() : null;
		} catch (Exception e) {
			logger.error("SubjectService.'\n' Method: getSubject() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
		return subject;
	}
	/**
	 * update sebject information
	 * @param subject
	 * @param id
	 */
	public Subject updateSubject(Subject subject, Long subjectId) {		
		try {
			subject.setSubjectId(subjectId);
			return subjectRepository.save(subject);
		} catch (Exception e) {
			logger.error("SubjectService.\n Method: updateSubject() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * delete a particular subject info according id
	 * @param id
	 */
	public void deleteSubject(Long subjectId) {		
		try {
			subjectRepository.deleteById(subjectId);
		} catch (Exception e) {
			logger.error("SubjectService.\n Method: deleteSubject() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * 
	 * @param pageable
	 * @return sebject list
	 */
	public Page<Subject> searchJobs(Pageable pageable) {
		return subjectRepository.findAll(pageable);
	}
}