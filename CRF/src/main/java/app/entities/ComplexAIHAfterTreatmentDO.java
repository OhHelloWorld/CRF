package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "complex_AIH_after_treatment")
public class ComplexAIHAfterTreatmentDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    private int woman;// 是否为女性
    private int historyDrugs;// 药物史
    @Column(name = "ALP_AST")
    private int aLPAST;// ALP（正常上限的倍数）：AST（或ALT）（正常上限的倍数）比值
    private int alcoholIntake;// 平均酒精摄入量
    private int serumGlobulinNormal;// 血清球蛋白或IgG与正常值的比值
    private int liverCheck;// 肝脏组织学检查
    @Column(name = "ANA")
    private int ana;
    private int otherImmuneDiseases;// 是否有其他免疫疾病
    @Column(name = "AMA_positive")
    private int amaPositive;// AMA阳性
    private int otherAvailableParameters;// 其他可用的参数
    private int hepatitisVirusMarkers;// 肝炎病毒标志物
    private int responseTreatment;// 治疗后反应
    private boolean complete;

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

    public int getWoman() {
        return woman;
    }

    public void setWoman(int woman) {
        this.woman = woman;
    }

    public int getHistoryDrugs() {
        return historyDrugs;
    }

    public void setHistoryDrugs(int historyDrugs) {
        this.historyDrugs = historyDrugs;
    }

    public int getaLPAST() {
        return aLPAST;
    }

    public void setaLPAST(int aLPAST) {
        this.aLPAST = aLPAST;
    }

    public int getAlcoholIntake() {
        return alcoholIntake;
    }

    public void setAlcoholIntake(int alcoholIntake) {
        this.alcoholIntake = alcoholIntake;
    }

    public int getSerumGlobulinNormal() {
        return serumGlobulinNormal;
    }

    public void setSerumGlobulinNormal(int serumGlobulinNormal) {
        this.serumGlobulinNormal = serumGlobulinNormal;
    }

    public int getLiverCheck() {
        return liverCheck;
    }

    public void setLiverCheck(int liverCheck) {
        this.liverCheck = liverCheck;
    }

    public int getAna() {
        return ana;
    }

    public void setAna(int ana) {
        this.ana = ana;
    }

    public int getOtherImmuneDiseases() {
        return otherImmuneDiseases;
    }

    public void setOtherImmuneDiseases(int otherImmuneDiseases) {
        this.otherImmuneDiseases = otherImmuneDiseases;
    }

    public int getAmaPositive() {
        return amaPositive;
    }

    public void setAmaPositive(int amaPositive) {
        this.amaPositive = amaPositive;
    }

    public int getOtherAvailableParameters() {
        return otherAvailableParameters;
    }

    public void setOtherAvailableParameters(int otherAvailableParameters) {
        this.otherAvailableParameters = otherAvailableParameters;
    }

    public int getHepatitisVirusMarkers() {
        return hepatitisVirusMarkers;
    }

    public void setHepatitisVirusMarkers(int hepatitisVirusMarkers) {
        this.hepatitisVirusMarkers = hepatitisVirusMarkers;
    }

    public int getResponseTreatment() {
        return responseTreatment;
    }

    public void setResponseTreatment(int responseTreatment) {
        this.responseTreatment = responseTreatment;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


}
