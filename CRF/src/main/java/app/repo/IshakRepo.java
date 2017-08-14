package app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.IshakDO;

public interface IshakRepo extends CrudRepository<IshakDO, Integer> {

    @Query(value = "select * from ishak where patient_id = ?1 order by id desc limit 1",
            nativeQuery = true)
    public IshakDO getIshakByPatientId(int patientId);

    @Query(value = "select choose from ishak where patient_id = ?1 order by id desc limit 1",
            nativeQuery = true)
    public Boolean getChooseByPatientId(int patientId);

    @Query(value = "select complete from ishak where patient_id = ?1 order by id desc limit 1",
            nativeQuery = true)
    public Boolean getCompleteByPatientId(int patientId);

    @Query(value = "select * from ishak where patient_id = ?1 order by id desc limit 1",
            nativeQuery = true)
    public IshakDO getDefaultIshak(int patientId);
}
