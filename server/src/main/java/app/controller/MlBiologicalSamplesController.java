package app.controller;

import app.dto.MedicineLiverBiologicalSamplesDTO;
import app.service.MlBiologicalSamplesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2017/9/9 0009.
 */
@RestController
@RequestMapping(path = "/api/mlBiologicalSamples")
public class MlBiologicalSamplesController {

    @Autowired
    private MlBiologicalSamplesService mlBiologicalSamplesService;

    @PostMapping(path = "")
    public void saveBiologicalSamples(@RequestBody MedicineLiverBiologicalSamplesDTO medicineLiverBiologicalSamplesDTO){
        mlBiologicalSamplesService.saveBiologicalSamples(medicineLiverBiologicalSamplesDTO);
    }

    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverBiologicalSamplesDTO getBiologicalSamplesByPatientId(@PathVariable int mlPatientId){
        return mlBiologicalSamplesService.getSamplesByPatientId(mlPatientId);
    }
}
