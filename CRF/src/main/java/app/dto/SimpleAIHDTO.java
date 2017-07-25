package app.dto;

public class SimpleAIHDTO {

    private int id;
    private int patientId;
    private int anasma1;
    private int anasma2;
    private int antiLkm;
    private int antiSla;
    private int igG;
    private int liver;
    private int eliminateViralHepatitis;
    private int result;
    private boolean complete;

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
