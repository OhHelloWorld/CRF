package app.entities;

import javax.persistence.*;

@Entity
@Table(name = "user")
public class UserDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String realName;
    private String account;
    private String password;
    private String salt;

    @ManyToOne
    @JoinColumn(name = "sys_role_id")
    private SysRoleDO sysRoleDO;

    @ManyToOne
    @JoinColumn(name = "hospital_id")
    private HospitalDO hospital;//多个用户对应一个医院

    public SysRoleDO getSysRoleDO() {
        return sysRoleDO;
    }

    public void setSysRoleDO(SysRoleDO sysRoleDO) {
        this.sysRoleDO = sysRoleDO;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAccount(String account) {
        this.account = account;
    }

    public String getAccount() {
        return this.account;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getCredentialSalt() {
        return account + salt;
    }

    public HospitalDO getHospital() {
        return hospital;
    }

    public void setHospital(HospitalDO hospital) {
        this.hospital = hospital;
    }
}
