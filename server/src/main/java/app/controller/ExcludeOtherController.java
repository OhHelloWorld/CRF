package app.controller;

import app.dto.MedicineLiverExcludeOtherDTO;
import app.entities.MedicineLiverExcludeOtherDO;
import app.service.ExcludeOtherService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @PostMapping(value = "/")
    public void addExcludeOther(@RequestBody MedicineLiverExcludeOtherDTO medicineLiverExcludeOtherDTO){
        excludeOtherService.addExcludeOther(medicineLiverExcludeOtherDTO);
    }

    @GetMapping(value = "/{pId}")
    public MedicineLiverExcludeOtherDTO getByPatientId(@PathVariable Long pId) {
        return excludeOtherService.getByPatientId(pId);
    }
}
