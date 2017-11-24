package app.controller;


import app.dto.MlPatientDTO;
import app.dto.PageDTO;
import app.service.MlPatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Administrator
 * @category 患者信息
 */
@RestController
@RequestMapping(path = "/api/mlPatient")
public class MlPatientController {

    @Autowired
    private MlPatientService mlPatientService;

    /**
     * 存储患者一般资料
     *
     * @param mlPatientDTO
     */
    @PostMapping(path = "")
    public int saveMlPatientGeneralInformation(@RequestBody MlPatientDTO mlPatientDTO) {
        return mlPatientService.saveMlPatientGeneralInformation(mlPatientDTO);
    }

    /**
     * 根据id更新病人的基本资料
     *
     */
    @PutMapping(path = "")
    public void updatePatientInfo(@RequestBody MlPatientDTO mlPatient) {
        mlPatientService.editMlPatient(mlPatient);
    }

    /**
     * ͨ根据id得到患者一般资料
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/{id}")
    public MlPatientDTO getMlPatientGeneralInformation(@PathVariable int id) {
        return mlPatientService.getMlPatientGeneralInformation(id);
    }

    /**
     * 得到患者的一般资料的填写状态
     *
     * @param id
     * @return
     */
    @GetMapping(path = "/complete/{id}")
    public boolean getCompleteById(@PathVariable int id) {
        return mlPatientService.getCompleteById(id);
    }

    /**
     * 得到所有患者的一般资料
     *
     * @return
     */
    @GetMapping(path = "/project/{projectId}")
    public PageDTO<MlPatientDTO> getAllPatient(@PathVariable int projectId,@PageableDefault(value = 10) Pageable pageable) {
        return mlPatientService.getAllPatient(projectId,pageable);
    }

    /**
     * 查询
     *
     * @param queryStr
     * @param pageable
     * @return
     */
    @GetMapping(path = "/{projectId}/q")
    public PageDTO<MlPatientDTO> getPatientByQueryStr(@PathVariable int projectId,@RequestParam("queryStr") String queryStr,
                                                    @PageableDefault(value = 15) Pageable pageable) {
        return mlPatientService.getMlPatientByQueryStr(projectId,queryStr, pageable);
    }

    /**
     * 返回年龄层次数据
     * @return
     */
    @GetMapping(path = "/ageData")
    public List<int[]> getMlPatientAgeData(){
        return mlPatientService.getMlPatientAgeData();
    }

}
