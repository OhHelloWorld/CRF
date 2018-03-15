package app.serviceImpl;

import app.dto.MedicineLiverAllergyHistoryDTO;
import app.dto.MedicineLiverAllergyHistoryDetailDTO;
import app.entities.MedicineLiverAllergyHistoryDO;
import app.entities.MedicineLiverAllergyHistoryDetailDO;
import app.repo.MlAllergyHistoryRepo;
import app.service.MlAllergyHistoryService;
import app.service.MlCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

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
        medicineLiverAllergyHistoryDO.setAllergyHistory(medicineLiverAllergyHistoryDTO.getAllergyHistory());
        List<MedicineLiverAllergyHistoryDetailDTO> medicineLiverAllergyHistoryDetailDTOS = medicineLiverAllergyHistoryDTO.getMedicineLiverAllergyHistoryDetailDTOS();
        List<MedicineLiverAllergyHistoryDetailDO> medicineLiverAllergyHistoryDetailDOS = new ArrayList<>();
        for(MedicineLiverAllergyHistoryDetailDTO medicineLiverAllergyHistoryDetailDTO : medicineLiverAllergyHistoryDetailDTOS){
            MedicineLiverAllergyHistoryDetailDO medicineLiverAllergyHistoryDetailDO = new MedicineLiverAllergyHistoryDetailDO();
            medicineLiverAllergyHistoryDetailDO.setAllergen(medicineLiverAllergyHistoryDetailDTO.getAllergen());
            medicineLiverAllergyHistoryDetailDO.setDescription(medicineLiverAllergyHistoryDetailDTO.getDescription());
            medicineLiverAllergyHistoryDetailDO.setMedicineLiverAllergyHistoryDO(medicineLiverAllergyHistoryDO);
            medicineLiverAllergyHistoryDetailDOS.add(medicineLiverAllergyHistoryDetailDO);
        }
        medicineLiverAllergyHistoryDO.setMedicineLiverAllergyHistoryDetailDOS(medicineLiverAllergyHistoryDetailDOS);
        return medicineLiverAllergyHistoryDO;
    }

    private MedicineLiverAllergyHistoryDTO convertToDTO(MedicineLiverAllergyHistoryDO medicineLiverAllergyHistoryDO){
        MedicineLiverAllergyHistoryDTO medicineLiverAllergyHistoryDTO = new MedicineLiverAllergyHistoryDTO();
        medicineLiverAllergyHistoryDTO.setAllergyHistory(medicineLiverAllergyHistoryDO.getAllergyHistory());
        medicineLiverAllergyHistoryDTO.setComplete(medicineLiverAllergyHistoryDO.isComplete());
        medicineLiverAllergyHistoryDTO.setId(medicineLiverAllergyHistoryDO.getId());
        List<MedicineLiverAllergyHistoryDetailDO> medicineLiverAllergyHistoryDetailDOS = medicineLiverAllergyHistoryDO.getMedicineLiverAllergyHistoryDetailDOS();
        List<MedicineLiverAllergyHistoryDetailDTO> medicineLiverAllergyHistoryDetailDTOS = new ArrayList<>();
        for(MedicineLiverAllergyHistoryDetailDO medicineLiverAllergyHistoryDetailDO : medicineLiverAllergyHistoryDetailDOS){
            MedicineLiverAllergyHistoryDetailDTO medicineLiverAllergyHistoryDetailDTO = new MedicineLiverAllergyHistoryDetailDTO();
            medicineLiverAllergyHistoryDetailDTO.setAllergen(medicineLiverAllergyHistoryDetailDO.getAllergen());
            medicineLiverAllergyHistoryDetailDTO.setDescription(medicineLiverAllergyHistoryDetailDO.getDescription());
            medicineLiverAllergyHistoryDetailDTOS.add(medicineLiverAllergyHistoryDetailDTO);
        }
        medicineLiverAllergyHistoryDTO.setMedicineLiverAllergyHistoryDetailDTOS(medicineLiverAllergyHistoryDetailDTOS);
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
