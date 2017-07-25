package app.repo;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import app.entities.BoneDensityDO;

public interface BoneDensityRepo extends CrudRepository<BoneDensityDO, Integer> {

    @Query(value = "select * from bone_density where patient_id =?1 order by id desc limit 1",
            nativeQuery = true)
    public BoneDensityDO getBoneDensity(int patientId);

    @Query(value = "select complete from bone_density where patient_id=?1 order by id desc limit 1",
            nativeQuery = true)
    public boolean getCompleteByPatientId(int patientId);
}
