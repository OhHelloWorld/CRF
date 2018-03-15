package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2018/3/14 0014.
 */
public class MedicineLiverHospitalAbnormalExaminationLiverDTO {

    private int id;
    private int hospitalAbnormalExaminationId;
    private String alt;
    private String ast;
    private String ggt;
    private String alp;
    private String bileAcid;
    private String tbil;
    private String dbil;
    private String tp;
    private String alb;
    private Date tab1CheckDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getHospitalAbnormalExaminationId() {
        return hospitalAbnormalExaminationId;
    }

    public void setHospitalAbnormalExaminationId(int hospitalAbnormalExaminationId) {
        this.hospitalAbnormalExaminationId = hospitalAbnormalExaminationId;
    }

    public String getAlt() {
        return alt;
    }

    public void setAlt(String alt) {
        this.alt = alt;
    }

    public String getAst() {
        return ast;
    }

    public void setAst(String ast) {
        this.ast = ast;
    }

    public String getGgt() {
        return ggt;
    }

    public void setGgt(String ggt) {
        this.ggt = ggt;
    }

    public String getAlp() {
        return alp;
    }

    public void setAlp(String alp) {
        this.alp = alp;
    }

    public String getBileAcid() {
        return bileAcid;
    }

    public void setBileAcid(String bileAcid) {
        this.bileAcid = bileAcid;
    }

    public String getTbil() {
        return tbil;
    }

    public void setTbil(String tbil) {
        this.tbil = tbil;
    }

    public String getDbil() {
        return dbil;
    }

    public void setDbil(String dbil) {
        this.dbil = dbil;
    }

    public String getTp() {
        return tp;
    }

    public void setTp(String tp) {
        this.tp = tp;
    }

    public String getAlb() {
        return alb;
    }

    public void setAlb(String alb) {
        this.alb = alb;
    }

    public Date getTab1CheckDate() {
        return tab1CheckDate;
    }

    public void setTab1CheckDate(Date tab1CheckDate) {
        this.tab1CheckDate = tab1CheckDate;
    }
}
