package app.controller;

import app.dto.MedicineLiverSymptomsDTO;
import app.service.MlCompleteService;
import app.service.MlSymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/8 0008.
 */
@RestController
@RequestMapping(path = "/api/mlSymptoms")
public class MlSymptomsController {

    @Autowired
    private MlSymptomsService mlSymptomsService;

    @Autowired
    @Qualifier("mlSymptomsServiceImpl")
    private MlCompleteService mlCompleteService;

    @PostMapping(path = "")
    public void saveSymptoms(@RequestBody MedicineLiverSymptomsDTO medicineLiverSymptomsDTO){
        mlSymptomsService.saveMlSymptoms(medicineLiverSymptomsDTO);
    }

    @GetMapping(path = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable  int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }

    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverSymptomsDTO getSymptomsByPatientId(@PathVariable int mlPatientId){
        return mlSymptomsService.getMlSymptomsByPatient(mlPatientId);
    }

}
