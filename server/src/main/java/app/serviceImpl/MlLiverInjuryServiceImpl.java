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
        medicineLiverLiverInjuryDTO.setR(medicineLiverLiverInjuryDO.getR());
        medicineLiverLiverInjuryDTO.setAge(medicineLiverLiverInjuryDO.getAge());
        medicineLiverLiverInjuryDTO.setAlp(medicineLiverLiverInjuryDO.getAlp());
        medicineLiverLiverInjuryDTO.setAlt(medicineLiverLiverInjuryDO.getAlt());
        medicineLiverLiverInjuryDTO.setContinueMedicine(medicineLiverLiverInjuryDO.getContinueMedicine());
        medicineLiverLiverInjuryDTO.setDrinkPregnancy(medicineLiverLiverInjuryDO.getDrinkPregnancy());
        medicineLiverLiverInjuryDTO.setLiverInjuryType(medicineLiverLiverInjuryDO.getLiverInjuryType());
        medicineLiverLiverInjuryDTO.setMedicine(medicineLiverLiverInjuryDO.getMedicine());
        medicineLiverLiverInjuryDTO.setMedicineStart(medicineLiverLiverInjuryDO.getMedicineStart());
        medicineLiverLiverInjuryDTO.setOtherLiverInjuryReason(medicineLiverLiverInjuryDO.getOtherLiverInjuryReason());
        medicineLiverLiverInjuryDTO.setPastLiverInjuryInformation(medicineLiverLiverInjuryDO.getPastLiverInjuryInformation());
        medicineLiverLiverInjuryDTO.setR(medicineLiverLiverInjuryDO.getR());
        medicineLiverLiverInjuryDTO.setReMedicineResponse(medicineLiverLiverInjuryDO.getReMedicineResponse());
        medicineLiverLiverInjuryDTO.setStopMedicine(medicineLiverLiverInjuryDO.getStopMedicine());
        medicineLiverLiverInjuryDTO.setWithdrawalStart(medicineLiverLiverInjuryDO.getWithdrawalStart());
        medicineLiverLiverInjuryDTO.setWithMedicine(medicineLiverLiverInjuryDO.getWithMedicine());
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
        medicineLiverLiverInjuryDO.setR(medicineLiverLiverInjuryDTO.getR());
        medicineLiverLiverInjuryDO.setAge(medicineLiverLiverInjuryDTO.getAge());
        medicineLiverLiverInjuryDO.setAlp(medicineLiverLiverInjuryDTO.getAlp());
        medicineLiverLiverInjuryDO.setAlt(medicineLiverLiverInjuryDTO.getAlt());
        medicineLiverLiverInjuryDO.setContinueMedicine(medicineLiverLiverInjuryDTO.getContinueMedicine());
        medicineLiverLiverInjuryDO.setDrinkPregnancy(medicineLiverLiverInjuryDTO.getDrinkPregnancy());
        medicineLiverLiverInjuryDO.setLiverInjuryType(medicineLiverLiverInjuryDTO.getLiverInjuryType());
        medicineLiverLiverInjuryDO.setMedicine(medicineLiverLiverInjuryDTO.getMedicine());
        medicineLiverLiverInjuryDO.setMedicineStart(medicineLiverLiverInjuryDTO.getMedicineStart());
        medicineLiverLiverInjuryDO.setOtherLiverInjuryReason(medicineLiverLiverInjuryDTO.getOtherLiverInjuryReason());
        medicineLiverLiverInjuryDO.setPastLiverInjuryInformation(medicineLiverLiverInjuryDTO.getPastLiverInjuryInformation());
        medicineLiverLiverInjuryDO.setR(medicineLiverLiverInjuryDTO.getR());
        medicineLiverLiverInjuryDO.setReMedicineResponse(medicineLiverLiverInjuryDTO.getReMedicineResponse());
        medicineLiverLiverInjuryDO.setStopMedicine(medicineLiverLiverInjuryDTO.getStopMedicine());
        medicineLiverLiverInjuryDO.setWithdrawalStart(medicineLiverLiverInjuryDTO.getWithdrawalStart());
        medicineLiverLiverInjuryDO.setWithMedicine(medicineLiverLiverInjuryDTO.getWithMedicine());
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
