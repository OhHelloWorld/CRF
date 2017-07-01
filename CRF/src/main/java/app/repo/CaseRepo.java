package app.repo;

import app.entities.CaseDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 */
public interface CaseRepo extends CrudRepository<CaseDO, Long> {


    @Query(value = "select * from cases c where c.project_id = ?1 and hospital_id = ?2", nativeQuery = true)
    List<CaseDO> findByProjectIdAndHospitalId(Long projectId, Long hospitalId);

    @Query(value = "select * from cases c where c.project_id = ?1 and case_name like %?2%", nativeQuery = true)
    List<CaseDO> findByProjectIdAndCaseName(Long projectId, String  caseName);

    @Query(value = "select * from cases c where c.project_id = ?1", nativeQuery = true)
    List<CaseDO> getByProjectId(Long projectId);
}
