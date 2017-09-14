package app.serviceImpl;

import app.dto.MedicineLiverLiverInjuryDTO;
import app.entities.MedicineLiverLiverInjuryDO;
import app.repo.MlLiverInjuryRepo;
import app.service.MlCompleteService;
import app.service.MlLiverInjuryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/11 0011.
 */
@Service
public class MlLiverInjuryServiceImpl implements MlLiverInjuryService,MlCompleteService{

    @Autowired
    private MlLiverInjuryRepo mlLiverInjuryRepo;

    private MedicineLiverLiverInjuryDTO convertToDTO(MedicineLiverLiverInjuryDO medicineLiverLiverInjuryDO){
        MedicineLiverLiverInjuryDTO medicineLiverLiverInjuryDTO = new MedicineLiverLiverInjuryDTO();
        medicineLiverLiverInjuryDTO.setComplete(medicineLiverLiverInjuryDO.isComplete());
        medicineLiverLiverInjuryDTO.setAscites(medicineLiverLiverInjuryDO.getAscites());
        medicineLiverLiverInjuryDTO.setExtendHospitalStay(medicineLiverLiverInjuryDO.getExtendHospitalStay());
        medicineLiverLiverInjuryDTO.setExtendInr(medicineLiverLiverInjuryDO.getExtendInr());
        medicineLiverLiverInjuryDTO.setFailure(medicineLiverLiverInjuryDO.getFailure());
        medicineLiverLiverInjuryDTO.setHepaticEncephalopathy(medicineLiverLiverInjuryDO.getHepaticEncephalopathy());
        medicineLiverLiverInjuryDTO.setId(medicineLiverLiverInjuryDO.getId());
        medicineLiverLiverInjuryDTO.setRucam(medicineLiverLiverInjuryDO.getRucam());
        return medicineLiverLiverInjuryDTO;
    }

    private MedicineLiverLiverInjuryDO convertToEntity(MedicineLiverLiverInjuryDTO medicineLiverLiverInjuryDTO){
        MedicineLiverLiverInjuryDO medicineLiverLiverInjuryDO = new MedicineLiverLiverInjuryDO();
        medicineLiverLiverInjuryDO.setRucam(medicineLiverLiverInjuryDTO.getRucam());
        medicineLiverLiverInjuryDO.setHepaticEncephalopathy(medicineLiverLiverInjuryDTO.getHepaticEncephalopathy());
        medicineLiverLiverInjuryDO.setFailure(medicineLiverLiverInjuryDTO.getFailure());
        medicineLiverLiverInjuryDO.setAscites(medicineLiverLiverInjuryDTO.getAscites());
        medicineLiverLiverInjuryDO.setComplete(medicineLiverLiverInjuryDTO.isComplete());
        medicineLiverLiverInjuryDO.setExtendHospitalStay(medicineLiverLiverInjuryDTO.getExtendHospitalStay());
        medicineLiverLiverInjuryDO.setExtendInr(medicineLiverLiverInjuryDTO.getExtendInr());
        medicineLiverLiverInjuryDO.setPatientId(medicineLiverLiverInjuryDTO.getPatientId());
        return medicineLiverLiverInjuryDO;
    }

    @Override
    public void saveMlLiverInjury(MedicineLiverLiverInjuryDTO medicineLiverLiverInjuryDTO) {
        mlLiverInjuryRepo.save(convertToEntity(medicineLiverLiverInjuryDTO));
    }

    @Override
    public MedicineLiverLiverInjuryDTO getMlLiverInjuryByPatientId(int mlPatientId) {
        return mlLiverInjuryRepo.getMlLiverInjuryByPatientId(mlPatientId)!=null?convertToDTO(mlLiverInjuryRepo.getMlLiverInjuryByPatientId(mlPatientId)):null;
    }

    @Override
    public Boolean getCompleteByPatient(int mlPatientId) {
        return mlLiverInjuryRepo.getCompleteByPatientId(mlPatientId);
    }
}
