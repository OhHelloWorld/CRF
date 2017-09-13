package app.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
@Entity(name = "medicine_liver_exclude_other")
public class MedicineLiverExcludeOtherDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    private int antiHav;
    @Column(name = "anti_hav_date")
    private Date antiHavDate;
    private int hbsag;
    private Date hbsagDate;
    private int hbsab;
    private Date hbsabDate;
    private int hbcab;
    private int hbcabDate;
    private int hbeag;
    private Date hbeagDate;
    private int hbeab;
    private Date hbeabDate;
    private int hbvdna;
    private Date hbvdnaDate;
    private int antihcv;
    private Date antihcvDate;
    private int hcvrna;
    private Date hcvrnaDate;
    private int Mononucleosis;
    private Date MononucleosisDate;//单核细胞增多症检查日期
    private int ana;
    private Date anaDate;
    private int ama;
    private Date amaDate;
    private int amam2;
    private Date amam2Date;
    private int sma;
    private Date smaDate;
    private int lkm;
    private Date lkmDate;
    private int rheumatoid;//类风湿因子
    private Date rheumatoidDate;//类风湿因子检查日期
    private int ceruloplasmin;//铜蓝蛋白
    private Date ceruloplasminDate;//铜蓝蛋白检查日期
    private int cytomegalovirus;//巨细胞病毒
    private Date cytomegalovirusDate;//巨细胞病毒检查日期
    private int ebviruses;//EB病毒
    private Date ebvirusesDate;//EB病毒检查日期
    private int herpesSimplex;//单纯疱疹病毒
    @Column(name = "herpes_simplex_date")
    private Date herpesSimplexDate;//单纯疱疹病毒检查日期
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

    public Date getHbsagDate() {
        return hbsagDate;
    }

    public void setHbsagDate(Date hbsagDate) {
        this.hbsagDate = hbsagDate;
    }

    public int getHbsab() {
        return hbsab;
    }

    public void setHbsab(int hbsab) {
        this.hbsab = hbsab;
    }

    public Date getHbsabDate() {
        return hbsabDate;
    }

    public void setHbsabDate(Date hbsabDate) {
        this.hbsabDate = hbsabDate;
    }

    public int getHbcab() {
        return hbcab;
    }

    public void setHbcab(int hbcab) {
        this.hbcab = hbcab;
    }

    public int getHbcabDate() {
        return hbcabDate;
    }

    public void setHbcabDate(int hbcabDate) {
        this.hbcabDate = hbcabDate;
    }

    public int getHbeag() {
        return hbeag;
    }

    public void setHbeag(int hbeag) {
        this.hbeag = hbeag;
    }

    public Date getHbeagDate() {
        return hbeagDate;
    }

    public void setHbeagDate(Date hbeagDate) {
        this.hbeagDate = hbeagDate;
    }

    public int getHbeab() {
        return hbeab;
    }

    public void setHbeab(int hbeab) {
        this.hbeab = hbeab;
    }

    public Date getHbeabDate() {
        return hbeabDate;
    }

    public void setHbeabDate(Date hbeabDate) {
        this.hbeabDate = hbeabDate;
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

    public Date getAnaDate() {
        return anaDate;
    }

    public void setAnaDate(Date anaDate) {
        this.anaDate = anaDate;
    }

    public int getAma() {
        return ama;
    }

    public void setAma(int ama) {
        this.ama = ama;
    }

    public Date getAmaDate() {
        return amaDate;
    }

    public void setAmaDate(Date amaDate) {
        this.amaDate = amaDate;
    }

    public int getAmam2() {
        return amam2;
    }

    public void setAmam2(int amam2) {
        this.amam2 = amam2;
    }

    public Date getAmam2Date() {
        return amam2Date;
    }

    public void setAmam2Date(Date amam2Date) {
        this.amam2Date = amam2Date;
    }

    public int getSma() {
        return sma;
    }

    public void setSma(int sma) {
        this.sma = sma;
    }

    public Date getSmaDate() {
        return smaDate;
    }

    public void setSmaDate(Date smaDate) {
        this.smaDate = smaDate;
    }

    public int getLkm() {
        return lkm;
    }

    public void setLkm(int lkm) {
        this.lkm = lkm;
    }

    public Date getLkmDate() {
        return lkmDate;
    }

    public void setLkmDate(Date lkmDate) {
        this.lkmDate = lkmDate;
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

    public Date getCytomegalovirusDate() {
        return cytomegalovirusDate;
    }

    public void setCytomegalovirusDate(Date cytomegalovirusDate) {
        this.cytomegalovirusDate = cytomegalovirusDate;
    }

    public int getEbviruses() {
        return ebviruses;
    }

    public void setEbviruses(int ebviruses) {
        this.ebviruses = ebviruses;
    }

    public Date getEbvirusesDate() {
        return ebvirusesDate;
    }

    public void setEbvirusesDate(Date ebvirusesDate) {
        this.ebvirusesDate = ebvirusesDate;
    }

    public int getHerpesSimplex() {
        return herpesSimplex;
    }

    public void setHerpesSimplex(int herpesSimplex) {
        this.herpesSimplex = herpesSimplex;
    }

    public Date getHerpesSimplexDate() {
        return herpesSimplexDate;
    }

    public void setHerpesSimplexDate(Date herpesSimplexDate) {
        this.herpesSimplexDate = herpesSimplexDate;
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
