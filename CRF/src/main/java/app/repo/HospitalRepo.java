package app.repo;

import app.entities.HospitalDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;



/**
 * Created by 52400 on 2017/6/21.
 */
public interface HospitalRepo extends PagingAndSortingRepository<HospitalDO, Long> {

    @Query(value = "select h.* from hospital h, project_hospital ph where ph.hospital_id = h.id and ph.project_id = ?1 order by ?#{#pageable}", nativeQuery = true)
    Page<HospitalDO> getHospitalByProjectId(Long projectId, Pageable pageable);
}
