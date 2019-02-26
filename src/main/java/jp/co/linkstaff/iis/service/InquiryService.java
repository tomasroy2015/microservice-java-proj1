package jp.co.linkstaff.iis.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jp.co.linkstaff.iis.repository.InquiryRepository;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.model.Inquiry;

@Service
public class InquiryService {
	private static final Logger logger = LogManager.getLogger(InquiryService .class);
	
	@Autowired
	private InquiryRepository inquiryRepo;
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Constructor~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		//Create if needs
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	
	/**
	 * Return a list of inquiries.
	 * set argument false to get a list of non deleted(flagged) data.
	 * @param boolean isDeleted
	 * @return List<Inquiry>
	 */
	public List<Inquiry> getAllInquiries(){
		List<Inquiry> inquiries = null;
		try {
			inquiries = inquiryRepo.findByIsDeleted(false); //set argument to false to get non deleted(flagged) data.
		} catch (Exception e) {
			inquiries = new ArrayList<>(); //Make sure to not to pass any nullpointer
			throw new ServerErrorException("Exception occured at Service in getAllInquiries(). "+e);
			//logger.error("InquiryService.'\n' Method: getAllInuiryies() '\n' Error Details:" + e.getMessage());
		}
		
		return inquiries;
	}
	
	/**
	 * Overload Method: getAllInquiries
	 * Returns a page of all Inquires according to page# and number of item in a page.
	 * @param int pageNo,
	 * @param int number of item.
	 * @return Page<Inquiry>
	 */
	public Page<Inquiry> getAllInquiries(int pageNo, int numberOfItem) {
		//TODO: put some exception handling here.
		Page<Inquiry> inquiries = null;
		try {
			inquiries = (Page<Inquiry>) inquiryRepo.findByIsDeleted(false, PageRequest.of(pageNo, numberOfItem)); //set argument to false to get non deleted(flagged) data.	
		} catch (Exception e) {
			throw new ServerErrorException("Exception occured at Service in a overload getAllInquiries(). "+e);
		}
		return inquiries;
	}
	
		
	/**
	 * Return a single instance of Inquiry that matches id
	 * @param id
	 * @return Inquiry 
	 */
	public Inquiry getInquiry(Long id) {
		Inquiry inquiry = null;
		try {
			inquiry = inquiryRepo.findByIsDeletedAndInquiryId(false, id);			
		} catch (Exception e) {
			inquiry = new Inquiry();
			throw new ServerErrorException("Exception occured at Service in getInquiry. "+e);
			//logger.error("InquiryService.'\n' Method: findById() '\n' Error Details:" + e.getMessage());
		}
		return inquiry;
	}
	
	/**
	 * Return a list of Inquiry that matches the 'name'
	 * @param name
	 * @return List<Inquiry>
	 */
	public List<Inquiry> getInquiriesByName(String name){
		List<Inquiry> inquiries = null;
		try {
			inquiries = inquiryRepo.findByIsDeletedAndNameIgnoreCase(false, name);
		} catch(Exception e) {
			inquiries = new ArrayList<>();
			throw new ServerErrorException("Exception occured at Service in getInquiriesByName(). "+e);
		}		
		return inquiries;
	}
	
	/**
	 * Return a list of Inquiry that matches the 'inquiryType'
	 * @param String name
	 * @return List<Inquiry>
	 */
	public List<Inquiry> getInquiriesByInquiryType(String inquiryType){
		List<Inquiry> inquiries= null;
		try {
			inquiries = inquiryRepo.findByIsDeletedAndInquiryTypeIgnoreCase(false, inquiryType);
		} catch(Exception e) {
			inquiries = new ArrayList<>();
			throw new ServerErrorException("Exception occured at Service in getInquiriesByInquiryType(). "+e);
		}		
		return inquiries;
	}
	
	/**
	 * Return a list of Inquiry that matches the 'email'
	 * @param name
	 * @return List<Inquiry>
	 */
	public List<Inquiry> getInquiriesByEmail(String email){
		List<Inquiry> inquiries= null;
		try {
			inquiries = inquiryRepo.findByIsDeletedAndEmailIgnoreCase(false, email);
		} catch(Exception e) {
			inquiries = new ArrayList<>();
			throw new ServerErrorException("Exception occured at Service in getInquiriesByEmail(). "+e);
		}		
		return inquiries;
	}
	
	
	/**
	 * Return a list of Inquiry that matches the 'telephone'
	 * @param name
	 * @return List<Inquiry>
	 */
	public List<Inquiry> getInquiriesByTel(String tel){
		List<Inquiry> inquiries= null;
		try {
			inquiries = inquiryRepo.findByIsDeletedAndTelIgnoreCase(false, tel);
		} catch(Exception e) {
			inquiries = new ArrayList<>();
			throw new ServerErrorException("Exception occured at Service in getInquiriesByTel(). "+e);
		}		
		return inquiries;
	}
	
	/**
	 * Return a list of Inquiry that matches the jobCode ignoring case
	 * @param jobCode
	 * @return
	 */
	public List<Inquiry> getInquiriesByJobCode(String jobCode){
		List<Inquiry> inquiries= null;
		try {
			inquiries = inquiryRepo.findByIsDeletedAndJobCodeIgnoreCase(false, jobCode);
		} catch(Exception e) {
			inquiries = new ArrayList<>();
			throw new ServerErrorException("Exception occured at Service in getInquiriesByJobCode(). "+e);
		}		
		return inquiries;
	}
	
	/**
	 * Return a list of queries that matches 'nameKan' ignoring case
	 * @param nameKana
	 * @return
	 */
	public List<Inquiry> getInquiriesByNameKana(String nameKana){
		List<Inquiry> inquiries= null;
		try {
			inquiries = inquiryRepo.findByIsDeletedAndNameKana(false, nameKana);
		} catch(Exception e) {
			inquiries = new ArrayList<>();
			throw new ServerErrorException("Exception occured at Service in getInquiriesByNameKana(). "+e);
		}		
		return inquiries;
	}

	/**
	 * Insert a single instance of Inquiry
	 * @param inquiry
	 * @return 
	 */
	public  Inquiry addNewInquiry(Inquiry inquiry) {
		Inquiry savedInq = null;
		try {
			savedInq = inquiryRepo.save(inquiry);
		} catch(Exception e) {
			savedInq = new Inquiry();
			throw new ServerErrorException("Exception occured at Service in addNewInquiry(). "+e);
		}	
		
		return savedInq;
	}
	
	/**
	 * Update a single instance of given id with the given Inquiry object.
	 * Check ORM if the instance with the given id.
	 * If exists, try to update, else produce error message.
	 * @param id
	 * @param inquiry
	 * @return 
	 */
	public void updateInquiry(Long id, Inquiry inquiry) {
		if(inquiryRepo.findByIsDeletedAndInquiryId(false, id) != null) {
			inquiry.setInquiryId(id);		
			try {
				inquiryRepo.save(inquiry);			
			} catch(Exception e) {
				//TODO: standardized  a logger Code
				throw new ServerErrorException("Exception occured at Service in updateInquiry(). "+e);
			}			
		} else {
			logger.error(String.format("Station by id: %d is not found.\nHence, cannot be updated.", id));
		}
	}
	
	/**
	 * This method doesn't delete anything from database.
	 * Just set a flag to remark as delete on database.
	 * @param Long id
	 */
	public void deleteInquiry(Long id) {
		Inquiry inquiry = null;

		try {
			inquiry = inquiryRepo.findByIsDeletedAndInquiryId(false, id);			
		} catch (Exception e) {
			throw new ServerErrorException("Exception occured at Service in deleteInquiry(). "+e);
		}


		if(inquiry != null) {
			inquiry.setDeleted(true);
			try {
				inquiryRepo.save(inquiry);
			} catch(Exception e) {
				throw new ServerErrorException("Exception occured at Service in deleteInquiry(). "+e);
			}			
		} else {
			logger.error(String.format("Station by id: %d is not found.\nHence, cannot be deleted.", id));
		}
	}
	
	/**
	 * Don't use this method but only for development purpose.
	 * Delete a single instance of given id.
	 * Check ORM if the instance with the given id.
	 * If exists, try to delete, else produce error message.
	 * @param id
	 * @return
	 */
	public void hardDeleteInquiry(Long id) {
		if(inquiryRepo.findById(id).isPresent()) {
			try {
				inquiryRepo.deleteById(id);
			} catch(Exception e) {
				throw new ServerErrorException("Exception occured at Service in hardDeleteInquiry(). "+e);
			}			
		} else {
			logger.error(String.format("Station by id: %d is not found.\nHence, cannot be deleted.", id));
		}
	}

	//This is temporary code, delete after when not needed
	public List<Inquiry> getAllInquiryList() {
		return (List<Inquiry>) inquiryRepo.findAll();
	}

	public List<Inquiry> getAll() {
		// TODO Auto-generated method stub
		return (List<Inquiry>) inquiryRepo.findAll();
	}
}//End of the class