package jp.co.linkstaff.iis.repository;

import java.util.List;
import jp.co.linkstaff.iis.model.Department;
import org.springframework.stereotype.Repository;
import org.springframework.data.repository.CrudRepository;

@Repository
public interface DepartmentRepository extends CrudRepository<Department,Long>{
	/**
	 * @param isDeleted
	 * @return Original Department list(here have no deleted data)
	 */
     List<Department> findByIsDeleted(boolean isDeleted);
     boolean existsByDepartmentCodeAndIsDeleted(String departmentCode,boolean isDeleted);
}
