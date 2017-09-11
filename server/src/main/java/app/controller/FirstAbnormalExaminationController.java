package app.controller;

import app.dto.MedicineLiverFirstAbnormalExaminationDTO;
import app.service.FirstAbnormalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 10210 on 2017/9/7.
 */
@RestController
@RequestMapping(path = "/api/mlfae")
public class FirstAbnormalExaminationController {

    @Autowired
    private FirstAbnormalExaminationService firstAbnormalExaminationService;

    @PostMapping(value = "/")
    public void addMsg(@RequestBody MedicineLiverFirstAbnormalExaminationDTO mlfaeDto) {
        firstAbnormalExaminationService.addMsg(mlfaeDto);
    }

    @GetMapping(value = "/{pId}")
    public MedicineLiverFirstAbnormalExaminationDTO getMsgByPID(@PathVariable Long pId) {
        return firstAbnormalExaminationService.getMsgByPID(pId);
    }
}
