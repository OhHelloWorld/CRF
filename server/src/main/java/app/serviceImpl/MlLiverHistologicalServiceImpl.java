package app.serviceImpl;

import app.dto.MedicineLiverLiverHistologicalDTO;
import app.entities.MedicineLiverLiverHistologicalDO;
import app.repo.MlLiverHistologicalRepo;
import app.service.MlCompleteService;
import app.service.MlLiverHistologicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
@Service
public class MlLiverHistologicalServiceImpl implements MlLiverHistologicalService,MlCompleteService{

    @Autowired
    private MlLiverHistologicalRepo mlLiverHistologicalRepo;

    private MedicineLiverLiverHistologicalDTO convertToDTO(MedicineLiverLiverHistologicalDO medicineLiverLiverHistologicalDO){
        MedicineLiverLiverHistologicalDTO medicineLiverLiverHistologicalDTO = new MedicineLiverLiverHistologicalDTO();
        medicineLiverLiverHistologicalDTO.setComplete(medicineLiverLiverHistologicalDO.isComplete());
        medicineLiverLiverHistologicalDTO.setId(medicineLiverLiverHistologicalDO.getId());
        medicineLiverLiverHistologicalDTO.setConfluentNecrosis(medicineLiverLiverHistologicalDO.getConfluentNecrosis());
        medicineLiverLiverHistologicalDTO.setFibrosis(medicineLiverLiverHistologicalDO.getFibrosis());
        medicineLiverLiverHistologicalDTO.setFocal(medicineLiverLiverHistologicalDO.getFocal());
        medicineLiverLiverHistologicalDTO.setInterfaceHepatitis(medicineLiverLiverHistologicalDO.getInterfaceHepatitis());
        medicineLiverLiverHistologicalDTO.setPortalInflammation(medicineLiverLiverHistologicalDO.getPortalInflammation());
        medicineLiverLiverHistologicalDTO.setSeverity(medicineLiverLiverHistologicalDO.getSeverity());
        medicineLiverLiverHistologicalDTO.setDone(medicineLiverLiverHistologicalDO.getDone());
        return medicineLiverLiverHistologicalDTO;
    }

    private MedicineLiverLiverHistologicalDO convertToEntity(MedicineLiverLiverHistologicalDTO medicineLiverLiverHistologicalDTO){
        MedicineLiverLiverHistologicalDO medicineLiverLiverHistologicalDO = new MedicineLiverLiverHistologicalDO();
        medicineLiverLiverHistologicalDO.setComplete(medicineLiverLiverHistologicalDTO.isComplete());
        medicineLiverLiverHistologicalDO.setPatientId(medicineLiverLiverHistologicalDTO.getPatientId());
        medicineLiverLiverHistologicalDO.setSeverity(medicineLiverLiverHistologicalDTO.getSeverity());
        medicineLiverLiverHistologicalDO.setInterfaceHepatitis(medicineLiverLiverHistologicalDTO.getInterfaceHepatitis());
        medicineLiverLiverHistologicalDO.setFocal(medicineLiverLiverHistologicalDTO.getFocal());
        medicineLiverLiverHistologicalDO.setConfluentNecrosis(medicineLiverLiverHistologicalDTO.getConfluentNecrosis());
        medicineLiverLiverHistologicalDO.setFibrosis(medicineLiverLiverHistologicalDTO.getFibrosis());
        medicineLiverLiverHistologicalDO.setPortalInflammation(medicineLiverLiverHistologicalDTO.getPortalInflammation());
        medicineLiverLiverHistologicalDO.setDone(medicineLiverLiverHistologicalDTO.getDone());
        return medicineLiverLiverHistologicalDO;
    }

    @Override
    public void saveMlLiverHistological(MedicineLiverLiverHistologicalDTO medicineLiverLiverHistologicalDTO) {
        mlLiverHistologicalRepo.save(convertToEntity(medicineLiverLiverHistologicalDTO));
    }

    @Override
    public MedicineLiverLiverHistologicalDTO getMlLiverHistologicalByPatientId(int mlPatientId) {
        return mlLiverHistologicalRepo.getMlLiverHistologicalByPatientId(mlPatientId)!=null?convertToDTO(mlLiverHistologicalRepo.getMlLiverHistologicalByPatientId(mlPatientId)):null;
    }

    @Override
    public Boolean getCompleteByPatient(int mlPatientId) {
        return mlLiverHistologicalRepo.getCompleteByPatientId(mlPatientId);
    }
}
