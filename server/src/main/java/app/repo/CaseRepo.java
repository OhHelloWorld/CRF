package app.repo;

import app.entities.MlPatientDO;
import app.entities.PatientDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by 52400 on 2017/6/30.
 */
public interface CaseRepo extends PagingAndSortingRepository<PatientDO, Long> {


    @Query(value = "select * from patient c where c.project_id = ?1 and hospital_id = ?2 order by ?#{#pageable}",
            nativeQuery = true)
    Page<PatientDO> findByProjectIdAndHospitalId(Long projectId, Long hospitalId,
                                                 Pageable pageable);

    @Query(value = "select * from patient where name like %?1% order by ?#{#pageable}",
            nativeQuery = true)
    Page<PatientDO> findByProjectIdAndCaseName(String caseName, Pageable pageable);

    @Query(value = "select * from patient c where c.project_id = ?1 order by ?#{#pageable}",
            nativeQuery = true)
    Page<PatientDO> getByProjectId(Long projectId, Pageable pageable);
}
