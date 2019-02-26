package jp.co.linkstaff.iis.service;

import java.util.Date;
import java.util.List;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;
import jp.co.linkstaff.iis.model.Department;
import org.springframework.stereotype.Service;
import jp.co.linkstaff.iis.utils.ServerErrorException;
import jp.co.linkstaff.iis.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;

@Service
public class DepartmentService {
	private static final Logger logger = LogManager.getLogger(DepartmentService.class);
	@Autowired
	private DepartmentRepository departmentRepository;
	/**
	 * add a new instance of Department
	 * @param department
	 */
	public Department addNewDepartment(Department department) {
		try {
			if(departmentRepository.existsByDepartmentCodeAndIsDeleted(department.getDepartmentCode(),false)) {
				throw new ServerErrorException("Department code already exists.Choose another.");
			}
			return departmentRepository.save(department);
		} catch (Exception e) {
			logger.error("DepartmentService.'\n' Method: addNewDepartment() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	public boolean isExistByCode(String code) {
		return departmentRepository.existsByDepartmentCodeAndIsDeleted(code,false);
	}
	/**
	 * fetch list of department
	 * List<Department
	 * @return list
	 */
	public List<Department> getAllDepartment() {
		List<Department> list = (List<Department>) departmentRepository.findAll();
		return list;
	}
	/**
	 * get those Department which is not deleted
	 * @return dept
	 */
	public List<Department> getAllOriginalDepartment(){
		List<Department> dept = null;
		try {
			dept = departmentRepository.findByIsDeleted(false); 
		} catch (Exception e) {			
			throw new ServerErrorException("Exception occured at Service in getAllOriginalDepartment(). "+e);	
		}		
		return dept;
	}
	/**
	 * find a department according id 
	 * @param id
	 * @return department
	 */
	public Department getDepartment(Long departmentId) {
		Department area = null;
		try {
			area = departmentRepository.findById(departmentId).get();
		} catch (Exception e) {
			logger.error("DepartmentService.'\n' Method: getDepartment() '\n' Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
		return area;
	}
	/**
	 * update department information
	 * @param department
	 * @param id
	 */
	public Department updateDepartment(Department department, Long departmentId) {		
		Date date = new Date();
		try {
			department.setDepartmentId(departmentId);
			department.setUpdatedAt(date);
			return departmentRepository.save(department);
		} catch (Exception e) {
			logger.error("DepartmentService.\n Method: updateDepartment() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
	/**
	 * we will no delete any data permanently
	 * first get all Department list which is not deleted
     * after that set isDeleted field = true(for our understanding that this data is deleted)
	 * @param departmentId
	 * @return dept
	 */
	public Department deleteDepartment(Long departmentId) {	
		try {
			Department dept = departmentRepository.findById(departmentId).get();
			dept.setIsDeleted(true);
			departmentRepository.save(dept);
			return dept;
		} catch (Exception e) {
			logger.error("DepartmentService.\n Method: deleteDepartment() \n Error Details:" + e.getMessage());
			throw new ServerErrorException(e.getMessage());
		}
	}
}
