package app.serviceImpl;

import app.dto.MedicineLiverSuspectedDrugDTO;
import app.dto.MedicineLiverSuspectedDrugDetailDTO;
import app.entities.MedicineLiverSuspectedDrugDO;
import app.entities.MedicineLiverSuspectedDrugDetailDO;
import app.repo.MlDrugHistoryRepo;
import app.service.MlDrugHistoryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/6 0006.
 */
public class MlDrugHistoryServiceImpl implements MlDrugHistoryService{

    @Autowired
    private MlDrugHistoryRepo mlDrugHistoryRepo;

    private MedicineLiverSuspectedDrugDTO convertToDTO(MedicineLiverSuspectedDrugDO medicineLiverSuspectedDrugDO){
        MedicineLiverSuspectedDrugDTO medicineLiverSuspectedDrugDTO = new MedicineLiverSuspectedDrugDTO();
        medicineLiverSuspectedDrugDTO.setPatientId(medicineLiverSuspectedDrugDO.getPatientId());
        medicineLiverSuspectedDrugDTO.setComplete(medicineLiverSuspectedDrugDO.isComplete());
        medicineLiverSuspectedDrugDTO.setId(medicineLiverSuspectedDrugDO.getId());
        List<MedicineLiverSuspectedDrugDetailDTO> medicineLiverSuspectedDrugDetailDTOS = new ArrayList<>();
        List<MedicineLiverSuspectedDrugDetailDO> medicineLiverSuspectedDrugDetailDOS = medicineLiverSuspectedDrugDO.getMedicineLiverSuspectedDrugDetailDOS();
        if(!medicineLiverSuspectedDrugDetailDOS.isEmpty() && medicineLiverSuspectedDrugDetailDOS != null){
            for(MedicineLiverSuspectedDrugDetailDO medicineLiverSuspectedDrugDetailDO : medicineLiverSuspectedDrugDetailDOS){
                MedicineLiverSuspectedDrugDetailDTO medicineLiverSuspectedDrugDetailDTO = new MedicineLiverSuspectedDrugDetailDTO();
                medicineLiverSuspectedDrugDetailDTO.setId(medicineLiverSuspectedDrugDetailDO.getId());
                medicineLiverSuspectedDrugDetailDTO.setBeginDate(medicineLiverSuspectedDrugDetailDO.getBeginDate());
                medicineLiverSuspectedDrugDetailDTO.setDecrement(medicineLiverSuspectedDrugDetailDO.getDecrement());
                medicineLiverSuspectedDrugDetailDTO.setDose(medicineLiverSuspectedDrugDetailDO.getDose());
                medicineLiverSuspectedDrugDetailDTO.setDrugExposure(medicineLiverSuspectedDrugDetailDO.getDrugExposure());
                medicineLiverSuspectedDrugDetailDTO.setDrugWithdrawal(medicineLiverSuspectedDrugDetailDO.getDrugWithdrawal());
                medicineLiverSuspectedDrugDetailDTO.setDrugWithdrawalDate(medicineLiverSuspectedDrugDetailDO.getDrugWithdrawalDate());
                medicineLiverSuspectedDrugDetailDTO.setExposureLiverDamage(medicineLiverSuspectedDrugDetailDO.getExposureLiverDamage());
                medicineLiverSuspectedDrugDetailDTO.setMedicationMethod(medicineLiverSuspectedDrugDetailDO.getMedicationMethod());
                medicineLiverSuspectedDrugDetailDTO.setMedicineLiverSuspectedDrugId(medicineLiverSuspectedDrugDetailDO.getMedicineLiverSuspectedDrugDO().getId());
                medicineLiverSuspectedDrugDetailDTOS.add(medicineLiverSuspectedDrugDetailDTO);
            }
        }
        medicineLiverSuspectedDrugDTO.setMedicineLiverSuspectedDrugDetailDTOS(medicineLiverSuspectedDrugDetailDTOS);
        return medicineLiverSuspectedDrugDTO;
    }

//   private MedicineLiverSuspectedDrugDO convertToEntity(MedicineLiverSuspectedDrugDTO medicineLiverSuspectedDrugDTO){
//
//   }

    @Override
    public void saveDrugHistory(MedicineLiverSuspectedDrugDTO medicineLiverSuspectedDrugDTO) {

    }

    @Override
    public MedicineLiverSuspectedDrugDTO getDrugByPatientId(int mlPatientId) {
        return null;
    }
}
