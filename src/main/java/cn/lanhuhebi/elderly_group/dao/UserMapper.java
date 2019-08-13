package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.pojo.domain.User;
import org.apache.ibatis.annotations.Param;

/**
 * @author dxq
 * @date 2019-08-13 - 11:02
 */
public interface UserMapper {

    User selectUserByPhone(@Param("phone")String phone);

    User selectUserByEmail(@Param("email")String email);
}
