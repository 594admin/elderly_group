package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.RoleDao;
import cn.lanhuhebi.elderly_group.model.pojo.Role;
import cn.lanhuhebi.elderly_group.service.RoleService;
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
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleDao roleDao;

    public Role getRoleById(String id){
        return roleDao.getRoleById(id);
    }

    public Integer addRole(Role role){
            return roleDao.addRole(role);
    }

    public Integer updateRole(Role role){
        return roleDao.updateRole(role);
    }

    public Integer delRoleById(String id){
        return roleDao.delRoleById(id);
    }

}
