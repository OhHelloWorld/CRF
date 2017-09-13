package app.repo;

import app.entities.MedicineLiverDiseaseOutcomeDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public interface MlDiseaseOutcomeRepo extends CrudRepository<MedicineLiverDiseaseOutcomeDO,Integer>{

    @Query(value = "select * from medicine_liver_disease_outcome where patient_id = ?1 order by id desc limit 1",nativeQuery = true)
    MedicineLiverDiseaseOutcomeDO getMlDiseaseOutcome(int mlPatientId);
}

