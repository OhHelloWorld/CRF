package app.repo;

import app.entities.MlPatientDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.entities.PatientDO;

@Repository
public interface MlPatientRepo extends CrudRepository<MlPatientDO, Integer> {

    @Query(value = "select * from medicine_liver_patient where id=?1", nativeQuery = true)
    MlPatientDO getMlPatientInformationById(int id);

    @Query(value = "select complete from medicine_liver_patient where id=?1", nativeQuery = true)
    Boolean getCompleteById(int id);

    @Query(value = "select * from medicine_liver_patient where project_id = ?1 and hospital_id = ?2 order by id and ?#{#pageable}", nativeQuery = true)
    Page<MlPatientDO> getAll(int patientId,Long hospitalId,Pageable pageable);

    @Query(value = "select * from medicine_liver_patient where (name like %?2% or identifier like %?2%) and project_id = ?1 order by ?#{#pageable}",
            nativeQuery = true)
    Page<MlPatientDO> getMlPatientByQueryStr(int projectId,String queryStr, Pageable pageable);

}
