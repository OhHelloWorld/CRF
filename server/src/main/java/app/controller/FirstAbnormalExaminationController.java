package app.controller;

import app.dto.MedicineLiverFirstAbnormalExaminationDTO;
import app.service.FirstAbnormalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by 10210 on 2017/9/7.
 */
@RestController
@RequestMapping(path = "/api/mlfae")
public class FirstAbnormalExaminationController {

    @Autowired
    private FirstAbnormalExaminationService firstAbnormalExaminationService;

    @PostMapping(path = "/")
    public void addMsg(MedicineLiverFirstAbnormalExaminationDTO mlfaeDto) {
        firstAbnormalExaminationService.addMsg(mlfaeDto);
    }

//    @GetMapping(path = "/")
//    public void addMsgByPID(MedicineLiverFirstAbnormalExaminationDO mlfaeDo) {
//
//    }
}
