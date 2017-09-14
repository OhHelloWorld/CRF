package app.repo;

import app.entities.MedicineLiverAllergyHistoryDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
public interface MlAllergyHistoryRepo extends CrudRepository<MedicineLiverAllergyHistoryDO,Integer>{

    @Query(value = "select * from medicine_liver_allergy_history where patient_id = ?1 order by id desc limit 1",nativeQuery = true)
    MedicineLiverAllergyHistoryDO getAllergyHistoryByPatientId(int mlPatientId);

    @Query(value = "select complete from medicine_liver_allergy_history where patient_id = ?1 order by id limit 1",nativeQuery = true)
    Boolean getCompleteByPatientId(int mlPatientId);
}
