package app.controller;

import app.dto.MedicineLiverImagingEndoscopyDTO;
import app.service.ImagingEndoScopyService;
import app.service.MlCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by 10210 on 2017/9/14.
 * 影像学和内窥镜检查
 */
@RestController
@RequestMapping(path = "api/iesc")
public class ImagingEndoscopyController {

    @Autowired
    private ImagingEndoScopyService imagingEndoScopyService;

    @Autowired
    @Qualifier("imagingEndoScopyImpl")
    private MlCompleteService mlCompleteService;

    /**
     * 新增数据
     * @param mDTO
     */
    @PostMapping(value = "/")
    public void addImageingEndoSc(@RequestBody MedicineLiverImagingEndoscopyDTO mDTO){
        imagingEndoScopyService.addImageingEndoSc(mDTO);
    }

    /**
     * 根据患者ID得到最新的数据
     * @param pId
     * @return
     */
    @GetMapping(value = "/{pId}")
    public MedicineLiverImagingEndoscopyDTO getByPid(@PathVariable Long pId){
        return imagingEndoScopyService.getByPid(pId);
    }

    /**
     * 根据患者ID得到完成情况
     * @param mlPatientId
     * @return
     */
    @GetMapping(value = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }
}
