package app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.HaiDO;

public interface HaiRepo extends CrudRepository<HaiDO, Integer> {

    @Query(value = "select * from hai where patient_id = ?1 order by id desc limit 1",
            nativeQuery = true)
    public HaiDO getHaiByPatientId(int patientId);

    @Query(value = "select choose from hai where patient_id = ?1 order by id desc limit 1",
            nativeQuery = true)
    public Boolean getChooseByPatientId(int patientId);

    @Query(value = "select complete from hai where patient_id = ?1 order by id desc limit 1",
            nativeQuery = true)
    public Boolean getCompleteByPatientId(int patientId);

    @Query(value = "select * from hai where patient_id = ?1 order by id desc limit 1",
            nativeQuery = true)
    public HaiDO getDefaultHai(int patientId);
}
