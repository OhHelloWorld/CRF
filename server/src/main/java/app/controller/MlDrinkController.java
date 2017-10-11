package app.controller;

import app.dto.MedicineLiverDrinkDTO;
import app.service.MlCompleteService;
import app.service.MlDrinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/5 0005.
 * 药肝饮酒情况
 */
@RestController
@RequestMapping(path = "/api/mlDrink")
public class MlDrinkController {

    @Autowired
    private MlDrinkService mlDrinkService;

    @Autowired
    @Qualifier("mlDrinkServiceImpl")
    private MlCompleteService mlCompleteService;

    /**
     * 根据患者ID得到最新饮酒数据
     * @param mlPatientId
     * @return
     */
    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverDrinkDTO getMlDrinkByPatientId(@PathVariable int mlPatientId){
        return mlDrinkService.getMlDrink(mlPatientId);
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
     * 新增饮酒数据
     * @param mlDrinkDTO
     */
    @PostMapping(path="")
    public void saveMlDiseaseHistory(@RequestBody MedicineLiverDrinkDTO mlDrinkDTO){
        mlDrinkService.saveMlDrink(mlDrinkDTO);
    }
}
