package app.controller;

import app.dto.MedicineLiverExcludeOtherDTO;
import app.entities.MedicineLiverExcludeOtherDO;
import app.service.ExcludeOtherService;
import app.service.MlCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;

/**
 * Created by 10210 on 2017/9/14.
 */
@RestController
@RequestMapping(path = "api/exclude")
public class ExcludeOtherController {

    @Autowired
    private ExcludeOtherService excludeOtherService;

    @Autowired
    @Qualifier("excludeOtherServiceImpl")
    private MlCompleteService mlCompleteService;

    @PostMapping(value = "/")
    public void addExcludeOther(@RequestBody MedicineLiverExcludeOtherDTO medicineLiverExcludeOtherDTO){
        excludeOtherService.addExcludeOther(medicineLiverExcludeOtherDTO);
    }

    @GetMapping(value = "/{pId}")
    public MedicineLiverExcludeOtherDTO getByPatientId(@PathVariable Long pId) {
        return excludeOtherService.getByPatientId(pId);
    }

    @GetMapping(value = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }
}
