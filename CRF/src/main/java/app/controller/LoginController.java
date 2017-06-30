package app.controller;

/**
 * Created by 10210 on 2017/6/7.
 */

import app.dto.UserDTO;
import app.service.LoginService;
import io.swagger.annotations.Api;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.tomcat.util.codec.binary.Base64;



@RestController
@RequestMapping(path = "/api")
@Api(value = "登陆")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(path = "/login")
    public UserDTO login(@RequestHeader("Authorization") String authValue){
        String value = new String(Base64.decodeBase64(authValue));
        String account = value.split("#")[0];
        String password = value.split("#")[1];
        Subject subject = SecurityUtils.getSubject();

        try {
           UsernamePasswordToken token = new UsernamePasswordToken(account, password);
           subject.login(token);
           return loginService.getUserDTOByAccount(account);
        } catch (UnknownAccountException e) {
            e.printStackTrace();
            throw new UnknownAccountException("账号尚未注册！");
        } catch (IncorrectCredentialsException ice) {
            ice.printStackTrace();
            throw new IncorrectCredentialsException("密码输入错误!");
        } catch (LockedAccountException lae) {
            lae.printStackTrace();
            throw new LockedAccountException("您的账号已被禁用!");
        }

    }

    @GetMapping(path = "/logout")
    public void logout() {
        Subject subject = SecurityUtils.getSubject();
        subject.logout();
    }
}
