package jp.co.linkstaff.iis.repository;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import jp.co.linkstaff.iis.model.FavouriteJobs;

@Repository
public interface FavouriteJobsRepository extends CrudRepository<FavouriteJobs, Long>{
	
	List<FavouriteJobs> findByDoctorId(Long docId);
	List<FavouriteJobs> findByJobCodeIgnoreCase(String jobCode);
	List<FavouriteJobs> findByHospitalCodeIgnoreCase(String hospitalCode);
	List<FavouriteJobs> findByHospitalNameIgnoreCase(String hospitalName);
}
