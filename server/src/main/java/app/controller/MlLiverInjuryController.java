package app.controller;

import app.dto.MedicineLiverLiverInjuryDTO;
import app.service.MlLiverInjuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
@RestController
@RequestMapping(path = "/api/mlLiverInjury")
public class MlLiverInjuryController {

    @Autowired
    private MlLiverInjuryService mlLiverInjuryService;

    @PostMapping(path = "")
    public void saveMlLiverInjury(@RequestBody MedicineLiverLiverInjuryDTO medicineLiverLiverInjuryDTO){
        mlLiverInjuryService.saveMlLiverInjury(medicineLiverLiverInjuryDTO);
    }

    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverLiverInjuryDTO getMlLiverInjuryByPatientId(@PathVariable int mlPatientId){
        return mlLiverInjuryService.getMlLiverInjuryByPatientId(mlPatientId);
    }
}
