package cn.edu.jxnu.rj.lrf.config.shiro;

import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import java.util.HashMap;
import java.util.Map;

/**
 * @Classname ShiroConfig
 * @Description TODO Shiro配置类
 * @Date 2021/5/12 22:48
 * @Created by 刘荣飞
 */
@Configuration
public class ShiroConfig {
    @Bean
    public ShiroFilterFactoryBean shiroFilterFactoryBean(SecurityManager manager){
        ShiroFilterFactoryBean filter = new ShiroFilterFactoryBean();
        //给filter设置安全管理器
        filter.setSecurityManager(manager);

        Map<String, String> map = new HashMap<>();
        //公共资源
        map.put("/**","anon");
        map.put("/util","anon");
        map.put("/user/login","anon");
        map.put("/user/register","anon");
        //受限资源
        map.put("/user/status","authc");
        map.put("/user/logout","authc");
        map.put("/friend/**","authc");

        filter.setFilterChainDefinitionMap(map);
        //配置默认认证界面,即无权访问受限资源时会自动跳转这个请求
        filter.setLoginUrl("/response/NotLogin");
        return filter;
    }

    @Bean
    public DefaultWebSecurityManager manager(Realm realm){
        DefaultWebSecurityManager manager = new DefaultWebSecurityManager();
        manager.setRealm(realm);
        return manager;
    }

    @Bean
    public Realm realm(){
        CustomerRealm realm = new CustomerRealm();
        //设置密码比较器
        HashedCredentialsMatcher matcher = new HashedCredentialsMatcher();
        //设置比较器hash算法为md5,散列次数为1024
        matcher.setHashAlgorithmName("MD5");
        matcher.setHashIterations(1024);
        realm.setCredentialsMatcher(matcher);
        return realm;
    }
}
