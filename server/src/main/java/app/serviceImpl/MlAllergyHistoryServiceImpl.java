package app.serviceImpl;

import app.dto.MedicineLiverAllergyHistoryDTO;
import app.entities.MedicineLiverAllergyHistoryDO;
import app.repo.MlAllergyHistoryRepo;
import app.service.MlAllergyHistoryService;
import app.service.MlCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
@Service
public class MlAllergyHistoryServiceImpl implements MlAllergyHistoryService,MlCompleteService{

    @Autowired
    private MlAllergyHistoryRepo mlAllergyHistoryRepo;

    private MedicineLiverAllergyHistoryDO convertToEntity(MedicineLiverAllergyHistoryDTO medicineLiverAllergyHistoryDTO){
        MedicineLiverAllergyHistoryDO medicineLiverAllergyHistoryDO = new MedicineLiverAllergyHistoryDO();
        medicineLiverAllergyHistoryDO.setPatientId(medicineLiverAllergyHistoryDTO.getPatientId());
        medicineLiverAllergyHistoryDO.setComplete(medicineLiverAllergyHistoryDTO.isComplete());
        medicineLiverAllergyHistoryDO.setAllergen(medicineLiverAllergyHistoryDTO.getAllergen());
        medicineLiverAllergyHistoryDO.setAllergyHistory(medicineLiverAllergyHistoryDTO.getAllergyHistory());
        return medicineLiverAllergyHistoryDO;
    }

    private MedicineLiverAllergyHistoryDTO convertToDTO(MedicineLiverAllergyHistoryDO medicineLiverAllergyHistoryDO){
        MedicineLiverAllergyHistoryDTO medicineLiverAllergyHistoryDTO = new MedicineLiverAllergyHistoryDTO();
        medicineLiverAllergyHistoryDTO.setAllergyHistory(medicineLiverAllergyHistoryDO.getAllergyHistory());
        medicineLiverAllergyHistoryDTO.setAllergen(medicineLiverAllergyHistoryDO.getAllergen());
        medicineLiverAllergyHistoryDTO.setComplete(medicineLiverAllergyHistoryDO.isComplete());
        medicineLiverAllergyHistoryDTO.setId(medicineLiverAllergyHistoryDO.getId());
        return medicineLiverAllergyHistoryDTO;
    }

    @Override
    public void saveAllergyHistory(MedicineLiverAllergyHistoryDTO medicineLiverAllergyHistoryDTO) {
        mlAllergyHistoryRepo.save(convertToEntity(medicineLiverAllergyHistoryDTO));
    }

    @Override
    public MedicineLiverAllergyHistoryDTO getAllergyByPatientId(int mlPatientId) {
        return mlAllergyHistoryRepo.getAllergyHistoryByPatientId(mlPatientId) != null ? convertToDTO(mlAllergyHistoryRepo.getAllergyHistoryByPatientId(mlPatientId)) : null;
    }

    @Override
    public Boolean getCompleteByPatient(int mlPatientId) {
        return mlAllergyHistoryRepo.getCompleteByPatientId(mlPatientId);
    }
}
