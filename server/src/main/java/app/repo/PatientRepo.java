package app.repo;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.entities.PatientDO;

@Repository
public interface PatientRepo extends CrudRepository<PatientDO, Integer> {

    @Query(value = "select * from patient where id=?1", nativeQuery = true)
    PatientDO getPatientInformationById(int id);

    @Query(value = "select complete from patient where id=?1", nativeQuery = true)
    Boolean getCompleteById(int id);

    @Query(value = "select * from patient where project_id = ?1 and hospital_id = ?2 order by id and ?#{#pageable}", nativeQuery = true)
    Page<PatientDO> getAll(int patientId,Long hospitalId,Pageable pageable);

    @Query(value = "select * from patient where (name like %?2% or identifier like %?2%) and project_id = ?1 order by ?#{#pageable}",
            nativeQuery = true)
    Page<PatientDO> getPatientByQueryStr(int projectId,String queryStr, Pageable pageable);

}
