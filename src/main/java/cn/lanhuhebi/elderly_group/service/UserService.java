package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.pojo.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author dxq
 * @date 2019-08-13 - 21:07
 */
public interface UserService {

    User getAllUserInfoByUsername(String userName);
}
