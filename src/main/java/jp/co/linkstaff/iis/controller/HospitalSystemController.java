package jp.co.linkstaff.iis.controller;

import java.util.List;
import org.springframework.hateoas.Link;
import jp.co.linkstaff.iis.model.HospitalSystem;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.service.HospitalSystemService;
import jp.co.linkstaff.iis.utils.ObjectNotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
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
@RequestMapping(value = "/hospitalsystem")
@EnableHypermediaSupport(type = HypermediaType.HAL)
@RestController
public class HospitalSystemController{
	@Autowired
	private HospitalSystemService hospitalSystemService;
	
	/**
	 * get total list of HospitalSystem
	 * @return system
	 */
	@RequestMapping(value = "/list",method = RequestMethod.GET, produces = { "application/hal+json" })
	public List<HospitalSystem> getList() {
		  List<HospitalSystem> system = hospitalSystemService.getAllHospitalSystem();
		  for (HospitalSystem hospitalSystem : system) {
			  Long hospitalSystemId = hospitalSystem.getHospitalSystemId();
	          Link selfLink = linkTo(HospitalSystemController.class).slash(hospitalSystemId).withSelfRel();
	          hospitalSystem.add(selfLink);
	      }
		  return system;
	}
	/**
	 * get those HospitalSystem list which is not deleted 
	 * @return system
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/original/list")
	public List<HospitalSystem> getNoticeOriginalList(){
		List<HospitalSystem> system =  null;
		try {
			system = hospitalSystemService.getAllOriginalHospitalSystem();		
		} catch (Exception e) {
			throw new ServerErrorException(e.getMessage());
		}
		return system;
	}
	/**
	 * get hospitalSystem instance according hospitalSystemId
	 * @param hospitalSystemId
	 * @return system
	 */
	@RequestMapping(value = "/{hospitalSystemId}")
	public HospitalSystem getHospitalSystem(@PathVariable Long hospitalSystemId) {
		HospitalSystem system = hospitalSystemService.getHospitalSystem(hospitalSystemId);
		if (system == null)
			throw new ObjectNotFoundException(" HospitalSystem not found of id-" + hospitalSystemId);
		return system;
	}	
	
}
