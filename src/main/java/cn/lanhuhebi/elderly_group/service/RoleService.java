package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Role;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface RoleService {

    Role getRoleById(String id);

    Integer addRole(Role role);

    Integer updateRole(Role role);

    Integer delRoleById(String id);

}
