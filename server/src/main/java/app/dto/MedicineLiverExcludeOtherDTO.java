package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class MedicineLiverExcludeOtherDTO {

    private int id;
    private int patientId;
    private int antiHav;
    private Date antiHavDate;
    private int hbsag;
    private int hbsab;
    private int hbcab;
    private int hbeag;
    private int hbeab;
    private int hbvdna;
    private Date hbvdnaDate;
    private int antihcv;
    private Date antihcvDate;
    private int hcvrna;
    private Date hcvrnaDate;
    private int Mononucleosis;
    private Date MononucleosisDate;//单核细胞增多症检查日期
    private int ana;
    private int ama;
    private int amam2;
    private int sma;
    private int lkm;
    private int rheumatoid;//类风湿因子
    private Date rheumatoidDate;//类风湿因子检查日期
    private int ceruloplasmin;//铜蓝蛋白
    private Date ceruloplasminDate;//铜蓝蛋白检查日期
    private int cytomegalovirus;//巨细胞病毒
    private int ebviruses;//EB病毒
    private int herpesSimplex;//单纯疱疹病毒
    private Date hepatitisBFiveDate;//乙肝五项日期
    private Date autoimmuneAntibodyDate;//自身免疫抗体日期
    private Date otherVirusCheckDate;//其他病毒检测时间
    private String remark;
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

    public int getAntiHav() {
        return antiHav;
    }

    public void setAntiHav(int antiHav) {
        this.antiHav = antiHav;
    }

    public Date getAntiHavDate() {
        return antiHavDate;
    }

    public void setAntiHavDate(Date antiHavDate) {
        this.antiHavDate = antiHavDate;
    }

    public int getHbsag() {
        return hbsag;
    }

    public void setHbsag(int hbsag) {
        this.hbsag = hbsag;
    }

    public int getHbsab() {
        return hbsab;
    }

    public void setHbsab(int hbsab) {
        this.hbsab = hbsab;
    }

    public int getHbcab() {
        return hbcab;
    }

    public void setHbcab(int hbcab) {
        this.hbcab = hbcab;
    }

    public int getHbeag() {
        return hbeag;
    }

    public void setHbeag(int hbeag) {
        this.hbeag = hbeag;
    }

    public int getHbeab() {
        return hbeab;
    }

    public void setHbeab(int hbeab) {
        this.hbeab = hbeab;
    }

    public int getHbvdna() {
        return hbvdna;
    }

    public void setHbvdna(int hbvdna) {
        this.hbvdna = hbvdna;
    }

    public Date getHbvdnaDate() {
        return hbvdnaDate;
    }

    public void setHbvdnaDate(Date hbvdnaDate) {
        this.hbvdnaDate = hbvdnaDate;
    }

    public int getAntihcv() {
        return antihcv;
    }

    public void setAntihcv(int antihcv) {
        this.antihcv = antihcv;
    }

    public Date getAntihcvDate() {
        return antihcvDate;
    }

    public void setAntihcvDate(Date antihcvDate) {
        this.antihcvDate = antihcvDate;
    }

    public int getHcvrna() {
        return hcvrna;
    }

    public void setHcvrna(int hcvrna) {
        this.hcvrna = hcvrna;
    }

    public Date getHcvrnaDate() {
        return hcvrnaDate;
    }

    public void setHcvrnaDate(Date hcvrnaDate) {
        this.hcvrnaDate = hcvrnaDate;
    }

    public int getMononucleosis() {
        return Mononucleosis;
    }

    public void setMononucleosis(int mononucleosis) {
        Mononucleosis = mononucleosis;
    }

    public Date getMononucleosisDate() {
        return MononucleosisDate;
    }

    public void setMononucleosisDate(Date mononucleosisDate) {
        MononucleosisDate = mononucleosisDate;
    }

    public int getAna() {
        return ana;
    }

    public void setAna(int ana) {
        this.ana = ana;
    }

    public int getAma() {
        return ama;
    }

    public void setAma(int ama) {
        this.ama = ama;
    }

    public int getAmam2() {
        return amam2;
    }

    public void setAmam2(int amam2) {
        this.amam2 = amam2;
    }

    public int getSma() {
        return sma;
    }

    public void setSma(int sma) {
        this.sma = sma;
    }

    public int getLkm() {
        return lkm;
    }

    public void setLkm(int lkm) {
        this.lkm = lkm;
    }

    public int getRheumatoid() {
        return rheumatoid;
    }

    public void setRheumatoid(int rheumatoid) {
        this.rheumatoid = rheumatoid;
    }

    public Date getRheumatoidDate() {
        return rheumatoidDate;
    }

    public void setRheumatoidDate(Date rheumatoidDate) {
        this.rheumatoidDate = rheumatoidDate;
    }

    public int getCeruloplasmin() {
        return ceruloplasmin;
    }

    public void setCeruloplasmin(int ceruloplasmin) {
        this.ceruloplasmin = ceruloplasmin;
    }

    public Date getCeruloplasminDate() {
        return ceruloplasminDate;
    }

    public void setCeruloplasminDate(Date ceruloplasminDate) {
        this.ceruloplasminDate = ceruloplasminDate;
    }

    public int getCytomegalovirus() {
        return cytomegalovirus;
    }

    public void setCytomegalovirus(int cytomegalovirus) {
        this.cytomegalovirus = cytomegalovirus;
    }

    public int getEbviruses() {
        return ebviruses;
    }

    public void setEbviruses(int ebviruses) {
        this.ebviruses = ebviruses;
    }

    public int getHerpesSimplex() {
        return herpesSimplex;
    }

    public void setHerpesSimplex(int herpesSimplex) {
        this.herpesSimplex = herpesSimplex;
    }

    public Date getHepatitisBFiveDate() {
        return hepatitisBFiveDate;
    }

    public void setHepatitisBFiveDate(Date hepatitisBFiveDate) {
        this.hepatitisBFiveDate = hepatitisBFiveDate;
    }

    public Date getAutoimmuneAntibodyDate() {
        return autoimmuneAntibodyDate;
    }

    public void setAutoimmuneAntibodyDate(Date autoimmuneAntibodyDate) {
        this.autoimmuneAntibodyDate = autoimmuneAntibodyDate;
    }

    public Date getOtherVirusCheckDate() {
        return otherVirusCheckDate;
    }

    public void setOtherVirusCheckDate(Date otherVirusCheckDate) {
        this.otherVirusCheckDate = otherVirusCheckDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
