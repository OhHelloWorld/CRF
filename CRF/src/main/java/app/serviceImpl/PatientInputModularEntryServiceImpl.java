package app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.PatientInputModularEntryDTO;
import app.entities.PatientInputModularEntryDO;
import app.repo.PatientInputModularEntryRepo;
import app.service.PatientInputModularEntryService;

@Service
public class PatientInputModularEntryServiceImpl implements PatientInputModularEntryService {

    @Autowired
    private PatientInputModularEntryRepo patientInputModularEntryRepo;

    @Override
    public void saveInputEntry(PatientInputModularEntryDTO patientInputModularEntryDTO) {

        patientInputModularEntryRepo.save(convertToDO(patientInputModularEntryDTO));
    }

    @Override
    public List<PatientInputModularEntryDTO> getInputEntryByPatientIdAndInformationId(int patientId,
            int informationId) {
        List<PatientInputModularEntryDO> patientInputModularEntryDOs = patientInputModularEntryRepo
                .getPatientInputModularEntryDOs(patientId, informationId);
        List<PatientInputModularEntryDTO> patientInputModularEntryDTOs = new ArrayList<>();
        for (PatientInputModularEntryDO patientInputModularEntryDO : patientInputModularEntryDOs) {
            patientInputModularEntryDTOs.add(convertToDTO(patientInputModularEntryDO));
        }
        return patientInputModularEntryDTOs;
    }

    private PatientInputModularEntryDO convertToDO(
            PatientInputModularEntryDTO patientInputModularEntryDTO) {

        PatientInputModularEntryDO patientInputModularEntryDO = new PatientInputModularEntryDO();
        patientInputModularEntryDO.setInputData(patientInputModularEntryDTO.getInputData());
        patientInputModularEntryDO
                .setInputModularId(patientInputModularEntryDTO.getInputModularId());
        patientInputModularEntryDO.setInformationId(patientInputModularEntryDTO.getInformationId());
        patientInputModularEntryDO.setPatientId(patientInputModularEntryDO.getPatientId());
        return patientInputModularEntryDO;
    }

    private PatientInputModularEntryDTO convertToDTO(
            PatientInputModularEntryDO patientInputModularEntryDO) {
        PatientInputModularEntryDTO patientInputModularEntryDTO = new PatientInputModularEntryDTO();
        patientInputModularEntryDTO.setId(patientInputModularEntryDO.getId());
        patientInputModularEntryDTO.setInformationId(patientInputModularEntryDO.getInformationId());
        patientInputModularEntryDTO.setInputData(patientInputModularEntryDO.getInputData());
        patientInputModularEntryDTO
                .setInputModularId(patientInputModularEntryDO.getInputModularId());
        patientInputModularEntryDTO.setPatientId(patientInputModularEntryDO.getPatientId());
        return patientInputModularEntryDTO;
    }


}
