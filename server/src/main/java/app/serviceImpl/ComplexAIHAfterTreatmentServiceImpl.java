package app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.ComplexAIHAfterTreatmentDTO;
import app.entities.ComplexAIHAfterTreatmentDO;
import app.repo.ComplexAIHAfterTreatmentRepo;
import app.service.ComplexAIHAfterTreatmentService;

@Service
public class ComplexAIHAfterTreatmentServiceImpl implements ComplexAIHAfterTreatmentService {

    @Autowired
    private ComplexAIHAfterTreatmentRepo complexAIHAfterTreatmentRepo;

    private ComplexAIHAfterTreatmentDTO convertToDto(
            ComplexAIHAfterTreatmentDO complexAIHAfterTreatmentDO) {
        ComplexAIHAfterTreatmentDTO complexAIHAfterTreatmentDTO = new ComplexAIHAfterTreatmentDTO();
        complexAIHAfterTreatmentDTO.setId(complexAIHAfterTreatmentDO.getId());
        complexAIHAfterTreatmentDTO.setAlcoholIntake(complexAIHAfterTreatmentDO.getAlcoholIntake());
        complexAIHAfterTreatmentDTO.setaLPAST(complexAIHAfterTreatmentDO.getaLPAST());
        complexAIHAfterTreatmentDTO.setAmaPositive(complexAIHAfterTreatmentDO.getAmaPositive());
        complexAIHAfterTreatmentDTO.setAna(complexAIHAfterTreatmentDO.getAna());
        complexAIHAfterTreatmentDTO.setComplete(complexAIHAfterTreatmentDO.isComplete());
        complexAIHAfterTreatmentDTO
                .setHepatitisVirusMarkers(complexAIHAfterTreatmentDO.getHepatitisVirusMarkers());
        complexAIHAfterTreatmentDTO.setHistoryDrugs(complexAIHAfterTreatmentDO.getHistoryDrugs());
        complexAIHAfterTreatmentDTO.setId(complexAIHAfterTreatmentDO.getId());
        complexAIHAfterTreatmentDTO.setLiverCheck(complexAIHAfterTreatmentDO.getLiverCheck());
        complexAIHAfterTreatmentDTO.setOtherAvailableParameters(
                complexAIHAfterTreatmentDO.getOtherAvailableParameters());
        complexAIHAfterTreatmentDTO
                .setOtherImmuneDiseases(complexAIHAfterTreatmentDO.getOtherImmuneDiseases());
        complexAIHAfterTreatmentDTO.setPatientId(complexAIHAfterTreatmentDO.getPatientId());
        complexAIHAfterTreatmentDTO
                .setResponseTreatment(complexAIHAfterTreatmentDO.getResponseTreatment());
        complexAIHAfterTreatmentDTO
                .setSerumGlobulinNormal(complexAIHAfterTreatmentDO.getSerumGlobulinNormal());
        complexAIHAfterTreatmentDTO.setWoman(complexAIHAfterTreatmentDO.getWoman());
        return complexAIHAfterTreatmentDTO;
    }

    private ComplexAIHAfterTreatmentDO convertToEntity(
            ComplexAIHAfterTreatmentDTO complexAIHAfterTreatmentDTO) {
        ComplexAIHAfterTreatmentDO complexAIHAfterTreatmentDO = new ComplexAIHAfterTreatmentDO();
        complexAIHAfterTreatmentDO.setId(complexAIHAfterTreatmentDTO.getId());
        complexAIHAfterTreatmentDO.setAlcoholIntake(complexAIHAfterTreatmentDTO.getAlcoholIntake());
        complexAIHAfterTreatmentDO.setaLPAST(complexAIHAfterTreatmentDTO.getaLPAST());
        complexAIHAfterTreatmentDO.setAmaPositive(complexAIHAfterTreatmentDTO.getAmaPositive());
        complexAIHAfterTreatmentDO.setAna(complexAIHAfterTreatmentDTO.getAna());
        complexAIHAfterTreatmentDO.setComplete(complexAIHAfterTreatmentDTO.isComplete());
        complexAIHAfterTreatmentDO
                .setHepatitisVirusMarkers(complexAIHAfterTreatmentDTO.getHepatitisVirusMarkers());
        complexAIHAfterTreatmentDO.setHistoryDrugs(complexAIHAfterTreatmentDTO.getHistoryDrugs());
        complexAIHAfterTreatmentDO.setLiverCheck(complexAIHAfterTreatmentDTO.getLiverCheck());
        complexAIHAfterTreatmentDO.setOtherAvailableParameters(
                complexAIHAfterTreatmentDTO.getOtherAvailableParameters());
        complexAIHAfterTreatmentDO
                .setOtherImmuneDiseases(complexAIHAfterTreatmentDTO.getOtherImmuneDiseases());
        complexAIHAfterTreatmentDO.setPatientId(complexAIHAfterTreatmentDTO.getPatientId());
        complexAIHAfterTreatmentDO
                .setResponseTreatment(complexAIHAfterTreatmentDTO.getResponseTreatment());
        complexAIHAfterTreatmentDO
                .setSerumGlobulinNormal(complexAIHAfterTreatmentDTO.getSerumGlobulinNormal());
        complexAIHAfterTreatmentDO.setWoman(complexAIHAfterTreatmentDTO.getWoman());
        return complexAIHAfterTreatmentDO;
    }

    @Override
    public void saveComplexAIHAfterTreatment(
            ComplexAIHAfterTreatmentDTO complexAIHAfterTreatmentDTO) {
        complexAIHAfterTreatmentRepo.save(convertToEntity(complexAIHAfterTreatmentDTO));
    }

    @Override
    public ComplexAIHAfterTreatmentDTO getComplexAIHAfterTreatment(int patientId) {
        if (complexAIHAfterTreatmentRepo.getComplexAIHAfterTreatment(patientId) != null) {
            return convertToDto(
                    complexAIHAfterTreatmentRepo.getComplexAIHAfterTreatment(patientId));
        } else {
            return null;
        }
    }

    @Override
    public boolean getCompleteByPatientId(int patientId) {
//        try {
//            return complexAIHAfterTreatmentRepo.getCompleteByPatientId(patientId);
//        } catch (Exception e) {
//            return false;
//        }
        return complexAIHAfterTreatmentRepo.getCompleteByPatientId(patientId) !=null? complexAIHAfterTreatmentRepo.getCompleteByPatientId(patientId) : false;
    }

}
