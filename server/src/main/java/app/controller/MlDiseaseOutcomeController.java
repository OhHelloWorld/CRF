package app.controller;

import app.dto.MedicineLiverDiseaseOutcomeDTO;
import app.service.MlDiseaseOutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
@RestController
@RequestMapping(path = "/api/diseaseOutcome")
public class MlDiseaseOutcomeController {

    @Autowired
    private MlDiseaseOutcomeService mlDiseaseOutcomeService;

    @PostMapping(path = "")
    public void saveMlDiseaseOutcome(@RequestBody MedicineLiverDiseaseOutcomeDTO medicineLiverDiseaseOutcomeDTO){
        mlDiseaseOutcomeService.saveMlDiseaseOutcome(medicineLiverDiseaseOutcomeDTO);
    }

    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverDiseaseOutcomeDTO getMlDiseaseByPatientId(@PathVariable int mlPatientId){
        return mlDiseaseOutcomeService.getMlDiseaseOutcome(mlPatientId);
    }
}
