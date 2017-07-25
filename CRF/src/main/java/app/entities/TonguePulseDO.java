package app.entities;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * 舌脉象数据
 * 
 * @author JR
 *
 */
@Entity
@Table(name = "tongue_pulse")
public class TonguePulseDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int patientId;// 患者Id
    private String tongue;// 舌质
    private String tonguePart;// 舌质部位
    private String tonguePartialDescription;// 舌质部位局部说明
    private String tongueBody;// 舌体
    private String mossy;// 苔质
    private String mossyPart;// 苔质部位
    private String mossyPartialDescription;// 苔质部位局部说明
    private String tongueColor;// 舌苔色
    private String tongueColorPart;// 舌苔色部位
    private String tongueColorPartialDescription;// 舌苔色部位局部说明
    private String sublingualVaricoseVeins;// 舌下静脉曲张
    private String leftPulse;// 左脉象
    private String rightPulse;// 右脉象
    private boolean complete;// 是否完成
    private boolean followUp;
    private Date followUpDate;

    public boolean isFollowUp() {
        return followUp;
    }

    public void setFollowUp(boolean followUp) {
        this.followUp = followUp;
    }

    public Date getFollowUpDate() {
        return followUpDate;
    }

    public void setFollowUpDate(Date followUpDate) {
        this.followUpDate = followUpDate;
    }

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

    public String getTongue() {
        return tongue;
    }

    public void setTongue(String tongue) {
        this.tongue = tongue;
    }

    public String getTonguePart() {
        return tonguePart;
    }

    public void setTonguePart(String tonguePart) {
        this.tonguePart = tonguePart;
    }

    public String getTonguePartialDescription() {
        return tonguePartialDescription;
    }

    public void setTonguePartialDescription(String tonguePartialDescription) {
        this.tonguePartialDescription = tonguePartialDescription;
    }

    public String getTongueBody() {
        return tongueBody;
    }

    public void setTongueBody(String tongueBody) {
        this.tongueBody = tongueBody;
    }

    public String getMossy() {
        return mossy;
    }

    public void setMossy(String mossy) {
        this.mossy = mossy;
    }

    public String getMossyPart() {
        return mossyPart;
    }

    public void setMossyPart(String mossyPart) {
        this.mossyPart = mossyPart;
    }

    public String getMossyPartialDescription() {
        return mossyPartialDescription;
    }

    public void setMossyPartialDescription(String mossyPartialDescription) {
        this.mossyPartialDescription = mossyPartialDescription;
    }

    public String getTongueColor() {
        return tongueColor;
    }

    public void setTongueColor(String tongueColor) {
        this.tongueColor = tongueColor;
    }

    public String getTongueColorPart() {
        return tongueColorPart;
    }

    public void setTongueColorPart(String tongueColorPart) {
        this.tongueColorPart = tongueColorPart;
    }

    public String getTongueColorPartialDescription() {
        return tongueColorPartialDescription;
    }

    public void setTongueColorPartialDescription(String tongueColorPartialDescription) {
        this.tongueColorPartialDescription = tongueColorPartialDescription;
    }

    public String getSublingualVaricoseVeins() {
        return sublingualVaricoseVeins;
    }

    public void setSublingualVaricoseVeins(String sublingualVaricoseVeins) {
        this.sublingualVaricoseVeins = sublingualVaricoseVeins;
    }

    public String getLeftPulse() {
        return leftPulse;
    }

    public void setLeftPulse(String leftPulse) {
        this.leftPulse = leftPulse;
    }

    public String getRightPulse() {
        return rightPulse;
    }

    public void setRightPulse(String rightPulse) {
        this.rightPulse = rightPulse;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


}
