package app.dto;

/**
 * Created by Administrator on 2017/8/24 0024.
 */
public class MedicineLiverBiologicalSamplesDTO {

    private int id;
    private int patientId;
    private int biologicalSamples;//是否留置
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

    public int getBiologicalSamples() {
        return biologicalSamples;
    }

    public void setBiologicalSamples(int biologicalSamples) {
        this.biologicalSamples = biologicalSamples;
    }

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }
}
