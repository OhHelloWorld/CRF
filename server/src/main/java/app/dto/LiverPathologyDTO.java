package app.dto;

import java.util.Date;

public class LiverPathologyDTO {

    private int id;
    private int patientId;
    private Date addDate;
    private String pathologyNumber;
    private int inflammationLeaflets;
    private int interfacialInflammation;
    private int portalAreaInflammation;
    private int lymphocytePlasmaCellInfiltration;
    private int fibrousTissueHyperplasia;
    private int inflammationBileDuct;
    private int hepatocellularSteatosis;
    private int roseSample;
    private int hbsAg;
    private int hbcAg;
    private int hcv;
    private int other;
    private int diagnosis;
    private String remarks;
    private boolean complete;
    private boolean choose;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isChoose() {
        return choose;
    }

    public void setChoose(boolean choose) {
        this.choose = choose;
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
