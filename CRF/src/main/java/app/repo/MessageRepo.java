package app.repo;

import app.entities.MessageDO;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 */
public interface MessageRepo extends CrudRepository<MessageDO, Long> {

    List<MessageDO> findByReceivedUserId(Long userId);
}
