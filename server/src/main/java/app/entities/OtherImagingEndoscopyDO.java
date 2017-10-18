package app.entities;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by Administrator on 2017/10/17 0017.
 */
@Entity(name = "medicine_liver_other_imaging_endoscopy")
public class OtherImagingEndoscopyDO {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @ManyToOne(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST,CascadeType.DETACH,CascadeType.REFRESH,CascadeType.MERGE})
    @JoinColumn(name = "imaging_endoscopy_id")
    private MedicineLiverImagingEndoscopyDO medicineLiverImagingEndoscopyDO;
    private String item;
    private Date itemDate;
    private String result;
    private int biliaryTract;
    private int esophagealGastricVarices;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MedicineLiverImagingEndoscopyDO getMedicineLiverImagingEndoscopyDO() {
        return medicineLiverImagingEndoscopyDO;
    }

    public void setMedicineLiverImagingEndoscopyDO(MedicineLiverImagingEndoscopyDO medicineLiverImagingEndoscopyDO) {
        this.medicineLiverImagingEndoscopyDO = medicineLiverImagingEndoscopyDO;
    }

    public String getItem() {
        return item;
    }

    public void setItem(String item) {
        this.item = item;
    }

    public Date getItemDate() {
        return itemDate;
    }

    public void setItemDate(Date itemDate) {
        this.itemDate = itemDate;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public int getBiliaryTract() {
        return biliaryTract;
    }

    public void setBiliaryTract(int biliaryTract) {
        this.biliaryTract = biliaryTract;
    }

    public int getEsophagealGastricVarices() {
        return esophagealGastricVarices;
    }

    public void setEsophagealGastricVarices(int esophagealGastricVarices) {
        this.esophagealGastricVarices = esophagealGastricVarices;
    }
}

