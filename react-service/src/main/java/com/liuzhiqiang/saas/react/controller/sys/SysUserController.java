package com.liuzhiqiang.saas.react.controller.sys;

import com.liuzhiqiang.saas.react.code.CommonResult;
import com.liuzhiqiang.saas.react.config.BaseController;
import com.liuzhiqiang.saas.react.domain.sys.SysUser;
import com.liuzhiqiang.saas.react.until.Md5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * 开发公司：青岛上朝信息科技有限公司
 * 版权：青岛上朝信息科技有限公司
 * <p>
 * 类功能描述
 *
 * @author 刘志强
 * @created 2018/7/19.
 */
@CrossOrigin
public class SysUserController extends BaseController {

    /**
     * 验证用户信息，用于登陆
     * @param sysUser
     * @return
     */
    @PostMapping("/verificationUser")
    public CommonResult<String> verificationUser(@RequestBody SysUser sysUser, HttpSession session){
        //验证用户信息
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(sysUser.getPhone(), Md5Utils.md5(sysUser.getPassWord()));
        Subject subject = SecurityUtils.getSubject();
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            //完成登录
            subject.login(usernamePasswordToken);
            SysUser user=(SysUser) subject.getPrincipal();
            session.setAttribute("user", user);
            return CommonResult.successReturn("登陆成功","登陆成功");
        } catch(Exception e) {
            return CommonResult.errorReturn(150,e.getMessage());
        }

    }
}
