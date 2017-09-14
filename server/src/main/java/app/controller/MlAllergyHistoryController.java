package app.controller;

import app.dto.MedicineLiverAllergyHistoryDTO;
import app.service.MlAllergyHistoryService;
import app.service.MlCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
@RestController
@RequestMapping(path = "/api/mlAllergyHistory")
public class MlAllergyHistoryController {

    @Autowired
    private MlAllergyHistoryService mlAllergyHistoryService;

    @Autowired
    @Qualifier("mlAllergyHistoryServiceImpl")
    private MlCompleteService mlCompleteService;


    @PostMapping(path = "")
    public void saveAllergyHistory(@RequestBody  MedicineLiverAllergyHistoryDTO medicineLiverAllergyHistoryDTO){
        mlAllergyHistoryService.saveAllergyHistory(medicineLiverAllergyHistoryDTO);
    }

    @GetMapping(path = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable  int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }

    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverAllergyHistoryDTO getAllergyHistoryByPatientId(@PathVariable int mlPatientId){
        return mlAllergyHistoryService.getAllergyByPatientId(mlPatientId);
    }
}
