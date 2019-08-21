package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.dto.RoleListVo;
import cn.lanhuhebi.elderly_group.model.pojo.Auth;
import cn.lanhuhebi.elderly_group.model.pojo.Role;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

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

    /**
     * 新增角色
     * @param roleName
     * @return
     */
    boolean addRole(String roleName);


    /**
     * 根据角色名查询一条数据
     * @param roleName
     * @return
     */
    boolean getRoleByroleName(String roleName);

    /**
     * 进入角色列表展示视图
     * @return
     */
    List<RoleListVo> getListRoleAndAuth();


    /**
     *  根据角色id查询一个角色的所有权限，菜单及权限分配
     */
    List<Auth> getSysRoleAuthByRoleId(Integer rlId);

    /**
     * 修改用户角色权限
     * @param authId
     * @param roleId
     * @return
     */
    Integer[] updateAUthsByRoleId(Set<Integer> authId, Integer roleId);


    /**
     * 查询角色权限用于权限认证
     * @param roleId
     * @return
     */
    Set<String> addStringPermissions(Integer roleId);

}
