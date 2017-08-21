package app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.ComplexAIHBeforeTreatmentDTO;
import app.entities.ComplexAIHBeforeTreatmentDO;
import app.repo.ComplexAIHBeforeTreatmentRepo;
import app.service.ComplexAIHBeforeTreatmentService;

@Service
public class ComplexAIHBeforeTreatmentServiceImpl implements ComplexAIHBeforeTreatmentService {

    @Autowired
    private ComplexAIHBeforeTreatmentRepo complexAIHBeforeTreatmentRepo;

    private ComplexAIHBeforeTreatmentDO convertToEntity(
            ComplexAIHBeforeTreatmentDTO complexAIHBeforeTreatmentDTO) {
        ComplexAIHBeforeTreatmentDO complexAIHBeforeTreatmentDO = new ComplexAIHBeforeTreatmentDO();
        complexAIHBeforeTreatmentDO
                .setAlcoholIntake(complexAIHBeforeTreatmentDTO.getAlcoholIntake());
        complexAIHBeforeTreatmentDO.setaLPAST(complexAIHBeforeTreatmentDTO.getaLPAST());
        complexAIHBeforeTreatmentDO.setAmaPositive(complexAIHBeforeTreatmentDTO.getAmaPositive());
        complexAIHBeforeTreatmentDO.setAna(complexAIHBeforeTreatmentDTO.getAna());
        complexAIHBeforeTreatmentDO.setComplete(complexAIHBeforeTreatmentDTO.isComplete());
        complexAIHBeforeTreatmentDO
                .setHepatitisVirusMarkers(complexAIHBeforeTreatmentDTO.getHepatitisVirusMarkers());
        complexAIHBeforeTreatmentDO.setHistoryDrugs(complexAIHBeforeTreatmentDTO.getHistoryDrugs());
        complexAIHBeforeTreatmentDO.setLiverCheck(complexAIHBeforeTreatmentDTO.getLiverCheck());
        complexAIHBeforeTreatmentDO.setOtherAvailableParameters(
                complexAIHBeforeTreatmentDTO.getOtherAvailableParameters());
        complexAIHBeforeTreatmentDO
                .setOtherImmuneDiseases(complexAIHBeforeTreatmentDTO.getOtherImmuneDiseases());
        complexAIHBeforeTreatmentDO.setPatientId(complexAIHBeforeTreatmentDTO.getPatientId());
        complexAIHBeforeTreatmentDO
                .setSerumGlobulinNormal(complexAIHBeforeTreatmentDTO.getSerumGlobulinNormal());
        complexAIHBeforeTreatmentDO.setWoman(complexAIHBeforeTreatmentDTO.getWoman());
        return complexAIHBeforeTreatmentDO;

    }

    private ComplexAIHBeforeTreatmentDTO convertToDto(
            ComplexAIHBeforeTreatmentDO complexAIHBeforeTreatmentDO) {
        ComplexAIHBeforeTreatmentDTO complexAIHBeforeTreatmentDTO =
                new ComplexAIHBeforeTreatmentDTO();
        complexAIHBeforeTreatmentDTO.setId(complexAIHBeforeTreatmentDO.getId());
        complexAIHBeforeTreatmentDTO
                .setAlcoholIntake(complexAIHBeforeTreatmentDO.getAlcoholIntake());
        complexAIHBeforeTreatmentDTO.setaLPAST(complexAIHBeforeTreatmentDO.getaLPAST());
        complexAIHBeforeTreatmentDTO.setAmaPositive(complexAIHBeforeTreatmentDO.getAmaPositive());
        complexAIHBeforeTreatmentDTO.setAna(complexAIHBeforeTreatmentDO.getAna());
        complexAIHBeforeTreatmentDTO.setComplete(complexAIHBeforeTreatmentDO.isComplete());
        complexAIHBeforeTreatmentDTO
                .setHepatitisVirusMarkers(complexAIHBeforeTreatmentDO.getHepatitisVirusMarkers());
        complexAIHBeforeTreatmentDTO.setHistoryDrugs(complexAIHBeforeTreatmentDO.getHistoryDrugs());
        complexAIHBeforeTreatmentDTO.setLiverCheck(complexAIHBeforeTreatmentDO.getLiverCheck());
        complexAIHBeforeTreatmentDTO.setOtherAvailableParameters(
                complexAIHBeforeTreatmentDO.getOtherAvailableParameters());
        complexAIHBeforeTreatmentDTO
                .setOtherImmuneDiseases(complexAIHBeforeTreatmentDO.getOtherImmuneDiseases());
        complexAIHBeforeTreatmentDTO.setPatientId(complexAIHBeforeTreatmentDO.getPatientId());
        complexAIHBeforeTreatmentDTO
                .setSerumGlobulinNormal(complexAIHBeforeTreatmentDO.getSerumGlobulinNormal());
        complexAIHBeforeTreatmentDTO.setWoman(complexAIHBeforeTreatmentDO.getWoman());
        return complexAIHBeforeTreatmentDTO;
    }

    @Override
    public void saveComplexAIHBeforeTreatment(
            ComplexAIHBeforeTreatmentDTO complexAIHBeforeTreatmentDTO) {
        complexAIHBeforeTreatmentRepo.save(convertToEntity(complexAIHBeforeTreatmentDTO));
    }

    @Override
    public ComplexAIHBeforeTreatmentDTO getComplexAIHBeforeTreatment(int patientId) {
        if (complexAIHBeforeTreatmentRepo.getComplexAIHBeforeTreatment(patientId) != null) {
            return convertToDto(
                    complexAIHBeforeTreatmentRepo.getComplexAIHBeforeTreatment(patientId));
        } else {
            return null;
        }
    }

    @Override
    public boolean getCompleteByPatientId(int patientId) {
//        try {
//            return complexAIHBeforeTreatmentRepo.getCompleteByPatientId(patientId);
//        } catch (Exception e) {
//            return false;
//        }
        return complexAIHBeforeTreatmentRepo.getCompleteByPatientId(patientId)!=null?complexAIHBeforeTreatmentRepo.getCompleteByPatientId(patientId):false;
    }

}
