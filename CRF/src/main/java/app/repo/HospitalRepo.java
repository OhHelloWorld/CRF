package app.repo;

import app.entities.HospitalDO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 52400 on 2017/6/21.
 */
public interface HospitalRepo extends CrudRepository<HospitalDO, Long> {
}
