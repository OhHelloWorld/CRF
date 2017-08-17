package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.Utils.UserMsgTool;
import app.dto.MessageDTO;
import app.dto.PageDTO;
import app.entities.MessageDO;
import app.repo.MessageRepo;
import app.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by 52400 on 2017/6/30.
 */

@Service
public class MessageServiceImpl implements MessageService {

    @Autowired
    private MessageRepo messageRepo;

    @Autowired
    private UserMsgTool userMsgTool;

    @Autowired
    private ConvertUtil convertUtil;

    public PageDTO<MessageDTO> getCurrentUserMessage(Pageable pageable) {
        return getPageDTO(messageRepo.findByReceivedUserId(pageable, userMsgTool.getCurrentUserId()));
    }

    public void readMessage(Long messageId) {
        MessageDO messageDO = messageRepo.findOne(messageId);
        messageDO.setRead(true);
        messageRepo.save(messageDO);
    }

    @Override
    public List<MessageDTO> getNotReadMessage() {
        List<MessageDTO> messageDTOList = new ArrayList<>();
        for(MessageDO m : messageRepo.findNotRead(userMsgTool.getCurrentUserId())) {
            messageDTOList.add(convertUtil.convertToMessageDTO(m));
        }
        return messageDTOList;
    }

    public PageDTO<MessageDTO> getPageDTO(Page<MessageDO> messageDOS) {
        PageDTO<MessageDTO> pageDTO = new PageDTO<>();
        List<MessageDTO> messageDTOList = new ArrayList<>();
        for(MessageDO m : messageDOS.getContent()) {
            messageDTOList.add(convertUtil.convertToMessageDTO(m));
        }
        pageDTO.setContent(messageDTOList);
        pageDTO.setTotalNumber(messageDOS.getTotalPages());
        return pageDTO;
    }

}
