package app.repo;

import app.entities.MedicineLiverTreatmentCnDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/11/27 0027.
 */
public interface MlTreatmentCnRepo extends CrudRepository<MedicineLiverTreatmentCnDO,Integer>{

    @Transactional
    @Modifying
    @Query(value = "delete from medicine_liver_treatment_cn where medicine_liver_treatment_id = ?1",nativeQuery = true)
    void deleteTreatmentCnByTId(int treatmentId);
}
