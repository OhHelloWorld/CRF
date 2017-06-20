package app.service;

import java.util.List;

import app.dto.InputModularDTO;

public interface InputModularService {

    public void saveInputModularService(InputModularDTO inputModularDTO);

    public List<InputModularDTO> getInputModularByInformationId(int informationId);
}
