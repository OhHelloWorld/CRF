package app.controller;

import app.dto.MedicineLiverAllergyHistoryDTO;
import app.service.MlAllergyHistoryService;
import app.service.MlCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/12 0012.
 * 过敏史
 */
@RestController
@RequestMapping(path = "/api/mlAllergyHistory")
public class MlAllergyHistoryController {

    @Autowired
    private MlAllergyHistoryService mlAllergyHistoryService;

    @Autowired
    @Qualifier("mlAllergyHistoryServiceImpl")
    private MlCompleteService mlCompleteService;

    /**
     * 增加数据
     * @param medicineLiverAllergyHistoryDTO
     */
    @PostMapping(path = "")
    public void saveAllergyHistory(@RequestBody  MedicineLiverAllergyHistoryDTO medicineLiverAllergyHistoryDTO){
        mlAllergyHistoryService.saveAllergyHistory(medicineLiverAllergyHistoryDTO);
    }

    /**
     * 根据患者ID得到完成情况
     * @param mlPatientId
     * @return
     */
    @GetMapping(path = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable  int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }

    /**
     * 根据患者ID得到最新数据
     * @param mlPatientId
     * @return
     */
    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverAllergyHistoryDTO getAllergyHistoryByPatientId(@PathVariable int mlPatientId){
        return mlAllergyHistoryService.getAllergyByPatientId(mlPatientId);
    }
}
