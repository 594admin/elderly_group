package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.common.constant.UserConstant;
import cn.lanhuhebi.elderly_group.dao.UserMapper;
import cn.lanhuhebi.elderly_group.model.pojo.domain.User;
import cn.lanhuhebi.elderly_group.service.UserService;
import cn.lanhuhebi.elderly_group.utils.loginUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

/**
 * @author dxq
 * @date 2019-08-13 - 21:08
 */
@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;


    @Override
    public User getAllUserInfoByUsername(String userName) {
        if (StringUtils.isEmpty(userName) ){
            throw new RuntimeException("用户名密码为空");
        }

        User user = null;
        if (loginUtils.maybeMobilePhoneNumber(userName)){
            user = userMapper.selectUserByPhone(userName);
        }

        if (loginUtils.maybeEmail(userName)){
            user = userMapper.selectUserByEmail(userName);
        }

        if (user == null){
            throw new RuntimeException("用户不存在");
        }

        if (user.getPreStatus() == UserConstant.USER_BLOCKED){
            throw new RuntimeException("封禁账号");
        }
        return user;
    }

}
