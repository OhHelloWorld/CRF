package app.dto;

import java.util.List;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
public class MedicineLiverSuspectedDrugDTO {
    private int id;
    private int patientId;
    private boolean complete;
    private List<MedicineLiverSuspectedDrugDetailDTO> medicineLiverSuspectedDrugDetailDTOS;

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

    public boolean isComplete() {
        return complete;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public List<MedicineLiverSuspectedDrugDetailDTO> getMedicineLiverSuspectedDrugDetailDTOS() {
        return medicineLiverSuspectedDrugDetailDTOS;
    }

    public void setMedicineLiverSuspectedDrugDetailDTOS(List<MedicineLiverSuspectedDrugDetailDTO> medicineLiverSuspectedDrugDetailDTOS) {
        this.medicineLiverSuspectedDrugDetailDTOS = medicineLiverSuspectedDrugDetailDTOS;
    }
}
