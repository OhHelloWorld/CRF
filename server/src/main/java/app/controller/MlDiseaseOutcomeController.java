package app.controller;

import app.dto.MedicineLiverDiseaseOutcomeDTO;
import app.service.MlCompleteService;
import app.service.MlDiseaseOutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/13 0013.
 * 药肝疾病转归
 */
@RestController
@RequestMapping(path = "/api/diseaseOutcome")
public class MlDiseaseOutcomeController {

    @Autowired
    private MlDiseaseOutcomeService mlDiseaseOutcomeService;

    @Autowired
    @Qualifier("mlDiseaseOutcomeServiceImpl")
    private MlCompleteService mlCompleteService;

    /**
     * 新增疾病转归数据
     * @param medicineLiverDiseaseOutcomeDTO
     */
    @PostMapping(path = "")
    public void saveMlDiseaseOutcome(@RequestBody MedicineLiverDiseaseOutcomeDTO medicineLiverDiseaseOutcomeDTO){
        mlDiseaseOutcomeService.saveMlDiseaseOutcome(medicineLiverDiseaseOutcomeDTO);
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
     * 根据患者ID得到最新疾病转归数据
     * @param mlPatientId
     * @return
     */
    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverDiseaseOutcomeDTO getMlDiseaseByPatientId(@PathVariable int mlPatientId){
        return mlDiseaseOutcomeService.getMlDiseaseOutcome(mlPatientId);
    }
}
