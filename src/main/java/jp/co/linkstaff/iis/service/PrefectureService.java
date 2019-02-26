package jp.co.linkstaff.iis.service;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.data.domain.Page;
import jp.co.linkstaff.iis.model.Prefecture;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.repository.PrefectureRepository;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * 
 * @author .....
 *
 */
@Service
public class PrefectureService {	
	private static final Logger logger = LogManager.getLogger(PrefectureService.class);	
	@Autowired
	private PrefectureRepository prefectureRepository;
	/**
	 * 
	 * @param prefectureRepository
	 */
	// @Autowired
	// public PrefectureService( PrefectureRepository prefectureRepository) {
	// 	this. prefectureRepository = prefectureRepository;
	// }
	/**
	 * add a particular prefecture with area 
	 * @param pref_code
	 * @param name
	 * @param area
	 */
	/*public void addNewPrefecture(String pref_code,String name, Area area) {
		try {
			Prefecture pref = new Prefecture(pref_code, name, area);
			prefectureRepository.save(pref);
		} catch (Exception e) {
			logger.error("PrefectureService.'\n' Method: addNewPrefecture() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}*/
	/**
	 * save prefecture info
	 * @param pref
	 */
	public Prefecture savePrefecture(Prefecture pref) {
		try {
			return prefectureRepository.save(pref);
		} catch (Exception e) {
			logger.error("PrefectureService.'\n' Method: addNewPrefecture() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * 
	 * @return prefecture list
	 */
	public List<Prefecture> getAllPrefecture() {
		try {
			return (List<Prefecture>) prefectureRepository.findByIsDeleted(false);
		}catch (Exception e) {
			logger.error("PrefectureService.'\n' Method: addNewPrefecture() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * fetch a particular prefecture according id
	 * @param prefectureId
	 * @return prefecture
	 */
	public Prefecture getPrefecture(Long prefectureId) {
		boolean isDataExist = false;
		Prefecture prefecture = null;
		try {
			isDataExist = prefectureRepository.findById(prefectureId).isPresent();
			prefecture = isDataExist ? prefectureRepository.findById(prefectureId).get() : null;
		} catch (Exception e) {
			logger.error("PrefectureService.'\n' Method: getPrefecture() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
		return prefecture;
	}
	
	/**
	 * update prefecture info
	 * @param prefecture
	 * @param prefectureId
	 */
	public Prefecture updatePrefecture(Prefecture prefecture, Long prefectureId) {		
		try {
			prefecture.setPrefectureId(prefectureId);
			return prefectureRepository.save(prefecture);
		} catch (Exception e) {
			logger.error("PrefectureService.\n Method: updatePrefecture() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * delete a particular prefecture against prefecture id 
	 * @param prefectureId
	 */
	public Prefecture deletePrefecture(Long prefectureId) {		
		try {
			Prefecture pref = prefectureRepository.findById(prefectureId).get();
			pref.setIsDeleted(true);
			prefectureRepository.save(pref);
			return pref;
		} catch (Exception e) {
			logger.error("PrefectureService.\n Method: deletePrefecture() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * 
	 * @param pageable
	 * @return prefecture list
	 */
	public Page<Prefecture> getList(Pageable pageable) {
		
		return prefectureRepository.findAll(pageable);
	}
}