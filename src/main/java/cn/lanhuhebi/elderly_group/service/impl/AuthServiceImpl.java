package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.AuthDao;
import cn.lanhuhebi.elderly_group.model.pojo.Auth;
import cn.lanhuhebi.elderly_group.service.AuthService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
@Service
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthDao authDao;

    public Auth getAuthById(String id){
        return authDao.getAuthById(id);
    }

    public Integer addAuth(Auth auth){
            return authDao.addAuth(auth);
    }

    public Integer updateAuth(Auth auth){
        return authDao.updateAuth(auth);
    }

    public Integer delAuthById(String id){
        return authDao.delAuthById(id);
    }

}
