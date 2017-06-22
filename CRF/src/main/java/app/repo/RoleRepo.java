package app.repo;

import app.entities.SysRoleDO;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by 52400 on 2017/6/20.
 */
public interface RoleRepo  extends CrudRepository<SysRoleDO, Long> {
}
