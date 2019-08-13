package cn.lanhuhebi.elderly_group.config;

import cn.lanhuhebi.elderly_group.model.pojo.domain.User;
import cn.lanhuhebi.elderly_group.service.UserService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 自定义Realm
 * 继承AuthorizingRealm 类 重写 doGetAuthorizationInfo doGetAuthenticationInfo 处理登录 权限
 * @author dxq
 * @date 2019-08-13 - 18:27
 */
public class PersonnelRealm extends AuthorizingRealm {

    @Resource
    private UserService userService;

    private final Logger logger = LoggerFactory.getLogger(PersonnelRealm.class);
    /**
     * 进行权限校验的时候会调用: doGetAuthorizationInfo
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("=========================权限认证=========================");
        String username = (String) principals.getPrimaryPrincipal();
        User user = userService.getAllUserInfoByUsername(username);
        String role = user.getRole().getRoleName();
        List<String> permissions = new ArrayList<>();
        user.getAuths().forEach(x -> permissions.add(x.getAuthName()));
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.addRole(role);
        simpleAuthorizationInfo.addStringPermissions(permissions);
        return simpleAuthorizationInfo;
    }

    /**
     * 用户登陆认证 调用doGetAuthenticationInfo
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        logger.info("=========================登录认证=========================");
        UsernamePasswordToken usernamePasswordToken = (UsernamePasswordToken) token;

        String userName = usernamePasswordToken.getUsername();

        User user =  userService.getAllUserInfoByUsername(userName);

        String password = user.getPrePassword();

        if (password == null || "".equals(password)){
            return null;
        }

        return new SimpleAuthenticationInfo(user,password,getName());
    }
}
