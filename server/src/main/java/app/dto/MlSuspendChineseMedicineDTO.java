package app.dto;

/**
 * Created by Administrator on 2017/10/23 0023.
 */
public class MlSuspendChineseMedicineDTO {

    private int id;
    private int mlDrugId;
    private String susName;
    private String sample;
    private String number;
    private String susCategory;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getMlDrugId() {
        return mlDrugId;
    }

    public void setMlDrugId(int mlDrugId) {
        this.mlDrugId = mlDrugId;
    }

    public String getSusName() {
        return susName;
    }

    public void setSusName(String susName) {
        this.susName = susName;
    }

    public String getSample() {
        return sample;
    }

    public void setSample(String sample) {
        this.sample = sample;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getSusCategory() {
        return susCategory;
    }

    public void setSusCategory(String susCategory) {
        this.susCategory = susCategory;
    }
}
