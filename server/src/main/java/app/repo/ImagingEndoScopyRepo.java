package app.repo;

import app.dto.MedicineLiverImagingEndoscopyDTO;
import app.entities.MedicineLiverImagingEndoscopyDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 10210 on 2017/9/14.
 */
public interface ImagingEndoScopyRepo extends CrudRepository<MedicineLiverImagingEndoscopyDO, Long>{

    @Query(value = "select * from medicine_liver_imaging_endoscopy where patient_id = ?1" +
            " order by id desc limit 1;", nativeQuery = true)
    MedicineLiverImagingEndoscopyDO getByPid(Long pId);

    @Query(value = "select complete from medicine_liver_imaging_endoscopy where patient_id = ?1 order by id limit 1",nativeQuery = true)
    Boolean getCompleteByPatientId(int mlPatientId);

}
