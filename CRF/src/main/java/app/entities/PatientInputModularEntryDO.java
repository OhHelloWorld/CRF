package app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = " patient_input_modular_entry")
@Entity
public class PatientInputModularEntryDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
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
