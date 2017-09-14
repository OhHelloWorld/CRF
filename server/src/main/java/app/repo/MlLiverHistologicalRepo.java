package app.repo;

import app.entities.MedicineLiverLiverHistologicalDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
public interface MlLiverHistologicalRepo extends CrudRepository<MedicineLiverLiverHistologicalDO,Integer>{

    @Query(value = "select * from medicine_liver_liver_histological where patient_id =?1 order by id desc limit 1",nativeQuery = true)
    MedicineLiverLiverHistologicalDO getMlLiverHistologicalByPatientId(int mlPatientId);
}
