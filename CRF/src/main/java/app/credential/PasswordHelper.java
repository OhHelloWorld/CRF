package app.credential;

import app.entities.UserDO;
import org.apache.shiro.crypto.SecureRandomNumberGenerator;
import org.apache.shiro.crypto.hash.SimpleHash;

/**
 * Created by 52400 on 2017/6/20.
 */
public class PasswordHelper {

    private SecureRandomNumberGenerator srn = new SecureRandomNumberGenerator();

    private String algorithmName = "md5";

    private int hashIterations = 2;

    //用MD5加密密码
    public void encrypUserPassword(UserDO userDO) {
        userDO.setSalt(srn.nextBytes().toHex());
        String newPassword = new SimpleHash(algorithmName, userDO.getPassword(),
                userDO.getCredentialSalt(), hashIterations).toHex();
        userDO.setPassword(newPassword);
    }


    //重新设置密码，加密
    public String encrypPasswordForReset(UserDO userDO, String password) {
        String newPassword =
                new SimpleHash(algorithmName, password, userDO.getCredentialSalt(), hashIterations)
                        .toHex();
        return newPassword;
    }
}
