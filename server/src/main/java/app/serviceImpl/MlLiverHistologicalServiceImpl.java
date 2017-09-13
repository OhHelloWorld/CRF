package app.serviceImpl;

import app.dto.MedicineLiverLiverHistologicalDTO;
import app.entities.MedicineLiverLiverHistologicalDO;
import app.repo.MlLiverHistologicalRepo;
import app.service.MlLiverHistologicalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
@Service
public class MlLiverHistologicalServiceImpl implements MlLiverHistologicalService{

    @Autowired
    private MlLiverHistologicalRepo mlLiverHistologicalRepo;

    private MedicineLiverLiverHistologicalDTO convertToDTO(MedicineLiverLiverHistologicalDO medicineLiverLiverHistologicalDO){
        MedicineLiverLiverHistologicalDTO medicineLiverLiverHistologicalDTO = new MedicineLiverLiverHistologicalDTO();
        medicineLiverLiverHistologicalDTO.setComplete(medicineLiverLiverHistologicalDO.isComplete());
        medicineLiverLiverHistologicalDTO.setId(medicineLiverLiverHistologicalDO.getId());
        medicineLiverLiverHistologicalDTO.setLiverHistologicalDate(medicineLiverLiverHistologicalDO.getLiverHistologicalDate());
        medicineLiverLiverHistologicalDTO.setLiverHistologicalResult(medicineLiverLiverHistologicalDO.getLiverHistologicalResult());
        return medicineLiverLiverHistologicalDTO;
    }

    private MedicineLiverLiverHistologicalDO convertToEntity(MedicineLiverLiverHistologicalDTO medicineLiverLiverHistologicalDTO){
        MedicineLiverLiverHistologicalDO medicineLiverLiverHistologicalDO = new MedicineLiverLiverHistologicalDO();
        medicineLiverLiverHistologicalDO.setLiverHistologicalResult(medicineLiverLiverHistologicalDTO.getLiverHistologicalResult());
        medicineLiverLiverHistologicalDO.setLiverHistologicalDate(medicineLiverLiverHistologicalDTO.getLiverHistologicalDate());
        medicineLiverLiverHistologicalDO.setComplete(medicineLiverLiverHistologicalDTO.isComplete());
        medicineLiverLiverHistologicalDO.setPatientId(medicineLiverLiverHistologicalDTO.getPatientId());
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
}
