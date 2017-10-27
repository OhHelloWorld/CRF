package app.serviceImpl;

import app.dto.MedicineLiverBiologicalSamplesDTO;
import app.entities.MedicineLiverBiologicalSamplesDO;
import app.repo.MlBiologicalSamplesRepo;
import app.service.MlBiologicalSamplesService;
import app.service.MlCompleteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/9/8 0008.
 */
@Service
public class MlBiologicalSamplesServiceImpl implements MlBiologicalSamplesService,MlCompleteService{

    @Autowired
    private MlBiologicalSamplesRepo mlBiologicalSamplesRepo;

    private MedicineLiverBiologicalSamplesDTO convertToDTO(MedicineLiverBiologicalSamplesDO medicineLiverBiologicalSamplesDO){

        MedicineLiverBiologicalSamplesDTO medicineLiverBiologicalSamplesDTO = new MedicineLiverBiologicalSamplesDTO();
        medicineLiverBiologicalSamplesDTO.setId(medicineLiverBiologicalSamplesDO.getId());
        medicineLiverBiologicalSamplesDTO.setBiologicalSamples(medicineLiverBiologicalSamplesDO.getBiologicalSamples());
        medicineLiverBiologicalSamplesDTO.setNum1(medicineLiverBiologicalSamplesDO.getNum1());
        medicineLiverBiologicalSamplesDTO.setNum2(medicineLiverBiologicalSamplesDO.getNum2());
        medicineLiverBiologicalSamplesDTO.setNum3(medicineLiverBiologicalSamplesDO.getNum3());
        medicineLiverBiologicalSamplesDTO.setNum4(medicineLiverBiologicalSamplesDO.getNum4());
        medicineLiverBiologicalSamplesDTO.setNum5(medicineLiverBiologicalSamplesDO.getNum5());
        medicineLiverBiologicalSamplesDTO.setNum6(medicineLiverBiologicalSamplesDO.getNum6());
        medicineLiverBiologicalSamplesDTO.setComplete(medicineLiverBiologicalSamplesDO.isComplete());
        medicineLiverBiologicalSamplesDTO.setRemark1(medicineLiverBiologicalSamplesDO.getRemark1());
        medicineLiverBiologicalSamplesDTO.setRemark2(medicineLiverBiologicalSamplesDO.getRemark2());
        medicineLiverBiologicalSamplesDTO.setRemark3(medicineLiverBiologicalSamplesDO.getRemark3());
        medicineLiverBiologicalSamplesDTO.setRemark4(medicineLiverBiologicalSamplesDO.getRemark4());
        medicineLiverBiologicalSamplesDTO.setRemark5(medicineLiverBiologicalSamplesDO.getRemark5());
        medicineLiverBiologicalSamplesDTO.setRemark6(medicineLiverBiologicalSamplesDO.getRemark6());
        return medicineLiverBiologicalSamplesDTO;
    }

    private MedicineLiverBiologicalSamplesDO convertToEntity(MedicineLiverBiologicalSamplesDTO medicineLiverBiologicalSamplesDTO){
        MedicineLiverBiologicalSamplesDO medicineLiverBiologicalSamplesDO = new MedicineLiverBiologicalSamplesDO();
        medicineLiverBiologicalSamplesDO.setComplete(medicineLiverBiologicalSamplesDTO.isComplete());
        medicineLiverBiologicalSamplesDO.setBiologicalSamples(medicineLiverBiologicalSamplesDTO.getBiologicalSamples());
        medicineLiverBiologicalSamplesDO.setNum1(medicineLiverBiologicalSamplesDTO.getNum1());
        medicineLiverBiologicalSamplesDO.setNum2(medicineLiverBiologicalSamplesDTO.getNum2());
        medicineLiverBiologicalSamplesDO.setNum3(medicineLiverBiologicalSamplesDTO.getNum3());
        medicineLiverBiologicalSamplesDO.setNum4(medicineLiverBiologicalSamplesDTO.getNum4());
        medicineLiverBiologicalSamplesDO.setNum5(medicineLiverBiologicalSamplesDTO.getNum5());
        medicineLiverBiologicalSamplesDO.setNum6(medicineLiverBiologicalSamplesDTO.getNum6());
        medicineLiverBiologicalSamplesDO.setRemark1(medicineLiverBiologicalSamplesDTO.getRemark1());
        medicineLiverBiologicalSamplesDO.setRemark2(medicineLiverBiologicalSamplesDTO.getRemark2());
        medicineLiverBiologicalSamplesDO.setRemark3(medicineLiverBiologicalSamplesDTO.getRemark3());
        medicineLiverBiologicalSamplesDO.setRemark4(medicineLiverBiologicalSamplesDTO.getRemark4());
        medicineLiverBiologicalSamplesDO.setRemark5(medicineLiverBiologicalSamplesDTO.getRemark5());
        medicineLiverBiologicalSamplesDO.setRemark6(medicineLiverBiologicalSamplesDTO.getRemark6());
        medicineLiverBiologicalSamplesDO.setPatientId(medicineLiverBiologicalSamplesDTO.getPatientId());
        return medicineLiverBiologicalSamplesDO;
    }

    @Override
    public void saveBiologicalSamples(MedicineLiverBiologicalSamplesDTO medicineLiverBiologicalSamplesDTO) {
        mlBiologicalSamplesRepo.save(convertToEntity(medicineLiverBiologicalSamplesDTO));
    }

    @Override
    public MedicineLiverBiologicalSamplesDTO getSamplesByPatientId(int mlPatient) {
        return mlBiologicalSamplesRepo.getMlBiologicalByPatientId(mlPatient)!=null?convertToDTO(mlBiologicalSamplesRepo.getMlBiologicalByPatientId(mlPatient)):null;
    }

    @Override
    public Boolean getCompleteByPatient(int mlPatientId) {
        return mlBiologicalSamplesRepo.getCompleteByPatientId(mlPatientId);
    }
}
