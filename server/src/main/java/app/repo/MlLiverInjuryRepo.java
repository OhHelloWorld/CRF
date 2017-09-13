package app.repo;

import app.entities.MedicineLiverLiverInjuryDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
public interface MlLiverInjuryRepo extends CrudRepository<MedicineLiverLiverInjuryDO,Integer>{

    @Query(value = "select * from medicine_liver_liver_injury where patient_id = ?1 order by id desc limit 1",nativeQuery = true)
    MedicineLiverLiverInjuryDO getMlLiverInjuryByPatientId(int mlPatientId);
}
