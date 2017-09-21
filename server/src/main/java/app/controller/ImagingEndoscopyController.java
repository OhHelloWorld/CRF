package app.controller;

import app.dto.MedicineLiverImagingEndoscopyDTO;
import app.service.ImagingEndoScopyService;
import app.service.MlCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 10210 on 2017/9/14.
 */
@RestController
@RequestMapping(path = "api/iesc")
public class ImagingEndoscopyController {

    @Autowired
    private ImagingEndoScopyService imagingEndoScopyService;

    @Autowired
    @Qualifier("imagingEndoScopyImpl")
    private MlCompleteService mlCompleteService;

    @PostMapping(value = "/")
    public void addImageingEndoSc(@RequestBody MedicineLiverImagingEndoscopyDTO mDTO){
        imagingEndoScopyService.addImageingEndoSc(mDTO);
    }

    @GetMapping(value = "/{pId}")
    public MedicineLiverImagingEndoscopyDTO getByPid(@PathVariable Long pId){
        return imagingEndoScopyService.getByPid(pId);
    }

    @GetMapping(value = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }
}
