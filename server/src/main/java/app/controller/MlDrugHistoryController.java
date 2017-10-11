package app.controller;

import app.dto.MedicineLiverSuspectedDrugDTO;
import app.service.MlCompleteService;
import app.service.MlDrugHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/6 0006.
 * 药肝既往用药史
 */
@RestController
@RequestMapping(path = "/api/mlDrug")
public class MlDrugHistoryController {

    @Autowired
    private MlDrugHistoryService mlDrugHistoryService;

    @Autowired
    @Qualifier("mlDrugHistoryServiceImpl")
    private MlCompleteService mlCompleteService;

    /**
     * 新增一条药物史数据
     * @param medicineLiverSuspectedDrugDTO
     */
    @PostMapping(path = "")
    public void saveDrugHistory(@RequestBody MedicineLiverSuspectedDrugDTO medicineLiverSuspectedDrugDTO){
        mlDrugHistoryService.saveDrugHistory(medicineLiverSuspectedDrugDTO);
    }

    /**
     * 根据患者ID得到最新数据完成情况
     * @param mlPatientId
     * @return
     */
    @GetMapping(path = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable  int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }

    /**
     * 根据患者ID得到药物史最新数据
     * @param mlPatientId
     * @return
     */
    @GetMapping(path="/{mlPatientId}")
    public MedicineLiverSuspectedDrugDTO getDrugHistoryByPatientId(@PathVariable int mlPatientId){
        return mlDrugHistoryService.getDrugByPatientId(mlPatientId);
    }
}
