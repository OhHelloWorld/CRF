package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.Utils.UserMsgTool;
import app.dto.MessageDTO;
import app.entities.MessageDO;
import app.repo.MessageRepo;
import app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 */
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private UserMsgTool userMsgTool;

    @Autowired
    private ConvertUtil convertUtil;

    public List<MessageDTO> getCurrentUserMessage() {
        List<MessageDTO> messageDTOList = new ArrayList<>();
        for(MessageDO m : messageRepo.findByUserId(userMsgTool.getCurrentUserId())) {
            messageDTOList.add(convertUtil.convertToMessageDTO(m));
        }
        return messageDTOList;
    }

    public void readMessage(Long messageId) {
        MessageDO messageDO = messageRepo.findOne(messageId);
        messageDO.setRead(true);
    }

}
