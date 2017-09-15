package app.controller;

import app.dto.MedicineLiverRoutineBloodDTO;
import app.service.MlRoutineBloodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 10210 on 2017/9/14.
 */
@RestController
@RequestMapping(path = "/api/routineBlood")
public class RoutineBloodController {

    @Autowired
    private MlRoutineBloodService mlRoutineBloodService;

    @PostMapping(value = "/")
    public void addRoutineBlood(@RequestBody MedicineLiverRoutineBloodDTO mDTO) {
        mlRoutineBloodService.addRoutineBlood(mDTO);
    }

    @GetMapping(value = "/{pId}")
    public MedicineLiverRoutineBloodDTO getRoutineByPid(@PathVariable Long pId){
        return mlRoutineBloodService.getRoutineByPid(pId);
    }
}
