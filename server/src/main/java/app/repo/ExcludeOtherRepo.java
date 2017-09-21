package app.repo;

import app.dto.MedicineLiverExcludeOtherDTO;
import app.entities.MedicineLiverExcludeOtherDO;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 10210 on 2017/9/14.
 */
@Repository
public interface ExcludeOtherRepo extends CrudRepository<MedicineLiverExcludeOtherDO, Long>{

    @Query(value = "select * from medicine_liver_exclude_other where patient_id=?1 " +
            "order by id desc limit 1;", nativeQuery = true)
    public MedicineLiverExcludeOtherDO getByPatientId(Long pId);

    @Query(value = "select complete from medicine_liver_exclude_other where patient_id = ?1 order by id desc limit 1",nativeQuery = true)
    public Boolean getCompleteByPatientId(int mlPatientId);
}
