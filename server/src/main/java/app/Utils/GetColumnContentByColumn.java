package app.Utils;

import app.entities.MedicineLiverFirstAbnormalExaminationDO;
import app.repo.FirstAbnormalExaminationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by 10210 on 2017/8/21.
 */
@Service
public class GetColumnContentByColumn {

    @PersistenceUnit
    private EntityManagerFactory emf;

    @Autowired
    private GetAllDateTool getAllDateTool;

    public List<Float> getColumnContentByColumn(int patientId, String columnName) {
        EntityManager em = emf.createEntityManager();
        String sql = "select " + columnName + " from treatment_programs where patient_id=" + patientId + " order by id limit 7;";
        List<Float> result = em.createQuery(sql).getResultList();
        return result;
    }

    /**
     *根据病人id和字段名，来查找所用字段名的药的开始时间
     * @param patientId
     * @param columnTime
     * @return
     */
    public List<String> getStartTime(int patientId, String columnTime) {
        List<String> startTimeList = new ArrayList<>();
        List<String> result = new ArrayList<>();
        EntityManager em = emf.createEntityManager();
        String sql ="select " + columnTime + " from treatment_programs where patient_id =" + patientId + " order by id;";

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        startTimeList = em.createNativeQuery(sql).getResultList();
        for(int i = 0; i < startTimeList.size(); i++ ){
            if(startTimeList.get(i) != null){
                try{
                    result.add(df.format(startTimeList.get(i)));
                }catch (Exception e ){
                    e.printStackTrace();
                }
            }
        }
        return result;
    }

    /**
     * 根据病人id和字段名，来查找所用字段名的药总时长（周）。
     * @param patientId
     * @param columnName
     * @return
     */
    public int getQdsDate(int patientId, String columnName) {
        EntityManager em = emf.createEntityManager();
        String sql ="select sum(" + columnName + ") from treatment_programs where patient_id = " + patientId;
        int result = (Integer) em.createNativeQuery(sql).getResultList().get(0);
        return result;
    }

    /**
     *根据开始时间和字段名来查找疗程（周）
     * @param startDate
     * @param columnTime
     * @param medicineHeal
     * @return
     */
    public int getQdsWeeks(String startDate, String columnTime, String medicineHeal) {
        EntityManager em = emf.createEntityManager();
        String sql ="select " + medicineHeal + " from treatment_programs where " + columnTime
                + " = " + "\"" + startDate + "\"";
        int result = (Integer)em.createNativeQuery(sql).getResultList().get(0);
        return result;
    }

    /**
     *得到用药量
     * @param startDate
     * @param columnName
     * @param columnTime
     * @return
     */
    public float getQdsDosage(String startDate, String columnName, String columnTime) {
        EntityManager em = emf.createEntityManager();
        String sql ="select " + columnName + " from treatment_programs where " + columnTime
                + " = " + "\"" + startDate + "\"";
        float result = (float)em.createNativeQuery(sql).getResultList().get(0);
        return result;
    }

    /**
     * 得到病人服用指定药物的起始时间
     * @param patientId 病人id
     * @param medicine 用药名称
     * @return
     */
    public ArrayList<String> getStartTimes(int patientId, String medicine) {
        String medicineTime = medicine + "_time";
        String medicineHeal = medicine + "_heal";
        String medicineName = medicine + "_dose";
        List<String> startDate;
        int weeks;
        float dosage;
        ArrayList<String> totals = new ArrayList<>();
        startDate = getStartTime(patientId, medicineTime);
        for (int i = 0; i < startDate.size(); i++) {
            weeks = getQdsWeeks(startDate.get(i), medicineTime, medicineHeal);
            dosage = getQdsDosage(startDate.get(i), medicineName, medicineTime);
            totals.addAll(getAllDateTool.getTotalDate(startDate.get(i).split(" ")[0], weeks, dosage));
        }
        return totals;
    }

}
