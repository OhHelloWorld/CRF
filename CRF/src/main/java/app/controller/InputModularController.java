package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.InputModularDTO;
import app.service.InputModularService;

@RestController
@RequestMapping(path = "/api/inputModular")
public class InputModularController {

    @Autowired
    private InputModularService inputModularService;
    
    /**
     * 存储前端新增的输入框类题目
     * @param inputModularDTO
     */
    @PostMapping(path = "")
    public void savePrimaryInputModular(@RequestBody InputModularDTO inputModularDTO) {
        inputModularService.saveInputModularService(inputModularDTO);
    }

    /**
     * 根据信息录入表ID得到该表内输入框类题目
     * @param informationId
     * @return
     */
    @GetMapping(path = "/{informationId}")
    public List<InputModularDTO> getInputModularByInformationId(@PathVariable int informationId) {
        return inputModularService.getInputModularByInformationId(informationId);
    }

}
