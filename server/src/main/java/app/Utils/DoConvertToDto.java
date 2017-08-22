package app.Utils;

import app.dto.FinalDiagnosisSpecialCircumstancesDTO;
import app.entities.FinalDiagnosisSpecialCircumstancesDO;

/**
 * Created by 10210 on 2017/7/12.
 */
public class DoConvertToDto {
    /**
     * finalDiagnosisSpecialCircumstancesDo convert to finalDiagnosisSpecialCircumstancesDto
     */
    public FinalDiagnosisSpecialCircumstancesDTO finalDSCDoConvertToDto(FinalDiagnosisSpecialCircumstancesDO fdscDO) {
        FinalDiagnosisSpecialCircumstancesDTO fdscDTO = new FinalDiagnosisSpecialCircumstancesDTO();
        fdscDTO.setId(fdscDO.getId());
        fdscDTO.setPatientId(fdscDO.getPatientId());
        fdscDTO.setPbcClinicalStage(fdscDO.getPbcClinicalStage());
        fdscDTO.setAihClinicalStage(fdscDO.getAihClinicalStage());
        fdscDTO.setChildren(fdscDO.isChildren());
        fdscDTO.setGestationPeriod(fdscDO.isGestationPeriod());
        fdscDTO.setRepeatedRelapse(fdscDO.isRepeatedRelapse());
        fdscDTO.setResistantToSteroidTreatment(fdscDO.isResistantToSteroidTreatment());
        fdscDTO.setPatientsWithChronicHepatitisB(fdscDO.isPatientsWithChronicHepatitisB());
        fdscDTO.setPatientsWithChronicHepatitisC(fdscDO.isPatientsWithChronicHepatitisC());
        fdscDTO.setOverlappingAIHPBC(fdscDO.isOverlappingAIHPBC());
        fdscDTO.setOverlappingAIHPSC(fdscDO.isOverlappingAIHPSC());
        fdscDTO.setAutoimmuneCholangitis(fdscDO.isAutoimmuneCholangitis());
        fdscDTO.setFinalDiagnosisOther(fdscDO.isFinalDiagnosisOther());
        fdscDTO.setComplete(fdscDO.isComplete());
        return fdscDTO;
    }
}