package app.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.LiverPathologyDTO;
import app.entities.LiverPathologyDO;
import app.repo.HaiRepo;
import app.repo.IshakRepo;
import app.repo.LiverPathologyRepo;
import app.service.LiverPathologyService;

@Service
public class LiverPathologyServiceImpl implements LiverPathologyService {

    @Autowired
    private LiverPathologyRepo liverPathologyRepo;

    @Autowired
    private IshakRepo ishakRepo;

    @Autowired
    private HaiRepo haiRepo;

    private LiverPathologyDO convertToEntity(LiverPathologyDTO liverPathologyDTO) {
        LiverPathologyDO liverPathologyDO = new LiverPathologyDO();
        liverPathologyDO.setAddDate(liverPathologyDTO.getAddDate());
        liverPathologyDO.setComplete(liverPathologyDTO.isComplete());
        liverPathologyDO.setDiagnosis(liverPathologyDTO.getDiagnosis());
        liverPathologyDO
                .setFibrousTissueHyperplasia(liverPathologyDTO.getFibrousTissueHyperplasia());
        liverPathologyDO.setHbcAg(liverPathologyDTO.getHbcAg());
        liverPathologyDO.setHbsAg(liverPathologyDTO.getHbsAg());
        liverPathologyDO.setHcv(liverPathologyDTO.getHcv());
        liverPathologyDO.setHepatocellularSteatosis(liverPathologyDTO.getHepatocellularSteatosis());
        liverPathologyDO.setInflammationBileDuct(liverPathologyDTO.getInflammationBileDuct());
        liverPathologyDO.setInflammationLeaflets(liverPathologyDTO.getInflammationLeaflets());
        liverPathologyDO.setInterfacialInflammation(liverPathologyDTO.getInterfacialInflammation());
        liverPathologyDO.setLymphocytePlasmaCellInfiltration(
                liverPathologyDTO.getLymphocytePlasmaCellInfiltration());
        liverPathologyDO.setOther(liverPathologyDTO.getOther());
        liverPathologyDO
                .setPathologyNumber(new SimpleDateFormat("yyyyMMddhhmmssSSS").format(new Date()));
        liverPathologyDO.setPatientId(liverPathologyDTO.getPatientId());
        liverPathologyDO.setPortalAreaInflammation(liverPathologyDTO.getPortalAreaInflammation());
        liverPathologyDO.setRemarks(liverPathologyDTO.getRemarks());
        liverPathologyDO.setRoseSample(liverPathologyDTO.getRoseSample());
        liverPathologyDO.setChoose(liverPathologyDTO.isChoose());
        return liverPathologyDO;
    }

    private LiverPathologyDTO convertToDTO(LiverPathologyDO liverPathologyDO) {
        LiverPathologyDTO liverPathologyDTO = new LiverPathologyDTO();
        liverPathologyDTO.setId(liverPathologyDO.getId());
        liverPathologyDTO.setAddDate(liverPathologyDO.getAddDate());
        liverPathologyDTO.setComplete(liverPathologyDO.isComplete());
        liverPathologyDTO.setDiagnosis(liverPathologyDO.getDiagnosis());
        liverPathologyDTO
                .setFibrousTissueHyperplasia(liverPathologyDO.getFibrousTissueHyperplasia());
        liverPathologyDTO.setHbcAg(liverPathologyDO.getHbcAg());
        liverPathologyDTO.setHbsAg(liverPathologyDO.getHbsAg());
        liverPathologyDTO.setHcv(liverPathologyDO.getHcv());
        liverPathologyDTO.setHepatocellularSteatosis(liverPathologyDO.getHepatocellularSteatosis());
        liverPathologyDTO.setInflammationBileDuct(liverPathologyDO.getInflammationBileDuct());
        liverPathologyDTO.setInflammationLeaflets(liverPathologyDO.getInflammationLeaflets());
        liverPathologyDTO.setInterfacialInflammation(liverPathologyDO.getInterfacialInflammation());
        liverPathologyDTO.setLymphocytePlasmaCellInfiltration(
                liverPathologyDO.getLymphocytePlasmaCellInfiltration());
        liverPathologyDTO.setOther(liverPathologyDO.getOther());
        liverPathologyDTO.setPathologyNumber(liverPathologyDO.getPathologyNumber());
        liverPathologyDTO.setPatientId(liverPathologyDO.getPatientId());
        liverPathologyDTO.setPortalAreaInflammation(liverPathologyDO.getPortalAreaInflammation());
        liverPathologyDTO.setRemarks(liverPathologyDO.getRemarks());
        liverPathologyDTO.setRoseSample(liverPathologyDO.getRoseSample());
        liverPathologyDTO.setChoose(liverPathologyDO.isChoose());
        return liverPathologyDTO;
    }

    @Override
    public int saveLiverPathology(LiverPathologyDTO liverPathologyDTO) {
        return liverPathologyRepo.save(convertToEntity(liverPathologyDTO)).getPatientId();
    }

    @Override
    public LiverPathologyDTO getLiverPathology(int patientId) {
        if (liverPathologyRepo.getLiverPathology(patientId) == null) {
            return null;
        } else {
            return convertToDTO(liverPathologyRepo.getLiverPathology(patientId));
        }
    }

    @Override
    public boolean getCompleteByPatientId(int patientId) {
        if (liverPathologyRepo.getCompleteByPatientId(patientId) == null
                && ishakRepo.getCompleteByPatientId(patientId) == null
                && haiRepo.getCompleteByPatientId(patientId) == null) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public List<Boolean> getChoose(int patientId) {
        List<Boolean> chooseList = new ArrayList<>();
        chooseList.add(liverPathologyRepo.getChooseByPatientId(patientId));
        chooseList.add(ishakRepo.getChooseByPatientId(patientId));
        chooseList.add(haiRepo.getChooseByPatientId(patientId));
        return chooseList;
    }


}
