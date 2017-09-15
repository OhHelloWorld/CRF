package app.controller;

import app.dto.MedicineLiverImagingEndoscopyDTO;
import app.entities.MedicineLiverImagingEndoscopyDO;
import app.service.ImagingEndoScopyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 10210 on 2017/9/14.
 */
@RestController
@RequestMapping(path = "api/iesc")
public class ImagingEndoscopyController {

    @Autowired
    private ImagingEndoScopyService imagingEndoScopyService;

    @PostMapping(value = "/")
    public void addImageingEndoSc(@RequestBody MedicineLiverImagingEndoscopyDTO mDTO){
        imagingEndoScopyService.addImageingEndoSc(mDTO);
    }

    @GetMapping(value = "/{pId}")
    public MedicineLiverImagingEndoscopyDTO getByPid(@PathVariable Long pId){
        return imagingEndoScopyService.getByPid(pId);
    }
}
