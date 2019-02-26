package jp.co.linkstaff.iis.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import jp.co.linkstaff.iis.model.Station;
import jp.co.linkstaff.iis.repository.StationRepository;
import jp.co.linkstaff.iis.utils.ServerErrorException;

@Service
	public class StationService {
		private static final Logger logger = LogManager.getLogger(StationService .class);
        @Autowired
		private StationRepository stationRepository;

		/**
		 * Constructor:Instanciate StationRepository object.
		 * @param stationRepository
		 */
		// @Autowired	//Autowired tie class instance to a wrapper class of CrudRepository interface to get some rebuild query(etc..) methods and so on.
		// public StationService(StationRepository stationRepository) {
		// 	this.stationRepository = stationRepository;
		// }

		/**
		 * Returns a list of Stations
		 * @return List<Station>
		 */
		public List<Station> getAllStation() {
			List<Station> stationList = null;
			try {
				stationList = (List<Station>) stationRepository.findByIsDeleted(false);
				
			} catch (Exception e) {
				stationList = new ArrayList<>();
				throw new ServerErrorException("Exception occured at Service in getAllStation(). "+e);
			}
			return stationList;
		}
		
		/**
		 * Overload Method: getAllInquiries
		 * Returns a page of all Inquires according to page# and number of item in a page.
		 * @param pageNo
		 * @param numberOfItem
		 * @return
		 */
		public Page<Station> getAllStation(int pageNo, int numberOfItem) {
			Page<Station> stations = null;
			try {
				stations = (Page<Station>) stationRepository.findByIsDeleted(false, PageRequest.of(pageNo, numberOfItem)); //set argument to false to get non deleted(flagged) data.	
			} catch (Exception e) {
				throw new ServerErrorException("Exception occured in controller."+e);
			}
			return stations;
		}

		/**
		 * get a particular station by id
		 * @param id
		 * @return Station
		 */
		public Station getStation(Long id) {
			Station station = null;
			try {
				station = stationRepository.findByIsDeletedAndStationId(false, id);
			}catch (Exception e) {
				station = new Station();
				throw new ServerErrorException("Exception occured at Service in getAllStation(). "+e);
			}
			return station;
		}

		/**
		 * Find Station By Name: First Occurrence. Ignore case.
		 * @param stationName
		 * @return
		 */
		public Station getStationByName(String stationName) {
			Station station = null;
			try {
				station = stationRepository.findOneByIsDeletedAndStationNameIgnoreCase(false, stationName);
			} catch(Exception e) {
				throw new ServerErrorException("Exception occured at Service in getAllStation(). "+e);
			}
			return station;
		}

		/**
		 * Find Station By code: First occurrence
		 * @param code
		 * @return Station
		 */
		public Station getStationByCode(String code) {
			Station station = null;

			try {
				station = stationRepository.findOneByIsDeletedAndStationCode(false, code);
			} catch(Exception e) {
				throw new ServerErrorException("Exception occured at Service in getAllStation(). "+e);
			}
			return station;
		}

		/**
		 * Find single occurrence of station find by latitude and longitude. Ignore case.
		 * @param lat
		 * @param lng
		 * @return Station
		 */
		public Station getStationByLatLng(String lat, String lng) {
			Station station = null;

			try {
				station = stationRepository.findByIsDeletedAndLatitudeAndLongitudeIgnoreCase(false, lat, lng);
			}catch (Exception e) {
				throw new ServerErrorException("Exception occured at Service in getAllStation(). "+e);
			}
			return station;
		}

		/**
		 * Insertion: Single instance of station.
		 * @param station
		 */
		public Station addNewStation(Station station) {
			Station savedStation = null;
			try {
				savedStation = stationRepository.save(station);
			}catch(Exception e) {
				savedStation = new Station();
				throw new ServerErrorException("Exception occured at Service in getAllStation(). "+e);
			}
			
			return savedStation;
		}

		/**
		 * Update single instance of station
		 * @param id
		 * @param station
		 */
		public Station updateStation(Long id, Station station) {
			Station savedStation = null;
			if(stationRepository.findByIsDeletedAndStationId(false, id) != null) {
				station.setId(id);
				try {
					savedStation = stationRepository.save(station);
				}catch (Exception e) {
					savedStation = new Station();
					throw new ServerErrorException("Exception occured at Service in getAllStation(). "+e);
				}				
			} else {
				logger.error(String.format("Station by id: %d is not found.\nHence, cannot be updated.", id));
			}
			
			return savedStation;
		}
		
		/**
		 * This method doesn't delete anything from database.
		 * Just set a flag to remark as delete on database.
		 * We don't delete data from database, just set a delete flag.
		 * @param Long id
		 */
		public void deleteStation(Long id) {
			Station station = null;
			try {
				station = stationRepository.findByIsDeletedAndStationId(false, id);
			} catch(Exception e) {
				throw new ServerErrorException("Exception occured at Service in getAllStation(). "+e);
			}
			
			
			if( station != null) {
				station.setDeleted(true);
				try {
					stationRepository.save(station);
				} catch(Exception e) {
					throw new ServerErrorException("Exception occured at Service in deleteStation(). "+e);
				}			
			} else {
				logger.error(String.format("Station by id: %d is not found.\nHence, cannot be deleted.", id));
			}	
		}
		
		/**
		 * Don't use this method but only for development purpose.
		 * Delete: Single instance of Station by id
		 * Check ORM if the instance with given id exist.
		 * if exist try to delete, else produce error message.
		 * @param id
		 */
		public void hardDeleteStation(Long id) {
			
			if(stationRepository.findById(id).isPresent()) {
				try {
					stationRepository.deleteById(id);
				} catch (Exception e) {
					throw new ServerErrorException("Exception occured at Service in hardDeleteStation(). "+e);
				}
			} else {
				logger.error(String.format("Station by id: %d is not found.\nHence, cannot be deleted.", id));
			}
		}

		/**
		 * Returns a list of Stations matches PrefCode ignoring case
		 * @param prefCode
		 * @return List<Station>
		 */
		public List<Station> getStationsByPrefCode(String prefCode) {
			List<Station> stations = null;
			try {
				stations = stationRepository.findByIsDeletedAndPrefCodeIgnoreCase(false, prefCode);
			} catch(Exception e) {
				throw new ServerErrorException("Exception occured at Service in getStationsByPrefCode(). "+e);
			}
			return stations;
		}
		
//		/**
//		 * Returns a list of Stations matches PrefCode ignoring case
//		 * @param prefCode
//		 * @return List<Station>
//		 */
//		public List<Station> getStationsByPrefName(String prefName) {
//			List<Station> stations = null;
//			try {
//				stations = stationRepository.findByIsDeletedAndPrefNameIgnoreCase(false, prefName);
//			} catch(Exception e) {
//				throw new ServerErrorException("Exception occured at Service in getStationsByPrefName(). "+e);
//			}
//			return stations;
//		}
		
		

	}//End of the class
