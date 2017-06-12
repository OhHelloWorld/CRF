package app.controller;

/**
 * Created by 10210 on 2017/6/7.
 */

import app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.tomcat.util.codec.binary.Base64;
@RestController
@RequestMapping(path = "api")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping(path = "/login")
    public boolean login(@RequestHeader("Authorization") String authValue){
        String value = new String(Base64.decodeBase64(authValue));
        String account = value.split("#")[0];
        String password = value.split("#")[1];
        return loginService.inputCompareToDatabase(account, password);
    }
}
