package app.controller;

import app.dto.MedicineLiverDiseaseOutcomeDTO;
import app.service.MlCompleteService;
import app.service.MlDiseaseOutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
@RestController
@RequestMapping(path = "/api/diseaseOutcome")
public class MlDiseaseOutcomeController {

    @Autowired
    private MlDiseaseOutcomeService mlDiseaseOutcomeService;

    @Autowired
    @Qualifier("mlDiseaseOutcomeServiceImpl")
    private MlCompleteService mlCompleteService;

    @PostMapping(path = "")
    public void saveMlDiseaseOutcome(@RequestBody MedicineLiverDiseaseOutcomeDTO medicineLiverDiseaseOutcomeDTO){
        mlDiseaseOutcomeService.saveMlDiseaseOutcome(medicineLiverDiseaseOutcomeDTO);
    }

    @GetMapping(path = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable  int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }

    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverDiseaseOutcomeDTO getMlDiseaseByPatientId(@PathVariable int mlPatientId){
        return mlDiseaseOutcomeService.getMlDiseaseOutcome(mlPatientId);
    }
}
