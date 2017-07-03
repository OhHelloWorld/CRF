package app.repo;

import app.entities.CaseDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 */
public interface CaseRepo extends PagingAndSortingRepository<CaseDO, Long> {


    @Query(value = "select * from cases c where c.project_id = ?1 and hospital_id = ?2 order by ?#{#pageable}", nativeQuery = true)
    Page<CaseDO> findByProjectIdAndHospitalId(Long projectId, Long hospitalId, Pageable pageable);

    @Query(value = "select * from cases c where c.project_id = ?1 and case_name like %?2% order by ?#{#pageable}", nativeQuery = true)
    Page<CaseDO> findByProjectIdAndCaseName(Long projectId, String  caseName, Pageable pageable);

    @Query(value = "select * from cases c where c.project_id = ?1 order by ?#{#pageable}", nativeQuery = true)
    Page<CaseDO> getByProjectId(Long projectId, Pageable pageable);
}
