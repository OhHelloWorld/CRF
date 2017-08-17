package app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import app.dto.HaiDTO;
import app.entities.HaiDO;
import app.repo.HaiRepo;
import app.service.HaiService;

@Service
public class HaiServiceImpl implements HaiService {

    @Autowired
    private HaiRepo haiRepo;

    private HaiDTO convertToDTO(HaiDO haiDO) {

        HaiDTO haiDTO = new HaiDTO();
        haiDTO.setChoose(haiDO.isChoose());
        haiDTO.setId(haiDO.getId());
        haiDTO.setAddDate(haiDO.getAddDate());
        haiDTO.setPatientId(haiDO.getPatientId());
        haiDTO.setInterfaceInflammation(haiDO.getInterfaceInflammation());
        haiDTO.setLobularMobility(haiDO.getLobularMobility());
        haiDTO.setPortalAreaInflammation(haiDO.getPortalAreaInflammation());
        haiDO.setComplete(haiDTO.isComplete());
        return haiDTO;
    }

    private HaiDO convertToEntity(HaiDTO haiDTO) {

        HaiDO haiDO = new HaiDO();
        haiDO.setChoose(haiDTO.isChoose());
        haiDO.setAddDate(haiDTO.getAddDate());
        haiDO.setPatientId(haiDTO.getPatientId());
        haiDO.setInterfaceInflammation(haiDTO.getInterfaceInflammation());
        haiDO.setLobularMobility(haiDTO.getLobularMobility());
        haiDO.setLobularMobility(haiDTO.getPortalAreaInflammation());
        haiDO.setPortalAreaInflammation(haiDTO.getPortalAreaInflammation());
        haiDO.setComplete(haiDTO.isChoose());
        return haiDO;
    }

    @Override
    public void saveHai(HaiDTO haiDTO) {
        haiRepo.save(convertToEntity(haiDTO));
    }

    @Override
    public HaiDTO getHaiByPatientId(int patientId) {
        if (haiRepo.getHaiByPatientId(patientId) != null) {
            return convertToDTO(haiRepo.getHaiByPatientId(patientId));
        } else {
            return null;
        }
    }


}
