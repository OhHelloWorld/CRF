package app.service;

import app.dto.MessageDTO;
import app.dto.PageDTO;
import org.springframework.data.domain.Pageable;

import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 */
public interface MessageService {

    PageDTO<MessageDTO> getCurrentUserMessage(Pageable pageable);

    void readMessage(Long messageId);

    List<MessageDTO> getNotReadMessage();
}
