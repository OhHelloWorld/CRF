package app.controller;


import app.dto.MedicineLiverDiseaseHistoryDTO;
import app.service.MlCompleteService;
import app.service.MlDiseaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/8/30 0030.
 * 药肝既往疾病史
 */
@RestController
@RequestMapping(path = "/api/mlDiseaseHistory")
public class MlDiseaseHistoryController {

    @Autowired
    private MlDiseaseHistoryService mlDiseaseHistoryService;

    @Autowired
    @Qualifier("mlDiseaseHistoryServiceImpl")
    private MlCompleteService mlCompleteService;

    /**
     * 根据患者ID得到最新数据
     * @param mlPatientId
     * @return
     */
    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverDiseaseHistoryDTO getMlDiseaseHistoryByPatientId(@PathVariable int mlPatientId){
        return mlDiseaseHistoryService.getMlDiseaseHistory(mlPatientId);
    }

    /**
     * 根据患者ID得到最新数据的完成情况
     * @param mlPatientId
     * @return
     */
    @GetMapping(path = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable  int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }

    /**
     * 新增数据
     * @param medicineLiverDiseaseHistoryDTO
     */
    @PostMapping(path="")
    public void saveMlDiseaseHistory(@RequestBody MedicineLiverDiseaseHistoryDTO medicineLiverDiseaseHistoryDTO){
        mlDiseaseHistoryService.saveMlDiseaseHistory(medicineLiverDiseaseHistoryDTO);
    }
}
