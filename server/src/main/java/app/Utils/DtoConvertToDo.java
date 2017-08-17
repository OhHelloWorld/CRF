package app.Utils;

import app.dto.FinalDiagnosisSpecialCircumstancesDTO;
import app.entities.FinalDiagnosisSpecialCircumstancesDO;

/**
 * Created by 10210 on 2017/7/12.
 */
public class DtoConvertToDo {

    /**
     * finalDiagnosisSpecialCircumstancesDto convert to finalDiagnosisSpecialCircumstancesDo
     */
    public FinalDiagnosisSpecialCircumstancesDO finalDSCDtoConvertToDo(FinalDiagnosisSpecialCircumstancesDTO fdscDTO) {
        FinalDiagnosisSpecialCircumstancesDO fdscDO = new FinalDiagnosisSpecialCircumstancesDO();

        fdscDO.setId(fdscDTO.getId());
        fdscDO.setPatientId(fdscDTO.getPatientId());
        fdscDO.setPbcClinicalStage(fdscDTO.getPbcClinicalStage());
        fdscDO.setAihClinicalStage(fdscDTO.getAihClinicalStage());
        fdscDO.setChildren(fdscDTO.isChildren());
        fdscDO.setGestationPeriod(fdscDTO.isGestationPeriod());
        fdscDO.setRepeatedRelapse(fdscDTO.isRepeatedRelapse());
        fdscDO.setResistantToSteroidTreatment(fdscDTO.isResistantToSteroidTreatment());
        fdscDO.setPatientsWithChronicHepatitisB(fdscDTO.isPatientsWithChronicHepatitisB());
        fdscDO.setPatientsWithChronicHepatitisC(fdscDTO.isPatientsWithChronicHepatitisC());
        fdscDO.setOverlappingAIHPBC(fdscDTO.isOverlappingAIHPBC());
        fdscDO.setOverlappingAIHPSC(fdscDTO.isOverlappingAIHPSC());
        fdscDO.setAutoimmuneCholangitis(fdscDTO.isAutoimmuneCholangitis());
        fdscDO.setFinalDiagnosisOther(fdscDTO.isFinalDiagnosisOther());
        fdscDO.setComplete(fdscDTO.isComplete());
        return fdscDO;
    }
}
