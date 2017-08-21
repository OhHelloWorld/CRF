package app.Utils;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import java.util.List;

/**
 * Created by 10210 on 2017/8/21.
 */
@Service
public class GetColumnContentByColumn {

    @PersistenceUnit
    private EntityManagerFactory emf;

    public List<Float> getColumnContentByColumn(int patientId, String columnName) {
        EntityManager em = emf.createEntityManager();
        String sql = "select " + columnName + " from treatment_programs where patient_id=" + patientId + " order by id limit 7;";
        List<Float> result = em.createQuery(sql).getResultList();
        return result;
    }

    /**
     *根据病人id和字段名，来查找所用字段名的药的开始时间
     * @param patientId
     * @param columnName
     * @return
     */
    public String getStartTime(int patientId, String columnName) {
        EntityManager em = emf.createEntityManager();
        String sql ="select " + columnName + " from treatment_programs where patient_id =" + patientId + " order by id;";
        String result = em.createNativeQuery(sql).getResultList().get(0).toString();
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

    public float getQdsDosage(String startDate, String columnName, String columnTime) {
        EntityManager em = emf.createEntityManager();
        String sql ="select " + columnName + " from treatment_programs where " + columnTime
                + " = " + "\"" + startDate + "\"";
        float result = (float)em.createNativeQuery(sql).getResultList().get(0);
        return result;
    }

}
