package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "final_diagnosis_special_circumstances")
public class FinalDiagnosisSpecialCircumstancesDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    @Column(name = "PBC_clinical")
    private String pbcClinicalStage;// PBC临床分期
    @Column(name = "AIH_clinical")
    private String aihClinicalStage;// AIH临床分期
    private boolean children;// 儿童
    @Column(name = "gestation_period")
    private boolean gestationPeriod;// 妊娠期
    @Column(name = "repeated_relapse")
    private boolean repeatedRelapse;// 多次复发
    @Column(name = "resistant_to_steroid_treatment")
    private boolean resistantToSteroidTreatment;// 对激素耐药
    @Column(name = "patients_with_chronic_hepatitis_b")
    private boolean patientsWithChronicHepatitisB;// 合并慢性乙型肝炎
    @Column(name = "patients_with_chronic_hepatitis_c")
    private boolean patientsWithChronicHepatitisC;// 合并慢性丙型肝炎
    @Column(name = "overlapping_aihpbc")
    private boolean overlappingAIHPBC;// AIH-PBC重叠
    @Column(name = "overlapping_aihpsc")
    private boolean overlappingAIHPSC;// AIH-PSC重叠
    @Column(name = "autoimmune_cholangitis")
    private boolean autoimmuneCholangitis;// 自身免疫性胆管炎
    @Column(name = "final_diagnosis_other")
    private boolean finalDiagnosisOther;// 其他
    private boolean complete;// 所有字段是否全部填写

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public String getPbcClinicalStage() {
        return pbcClinicalStage;
    }

    public void setPbcClinicalStage(String pbcClinicalStage) {
        this.pbcClinicalStage = pbcClinicalStage;
    }

    public String getAihClinicalStage() {
        return aihClinicalStage;
    }

    public void setAihClinicalStage(String aihClinicalStage) {
        this.aihClinicalStage = aihClinicalStage;
    }

    public boolean isChildren() {
        return children;
    }

    public void setChildren(boolean children) {
        this.children = children;
    }

    public boolean isGestationPeriod() {
        return gestationPeriod;
    }

    public void setGestationPeriod(boolean gestationPeriod) {
        this.gestationPeriod = gestationPeriod;
    }

    public boolean isRepeatedRelapse() {
        return repeatedRelapse;
    }

    public void setRepeatedRelapse(boolean repeatedRelapse) {
        this.repeatedRelapse = repeatedRelapse;
    }

    public boolean isResistantToSteroidTreatment() {
        return resistantToSteroidTreatment;
    }

    public void setResistantToSteroidTreatment(boolean resistantToSteroidTreatment) {
        this.resistantToSteroidTreatment = resistantToSteroidTreatment;
    }

    public boolean isPatientsWithChronicHepatitisB() {
        return patientsWithChronicHepatitisB;
    }

    public void setPatientsWithChronicHepatitisB(boolean patientsWithChronicHepatitisB) {
        this.patientsWithChronicHepatitisB = patientsWithChronicHepatitisB;
    }

    public boolean isPatientsWithChronicHepatitisC() {
        return patientsWithChronicHepatitisC;
    }

    public void setPatientsWithChronicHepatitisC(boolean patientsWithChronicHepatitisC) {
        this.patientsWithChronicHepatitisC = patientsWithChronicHepatitisC;
    }

    public boolean isOverlappingAIHPBC() {
        return overlappingAIHPBC;
    }

    public void setOverlappingAIHPBC(boolean overlappingAIHPBC) {
        this.overlappingAIHPBC = overlappingAIHPBC;
    }

    public boolean isOverlappingAIHPSC() {
        return overlappingAIHPSC;
    }

    public void setOverlappingAIHPSC(boolean overlappingAIHPSC) {
        this.overlappingAIHPSC = overlappingAIHPSC;
    }

    public boolean isAutoimmuneCholangitis() {
        return autoimmuneCholangitis;
    }

    public void setAutoimmuneCholangitis(boolean autoimmuneCholangitis) {
        this.autoimmuneCholangitis = autoimmuneCholangitis;
    }

    public boolean isFinalDiagnosisOther() {
        return finalDiagnosisOther;
    }

    public void setFinalDiagnosisOther(boolean finalDiagnosisOther) {
        this.finalDiagnosisOther = finalDiagnosisOther;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
