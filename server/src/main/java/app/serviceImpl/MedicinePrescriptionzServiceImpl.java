package app.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.ChineseMedicinePrescriptionDTO;
import app.entities.ChineseMedicinePrescriptionDO;
import app.repo.MedicinePrescriptionRepo;
import app.service.MedicinePrescriptionService;

@Service
public class MedicinePrescriptionzServiceImpl implements MedicinePrescriptionService {

    @Autowired
    private MedicinePrescriptionRepo medicinePrescriptionRepo;

    private ChineseMedicinePrescriptionDTO convertToDto(
            ChineseMedicinePrescriptionDO chineseMedicinePrescriptionDO) {
        ChineseMedicinePrescriptionDTO chineseMedicinePrescriptionDTO =
                new ChineseMedicinePrescriptionDTO();
        chineseMedicinePrescriptionDTO.setComplete(chineseMedicinePrescriptionDO.isComplete());
        chineseMedicinePrescriptionDTO.setFollowUp(chineseMedicinePrescriptionDO.isFollowUp());
        chineseMedicinePrescriptionDTO
                .setFollowUpDate(chineseMedicinePrescriptionDO.getFollowUpDate());
        chineseMedicinePrescriptionDTO.setId(chineseMedicinePrescriptionDO.getId());
        chineseMedicinePrescriptionDTO.setPatientId(chineseMedicinePrescriptionDO.getPatientId());
        chineseMedicinePrescriptionDTO.setaProprietaryMedicineHeal(
                chineseMedicinePrescriptionDO.getaProprietaryMedicineHeal());
        chineseMedicinePrescriptionDTO.setaProprietaryMedicineName(
                chineseMedicinePrescriptionDO.getaProprietaryMedicineName());
        chineseMedicinePrescriptionDTO.setaProprietaryMedicineTime(
                chineseMedicinePrescriptionDO.getaProprietaryMedicineTime());
        chineseMedicinePrescriptionDTO.setbProprietaryMedicineHeal(
                chineseMedicinePrescriptionDO.getbProprietaryMedicineHeal());
        chineseMedicinePrescriptionDTO.setbProprietaryMedicineName(
                chineseMedicinePrescriptionDO.getbProprietaryMedicineName());
        chineseMedicinePrescriptionDTO.setbProprietaryMedicineTime(
                chineseMedicinePrescriptionDO.getbProprietaryMedicineTime());
        chineseMedicinePrescriptionDTO.setChineseMedicineFormulasDose(
                chineseMedicinePrescriptionDO.getChineseMedicineFormulasDose());
        chineseMedicinePrescriptionDTO
                .setChineseMedicineHeal(chineseMedicinePrescriptionDO.getChineseMedicineHeal());
        chineseMedicinePrescriptionDTO
                .setChineseMedicineTime(chineseMedicinePrescriptionDO.getChineseMedicineTime());
        return chineseMedicinePrescriptionDTO;
    }

    private ChineseMedicinePrescriptionDO convertToEntity(
            ChineseMedicinePrescriptionDTO chineseMedicinePrescriptionDTO) {
        ChineseMedicinePrescriptionDO chineseMedicinePrescriptionDO =
                new ChineseMedicinePrescriptionDO();
        chineseMedicinePrescriptionDO.setComplete(chineseMedicinePrescriptionDTO.isComplete());
        chineseMedicinePrescriptionDO.setFollowUp(chineseMedicinePrescriptionDTO.isFollowUp());
        chineseMedicinePrescriptionDO
                .setFollowUpDate(chineseMedicinePrescriptionDTO.getFollowUpDate());
        chineseMedicinePrescriptionDO.setPatientId(chineseMedicinePrescriptionDTO.getPatientId());
        chineseMedicinePrescriptionDO.setaProprietaryMedicineHeal(
                chineseMedicinePrescriptionDTO.getaProprietaryMedicineHeal());
        chineseMedicinePrescriptionDO.setaProprietaryMedicineName(
                chineseMedicinePrescriptionDTO.getaProprietaryMedicineName());
        chineseMedicinePrescriptionDO.setaProprietaryMedicineTime(
                chineseMedicinePrescriptionDTO.getaProprietaryMedicineTime());
        chineseMedicinePrescriptionDO.setbProprietaryMedicineHeal(
                chineseMedicinePrescriptionDTO.getbProprietaryMedicineHeal());
        chineseMedicinePrescriptionDO.setbProprietaryMedicineName(
                chineseMedicinePrescriptionDTO.getbProprietaryMedicineName());
        chineseMedicinePrescriptionDO.setbProprietaryMedicineTime(
                chineseMedicinePrescriptionDTO.getbProprietaryMedicineTime());
        chineseMedicinePrescriptionDO.setChineseMedicineFormulasDose(
                chineseMedicinePrescriptionDTO.getChineseMedicineFormulasDose());
        chineseMedicinePrescriptionDO
                .setChineseMedicineHeal(chineseMedicinePrescriptionDTO.getChineseMedicineHeal());
        chineseMedicinePrescriptionDO
                .setChineseMedicineTime(chineseMedicinePrescriptionDTO.getChineseMedicineTime());
        return chineseMedicinePrescriptionDO;
    }

    @Override
    public void saveMedicinePrescription(
            ChineseMedicinePrescriptionDTO chineseMedicinePrescriptionDTO) {
        medicinePrescriptionRepo.save(convertToEntity(chineseMedicinePrescriptionDTO));
    }

    @Override
    public ChineseMedicinePrescriptionDTO getMedicinePrescription(int patientId) {
        if (medicinePrescriptionRepo.getMedicinePrescription(patientId) != null) {
            return convertToDto(medicinePrescriptionRepo.getMedicinePrescription(patientId));
        } else {
            return null;
        }
    }

    @Override
    public boolean getCompleteByPatientId(int patientId) {
//        try {
//            return medicinePrescriptionRepo.getCompleteByPatientId(patientId);
//        } catch (Exception e) {
//            return false;
//        }
        return medicinePrescriptionRepo.getCompleteByPatientId(patientId)!=null?medicinePrescriptionRepo.getCompleteByPatientId(patientId):false;
    }

    @Override
    public List<ChineseMedicinePrescriptionDTO> getFollowMedicine(int patientId) {
        if (!(medicinePrescriptionRepo.getFollowMedicine(patientId)).isEmpty()) {
            List<ChineseMedicinePrescriptionDTO> chineseMedicinePrescriptionDTOs =
                    new ArrayList<>();
            List<ChineseMedicinePrescriptionDO> chineseMedicinePrescriptionDOs =
                    medicinePrescriptionRepo.getFollowMedicine(patientId);
            for (ChineseMedicinePrescriptionDO chineseMedicinePrescriptionDO : chineseMedicinePrescriptionDOs) {
                chineseMedicinePrescriptionDTOs.add(convertToDto(chineseMedicinePrescriptionDO));
            }
            return chineseMedicinePrescriptionDTOs;
        } else {
            return null;
        }
    }

    @Override
    public ChineseMedicinePrescriptionDTO getDefaultMedicine(int patientId) {
        return medicinePrescriptionRepo.getDefaultMedicine(patientId) != null
                ? convertToDto(medicinePrescriptionRepo.getDefaultMedicine(patientId)) : null;
    }

    @Override
    public ChineseMedicinePrescriptionDTO getFollowChineseByDate(String date) {
        return medicinePrescriptionRepo.getFollowChineseByDate(date)!=null?convertToDto(medicinePrescriptionRepo.getFollowChineseByDate(date)):null;
    }

}
