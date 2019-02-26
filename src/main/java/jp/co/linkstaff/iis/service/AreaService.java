package jp.co.linkstaff.iis.service;

import java.util.Date;
import java.util.List;
import jp.co.linkstaff.iis.model.Area;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Service;
import org.springframework.data.domain.Pageable;
import jp.co.linkstaff.iis.repository.AreaRepository;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import org.springframework.beans.factory.annotation.Autowired;
/**
 * 
 * @author .....
 *
 */
@Service
	public class AreaService {
		private static final Logger logger = LogManager.getLogger(AreaService .class);
		@Autowired
		private AreaRepository areaRepository;
		/**
		 * add a new instance of Area
		 * @param area
		 */
		public Area addNewArea(Area area) {
			try {
				return areaRepository.save(area);
			} catch (Exception e) {
				logger.error("AreaService.'\n' Method: addNewArea() '\n' Error Details:" + e.getMessage());
				throw new ServerErrorException(e.getMessage());
			}	
		}
		/**
		 * fetch list of area
		 * List<Area
		 * @return list
		 */
		public List<Area> getAllArea() {
			List<Area> list = (List<Area>) areaRepository.findAll();
			return list;
		}		
		  /**
	     * get those Area which is not deleted
	     * @return area
	     */
		public List<Area> getAllOriginalArea(){
			List<Area> area = null;
			try {
				area = areaRepository.findByIsDeleted(false); 
			} catch (Exception e) {			
				throw new ServerErrorException("Exception occured at Service in getAllOriginalArea(). "+e);	
			}		
			return area;
		}
		/**
		 * find a area according id 
		 * @param id
		 * @return area
		 */
		public Area getArea(Long areaId) {
			Area area = null;
			try {
				area = areaRepository.findById(areaId).get();
			} catch (Exception e) {
				logger.error("AreaService.'\n' Method: getArea() '\n' Error Details:" + e.getMessage());
				throw new ServerErrorException(e.getMessage());
			}
			return area;
		}
		/**
		 * update area information
		 * @param area
		 * @param id
		 */
		public Area updateArea(Area area, Long areaId) {
			Date date = new Date();
			try {
				area.setAreaId(areaId);
				area.setUpdatedAt(date);
				return areaRepository.save(area);
			} catch (Exception e) {
				logger.error("AreaService.\n Method: updateArea() \n Error Details:" + e.getMessage());
				throw new ServerErrorException(e.getMessage());
			}
		}
		/**
		 * we will no delete any data permanently
		 * first get all Area list which is not deleted
		 * after that set isDeleted field = true(for our understanding that this data is deleted)
		 * @param areaId
		 */
		public Area deleteArea(Long areaId) {		
			try {
				Area area = areaRepository.findById(areaId).get();
				area.setIsDeleted(true);
				areaRepository.save(area);
				return area;
			} catch (Exception e) {
				logger.error("AreaService.\n Method: deleteArea() \n Error Details:" + e.getMessage());
				throw new ServerErrorException(e.getMessage());
			}
		}
		/**
		 * @param pageable
		 * @return area list with pagination
		 */
		public Page<Area> searchAreas(Pageable pageable) {
			return areaRepository.findAll(pageable);
		}
}
