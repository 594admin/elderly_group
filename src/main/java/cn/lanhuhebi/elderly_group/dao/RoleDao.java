package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Role;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface RoleDao {

	Role getRoleById(@Param(value = "id") String id);

	Integer addRole(Role role);

	Integer updateRole(Role role);

	Integer delRoleById(@Param(value = "id") String id);

}
