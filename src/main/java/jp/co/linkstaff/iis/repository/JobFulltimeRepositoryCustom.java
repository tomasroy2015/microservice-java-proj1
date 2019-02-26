package jp.co.linkstaff.iis.repository;
import java.util.Collection;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.lang.Nullable;

import jp.co.linkstaff.iis.model.JobFulltime;
/**
 * 
 * @author Roy
 *
 */
public interface JobFulltimeRepositoryCustom {
    Page<JobFulltime> searchJobsCustom(@Nullable String keyword,@Nullable Collection<String> station,@Nullable Collection<String> pref,@Nullable String content,@Nullable String subject,boolean ispublic,Pageable pageable);
}