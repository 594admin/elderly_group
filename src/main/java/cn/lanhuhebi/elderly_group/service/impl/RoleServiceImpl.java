package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.RoleDao;
import cn.lanhuhebi.elderly_group.model.dto.RoleListVo;
import cn.lanhuhebi.elderly_group.model.pojo.Auth;
import cn.lanhuhebi.elderly_group.model.pojo.Role;
import cn.lanhuhebi.elderly_group.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service("RoleServiceImpl")
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

    @Override
    public boolean addRole(String roleName) {
        return roleDao.addRole(roleName)>0;
    }

    @Override
    public boolean getRoleByroleName(String roleName) {
        return roleDao.getRoleByroleName(roleName)!=null;
    }

    @Override
    public List<RoleListVo> getListRoleAndAuth() {
        List<RoleListVo> roleListVos = new ArrayList<>();
        List<Role> listRoles = getListRoles();
        for(Role r :listRoles){
            RoleListVo  roles = new RoleListVo();
            roles.setRlName(r.getRoleName());
            roles.setRlId(r.getRoleId());
            List<Auth> authByRole = roleDao.getAuthByRoleID(r.getRoleId());
            for(Auth a:authByRole){
                if(a.getAuthDuan()==2){
                    roles.getMobileMenu().add(a.getAuthName());
                }else {
                    roles.getClientMenu().add(a.getAuthName());
                }
            }
            roleListVos.add(roles);

        }
        return roleListVos;
    }

    @Override
    public List<Auth> getSysRoleAuthByRoleId(Integer rlId) {
        return roleDao.getSysRoleAuthByRoleId(rlId);
    }

    @Override
    public Integer[] updateAUthsByRoleId(Set<Integer> authId, Integer roleId) {
        Integer[] msg = new Integer[2];
        Set<Integer> repeat = roleDao.repeatSysRoleAuthByRoleId(roleId);
        Set<Integer> calculation = new HashSet<>();

        //需要添加的数据，数据库没有的
        calculation.clear();
        calculation.addAll(authId);
        calculation.removeAll(repeat);
        if(calculation.size()>0){
            //新增成功多少条
            msg[0] = roleDao.addAuthsByRoleId(calculation, roleId);
        }else{
            msg[0] = 0;
        }
        //需要删除的数据，
        calculation.clear();
        calculation.addAll(repeat);
        calculation.removeAll(authId);
        if(calculation.size()>0){
            //删除成功多少条
            msg[1] = roleDao.deleteAuthsByRoleId(calculation, roleId);
        }else{
            msg[1] = 0;
        }



        return msg;
    }

    @Override
    public Set<String> addStringPermissions(Integer roleId) {
        Set<Integer> integers = roleDao.repeatSysRoleAuthByRoleId(roleId);
        Set<String> strings = new HashSet<>();
        for(int i: integers){
            strings.add(String.valueOf(i));
        }
        return strings;
    }

}
