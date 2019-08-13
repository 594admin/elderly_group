package cn.lanhuhebi.elderly_group.config;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.session.mgt.SessionManager;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.filter.mgt.DefaultFilter;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author dxq
 * @date 2019-08-13 - 11:12
 */
@Configuration
public class ShiroConfig {

    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager securityManager, Map<String,String> filterChainDefinitionMap){
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //组装安全管理器
        shiroFilterFactoryBean.setSecurityManager(securityManager);
        //设置登录页
        shiroFilterFactoryBean.setLoginUrl("/pub/login");
        //设置登录成功跳转页面
        shiroFilterFactoryBean.setSuccessUrl("/");
        //没有权限，未授权就会调用此方法， 先验证登录  再验证是否有权限
        shiroFilterFactoryBean.setUnauthorizedUrl("/pub/not_permit");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);

        return shiroFilterFactoryBean;
    }

    /**
     * 安全管理器，Subject的认证和授权都要在安全管理器下进行
     * @return
     */
    @Bean
    public SecurityManager securityManager(PersonnelRealm personnelRealm){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        //设置sessionManager
        securityManager.setSessionManager(null);
        //设置数据域
        securityManager.setRealm(personnelRealm);

        return securityManager;
    }

    @Bean
    public Map<String,String> filterChainDefinitionMap(){

        // shiro 过滤器枚举类    DefaultFilter
        Map<String,String> filterChainDefinitionMap = new LinkedHashMap<>();
        filterChainDefinitionMap.put("/css/**", "anon");
        filterChainDefinitionMap.put("/docs/**", "anon");
        filterChainDefinitionMap.put("/fonts/**", "anon");
        filterChainDefinitionMap.put("/img/**", "anon");
        filterChainDefinitionMap.put("/js/**", "anon");
        filterChainDefinitionMap.put("/favicon.ico", "anon");

        //authc : url定义必须通过认证才可以访问
        //anon  : url可以匿名访问

        //登出拦截器
        filterChainDefinitionMap.put("/logout","logout");

        //匿名可以访问，也是就游客模式
        filterChainDefinitionMap.put("/pub/**","anon");

        //登录用户才可以访问
        filterChainDefinitionMap.put("/authc/**","authc");

        //管理员角色才可以访问
        filterChainDefinitionMap.put("/admin/**","roles[管理员]");

        //用户信息列表必须要有family_list权限
        filterChainDefinitionMap.put("/family/list","perms[family_list]");

        return filterChainDefinitionMap;

    }

    /**
     * 数据域，Shiro和安全数据的连接器通过realm获取认证授权相关信息
     * @param hashedCredentialsMatcher
     * @return
     */
    @Bean
    public PersonnelRealm personnelRealm(HashedCredentialsMatcher hashedCredentialsMatcher){
        PersonnelRealm personnelRealm = new PersonnelRealm();
        //设置加密器
        personnelRealm.setCredentialsMatcher(hashedCredentialsMatcher);
        return personnelRealm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher(){
        HashedCredentialsMatcher credentialsMatcher = new HashedCredentialsMatcher();
        //md5加密
        credentialsMatcher.setHashAlgorithmName("md5");
        //md5双重加密
        credentialsMatcher.setHashIterations(2);
        return credentialsMatcher;
    }

    /**
     * 会话管理器
     * @return
     */
    @Bean
    public SessionManager sessionManager(){
        CustomSeesionManager seesionManager = new CustomSeesionManager();
        //超时时间  默认30分钟会话过期，单位是毫秒
        //seesionManager.setGlobalSessionTimeout(20000);
        return seesionManager;
    }
}
