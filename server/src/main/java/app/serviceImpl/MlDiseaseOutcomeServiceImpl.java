package app.serviceImpl;

import app.dto.MedicineLiverDiseaseOutcomeDTO;
import app.entities.MedicineLiverDiseaseOutcomeDO;
import app.repo.MlDiseaseOutcomeRepo;
import app.service.MlCompleteService;
import app.service.MlDiseaseOutcomeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/13 0013.
 */
@Service
public class MlDiseaseOutcomeServiceImpl implements MlDiseaseOutcomeService,MlCompleteService{

    @Autowired
    private MlDiseaseOutcomeRepo mlDiseaseOutcomeRepo;

    private MedicineLiverDiseaseOutcomeDTO convertToDTO(MedicineLiverDiseaseOutcomeDO medicineLiverDiseaseOutcomeDO){
        MedicineLiverDiseaseOutcomeDTO medicineLiverDiseaseOutcomeDTO = new MedicineLiverDiseaseOutcomeDTO();
        medicineLiverDiseaseOutcomeDTO.setComplete(medicineLiverDiseaseOutcomeDO.isComplete());
        medicineLiverDiseaseOutcomeDTO.setId(medicineLiverDiseaseOutcomeDO.getId());
        medicineLiverDiseaseOutcomeDTO.setOutcome(medicineLiverDiseaseOutcomeDO.getOutcome());
        return medicineLiverDiseaseOutcomeDTO;
    }

    private MedicineLiverDiseaseOutcomeDO convertToEntity(MedicineLiverDiseaseOutcomeDTO medicineLiverDiseaseOutcomeDTO){
        MedicineLiverDiseaseOutcomeDO medicineLiverDiseaseOutcomeDO = new MedicineLiverDiseaseOutcomeDO();
        medicineLiverDiseaseOutcomeDO.setOutcome(medicineLiverDiseaseOutcomeDTO.getOutcome());
        medicineLiverDiseaseOutcomeDO.setComplete(medicineLiverDiseaseOutcomeDTO.isComplete());
        medicineLiverDiseaseOutcomeDO.setPatientId(medicineLiverDiseaseOutcomeDTO.getPatientId());
        return medicineLiverDiseaseOutcomeDO;
    }


    @Override
    public void saveMlDiseaseOutcome(MedicineLiverDiseaseOutcomeDTO medicineLiverDiseaseOutcomeDTO) {
        mlDiseaseOutcomeRepo.save(convertToEntity(medicineLiverDiseaseOutcomeDTO));
    }

    @Override
    public MedicineLiverDiseaseOutcomeDTO getMlDiseaseOutcome(int mlPatientId) {
        return mlDiseaseOutcomeRepo.getMlDiseaseOutcome(mlPatientId)!=null?convertToDTO(mlDiseaseOutcomeRepo.getMlDiseaseOutcome(mlPatientId)):null;
    }

    @Override
    public Boolean getCompleteByPatient(int mlPatientId) {
        return mlDiseaseOutcomeRepo.getCompleteByPatientId(mlPatientId);
    }
}
