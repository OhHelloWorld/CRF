package app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import app.dto.FourDiagnosticInformationDTO;
import app.entities.FourDiagnosticInformationDO;
import app.repo.FourDiagnosticInformationRepo;
import app.service.FourDiagnosticInformationService;

@Service
public class FourDiagnosticInformationServiceImpl implements FourDiagnosticInformationService {

    @Autowired
    private FourDiagnosticInformationRepo fRepo;

    @Transactional
    public void saveFourDiagnosticInformation(FourDiagnosticInformationDTO fDto) {

        fRepo.save(convertToFourdiagnosticinfoDO(fDto,null));
    }

    public FourDiagnosticInformationDTO getFourDiagnosticInfoByPatientId(int patientId) {

        if (fRepo.findFourDiagnosticInfoByPatientId(patientId) != null) {
            return convertToFourDiagnosticInfoDTO(
                    fRepo.findFourDiagnosticInfoByPatientId(patientId));
        } else {
            return null;
        }
    }

    public boolean getCompleteByPatientId(int patientId) {
//        try {
//            return fRepo.getCompleteByPatientId(patientId);
//        } catch (Exception e) {
//            return false;
//        }
        return fRepo.getCompleteByPatientId(patientId)!=null?fRepo.getCompleteByPatientId(patientId):false;
    }

    private FourDiagnosticInformationDO convertToFourdiagnosticinfoDO(
            FourDiagnosticInformationDTO fDto,FourDiagnosticInformationDO fDo){
        if(fDo == null) {
            fDo = new FourDiagnosticInformationDO();
        }
        fDo.setAbdominalDistention(fDto.getAbdominalDistention());
        fDo.setAbdominalVeins(fDto.getAbdominalVeins());
        fDo.setAnorexia(fDto.getAnorexia());
        fDo.setAphrodisiacCold(fDto.getAphrodisiacCold());
        fDo.setBackacheFootSoft(fDto.getBackacheFootSoft());
        fDo.setBadBreath(fDto.getBadBreath());
        fDo.setBelching(fDto.getBelching());
        fDo.setBlurredVision(fDto.getBlurredVision());
        fDo.setBodyYellow(fDto.getBodyYellow());
        fDo.setComplete(fDto.isComplete());
        fDo.setConstipation(fDto.getConstipation());
        fDo.setDepression(fDto.getDepression());
        fDo.setDryMouth(fDto.getDryMouth());
        fDo.setEasyWakeUp(fDto.getEasyWakeUp());
        fDo.setEyeYellow(fDto.getEyeYellow());
        fDo.setFaceDull(fDto.getFaceDull());
        fDo.setFatigue(fDto.getFatigue());
        fDo.setFlankPainDiscomfort(fDto.getFlankPainDiscomfort());
        fDo.setFlankPainDull(fDto.getFlankPainDull());
        fDo.setFlankPainStinging(fDto.getFlankPainStinging());
        fDo.setFlankPainSwell(fDto.getFlankPainSwell());
        fDo.setFollowUp(fDto.isFollowUp());
        fDo.setFollowUpDate(fDto.getFollowUpDate());
        fDo.setHandFootFanHot(fDto.getHandFootFanHot());
        fDo.setInsomnia(fDto.getInsomnia());
        fDo.setIrritability(fDto.getIrritability());
        fDo.setLimb(fDto.getLimb());
        fDo.setLiverPalm(fDto.getLiverPalm());
        fDo.setLooseStools(fDto.getLooseStools());
        fDo.setLowerExtremityEdema(fDto.getLowerExtremityEdema());
        fDo.setMouthPain(fDto.getMouthPain());
        fDo.setNausea(fDto.getNausea());
        fDo.setNightSweats(fDto.getNightSweats());
        fDo.setPatientId(fDto.getPatientId());
        fDo.setPerspiration(fDto.getPerspiration());
        fDo.setSkinItching(fDto.getSkinItching());
        fDo.setSpiderNevus(fDto.getSpiderNevus());
        fDo.setTinnitus(fDto.getTinnitus());
        fDo.setTwoEyesDry(fDto.getTwoEyesDry());
        fDo.setUrineYellow(fDto.getUrineYellow());
        fDo.setYellowTumor(fDto.getYellowTumor());
        return fDo;
    }

    private FourDiagnosticInformationDTO convertToFourDiagnosticInfoDTO(
            FourDiagnosticInformationDO fDo) {
        FourDiagnosticInformationDTO fDto = new FourDiagnosticInformationDTO();
        fDto.setId(fDo.getId());
        fDto.setAbdominalDistention(fDo.getAbdominalDistention());
        fDto.setAbdominalVeins(fDo.getAbdominalVeins());
        fDto.setAnorexia(fDo.getAnorexia());
        fDto.setAphrodisiacCold(fDo.getAphrodisiacCold());
        fDto.setBackacheFootSoft(fDo.getBackacheFootSoft());
        fDto.setBadBreath(fDo.getBadBreath());
        fDto.setBelching(fDo.getBelching());
        fDto.setBlurredVision(fDo.getBlurredVision());
        fDto.setBodyYellow(fDo.getBodyYellow());
        fDto.setComplete(fDo.isComplete());
        fDto.setConstipation(fDo.getConstipation());
        fDto.setDepression(fDo.getDepression());
        fDto.setDryMouth(fDo.getDryMouth());
        fDto.setEasyWakeUp(fDo.getEasyWakeUp());
        fDto.setEyeYellow(fDo.getEyeYellow());
        fDto.setFaceDull(fDo.getFaceDull());
        fDto.setFatigue(fDo.getFatigue());
        fDto.setFlankPainDiscomfort(fDo.getFlankPainDiscomfort());
        fDto.setFlankPainDull(fDo.getFlankPainDull());
        fDto.setFlankPainStinging(fDo.getFlankPainStinging());
        fDto.setFlankPainSwell(fDo.getFlankPainSwell());
        fDto.setFollowUp(fDo.isFollowUp());
        fDto.setFollowUpDate(fDo.getFollowUpDate());
        fDto.setHandFootFanHot(fDo.getHandFootFanHot());
        fDto.setInsomnia(fDo.getInsomnia());
        fDto.setIrritability(fDo.getIrritability());
        fDto.setLimb(fDo.getLimb());
        fDto.setLiverPalm(fDo.getLiverPalm());
        fDto.setLooseStools(fDo.getLooseStools());
        fDto.setLowerExtremityEdema(fDo.getLowerExtremityEdema());
        fDto.setMouthPain(fDo.getMouthPain());
        fDto.setNausea(fDo.getNausea());
        fDto.setNightSweats(fDo.getNightSweats());
        fDto.setPatientId(fDo.getPatientId());
        fDto.setPerspiration(fDo.getPerspiration());
        fDto.setSkinItching(fDo.getSkinItching());
        fDto.setSpiderNevus(fDo.getSpiderNevus());
        fDto.setTinnitus(fDo.getTinnitus());
        fDto.setTwoEyesDry(fDo.getTwoEyesDry());
        fDto.setUrineYellow(fDo.getUrineYellow());
        fDto.setYellowTumor(fDo.getYellowTumor());
        return fDto;
    }

    @Override
    public List<FourDiagnosticInformationDTO> getFollowFourDia(int patientId) {
        if (!fRepo.getFollowFourDia(patientId).isEmpty()) {
            List<FourDiagnosticInformationDO> fourDiagnosticInformationDOs =
                    fRepo.getFollowFourDia(patientId);
            List<FourDiagnosticInformationDTO> fourDiagnosticInformationDTOs = new ArrayList<>();
            for (FourDiagnosticInformationDO fourDiagnosticInformationDO : fourDiagnosticInformationDOs) {
                fourDiagnosticInformationDTOs
                        .add(convertToFourDiagnosticInfoDTO(fourDiagnosticInformationDO));
            }
            return fourDiagnosticInformationDTOs;
        } else {
            return null;
        }
    }

    @Override
    public FourDiagnosticInformationDTO getDefaultFourDia(int patientId) {
        return fRepo.getDefaultFourDia(patientId) != null
                ? convertToFourDiagnosticInfoDTO(fRepo.getDefaultFourDia(patientId)) : null;
    }

    @Override
    public FourDiagnosticInformationDTO getSingleFollowById(int id) {
        return convertToFourDiagnosticInfoDTO(fRepo.findOne(id));
    }

    @Override
    public void updateFourDia(FourDiagnosticInformationDTO fourDiagnosticInformationDTO) {
        FourDiagnosticInformationDO fourDiagnosticInformationDO = fRepo.findOne(fourDiagnosticInformationDTO.getId());
        fRepo.save(convertToFourdiagnosticinfoDO(fourDiagnosticInformationDTO,fourDiagnosticInformationDO));
    }
}
