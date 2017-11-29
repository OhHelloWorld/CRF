package app.serviceImpl;

import app.dto.MedicineLiverFourDTO;
import app.entities.MedicineLiverFourDO;
import app.repo.MlFourRepo;
import app.service.MlCompleteService;
import app.service.MlFourService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by Administrator on 2017/11/27 0027.
 */
@Service
public class MlFourServiceImpl implements MlFourService,MlCompleteService{

    @Autowired
    private MlFourRepo mlFourRepo;

    private MedicineLiverFourDTO convertToDTO(MedicineLiverFourDO fourDO){
        MedicineLiverFourDTO fourDTO = new MedicineLiverFourDTO();
        fourDTO.setAbdominalDistention(fourDO.getAbdominalDistention());
        fourDTO.setAbdominalVeins(fourDO.getAbdominalVeins());
        fourDTO.setAnorexia(fourDO.getAnorexia());
        fourDTO.setAphrodisiacCold(fourDO.getAphrodisiacCold());
        fourDTO.setBackacheFootSoft(fourDO.getBackacheFootSoft());
        fourDTO.setBadBreath(fourDO.getBadBreath());
        fourDTO.setBelching(fourDO.getBelching());
        fourDTO.setBlurredVision(fourDO.getBlurredVision());
        fourDTO.setBodyYellow(fourDO.getBodyYellow());
        fourDTO.setConstipation(fourDO.getConstipation());
        fourDTO.setDepression(fourDO.getDepression());
        fourDTO.setDryMouth(fourDO.getDryMouth());
        fourDTO.setEasyWakeUp(fourDO.getEasyWakeUp());
        fourDTO.setEyeYellow(fourDO.getEyeYellow());
        fourDTO.setFaceDull(fourDO.getFaceDull());
        fourDTO.setFatigue(fourDO.getFatigue());
        fourDTO.setFlankPain(fourDO.getFlankPain());
        fourDTO.setFlankPainPersist(fourDO.getFlankPainPersist());
        fourDTO.setHandFootFanHot(fourDO.getHandFootFanHot());
        fourDTO.setId(fourDO.getId());
        fourDTO.setInsomnia(fourDO.getInsomnia());
        fourDTO.setIrritability(fourDO.getIrritability());
        fourDTO.setLeftVein(fourDO.getLeftVein());
        fourDTO.setLimb(fourDO.getLimb());
        fourDTO.setLiverPalm(fourDO.getLiverPalm());
        fourDTO.setLooseStools(fourDO.getLooseStools());
        fourDTO.setLowerExtremityEdema(fourDO.getLowerExtremityEdema());
        fourDTO.setMossColor(fourDO.getMossColor());
        fourDTO.setMossColorPart(fourDO.getMossColorPart());
        fourDTO.setMossNature(fourDO.getMossNature());
        fourDTO.setMossNaturePart(fourDO.getMossNaturePart());
        fourDTO.setMouthPain(fourDO.getMouthPain());
        fourDTO.setNausea(fourDO.getNausea());
        fourDTO.setRightVein(fourDO.getRightVein());
        fourDTO.setSkinItching(fourDO.getSkinItching());
        fourDTO.setSpiderNevus(fourDO.getSpiderNevus());
        fourDTO.setSublingualVein(fourDO.getSublingualVein());
        fourDTO.setSweat(fourDO.getSweat());
        fourDTO.setSweatPersist(fourDO.getSweatPersist());
        fourDTO.setTinnitus(fourDO.getTinnitus());
        fourDTO.setTongueBody(fourDO.getTongueBody());
        fourDTO.setTongueColor(fourDO.getTongueColor());
        fourDTO.setTongueGloss(fourDO.getTongueGloss());
        fourDTO.setTongueNature(fourDO.getTongueNature());
        fourDTO.setTongueNaturePart(fourDO.getTongueNaturePart());
        fourDTO.setTwoEyesDry(fourDO.getTwoEyesDry());
        fourDTO.setUrineYellow(fourDO.getUrineYellow());
        fourDTO.setYellowTumor(fourDO.getYellowTumor());
        return fourDTO;
    }

    private MedicineLiverFourDO convertToEntity(MedicineLiverFourDTO fourDTO){
        MedicineLiverFourDO fourDO = new MedicineLiverFourDO();
        fourDO.setAbdominalDistention(fourDTO.getAbdominalDistention());
        fourDO.setAbdominalVeins(fourDTO.getAbdominalVeins());
        fourDO.setAnorexia(fourDTO.getAnorexia());
        fourDO.setAphrodisiacCold(fourDTO.getAphrodisiacCold());
        fourDO.setBackacheFootSoft(fourDTO.getBackacheFootSoft());
        fourDO.setBadBreath(fourDTO.getBadBreath());
        fourDO.setBelching(fourDTO.getBelching());
        fourDO.setBlurredVision(fourDTO.getBlurredVision());
        fourDO.setBodyYellow(fourDTO.getBodyYellow());
        fourDO.setConstipation(fourDTO.getConstipation());
        fourDO.setDepression(fourDTO.getDepression());
        fourDO.setDryMouth(fourDTO.getDryMouth());
        fourDO.setEasyWakeUp(fourDTO.getEasyWakeUp());
        fourDO.setEyeYellow(fourDTO.getEyeYellow());
        fourDO.setFaceDull(fourDTO.getFaceDull());
        fourDO.setFatigue(fourDTO.getFatigue());
        fourDO.setFlankPain(fourDTO.getFlankPain());
        fourDO.setFlankPainPersist(fourDTO.getFlankPainPersist());
        fourDO.setHandFootFanHot(fourDTO.getHandFootFanHot());
        fourDO.setId(fourDTO.getId());
        fourDO.setInsomnia(fourDTO.getInsomnia());
        fourDO.setIrritability(fourDTO.getIrritability());
        fourDO.setLeftVein(fourDTO.getLeftVein());
        fourDO.setLimb(fourDTO.getLimb());
        fourDO.setLiverPalm(fourDTO.getLiverPalm());
        fourDO.setLooseStools(fourDTO.getLooseStools());
        fourDO.setLowerExtremityEdema(fourDTO.getLowerExtremityEdema());
        fourDO.setMossColor(fourDTO.getMossColor());
        fourDO.setMossColorPart(fourDTO.getMossColorPart());
        fourDO.setMossNature(fourDTO.getMossNature());
        fourDO.setMossNaturePart(fourDTO.getMossNaturePart());
        fourDO.setMouthPain(fourDTO.getMouthPain());
        fourDO.setNausea(fourDTO.getNausea());
        fourDO.setRightVein(fourDTO.getRightVein());
        fourDO.setSkinItching(fourDTO.getSkinItching());
        fourDO.setSpiderNevus(fourDTO.getSpiderNevus());
        fourDO.setSublingualVein(fourDTO.getSublingualVein());
        fourDO.setSweat(fourDTO.getSweat());
        fourDO.setSweatPersist(fourDTO.getSweatPersist());
        fourDO.setTinnitus(fourDTO.getTinnitus());
        fourDO.setTongueBody(fourDTO.getTongueBody());
        fourDO.setTongueColor(fourDTO.getTongueColor());
        fourDO.setTongueGloss(fourDTO.getTongueGloss());
        fourDO.setTongueNature(fourDTO.getTongueNature());
        fourDO.setTongueNaturePart(fourDTO.getTongueNaturePart());
        fourDO.setTwoEyesDry(fourDTO.getTwoEyesDry());
        fourDO.setUrineYellow(fourDTO.getUrineYellow());
        fourDO.setYellowTumor(fourDTO.getYellowTumor());
        return fourDO;
    }

    @Override
    public void saveFour(MedicineLiverFourDTO fourDTO) {
        mlFourRepo.save(convertToEntity(fourDTO));
    }

    @Override
    public MedicineLiverFourDTO getFourByPatientId(int patientId) {
        return mlFourRepo.findByPatientId(patientId)!=null?convertToDTO(mlFourRepo.findByPatientId(patientId)):null;
    }

    @Override
    public Boolean getCompleteByPatient(int mlPatientId) {
        return mlFourRepo.getCompleteByPatientId(mlPatientId);
    }
}
