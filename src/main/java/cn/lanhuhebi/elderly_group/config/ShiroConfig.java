package cn.lanhuhebi.elderly_group.config;

import cn.lanhuhebi.elderly_group.util.MyRealm;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.aop.framework.autoproxy.DefaultAdvisorAutoProxyCreator;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
@Component
public class ShiroConfig {

    @Bean //2.1.建立shiroFilter Bean--->设置securityManager并且把请求规则加入Filter过滤链中
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager){
        ShiroFilterFactoryBean bean = new ShiroFilterFactoryBean();
        bean.setSecurityManager(securityManager);
        //配置拦截链 使用LinkedHashMap,因为LinkedHashMap是有序的，shiro会根据添加的顺序           进行拦截
        // Map<K,V> K指的是拦截的url V值的是该url是否拦截
        // 配置不会被拦截的链接 顺序判断
        Map<String,String> filterMap=new LinkedHashMap<>();
        //配置退出过滤器logout，由shiro实现
        filterMap.put("/logout","logout");
        filterMap.put("/css/**", "anon");
        filterMap.put("/docs/**", "anon");
        filterMap.put("/fonts/**", "anon");
        filterMap.put("/img/**", "anon");
        filterMap.put("/js/**", "anon");
        filterMap.put("/aaa", "anon");
        filterMap.put("/bbb", "anon");
        filterMap.put("/iii", "anon");//安装列表
        filterMap.put("/eee", "anon");//安装一个的地址
        filterMap.put("/ppp", "anon");//安装设备明细
        filterMap.put("/favicon.ico", "anon");
        filterMap.put("/messenger/*", "anon");
        filterMap.put("/address/*", "anon");
        filterMap.put("/fail", "anon");
        filterMap.put("/upLoadImg", "anon");
        //测试权限
        filterMap.put("/test", "anon");
        filterMap.put("/doAuth", "anon");

        //authc:所有url都必须认证通过才可以访问; anon:所有url都都可以匿名访问,先配置anon再配置authc。
        filterMap.put("/","anon");

        filterMap.put("/doLogin","anon");
        //<!-- 过滤链定义，从上向下顺序执行，一般将/**放在最为下边 -->:这是一个坑呢，一不小心代码就不好使了;
        filterMap.put("/**","authc");
        // loginUrl：没有登录的用户请求需要登录的页面时自动跳转到登录页面。
        bean.setLoginUrl("/");
        //successUrl：登录成功默认跳转页面，不配置则跳转至”/”，可以不配置，直接通过代码进行处理。
        bean.setSuccessUrl("/info");

        //unauthorizedUrl：没有权限默认跳转的页面，登录的用户访问了没有被授权的资源自动跳转到的页面。
        bean.setUnauthorizedUrl("/notauth");

        bean.setFilterChainDefinitionMap(filterMap);
        return bean;
    }

    //给SecurityManager设置需要管理的Realm,可以有多个Realm
    @Bean
    public SecurityManager securityManager(){
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(new MyRealm());
        return securityManager;
    }



    /**
     * 开启aop注解支持
     */
    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager){
        AuthorizationAttributeSourceAdvisor attributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        //设置安全管理器
        attributeSourceAdvisor.setSecurityManager(securityManager);
        return attributeSourceAdvisor;
    }
    @Bean
    @ConditionalOnMissingBean
    public DefaultAdvisorAutoProxyCreator defaultAdvisorAutoProxyCreator() {
        DefaultAdvisorAutoProxyCreator defaultAAP = new DefaultAdvisorAutoProxyCreator();
        defaultAAP.setProxyTargetClass(true);
        return defaultAAP;
    }


}
