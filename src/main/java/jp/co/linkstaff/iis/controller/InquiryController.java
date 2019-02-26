package jp.co.linkstaff.iis.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import jp.co.linkstaff.iis.model.Inquiry;
import jp.co.linkstaff.iis.service.InquiryService;



/**
 * 
 * @author khaliddhali(ls-215)
 *
 */
@CrossOrigin
@EnableHypermediaSupport(type = HypermediaType.HAL)
@RestController
@RequestMapping(value = "/inquiry")
public class InquiryController {
	
	@Autowired
	InquiryService inquiryService;
	
	private static final Logger logger = LogManager.getLogger(InquiryService .class);
	
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
		
	//#6: OK
	/**
	 * get a list of Inquiry
	 * @return List<Inquiry>
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/list")
	public List<Inquiry> getInquiryList(){
		List<Inquiry> inquiries =  null;
		
		try {
			inquiries = inquiryService.getAllInquiries();		//Nullpointer exception proof (not yet fully tested)	
		} catch (Exception e) {
			logger.error(String.format("List is empty."+e.getMessage()));
		}
		
		return inquiries;
	}
	
	//#7: OK
	/**
	 * Get a page of Inquiries according to page# and desired number of item in the page.
	 * @param int pageNo
	 * @param int numOfItem
	 * @return List<Inquiry>findByTel
	 */		
	@RequestMapping(method = RequestMethod.GET , value ="/page/{pageNo}/{pageSize}", produces = {"application/hal+json"})
	public Page<Inquiry> getInquiryList(@PathVariable int pageNo, @PathVariable int pageSize) {
		Page<Inquiry> inquiries = null;
		
		try {
			inquiries = (Page<Inquiry>) inquiryService.getAllInquiries(pageNo, pageSize);	//Possibly Nullpointer exception proof.	PageRequest.Of()  method Implementation handle null pointer exception	
		} catch (Exception e) {
			logger.error(String.format("No page found.\n"+e.getMessage()));
		}
		
		if( !inquiries.isEmpty() || inquiries != null) { //null checking might not be necessary. 
			for(Inquiry inquiry : inquiries) {
				Long inquiryId = inquiry.getInquiryId();
				
				//Creating link for each area object in the list by inquiryId;
				Link selfLink = linkTo(InquiryController.class).slash(inquiryId).withSelfRel();
				inquiry.add(selfLink);
			}			
		}
		
		return inquiries;
	}
	
	
	//#8 OK
	/**
	 * Get a single instance of 'Inquiry' matching id.
	 * @param id
	 * @return Inquiry
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Inquiry getInquiry(@PathVariable Long id) {
		Inquiry inquiry = null;
		
		try {
			inquiry = (Inquiry) inquiryService.getInquiry(id);
		} catch (Exception e){
			logger.error(String.format("Nothing found by id: "+id+"\n"+e.getMessage()));
		}		
		return inquiry;
	}
	

	
	//#10 OK
	/**
	 * Return a list that matches the  'inquiryType'  ignoring case
	 * @param inquiryType
	 * @return List<Inquiry>
	 */	
	@RequestMapping(method = RequestMethod.GET, value = "/inquiryType/{inquiryType}", produces = { "application/hal+json" })
	public List<Inquiry> getInquiriesByInquiryType(@PathVariable String inquiryType){
		List<Inquiry> inquiries = null;
		inquiries = inquiryService.getInquiriesByInquiryType(inquiryType);
		
		if(!inquiries.isEmpty() || inquiries != null) {
			for(Inquiry inquiry : inquiries) {
				Long inquiryId = inquiry.getInquiryId();
				Link selfLink = linkTo(InquiryController.class).slash(inquiryId).withSelfRel();
				inquiry.add(selfLink);
			}			
		}
			
		return inquiries;
	}
	


	
	//#13 OK
	/**
	 * Return a list of 'Inquiry' that matches 'jobCode' ignoring case
	 * @param jobCode
	 * @return List<Inquiries>
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/jobCode/{jobCode}", produces = { "application/hal+json" })
	public List<Inquiry> getInquiriesByJobCode(@PathVariable String jobCode){
		List<Inquiry> inquiries = null;
		inquiries = inquiryService.getInquiriesByJobCode(jobCode);
		
		if(!inquiries.isEmpty() || inquiries != null) {
			for(Inquiry inquiry : inquiries) {
				Long inquiryId = inquiry.getInquiryId();
				Link selfLink = linkTo(InquiryController.class).slash(inquiryId).withSelfRel();
				inquiry.add(selfLink);
			}			
		}
			
		return inquiries;
	}
	
	//#15
	/**
	 * POST Method: Insert single instance of Inquiry 
	 * @param Inquiry inquiry
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public Inquiry addInquiry(@RequestBody Inquiry inquiry) {
		Inquiry savedInq = null;
		try {
			savedInq = inquiryService.addNewInquiry(inquiry);
		} catch (Exception e) {
			savedInq = new Inquiry();
			logger.error(String.format("Inquiry instance is NOT inserted!\n"+e.getMessage()));
		}
		
		return savedInq;
	}
	
	//#16 OK
	/**
	 * PUT Method: Update a single instance of Inquiry matching id with an Inquiry instance
	 * @param Inquiry inquiry
	 * @param Long id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public void updateInquiry(@PathVariable Long id, @RequestBody Inquiry inquiry) {
		try {
			inquiryService.updateInquiry(id, inquiry);
		} catch (Exception e) {
			logger.error(String.format("Inquiry by id: "+id+"couldn't be updated\n"+e.getMessage()));
		}
	}
	
	//#16.1 Experimental Method: update
	/*@RequestMapping(value="update/{id}", method=RequestMethod.GET)
	public Inquiry requestMethodName(@RequestParam String param) {
		Inquiry updatedInquiry = null;
		
		return new SomeData();
	}*/
	
	
	//#17 OK
	/**
	 * Set isdeleted flag to true. 
	 * This method doesn't delete data from database.
	 * We don't delete any data from database
	 * @param Long id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/del/{id}")
	public void deleteInquiry(@PathVariable Long id) {
		try {
			inquiryService.deleteInquiry(id);
		} catch(Exception e) {
			logger.error(String.format("Inquiry by id: "+id+" cannot be deleted!\n"+e.getMessage()));
		}
	}
	
	//NO need to test
	/**
	 * Delete Method: Delete a single instance of 'Inquiry' matching the 'id'.
	 * This method must not be used. Only for development/testing purpose.
	 * We don't Delete anything from database.
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void hardDeleteInquiry(@PathVariable Long id) {
		try {
			inquiryService.hardDeleteInquiry(id);
		} catch (Exception e) {
			logger.error(String.format("Inquiry is not delted with id: "+id+"\n"+e.getMessage()));
		}
	}	
}//End of the class
