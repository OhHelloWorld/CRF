package app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.SimpleAIHDTO;
import app.entities.SimpleAIHDO;
import app.repo.SimpleAIHRepo;
import app.service.SimpleAIHService;

@Service
public class SimpleAIHServiceImpl implements SimpleAIHService {

    @Autowired
    private SimpleAIHRepo simpleAIHRepo;

    private SimpleAIHDO convertToEntity(SimpleAIHDTO simpleAIHDTO) {

        SimpleAIHDO simpleAIHDO = new SimpleAIHDO();
        simpleAIHDO.setAnasma1(simpleAIHDTO.getAnasma1());
        simpleAIHDO.setAnasma2(simpleAIHDTO.getAnasma2());
        simpleAIHDO.setAntiLkm(simpleAIHDTO.getAntiLkm());
        simpleAIHDO.setAntiSla(simpleAIHDTO.getAntiSla());
        simpleAIHDO.setEliminateViralHepatitis(simpleAIHDTO.getEliminateViralHepatitis());
        simpleAIHDO.setIgG(simpleAIHDTO.getIgG());
        simpleAIHDO.setLiver(simpleAIHDTO.getLiver());
        simpleAIHDO.setPatientId(simpleAIHDTO.getPatientId());
        simpleAIHDO.setComplete(simpleAIHDTO.isComplete());
        simpleAIHDO.setResult(simpleAIHDTO.getResult());
        return simpleAIHDO;
    }

    private SimpleAIHDTO convertToDTO(SimpleAIHDO simpleAIHDO) {
        SimpleAIHDTO simpleAIHDTO = new SimpleAIHDTO();
        simpleAIHDTO.setId(simpleAIHDO.getId());
        simpleAIHDTO.setAnasma1(simpleAIHDO.getAnasma1());
        simpleAIHDTO.setAnasma2(simpleAIHDO.getAnasma2());
        simpleAIHDTO.setAntiLkm(simpleAIHDO.getAntiLkm());
        simpleAIHDTO.setAntiSla(simpleAIHDO.getAntiSla());
        simpleAIHDTO.setEliminateViralHepatitis(simpleAIHDO.getEliminateViralHepatitis());
        simpleAIHDTO.setIgG(simpleAIHDO.getIgG());
        simpleAIHDTO.setLiver(simpleAIHDO.getLiver());
        simpleAIHDTO.setPatientId(simpleAIHDO.getPatientId());
        simpleAIHDTO.setResult(simpleAIHDO.getResult());
        simpleAIHDTO.setComplete(simpleAIHDO.isComplete());
        return simpleAIHDTO;
    }


    @Override
    public void saveSimpleAIH(SimpleAIHDTO simpleAIHDTO) {

        simpleAIHRepo.save(convertToEntity(simpleAIHDTO));
    }

    @Override
    public SimpleAIHDTO getSimpleAIH(int patientId) {
        if (simpleAIHRepo.getSimpleAIH(patientId) == null) {
            return null;
        } else {
            return convertToDTO(simpleAIHRepo.getSimpleAIH(patientId));
        }
    }

    @Override
    public boolean getCompleteByPatientId(int patientId) {
        try {
            return simpleAIHRepo.getCompleteByPatientId(patientId);
        } catch (Exception e) {
            return false;
        }
    }

}
