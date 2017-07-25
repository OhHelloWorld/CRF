package app.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "liver_pathology")
@Entity
public class LiverPathologyDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    private Date addDate;// 添加时间
    private String pathologyNumber;// 医院病理号，可填，默认为病人编号
    private int inflammationLeaflets;// 小叶内炎症
    private int interfacialInflammation;// 界面性炎症
    private int portalAreaInflammation;// 汇管区炎症
    private int lymphocytePlasmaCellInfiltration;// 淋巴细胞浆细胞浸润
    private int fibrousTissueHyperplasia;// 纤维组织增生
    private int inflammationBileDuct;// 胆管炎症
    private int hepatocellularSteatosis;// 肝细胞脂肪变性
    private int roseSample;// 玫瑰花结样改变
    @Column(name = "HBs_Ag")
    private int hbsAg;// HBsAg染色
    @Column(name="HBc_Ag")
    private int hbcAg;// HBcAg染色
    @Column(name = "HCV")
    private int hcv;// HCV染色
    private int other;// 其他
    private int diagnosis;// 诊断(分期分级)
    private String remarks;// 备注
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

    public Date getAddDate() {
        return addDate;
    }

    public void setAddDate(Date addDate) {
        this.addDate = addDate;
    }

    public String getPathologyNumber() {
        return pathologyNumber;
    }

    public void setPathologyNumber(String pathologyNumber) {
        this.pathologyNumber = pathologyNumber;
    }

    public int getInflammationLeaflets() {
        return inflammationLeaflets;
    }

    public void setInflammationLeaflets(int inflammationLeaflets) {
        this.inflammationLeaflets = inflammationLeaflets;
    }

    public int getInterfacialInflammation() {
        return interfacialInflammation;
    }

    public void setInterfacialInflammation(int interfacialInflammation) {
        this.interfacialInflammation = interfacialInflammation;
    }

    public int getPortalAreaInflammation() {
        return portalAreaInflammation;
    }

    public void setPortalAreaInflammation(int portalAreaInflammation) {
        this.portalAreaInflammation = portalAreaInflammation;
    }

    public int getLymphocytePlasmaCellInfiltration() {
        return lymphocytePlasmaCellInfiltration;
    }

    public void setLymphocytePlasmaCellInfiltration(int lymphocytePlasmaCellInfiltration) {
        this.lymphocytePlasmaCellInfiltration = lymphocytePlasmaCellInfiltration;
    }

    public int getFibrousTissueHyperplasia() {
        return fibrousTissueHyperplasia;
    }

    public void setFibrousTissueHyperplasia(int fibrousTissueHyperplasia) {
        this.fibrousTissueHyperplasia = fibrousTissueHyperplasia;
    }

    public int getInflammationBileDuct() {
        return inflammationBileDuct;
    }

    public void setInflammationBileDuct(int inflammationBileDuct) {
        this.inflammationBileDuct = inflammationBileDuct;
    }

    public int getHepatocellularSteatosis() {
        return hepatocellularSteatosis;
    }

    public void setHepatocellularSteatosis(int hepatocellularSteatosis) {
        this.hepatocellularSteatosis = hepatocellularSteatosis;
    }

    public int getRoseSample() {
        return roseSample;
    }

    public void setRoseSample(int roseSample) {
        this.roseSample = roseSample;
    }

    public int getHbsAg() {
        return hbsAg;
    }

    public void setHbsAg(int hbsAg) {
        this.hbsAg = hbsAg;
    }

    public int getHbcAg() {
        return hbcAg;
    }

    public void setHbcAg(int hbcAg) {
        this.hbcAg = hbcAg;
    }

    public int getHcv() {
        return hcv;
    }

    public void setHcv(int hcv) {
        this.hcv = hcv;
    }

    public int getOther() {
        return other;
    }

    public void setOther(int other) {
        this.other = other;
    }

    public int getDiagnosis() {
        return diagnosis;
    }

    public void setDiagnosis(int diagnosis) {
        this.diagnosis = diagnosis;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


}
