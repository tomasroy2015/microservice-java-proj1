package jp.co.linkstaff.iis.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import jp.co.linkstaff.iis.model.Inquiry;

/**
 * 
 * @author khaliddhali(ls-215)
 *
 */

@Repository
public interface InquiryRepository extends CrudRepository<Inquiry,Long> {
	
	/*
	@Modifying
	@Query("SELECT inquiry FROM Inquiry inquiry WHERE inquiry.isDeleted = false")
	List<Inquiry> findAll();
	
	@Modifying
	@Query("SELECT inquiry FROM Inquiry inquiry WHERE inquiry.inquiryId = :inquiryId AND inquiry.isDeleted = false")
	Inquiry findById(@Param("inquiryId") Long inquiryId); */
	
	
	List<Inquiry> findByIsDeleted(boolean isDeleted);
	
	/**
	 * Overload Method: findByIsDeleted 
	 * Return Pageable instance, that need some implementation.
	 * @param isDeleted
	 * @param pageable
	 * @return
	 */
	Page<Inquiry> findByIsDeleted(@Param("isDeleted")boolean isDeleted, Pageable pageable);
	
	Inquiry findByIsDeletedAndInquiryId(boolean isDeleted, Long id);	
	List<Inquiry> findByIsDeletedAndNameIgnoreCase(boolean isDeleted, String name);	
	List<Inquiry> findByIsDeletedAndInquiryTypeIgnoreCase(boolean isDeleted, String inquiryType);
	List<Inquiry> findByIsDeletedAndEmailIgnoreCase(boolean isDeleted, String email);
	List<Inquiry> findByIsDeletedAndTelIgnoreCase(boolean isDeleted, String tel);	
	List<Inquiry> findByIsDeletedAndJobCodeIgnoreCase(boolean isDeleted, String jobCode);
	List<Inquiry> findByIsDeletedAndNameKana(boolean isDeleted, String nameKana);
	
	@Query("UPDATE Inquiry inquiry SET inquiry.isDeleted = TRUE WHERE inquiry.inquiryId = :inquiryId")
	void deleteInquiry(@Param("inquiryId") Long inquiryId);
	
}