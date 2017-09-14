package app.serviceImpl;

import app.dto.MedicineLiverSuspectedDrugDTO;
import app.dto.MedicineLiverSuspectedDrugDetailDTO;
import app.entities.MedicineLiverSuspectedDrugDO;
import app.entities.MedicineLiverSuspectedDrugDetailDO;
import app.repo.MlDrugHistoryRepo;
import app.service.MlDrugHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/6 0006.
 */
@Service
public class MlDrugHistoryServiceImpl implements MlDrugHistoryService {

    @Autowired
    private MlDrugHistoryRepo mlDrugHistoryRepo;

    private MedicineLiverSuspectedDrugDTO convertToDTO(MedicineLiverSuspectedDrugDO medicineLiverSuspectedDrugDO) {
        MedicineLiverSuspectedDrugDTO medicineLiverSuspectedDrugDTO = new MedicineLiverSuspectedDrugDTO();
        medicineLiverSuspectedDrugDTO.setPatientId(medicineLiverSuspectedDrugDO.getPatientId());
        medicineLiverSuspectedDrugDTO.setComplete(medicineLiverSuspectedDrugDO.isComplete());
        medicineLiverSuspectedDrugDTO.setId(medicineLiverSuspectedDrugDO.getId());
        List<MedicineLiverSuspectedDrugDetailDTO> medicineLiverSuspectedDrugDetailDTOS = new ArrayList<>();
        List<MedicineLiverSuspectedDrugDetailDO> medicineLiverSuspectedDrugDetailDOS = medicineLiverSuspectedDrugDO.getMedicineLiverSuspectedDrugDetailDOS();
        if (!medicineLiverSuspectedDrugDetailDOS.isEmpty() && medicineLiverSuspectedDrugDetailDOS != null) {
            for (MedicineLiverSuspectedDrugDetailDO medicineLiverSuspectedDrugDetailDO : medicineLiverSuspectedDrugDetailDOS) {
                MedicineLiverSuspectedDrugDetailDTO medicineLiverSuspectedDrugDetailDTO = new MedicineLiverSuspectedDrugDetailDTO();
                medicineLiverSuspectedDrugDetailDTO.setId(medicineLiverSuspectedDrugDetailDO.getId());
                medicineLiverSuspectedDrugDetailDTO.setBeginDate(medicineLiverSuspectedDrugDetailDO.getBeginDate());
                medicineLiverSuspectedDrugDetailDTO.setDecrement(medicineLiverSuspectedDrugDetailDO.getDecrement());
                medicineLiverSuspectedDrugDetailDTO.setDose(medicineLiverSuspectedDrugDetailDO.getDose());
                medicineLiverSuspectedDrugDetailDTO.setDrugExposure(medicineLiverSuspectedDrugDetailDO.getDrugExposure());
                medicineLiverSuspectedDrugDetailDTO.setDrugWithDrawal(medicineLiverSuspectedDrugDetailDO.getDrugWithDrawal());
                medicineLiverSuspectedDrugDetailDTO.setDrugWithDrawalDate(medicineLiverSuspectedDrugDetailDO.getDrugWithDrawalDate());
                medicineLiverSuspectedDrugDetailDTO.setExposureLiverDamage(medicineLiverSuspectedDrugDetailDO.getExposureLiverDamage());
                medicineLiverSuspectedDrugDetailDTO.setMedicationMethod(medicineLiverSuspectedDrugDetailDO.getMedicationMethod());
                medicineLiverSuspectedDrugDetailDTO.setGenericName(medicineLiverSuspectedDrugDetailDO.getGenericName());
                medicineLiverSuspectedDrugDetailDTO.setTradeName(medicineLiverSuspectedDrugDetailDO.getTradeName());
                medicineLiverSuspectedDrugDetailDTO.setTreatComplaint(medicineLiverSuspectedDrugDetailDO.getTreatComplaint());

                medicineLiverSuspectedDrugDetailDTO.setMedicineLiverSuspectedDrugId(medicineLiverSuspectedDrugDetailDO.getMedicineLiverSuspectedDrugDO().getId());
                medicineLiverSuspectedDrugDetailDTOS.add(medicineLiverSuspectedDrugDetailDTO);
            }
        }
        medicineLiverSuspectedDrugDTO.setMedicineLiverSuspectedDrugDetailDTOS(medicineLiverSuspectedDrugDetailDTOS);
        return medicineLiverSuspectedDrugDTO;
    }

    private MedicineLiverSuspectedDrugDO convertToEntity(MedicineLiverSuspectedDrugDTO medicineLiverSuspectedDrugDTO) {
        MedicineLiverSuspectedDrugDO medicineLiverSuspectedDrugDO = new MedicineLiverSuspectedDrugDO();
        medicineLiverSuspectedDrugDO.setComplete(medicineLiverSuspectedDrugDTO.isComplete());
        medicineLiverSuspectedDrugDO.setPatientId(medicineLiverSuspectedDrugDTO.getPatientId());
        List<MedicineLiverSuspectedDrugDetailDO> medicineLiverSuspectedDrugDetailDOS = new ArrayList<>();
        List<MedicineLiverSuspectedDrugDetailDTO> medicineLiverSuspectedDrugDetailDTOS = medicineLiverSuspectedDrugDTO.getMedicineLiverSuspectedDrugDetailDTOS();
        if(!medicineLiverSuspectedDrugDetailDTOS.isEmpty() && medicineLiverSuspectedDrugDetailDTOS != null){
            for(MedicineLiverSuspectedDrugDetailDTO medicineLiverSuspectedDrugDetailDTO:medicineLiverSuspectedDrugDetailDTOS){
                MedicineLiverSuspectedDrugDetailDO medicineLiverSuspectedDrugDetailDO = new MedicineLiverSuspectedDrugDetailDO();
                medicineLiverSuspectedDrugDetailDO.setMedicationMethod(medicineLiverSuspectedDrugDetailDTO.getMedicationMethod());
                medicineLiverSuspectedDrugDetailDO.setExposureLiverDamage(medicineLiverSuspectedDrugDetailDTO.getExposureLiverDamage());
                medicineLiverSuspectedDrugDetailDO.setBeginDate(medicineLiverSuspectedDrugDetailDTO.getBeginDate());
                medicineLiverSuspectedDrugDetailDO.setDecrement(medicineLiverSuspectedDrugDetailDTO.getDecrement());
                medicineLiverSuspectedDrugDetailDO.setDose(medicineLiverSuspectedDrugDetailDTO.getDose());
                medicineLiverSuspectedDrugDetailDO.setDrugExposure(medicineLiverSuspectedDrugDetailDTO.getDrugExposure());
                medicineLiverSuspectedDrugDetailDO.setDrugWithDrawal(medicineLiverSuspectedDrugDetailDTO.getDrugWithDrawal());
                medicineLiverSuspectedDrugDetailDO.setDrugWithDrawalDate(medicineLiverSuspectedDrugDetailDTO.getDrugWithDrawalDate());
                medicineLiverSuspectedDrugDetailDO.setGenericName(medicineLiverSuspectedDrugDetailDTO.getGenericName());
                medicineLiverSuspectedDrugDetailDO.setTradeName(medicineLiverSuspectedDrugDetailDTO.getTradeName());
                medicineLiverSuspectedDrugDetailDO.setTreatComplaint(medicineLiverSuspectedDrugDetailDTO.getTreatComplaint());
                medicineLiverSuspectedDrugDetailDO.setMedicineLiverSuspectedDrugDO(medicineLiverSuspectedDrugDO);
                medicineLiverSuspectedDrugDetailDOS.add(medicineLiverSuspectedDrugDetailDO);
            }
        }
        medicineLiverSuspectedDrugDO.setMedicineLiverSuspectedDrugDetailDOS(medicineLiverSuspectedDrugDetailDOS);
        return medicineLiverSuspectedDrugDO;
    }

    @Override
    public void saveDrugHistory(MedicineLiverSuspectedDrugDTO medicineLiverSuspectedDrugDTO) {
        mlDrugHistoryRepo.save(convertToEntity(medicineLiverSuspectedDrugDTO));
    }

    @Override
    public MedicineLiverSuspectedDrugDTO getDrugByPatientId(int mlPatientId) {
        return mlDrugHistoryRepo.getMlDrugByPatientId(mlPatientId) !=null?convertToDTO(mlDrugHistoryRepo.getMlDrugByPatientId(mlPatientId)):null;
    }
}
