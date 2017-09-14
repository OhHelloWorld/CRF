package app.repo;

import app.entities.MedicineLiverSuspectedDrugDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/9/6 0006.
 */
public interface MlDrugHistoryRepo extends CrudRepository<MedicineLiverSuspectedDrugDO,Integer>{

    @Query(value = "select * from medicine_liver_suspected_drug where patient_id = ?1 order by id desc limit 1",nativeQuery = true)
    MedicineLiverSuspectedDrugDO getMlDrugByPatientId(int mlPatientId);

    @Query(value = "select complete from medicine_liver_suspected_drug where patient_id = ?1 order by id desc limit 1",nativeQuery = true)
    Boolean getCompleteByPatientId(int mlPatientId);
}
