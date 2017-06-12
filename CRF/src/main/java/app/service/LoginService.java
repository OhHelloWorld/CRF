package app.service;

import org.springframework.web.bind.annotation.RequestBody;

/**
 * Created by 10210 on 2017/6/7.
 */
public interface LoginService {

    public boolean inputCompareToDatabase(String account, String password);

}
