package app.controller;


import app.dto.MedicineLiverDiseaseHistoryDTO;
import app.service.MlDiseaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/8/30 0030.
 */
@RestController
@RequestMapping(path = "/api/mlDiseaseHistory")
public class mlDiseaseHistory {

    @Autowired
    private MlDiseaseHistoryService mlDiseaseHistoryService;

    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverDiseaseHistoryDTO getMlDiseaseHistoryByPatientId(@PathVariable int mlPatientId){
        return mlDiseaseHistoryService.getMlDiseaseHistory(mlPatientId);
    }

    @PostMapping(path="")
    public void saveMlDiseaseHistory(@RequestBody MedicineLiverDiseaseHistoryDTO medicineLiverDiseaseHistoryDTO){
        mlDiseaseHistoryService.saveMlDiseaseHistory(medicineLiverDiseaseHistoryDTO);
    }

    @PutMapping(path = "")
    public void updateMlDiseaseHistory(@RequestBody MedicineLiverDiseaseHistoryDTO medicineLiverDiseaseHistoryDTO){
        mlDiseaseHistoryService.updateMlDiseaseHistory(medicineLiverDiseaseHistoryDTO);
    }
}
