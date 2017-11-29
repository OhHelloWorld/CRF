package app.repo;

import app.entities.MedicineLiverFourDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/11/27 0027.
 */
public interface MlFourRepo extends CrudRepository<MedicineLiverFourDO,Integer>{

    @Query(value = "select * from ml_four where patient_id=?1 order by id desc limit 1",nativeQuery = true)
    MedicineLiverFourDO findByPatientId(int patientId);

    @Query(value = "select complete from ml_four where patient_id=?1 order by id desc limit 1",nativeQuery = true)
    boolean getCompleteByPatientId(int mlPatientId);

}
