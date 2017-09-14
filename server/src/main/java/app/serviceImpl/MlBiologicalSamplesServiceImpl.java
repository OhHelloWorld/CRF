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
        medicineLiverBiologicalSamplesDTO.setComplete(medicineLiverBiologicalSamplesDO.isComplete());
        return medicineLiverBiologicalSamplesDTO;
    }

    private MedicineLiverBiologicalSamplesDO convertToEntity(MedicineLiverBiologicalSamplesDTO medicineLiverBiologicalSamplesDTO){
        MedicineLiverBiologicalSamplesDO medicineLiverBiologicalSamplesDO = new MedicineLiverBiologicalSamplesDO();
        medicineLiverBiologicalSamplesDO.setComplete(medicineLiverBiologicalSamplesDTO.isComplete());
        medicineLiverBiologicalSamplesDO.setBiologicalSamples(medicineLiverBiologicalSamplesDTO.getBiologicalSamples());
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
