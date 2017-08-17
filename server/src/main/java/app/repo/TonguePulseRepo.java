package app.repo;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import app.entities.TonguePulseDO;

@Repository
public interface TonguePulseRepo extends CrudRepository<TonguePulseDO, Integer> {

    @Query(value = "select * from tongue_pulse where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public TonguePulseDO getTonguePulseByPatientId(int patientId);

    @Query(value = "select complete from tongue_pulse where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public boolean getCompleteByPatientId(int patientId);

    @Query(value = "select * from tongue_pulse where follow_up = 1 and patient_id = ?1",
            nativeQuery = true)
    public List<TonguePulseDO> getFollowTongue(int patientId);

    @Query(value = "select * from tongue_pulse where patient_id = ?1 and follow_up = 0 order by id desc limit 1",
            nativeQuery = true)
    public TonguePulseDO getDefaultTongue(int patientId);
}
