package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class AdmissionDiagnosisDTO {
    private int id;
    private int mlPatientId;
    private String diagnosis;
    private Date diagnosisDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMlPatientId() {
        return mlPatientId;
    }

    public void setMlPatientId(int mlPatientId) {
        this.mlPatientId = mlPatientId;
    }

    public String getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }

    public Date getDiagnosisDate() {
        return diagnosisDate;
    }

    public void setDiagnosisDate(Date diagnosisDate) {
        this.diagnosisDate = diagnosisDate;
    }
}
