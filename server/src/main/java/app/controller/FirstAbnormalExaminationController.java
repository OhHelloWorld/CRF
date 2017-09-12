package app.controller;

import app.dto.MedicineLiverFirstAbnormalExaminationDTO;
import app.service.FirstAbnormalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 10210 on 2017/9/7.
 */
@RestController
@RequestMapping(path = "/api/mlfae")
public class FirstAbnormalExaminationController {

    @Autowired
    private FirstAbnormalExaminationService firstAbnormalExaminationService;

    /**
     * 保存数据
     * @param mlfaeDto
     */
    @PostMapping(value = "/")
    public void addMsg(@RequestBody MedicineLiverFirstAbnormalExaminationDTO mlfaeDto) {
        firstAbnormalExaminationService.addMsg(mlfaeDto);
    }

    /**
     * 得到最新的数据
     * @param pId
     * @return
     */
    @GetMapping(value = "/{pId}")
    public MedicineLiverFirstAbnormalExaminationDTO getMsgByPID(@PathVariable Long pId) {
        return firstAbnormalExaminationService.getMsgByPID(pId);
    }

    /**
     * 根据pId得到所有mlfae 数据，首次数据除外
     * @return
     */
    @GetMapping(value = "/all/{pId}")
    public List<MedicineLiverFirstAbnormalExaminationDTO> getAllMlfaeData(@PathVariable Long pId) {
        return firstAbnormalExaminationService.getAllMlfaeData(pId);
    }
}
