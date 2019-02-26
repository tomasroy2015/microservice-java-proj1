package jp.co.linkstaff.iis.service;

import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.stereotype.Service;
import jp.co.linkstaff.iis.model.HospitalEmergency;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
import jp.co.linkstaff.iis.repository.HospitalEmergencyRepository;

@Service
public class HospitalEmergencyService {
    private static final Logger logger = LogManager.getLogger(HospitalEmergencyService.class);
	@Autowired
	private HospitalEmergencyRepository hospitalEmergencyRepository;
	/**
	 * add new instance of HospitalEmergency using save method
	 * @param HospitalEmergency
	 */
	public HospitalEmergency addNewHospitalEmergency(HospitalEmergency hospitalEmergency) {
		try {
			return hospitalEmergencyRepository.save(hospitalEmergency);
		} catch (Exception e) {
			logger.error("HospitalEmergencyService.'\n' Method: addNewHospitalEmergency() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}		
	}
	/**
	 * get all HospitalEmergency list including soft delete
	 * @return list
	 */
	public List<HospitalEmergency> getAllHospitalEmergency() {
		List<HospitalEmergency> list = (List<HospitalEmergency>) hospitalEmergencyRepository.findAll();
		return list;
	}
	  /**
     * get those HospitalEmergency which is not deleted
     * @return HospitalEmergency
     */
	public List<HospitalEmergency> getAllOriginalHospitalEmergency(){
		List<HospitalEmergency> emergency = null;
		try {
			emergency = hospitalEmergencyRepository.findByIsDeleted(false); 
		} catch (Exception e) {			
			throw new ServerErrorException("Exception occured at Service in getAllOriginalHospitalEmergency(). "+e);	
		}		
		return emergency;
	}
	/**
	 * we can get hospitalEmergency against hospitalEmergencyId
	 * @param hospitalEmergencyId
	 * @return hospitalEmergency
	 */
	public HospitalEmergency getHospitalEmergency (Long hospitalEmergencyId) {
		HospitalEmergency hospitalEmergency = null;
		try {
			hospitalEmergency = hospitalEmergencyRepository.findById(hospitalEmergencyId).get();
		} catch (Exception e) {
			logger.error("HospitalEmergencyService.'\n' Method: getHospitalEmergency() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
		return hospitalEmergency;
	}
	/**
	 * we can update single instance against hospitalEmergencyId
	 * @param hospitalEmergency
	 * @param hospitalEmergencyId
	 */
	public HospitalEmergency updateHospitalEmergency(HospitalEmergency hospitalEmergency, Long hospitalEmergencyId){		
		try {
			hospitalEmergency.setHospitalEmergencyId(hospitalEmergencyId);
			return hospitalEmergencyRepository.save(hospitalEmergency);
		} catch (Exception e) {
			logger.error("HospitalEmergencyService.\n Method: updateHospitalEmergency() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * we will no delete any data permanently
	 * first get all hospitalEmergency list which is not deleted
	 * after that set isDeleted field = true(for our understanding that this data is deleted)
	 * @param hospitalEmergencyId
	 */
	public void deleteHospitalEmergency(Long hospitalEmergencyId) {		
		HospitalEmergency hospitalEmergency = null;
		try {		
			hospitalEmergency = hospitalEmergencyRepository.findByIsDeletedAndHospitalEmergencyId(false, hospitalEmergencyId);				
		} catch (Exception e) {
			throw new ServerErrorException("Exception occured at Service in deleteHospitalSystem(). "+e);
		}
		if( hospitalEmergency != null) {
			hospitalEmergency.setIsDeleted(true);
			try {				
				hospitalEmergencyRepository.save(hospitalEmergency);				
			} catch(Exception e) {
				throw new ServerErrorException("Exception occured at Service in deleteHospitalEmergency(). "+e);
			}			
		} else {
			logger.error(String.format(" HospitalEmergency by id: %d is not found.\nHence, cannot be deleted.", hospitalEmergencyId));
		}		
	}
	
}