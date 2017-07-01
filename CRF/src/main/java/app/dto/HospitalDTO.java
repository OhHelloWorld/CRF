package app.dto;

/**
 * Created by 52400 on 2017/6/21.
 */
public class HospitalDTO {

    private Long id;

    private String hospitalName;

    private String address;

    private String addressDetail;

    private String telephone;

    private String specialMajor;

    private String manageRange;

    private String image_url;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public void setHospitalName(String hospitalName) {
        this.hospitalName = hospitalName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddressDetail() {
        return addressDetail;
    }

    public void setAddressDetail(String addressDetail) {
        this.addressDetail = addressDetail;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public String getSpecialMajor() {
        return specialMajor;
    }

    public void setSpecialMajor(String specialMajor) {
        this.specialMajor = specialMajor;
    }

    public String getManageRange() {
        return manageRange;
    }

    public void setManageRange(String manageRange) {
        this.manageRange = manageRange;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }
}
