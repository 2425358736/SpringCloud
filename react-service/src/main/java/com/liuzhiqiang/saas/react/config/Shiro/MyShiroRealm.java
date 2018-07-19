package com.liuzhiqiang.saas.react.config.Shiro;

/**
 * Created by JJJ on 2017/9/19.
 */
import com.liuzhiqiang.saas.react.dao.sys.SysUserMapper;
import com.liuzhiqiang.saas.react.domain.sys.SysUser;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.SimplePrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.Set;

/**
 *
 * shiro 认证 + 授权   重写
 *@author MyShiroRealm
 */
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    public SysUserMapper sysUserService;

    public MyShiroRealm() {
        super();
    }
    /**
     *  认证信息，主要针对用户登录，
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(
            AuthenticationToken authcToken) throws AuthenticationException {
        UsernamePasswordToken utoken=(UsernamePasswordToken) authcToken;
        SysUser sysUser = new SysUser();
        sysUser.setPhone(utoken.getUsername());
        sysUser.setPassWord(new String(utoken.getPassword()));
        //根据账号密码查用户信息
        SysUser user = sysUserService.verificationUser(sysUser);
//        user.setPassWord(user.getPassWord());
        if(null == user){
            throw new AccountException("手机或密码不正确！");
            /**
             * 如果用户的status为禁用。那么就抛出<code>DisabledAccountException</code>
             */
        }else if (2 == user.getLoginFlag()) {
            //用户被关闭
            throw new DisabledAccountException("账号被关闭！");
        }
        return new SimpleAuthenticationInfo(user, user.getPassWord(),this.getClass().getName());
    }

    /**
     * 授权
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {

        SimpleAuthorizationInfo info =  new SimpleAuthorizationInfo();
        SysUser userInfo  = (SysUser)principals.getPrimaryPrincipal();
        //根据用户ID查询权限（permission），放入到Authorization里。
        Set<String> permissions = sysUserService.findPermissionByUserId(userInfo.getId());
        info.setStringPermissions(permissions);
        return info;
    }
    /**
     * 清空当前用户权限信息
     */
    public  void clearCachedAuthorizationInfo() {
        PrincipalCollection principalCollection = SecurityUtils.getSubject().getPrincipals();
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
    /**
     * 指定principalCollection 清楚
     */
    @Override
    public void clearCachedAuthorizationInfo(PrincipalCollection principalCollection) {
        SimplePrincipalCollection principals = new SimplePrincipalCollection(
                principalCollection, getName());
        super.clearCachedAuthorizationInfo(principals);
    }
}

