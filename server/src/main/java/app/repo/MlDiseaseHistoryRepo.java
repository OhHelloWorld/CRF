package app.repo;

import app.entities.MedicineLiverDiseaseHistoryDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/9/4 0004.
 */
public interface MlDiseaseHistoryRepo extends CrudRepository<MedicineLiverDiseaseHistoryDO,Integer>{

    @Query(value = "select * from medicine_liver_disease_history where patient_id=?1 order by patient_id desc limit 1",nativeQuery = true)
    MedicineLiverDiseaseHistoryDO getMlDiseaseHistoryByPatientId(int mlPatientId);


}
