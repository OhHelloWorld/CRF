package app.repo;

import app.entities.MedicineLiverSymptomsOtherDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public interface MlSymptomsOtherRepo extends CrudRepository<MedicineLiverSymptomsOtherDO,Integer>{

    @Transactional
    @Modifying
    @Query(value = "delete from medicine_liver_symptoms_other where medicine_liver_symptoms_id = ?1",nativeQuery = true)
    void deleteSymptomsOtherBySId(int symptomsId);
}
