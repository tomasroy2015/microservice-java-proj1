package jp.co.linkstaff.iis.controller;

import java.util.List;
import org.springframework.hateoas.Link;
import org.springframework.http.HttpStatus;
import jp.co.linkstaff.iis.model.Department;
import org.springframework.http.ResponseEntity;
import jp.co.linkstaff.iis.service.DepartmentService;
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

@RequestMapping(value = "/department")
@EnableHypermediaSupport(type = HypermediaType.HAL)
@RestController
@CrossOrigin
public class DepartmentController {
	@Autowired
	private DepartmentService departmentService;
	
	/**
	 * fetch List<Department> departments
	 * @return departments
	 */
	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = { "application/hal+json" })
	public ResponseEntity<List<Department>> getList() {
		List<Department> departments = departmentService.getAllDepartment();
		for (Department department : departments) {
			Long departmentId = department.getDepartmentId();
			Link selfLink = linkTo(DepartmentController.class).slash(departmentId).withSelfRel();
			department.add(selfLink);
		}
		return  new ResponseEntity<>(departments,HttpStatus.OK);
	}
	/**
	 * get those department(list) which is not deleted 
	 * @return dept
	 */
	@RequestMapping(method = RequestMethod.GET, value = "/original/list")
        public ResponseEntity<List<Department>> getDepartmentOriginalList(){
	    List<Department> dept = departmentService.getAllOriginalDepartment();		
        return new ResponseEntity<>(dept,HttpStatus.OK);
	}
	 
	/**
	 * fetch department info according department id
	 * @param id
	 * @return department
	 */
	@RequestMapping(value = "/{departmentId}")
	public ResponseEntity<Department> getDepartment(@PathVariable Long departmentId) {
		Department department = departmentService.getDepartment(departmentId);

		if (department == null)
			throw new ObjectNotFoundException("Department not found of id-" + departmentId);
		return  new ResponseEntity<>(department,HttpStatus.OK);
	}
	
}
