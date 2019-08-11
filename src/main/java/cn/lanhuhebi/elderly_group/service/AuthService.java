package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Auth;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface AuthService {

    Auth getAuthById(String id);

    Integer addAuth(Auth auth);

    Integer updateAuth(Auth auth);

    Integer delAuthById(String id);

}
