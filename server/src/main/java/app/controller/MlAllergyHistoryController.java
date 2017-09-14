package app.controller;

import app.dto.MedicineLiverAllergyHistoryDTO;
import app.service.MlAllergyHistoryService;
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
    @Qualifier(value = "mlAllergyHistoryServiceImpl")
    private MlAllergyHistoryService mlAllergyHistoryService;

    @PostMapping(path = "")
    public void saveAllergyHistory(@RequestBody  MedicineLiverAllergyHistoryDTO medicineLiverAllergyHistoryDTO){
        mlAllergyHistoryService.saveAllergyHistory(medicineLiverAllergyHistoryDTO);
    }

    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverAllergyHistoryDTO getAllergyHistoryByPatientId(@PathVariable int mlPatientId){
        return mlAllergyHistoryService.getAllergyByPatientId(mlPatientId);
    }
}
