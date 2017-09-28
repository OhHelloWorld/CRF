package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.service.CreateExcelService;


@RestController
@RequestMapping(path = "/api/excel")
public class CreateExcelController {

    @Autowired
    private CreateExcelService createExcelService;

    /**
     * 打印四诊信息Excel表
     * 
     * @param fourDiaId
     */
    @PostMapping(path = "/{fourDiaId}")
    public void createFourDiaExcel(@PathVariable int fourDiaId) {
        createExcelService.createFourDiaExcel(fourDiaId);
    }

    /**
     * 打印所有自免肝录入情况Excel表
     */
    @PostMapping(path = "")
    public void createAllExcel() {
        createExcelService.createAllExcel();
    }

    /**
     * 打印所有药肝录入情况Excel表
     */
    @PostMapping(path = "/ml")
    public void mlCreateExcel(){
        createExcelService.createMlAllExcel();
    }
}
