package app.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.IshakDTO;
import app.entities.IshakDO;
import app.repo.IshakRepo;
import app.service.IshakService;

@Service
public class IshakServiceImpl implements IshakService {

    @Autowired
    private IshakRepo ishakRepo;

    private IshakDTO convertToDTO(IshakDO ishakDO) {
        IshakDTO ishakDTO = new IshakDTO();
        ishakDTO.setChoose(ishakDO.isChoose());
        ishakDTO.setAddDate(ishakDO.getAddDate());
        ishakDTO.setPatientId(ishakDO.getPatientId());
        ishakDTO.setConfluentNecrosis(ishakDO.getConfluentNecrosis());
        ishakDTO.setFibrosis(ishakDO.getFibrosis());
        ishakDTO.setId(ishakDO.getId());
        ishakDTO.setInterfaceInflammation(ishakDO.getInterfaceInflammation());
        ishakDTO.setLobularMobility(ishakDO.getLobularMobility());
        ishakDTO.setPortalAreaInflammation(ishakDO.getPortalAreaInflammation());
        return ishakDTO;
    }

    private IshakDO convertToEntity(IshakDTO ishakDTO) {

        IshakDO ishakDO = new IshakDO();
        ishakDO.setChoose(ishakDTO.isChoose());
        ishakDO.setAddDate(ishakDTO.getAddDate());
        ishakDO.setPatientId(ishakDTO.getPatientId());
        ishakDO.setConfluentNecrosis(ishakDTO.getConfluentNecrosis());
        ishakDO.setFibrosis(ishakDTO.getFibrosis());
        ishakDO.setInterfaceInflammation(ishakDTO.getInterfaceInflammation());
        ishakDO.setLobularMobility(ishakDTO.getLobularMobility());
        ishakDO.setPortalAreaInflammation(ishakDTO.getPortalAreaInflammation());
        return ishakDO;
    }

    @Override
    public void saveIshak(IshakDTO ishakDTO) {

        ishakRepo.save(convertToEntity(ishakDTO));
    }

    @Override
    public IshakDTO getIshakByPatientId(int patientId) {
        if (ishakRepo.getIshakByPatientId(patientId) != null) {
            return convertToDTO(ishakRepo.getIshakByPatientId(patientId));
        } else {
            return null;
        }
    }


}
