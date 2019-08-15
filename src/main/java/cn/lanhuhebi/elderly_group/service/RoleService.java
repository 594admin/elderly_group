package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.dao.RoleDao;

import java.util.List;

public interface RoleService {

    /**
     * 查询全部用户角色
     * @return
     */
    List<RoleDao> getListRoles();
}
