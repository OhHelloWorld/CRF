package app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.entities.TonguePulseDO;

@Repository
public interface TonguePulseRepo extends CrudRepository<TonguePulseDO, Integer> {

    @Query(value = "select * from tongue_pulse where patient_id=?1 and complete = true order by id desc limit 1",
            nativeQuery = true)
    public TonguePulseDO getTonguePulseByPatientId(int patientId);

    @Query(value = "select complete from tongue_pulse where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public boolean getCompleteByPatientId(int patientId);
}
