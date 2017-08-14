package app.serviceImpl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

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

    private TreatmentProgramsDTO convertToDto(TreatmentProgramsDO treatmentProgramsDO) {
        TreatmentProgramsDTO treatmentProgramsDTO = new TreatmentProgramsDTO();
        treatmentProgramsDTO.setBdndDose(treatmentProgramsDO.getBdndDose());
        treatmentProgramsDTO.setBdndHeal(treatmentProgramsDO.getBdndHeal());
        treatmentProgramsDTO.setBdndTime(treatmentProgramsDO.getBdndTime());
        treatmentProgramsDTO.setComplete(treatmentProgramsDO.isComplete());
        treatmentProgramsDTO.setCtxDose(treatmentProgramsDO.getCtxDose());
        treatmentProgramsDTO.setCtxHeal(treatmentProgramsDO.getCtxHeal());
        treatmentProgramsDTO.setCtxTime(treatmentProgramsDO.getCtxTime());
        treatmentProgramsDTO.setCysaDose(treatmentProgramsDO.getCysaDose());
        treatmentProgramsDTO.setCysaHeal(treatmentProgramsDO.getCysaHeal());
        treatmentProgramsDTO.setCysaTime(treatmentProgramsDO.getCysaTime());
        treatmentProgramsDTO.setFnbtDose(treatmentProgramsDO.getFnbtDose());
        treatmentProgramsDTO.setFnbtHeal(treatmentProgramsDO.getFnbtHeal());
        treatmentProgramsDTO.setFnbtTime(treatmentProgramsDO.getFnbtTime());
        treatmentProgramsDTO.setFollowUp(treatmentProgramsDO.isFollowUp());
        treatmentProgramsDTO.setFollowUpDate(treatmentProgramsDO.getFollowUpDate());
        treatmentProgramsDTO.setGyzDetails(treatmentProgramsDO.getGyzDetails());
        treatmentProgramsDTO.setGyzReason(treatmentProgramsDO.getGyzReason());
        treatmentProgramsDTO.setGyzResult(treatmentProgramsDO.getGyzResult());
        treatmentProgramsDTO.setGyzTime(treatmentProgramsDO.getGyzTime());
        treatmentProgramsDTO.setId(treatmentProgramsDO.getId());
        treatmentProgramsDTO.setJjqDose(treatmentProgramsDO.getJjqDose());
        treatmentProgramsDTO.setJjqHeal(treatmentProgramsDO.getJjqHeal());
        treatmentProgramsDTO.setJjqTime(treatmentProgramsDO.getJjqTime());
        treatmentProgramsDTO.setLcplDose(treatmentProgramsDO.getLcplDose());
        treatmentProgramsDTO.setLcplHeal(treatmentProgramsDO.getLcplHeal());
        treatmentProgramsDTO.setLcplTime(treatmentProgramsDO.getLcplTime());
        treatmentProgramsDTO.setMtmkDose(treatmentProgramsDO.getMtmkDose());
        treatmentProgramsDTO.setMtmkHeal(treatmentProgramsDO.getMtxHeal());
        treatmentProgramsDTO.setMtmkTime(treatmentProgramsDO.getMtmkTime());
        treatmentProgramsDTO.setMtxTime(treatmentProgramsDO.getMtxTime());
        treatmentProgramsDTO.setMtxDose(treatmentProgramsDO.getMtxDose());
        treatmentProgramsDTO.setMtxHeal(treatmentProgramsDO.getMtxHeal());
        treatmentProgramsDTO.setPatientId(treatmentProgramsDO.getPatientId());
        treatmentProgramsDTO.setQdsDose(treatmentProgramsDO.getQdsDose());
        treatmentProgramsDTO.setQdsHeal(treatmentProgramsDO.getQdsHeal());
        treatmentProgramsDTO.setQdsTime(treatmentProgramsDO.getQdsTime());
        treatmentProgramsDTO.setQdslDose(treatmentProgramsDO.getQdslDose());
        treatmentProgramsDTO.setQdslHeal(treatmentProgramsDO.getQdslHeal());
        treatmentProgramsDTO.setQdslTime(treatmentProgramsDO.getQdslTime());
        treatmentProgramsDTO.setQsxsDose(treatmentProgramsDO.getQsxsDose());
        treatmentProgramsDTO.setQsxsHeal(treatmentProgramsDO.getQsxsHeal());
        treatmentProgramsDTO.setQsxsTime(treatmentProgramsDO.getQsxsTime());
        treatmentProgramsDTO.setXqydDose(treatmentProgramsDO.getXqydDose());
        treatmentProgramsDTO.setXqydHeal(treatmentProgramsDO.getXqydHeal());
        treatmentProgramsDTO.setXqydTime(treatmentProgramsDO.getXqydTime());
        treatmentProgramsDTO.setBzbtTime(treatmentProgramsDO.getBzbtTime());
        treatmentProgramsDTO.setBzbtDose(treatmentProgramsDO.getBzbtDose());
        treatmentProgramsDTO.setBzbtHeal(treatmentProgramsDO.getBzbtHeal());
        return treatmentProgramsDTO;
    }

    private TreatmentProgramsDO convertToEntity(TreatmentProgramsDTO treatmentProgramsDTO) {
        TreatmentProgramsDO treatmentProgramsDO = new TreatmentProgramsDO();
        treatmentProgramsDO.setBdndDose(treatmentProgramsDTO.getBdndDose());
        treatmentProgramsDO.setBdndHeal(treatmentProgramsDTO.getBdndHeal());
        treatmentProgramsDO.setBdndTime(treatmentProgramsDTO.getBdndTime());
        treatmentProgramsDO.setComplete(treatmentProgramsDTO.isComplete());
        treatmentProgramsDO.setCtxDose(treatmentProgramsDTO.getCtxDose());
        treatmentProgramsDO.setCtxHeal(treatmentProgramsDTO.getCtxHeal());
        treatmentProgramsDO.setCtxTime(treatmentProgramsDTO.getCtxTime());
        treatmentProgramsDO.setCysaDose(treatmentProgramsDTO.getCysaDose());
        treatmentProgramsDO.setCysaHeal(treatmentProgramsDTO.getCysaHeal());
        treatmentProgramsDO.setCysaTime(treatmentProgramsDTO.getCysaTime());
        treatmentProgramsDO.setFnbtDose(treatmentProgramsDTO.getFnbtDose());
        treatmentProgramsDO.setFnbtHeal(treatmentProgramsDTO.getFnbtHeal());
        treatmentProgramsDO.setFnbtTime(treatmentProgramsDTO.getFnbtTime());
        treatmentProgramsDO.setFollowUp(treatmentProgramsDTO.isFollowUp());
        treatmentProgramsDO.setFollowUpDate(treatmentProgramsDTO.getFollowUpDate());
        treatmentProgramsDO.setGyzDetails(treatmentProgramsDTO.getGyzDetails());
        treatmentProgramsDO.setGyzReason(treatmentProgramsDTO.getGyzReason());
        treatmentProgramsDO.setGyzResult(treatmentProgramsDTO.getGyzResult());
        treatmentProgramsDO.setGyzTime(treatmentProgramsDTO.getGyzTime());
        treatmentProgramsDO.setJjqDose(treatmentProgramsDTO.getJjqDose());
        treatmentProgramsDO.setJjqHeal(treatmentProgramsDTO.getJjqHeal());
        treatmentProgramsDO.setJjqTime(treatmentProgramsDTO.getJjqTime());
        treatmentProgramsDO.setLcplDose(treatmentProgramsDTO.getLcplDose());
        treatmentProgramsDO.setLcplHeal(treatmentProgramsDTO.getLcplHeal());
        treatmentProgramsDO.setLcplTime(treatmentProgramsDTO.getLcplTime());
        treatmentProgramsDO.setMtmkDose(treatmentProgramsDTO.getMtmkDose());
        treatmentProgramsDO.setMtmkHeal(treatmentProgramsDTO.getMtmkHeal());
        treatmentProgramsDO.setMtmkTime(treatmentProgramsDTO.getMtmkTime());
        treatmentProgramsDO.setPatientId(treatmentProgramsDTO.getPatientId());
        treatmentProgramsDO.setQdsDose(treatmentProgramsDTO.getQdsDose());
        treatmentProgramsDO.setQdsHeal(treatmentProgramsDTO.getQdsHeal());
        treatmentProgramsDO.setQdsTime(treatmentProgramsDTO.getQdsTime());
        treatmentProgramsDO.setQdslDose(treatmentProgramsDTO.getQdslDose());
        treatmentProgramsDO.setQdslHeal(treatmentProgramsDTO.getQdslHeal());
        treatmentProgramsDO.setQdslTime(treatmentProgramsDTO.getQdslTime());
        treatmentProgramsDO.setQsxsDose(treatmentProgramsDTO.getQsxsDose());
        treatmentProgramsDO.setQsxsHeal(treatmentProgramsDTO.getQsxsHeal());
        treatmentProgramsDO.setQsxsTime(treatmentProgramsDTO.getQsxsTime());
        treatmentProgramsDO.setXqydDose(treatmentProgramsDTO.getXqydDose());
        treatmentProgramsDO.setXqydHeal(treatmentProgramsDTO.getXqydHeal());
        treatmentProgramsDO.setXqydTime(treatmentProgramsDTO.getXqydTime());
        treatmentProgramsDO.setBzbtTime(treatmentProgramsDTO.getBzbtTime());
        treatmentProgramsDO.setBzbtDose(treatmentProgramsDTO.getBzbtDose());
        treatmentProgramsDO.setBzbtHeal(treatmentProgramsDTO.getBzbtHeal());
        treatmentProgramsDO.setMtxTime(treatmentProgramsDTO.getMtxTime());
        treatmentProgramsDO.setMtxDose(treatmentProgramsDTO.getMtxDose());
        treatmentProgramsDO.setMtxHeal(treatmentProgramsDTO.getMtxHeal());
        return treatmentProgramsDO;
    }

    @Override
    public void saveTreatment(TreatmentProgramsDTO treatmentProgramsDTO) {
        treatmentRepo.save(convertToEntity(treatmentProgramsDTO));
    }

    @Override
    public TreatmentProgramsDTO getTreatment(int patientId) {
        if (treatmentRepo.getTreatment(patientId) != null) {
            return convertToDto(treatmentRepo.getTreatment(patientId));
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
    public ArrayList<String> getQdsDate(int patientId) {

//        int weekNum = treatmentRepo.getQdsDate(patientId);
//
//
//        ArrayList<Date> listDate = new ArrayList<>();
        String qds = new String();
        return getStartTime(patientId, "qds");
    }

    /**
     * 得到病人服用指定药物的起始时间
     * @param patientId 病人id
     * @param medicine 用药名称
     * @return
     */
    public ArrayList<String> getStartTime(int patientId, String medicine) {
        String medicineTime = medicine + "_time";
        String startDate;
        int weeks;
        int dosage;
        ArrayList<String> totals = new ArrayList<>();
//        Date startDate = treatmentRepo.getStartTime(patientId ,medicineTime);
        for(int i = 0; i < treatmentRepo.getStartTime(patientId).size(); i++){
            startDate = treatmentRepo.getStartTime(patientId).get(i);
            weeks = treatmentRepo.getQdsWeeks(startDate).get(i);
            dosage = treatmentRepo.getQdsDosage(startDate).get(i);
            totals.addAll(getTotalDate(startDate.split(" ")[0], weeks, dosage));
        }
        return totals;
    }

    /**
     * 返回一个String列表，包含从头到尾的每天的日期。
     * parameters startDate(其实日期)、weeks(治疗周数)
     */
    public ArrayList<String> getTotalDate(String startDate ,int weeks, int dosage){
        ArrayList<String> totalDate = new ArrayList<>();

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal = Calendar.getInstance();
        try {
            cal.setTime(sdf.parse(startDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for(int i = 1; i <= weeks * 7; i++) {
            cal.add(Calendar.DATE, 1);
            System.out.println(sdf.format(cal.getTime()));
            totalDate.add(sdf.format(cal.getTime()) + "$" + dosage);
        }
        System.out.println(totalDate.toString());
        return totalDate;
    }
}