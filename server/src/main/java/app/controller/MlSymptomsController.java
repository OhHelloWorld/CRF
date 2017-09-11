package app.controller;

import app.dto.MedicineLiverSymptomsDTO;
import app.service.MlSymptomsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/8 0008.
 */
@RestController
@RequestMapping(path = "/api/mlSymptoms")
public class MlSymptomsController {

    @Autowired
    private MlSymptomsService mlSymptomsService;

    @PostMapping(path = "")
    public void saveSymptoms(@RequestBody MedicineLiverSymptomsDTO medicineLiverSymptomsDTO){
        mlSymptomsService.saveMlSymptoms(medicineLiverSymptomsDTO);
    }

    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverSymptomsDTO getSymptomsByPatientId(@PathVariable int mlPatientId){
        return mlSymptomsService.getMlSymptomsByPatient(mlPatientId);
    }

}
