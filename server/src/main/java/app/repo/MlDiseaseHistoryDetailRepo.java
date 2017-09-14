package app.repo;

import app.entities.MedicineLiverDiseaseHistoryDetailDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public interface MlDiseaseHistoryDetailRepo extends CrudRepository<MedicineLiverDiseaseHistoryDetailDO,Integer>{

    @Transactional
    @Modifying
    @Query(value = "delete from medicine_liver_disease_history_detail where disease_history_id = ?1",nativeQuery = true)
    void deleteDiseaseHistoryDetailByDId(int diseaseHistoryId);
}
