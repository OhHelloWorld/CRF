package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class MedicineLiverDiseaseHistoryDetailDTO {

    private int id;
    private int medicineLiverDiseaseHistoryId;
    private String diseaseType;//疾病种类
    private String diseaseName; //疾病名称
    private String existence;//是否仍然存在
    private String preMedicine;//曾用药

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

    public String getDiseaseType() {
        return diseaseType;
    }

    public void setDiseaseType(String diseaseType) {
        this.diseaseType = diseaseType;
    }

    public String getPreMedicine() {
        return preMedicine;
    }

    public void setPreMedicine(String preMedicine) {
        this.preMedicine = preMedicine;
    }

    public String getExistence() {
        return existence;
    }

    public void setExistence(String existence) {
        this.existence = existence;
    }
}
