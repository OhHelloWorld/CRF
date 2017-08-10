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

    @PostMapping(path = "/{fourDiaId}")
    public void createFourDiaExcel(@PathVariable int fourDiaId) {
        createExcelService.createFourDiaExcel(fourDiaId);
    }

    @PostMapping(path = "")
    public void createAllExcel() {
        createExcelService.createAllExcel();
    }
}
