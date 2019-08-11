package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.SysRoleAuth;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface SysRoleAuthService {

    SysRoleAuth getSysRoleAuthById(String id);

    Integer addSysRoleAuth(SysRoleAuth sysRoleAuth);

    Integer updateSysRoleAuth(SysRoleAuth sysRoleAuth);

    Integer delSysRoleAuthById(String id);

}
