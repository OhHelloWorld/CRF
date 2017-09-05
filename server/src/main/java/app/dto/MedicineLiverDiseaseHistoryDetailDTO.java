package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class MedicineLiverDiseaseHistoryDetailDTO {

    private int id;
    private int medicineLiverDiseaseHistoryId;
    private String diseaseName; //疾病名称
    private Date diagnosisDate;//发作/诊断日期
    private Date crueDate;//治愈日期
    private String existence;//是否仍然存在

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMedicineLiverDiseaseHistoryId() {
        return medicineLiverDiseaseHistoryId;
    }

    public void setMedicineLiverDiseaseHistoryId(int medicineLiverDiseaseHistoryId) {
        this.medicineLiverDiseaseHistoryId = medicineLiverDiseaseHistoryId;
    }

    public String getDiseaseName() {
        return diseaseName;
    }

    public void setDiseaseName(String diseaseName) {
        this.diseaseName = diseaseName;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }

    public Date getCrueDate() {
        return crueDate;
    }

    public void setCrueDate(Date crueDate) {
        this.crueDate = crueDate;
    }

    public String getExistence() {
        return existence;
    }

    public void setExistence(String existence) {
        this.existence = existence;
    }
}
