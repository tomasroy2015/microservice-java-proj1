package jp.co.linkstaff.iis.controller;

import java.util.List;
import org.springframework.hateoas.Link;
import jp.co.linkstaff.iis.model.HospitalBed;
import jp.co.linkstaff.iis.service.HospitalBedService;
import jp.co.linkstaff.iis.utils.ServerErrorException;
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
@RequestMapping(value = "/hospitalbed")
@EnableHypermediaSupport(type = HypermediaType.HAL)
@RestController
public class HospitalBedController {
	@Autowired
	private HospitalBedService hospitalBedService;
	
	/**
	 * get total list of HospitalBed
	 * @return bed
	 */
	@RequestMapping(value = "/list",method = RequestMethod.GET, produces = { "application/hal+json" })
	public List<HospitalBed> getList() {
		  List<HospitalBed> bed = hospitalBedService.getAllHospitalBed();
		  for (HospitalBed hospitalBed : bed) {
			  Long hospitalBedId = hospitalBed.getHospitalBedId();
	          Link selfLink = linkTo(HospitalBedController.class).slash(hospitalBedId).withSelfRel();
	          hospitalBed.add(selfLink);
	      }
		  return bed;
	}
	/**
	 * get those HospitalBed list which is not deleted 
	 * @return bed
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/original/list")
	public List<HospitalBed> getHospitalBedOriginalList(){
		List<HospitalBed> bed =  null;
		try {
			bed = hospitalBedService.getAllOriginalHospitalBed();		
		} catch (Exception e) {
			throw new ServerErrorException(e.getMessage());
		}
		return bed;
	}
	/**
	 * get hospitalSystem instance according hospitalBedId
	 * @param hospitalBedId
	 * @return bed
	 */
	@RequestMapping(value = "/{hospitalBedId}")
	public HospitalBed getHospitalBed(@PathVariable Long hospitalBedId) {
		HospitalBed bed = hospitalBedService.getHospitalBed(hospitalBedId);
		if (bed == null)
			throw new ObjectNotFoundException(" HospitalBed not found of id-" + hospitalBedId);
		return bed;
	}	
	
}
