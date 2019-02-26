package jp.co.linkstaff.iis.controller;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;

import java.util.ArrayList;
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


import jp.co.linkstaff.iis.model.Station;
import jp.co.linkstaff.iis.service.InquiryService;
import jp.co.linkstaff.iis.service.StationService;



/**
 * 
 * @author khaliddhali(ls-215)
 *
 */

@CrossOrigin
@EnableHypermediaSupport(type = HypermediaType.HAL)
@RestController
@RequestMapping(value = "/station")
public class StationController {
	@Autowired
	private StationService stationService; //Dependency
	private static final Logger logger = LogManager.getLogger(InquiryService .class);
	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Constructors~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	/**
	 * 
	 * @param StationService
	 */
//	@Autowired
//	public StationController(StationService stationService) {
//		this.stationService = stationService;
//	}

	//Constructor: 0 argument, empty constructor
//	public StationController() {
//		//Do nothing here...
//	}

	/*~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~Methods~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~*/
	//#51 OK
	/**
	 * Get a list of Station
	 * @return List<Station>
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/station/list", produces = {"application/hal+json"})
	public List<Station> getAllStations(){
		List<Station> stations = new ArrayList<>();
		
		try {
			stations = stationService.getAllStation(); //Make it Nullpointer exception proof
		} catch(Exception e) {
			logger.error(String.format("List is empty.\n"+e.getMessage()));
		}

		if(!stations.isEmpty() || stations != null) {
			for(Station station : stations) {
				Long stationId = station.getStationId();

				//Creating link for each area object in the list by stationId;
				Link selfLink = linkTo(InquiryController.class).slash(stationId).withSelfRel();
				station.add(selfLink);					
			}
		}

		return stations; //Possible to return null. ToDo: Exception Handling
	}
	
	/**
	 * 
	 * @param param
	 * @return
	 */
	@RequestMapping(value="/page/{pageNo}/{pageSize}", method=RequestMethod.GET, produces = {"application/hal+json"})
	public Page<Station> getAllStations(@PathVariable int pageNo, @PathVariable int pageSize) {
		Page<Station> stations = null;
		
		try {
			stations = (Page<Station>) stationService.getAllStation(pageNo, pageSize);
		} catch(Exception e) {
			logger.error(String.format("No page found.\n"+e.getMessage()));
		}
		
		if( !stations.isEmpty() || stations != null) { //null checking might not be necessary. 
			for(Station station : stations) {
				Long inquiryId = station.getStationId();
				
				//Creating link for each area object in the list by inquiryId;
				Link selfLink = linkTo(InquiryController.class).slash(inquiryId).withSelfRel();
				station.add(selfLink);
			}			
		}
		
		return stations;
	}
	

	/**
	 * Get a list of Station that matches preCode ignoring case.
	 * @param prefCode
	 * @return List<Station>
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/prefCode/{prefCode}", produces = {"application/hal+json"})
	public List<Station> getStationsByPrefCode(@PathVariable String prefCode ){
		List<Station> stations = null;
		stations = stationService.getStationsByPrefCode(prefCode);

		if(!stations.isEmpty() || stations != null) {
			for(Station station : stations) {
				Long stationId = station.getStationId();

				//Creating link for each area object in the list by stationId;
				Link selfLink = linkTo(InquiryController.class).slash(stationId).withSelfRel();
				station.add(selfLink);
			}
		}

		return stations;
	}

//	/**
//	 * Get a list of Station that matches preName ignoring case.
//	 * @param prefName
//	 * @return
//	 */
//	@RequestMapping(method = RequestMethod.GET, value = "/prefName/{prefCode}", produces = {"application/hal+json"})
//	public List<Station> getStationsByPrefName(@PathVariable String prefName ){
//		List<Station> stations = null;
//		stations = stationService.getStationsByPrefName(prefName);
//
//		if(!stations.isEmpty() || stations != null) {
//			for(Station station : stations) {
//				Long stationId = station.getStationId();
//
//				//Creating link for each area object in the list by stationId;
//				Link selfLink = linkTo(InquiryController.class).slash(stationId).withSelfRel();
//				station.add(selfLink);
//			}
//		}
//
//		return stations;
//	}

	//#52 OK
	/**
	 * Get a single instance of Station by id
	 * @param Long id
	 * @return Station
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/{id}")
	public Station getStation(@PathVariable Long id) {
		Station station = null;
		try {
			station = stationService.getStation(id);
		} catch(Exception e) {
			logger.error(String.format("Nothings foudn by id: "+id+".\n"+e.getMessage()));
		}
		
		return station;
	}

	/**
	 * Get Station by station name: first occurrence ignoring case
	 * @param name
	 * @return Station
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/name/{name}")
	public Station getStationByName(@PathVariable String name) {
		Station station = stationService.getStationByName(name);
		if(station == null)
			logger.error(String.format("Nothings foudn by name: "+name+".\n"));
		return station;
	}

	/**
	 * Get a single instance of station matching code
	 * @param String code
	 * @return Station
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/code/{code}")
	public Station getStationByCode(@PathVariable String code) {
		Station station = stationService.getStationByCode(code);
		if (station == null)
			logger.error(String.format("Nothings foudn by code: "+code+".\n"));
		return station;
	}

	/**
	 * Get a single instance of Station matching both Latitude && longitude ignoring case
	 * @param lat
	 * @param lng
	 * @return Station
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/latLng/{lat}/{lng}")		
	public Station getStationByLatLng(@PathVariable String lat, @PathVariable String lng) {
		Station station = stationService.getStationByLatLng(lat, lng);
		if(station == null)
			logger.error(String.format("Nothings found by Latitude: "+lat+" and Longitude: "+lng+".\n"));
		return station;
	}

	//#48 OK
	/**
	 * Insertion: single instance of Station 
	 * @param station
	 */
	@RequestMapping(method = RequestMethod.POST, value = "/add")
	public Station addArea(@RequestBody Station station) {
		Station savedStation = null;
		try {
			savedStation = stationService.addNewStation(station);
		} catch (Exception e) {
			savedStation = new Station();
			logger.error(String.format("Insertion is NOT done!\n"+e.getMessage()));
		}
		
		return savedStation;
	}

	//#49 OK
	/**
	 * Update: single instance of Station, refereed by id
	 * @param Long id
	 * @param Station station
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/{id}")
	public Station updateStation(@PathVariable Long id, @RequestBody Station station) {
		Station savedStation = null;
		try {
			savedStation = stationService.updateStation(id, station);
		} catch(Exception e) {
			savedStation = new Station();
			logger.error(String.format("Station with id: "+id+" is not updated\n"+e.getMessage()));
		}
		return savedStation;
	}

	//#50 OK
	/**
	 * Delete a single instance (flag as deleted)
	 * update isDeleted flag to true.
	 * We don't delete anything from database.
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.PUT, value = "/del/{id}")
	public void deleteStation(@PathVariable Long id) {
		try {
			stationService.deleteStation(id);
		} catch (Exception e) {
			logger.error(String.format("Station with id: "+id+" is not deleted\n"+e.getMessage()));
		}
	}

	/**
	 * Delete: Station Single instance, refereed by id.
	 * Dont't use this method. Use only for development/testing purpose.
	 * We don't delete data from database.
	 * @param id
	 */
	@RequestMapping(method = RequestMethod.DELETE, value = "/{id}")
	public void hardDeleteStation(@PathVariable Long id) {

		try {
			stationService.hardDeleteStation(id);
		} catch(Exception e) {
			logger.error(String.format("Station with id: "+id+" is NOT deleted!\n"+e.getMessage()));
		}
	}		
} //End of Station
