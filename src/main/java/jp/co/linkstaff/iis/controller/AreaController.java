package jp.co.linkstaff.iis.controller;

import java.util.List;
import jp.co.linkstaff.iis.model.Area;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import jp.co.linkstaff.iis.service.AreaService;
import jp.co.linkstaff.iis.utils.ObjectNotFoundException;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
/**
 * 
 * @author .....
 *
 */
@RequestMapping(value = "/area")
@EnableHypermediaSupport(type = HypermediaType.HAL)
@RestController
@CrossOrigin
public class AreaController {
	@Autowired
	private AreaService areaService;
	
	/**
	 * fetch List<Area> areas
	 * @return areas
	 */
	@RequestMapping(value = "/list",method = RequestMethod.GET, produces = { "application/hal+json" })
	public ResponseEntity<List<Area>> getList() {  
		  List<Area> areas = areaService.getAllArea();
		  for (Area area : areas) {
			  Long areaId = area.getAreaId();
	          Link selfLink = linkTo(AreaController.class).slash(areaId).withSelfRel();
	          area.add(selfLink);
	      }
		  return new ResponseEntity<>(areas,HttpStatus.OK);
	}
	/**
	 * get those area(list) which is not deleted 
	 * @return area
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/original/list")
	public ResponseEntity<List<Area>> getAreaOriginalList(){
			List<Area> area = areaService.getAllOriginalArea();		
		    return new ResponseEntity<>(area,HttpStatus.OK);
	}
	/**	
	 * fetch area info according area id
	 * @param id
	 * @return area
	 */
	@RequestMapping(value = "/{areaId}")
	public ResponseEntity<Area> getArea(@PathVariable Long areaId) {
		Area area = areaService.getArea(areaId);
		if (area == null)
			throw new ObjectNotFoundException("Area not found of id-" + areaId);
		return new ResponseEntity<>(area,HttpStatus.OK);
	}	
	
}
