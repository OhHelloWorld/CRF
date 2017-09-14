package app.repo;

import app.entities.MedicineLiverDrinkDetailDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
public interface MlDrinkDetailRepo extends CrudRepository<MedicineLiverDrinkDetailDO,Integer>{

    @Transactional
    @Modifying
    @Query(value = "delete from medicine_liver_drink_detail where medicine_liver_drink_id = ?1",nativeQuery = true)
    void deleteDrinkDetailByDId(int drinkId);
}
