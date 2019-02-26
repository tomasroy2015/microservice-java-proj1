package jp.co.linkstaff.iis.repository;
import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import jp.co.linkstaff.iis.model.JobFulltime;
import jp.co.linkstaff.iis.utils.ServerErrorException;

/**
 * 
 * @author Roy
 *
 */
@Repository
@Transactional
public class JobFulltimeRepositoryImpl implements JobFulltimeRepositoryCustom {
   @PersistenceContext
   EntityManager entityManager;

   @Override
   public  Page<JobFulltime> searchJobsCustom(@Nullable String keyword,@Nullable Collection<String> station,@Nullable Collection<String> pref,
   @Nullable String content,@Nullable String subject,boolean ispublic,Pageable pageable){
	  
        List<JobFulltime> jobs = null;
        Page<JobFulltime> pageJob = null;
        try{
         CriteriaBuilder cb = entityManager.getCriteriaBuilder();
         CriteriaQuery<JobFulltime> cq = cb.createQuery(JobFulltime.class); 
         Root<JobFulltime> job = cq.from(JobFulltime.class);
         Predicate predicate = cb.isNull(job.get("jobCode"));
         
         if(keyword != null && !keyword.isEmpty())
            predicate = cb.or(cb.like(cb.lower(job.get("searchKeyword")),"%"+ keyword.toLowerCase() +"%"));     

         else if (station != null)
            predicate = cb.or(predicate, job.get("workStationCode1").in(station));

         else if (pref != null)
            predicate = cb.or(predicate, job.get("workAddress1").in(pref));

         else if (content != null)
            predicate = cb.or(predicate,cb.like(cb.lower(job.get("workContent")), "%"+ content.toLowerCase() +"%"));

         else if (subject != null)
            predicate = cb.or(predicate,cb.like(cb.lower(job.get("subject")), "%"+ subject.toLowerCase() +"%"));

         else
            predicate = cb.or(predicate,cb.equal(job.get("isPublic"),ispublic));
               
         cq.select(job).where(predicate);

         TypedQuery<JobFulltime> query = entityManager.createQuery(cq);
         query.setFirstResult(pageable.getPageNumber()); 
         query.setMaxResults(pageable.getPageSize());
         jobs = query.getResultList();

         pageJob = new PageImpl<>(jobs, pageable,jobs.size());
      }
      catch(Exception ex) {
         throw new ServerErrorException(ex.getMessage());
      }
      
      return pageJob;
    }
}