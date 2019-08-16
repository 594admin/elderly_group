package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface RoleService {

    /**
     * 查询全部用户角色
     * @return
     */
    List<Role> getListRoles();

    /**
     * 根据id 查询出角色资料
     * @param roleId
     * @return
     */
    Role getRole(@Param("roleId")Integer roleId);
}
