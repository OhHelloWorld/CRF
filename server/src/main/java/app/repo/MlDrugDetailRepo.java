package app.repo;

import app.entities.MedicineLiverSuspectedDrugDetailDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public interface MlDrugDetailRepo extends CrudRepository<MedicineLiverSuspectedDrugDetailDO,Integer> {

    @Transactional
    @Modifying
    @Query(value = "delete from medicine_liver_suspected_drug_detail where medicine_liver_suspected_drug_id = ?1",nativeQuery = true)
    void deleteDrugDetailByDId(int drugId);
}
