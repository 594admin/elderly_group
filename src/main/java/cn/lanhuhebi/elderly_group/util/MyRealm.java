package cn.lanhuhebi.elderly_group.util;

import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.service.PersonnelService;
import cn.lanhuhebi.elderly_group.service.impl.PersonnelServiceImpl;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;

public class MyRealm extends AuthorizingRealm  {

    private PersonnelService personnelService;

    @Override//权限认证的方法，暂时未写
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
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
        }else{
            //将对象，对象密码，和这个shiro内的唯一名字交给simpleAuthenticationInfo对象
            SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(personnel,personnel.getPrePassword(),getName());
            //返回这个对象
            return simpleAuthenticationInfo;
        }
    }
}
