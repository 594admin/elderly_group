package cn.lanhuhebi.elderly_group.util;

import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.model.pojo.Role;
import cn.lanhuhebi.elderly_group.service.PersonnelService;
import cn.lanhuhebi.elderly_group.service.RoleService;
import cn.lanhuhebi.elderly_group.service.impl.PersonnelServiceImpl;
import cn.lanhuhebi.elderly_group.service.impl.RoleServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

import java.util.Set;

public class MyRealm extends AuthorizingRealm  {

    private PersonnelService personnelService;
    private RoleService roleService;

    @Override//权限认证的方法
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        roleService = (RoleServiceImpl)ApplicationContextHelper.getBean("RoleServiceImpl");
        //获取当前用户
        Personnel personnel =   (Personnel)principalCollection.getPrimaryPrincipal();
        //查询出当前用户的所有权限
        Set<String> strings = roleService.addStringPermissions(personnel.getPreRoleId());
        //获得用户角色
        Role role = roleService.getRole(personnel.getPreRoleId());
        //通过SimpleAuthenticationInfo做授权
        SimpleAuthorizationInfo simpleAuthorizationInfo=new SimpleAuthorizationInfo();
        //添加角色
        simpleAuthorizationInfo.addRole(String.valueOf(role.getRoleId()));
        //添加权限
        simpleAuthorizationInfo.addStringPermissions(strings);
        return simpleAuthorizationInfo;
    }

    @Override //登录的处理方法
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //new员工的service实现类
        personnelService = (PersonnelServiceImpl) ApplicationContextHelper.getBean("PersonnelServiceImpl");
        UsernamePasswordToken token=(UsernamePasswordToken) authenticationToken;
        Personnel personnel = new Personnel();
        if(!token.getUsername().equals("")){
            //根据账户名查询出一条数据
            personnel = personnelService.login(token.getUsername());
        }
        //判断用户是否为空
        if(null == personnel){
            return null;
        }else if(personnel.getPreStatus()==0){
            throw new AuthenticationException("账号被禁用,请联系管理员");
        }else{
            //将对象，对象密码，和这个shiro内的唯一名字交给simpleAuthenticationInfo对象
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(personnel,personnel.getPrePassword(),getName());
            //返回这个对象
            return simpleAuthenticationInfo;
        }
    }
}
