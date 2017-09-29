package app.controller;

import app.dto.MedicineLiverFirstAbnormalExaminationDTO;
import app.service.FirstAbnormalExaminationService;
import app.service.MlCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by 10210 on 2017/9/7.
 * 第一次异常检查
 */
@RestController
@RequestMapping(path = "/api/mlfae")
public class FirstAbnormalExaminationController {

    @Autowired
    private FirstAbnormalExaminationService firstAbnormalExaminationService;

    @Autowired
    @Qualifier("firstAbnormalExaminationServiceImpl")
    private MlCompleteService mlCompleteService;

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
    @GetMapping(value = "/first/{pId}")
    public MedicineLiverFirstAbnormalExaminationDTO getMsgByPID(@PathVariable Long pId) {
        return firstAbnormalExaminationService.getMsgByPID(pId);
    }

    /**
     * 根据pId得到所有mlfae 数据，首次数据除外
     * @return
     */
    @GetMapping(value = "/all/nofirst/{pId}")
    public List<MedicineLiverFirstAbnormalExaminationDTO> getAllMlfaeData(@PathVariable Long pId) {
        return firstAbnormalExaminationService.getAllMlfaeData(pId);
    }

    /**
     * 根据患者ID得到该表完成情况
     * @param mlPatientId
     * @return
     */
    @GetMapping(value = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }

    /**
     * 根据患者ID得到 所有异常检查 数据
     * @param mlPatientId
     * @return
     */
    @GetMapping(path = "/hos/{mlPatientId}")
    public MedicineLiverFirstAbnormalExaminationDTO getHosData(@PathVariable int mlPatientId){
        return firstAbnormalExaminationService.getHosData(mlPatientId);
    }
}
