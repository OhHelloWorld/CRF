package app.serviceImpl;

import app.dto.MedicineLiverDiseaseHistoryDTO;
import app.dto.MedicineLiverDiseaseHistoryDetailDTO;
import app.entities.MedicineLiverDiseaseHistoryDO;
import app.entities.MedicineLiverDiseaseHistoryDetailDO;
import app.repo.MlDiseaseHistoryDetailRepo;
import app.repo.MlDiseaseHistoryRepo;
import app.service.MlCompleteService;
import app.service.MlDiseaseHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/4 0004.
 */

@Service
public class MlDiseaseHistoryServiceImpl implements MlDiseaseHistoryService ,MlCompleteService{

    @Autowired
    private MlDiseaseHistoryRepo mlDiseaseHistoryRepo;

    @Autowired
    private MlDiseaseHistoryDetailRepo mlDiseaseHistoryDetailRepo;

    private MedicineLiverDiseaseHistoryDO convertToEntity(MedicineLiverDiseaseHistoryDTO medicineLiverDiseaseHistoryDTO) {

        MedicineLiverDiseaseHistoryDO medicineLiverDiseaseHistoryDO = new MedicineLiverDiseaseHistoryDO();
        medicineLiverDiseaseHistoryDO.setPatientId(medicineLiverDiseaseHistoryDTO.getPatientId());
        medicineLiverDiseaseHistoryDO.setComplete(medicineLiverDiseaseHistoryDTO.isComplete());
        medicineLiverDiseaseHistoryDO.setEpidemicTourism(medicineLiverDiseaseHistoryDTO.getEpidemicTourism());
        medicineLiverDiseaseHistoryDO.setEpidemicText(medicineLiverDiseaseHistoryDTO.getEpidemicText());
        medicineLiverDiseaseHistoryDO.setOtherHistory(medicineLiverDiseaseHistoryDTO.getOtherHistory());
        medicineLiverDiseaseHistoryDO.setPastDisease(medicineLiverDiseaseHistoryDTO.getPastDisease());
        medicineLiverDiseaseHistoryDO.setPersonHistory(medicineLiverDiseaseHistoryDTO.getPersonHistory());
        mlDiseaseHistoryDetailRepo.deleteDiseaseHistoryDetailByDId(medicineLiverDiseaseHistoryDTO.getId());
        List<MedicineLiverDiseaseHistoryDetailDO> medicineLiverDiseaseHistoryDetailDOS = new ArrayList<>();
        List<MedicineLiverDiseaseHistoryDetailDTO> medicineLiverDiseaseHistoryDetailDTOS = medicineLiverDiseaseHistoryDTO.getMedicineLiverDiseaseHistoryDetailDTOS();
        if (medicineLiverDiseaseHistoryDetailDTOS != null) {
            for (MedicineLiverDiseaseHistoryDetailDTO medicineLiverDiseaseHistoryDetailDTO : medicineLiverDiseaseHistoryDetailDTOS) {
                MedicineLiverDiseaseHistoryDetailDO medicineLiverDiseaseHistoryDetailDO = new MedicineLiverDiseaseHistoryDetailDO();
                medicineLiverDiseaseHistoryDetailDO.setDiseaseType(medicineLiverDiseaseHistoryDetailDTO.getDiseaseType());
                medicineLiverDiseaseHistoryDetailDO.setPreMedicine(medicineLiverDiseaseHistoryDetailDTO.getPreMedicine());
                medicineLiverDiseaseHistoryDetailDO.setDiseaseName(medicineLiverDiseaseHistoryDetailDTO.getDiseaseName());
                medicineLiverDiseaseHistoryDetailDO.setExistence(medicineLiverDiseaseHistoryDetailDTO.getExistence());
                medicineLiverDiseaseHistoryDetailDO.setMedicineLiverDiseaseHistoryDO(medicineLiverDiseaseHistoryDO);
                medicineLiverDiseaseHistoryDetailDOS.add(medicineLiverDiseaseHistoryDetailDO);
            }
        }
        medicineLiverDiseaseHistoryDO.setMedicineLiverDiseaseHistoryDetailDOS(medicineLiverDiseaseHistoryDetailDOS);
        return medicineLiverDiseaseHistoryDO;
    }

    private MedicineLiverDiseaseHistoryDTO convertToDTO(MedicineLiverDiseaseHistoryDO medicineLiverDiseaseHistoryDO) {

        MedicineLiverDiseaseHistoryDTO medicineLiverDiseaseHistoryDTO = new MedicineLiverDiseaseHistoryDTO();
        medicineLiverDiseaseHistoryDTO.setComplete(medicineLiverDiseaseHistoryDO.isComplete());
        medicineLiverDiseaseHistoryDTO.setOtherHistory(medicineLiverDiseaseHistoryDO.getOtherHistory());
        medicineLiverDiseaseHistoryDTO.setPastDisease(medicineLiverDiseaseHistoryDO.getPastDisease());
        medicineLiverDiseaseHistoryDTO.setEpidemicTourism(medicineLiverDiseaseHistoryDO.getEpidemicTourism());
        medicineLiverDiseaseHistoryDTO.setEpidemicText(medicineLiverDiseaseHistoryDO.getEpidemicText());
        medicineLiverDiseaseHistoryDTO.setPatientId(medicineLiverDiseaseHistoryDO.getPatientId());
        medicineLiverDiseaseHistoryDTO.setId(medicineLiverDiseaseHistoryDO.getId());
        medicineLiverDiseaseHistoryDTO.setPersonHistory(medicineLiverDiseaseHistoryDO.getPersonHistory());
        List<MedicineLiverDiseaseHistoryDetailDTO> medicineLiverDiseaseHistoryDetailDTOS = new ArrayList<>();
        List<MedicineLiverDiseaseHistoryDetailDO> medicineLiverDiseaseHistoryDetailDOS = medicineLiverDiseaseHistoryDO.getMedicineLiverDiseaseHistoryDetailDOS();
        if (!medicineLiverDiseaseHistoryDetailDOS.isEmpty() && medicineLiverDiseaseHistoryDetailDOS != null) {
            for (MedicineLiverDiseaseHistoryDetailDO medicineLiverDiseaseHistoryDetailDO : medicineLiverDiseaseHistoryDetailDOS) {
                MedicineLiverDiseaseHistoryDetailDTO medicineLiverDiseaseHistoryDetailDTO = new MedicineLiverDiseaseHistoryDetailDTO();
                medicineLiverDiseaseHistoryDetailDTO.setPreMedicine(medicineLiverDiseaseHistoryDetailDO.getPreMedicine());
                medicineLiverDiseaseHistoryDetailDTO.setDiseaseType(medicineLiverDiseaseHistoryDetailDO.getDiseaseType());
                medicineLiverDiseaseHistoryDetailDTO.setDiseaseName(medicineLiverDiseaseHistoryDetailDO.getDiseaseName());
                medicineLiverDiseaseHistoryDetailDTO.setExistence(medicineLiverDiseaseHistoryDetailDO.getExistence());
                medicineLiverDiseaseHistoryDetailDTO.setMedicineLiverDiseaseHistoryId(medicineLiverDiseaseHistoryDetailDO.getMedicineLiverDiseaseHistoryDO().getId());
                medicineLiverDiseaseHistoryDetailDTO.setId(medicineLiverDiseaseHistoryDetailDO.getId());
                medicineLiverDiseaseHistoryDetailDTOS.add(medicineLiverDiseaseHistoryDetailDTO);
            }
        }
        medicineLiverDiseaseHistoryDTO.setMedicineLiverDiseaseHistoryDetailDTOS(medicineLiverDiseaseHistoryDetailDTOS);
        return medicineLiverDiseaseHistoryDTO;
    }

    @Override
    public MedicineLiverDiseaseHistoryDTO getMlDiseaseHistory(int mlPatientId) {
        return mlDiseaseHistoryRepo.getMlDiseaseHistoryByPatientId(mlPatientId) != null ? convertToDTO(mlDiseaseHistoryRepo.getMlDiseaseHistoryByPatientId(mlPatientId)) : null;
    }

    @Override
    public void saveMlDiseaseHistory(MedicineLiverDiseaseHistoryDTO diseaseHistoryDTO) {
        mlDiseaseHistoryRepo.save(convertToEntity(diseaseHistoryDTO));
    }

    @Override
    public Boolean getCompleteByPatient(int mlPatientId) {
        return mlDiseaseHistoryRepo.getCompleteByPatientId(mlPatientId);
    }
}
