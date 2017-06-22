package app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dto.InputModularDTO;
import app.entities.InputModularDO;
import app.repo.InformationInputRepo;
import app.repo.InputModularRepo;
import app.service.InputModularService;

@Service
public class InputModularServiceImpl implements InputModularService {

    @Autowired
    private InputModularRepo inputModularRepo;

    @Autowired
    private InformationInputRepo informationInputRepo;

    @Override
    @Transactional
    public void saveInputModularService(InputModularDTO inputModularDTO) {

        inputModularRepo.save(convertToDO(inputModularDTO));

    }

    @Override
    public List<InputModularDTO> getInputModularByInformationId(int informationId) {

        List<Integer> inputModularIds = informationInputRepo.getInputId(informationId);
        List<InputModularDTO> inputModularDTOs = new ArrayList<>();
        for (int id : inputModularIds) {
            inputModularDTOs.add(convertToDTO(inputModularRepo.getInputModularById(id)));
        }
        return inputModularDTOs;
    }

    private InputModularDO convertToDO(InputModularDTO inputModularDTO) {
        InputModularDO inputModularDO = new InputModularDO();
        inputModularDO.setDescription(inputModularDTO.getDescription());
        inputModularDO.setInputLength(inputModularDTO.getInputLength());
        inputModularDO.setInputLimit(inputModularDTO.getInputLimit());
        inputModularDO.setUnit(inputModularDTO.getUnit());
        return inputModularDO;
    }

    private InputModularDTO convertToDTO(InputModularDO inputModularDO) {
        InputModularDTO inputModularDTO = new InputModularDTO();
        inputModularDTO.setDescription(inputModularDO.getDescription());
        inputModularDTO.setId(inputModularDO.getId());
        inputModularDTO.setInputLength(inputModularDO.getInputLength());
        inputModularDTO.setInputLimit(inputModularDO.getInputLimit());
        inputModularDTO.setUnit(inputModularDO.getUnit());
        return inputModularDTO;
    }


}
