package app.repo;

import app.entities.OtherImagingEndoscopyDO;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Administrator on 2017/10/17 0017.
 */
public interface OtherImagingEndoscopyRepo extends CrudRepository<OtherImagingEndoscopyDO,Integer> {

    @Transactional
    @Modifying
    @Query(value = "delete from medicine_liver_other_imaging_endoscopy where imaging_endoscopy_id = ?1",nativeQuery = true)
    void deleteOtherByEId(int imagingEndoscopyId);
}
