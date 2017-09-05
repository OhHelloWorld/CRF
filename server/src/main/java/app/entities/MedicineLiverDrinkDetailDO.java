package app.entities;

import javax.persistence.*;

/**
 * Created by Administrator on 2017/8/23 0023.
 */
@Entity(name = "medicine_liver_drink_detail")
public class MedicineLiverDrinkDetailDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinColumn(name = "medicine_liver_drink_id")
    private MedicineLiverDrinkDO medicineLiverDrinkDO;
    private String drinkType;//饮酒种类
    private String drinkQuantity;//饮酒数量
    private String drinkLife;//饮酒年限
        private String proof;//酒精精度

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicineLiverDrinkDO getMedicineLiverDrinkDO() {
        return medicineLiverDrinkDO;
    }

    public void setMedicineLiverDrinkDO(MedicineLiverDrinkDO medicineLiverDrinkDO) {
        this.medicineLiverDrinkDO = medicineLiverDrinkDO;
    }

    public String getDrinkType() {
        return drinkType;
    }

    public void setDrinkType(String drinkType) {
        this.drinkType = drinkType;
    }

    public String getDrinkQuantity() {
        return drinkQuantity;
    }

    public void setDrinkQuantity(String drinkQuantity) {
        this.drinkQuantity = drinkQuantity;
    }

    public String getDrinkLife() {
        return drinkLife;
    }

    public void setDrinkLife(String drinkLife) {
        this.drinkLife = drinkLife;
    }

    public String getProof() {
        return proof;
    }

    public void setProof(String proof) {
        this.proof = proof;
    }
}
