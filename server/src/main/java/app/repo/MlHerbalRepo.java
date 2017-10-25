package app.repo;

import app.entities.MlChineseHerbalMedicineDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
public interface MlHerbalRepo extends CrudRepository<MlChineseHerbalMedicineDO,Integer>{

    @Transactional
    @Modifying
    @Query(value = "delete from ml_chinese_herbal_medicine where ml_chinese_medicine_history_id = ?1",nativeQuery = true)
    void deleteHerbalChineseById(int historyId);
}
