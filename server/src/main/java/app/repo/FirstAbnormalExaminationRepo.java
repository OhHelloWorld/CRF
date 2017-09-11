package app.repo;

import app.entities.MedicineLiverFirstAbnormalExaminationDO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.validation.ReportAsSingleViolation;

/**
 * Created by 10210 on 2017/9/7.
 */
public interface FirstAbnormalExaminationRepo extends CrudRepository<MedicineLiverFirstAbnormalExaminationDO, Long>{


}
