package app.repo;

import app.entities.MlSuspendChineseMedicineDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
public interface MlSuspendChineseRepo extends CrudRepository<MlSuspendChineseMedicineDO,Integer>{

    @Transactional
    @Modifying
    @Query(value = "delete from ml_suspend_chinese_medicine where ml_chinese_medicine_history_id = ?1",nativeQuery = true)
    void deleteSusChineseById(int historyId);
}
