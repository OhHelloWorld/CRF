package app.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "simple_aih")
public class SimpleAIHDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    @Column(name = "ANA_SMA1")
    private int anasma1;// ANA或SMA阴性阳性
    @Column(name = "ANA_SMA2")
    private int anasma2;// ANA/SMA
    private int antiLkm;// Anti-LKM
    private int antiSla;
    @Column(name = "IgG")
    private int igG;
    private int liver;// 肝组织学
    private int eliminateViralHepatitis;// 排除病毒性肝炎
    private boolean complete;
    private int result;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    public int getPatientId() {
        return patientId;
    }

    public void setPatientId(int patientId) {
        this.patientId = patientId;
    }

    public int getAnasma1() {
        return anasma1;
    }

    public void setAnasma1(int anasma1) {
        this.anasma1 = anasma1;
    }

    public int getAnasma2() {
        return anasma2;
    }

    public void setAnasma2(int anasma2) {
        this.anasma2 = anasma2;
    }

    public int getAntiLkm() {
        return antiLkm;
    }

    public void setAntiLkm(int antiLkm) {
        this.antiLkm = antiLkm;
    }

    public int getAntiSla() {
        return antiSla;
    }

    public void setAntiSla(int antiSla) {
        this.antiSla = antiSla;
    }

    public int getIgG() {
        return igG;
    }

    public void setIgG(int igG) {
        this.igG = igG;
    }

    public int getLiver() {
        return liver;
    }

    public void setLiver(int liver) {
        this.liver = liver;
    }

    public int getEliminateViralHepatitis() {
        return eliminateViralHepatitis;
    }

    public void setEliminateViralHepatitis(int eliminateViralHepatitis) {
        this.eliminateViralHepatitis = eliminateViralHepatitis;
    }


}
