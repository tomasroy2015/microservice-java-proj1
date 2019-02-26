package jp.co.linkstaff.iis.repository;
import java.util.Collection;
import java.util.Date;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;

import jp.co.linkstaff.iis.model.JobSpot;
/**
 * 
 * @author Roy
 *
 */
public interface JobSpotRepositoryCustom { 
    Page<JobSpot> searchJobsCustom(boolean ispublic, @Nullable String keyword,@Nullable Collection<String> station,@Nullable Collection<String> pref,
                                   @Nullable String content,@Nullable String subject,@Nullable String shiftpattern, @Nullable Collection<Date> spotdate, Pageable pageable);
}