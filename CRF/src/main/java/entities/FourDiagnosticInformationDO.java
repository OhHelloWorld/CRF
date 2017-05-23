package entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * @author Administrator »¼ÕßÒ»°ã×ÊÁÏEntity
 */
@Entity
@Table(name = "four_diagnostic_information")
public class FourDiagnosticInformationDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int patientId;// »¼ÕßId
    private int fatigue;// ·¦Á¦
    private int skinItching;// Æ¤·ôðþÑ÷
    private int twoEyesDry;// Á½Ä¿¸ÉÉ¬
    private int blurredVision;// ÊÓÎïÄ£ºý
    private int depression;// ÒÖÓô
    private int irritability;// ·³ÔêÒ×Å­
    private int insomnia;// Ê§Ãß
    private int easyWakeUp;// Ò×ÐÑ
    private int tinnitus;// ¶úÃù
    private int dryMouth;// ¿Ú¸É
    private int mouthPain;// ¿Ú¿à
    private int badBreath;// ¿Ú³ô
    private int nausea;// ¶ñÐÄ
    private int belching;// àÈÆø
    private int abdominalDistention;// ëä¸¹ÕÍÂú
    private int flankPainStinging;// Ð²ÀßÍ´-´ÌÍ´
    private int flankPainSwell;// Ð²ÀßÍ´-ÕÍÍ´
    private int flankPainDull;// Ð²ÀßÍ´-ÒþÍ´
    private int flankPainDiscomfort;// Ð²ÀßÍ´-²»ÊÊ
    private int anorexia;// ÄÉ²î
    private int aphrodisiacCold;// Î·º®Ö«Àä
    private int limb;// Ö«ÌåÀ§ÖØ
    private int backacheFootSoft;// Ñü¯iÍÈÈí
    private int handFootFanHot;// ÊÖ×ã·³ÈÈ
    private int urineYellow;// Äò»Æ
    private int constipation;// ±ãÃØ
    private int looseStools;// ±ãäç
    private int perspiration;// ×Ôº¹
    private int nightSweats;// µÁº¹
    private int lowerExtremityEdema;// ÏÂÖ«Ë®Ö×
    private int faceDull;// Ãæ»Þ°µ
    private int eyeYellow;// Ä¿»Æ
    private int bodyYellow;// Éí»Æ
    private int spiderNevus;// Ö©ÖëðëÊýÁ¿
    private int liverPalm;// ¸ÎÕÆ
    private int abdominalVeins;// ¸¹±ÚÂöÂçÇúÕÅ
    private int yellowTumor;// »ÆÉ«Áö
    private boolean complete;// ÊÇ·ñÍê³É

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

    public int getFatigue() {
        return fatigue;
    }

    public void setFatigue(int fatigue) {
        this.fatigue = fatigue;
    }

    public int getSkinItching() {
        return skinItching;
    }

    public void setSkinItching(int skinItching) {
        this.skinItching = skinItching;
    }

    public int getTwoEyesDry() {
        return twoEyesDry;
    }

    public void setTwoEyesDry(int twoEyesDry) {
        this.twoEyesDry = twoEyesDry;
    }

    public int getBlurredVision() {
        return blurredVision;
    }

    public void setBlurredVision(int blurredVision) {
        this.blurredVision = blurredVision;
    }

    public int getDepression() {
        return depression;
    }

    public void setDepression(int depression) {
        this.depression = depression;
    }

    public int getIrritability() {
        return irritability;
    }

    public void setIrritability(int irritability) {
        this.irritability = irritability;
    }

    public int getInsomnia() {
        return insomnia;
    }

    public void setInsomnia(int insomnia) {
        this.insomnia = insomnia;
    }

    public int getEasyWakeUp() {
        return easyWakeUp;
    }

    public void setEasyWakeUp(int easyWakeUp) {
        this.easyWakeUp = easyWakeUp;
    }

    public int getTinnitus() {
        return tinnitus;
    }

    public void setTinnitus(int tinnitus) {
        this.tinnitus = tinnitus;
    }

    public int getDryMouth() {
        return dryMouth;
    }

    public void setDryMouth(int dryMouth) {
        this.dryMouth = dryMouth;
    }

    public int getMouthPain() {
        return mouthPain;
    }

    public void setMouthPain(int mouthPain) {
        this.mouthPain = mouthPain;
    }

    public int getBadBreath() {
        return badBreath;
    }

    public void setBadBreath(int badBreath) {
        this.badBreath = badBreath;
    }

    public int getNausea() {
        return nausea;
    }

    public void setNausea(int nausea) {
        this.nausea = nausea;
    }

    public int getBelching() {
        return belching;
    }

    public void setBelching(int belching) {
        this.belching = belching;
    }

    public int getAbdominalDistention() {
        return abdominalDistention;
    }

    public void setAbdominalDistention(int abdominalDistention) {
        this.abdominalDistention = abdominalDistention;
    }

    public int getFlankPainStinging() {
        return flankPainStinging;
    }

    public void setFlankPainStinging(int flankPainStinging) {
        this.flankPainStinging = flankPainStinging;
    }

    public int getFlankPainSwell() {
        return flankPainSwell;
    }

    public void setFlankPainSwell(int flankPainSwell) {
        this.flankPainSwell = flankPainSwell;
    }

    public int getFlankPainDull() {
        return flankPainDull;
    }

    public void setFlankPainDull(int flankPainDull) {
        this.flankPainDull = flankPainDull;
    }

    public int getFlankPainDiscomfort() {
        return flankPainDiscomfort;
    }

    public void setFlankPainDiscomfort(int flankPainDiscomfort) {
        this.flankPainDiscomfort = flankPainDiscomfort;
    }

    public int getAnorexia() {
        return anorexia;
    }

    public void setAnorexia(int anorexia) {
        this.anorexia = anorexia;
    }

    public int getAphrodisiacCold() {
        return aphrodisiacCold;
    }

    public void setAphrodisiacCold(int aphrodisiacCold) {
        this.aphrodisiacCold = aphrodisiacCold;
    }

    public int getLimb() {
        return limb;
    }

    public void setLimb(int limb) {
        this.limb = limb;
    }

    public int getBackacheFootSoft() {
        return backacheFootSoft;
    }

    public void setBackacheFootSoft(int backacheFootSoft) {
        this.backacheFootSoft = backacheFootSoft;
    }

    public int getHandFootFanHot() {
        return handFootFanHot;
    }

    public void setHandFootFanHot(int handFootFanHot) {
        this.handFootFanHot = handFootFanHot;
    }

    public int getUrineYellow() {
        return urineYellow;
    }

    public void setUrineYellow(int urineYellow) {
        this.urineYellow = urineYellow;
    }

    public int getConstipation() {
        return constipation;
    }

    public void setConstipation(int constipation) {
        this.constipation = constipation;
    }

    public int getLooseStools() {
        return looseStools;
    }

    public void setLooseStools(int looseStools) {
        this.looseStools = looseStools;
    }

    public int getPerspiration() {
        return perspiration;
    }

    public void setPerspiration(int perspiration) {
        this.perspiration = perspiration;
    }

    public int getNightSweats() {
        return nightSweats;
    }

    public void setNightSweats(int nightSweats) {
        this.nightSweats = nightSweats;
    }

    public int getLowerExtremityEdema() {
        return lowerExtremityEdema;
    }

    public void setLowerExtremityEdema(int lowerExtremityEdema) {
        this.lowerExtremityEdema = lowerExtremityEdema;
    }

    public int getFaceDull() {
        return faceDull;
    }

    public void setFaceDull(int faceDull) {
        this.faceDull = faceDull;
    }

    public int getEyeYellow() {
        return eyeYellow;
    }

    public void setEyeYellow(int eyeYellow) {
        this.eyeYellow = eyeYellow;
    }

    public int getBodyYellow() {
        return bodyYellow;
    }

    public void setBodyYellow(int bodyYellow) {
        this.bodyYellow = bodyYellow;
    }

    public int getSpiderNevus() {
        return spiderNevus;
    }

    public void setSpiderNevus(int spiderNevus) {
        this.spiderNevus = spiderNevus;
    }

    public int getLiverPalm() {
        return liverPalm;
    }

    public void setLiverPalm(int liverPalm) {
        this.liverPalm = liverPalm;
    }

    public int getAbdominalVeins() {
        return abdominalVeins;
    }

    public void setAbdominalVeins(int abdominalVeins) {
        this.abdominalVeins = abdominalVeins;
    }

    public int getYellowTumor() {
        return yellowTumor;
    }

    public void setYellowTumor(int yellowTumor) {
        this.yellowTumor = yellowTumor;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


}
