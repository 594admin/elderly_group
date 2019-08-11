package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.SysRoleAuth;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface SysRoleAuthDao {

	SysRoleAuth getSysRoleAuthById(@Param(value = "id") String id);

	Integer addSysRoleAuth(SysRoleAuth sysRoleAuth);

	Integer updateSysRoleAuth(SysRoleAuth sysRoleAuth);

	Integer delSysRoleAuthById(@Param(value = "id") String id);

}
