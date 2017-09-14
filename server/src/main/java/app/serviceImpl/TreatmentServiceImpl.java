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
    public List<String> getQdsDose(int patientId) {
        return getColumnContentByColumn.getStartTimes(patientId, "qds");
    }

    @Override
    public ArrayList<String> getQdslDose(int patientId) {
        return getColumnContentByColumn.getStartTimes(patientId, "qdsl");
    }

    @Override
    public List<String> getJjqDose(int patientId) {
        return getColumnContentByColumn.getStartTimes(patientId, "jjq");
    }

    @Override
    public List<String> getBdndDose(int patientId) {
        return getColumnContentByColumn.getStartTimes(patientId, "bdnd");
    }

    @Override
    public List<String> getLcplDose(int patientId) {
        return getColumnContentByColumn.getStartTimes(patientId, "lcpl");
    }

    @Override
    public List<String> getMtxDose(int patientId) {
        return getColumnContentByColumn.getStartTimes(patientId, "mtx");
    }

    @Override
    public List<String> getCysaDose(int patientId) {
        return getColumnContentByColumn.getStartTimes(patientId, "cysa");
    }

    @Override
    public List<String> getCtxDose(int patientId) {
        return getColumnContentByColumn.getStartTimes(patientId ,"ctx");
    }

    @Override
    public List<String> getMtmkDose(int patientId) {
        return getColumnContentByColumn.getStartTimes(patientId, "mtmk");
    }

    @Override
    public List<String> getQsxsDose(int patientId) {
        return getColumnContentByColumn.getStartTimes(patientId, "qsxs");
    }

    @Override
    public List<String> getXqydDose(int patientId) {
        return getColumnContentByColumn.getStartTimes(patientId, "xqyd");
    }

    @Override
    public List<String> getFnbtDose(int patientId) {
        return getColumnContentByColumn.getStartTimes(patientId, "fnbt");
    }

    @Override
    public List<String> getBzbtDose(int patientId) {
        return getColumnContentByColumn.getStartTimes(patientId, "bzbt");
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
    public TreatmentProgramsDTO getSingleFollowById(int id) {
        return null;
    }

    @Override
    public void updateTreat(TreatmentProgramsDTO treatmentProgramsDTO) {

    }

    @Override
    public TreatmentProgramsDTO getFollowTreatByDate(String date) {
        return treatmentRepo.getFollowTreatByDate(date)!=null?convertUtil.tpDOconvertToTpDto(treatmentRepo.getFollowTreatByDate(date)):null;
    }

}