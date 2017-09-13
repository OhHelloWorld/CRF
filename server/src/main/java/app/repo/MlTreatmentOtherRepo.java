package app.repo;

import app.entities.MedicineLiverTreatmentOtherDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public interface MlTreatmentOtherRepo extends CrudRepository<MedicineLiverTreatmentOtherDO,Integer>{

    @Transactional
    @Modifying
    @Query(value = "delete from medicine_liver_treatment_other where medicine_liver_treatment_id = ?1",nativeQuery = true)
    void deleteTreatmentOtherByTId(int treatmentId);

}
