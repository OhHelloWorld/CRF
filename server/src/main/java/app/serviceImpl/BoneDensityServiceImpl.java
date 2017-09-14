package app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import app.dto.BoneDensityDTO;
import app.entities.BoneDensityDO;
import app.repo.BoneDensityRepo;
import app.service.BoneDensityService;

@Service
public class BoneDensityServiceImpl implements BoneDensityService {

    @Autowired
    private BoneDensityRepo bRepo;

    private BoneDensityDO convertToEntity(BoneDensityDTO boneDensityDTO, BoneDensityDO boneDensityDO) {
        if (boneDensityDO == null) {
            boneDensityDO = new BoneDensityDO();
        }
        if (boneDensityDTO.getBigTrochanter() != 0) {
            boneDensityDO.setBigTrochanter(boneDensityDTO.getBigTrochanter());
        } else {
            boneDensityDO.setBigTrochanter(null);
        }
        boneDensityDO.setBigTrochanterT(boneDensityDTO.getBigTrochanterT());
        boneDensityDO.setComplete(boneDensityDTO.isComplete());
        boneDensityDO.setDiagnosis(boneDensityDTO.getDiagnosis());
        if (boneDensityDTO.getFemoralNeck() != 0) {
            boneDensityDO.setFemoralNeck(boneDensityDTO.getFemoralNeck());
        } else {
            boneDensityDO.setFemoralNeck(null);
        }
        boneDensityDO.setFemoralNeckT(boneDensityDTO.getFemoralNeckT());
        boneDensityDO.setFollowUp(boneDensityDTO.isFollowUp());
        boneDensityDO.setFollowUpDate(boneDensityDTO.getFollowUpDate());
        if (boneDensityDTO.getFullHip() != 0) {
            boneDensityDO.setFullHip(boneDensityDTO.getFullHip());
        } else {
            boneDensityDO.setFullHip(null);
        }
        boneDensityDO.setFullHipT(boneDensityDTO.getFullHipT());
        if (boneDensityDTO.getLumbarSpine() != 0) {
            boneDensityDO.setLumbarSpine(boneDensityDTO.getLumbarSpine());
        } else {
            boneDensityDO.setLumbarSpine(null);
        }
        boneDensityDO.setLumbarSpineT(boneDensityDTO.getLumbarSpineT());
        boneDensityDO.setMeasuringTime(boneDensityDTO.getMeasuringTime());
        boneDensityDO.setPatientId(boneDensityDTO.getPatientId());
        boneDensityDO.setRemarks(boneDensityDTO.getRemarks());
        return boneDensityDO;
    }

    private BoneDensityDTO convertToDTO(BoneDensityDO boneDensityDO) {
        BoneDensityDTO boneDensityDTO = new BoneDensityDTO();
        boneDensityDTO.setId(boneDensityDO.getId());
        boneDensityDTO.setBigTrochanter(boneDensityDO.getBigTrochanter());
        boneDensityDTO.setBigTrochanterT(boneDensityDO.getBigTrochanterT());
        boneDensityDTO.setComplete(boneDensityDO.isComplete());
        boneDensityDTO.setDiagnosis(boneDensityDO.getDiagnosis());
        boneDensityDTO.setFemoralNeck(boneDensityDO.getFemoralNeck());
        boneDensityDTO.setFemoralNeckT(boneDensityDO.getFemoralNeckT());
        boneDensityDTO.setFollowUp(boneDensityDO.isFollowUp());
        boneDensityDTO.setFollowUpDate(boneDensityDO.getFollowUpDate());
        boneDensityDTO.setFullHip(boneDensityDO.getFullHip());
        boneDensityDTO.setFullHipT(boneDensityDO.getFullHipT());
        boneDensityDTO.setLumbarSpine(boneDensityDO.getLumbarSpine());
        boneDensityDTO.setLumbarSpineT(boneDensityDO.getLumbarSpineT());
        boneDensityDTO.setMeasuringTime(boneDensityDO.getMeasuringTime());
        boneDensityDTO.setPatientId(boneDensityDO.getPatientId());
        boneDensityDTO.setRemarks(boneDensityDO.getRemarks());
        return boneDensityDTO;
    }

    @Override
    public void saveBoneDensity(BoneDensityDTO boneDensityDTO) {
        bRepo.save(convertToEntity(boneDensityDTO, null));
    }

    @Override
    public BoneDensityDTO getBoneDensity(int patientId) {
        if (bRepo.getBoneDensity(patientId) == null) {
            return null;
        } else {
            return convertToDTO(bRepo.getBoneDensity(patientId));
        }
    }

    @Override
    public boolean getCompleteByPatientId(int patientId) {
//        try {
//            return bRepo.getCompleteByPatientId(patientId);
//        } catch (Exception e) {
//            return false;
//        }
        return bRepo.getCompleteByPatientId(patientId) != null ? bRepo.getCompleteByPatientId(patientId) : false;
    }

    @Override
    public List<BoneDensityDTO> getFollowBone(int patientId) {
        if (!bRepo.getFollowBone(patientId).isEmpty()) {
            List<BoneDensityDO> boneDensityDOs = bRepo.getFollowBone(patientId);
            List<BoneDensityDTO> boneDensityDTOs = new ArrayList<>();
            for (BoneDensityDO boneDensityDO : boneDensityDOs) {
                boneDensityDTOs.add(convertToDTO(boneDensityDO));
            }
            return boneDensityDTOs;
        } else {
            return null;
        }
    }

    @Override
    public BoneDensityDTO getDefaultBone(int patientId) {
        if (bRepo.getDefaultBone(patientId) != null) {
            return convertToDTO(bRepo.getDefaultBone(patientId));
        } else {
            return null;
        }
    }

    @Override
    public BoneDensityDTO getSingleFollowById(int id) {
        return convertToDTO(bRepo.findOne(id));
    }

    @Override
    public void updateBone(BoneDensityDTO boneDensityDTO) {
        bRepo.save(convertToEntity(boneDensityDTO, bRepo.findOne(boneDensityDTO.getId())));
    }

}
