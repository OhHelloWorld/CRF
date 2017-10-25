package app.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
@Entity(name = "medicine_liver_suspected_drug")
public class MedicineLiverSuspectedDrugDO {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int patientId;
    private boolean complete;
    @OneToMany(mappedBy = "medicineLiverSuspectedDrugDO",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MedicineLiverSuspectedDrugDetailDO> medicineLiverSuspectedDrugDetailDOS;
    @OneToMany(mappedBy = "mlSuspectedDrugDO",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MlProprietaryChineseMedicineDO> mlProprietaryChineseMedicineDOS;
    @OneToMany(mappedBy = "mlSuspectedDrugDO",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MlChineseHerbalMedicineDO> mlChineseHerbalMedicineDOS;
    @OneToMany(mappedBy = "mlSuspectedDrugDO",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private List<MlSuspendChineseMedicineDO> mlSuspendChineseMedicineDOS;

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

    public List<MedicineLiverSuspectedDrugDetailDO> getMedicineLiverSuspectedDrugDetailDOS() {
        return medicineLiverSuspectedDrugDetailDOS;
    }

    public void setMedicineLiverSuspectedDrugDetailDOS(List<MedicineLiverSuspectedDrugDetailDO> medicineLiverSuspectedDrugDetailDOS) {
        this.medicineLiverSuspectedDrugDetailDOS = medicineLiverSuspectedDrugDetailDOS;
    }

    public List<MlProprietaryChineseMedicineDO> getMlProprietaryChineseMedicineDOS() {
        return mlProprietaryChineseMedicineDOS;
    }

    public void setMlProprietaryChineseMedicineDOS(List<MlProprietaryChineseMedicineDO> mlProprietaryChineseMedicineDOS) {
        this.mlProprietaryChineseMedicineDOS = mlProprietaryChineseMedicineDOS;
    }

    public List<MlChineseHerbalMedicineDO> getMlChineseHerbalMedicineDOS() {
        return mlChineseHerbalMedicineDOS;
    }

    public void setMlChineseHerbalMedicineDOS(List<MlChineseHerbalMedicineDO> mlChineseHerbalMedicineDOS) {
        this.mlChineseHerbalMedicineDOS = mlChineseHerbalMedicineDOS;
    }

    public List<MlSuspendChineseMedicineDO> getMlSuspendChineseMedicineDOS() {
        return mlSuspendChineseMedicineDOS;
    }

    public void setMlSuspendChineseMedicineDOS(List<MlSuspendChineseMedicineDO> mlSuspendChineseMedicineDOS) {
        this.mlSuspendChineseMedicineDOS = mlSuspendChineseMedicineDOS;
    }
}
