package app.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import app.dto.inputModularDTO;
import app.service.InputModularService;

@RestController
@RequestMapping(path = "/api/inputModular")
public class InputModularController {

    @Autowired
    private InputModularService inputModularService;

    @PostMapping(path = "")
    public void savePrimaryInputModular(@RequestBody inputModularDTO inputModularDTO) {
        inputModularService.saveInputModularService(inputModularDTO);
    }

}
