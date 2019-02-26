package jp.co.linkstaff.iis.controller;

import java.util.List;
import jp.co.linkstaff.iis.model.Prefecture;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.domain.PageRequest;
import jp.co.linkstaff.iis.service.PrefectureService;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.utils.ObjectNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.config.EnableHypermediaSupport;
import org.springframework.hateoas.config.EnableHypermediaSupport.HypermediaType;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
/**
 * 
 * @author .....
 *
 */
@RequestMapping(value = "/prefecture")
@EnableHypermediaSupport(type = HypermediaType.HAL)
@RestController
@CrossOrigin
public class PrefectureController {	
	@Autowired
	private PrefectureService prefectureService;
	/**
	 * 
	 * @param prefectureservice
	 */
//	@Autowired
//	public PrefectureController(PrefectureService prefectureservice) {
//		this.prefectureService = prefectureservice;
//	}

	/**
	 * add new instance of prefecture
	 * @param pref
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/add")

	public ResponseEntity<Prefecture> savePrefecture(@RequestBody Prefecture pref) {
		try {
			Prefecture prefecture = prefectureService.savePrefecture(pref);
			return new ResponseEntity<>(prefecture,HttpStatus.OK);
		} catch (Exception ex) {
			throw new ServerErrorException("Error occured due to Database operation failure.");
		}
	}
	/**
	 * get all prefecture list
	 * @return List<Prefecture
	 */
	@RequestMapping(value = "/list")
	public ResponseEntity<List<Prefecture>> getList() {
		List<Prefecture> prefs = prefectureService.getAllPrefecture();
		return new ResponseEntity<>(prefs,HttpStatus.OK);
	}		
	/**
	 * get a particular prefecture info
	 * @param id
	 * @return prefecture
	 */
	@RequestMapping(value = "/{prefectureId}")
	public ResponseEntity<Prefecture> getPrefecture(@PathVariable Long prefectureId) {
		Prefecture prefecture = prefectureService.getPrefecture(prefectureId);
		if (prefecture == null)
			throw new ObjectNotFoundException("Prefecture not found of id-" + prefectureId);
		return new ResponseEntity<>(prefecture,HttpStatus.OK);
	}
	/**
	 * add a new instance of prefecture
	 * @param prefecture
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/{prefectureId}")
	public ResponseEntity<Prefecture> updatePrefecture(@RequestBody Prefecture prefecture, @PathVariable Long prefectureId) {
		Prefecture pref = null;
		try {
			pref = prefectureService.updatePrefecture(prefecture, prefectureId);
		} catch (Exception ex) {
			throw new ServerErrorException("Error occured due to Database operation failure.");
		}
		return new ResponseEntity<>(pref,HttpStatus.OK);
	}
	/**
	 * delete particular instance according prefecture prefectureId 
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{prefectureId}")
	public ResponseEntity<Prefecture> deletePrefecture(@PathVariable Long prefectureId) {
		try {
			Prefecture pref = prefectureService.deletePrefecture(prefectureId);
			return new ResponseEntity<>(pref,HttpStatus.OK);
		} catch (Exception ex) {
			throw new ServerErrorException("Error occured due to Database operation failure.");
		}
	}
	/**
	 * 
	 * @param page
	 * @param pageSize
	 * @return jobs
	 */
	@RequestMapping(method = RequestMethod.GET,value = "/prefList/{page}/{pageSize}")
	public Page<Prefecture> prefectures(@PathVariable int page,@PathVariable int pageSize) {
	    Pageable pageable = PageRequest.of(page, pageSize,Direction.ASC);
	    Page<Prefecture> jobs = prefectureService.getList(pageable);
	    return jobs;
	}

}