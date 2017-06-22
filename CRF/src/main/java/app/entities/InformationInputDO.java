package app.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "information_input")
@Entity
public class InformationInputDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private int informationId;
    private int inputModularId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getInformationId() {
        return informationId;
    }

    public void setInformationId(int informationId) {
        this.informationId = informationId;
    }

    public int getInputModularId() {
        return inputModularId;
    }

    public void setInputModularId(int inputModularId) {
        this.inputModularId = inputModularId;
    }


}
