package app.serviceImpl;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import app.Utils.ConvertUtil;
import app.Utils.GetAllDateTool;
import app.Utils.GetColumnContentByColumn;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.dto.TreatmentProgramsDTO;
import app.entities.TreatmentProgramsDO;
import app.repo.TreatmentRepo;
import app.service.TreatmentService;

@Service
public class TreatmentServiceImpl implements TreatmentService {

    @Autowired
    private TreatmentRepo treatmentRepo;

    @Autowired
    private GetAllDateTool getAllDateTool;

    @Autowired
    private ConvertUtil convertUtil;

    @Autowired
    private GetColumnContentByColumn getColumnContentByColumn;

    @Override
    public void saveTreatment(TreatmentProgramsDTO treatmentProgramsDTO) {
        treatmentRepo.save(convertUtil.tpDTOconvertToTpEntity(treatmentProgramsDTO));
    }

    @Override
    public TreatmentProgramsDTO getTreatment(int patientId) {
        if (treatmentRepo.getTreatment(patientId) != null) {
            return convertUtil.tpDOconvertToTpDto(treatmentRepo.getTreatment(patientId));
        } else {
            return null;
        }
    }

    @Override
    public List<Float> getQdsDose(int patientId) {
        return treatmentRepo.getQdsDose(patientId);
    }

    @Override
    public List<Float> getQdslDose(int patientId) {
        return treatmentRepo.getQdslDose(patientId);
    }

    @Override
    public List<Float> getJjqDose(int patientId) {
        return treatmentRepo.getJjqDose(patientId);
    }

    @Override
    public List<Float> getBdndDose(int patientId) {
        return treatmentRepo.getBdndDose(patientId);
    }

    @Override
    public List<Float> getLcplDose(int patientId) {
        return treatmentRepo.getLcplDose(patientId);
    }

    @Override
    public List<Float> getMtxDose(int patientId) {
        return treatmentRepo.getMtxDose(patientId);
    }

    @Override
    public List<Float> getCysaDose(int patientId) {
        return treatmentRepo.getCysaDose(patientId);
    }

    @Override
    public List<Float> getCtxDose(int patientId) {
        return treatmentRepo.getCtxDose(patientId);
    }

    @Override
    public List<Float> getMtmkDose(int patientId) {
        return treatmentRepo.getMtmkDose(patientId);
    }

    @Override
    public List<Float> getQsxsDose(int patientId) {
        return treatmentRepo.getQsxsDose(patientId);
    }

    @Override
    public List<Float> getXqydDose(int patientId) {
        return treatmentRepo.getXqydDose(patientId);
    }

    @Override
    public List<Float> getFnbtDose(int patientId) {
        return treatmentRepo.getFnbtDose(patientId);
    }

    @Override
    public List<Float> getBzbtDose(int patientId) {
        return treatmentRepo.getBzbtDose(patientId);
    }

    @Override
    public boolean getCompleteByPatientId(int patientId) {
        try {
            return treatmentRepo.getCompleteByPatientId(patientId);
        } catch (Exception e) {
            return false;
        }
    }

    @Override
    public List<TreatmentProgramsDTO> getFollowTreat(int patientId) {
        if (!treatmentRepo.getFollowTreat(patientId).isEmpty()) {
            List<TreatmentProgramsDTO> treatmentProgramsDTOs = new ArrayList<>();
            List<TreatmentProgramsDO> treatmentProgramsDOs =
                    treatmentRepo.getFollowTreat(patientId);
            for (TreatmentProgramsDO treatmentProgramsDO : treatmentProgramsDOs) {
                treatmentProgramsDTOs.add(convertUtil.tpDOconvertToTpDto(treatmentProgramsDO));
            }
            return treatmentProgramsDTOs;
        } else {
            return null;
        }
    }

    @Override
    public TreatmentProgramsDTO getDefaultTreat(int patientId) {
        return treatmentRepo.getDefaultTreat(patientId) != null
                ? convertUtil.tpDOconvertToTpDto(treatmentRepo.getDefaultTreat(patientId)) : null;
    }

    @Override
    public ArrayList<String> getQdsDate(int patientId) {
        return getStartTime(patientId, "qds");
    }

    @Override
    public TreatmentProgramsDTO getSingleFollowById(int id) {
        return null;
    }

    @Override
    public void updateTreat(TreatmentProgramsDTO treatmentProgramsDTO) {

    }

    /**
     * 得到病人服用指定药物的起始时间
     * @param patientId 病人id
     * @param medicine 用药名称
     * @return
     */
    public ArrayList<String> getStartTime(int patientId, String medicine) {
        String medicineTime = medicine + "_time";
        String medicineHeal = medicine + "_heal";
        String medicineName = medicine + "_dose";
        String startDate;
        int weeks;
        float dosage;
        ArrayList<String> totals = new ArrayList<>();
//         Date startDate = treatmentRepo.getStartTime(patientId ,medicineTime);
//        for (int i = 0; i < treatmentRepo.getStartTime(patientId).size(); i++) {
//            startDate = treatmentRepo.getStartTime(patientId).get(i);
//            weeks = treatmentRepo.getQdsWeeks(startDate).get(i);
//            dosage = treatmentRepo.getQdsDosage(startDate).get(i);
//            totals.addAll(getAllDateTool.getTotalDate(startDate.split(" ")[0], weeks, dosage));
//        }
        startDate = getColumnContentByColumn.getStartTime(patientId, medicineTime);
        weeks = getColumnContentByColumn.getQdsWeeks(startDate, medicineTime, medicineHeal);
        dosage = getColumnContentByColumn.getQdsDosage(startDate, medicineName, medicineTime);
        totals.addAll(getAllDateTool.getTotalDate(startDate.split(" ")[0], weeks, dosage));
        return totals;
    }

}
