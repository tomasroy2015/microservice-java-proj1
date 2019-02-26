package jp.co.linkstaff.iis.controller;

import java.util.List;
import org.springframework.hateoas.Link;
import jp.co.linkstaff.iis.model.HospitalEmergency;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.utils.ObjectNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import jp.co.linkstaff.iis.service.HospitalEmergencyService;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
/**
 * 
 * @author ....
 *
 */
@RequestMapping(value = "/hospitalemergency")
@EnableHypermediaSupport(type = HypermediaType.HAL)
@RestController
public class HospitalEmergencyController {	
	@Autowired
	private HospitalEmergencyService hospitalEmergencyService;
	
	/**
	 * get total list of hospitalEmergency
	 * @return emergency
	 */
	@RequestMapping(value = "/list",method = RequestMethod.GET, produces = { "application/hal+json" })
	public List<HospitalEmergency> getList() {
		  List<HospitalEmergency> emergency = hospitalEmergencyService.getAllHospitalEmergency();
		  for (HospitalEmergency hospitalEmergency : emergency) {
			  Long hospitalEmergencyId = hospitalEmergency.getHospitalEmergencyId();
	          Link selfLink = linkTo(HospitalEmergencyController.class).slash(hospitalEmergencyId).withSelfRel();
	          hospitalEmergency.add(selfLink);
	      }
		  return emergency;
	}
	/**
	 * get those HospitalEmergency list which is not deleted 
	 * @return emergency
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/original/list")
	public List<HospitalEmergency> getHospitalEmergencyOriginalList(){
		List<HospitalEmergency> emergency =  null;
		try {
			emergency = hospitalEmergencyService.getAllOriginalHospitalEmergency();		
		} catch (Exception e) {
			throw new ServerErrorException(e.getMessage());
		}
		return emergency;
	}
	/**
	 * get HospitalEmergency instance according hospitalEmergencyId
	 * @param hospitalEmergencyId
	 * @return emergency
	 */
	@RequestMapping(value = "/{hospitalEmergencyId}")
	public HospitalEmergency getHospitalEmergency(@PathVariable Long hospitalEmergencyId) {
		HospitalEmergency emergency = hospitalEmergencyService.getHospitalEmergency(hospitalEmergencyId);
		if ( emergency == null)
			throw new ObjectNotFoundException(" HospitalEmergency not found of id-" + hospitalEmergencyId);
		return emergency;
	}	
	

}
