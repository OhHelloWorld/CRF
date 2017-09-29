package app.controller;

import app.dto.MedicineLiverExcludeOtherDTO;
import app.entities.MedicineLiverExcludeOtherDO;
import app.service.ExcludeOtherService;
import app.service.MlCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by 10210 on 2017/9/14.
 * 排除其他肝病
 */
@RestController
@RequestMapping(path = "api/exclude")
public class ExcludeOtherController {

    @Autowired
    private ExcludeOtherService excludeOtherService;


    @Autowired
    @Qualifier("excludeOtherServiceImpl")
    private MlCompleteService mlCompleteService;

    /**
     * 增加 排除其他肝病 数据
     * @param medicineLiverExcludeOtherDTO
     */
    @PostMapping(value = "/")
    public void addExcludeOther(@RequestBody MedicineLiverExcludeOtherDTO medicineLiverExcludeOtherDTO){
        excludeOtherService.addExcludeOther(medicineLiverExcludeOtherDTO);
    }

    /**
     * 根据患者ID得到该患者最新录入的 排除其他肝病 数据
     * @param pId
     * @return
     */
    @GetMapping(value = "/{pId}")
    public MedicineLiverExcludeOtherDTO getByPatientId(@PathVariable Long pId) {
        return excludeOtherService.getByPatientId(pId);
    }

    /**
     * 根据患者ID得到该患者该表完成情况
     * @param mlPatientId
     * @return
     */
    @GetMapping(value = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }
}
