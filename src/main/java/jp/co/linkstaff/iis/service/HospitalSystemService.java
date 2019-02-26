package jp.co.linkstaff.iis.service;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;
import jp.co.linkstaff.iis.model.HospitalSystem;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import jp.co.linkstaff.iis.repository.HospitalSystemRepository;
@Service
public class HospitalSystemService {
    private static final Logger logger = LogManager.getLogger(HospitalSystemService.class);
	@Autowired
	private HospitalSystemRepository hospitalSystemRepository;
	/**
	 * add new instance of HospitalSystem using save method
	 * @param HospitalSystem
	 */
	public HospitalSystem addNewHospitalSystem(HospitalSystem hospitalSystem) {
		try {
			return hospitalSystemRepository.save(hospitalSystem);
		} catch (Exception e) {
			logger.error("HospitalSystemService.'\n' Method: addNewHospitalSystem() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}		
	}
	/**
	 * get all HospitalSystem list including soft delete
	 * @return list
	 */
	public List<HospitalSystem> getAllHospitalSystem() {
		List<HospitalSystem> list = (List<HospitalSystem>) hospitalSystemRepository.findAll();
		return list;
	}
	  /**
     * get those HospitalSystem which is not deleted
     * @return HospitalSystem
     */
	public List<HospitalSystem> getAllOriginalHospitalSystem(){
		List<HospitalSystem> system = null;
		try {
			system = hospitalSystemRepository.findByIsDeleted(false); 
		} catch (Exception e) {			
			throw new ServerErrorException("Exception occured at Service in getAllOriginalHospitalSystem(). "+e);	
		}		
		return system;
	}
	/**
	 * we can get HospitalSystem against hospitalSystemId
	 * @param hospitalSystemId
	 * @return HospitalSystem
	 */
	public HospitalSystem getHospitalSystem(Long hospitalSystemId) {
		HospitalSystem hospitalSystem = null;
		try {
			hospitalSystem = hospitalSystemRepository.findById(hospitalSystemId).get();
		} catch (Exception e) {
			logger.error("HospitalSystemService.'\n' Method: getHospitalSystem() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
		return hospitalSystem;
	}
	/**
	 * we can update single instance against hospitalSystemId
	 * @param hospitalSystem
	 * @param hospitalSystemId
	 */
	public HospitalSystem updateHospitalSystem(HospitalSystem hospitalSystem, Long hospitalSystemId){		
		try {
			hospitalSystem.setHospitalSystemId(hospitalSystemId);
			return hospitalSystemRepository.save(hospitalSystem);
		} catch (Exception e) {
			logger.error("HospitalSystemService.\n Method: updateHospitalSystem() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * we will no delete any data permanently
	 * first get all HospitalSystem list which is not deleted
	 * after that set isDeleted field = true(for our understanding that this data is deleted)
	 * @param hospitalSystemId
	 */
	public void deleteHospitalSystem(Long hospitalSystemId) {		
		HospitalSystem hospitalSystem = null;
		try {		
			hospitalSystem = hospitalSystemRepository.findByIsDeletedAndHospitalSystemId(false, hospitalSystemId);				
		} catch (Exception e) {
			throw new ServerErrorException("Exception occured at Service in deleteHospitalSystem(). "+e);
		}
		if( hospitalSystem != null) {
			hospitalSystem.setIsDeleted(true);
			try {				
				hospitalSystemRepository.save(hospitalSystem);				
			} catch(Exception e) {
				throw new ServerErrorException("Exception occured at Service in deleteHospitalSystem(). "+e);
			}			
		} else {
			logger.error(String.format("HospitalSystem by id: %d is not found.\nHence, cannot be deleted.", hospitalSystemId));
		}		
	}
	
}
