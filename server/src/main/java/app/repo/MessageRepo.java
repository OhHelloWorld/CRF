package app.repo;

import app.entities.MessageDO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 */
public interface MessageRepo extends PagingAndSortingRepository<MessageDO, Long> {

    Page<MessageDO> findByReceivedUserId(Pageable pageable, Long userId);

    @Query(value = "select * from message where received_user_id = ?1 and readed = 0", nativeQuery = true)
    List<MessageDO> findNotRead(Long userId);
}
