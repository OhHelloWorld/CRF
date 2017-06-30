package app.service;

import app.dto.MessageDTO;

import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 */
public interface MessageService {

    public List<MessageDTO> getCurrentUserMessage();
}
