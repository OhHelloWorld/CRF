package app.repo;

import app.entities.MedicineLiverBiologicalSamplesDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Administrator on 2017/9/8 0008.
 */
public interface MlBiologicalSamplesRepo extends CrudRepository<MedicineLiverBiologicalSamplesDO,Integer>{

    @Query(value = "select * from medicine_liver_biological_samples where patient_id = ?1 order by id desc limit 1",nativeQuery = true)
    MedicineLiverBiologicalSamplesDO getMlBiologicalByPatientId(int mlPatientId);
}
