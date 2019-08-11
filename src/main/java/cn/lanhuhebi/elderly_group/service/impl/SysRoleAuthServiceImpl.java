package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.SysRoleAuthDao;
import cn.lanhuhebi.elderly_group.model.pojo.SysRoleAuth;
import cn.lanhuhebi.elderly_group.service.SysRoleAuthService;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
@Service
public class SysRoleAuthServiceImpl implements SysRoleAuthService {

    @Resource
    private SysRoleAuthDao sysRoleAuthDao;

    public SysRoleAuth getSysRoleAuthById(String id){
        return sysRoleAuthDao.getSysRoleAuthById(id);
    }

    public Integer addSysRoleAuth(SysRoleAuth sysRoleAuth){
            return sysRoleAuthDao.addSysRoleAuth(sysRoleAuth);
    }

    public Integer updateSysRoleAuth(SysRoleAuth sysRoleAuth){
        return sysRoleAuthDao.updateSysRoleAuth(sysRoleAuth);
    }

    public Integer delSysRoleAuthById(String id){
        return sysRoleAuthDao.delSysRoleAuthById(id);
    }

}
