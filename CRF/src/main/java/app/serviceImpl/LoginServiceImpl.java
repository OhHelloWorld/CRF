package app.serviceImpl;

import app.entities.UserDO;
import app.repo.LoginRepo;
import app.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by 10210 on 2017/6/7.
 */
@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginRepo loginRepo;


    @Override
    public boolean inputCompareToDatabase(String account, String password) {
        List<UserDO> user = loginRepo.inputCompareToDatabase(account, password);
        if(user.size() == 0){
            return false;
        }
        return true;
    }
}
