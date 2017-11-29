package app.controller;

import app.dto.MedicineLiverFourDTO;
import app.service.MlCompleteService;
import app.service.MlFourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/11/28 0028.
 */
@RestController
@RequestMapping(path = "/api/mlFour")
public class MlFourController {

    @Autowired
    private MlFourService mlFourService;

    @Autowired
    @Qualifier("mlFourServiceImpl")
    private MlCompleteService mlCompleteService;

    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverFourDTO getMlFourByPatientId(@PathVariable int mlPatientId){
        return mlFourService.getFourByPatientId(mlPatientId);
    }

    @PostMapping(path = "")
    public void saveMlFour(@RequestBody MedicineLiverFourDTO fourDTO){
        mlFourService.saveFour(fourDTO);
    }

    @GetMapping("/complete/{mlPatientId}")
    public boolean getCompleteByPatientId(@PathVariable int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }

}
