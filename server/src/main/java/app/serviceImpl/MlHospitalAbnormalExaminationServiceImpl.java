package app.serviceImpl;

import app.dto.*;
import app.entities.*;
import app.repo.MlHospitalAbnormalExaminationRepo;
import app.service.MlCompleteService;
import app.service.MlHospitalAbnormalExaminationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
@Service
public class MlHospitalAbnormalExaminationServiceImpl implements MlHospitalAbnormalExaminationService,MlCompleteService {

    @Autowired
    private MlHospitalAbnormalExaminationRepo mlHospitalAbnormalExaminationRepo;

    private MedicineLiverHospitalAbnormalExaminationDTO convertToDTO(MedicineLiverHospitalAbnormalExaminationDO medicineLiverHospitalAbnormalExaminationDO){
        MedicineLiverHospitalAbnormalExaminationDTO medicineLiverHospitalAbnormalExaminationDTO = new MedicineLiverHospitalAbnormalExaminationDTO();
        medicineLiverHospitalAbnormalExaminationDTO.setComplete(medicineLiverHospitalAbnormalExaminationDO.isComplete());
        medicineLiverHospitalAbnormalExaminationDTO.setPatientId(medicineLiverHospitalAbnormalExaminationDO.getPatientId());
        List<MedicineLiverHospitalAbnormalExaminationLiverDO> medicineLiverHospitalAbnormalExaminationLiverDOS = medicineLiverHospitalAbnormalExaminationDO.getMedicineLiverHospitalAbnormalExaminationLiverDOS();
        List<MedicineLiverHospitalAbnormalExaminationLiverDTO> medicineLiverHospitalAbnormalExaminationLiverDTOS = new ArrayList<>();
        if(!medicineLiverHospitalAbnormalExaminationLiverDOS.isEmpty()){
            for(MedicineLiverHospitalAbnormalExaminationLiverDO medicineLiverHospitalAbnormalExaminationLiverDO : medicineLiverHospitalAbnormalExaminationLiverDOS){
                MedicineLiverHospitalAbnormalExaminationLiverDTO medicineLiverHospitalAbnormalExaminationLiverDTO = new MedicineLiverHospitalAbnormalExaminationLiverDTO();
                medicineLiverHospitalAbnormalExaminationLiverDTO.setAlb(medicineLiverHospitalAbnormalExaminationLiverDO.getAlb());
                medicineLiverHospitalAbnormalExaminationLiverDTO.setAlp(medicineLiverHospitalAbnormalExaminationLiverDO.getAlp());
                medicineLiverHospitalAbnormalExaminationLiverDTO.setAlt(medicineLiverHospitalAbnormalExaminationLiverDO.getAlt());
                medicineLiverHospitalAbnormalExaminationLiverDTO.setAst(medicineLiverHospitalAbnormalExaminationLiverDO.getAst());
                medicineLiverHospitalAbnormalExaminationLiverDTO.setBileAcid(medicineLiverHospitalAbnormalExaminationLiverDO.getBileAcid());
                medicineLiverHospitalAbnormalExaminationLiverDTO.setTab1CheckDate(medicineLiverHospitalAbnormalExaminationLiverDO.getTab1CheckDate());
                medicineLiverHospitalAbnormalExaminationLiverDTO.setDbil(medicineLiverHospitalAbnormalExaminationLiverDO.getDbil());
                medicineLiverHospitalAbnormalExaminationLiverDTO.setGgt(medicineLiverHospitalAbnormalExaminationLiverDO.getGgt());
                medicineLiverHospitalAbnormalExaminationLiverDTO.setTbil(medicineLiverHospitalAbnormalExaminationLiverDO.getTbil());
                medicineLiverHospitalAbnormalExaminationLiverDTO.setTp(medicineLiverHospitalAbnormalExaminationLiverDO.getTp());
                medicineLiverHospitalAbnormalExaminationLiverDTOS.add(medicineLiverHospitalAbnormalExaminationLiverDTO);
            }
        }

        List<MedicineLiverHospitalAbnormalExaminationKidneyDO> medicineLiverHospitalAbnormalExaminationKidneyDOS = medicineLiverHospitalAbnormalExaminationDO.getMedicineLiverHospitalAbnormalExaminationKidneyDOS();
        List<MedicineLiverHospitalAbnormalExaminationKidneyDTO> medicineLiverHospitalAbnormalExaminationKidneyDTOS = new ArrayList<>();
        if(!medicineLiverHospitalAbnormalExaminationKidneyDOS.isEmpty()){
            for(MedicineLiverHospitalAbnormalExaminationKidneyDO medicineLiverHospitalAbnormalExaminationKidneyDO : medicineLiverHospitalAbnormalExaminationKidneyDOS){
                MedicineLiverHospitalAbnormalExaminationKidneyDTO medicineLiverHospitalAbnormalExaminationKidneyDTO = new MedicineLiverHospitalAbnormalExaminationKidneyDTO();
                medicineLiverHospitalAbnormalExaminationKidneyDTO.setScr(medicineLiverHospitalAbnormalExaminationKidneyDO.getScr());
                medicineLiverHospitalAbnormalExaminationKidneyDTO.setUreaNitrogen(medicineLiverHospitalAbnormalExaminationKidneyDO.getUreaNitrogen());
                medicineLiverHospitalAbnormalExaminationKidneyDTO.setTab2CheckDate(medicineLiverHospitalAbnormalExaminationKidneyDO.getTab2CheckDate());
                medicineLiverHospitalAbnormalExaminationKidneyDTOS.add(medicineLiverHospitalAbnormalExaminationKidneyDTO);
            }
        }

        List<MedicineLiverHospitalAbnormalExaminationBsDO> medicineLiverHospitalAbnormalExaminationBsDOS = medicineLiverHospitalAbnormalExaminationDO.getMedicineLiverHospitalAbnormalExaminationBsDOS();
        List<MedicineLiverHospitalAbnormalExaminationBsDTO> medicineLiverHospitalAbnormalExaminationBsDTOS = new ArrayList<>();
        if(!medicineLiverHospitalAbnormalExaminationBsDOS.isEmpty()){
            for(MedicineLiverHospitalAbnormalExaminationBsDO medicineLiverHospitalAbnormalExaminationBsDO : medicineLiverHospitalAbnormalExaminationBsDOS){
                MedicineLiverHospitalAbnormalExaminationBsDTO medicineLiverHospitalAbnormalExaminationBsDTO = new MedicineLiverHospitalAbnormalExaminationBsDTO();
                medicineLiverHospitalAbnormalExaminationBsDTO.setPlasmaGlucose(medicineLiverHospitalAbnormalExaminationBsDO.getPlasmaGlucose());
                medicineLiverHospitalAbnormalExaminationBsDTO.setTab3CheckDate(medicineLiverHospitalAbnormalExaminationBsDO.getTab3CheckDate());
                medicineLiverHospitalAbnormalExaminationBsDTOS.add(medicineLiverHospitalAbnormalExaminationBsDTO);
            }
        }

        List<MedicineLiverHospitalAbnormalExaminationCruorDO> medicineLiverHospitalAbnormalExaminationCruorDOS = medicineLiverHospitalAbnormalExaminationDO.getMedicineLiverHospitalAbnormalExaminationCruorDOS();
        List<MedicineLiverHospitalAbnormalExaminationCruorDTO> medicineLiverHospitalAbnormalExaminationCruorDTOS = new ArrayList<>();
        if(!medicineLiverHospitalAbnormalExaminationCruorDOS.isEmpty()){
            for(MedicineLiverHospitalAbnormalExaminationCruorDO medicineLiverHospitalAbnormalExaminationCruorDO : medicineLiverHospitalAbnormalExaminationCruorDOS){
                MedicineLiverHospitalAbnormalExaminationCruorDTO medicineLiverHospitalAbnormalExaminationCruorDTO = new MedicineLiverHospitalAbnormalExaminationCruorDTO();
                medicineLiverHospitalAbnormalExaminationCruorDTO.setInr(medicineLiverHospitalAbnormalExaminationCruorDO.getInr());
                medicineLiverHospitalAbnormalExaminationCruorDTO.setTab4CheckDate(medicineLiverHospitalAbnormalExaminationCruorDO.getTab4CheckDate());
                medicineLiverHospitalAbnormalExaminationCruorDTO.setPt(medicineLiverHospitalAbnormalExaminationCruorDO.getPt());
                medicineLiverHospitalAbnormalExaminationCruorDTOS.add(medicineLiverHospitalAbnormalExaminationCruorDTO);
            }
        }

        List<MedicineLiverHospitalAbnormalExaminationTumourDO> medicineLiverHospitalAbnormalExaminationTumourDOS = medicineLiverHospitalAbnormalExaminationDO.getMedicineLiverHospitalAbnormalExaminationTumourDOS();
        List<MedicineLiverHospitalAbnormalExaminationTumourDTO> medicineLiverHospitalAbnormalExaminationTumourDTOS = new ArrayList<>();
        if(!medicineLiverHospitalAbnormalExaminationTumourDOS.isEmpty()){
            for(MedicineLiverHospitalAbnormalExaminationTumourDO medicineLiverHospitalAbnormalExaminationTumourDO : medicineLiverHospitalAbnormalExaminationTumourDOS){
                MedicineLiverHospitalAbnormalExaminationTumourDTO medicineLiverHospitalAbnormalExaminationTumourDTO = new MedicineLiverHospitalAbnormalExaminationTumourDTO();
                medicineLiverHospitalAbnormalExaminationTumourDTO.setAfp(medicineLiverHospitalAbnormalExaminationTumourDO.getAfp());
                medicineLiverHospitalAbnormalExaminationTumourDTO.setTab5CheckDate(medicineLiverHospitalAbnormalExaminationTumourDO.getTab5CheckDate());
                medicineLiverHospitalAbnormalExaminationTumourDTOS.add(medicineLiverHospitalAbnormalExaminationTumourDTO);
            }
        }

        medicineLiverHospitalAbnormalExaminationDTO.setMedicineLiverHospitalAbnormalExaminationLiverDTOS(medicineLiverHospitalAbnormalExaminationLiverDTOS);
        medicineLiverHospitalAbnormalExaminationDTO.setMedicineLiverHospitalAbnormalExaminationKidneyDTOS(medicineLiverHospitalAbnormalExaminationKidneyDTOS);
        medicineLiverHospitalAbnormalExaminationDTO.setMedicineLiverHospitalAbnormalExaminationBsDTOS(medicineLiverHospitalAbnormalExaminationBsDTOS);
        medicineLiverHospitalAbnormalExaminationDTO.setMedicineLiverHospitalAbnormalExaminationCruorDTOS(medicineLiverHospitalAbnormalExaminationCruorDTOS);
        medicineLiverHospitalAbnormalExaminationDTO.setMedicineLiverHospitalAbnormalExaminationTumourDTOS(medicineLiverHospitalAbnormalExaminationTumourDTOS);
        return medicineLiverHospitalAbnormalExaminationDTO;
    }

    private MedicineLiverHospitalAbnormalExaminationDO convertToEntity(MedicineLiverHospitalAbnormalExaminationDTO medicineLiverHospitalAbnormalExaminationDTO){
        MedicineLiverHospitalAbnormalExaminationDO medicineLiverHospitalAbnormalExaminationDO = new MedicineLiverHospitalAbnormalExaminationDO();
        medicineLiverHospitalAbnormalExaminationDO.setComplete(medicineLiverHospitalAbnormalExaminationDTO.isComplete());
        medicineLiverHospitalAbnormalExaminationDO.setPatientId(medicineLiverHospitalAbnormalExaminationDTO.getPatientId());
        List<MedicineLiverHospitalAbnormalExaminationLiverDTO> medicineLiverHospitalAbnormalExaminationLiverDTOS = medicineLiverHospitalAbnormalExaminationDTO.getMedicineLiverHospitalAbnormalExaminationLiverDTOS();
        List<MedicineLiverHospitalAbnormalExaminationLiverDO> medicineLiverHospitalAbnormalExaminationLiverDOS = new ArrayList<>();
        if(!medicineLiverHospitalAbnormalExaminationLiverDTOS.isEmpty()){
            for(MedicineLiverHospitalAbnormalExaminationLiverDTO medicineLiverHospitalAbnormalExaminationLiverDTO : medicineLiverHospitalAbnormalExaminationLiverDTOS){
                MedicineLiverHospitalAbnormalExaminationLiverDO medicineLiverHospitalAbnormalExaminationLiverDO = new MedicineLiverHospitalAbnormalExaminationLiverDO();
                medicineLiverHospitalAbnormalExaminationLiverDO.setAlb(medicineLiverHospitalAbnormalExaminationLiverDTO.getAlb());
                medicineLiverHospitalAbnormalExaminationLiverDO.setAlp(medicineLiverHospitalAbnormalExaminationLiverDTO.getAlp());
                medicineLiverHospitalAbnormalExaminationLiverDO.setAlt(medicineLiverHospitalAbnormalExaminationLiverDTO.getAlt());
                medicineLiverHospitalAbnormalExaminationLiverDO.setAst(medicineLiverHospitalAbnormalExaminationLiverDTO.getAst());
                medicineLiverHospitalAbnormalExaminationLiverDO.setBileAcid(medicineLiverHospitalAbnormalExaminationLiverDTO.getBileAcid());
                medicineLiverHospitalAbnormalExaminationLiverDO.setTab1CheckDate(medicineLiverHospitalAbnormalExaminationLiverDTO.getTab1CheckDate());
                medicineLiverHospitalAbnormalExaminationLiverDO.setDbil(medicineLiverHospitalAbnormalExaminationLiverDTO.getDbil());
                medicineLiverHospitalAbnormalExaminationLiverDO.setGgt(medicineLiverHospitalAbnormalExaminationLiverDTO.getGgt());
                medicineLiverHospitalAbnormalExaminationLiverDO.setTbil(medicineLiverHospitalAbnormalExaminationLiverDTO.getTbil());
                medicineLiverHospitalAbnormalExaminationLiverDO.setTp(medicineLiverHospitalAbnormalExaminationLiverDTO.getTp());
                medicineLiverHospitalAbnormalExaminationLiverDO.setMedicineLiverHospitalAbnormalExaminationDO(medicineLiverHospitalAbnormalExaminationDO);
                medicineLiverHospitalAbnormalExaminationLiverDOS.add(medicineLiverHospitalAbnormalExaminationLiverDO);
            }
        }

        List<MedicineLiverHospitalAbnormalExaminationKidneyDTO> medicineLiverHospitalAbnormalExaminationKidneyDTOS = medicineLiverHospitalAbnormalExaminationDTO.getMedicineLiverHospitalAbnormalExaminationKidneyDTOS();
        List<MedicineLiverHospitalAbnormalExaminationKidneyDO> medicineLiverHospitalAbnormalExaminationKidneyDOS = new ArrayList<>();
        if(!medicineLiverHospitalAbnormalExaminationKidneyDTOS.isEmpty()){
            for(MedicineLiverHospitalAbnormalExaminationKidneyDTO medicineLiverHospitalAbnormalExaminationKidneyDTO : medicineLiverHospitalAbnormalExaminationKidneyDTOS){
                MedicineLiverHospitalAbnormalExaminationKidneyDO medicineLiverHospitalAbnormalExaminationKidneyDO = new MedicineLiverHospitalAbnormalExaminationKidneyDO();
                medicineLiverHospitalAbnormalExaminationKidneyDO.setScr(medicineLiverHospitalAbnormalExaminationKidneyDTO.getScr());
                medicineLiverHospitalAbnormalExaminationKidneyDO.setUreaNitrogen(medicineLiverHospitalAbnormalExaminationKidneyDTO.getUreaNitrogen());
                medicineLiverHospitalAbnormalExaminationKidneyDO.setTab2CheckDate(medicineLiverHospitalAbnormalExaminationKidneyDTO.getTab2CheckDate());
                medicineLiverHospitalAbnormalExaminationKidneyDO.setMedicineLiverHospitalAbnormalExaminationDO(medicineLiverHospitalAbnormalExaminationDO);
                medicineLiverHospitalAbnormalExaminationKidneyDOS.add(medicineLiverHospitalAbnormalExaminationKidneyDO);
            }
        }

        List<MedicineLiverHospitalAbnormalExaminationBsDTO> medicineLiverHospitalAbnormalExaminationBsDTOS = medicineLiverHospitalAbnormalExaminationDTO.getMedicineLiverHospitalAbnormalExaminationBsDTOS();
        List<MedicineLiverHospitalAbnormalExaminationBsDO> medicineLiverHospitalAbnormalExaminationBsDOS = new ArrayList<>();
        if(!medicineLiverHospitalAbnormalExaminationBsDTOS.isEmpty()){
            for(MedicineLiverHospitalAbnormalExaminationBsDTO medicineLiverHospitalAbnormalExaminationBsDTO : medicineLiverHospitalAbnormalExaminationBsDTOS){
                MedicineLiverHospitalAbnormalExaminationBsDO medicineLiverHospitalAbnormalExaminationBsDO = new MedicineLiverHospitalAbnormalExaminationBsDO();
                medicineLiverHospitalAbnormalExaminationBsDO.setPlasmaGlucose(medicineLiverHospitalAbnormalExaminationBsDTO.getPlasmaGlucose());
                medicineLiverHospitalAbnormalExaminationBsDO.setTab3CheckDate(medicineLiverHospitalAbnormalExaminationBsDTO.getTab3CheckDate());
                medicineLiverHospitalAbnormalExaminationBsDO.setMedicineLiverHospitalAbnormalExaminationDO(medicineLiverHospitalAbnormalExaminationDO);
                medicineLiverHospitalAbnormalExaminationBsDOS.add(medicineLiverHospitalAbnormalExaminationBsDO);
            }
        }

        List<MedicineLiverHospitalAbnormalExaminationCruorDTO> medicineLiverHospitalAbnormalExaminationCruorDTOS = medicineLiverHospitalAbnormalExaminationDTO.getMedicineLiverHospitalAbnormalExaminationCruorDTOS();
        List<MedicineLiverHospitalAbnormalExaminationCruorDO> medicineLiverHospitalAbnormalExaminationCruorDOS = new ArrayList<>();
        if(!medicineLiverHospitalAbnormalExaminationCruorDTOS.isEmpty()){
            for(MedicineLiverHospitalAbnormalExaminationCruorDTO medicineLiverHospitalAbnormalExaminationCruorDTO : medicineLiverHospitalAbnormalExaminationCruorDTOS){
                MedicineLiverHospitalAbnormalExaminationCruorDO medicineLiverHospitalAbnormalExaminationCruorDO = new MedicineLiverHospitalAbnormalExaminationCruorDO();
                medicineLiverHospitalAbnormalExaminationCruorDO.setInr(medicineLiverHospitalAbnormalExaminationCruorDTO.getInr());
                medicineLiverHospitalAbnormalExaminationCruorDO.setTab4CheckDate(medicineLiverHospitalAbnormalExaminationCruorDTO.getTab4CheckDate());
                medicineLiverHospitalAbnormalExaminationCruorDO.setPt(medicineLiverHospitalAbnormalExaminationCruorDTO.getPt());
                medicineLiverHospitalAbnormalExaminationCruorDO.setMedicineLiverHospitalAbnormalExaminationDO(medicineLiverHospitalAbnormalExaminationDO);
                medicineLiverHospitalAbnormalExaminationCruorDOS.add(medicineLiverHospitalAbnormalExaminationCruorDO);
            }
        }

        List<MedicineLiverHospitalAbnormalExaminationTumourDTO> medicineLiverHospitalAbnormalExaminationTumourDTOS = medicineLiverHospitalAbnormalExaminationDTO.getMedicineLiverHospitalAbnormalExaminationTumourDTOS();
        List<MedicineLiverHospitalAbnormalExaminationTumourDO> medicineLiverHospitalAbnormalExaminationTumourDOS = new ArrayList<>();
        if(!medicineLiverHospitalAbnormalExaminationTumourDTOS.isEmpty()){
            for(MedicineLiverHospitalAbnormalExaminationTumourDTO medicineLiverHospitalAbnormalExaminationTumourDTO : medicineLiverHospitalAbnormalExaminationTumourDTOS){
                MedicineLiverHospitalAbnormalExaminationTumourDO medicineLiverHospitalAbnormalExaminationTumourDO = new MedicineLiverHospitalAbnormalExaminationTumourDO();
                medicineLiverHospitalAbnormalExaminationTumourDO.setAfp(medicineLiverHospitalAbnormalExaminationTumourDTO.getAfp());
                medicineLiverHospitalAbnormalExaminationTumourDO.setTab5CheckDate(medicineLiverHospitalAbnormalExaminationTumourDTO.getTab5CheckDate());
                medicineLiverHospitalAbnormalExaminationTumourDO.setMedicineLiverHospitalAbnormalExaminationDO(medicineLiverHospitalAbnormalExaminationDO);
                medicineLiverHospitalAbnormalExaminationTumourDOS.add(medicineLiverHospitalAbnormalExaminationTumourDO);
            }
        }

        medicineLiverHospitalAbnormalExaminationDO.setMedicineLiverHospitalAbnormalExaminationLiverDOS(medicineLiverHospitalAbnormalExaminationLiverDOS);
        medicineLiverHospitalAbnormalExaminationDO.setMedicineLiverHospitalAbnormalExaminationKidneyDOS(medicineLiverHospitalAbnormalExaminationKidneyDOS);
        medicineLiverHospitalAbnormalExaminationDO.setMedicineLiverHospitalAbnormalExaminationBsDOS(medicineLiverHospitalAbnormalExaminationBsDOS);
        medicineLiverHospitalAbnormalExaminationDO.setMedicineLiverHospitalAbnormalExaminationCruorDOS(medicineLiverHospitalAbnormalExaminationCruorDOS);
        medicineLiverHospitalAbnormalExaminationDO.setMedicineLiverHospitalAbnormalExaminationTumourDOS(medicineLiverHospitalAbnormalExaminationTumourDOS);
        return medicineLiverHospitalAbnormalExaminationDO;
    }

    @Override
    public void saveHospitalExam(MedicineLiverHospitalAbnormalExaminationDTO medicineLiverHospitalAbnormalExaminationDTO) {
        mlHospitalAbnormalExaminationRepo.save(convertToEntity(medicineLiverHospitalAbnormalExaminationDTO));
    }

    @Override
    public MedicineLiverHospitalAbnormalExaminationDTO getHospitalExamByPatientId(int mlPatientId) {
        return mlHospitalAbnormalExaminationRepo.getHospitalAbnormalExamByPatientId(mlPatientId) != null?convertToDTO(mlHospitalAbnormalExaminationRepo.getHospitalAbnormalExamByPatientId(mlPatientId)):null;
    }

    @Override
    public Boolean getCompleteByPatient(int mlPatientId) {
        return mlHospitalAbnormalExaminationRepo.getCompleteByPatientId(mlPatientId);
    }
}
