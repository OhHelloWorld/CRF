package app.controller;

import app.dto.MedicineLiverLiverHistologicalDTO;
import app.service.MlCompleteService;
import app.service.MlLiverHistologicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/11 0011.
 * 药肝肝脏检查
 */
@RestController
@RequestMapping(path = "/api/mlLiverHistological")
public class MlLiverHistologicalController {

    @Autowired
    private MlLiverHistologicalService mlLiverHistologicalService;

    @Autowired
    @Qualifier("mlLiverHistologicalServiceImpl")
    private MlCompleteService mlCompleteService;

    /**
     * 新增数据
     * @param medicineLiverLiverHistologicalDTO
     */
    @PostMapping(path = "")
    public void saveMlLiverHistological(@RequestBody MedicineLiverLiverHistologicalDTO medicineLiverLiverHistologicalDTO){
        mlLiverHistologicalService.saveMlLiverHistological(medicineLiverLiverHistologicalDTO);
    }

    /**
     * 根据患者ID得到最新数据的完成情况
     * @param mlPatientId
     * @return
     */
    @GetMapping(path = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable  int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }

    /**
     * 根据患者ID得到最新数据
     * @param mlPatientId
     * @return
     */
    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverLiverHistologicalDTO getMlLiverHistologicalByPatientId(@PathVariable int mlPatientId){
        return mlLiverHistologicalService.getMlLiverHistologicalByPatientId(mlPatientId);
    }
}
