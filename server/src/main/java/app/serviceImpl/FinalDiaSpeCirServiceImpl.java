package app.serviceImpl;

import app.Utils.ConvertUtil;
import app.dto.FinalDiagnosisSpecialCircumstancesDTO;
import app.entities.FinalDiagnosisSpecialCircumstancesDO;
import app.repo.FinalDiaSpeCirRepo;
import app.service.FinalDiaSpeCirService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by 10210 on 2017/7/12.
 */
@Service
public class FinalDiaSpeCirServiceImpl implements FinalDiaSpeCirService {

    @Autowired
    private FinalDiaSpeCirRepo fdscRepo;

    private ConvertUtil converUtil = new ConvertUtil();

    @Override
    public void saveFinalDiagnosisSpecialCircumstances(
            FinalDiagnosisSpecialCircumstancesDTO finalDTO) {

        FinalDiagnosisSpecialCircumstancesDO fdscDO = new FinalDiagnosisSpecialCircumstancesDO();
        fdscDO.setPatientId(finalDTO.getPatientId());
        fdscDO.setPbcClinicalStage(finalDTO.getPbcClinicalStage());
        fdscDO.setAihClinicalStage(finalDTO.getAihClinicalStage());
        fdscDO.setChildren(finalDTO.isChildren());
        fdscDO.setGestationPeriod(finalDTO.isGestationPeriod());
        fdscDO.setRepeatedRelapse(finalDTO.isRepeatedRelapse());
        fdscDO.setResistantToSteroidTreatment(finalDTO.isResistantToSteroidTreatment());
        fdscDO.setPatientsWithChronicHepatitisB(finalDTO.isPatientsWithChronicHepatitisB());
        fdscDO.setPatientsWithChronicHepatitisC(finalDTO.isPatientsWithChronicHepatitisC());
        fdscDO.setOverlappingAIHPBC(finalDTO.isOverlappingAIHPBC());
        fdscDO.setOverlappingAIHPSC(finalDTO.isOverlappingAIHPSC());
        fdscDO.setAutoimmuneCholangitis(finalDTO.isAutoimmuneCholangitis());
        fdscDO.setFinalDiagnosisOther(finalDTO.isFinalDiagnosisOther());
        fdscDO.setComplete(finalDTO.isComplete());
        fdscRepo.save(fdscDO);
    }

    @Override
    public FinalDiagnosisSpecialCircumstancesDTO getInformation(Long id) {
        if (fdscRepo.getInformation(id) != null) {
            return converUtil.finalDSCDoConvertToDto(fdscRepo.getInformation(id));
        } else {
            return null;
        }
    }

    @Override
    public boolean getCompleteByPatientId(int patientId) {
        try {
            return fdscRepo.getCompleteByPatientId(patientId);
        } catch (Exception e) {
            return false;
        }
    }
}
