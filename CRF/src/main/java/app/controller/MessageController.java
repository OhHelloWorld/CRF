package app.controller;

import app.dto.MessageDTO;
import app.entities.MessageDO;
import app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 */
@RestController
@RequestMapping(path = "/api/message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/user")
    public List<MessageDTO> getCurrentUserMessage() {
        return messageService.getCurrentUserMessage();
    }
}
