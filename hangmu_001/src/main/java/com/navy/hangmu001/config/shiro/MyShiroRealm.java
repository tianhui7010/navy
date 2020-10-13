package com.navy.hangmu001.config.shiro;

import com.navy.jianzaiji.model.user.User;
import com.navy.jianzaiji.service.sailor.UserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * Created by 52613 on 2019/11/26.
 */
public class MyShiroRealm extends AuthorizingRealm {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    UserService userService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {

        logger.debug("执行授权流程...");

        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();

        User user = (User) principalCollection.getPrimaryPrincipal();

        List<String> roles = userService.getRolesByUserId(user.getId());
        List<String> permissions = userService.getPermissionsByUserId(user.getId());

        info.addRoles(roles);
        info.addStringPermissions(permissions);
        return info;
    }

    //认证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

        System.out.println("开始认证...");
        //获取当前用户名
        String useraName = token.getPrincipal().toString();

        System.out.println("userService is "+userService);
        User user = userService.getByUserName(useraName);

        logger.debug("user is {}",user);
        if(ObjectUtils.isEmpty(user)){
            return null;
        }

        //这里会去校验密码是否正确
        SimpleAuthenticationInfo result = new SimpleAuthenticationInfo(
                user, //用户名
                user.getPassWord(),//密码
                getName()
        );
        logger.debug("result is "+result);
        return result;
    }
}
