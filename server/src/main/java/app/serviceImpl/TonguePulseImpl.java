package app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dto.TonguePulseDTO;
import app.entities.TonguePulseDO;
import app.repo.TonguePulseRepo;
import app.service.TonguePulseService;

@Service
public class TonguePulseImpl implements TonguePulseService {

    @Autowired
    private TonguePulseRepo tonguePulseRepo;

    @Transactional
    public void saveTonguePulse(TonguePulseDTO tonguePulseDTO) {
        tonguePulseRepo.save(convertToTonguePulseDO(tonguePulseDTO));
    }

    public TonguePulseDTO getTonguePulseByPatientId(int patientId) {
        if (tonguePulseRepo.getTonguePulseByPatientId(patientId) != null) {
            return convertToTonguePulseDTO(tonguePulseRepo.getTonguePulseByPatientId(patientId));
        } else {
            return null;
        }
    }

    public boolean getCompleteByPatientId(int patientId) {
        try {
            return tonguePulseRepo.getCompleteByPatientId(patientId);
        } catch (Exception e) {
            return false;
        }
    }

    private TonguePulseDO convertToTonguePulseDO(TonguePulseDTO tonguePulseDTO) {
        TonguePulseDO tonguePulseDO = new TonguePulseDO();
        tonguePulseDO.setComplete(tonguePulseDTO.isComplete());
        tonguePulseDO.setLeftPulse(tonguePulseDTO.getLeftPulse());
        tonguePulseDO.setMossy(tonguePulseDTO.getMossy());
        tonguePulseDO.setMossyPart(tonguePulseDTO.getMossyPart());
        tonguePulseDO.setMossyPartialDescription(tonguePulseDTO.getMossyPartialDescription());
        tonguePulseDO.setPatientId(tonguePulseDTO.getPatientId());
        tonguePulseDO.setRightPulse(tonguePulseDTO.getRightPulse());
        tonguePulseDO.setSublingualVaricoseVeins(tonguePulseDTO.getSublingualVaricoseVeins());
        tonguePulseDO.setTongue(tonguePulseDTO.getTongue());
        tonguePulseDO.setTongueBody(tonguePulseDTO.getTongueBody());
        tonguePulseDO.setTongueColor(tonguePulseDTO.getTongueColor());
        tonguePulseDO.setTongueColorPart(tonguePulseDTO.getTongueColorPart());
        tonguePulseDO.setTongueColorPartialDescription(
                tonguePulseDTO.getTongueColorPartialDescription());
        tonguePulseDO.setTonguePart(tonguePulseDTO.getTonguePart());
        tonguePulseDO.setFollowUp(tonguePulseDTO.isFollowUp());
        tonguePulseDO.setFollowUpDate(tonguePulseDTO.getFollowUpDate());
        tonguePulseDO.setTonguePartialDescription(tonguePulseDTO.getTonguePartialDescription());
        return tonguePulseDO;
    }

    private TonguePulseDTO convertToTonguePulseDTO(TonguePulseDO tDo) {
        TonguePulseDTO tDto = new TonguePulseDTO();
        tDto.setId(tDo.getId());
        tDto.setComplete(tDo.isComplete());
        tDto.setLeftPulse(tDo.getLeftPulse());
        tDto.setMossy(tDo.getMossy());
        tDto.setMossyPart(tDo.getMossyPart());
        tDto.setMossyPartialDescription(tDo.getMossyPartialDescription());
        tDto.setPatientId(tDo.getPatientId());
        tDto.setRightPulse(tDo.getRightPulse());
        tDto.setSublingualVaricoseVeins(tDo.getSublingualVaricoseVeins());
        tDto.setTongue(tDo.getTongue());
        tDto.setTongueBody(tDo.getTongueBody());
        tDto.setTongueColor(tDo.getTongueColor());
        tDto.setTongueColorPart(tDo.getTongueColorPart());
        tDto.setTongueColorPartialDescription(tDo.getTongueColorPartialDescription());
        tDto.setTonguePart(tDo.getTonguePart());
        tDto.setTonguePartialDescription(tDo.getTonguePartialDescription());
        tDto.setFollowUp(tDo.isFollowUp());
        tDto.setFollowUpDate(tDo.getFollowUpDate());
        return tDto;
    }

    @Override
    public List<TonguePulseDTO> getFollowTongue(int patientId) {
        if (!tonguePulseRepo.getFollowTongue(patientId).isEmpty()) {
            List<TonguePulseDTO> tonguePulseDTOs = new ArrayList<>();
            List<TonguePulseDO> tonguePulseDOs = tonguePulseRepo.getFollowTongue(patientId);
            for (TonguePulseDO tonguePulseDO : tonguePulseDOs) {
                tonguePulseDTOs.add(convertToTonguePulseDTO(tonguePulseDO));
            }
            return tonguePulseDTOs;
        } else {
            return null;
        }
    }

    @Override
    public TonguePulseDTO getDefaultTongue(int patientId) {
        return tonguePulseRepo.getDefaultTongue(patientId) != null
                ? convertToTonguePulseDTO(tonguePulseRepo.getDefaultTongue(patientId)) : null;
    }

}
