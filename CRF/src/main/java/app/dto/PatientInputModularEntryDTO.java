package app.dto;

public class PatientInputModularEntryDTO {

    private int id;
    private int patientId;
    private int informationId;

    public int getInformationId() {
        return informationId;
    }

    public void setInformationId(int informationId) {
        this.informationId = informationId;
    }

    private int inputModularId;
    private String inputData;

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

    public int getInputModularId() {
        return inputModularId;
    }

    public void setInputModularId(int inputModularId) {
        this.inputModularId = inputModularId;
    }

    public String getInputData() {
        return inputData;
    }

    public void setInputData(String inputData) {
        this.inputData = inputData;
    }


}
