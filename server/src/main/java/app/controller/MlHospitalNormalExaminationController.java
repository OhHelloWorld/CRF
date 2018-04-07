package app.controller;

import app.dto.MedicineLiverHospitalAbnormalExaminationDTO;
import app.service.MlCompleteService;
import app.service.MlHospitalAbnormalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
@RestController
@RequestMapping(path = "/api/mlHospitalExam")
public class MlHospitalNormalExaminationController {

    @Autowired
    private MlHospitalAbnormalExaminationService mlHospitalAbnormalExaminationService;

    @Autowired
    @Qualifier("mlHospitalAbnormalExaminationServiceImpl")
    private MlCompleteService mlCompleteService;

    @PostMapping(path = "")
    public void saveExam(@RequestBody MedicineLiverHospitalAbnormalExaminationDTO medicineLiverHospitalAbnormalExaminationDTO){
        mlHospitalAbnormalExaminationService.saveHospitalExam(medicineLiverHospitalAbnormalExaminationDTO);
    }

    @GetMapping(path = "/complete/{mlPatientId}")
    public Boolean getCompleteByPatientId(@PathVariable  int mlPatientId){
        return mlCompleteService.getCompleteByPatient(mlPatientId);
    }

    @GetMapping(path = "/{mlPatientId}")
    public MedicineLiverHospitalAbnormalExaminationDTO getExamByPatientId(@PathVariable int mlPatientId){
        return mlHospitalAbnormalExaminationService.getHospitalExamByPatientId(mlPatientId);
    }


}
