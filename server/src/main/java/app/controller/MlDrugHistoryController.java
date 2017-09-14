package app.controller;

import app.dto.MedicineLiverSuspectedDrugDTO;
import app.service.MlDrugHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/6 0006.
 */
@RestController
@RequestMapping(path = "/api/mlDrug")
public class MlDrugHistoryController {

    @Autowired
    private MlDrugHistoryService mlDrugHistoryService;

    @PostMapping(path = "")
    public void saveDrugHistory(@RequestBody MedicineLiverSuspectedDrugDTO medicineLiverSuspectedDrugDTO){
        mlDrugHistoryService.saveDrugHistory(medicineLiverSuspectedDrugDTO);
    }

    @GetMapping(path="/{mlPatientId}")
    public MedicineLiverSuspectedDrugDTO getDrugHistoryByPatientId(@PathVariable int mlPatientId){
        return mlDrugHistoryService.getDrugByPatientId(mlPatientId);
    }
}
