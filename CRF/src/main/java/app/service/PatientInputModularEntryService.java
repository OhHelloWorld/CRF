package app.service;

import java.util.List;

import app.dto.PatientInputModularEntryDTO;

public interface PatientInputModularEntryService {

    public void saveInputEntry(PatientInputModularEntryDTO patientInputModularEntryDTO);

    public List<PatientInputModularEntryDTO> getInputEntryByPatientIdAndInformationId(int patientId,
            int informationId);
}
