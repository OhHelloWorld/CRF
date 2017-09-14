package app.controller;

import app.dto.MedicineLiverTreatmentDTO;
import app.service.MlCompleteService;
import app.service.MlTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
@RestController
@RequestMapping(path = "/api/mlTreatment")
public class MlTreatmentController {

    @Autowired
    private MlTreatmentService mlTreatmentService;

    @Autowired
    @Qualifier("mlTreatmentServiceImpl")
    private MlCompleteService mlCompleteService;

    @PostMapping(path = "")
    public void saveMlTreatment(@RequestBody MedicineLiverTreatmentDTO medicineLiverTreatmentDTO){
        mlTreatmentService.saveMlTreatment(medicineLiverTreatmentDTO);
    }

    @GetMapping(path = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable  int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }

    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverTreatmentDTO getMlTreatmentByPatientId(@PathVariable int mlPatientId){
        return mlTreatmentService.getTreatmentByPatientId(mlPatientId);
    }
}
