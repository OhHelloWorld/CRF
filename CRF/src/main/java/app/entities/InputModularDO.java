package app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "input_modular")
public class InputModularDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String description;
    private int inputLength;
    private int inputLimit;
    private String unit;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getInputLength() {
        return inputLength;
    }

    public void setInputLength(int inputLength) {
        this.inputLength = inputLength;
    }

    public int getInputLimit() {
        return inputLimit;
    }

    public void setInputLimit(int inputLimit) {
        this.inputLimit = inputLimit;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }


}
