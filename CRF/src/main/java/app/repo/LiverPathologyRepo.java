package app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.LiverPathologyDO;

public interface LiverPathologyRepo extends CrudRepository<LiverPathologyDO, Integer> {


    @Query(value = "select * from liver_pathology where patient_id = ?1 order by id desc limit 1;",
            nativeQuery = true)
    public LiverPathologyDO getLiverPathology(int patientId);

    @Query(value = "select complete from liver_pathology where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public boolean getCompleteByPatientId(int patientId);
}
