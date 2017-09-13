package app.dto;

import java.util.Date;
import java.util.List;


/**
 * @author Administrator PatientDTO
 */
public class MlPatientDTO {

    private int id;
    private String identifier;
    private String abbreviation;//患者姓名拼音缩写
    private String name;
    private String gender;
    private String nation;
    private float height;
    private float weight;
    private String department;//科室
    private Date admissionDate;//入院日期
    private Date dischargeDate;//出院日期
    private String hospitalizedNumber;//住院号
    private String hospitalizedDepartment;//住院科室
    private int hospitalizedAge;//住院年龄
    private String career;//职业
    private Date birthday;
    private String hospital;
    private boolean complete;
    private Long hospitalId;
    private Long projectId;
    private List<AdmissionDiagnosisDTO> admissionDiagnosisDTOS;
    private List<DischargeDiagnosisDTO> dischargeDiagnosisDTOS;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Long getProjectId() {
        return projectId;
    }

    public void setProjectId(Long projectId) {
        this.projectId = projectId;
    }

    public Long getHospitalId() {
        return hospitalId;
    }

    public void setHospitalId(Long hospitalId) {
        this.hospitalId = hospitalId;
    }

    public String getIdentifier() {
        return identifier;
    }

    public void setIdentifier(String identifier) {
        this.identifier = identifier;
    }

    public String getHospital() {
        return hospital;
    }

    public void setHospital(String hospital) {
        this.hospital = hospital;
    }

    public String getHospitalizedNumber() {
        return hospitalizedNumber;
    }

    public void setHospitalizedNumber(String hospitalizedNumber) {
        this.hospitalizedNumber = hospitalizedNumber;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public void setAbbreviation(String abbreviation) {
        this.abbreviation = abbreviation;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Date getAdmissionDate() {
        return admissionDate;
    }

    public void setAdmissionDate(Date admissionDate) {
        this.admissionDate = admissionDate;
    }

    public Date getDischargeDate() {
        return dischargeDate;
    }

    public void setDischargeDate(Date dischargeDate) {
        this.dischargeDate = dischargeDate;
    }

    public String getHospitalizedDepartment() {
        return hospitalizedDepartment;
    }

    public void setHospitalizedDepartment(String hospitalizedDepartment) {
        this.hospitalizedDepartment = hospitalizedDepartment;
    }

    public int getHospitalizedAge() {
        return hospitalizedAge;
    }

    public void setHospitalizedAge(int hospitalizedAge) {
        this.hospitalizedAge = hospitalizedAge;
    }

    public String getCareer() {
        return career;
    }

    public void setCareer(String career) {
        this.career = career;
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

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public List<AdmissionDiagnosisDTO> getAdmissionDiagnosisDTOS() {
        return admissionDiagnosisDTOS;
    }

    public void setAdmissionDiagnosisDTOS(List<AdmissionDiagnosisDTO> admissionDiagnosisDTOS) {
        this.admissionDiagnosisDTOS = admissionDiagnosisDTOS;
    }

    public List<DischargeDiagnosisDTO> getDischargeDiagnosisDTOS() {
        return dischargeDiagnosisDTOS;
    }

    public void setDischargeDiagnosisDTOS(List<DischargeDiagnosisDTO> dischargeDiagnosisDTOS) {
        this.dischargeDiagnosisDTOS = dischargeDiagnosisDTOS;
    }

//    @Override
//    public String toString() {
//        return "PatientDTO{" + "id=" + id + ", identifier='" + identifier + '\'' + ", name='" + name
//                + '\'' + ", gender='" + gender + '\'' + ", nation=" + nation + ", height=" + height
//                + ", weight=" + weight + ", smoke=" + smoke + ", drink=" + drink
//                + ", familyHistory=" + familyHistory + ", birthday=" + birthday + ", bmi=" + bmi
//                + ", degreeOfEducation='" + degreeOfEducation + '\'' + ", firstTimeLiverInjury='"
//                + firstTimeLiverInjury + '\'' + ", investigateHospital='" + investigateHospital
//                + '\'' + ", telephone='" + telephone + '\'' + ", durationOfVisit='"
//                + durationOfVisit + '\'' + ", firstVisitAge=" + firstVisitAge + ", firstVisitTime="
//                + firstVisitTime + ", smokeDrinkFamHis='" + smokeDrinkFamHis + '\''
//                + ", concurrentAutoDisease='" + concurrentAutoDisease + '\''
//                + ", concurrentAutoDate=" + concurrentAutoDate + ", conAutoDisFirstOrNot="
//                + conAutoDisFirstOrNot + ", complete=" + complete + '}';
//    }
}
