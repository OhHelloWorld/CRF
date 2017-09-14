package app.controller;

import app.dto.MedicineLiverLiverHistologicalDTO;
import app.service.MlCompleteService;
import app.service.MlLiverHistologicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
@RestController
@RequestMapping(path = "/api/mlLiverHistological")
public class MlLiverHistologicalController {

    @Autowired
    private MlLiverHistologicalService mlLiverHistologicalService;

    @Autowired
    @Qualifier("mlLiverHistologicalServiceImpl")
    private MlCompleteService mlCompleteService;

    @PostMapping(path = "")
    public void saveMlLiverHistological(@RequestBody MedicineLiverLiverHistologicalDTO medicineLiverLiverHistologicalDTO){
        mlLiverHistologicalService.saveMlLiverHistological(medicineLiverLiverHistologicalDTO);
    }

    @GetMapping(path = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable  int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }

    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverLiverHistologicalDTO getMlLiverHistologicalByPatientId(@PathVariable int mlPatientId){
        return mlLiverHistologicalService.getMlLiverHistologicalByPatientId(mlPatientId);
    }
}
