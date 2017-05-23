package dto;

import java.util.Date;


/**
 * @author Administrator 患者一般资料DTO
 */
public class PatientDTO {

    private int id;
    private String name;
    private String gender;
    private int age;
    private float height;
    private float weight;
    private boolean smoke;
    private boolean drink;
    private boolean familyHistory;
    private Date hepatitisDiagnosisTime;
    private Date cirrhosisDiagnosisTime;
    private String westernMedicineDiagnosis;
    private String chineseMedicineDiagnosis;
    private String westernMedicineTreatment;
    private String chineseMedicineTreatment;
    private boolean complete;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public boolean isSmoke() {
        return smoke;
    }

    public void setSmoke(boolean smoke) {
        this.smoke = smoke;
    }

    public boolean isDrink() {
        return drink;
    }

    public void setDrink(boolean drink) {
        this.drink = drink;
    }

    public boolean isFamilyHistory() {
        return familyHistory;
    }

    public void setFamilyHistory(boolean familyHistory) {
        this.familyHistory = familyHistory;
    }

    public Date getHepatitisDiagnosisTime() {
        return hepatitisDiagnosisTime;
    }

    public void setHepatitisDiagnosisTime(Date hepatitisDiagnosisTime) {
        this.hepatitisDiagnosisTime = hepatitisDiagnosisTime;
    }

    public Date getCirrhosisDiagnosisTime() {
        return cirrhosisDiagnosisTime;
    }

    public void setCirrhosisDiagnosisTime(Date cirrhosisDiagnosisTime) {
        this.cirrhosisDiagnosisTime = cirrhosisDiagnosisTime;
    }

    public String getWesternMedicineDiagnosis() {
        return westernMedicineDiagnosis;
    }

    public void setWesternMedicineDiagnosis(String westernMedicineDiagnosis) {
        this.westernMedicineDiagnosis = westernMedicineDiagnosis;
    }

    public String getChineseMedicineDiagnosis() {
        return chineseMedicineDiagnosis;
    }

    public void setChineseMedicineDiagnosis(String chineseMedicineDiagnosis) {
        this.chineseMedicineDiagnosis = chineseMedicineDiagnosis;
    }

    public String getWesternMedicineTreatment() {
        return westernMedicineTreatment;
    }

    public void setWesternMedicineTreatment(String westernMedicineTreatment) {
        this.westernMedicineTreatment = westernMedicineTreatment;
    }

    public String getChineseMedicineTreatment() {
        return chineseMedicineTreatment;
    }

    public void setChineseMedicineTreatment(String chineseMedicineTreatment) {
        this.chineseMedicineTreatment = chineseMedicineTreatment;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }


}
