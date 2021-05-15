package cn.edu.jxnu.rj.lrf.config.shiro;

import cn.edu.jxnu.rj.lrf.entity.User;
import cn.edu.jxnu.rj.lrf.service.UserService;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @Classname MyRealm
 * @Description TODO
 * @Date 2021/5/12 22:41
 * @Created by 刘荣飞
 */
public class CustomerRealm extends AuthorizingRealm {
    @Autowired
    UserService userService;

    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取主身份信息
        User user = (User) principalCollection.getPrimaryPrincipal();
        System.out.println("principal:"+user.getUserName());
        if("13304116773".equals(user.getUserPhone())){
            SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
            authorizationInfo.addRole("user");
            authorizationInfo.addStringPermission("user:find:*");
            return authorizationInfo;
        }
        System.out.println("进行认证");
        return null;
    }

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        //从token中获取用户名
        String userPhone = (String)authenticationToken.getPrincipal();

        //根据身份信息查询MySQL中的身份信息记录
        User user = userService.findByUserPhone(userPhone);
        if(!ObjectUtils.isEmpty(user)){
            System.out.println("这是认证环节,认证成功");
            return new SimpleAuthenticationInfo(user,user.getUserPassword(), ByteSource.Util.bytes(user.getSalt()),getName());
        }

        System.out.println("认证失败");
        return null;
    }
}
