package app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.SimpleAIHDO;

public interface SimpleAIHRepo extends CrudRepository<SimpleAIHDO, Integer> {

    @Query(value = "select * from simple_aih where patient_id =?1 order by id desc limit 1",
            nativeQuery = true)
    public SimpleAIHDO getSimpleAIH(int patientId);

    @Query(value = "select complete from simple_aih where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public Boolean getCompleteByPatientId(int patientId);

    @Query(value = "select * from simple_aih where patient_id = ?1 order by id desc limit 1",
            nativeQuery = true)
    public SimpleAIHDO getDefaultSimpleAIH(int patientId);
}
