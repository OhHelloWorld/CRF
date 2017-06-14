package app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dto.inputModularDTO;
import app.entities.InputModularDO;
import app.repo.InputModularRepo;
import app.service.InputModularService;

@Service
public class InputModularServiceImpl implements InputModularService {

    @Autowired
    private InputModularRepo inputModularRepo;

    @Override
    @Transactional
    public void saveInputModularService(inputModularDTO inputModularDTO) {

        InputModularDO inputModularDO = inputModularRepo.save(convertToDO(inputModularDTO));

    }

    private InputModularDO convertToDO(inputModularDTO inputModularDTO) {
        InputModularDO inputModularDO = new InputModularDO();

        return inputModularDO;
    }

}
