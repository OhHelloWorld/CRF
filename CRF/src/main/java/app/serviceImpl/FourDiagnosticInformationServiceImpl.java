package app.serviceImpl;

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

        fRepo.save(convertToFourdiagnosticinformationDTO(fDto));
    }

    public FourDiagnosticInformationDTO getFourDiagnosticInfoByPatientId(int patientId) {

        return convertToFourDiagnosticInfoDTO(fRepo.findFourDiagnosticInfoByPatientId(patientId));
    }

    public boolean getCompleteByPatientId(int patientId) {
        try {
            return fRepo.getCompleteByPatientId(patientId);
        } catch (Exception e) {
            return false;
        }
    }

    private FourDiagnosticInformationDO convertToFourdiagnosticinformationDTO(
            FourDiagnosticInformationDTO fDto) {
        FourDiagnosticInformationDO fDo = new FourDiagnosticInformationDO();
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
}
