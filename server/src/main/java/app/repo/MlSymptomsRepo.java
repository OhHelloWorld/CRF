package app.repo;

import app.entities.MedicineLiverSymptomsDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/9/8 0008.
 */
public interface MlSymptomsRepo extends CrudRepository<MedicineLiverSymptomsDO,Integer> {

    @Query(value = "select * from medicine_liver_symptoms where patient_id = ?1 order by id desc limit 1",nativeQuery = true)
    MedicineLiverSymptomsDO getMlSysptomsByPatientId(int mlPatient);

    @Query(value = "select complete from medicine_liver_symptoms where patient_id = ?1 order by id desc limit 1",nativeQuery = true)
    Boolean getCompleteByPatientId(int mlPatient);
}
