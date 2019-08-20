package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.pojo.Auth;
import cn.lanhuhebi.elderly_group.model.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface RoleDao {
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

    /**
     * 新增角色
     * @param roleName
     * @return
     */
    int addRole(@Param("roleName")String roleName);

    /**
     * 根据角色名查询一条数据
     * @param roleName
     * @return
     */
    Role getRoleByroleName(@Param("roleName")String roleName);

    /**
     * 查询所有角色的权限
     * @return
     */
    List<Role> getAuths();

    /**
     * 根据id查询一个角色的菜单权限
     */
    List<Auth> getAuthByRoleID(@Param("rlId")Integer rlId);

    /**
     *  根据角色id查询一个角色的所有权限，菜单及权限分配
     */
    List<Auth> getSysRoleAuthByRoleId(@Param("rlId")Integer rlId);

    /**
     * 批量添加用户权限
     * @param collection
     * @return
     */
    int addAuthsByRoleId(Set<Integer> collection,@Param("roleId")Integer roleId);

    /**
     * 批量删除用户权限
     * @param collection
     * @param roleId
     * @return
     */
    int deleteAuthsByRoleId(Set<Integer> collection,@Param("roleId")Integer roleId);

    /**
     * 查询角色下是否重复
     * @param roleId
     * @return
     */
    Set<Integer> repeatSysRoleAuthByRoleId(@Param("roleId")Integer roleId);


}
