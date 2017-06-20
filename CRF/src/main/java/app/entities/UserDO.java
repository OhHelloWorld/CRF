package app.entities;

import javax.persistence.*;

@Entity
@Table(name = "users")
public class UserDO {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String realName;
    private String userName;
    private String account;
    private String password;
    private String salt;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private SysRoleDO roleDO;

    public SysRoleDO getRoleDO() {
        return roleDO;
    }

    public void setRoleDO(SysRoleDO roleDO) {
        this.roleDO = roleDO;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
}
