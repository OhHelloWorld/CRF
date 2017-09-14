package app.repo;

import app.entities.MedicineLiverTreatmentDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
public interface MlTreatmentRepo extends CrudRepository<MedicineLiverTreatmentDO,Integer>{

    @Query(value = "select * from medicine_liver_treatment where patient_id=?1 order by id desc limit 1",nativeQuery = true)
    MedicineLiverTreatmentDO getTreatByPatientId(int mlPatientId);

    @Query(value = "select complete from medicine_liver_treatment where patient_id=?1 order by id desc limit 1",nativeQuery = true)
    Boolean getCompleteByPatientId(int mlPatientId);
}
