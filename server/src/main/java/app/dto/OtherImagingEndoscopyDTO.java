package app.dto;

import java.util.Date;

/**
 * Created by Administrator on 2017/10/17 0017.
 */
public class OtherImagingEndoscopyDTO {

    private int id;
    private int imagingEndoscopyId;
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

    public int getImagingEndoscopyId() {
        return imagingEndoscopyId;
    }

    public void setImagingEndoscopyId(int imagingEndoscopyId) {
        this.imagingEndoscopyId = imagingEndoscopyId;
    }
}
