package jp.co.linkstaff.iis.repository;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
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

import jp.co.linkstaff.iis.model.JobSpot;
import jp.co.linkstaff.iis.utils.Util;
/**
 * 
 * @author Roy
 *
 */
@Repository
@Transactional
public class JobSpotRepositoryImpl implements JobSpotRepositoryCustom {
    @PersistenceContext
    EntityManager entityManager;

   @Override
   public  Page<JobSpot> searchJobsCustom(boolean ispublic,@Nullable String keyword,@Nullable Collection<String> station,@Nullable Collection<String> pref,
   @Nullable String content,@Nullable String subject,
   @Nullable String shiftpattern, @Nullable Collection<Date> spotdate, Pageable pageable){
        List<JobSpot> jobs = null;
        Page<JobSpot> pageJob = null;
        List<String> dates = null;
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<JobSpot> cq = cb.createQuery(JobSpot.class); 
        Root<JobSpot> job = cq.from(JobSpot.class);
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

        else if (shiftpattern != null)
           predicate = cb.or(predicate,cb.like(cb.lower(job.get("shiftPattern")), "%"+ shiftpattern.toLowerCase() +"%"));

        else if (spotdate != null){
           for(Date d : spotdate){
            // Format the date to Strings
            String mdy = Util.formatedDate(d);//dmyFormat.format(d);
            dates = new ArrayList<String>();
            dates.add(mdy);
           }
           predicate = cb.or(predicate,job.get("spotDate").as(String.class).in(dates));
        }else{
           predicate = cb.or(predicate,cb.equal(job.get("isPublic"),ispublic));
        }
      
       cq.select(job).where(predicate);
       TypedQuery<JobSpot> query = entityManager.createQuery(cq);
       query.setFirstResult(pageable.getPageNumber()); 
       query.setMaxResults(pageable.getPageSize());

       jobs = query.getResultList();

       pageJob = new PageImpl<>(jobs, pageable,jobs.size());
       return pageJob;
    }
}