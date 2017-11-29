package app.serviceImpl;

import app.dto.MedicineLiverTreatmentCnDTO;
import app.dto.MedicineLiverTreatmentDTO;
import app.dto.MedicineLiverTreatmentDetailDTO;
import app.dto.MedicineLiverTreatmentOtherDTO;
import app.entities.MedicineLiverTreatmentCnDO;
import app.entities.MedicineLiverTreatmentDO;
import app.entities.MedicineLiverTreatmentDetailDO;
import app.entities.MedicineLiverTreatmentOtherDO;
import app.repo.MlTreatmentCnRepo;
import app.repo.MlTreatmentDetailRepo;
import app.repo.MlTreatmentOtherRepo;
import app.repo.MlTreatmentRepo;
import app.service.MlCompleteService;
import app.service.MlTreatmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/12 0012.
 */
@Service
public class MlTreatmentServiceImpl implements MlTreatmentService,MlCompleteService{

    @Autowired
    private MlTreatmentRepo mlTreatmentRepo;

    @Autowired
    private MlTreatmentOtherRepo mlTreatmentOtherRepo;

    @Autowired
    private MlTreatmentDetailRepo mlTreatmentDetailRepo;

    @Autowired
    private MlTreatmentCnRepo mlTreatmentCnRepo;

    private MedicineLiverTreatmentDTO convertToDTO(MedicineLiverTreatmentDO medicineLiverTreatmentDO){
        MedicineLiverTreatmentDTO medicineLiverTreatmentDTO = new MedicineLiverTreatmentDTO();
        medicineLiverTreatmentDTO.setId(medicineLiverTreatmentDO.getId());
        medicineLiverTreatmentDTO.setComplete(medicineLiverTreatmentDO.isComplete());
        medicineLiverTreatmentDTO.setTreatment(medicineLiverTreatmentDO.getTreatment());

        List<MedicineLiverTreatmentDetailDTO> medicineLiverTreatmentDetailDTOS = new ArrayList<>();
        List<MedicineLiverTreatmentDetailDO> medicineLiverTreatmentDetailDOS = medicineLiverTreatmentDO.getMedicineLiverTreatmentDetailDOS();
        if(!medicineLiverTreatmentDetailDOS.isEmpty() && medicineLiverTreatmentDetailDOS != null){
            for(MedicineLiverTreatmentDetailDO medicineLiverTreatmentDetailDO : medicineLiverTreatmentDetailDOS){
                MedicineLiverTreatmentDetailDTO medicineLiverTreatmentDetailDTO = new MedicineLiverTreatmentDetailDTO();
                medicineLiverTreatmentDetailDTO.setId(medicineLiverTreatmentDetailDO.getId());
                medicineLiverTreatmentDetailDTO.setDetailEndDate(medicineLiverTreatmentDetailDO.getDetailEndDate());
                medicineLiverTreatmentDetailDTO.setDetailMethod(medicineLiverTreatmentDetailDO.getDetailMethod());
                medicineLiverTreatmentDetailDTO.setDetailStartDate(medicineLiverTreatmentDetailDO.getDetailStartDate());
                medicineLiverTreatmentDetailDTO.setCategory(medicineLiverTreatmentDetailDO.getCategory());
                medicineLiverTreatmentDetailDTO.setDose(medicineLiverTreatmentDetailDO.getDose());
                medicineLiverTreatmentDetailDTO.setGenericName(medicineLiverTreatmentDetailDO.getGenericName());
                medicineLiverTreatmentDetailDTO.setMedicineLiverTreatmentId(medicineLiverTreatmentDetailDO.getMedicineLiverTreatmentDO().getId());
                medicineLiverTreatmentDetailDTO.setTradeName(medicineLiverTreatmentDetailDO.getTradeName());
                medicineLiverTreatmentDetailDTOS.add(medicineLiverTreatmentDetailDTO);
            }
        }

        List<MedicineLiverTreatmentCnDTO> medicineLiverTreatmentCnDTOS = new ArrayList<>();
        List<MedicineLiverTreatmentCnDO> medicineLiverTreatmentCnDOS = medicineLiverTreatmentDO.getMedicineLiverTreatmentCnDOS();
        if(!medicineLiverTreatmentCnDOS.isEmpty() && medicineLiverTreatmentCnDOS != null){
            for(MedicineLiverTreatmentCnDO medicineLiverTreatmentCnDO : medicineLiverTreatmentCnDOS){
                MedicineLiverTreatmentCnDTO medicineLiverTreatmentCnDTO = new MedicineLiverTreatmentCnDTO();
                medicineLiverTreatmentCnDTO.setCnDose(medicineLiverTreatmentCnDO.getCnDose());
                medicineLiverTreatmentCnDTO.setCnEndDate(medicineLiverTreatmentCnDO.getCnEndDate());
                medicineLiverTreatmentCnDTO.setCnMethod(medicineLiverTreatmentCnDO.getCnMethod());
                medicineLiverTreatmentCnDTO.setCnStartDate(medicineLiverTreatmentCnDO.getCnStartDate());
                medicineLiverTreatmentCnDTO.setCnTradeName(medicineLiverTreatmentCnDO.getCnTradeName());
                medicineLiverTreatmentCnDTOS.add(medicineLiverTreatmentCnDTO);
            }
        }

        List<MedicineLiverTreatmentOtherDTO> medicineLiverTreatmentOtherDTOS = new ArrayList<>();
        List<MedicineLiverTreatmentOtherDO> medicineLiverTreatmentOtherDOS = medicineLiverTreatmentDO.getMedicineLiverTreatmentOtherDOS();
        if(!medicineLiverTreatmentOtherDOS.isEmpty() && medicineLiverTreatmentOtherDOS != null){
            for(MedicineLiverTreatmentOtherDO medicineLiverTreatmentOtherDO : medicineLiverTreatmentOtherDOS){
                MedicineLiverTreatmentOtherDTO medicineLiverTreatmentOtherDTO = new MedicineLiverTreatmentOtherDTO();
                medicineLiverTreatmentOtherDTO.setMedicineLiverTreatmentId(medicineLiverTreatmentOtherDO.getMedicineLiverTreatmentDO().getId());
                medicineLiverTreatmentOtherDTO.setId(medicineLiverTreatmentOtherDO.getId());
                medicineLiverTreatmentOtherDTO.setMethod(medicineLiverTreatmentOtherDO.getMethod());
                medicineLiverTreatmentOtherDTO.setMethodDetail(medicineLiverTreatmentOtherDO.getMethodDetail());
                medicineLiverTreatmentOtherDTO.setOtherEndDate(medicineLiverTreatmentOtherDO.getOtherEndDate());
                medicineLiverTreatmentOtherDTO.setOtherStartDate(medicineLiverTreatmentOtherDO.getOtherStartDate());
                medicineLiverTreatmentOtherDTOS.add(medicineLiverTreatmentOtherDTO);
            }
        }

        medicineLiverTreatmentDTO.setMedicineLiverTreatmentDetailDTOS(medicineLiverTreatmentDetailDTOS);
        medicineLiverTreatmentDTO.setMedicineLiverTreatmentOtherDTOS(medicineLiverTreatmentOtherDTOS);
        medicineLiverTreatmentDTO.setMedicineLiverTreatmentCnDTOS(medicineLiverTreatmentCnDTOS);
        return medicineLiverTreatmentDTO;
    }

    private MedicineLiverTreatmentDO convertToEntity(MedicineLiverTreatmentDTO medicineLiverTreatmentDTO){
        MedicineLiverTreatmentDO medicineLiverTreatmentDO = new MedicineLiverTreatmentDO();
        medicineLiverTreatmentDO.setComplete(medicineLiverTreatmentDTO.isComplete());
        medicineLiverTreatmentDO.setPatientId(medicineLiverTreatmentDTO.getPatientId());
        medicineLiverTreatmentDO.setTreatment(medicineLiverTreatmentDTO.getTreatment());
        List<MedicineLiverTreatmentDetailDO> medicineLiverTreatmentDetailDOS = new ArrayList<>();
        List<MedicineLiverTreatmentOtherDO> medicineLiverTreatmentOtherDOS = new ArrayList<>();
        List<MedicineLiverTreatmentCnDO> medicineLiverTreatmentCnDOS = new ArrayList<>();

        if(medicineLiverTreatmentDTO.getId()!=0){
            mlTreatmentDetailRepo.deleteTreatmentDetailByTId(medicineLiverTreatmentDTO.getId());
            mlTreatmentOtherRepo.deleteTreatmentOtherByTId(medicineLiverTreatmentDTO.getId());
            mlTreatmentCnRepo.deleteTreatmentCnByTId(medicineLiverTreatmentDTO.getId());
        }

        List<MedicineLiverTreatmentDetailDTO> medicineLiverTreatmentDetailDTOS = medicineLiverTreatmentDTO.getMedicineLiverTreatmentDetailDTOS();
        if(medicineLiverTreatmentDetailDTOS != null && !medicineLiverTreatmentDetailDTOS.isEmpty() ){
            for(MedicineLiverTreatmentDetailDTO medicineLiverTreatmentDetailDTO : medicineLiverTreatmentDetailDTOS) {
                MedicineLiverTreatmentDetailDO medicineLiverTreatmentDetailDO = new MedicineLiverTreatmentDetailDO();
                medicineLiverTreatmentDetailDO.setDetailEndDate(medicineLiverTreatmentDetailDTO.getDetailEndDate());
                medicineLiverTreatmentDetailDO.setDetailMethod(medicineLiverTreatmentDetailDTO.getDetailMethod());
                medicineLiverTreatmentDetailDO.setDetailStartDate(medicineLiverTreatmentDetailDTO.getDetailStartDate());
                medicineLiverTreatmentDetailDO.setCategory(medicineLiverTreatmentDetailDTO.getCategory());
                medicineLiverTreatmentDetailDO.setDose(medicineLiverTreatmentDetailDTO.getDose());
                medicineLiverTreatmentDetailDO.setGenericName(medicineLiverTreatmentDetailDTO.getGenericName());
                medicineLiverTreatmentDetailDO.setTradeName(medicineLiverTreatmentDetailDTO.getTradeName());
                medicineLiverTreatmentDetailDO.setMedicineLiverTreatmentDO(medicineLiverTreatmentDO);
                medicineLiverTreatmentDetailDOS.add(medicineLiverTreatmentDetailDO);
            }
        }

        List<MedicineLiverTreatmentCnDTO> medicineLiverTreatmentCnDTOS = medicineLiverTreatmentDTO.getMedicineLiverTreatmentCnDTOS();
        if(medicineLiverTreatmentCnDTOS != null && !medicineLiverTreatmentCnDTOS.isEmpty() ){
            for(MedicineLiverTreatmentCnDTO medicineLiverTreatmentCnDTO : medicineLiverTreatmentCnDTOS) {
                MedicineLiverTreatmentCnDO medicineLiverTreatmentCnDO = new MedicineLiverTreatmentCnDO();
                medicineLiverTreatmentCnDO.setCnTradeName(medicineLiverTreatmentCnDTO.getCnTradeName());
                medicineLiverTreatmentCnDO.setCnStartDate(medicineLiverTreatmentCnDTO.getCnStartDate());
                medicineLiverTreatmentCnDO.setCnMethod(medicineLiverTreatmentCnDTO.getCnMethod());
                medicineLiverTreatmentCnDO.setCnEndDate(medicineLiverTreatmentCnDTO.getCnEndDate());
                medicineLiverTreatmentCnDO.setCnDose(medicineLiverTreatmentCnDTO.getCnDose());
                medicineLiverTreatmentCnDO.setMedicineLiverTreatmentDO(medicineLiverTreatmentDO);
                medicineLiverTreatmentCnDOS.add(medicineLiverTreatmentCnDO);
            }
        }

        List<MedicineLiverTreatmentOtherDTO> medicineLiverTreatmentOtherDTOS = medicineLiverTreatmentDTO.getMedicineLiverTreatmentOtherDTOS();
        if(medicineLiverTreatmentOtherDTOS != null && !medicineLiverTreatmentOtherDTOS.isEmpty()){
            for(MedicineLiverTreatmentOtherDTO medicineLiverTreatmentOtherDTO : medicineLiverTreatmentOtherDTOS) {
                MedicineLiverTreatmentOtherDO medicineLiverTreatmentOtherDO = new MedicineLiverTreatmentOtherDO();
                medicineLiverTreatmentOtherDO.setMethod(medicineLiverTreatmentOtherDTO.getMethod());
                medicineLiverTreatmentOtherDO.setMethodDetail(medicineLiverTreatmentOtherDTO.getMethodDetail());
                medicineLiverTreatmentOtherDO.setOtherEndDate(medicineLiverTreatmentOtherDTO.getOtherEndDate());
                medicineLiverTreatmentOtherDO.setOtherStartDate(medicineLiverTreatmentOtherDTO.getOtherStartDate());
                medicineLiverTreatmentOtherDO.setMedicineLiverTreatmentDO(medicineLiverTreatmentDO);
                medicineLiverTreatmentOtherDOS.add(medicineLiverTreatmentOtherDO);
            }
        }

        medicineLiverTreatmentDO.setMedicineLiverTreatmentDetailDOS(medicineLiverTreatmentDetailDOS);
        medicineLiverTreatmentDO.setMedicineLiverTreatmentCnDOS(medicineLiverTreatmentCnDOS);
        medicineLiverTreatmentDO.setMedicineLiverTreatmentOtherDOS(medicineLiverTreatmentOtherDOS);
        return medicineLiverTreatmentDO;
    }

    @Override
    public void saveMlTreatment(MedicineLiverTreatmentDTO medicineLiverTreatmentDTO) {
        mlTreatmentRepo.save(convertToEntity(medicineLiverTreatmentDTO));
    }

    @Override
    public MedicineLiverTreatmentDTO getTreatmentByPatientId(int mlPatientId) {
        return mlTreatmentRepo.getTreatByPatientId(mlPatientId) != null?convertToDTO(mlTreatmentRepo.getTreatByPatientId(mlPatientId)):null;
    }

    @Override
    public Boolean getCompleteByPatient(int mlPatientId) {
        return mlTreatmentRepo.getCompleteByPatientId(mlPatientId);
    }
}
