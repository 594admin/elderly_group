package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.RoleDao;
import cn.lanhuhebi.elderly_group.model.pojo.Role;
import cn.lanhuhebi.elderly_group.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Override
    public List<Role> getListRoles() {
        return roleDao.getListRoles();
    }

    @Override
    public Role getRole(Integer roleId) {
        return roleDao.getRole(roleId);
    }
}
