package app.serviceImpl;

import app.dto.*;
import app.entities.*;
import app.repo.*;
import app.service.MlCompleteService;
import app.service.MlDrugHistoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2017/9/6 0006.
 */
@Service
public class MlDrugHistoryServiceImpl implements MlDrugHistoryService, MlCompleteService {

    @Autowired
    private MlDrugHistoryRepo mlDrugHistoryRepo;

    @Autowired
    private MlDrinkDetailRepo mlDrinkDetailRepo;

    @Autowired
    private MlProChineseMedicineRepo mlProChineseMedicineRepo;

    @Autowired
    private MlHerbalRepo mlHerbalRepo;

    @Autowired
    private MlSuspendChineseRepo mlSuspendChineseRepo;

    private MedicineLiverSuspectedDrugDTO convertToDTO(MedicineLiverSuspectedDrugDO medicineLiverSuspectedDrugDO) {
        MedicineLiverSuspectedDrugDTO medicineLiverSuspectedDrugDTO = new MedicineLiverSuspectedDrugDTO();
        medicineLiverSuspectedDrugDTO.setPatientId(medicineLiverSuspectedDrugDO.getPatientId());
        medicineLiverSuspectedDrugDTO.setComplete(medicineLiverSuspectedDrugDO.isComplete());
        medicineLiverSuspectedDrugDTO.setId(medicineLiverSuspectedDrugDO.getId());

        List<MedicineLiverSuspectedDrugDetailDTO> medicineLiverSuspectedDrugDetailDTOS = new ArrayList<>();
        List<MlProprietaryChineseMedicineDTO> mlProprietaryChineseMedicineDTOS = new ArrayList<>();
        List<MlChineseHerbalMedicineDTO> mlChineseHerbalMedicineDTOS = new ArrayList<>();
        List<MlSuspendChineseMedicineDTO> mlSuspendChineseMedicineDTOS = new ArrayList<>();

        List<MlProprietaryChineseMedicineDO> mlProprietaryChineseMedicineDOS = medicineLiverSuspectedDrugDO.getMlProprietaryChineseMedicineDOS();
        List<MlChineseHerbalMedicineDO> mlChineseHerbalMedicineDOS = medicineLiverSuspectedDrugDO.getMlChineseHerbalMedicineDOS();
        List<MlSuspendChineseMedicineDO> mlSuspendChineseMedicineDOS = medicineLiverSuspectedDrugDO.getMlSuspendChineseMedicineDOS();
        List<MedicineLiverSuspectedDrugDetailDO> medicineLiverSuspectedDrugDetailDOS = medicineLiverSuspectedDrugDO.getMedicineLiverSuspectedDrugDetailDOS();

        if (medicineLiverSuspectedDrugDetailDOS != null && !medicineLiverSuspectedDrugDetailDOS.isEmpty()) {
            for (MedicineLiverSuspectedDrugDetailDO medicineLiverSuspectedDrugDetailDO : medicineLiverSuspectedDrugDetailDOS) {
                MedicineLiverSuspectedDrugDetailDTO medicineLiverSuspectedDrugDetailDTO = new MedicineLiverSuspectedDrugDetailDTO();
                medicineLiverSuspectedDrugDetailDTO.setId(medicineLiverSuspectedDrugDetailDO.getId());
                medicineLiverSuspectedDrugDetailDTO.setBeginDate(medicineLiverSuspectedDrugDetailDO.getBeginDate());
                medicineLiverSuspectedDrugDetailDTO.setDecrement(medicineLiverSuspectedDrugDetailDO.getDecrement());
                medicineLiverSuspectedDrugDetailDTO.setDose(medicineLiverSuspectedDrugDetailDO.getDose());
                medicineLiverSuspectedDrugDetailDTO.setDrugExposure(medicineLiverSuspectedDrugDetailDO.getDrugExposure());
                medicineLiverSuspectedDrugDetailDTO.setDrugWithDrawal(medicineLiverSuspectedDrugDetailDO.getDrugWithDrawal());
                medicineLiverSuspectedDrugDetailDTO.setDrugWithDrawalDate(medicineLiverSuspectedDrugDetailDO.getDrugWithDrawalDate());
                medicineLiverSuspectedDrugDetailDTO.setExposureLiverDamage(medicineLiverSuspectedDrugDetailDO.getExposureLiverDamage());
                medicineLiverSuspectedDrugDetailDTO.setMedicationMethod(medicineLiverSuspectedDrugDetailDO.getMedicationMethod());
                medicineLiverSuspectedDrugDetailDTO.setGenericName(medicineLiverSuspectedDrugDetailDO.getGenericName());
                medicineLiverSuspectedDrugDetailDTO.setTradeName(medicineLiverSuspectedDrugDetailDO.getTradeName());
                medicineLiverSuspectedDrugDetailDTO.setDrugClassification(medicineLiverSuspectedDrugDetailDO.getDrugClassification());
                medicineLiverSuspectedDrugDetailDTO.setManufactor(medicineLiverSuspectedDrugDetailDO.getManufactor());
                medicineLiverSuspectedDrugDetailDTO.setMedicineLiverSuspectedDrugId(medicineLiverSuspectedDrugDetailDO.getMedicineLiverSuspectedDrugDO().getId());
                medicineLiverSuspectedDrugDetailDTOS.add(medicineLiverSuspectedDrugDetailDTO);
            }
        }

        if (mlProprietaryChineseMedicineDOS != null && !mlProprietaryChineseMedicineDOS.isEmpty()) {
            for (MlProprietaryChineseMedicineDO mlProprietaryChineseMedicineDO : mlProprietaryChineseMedicineDOS) {
                MlProprietaryChineseMedicineDTO mlProprietaryChineseMedicineDTO = new MlProprietaryChineseMedicineDTO();
                mlProprietaryChineseMedicineDTO.setId(mlProprietaryChineseMedicineDO.getId());
                mlProprietaryChineseMedicineDTO.setConstitute(mlProprietaryChineseMedicineDO.getConstitute());
                mlProprietaryChineseMedicineDTO.setProManufactor(mlProprietaryChineseMedicineDO.getManufactor());
                mlProprietaryChineseMedicineDTO.setMlDrugId(mlProprietaryChineseMedicineDO.getMlSuspectedDrugDO().getId());
                mlProprietaryChineseMedicineDTO.setProBeginTime(mlProprietaryChineseMedicineDO.getProBeginTime());
                mlProprietaryChineseMedicineDTO.setProDose(mlProprietaryChineseMedicineDO.getProDose());
                mlProprietaryChineseMedicineDTO.setProEndTime(mlProprietaryChineseMedicineDO.getProEndTime());
                mlProprietaryChineseMedicineDTO.setProName(mlProprietaryChineseMedicineDO.getProName());
                mlProprietaryChineseMedicineDTO.setSuspendConstitute(mlProprietaryChineseMedicineDO.getSuspendConstitute());
                mlProprietaryChineseMedicineDTO.setProCategory(mlProprietaryChineseMedicineDO.getProCategory());
                mlProprietaryChineseMedicineDTOS.add(mlProprietaryChineseMedicineDTO);
            }
        }

        if (mlChineseHerbalMedicineDOS != null && !mlChineseHerbalMedicineDOS.isEmpty()) {
            for (MlChineseHerbalMedicineDO mlChineseHerbalMedicineDO : mlChineseHerbalMedicineDOS) {
                MlChineseHerbalMedicineDTO mlChineseHerbalMedicineDTO = new MlChineseHerbalMedicineDTO();
                mlChineseHerbalMedicineDTO.setBuyFrom(mlChineseHerbalMedicineDO.getBuyFrom());
                mlChineseHerbalMedicineDTO.setHerbalCategory(mlChineseHerbalMedicineDO.getHerbalCategory());
                mlChineseHerbalMedicineDTO.setHerbalBeginTime(mlChineseHerbalMedicineDO.getHerbalBeginTime());
                mlChineseHerbalMedicineDTO.setHerbalDose(mlChineseHerbalMedicineDO.getHerbalDose());
                mlChineseHerbalMedicineDTO.setHerbalEndTime(mlChineseHerbalMedicineDO.getHerbalEndTime());
                mlChineseHerbalMedicineDTO.setHerbalName(mlChineseHerbalMedicineDO.getHerbalName());
                mlChineseHerbalMedicineDTO.setId(mlChineseHerbalMedicineDO.getId());
                mlChineseHerbalMedicineDTO.setMlDrugId(mlChineseHerbalMedicineDO.getMlSuspectedDrugDO().getId());
                mlChineseHerbalMedicineDTOS.add(mlChineseHerbalMedicineDTO);
            }
        }

        if (mlSuspendChineseMedicineDOS != null && !mlSuspendChineseMedicineDOS.isEmpty()) {
            for (MlSuspendChineseMedicineDO mlSuspendChineseMedicineDO : mlSuspendChineseMedicineDOS) {
                MlSuspendChineseMedicineDTO mlSuspendChineseMedicineDTO = new MlSuspendChineseMedicineDTO();
                mlSuspendChineseMedicineDTO.setId(mlSuspendChineseMedicineDO.getId());
                mlSuspendChineseMedicineDTO.setSusCategory(mlSuspendChineseMedicineDO.getSusCategory());
                mlSuspendChineseMedicineDTO.setMlDrugId(mlSuspendChineseMedicineDO.getMlSuspectedDrugDO().getId());
                mlSuspendChineseMedicineDTO.setSample(mlSuspendChineseMedicineDO.getSample());
                mlSuspendChineseMedicineDTO.setSusName(mlSuspendChineseMedicineDO.getSusName());
                mlSuspendChineseMedicineDTO.setNumber(mlSuspendChineseMedicineDO.getNumber());
                mlSuspendChineseMedicineDTOS.add(mlSuspendChineseMedicineDTO);
            }
        }

        medicineLiverSuspectedDrugDTO.setMedicineLiverSuspectedDrugDetailDTOS(medicineLiverSuspectedDrugDetailDTOS);
        medicineLiverSuspectedDrugDTO.setMlProprietaryChineseMedicineDTOS(mlProprietaryChineseMedicineDTOS);
        medicineLiverSuspectedDrugDTO.setMlChineseHerbalMedicineDTOS(mlChineseHerbalMedicineDTOS);
        medicineLiverSuspectedDrugDTO.setMlSuspendChineseMedicineDTOS(mlSuspendChineseMedicineDTOS);
        return medicineLiverSuspectedDrugDTO;
    }

    private MedicineLiverSuspectedDrugDO convertToEntity(MedicineLiverSuspectedDrugDTO medicineLiverSuspectedDrugDTO) {
        MedicineLiverSuspectedDrugDO medicineLiverSuspectedDrugDO = new MedicineLiverSuspectedDrugDO();
        medicineLiverSuspectedDrugDO.setComplete(medicineLiverSuspectedDrugDTO.isComplete());
        medicineLiverSuspectedDrugDO.setPatientId(medicineLiverSuspectedDrugDTO.getPatientId());

        List<MedicineLiverSuspectedDrugDetailDO> medicineLiverSuspectedDrugDetailDOS = new ArrayList<>();
        List<MlProprietaryChineseMedicineDO> mlProprietaryChineseMedicineDOS = new ArrayList<>();
        List<MlChineseHerbalMedicineDO> mlChineseHerbalMedicineDOS = new ArrayList<>();
        List<MlSuspendChineseMedicineDO> mlSuspendChineseMedicineDOS = new ArrayList<>();

        List<MedicineLiverSuspectedDrugDetailDTO> medicineLiverSuspectedDrugDetailDTOS = medicineLiverSuspectedDrugDTO.getMedicineLiverSuspectedDrugDetailDTOS();
        List<MlProprietaryChineseMedicineDTO> mlProprietaryChineseMedicineDTOS = medicineLiverSuspectedDrugDTO.getMlProprietaryChineseMedicineDTOS();
        List<MlChineseHerbalMedicineDTO> mlChineseHerbalMedicineDTOS = medicineLiverSuspectedDrugDTO.getMlChineseHerbalMedicineDTOS();
        List<MlSuspendChineseMedicineDTO> mlSuspendChineseMedicineDTOS = medicineLiverSuspectedDrugDTO.getMlSuspendChineseMedicineDTOS();

        if (medicineLiverSuspectedDrugDTO.getId() != 0) {
            mlDrinkDetailRepo.deleteDrinkDetailByDId(medicineLiverSuspectedDrugDTO.getId());
            mlProChineseMedicineRepo.deleteProChineseById(medicineLiverSuspectedDrugDTO.getId());
            mlHerbalRepo.deleteHerbalChineseById(medicineLiverSuspectedDrugDTO.getId());
            mlSuspendChineseRepo.deleteSusChineseById(medicineLiverSuspectedDrugDTO.getId());
        }

        if (medicineLiverSuspectedDrugDetailDTOS != null && !medicineLiverSuspectedDrugDetailDTOS.isEmpty()) {
            for (MedicineLiverSuspectedDrugDetailDTO medicineLiverSuspectedDrugDetailDTO : medicineLiverSuspectedDrugDetailDTOS) {
                MedicineLiverSuspectedDrugDetailDO medicineLiverSuspectedDrugDetailDO = new MedicineLiverSuspectedDrugDetailDO();
                medicineLiverSuspectedDrugDetailDO.setMedicationMethod(medicineLiverSuspectedDrugDetailDTO.getMedicationMethod());
                medicineLiverSuspectedDrugDetailDO.setExposureLiverDamage(medicineLiverSuspectedDrugDetailDTO.getExposureLiverDamage());
                medicineLiverSuspectedDrugDetailDO.setBeginDate(medicineLiverSuspectedDrugDetailDTO.getBeginDate());
                medicineLiverSuspectedDrugDetailDO.setDecrement(medicineLiverSuspectedDrugDetailDTO.getDecrement());
                medicineLiverSuspectedDrugDetailDO.setDose(medicineLiverSuspectedDrugDetailDTO.getDose());
                medicineLiverSuspectedDrugDetailDO.setDrugExposure(medicineLiverSuspectedDrugDetailDTO.getDrugExposure());
                medicineLiverSuspectedDrugDetailDO.setDrugWithDrawal(medicineLiverSuspectedDrugDetailDTO.getDrugWithDrawal());
                medicineLiverSuspectedDrugDetailDO.setDrugWithDrawalDate(medicineLiverSuspectedDrugDetailDTO.getDrugWithDrawalDate());
                medicineLiverSuspectedDrugDetailDO.setGenericName(medicineLiverSuspectedDrugDetailDTO.getGenericName());
                medicineLiverSuspectedDrugDetailDO.setTradeName(medicineLiverSuspectedDrugDetailDTO.getTradeName());
                medicineLiverSuspectedDrugDetailDO.setDrugClassification(medicineLiverSuspectedDrugDetailDTO.getDrugClassification());
                medicineLiverSuspectedDrugDetailDO.setMedicineLiverSuspectedDrugDO(medicineLiverSuspectedDrugDO);
                medicineLiverSuspectedDrugDetailDO.setManufactor(medicineLiverSuspectedDrugDetailDTO.getManufactor());
                medicineLiverSuspectedDrugDetailDOS.add(medicineLiverSuspectedDrugDetailDO);
            }
        }

        if (mlProprietaryChineseMedicineDTOS != null && !mlProprietaryChineseMedicineDTOS.isEmpty()) {
            for (MlProprietaryChineseMedicineDTO mlProprietaryChineseMedicineDTO : mlProprietaryChineseMedicineDTOS) {
                MlProprietaryChineseMedicineDO mlProprietaryChineseMedicineDO = new MlProprietaryChineseMedicineDO();
                mlProprietaryChineseMedicineDO.setConstitute(mlProprietaryChineseMedicineDTO.getConstitute());
                mlProprietaryChineseMedicineDO.setManufactor(mlProprietaryChineseMedicineDTO.getProManufactor());
                mlProprietaryChineseMedicineDO.setMlSuspectedDrugDO(medicineLiverSuspectedDrugDO);
                mlProprietaryChineseMedicineDO.setProBeginTime(mlProprietaryChineseMedicineDTO.getProBeginTime());
                mlProprietaryChineseMedicineDO.setProDose(mlProprietaryChineseMedicineDTO.getProDose());
                mlProprietaryChineseMedicineDO.setProEndTime(mlProprietaryChineseMedicineDTO.getProEndTime());
                mlProprietaryChineseMedicineDO.setProName(mlProprietaryChineseMedicineDTO.getProName());
                mlProprietaryChineseMedicineDO.setSuspendConstitute(mlProprietaryChineseMedicineDTO.getSuspendConstitute());
                mlProprietaryChineseMedicineDO.setProCategory(mlProprietaryChineseMedicineDTO.getProCategory());
                mlProprietaryChineseMedicineDOS.add(mlProprietaryChineseMedicineDO);
            }
        }

        if (mlChineseHerbalMedicineDTOS != null && !mlChineseHerbalMedicineDTOS.isEmpty()) {
            for (MlChineseHerbalMedicineDTO mlChineseHerbalMedicineDTO : mlChineseHerbalMedicineDTOS) {
                MlChineseHerbalMedicineDO mlChineseHerbalMedicineDO = new MlChineseHerbalMedicineDO();
                mlChineseHerbalMedicineDO.setMlSuspectedDrugDO(medicineLiverSuspectedDrugDO);
                mlChineseHerbalMedicineDO.setBuyFrom(mlChineseHerbalMedicineDTO.getBuyFrom());
                mlChineseHerbalMedicineDO.setHerbalBeginTime(mlChineseHerbalMedicineDTO.getHerbalBeginTime());
                mlChineseHerbalMedicineDO.setHerbalDose(mlChineseHerbalMedicineDTO.getHerbalDose());
                mlChineseHerbalMedicineDO.setHerbalEndTime(mlChineseHerbalMedicineDTO.getHerbalEndTime());
                mlChineseHerbalMedicineDO.setHerbalName(mlChineseHerbalMedicineDTO.getHerbalName());
                mlChineseHerbalMedicineDO.setHerbalCategory(mlChineseHerbalMedicineDTO.getHerbalCategory());
                mlChineseHerbalMedicineDOS.add(mlChineseHerbalMedicineDO);
            }
        }

        if (mlSuspendChineseMedicineDTOS != null && !mlSuspendChineseMedicineDTOS.isEmpty()) {
            for (MlSuspendChineseMedicineDTO mlSuspendChineseMedicineDTO : mlSuspendChineseMedicineDTOS) {
                MlSuspendChineseMedicineDO mlSuspendChineseMedicineDO = new MlSuspendChineseMedicineDO();
                mlSuspendChineseMedicineDO.setMlSuspectedDrugDO(medicineLiverSuspectedDrugDO);
                mlSuspendChineseMedicineDO.setSample(mlSuspendChineseMedicineDTO.getSample());
                mlSuspendChineseMedicineDO.setSusName(mlSuspendChineseMedicineDTO.getSusName());
                mlSuspendChineseMedicineDO.setNumber(mlSuspendChineseMedicineDTO.getNumber());
                mlSuspendChineseMedicineDO.setSusCategory(mlSuspendChineseMedicineDTO.getSusCategory());
                mlSuspendChineseMedicineDOS.add(mlSuspendChineseMedicineDO);
            }
        }

        medicineLiverSuspectedDrugDO.setMlProprietaryChineseMedicineDOS(mlProprietaryChineseMedicineDOS);
        medicineLiverSuspectedDrugDO.setMlChineseHerbalMedicineDOS(mlChineseHerbalMedicineDOS);
        medicineLiverSuspectedDrugDO.setMlSuspendChineseMedicineDOS(mlSuspendChineseMedicineDOS);
        medicineLiverSuspectedDrugDO.setMedicineLiverSuspectedDrugDetailDOS(medicineLiverSuspectedDrugDetailDOS);
        return medicineLiverSuspectedDrugDO;
    }

    @Override
    public void saveDrugHistory(MedicineLiverSuspectedDrugDTO medicineLiverSuspectedDrugDTO) {
        mlDrugHistoryRepo.save(convertToEntity(medicineLiverSuspectedDrugDTO));
    }

    @Override
    public MedicineLiverSuspectedDrugDTO getDrugByPatientId(int mlPatientId) {
        return mlDrugHistoryRepo.getMlDrugByPatientId(mlPatientId) != null ? convertToDTO(mlDrugHistoryRepo.getMlDrugByPatientId(mlPatientId)) : null;
    }

    @Override
    public Boolean getCompleteByPatient(int mlPatientId) {
        return mlDrugHistoryRepo.getCompleteByPatientId(mlPatientId);
    }
}
