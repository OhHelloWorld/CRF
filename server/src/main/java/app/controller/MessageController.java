package app.controller;

import app.dto.MessageDTO;
import app.dto.PageDTO;
import app.service.MessageService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 * 消息
 */
@RestController
@RequestMapping(path = "/api/message")
@Api(value = "消息")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping(value = "/user")
    @ApiOperation(value = "得到当前用户消息")
    public PageDTO<MessageDTO> getCurrentUserMessage(@PageableDefault(value = 15) Pageable pageable) {
        return messageService.getCurrentUserMessage(pageable);
    }

    @GetMapping(value = "/{messageId}")
    @ApiOperation(value = "消息已读")
    public void readMessage(@PathVariable Long messageId) {
        messageService.readMessage(messageId);
    }

    @GetMapping(value = "/noRead")
    @ApiOperation(value = "得到未读消息")
    public List<MessageDTO> getNotReadUserMessage() {
        return messageService.getNotReadMessage();
    }
}
