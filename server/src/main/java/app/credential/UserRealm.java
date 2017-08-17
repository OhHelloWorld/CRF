package app.credential;

import app.entities.UserDO;
import app.service.LoginService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by 52400 on 2017/6/20.
 */

@Component
public class UserRealm extends AuthorizingRealm {


    @Autowired
    private LoginService loginService;

    //配置登陆realm的基本信息
    public UserRealm() {
        setName("userRealm");
        HashedCredentialsMatcher hcm = new HashedCredentialsMatcher();
        hcm.setHashIterations(2);
        hcm.setHashAlgorithmName("md5");
        hcm.setStoredCredentialsHexEncoded(true);
        setCredentialsMatcher(hcm);
    }




    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String account = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        authorizationInfo.setRoles(loginService.listRole(account));
        authorizationInfo.setStringPermissions(loginService.listPermission(account));
        return authorizationInfo;

    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String account = (String) authenticationToken.getPrincipal();
        UserDO userInfo = loginService.getUserDOByAccount(account);
        SimpleAuthenticationInfo simpleAuthenticationInfo =
                new SimpleAuthenticationInfo(
                        account,
                        userInfo.getPassword(),
                        ByteSource.Util.bytes(userInfo.getCredentialSalt()),
                        getName());
        return simpleAuthenticationInfo;

    }
}
