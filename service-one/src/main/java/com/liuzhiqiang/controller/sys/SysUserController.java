package com.liuzhiqiang.controller.sys;

import com.alibaba.druid.util.StringUtils;
import com.github.pagehelper.PageInfo;
import com.liuzhiqiang.config.redis.IRedisService;
import com.liuzhiqiang.controller.BaseController;
import com.liuzhiqiang.domain.sys.SysUser;
import com.liuzhiqiang.domain.sys.vo.SysUserVo;
import com.liuzhiqiang.service.sys.SysUserRoleService;
import com.liuzhiqiang.service.sys.SysUserService;
import com.liuzhiqiang.until.BrushUtils;
import com.liuzhiqiang.until.CommonResult;
import com.liuzhiqiang.until.Md5Utils;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by 刘志强 on 2018/2/24.
 * 账号管理
 */
@RestController
@RequestMapping("/system")
@CrossOrigin
public class SysUserController extends BaseController {

    @Autowired
    public SysUserService sysUserService;
    @Autowired
    public SysUserRoleService sysUserRoleService;
    @Autowired
    public IRedisService iRedisService;
    /**
     *
     * @param brushUtils
     * @return 用户列表
     */
    @PreAuthorize("hasAnyAuthority('sys:sysuser')")
    @PostMapping("/sysUserList")
    public CommonResult<PageInfo> sysUserList(@RequestBody BrushUtils brushUtils) {
        List<SysUserVo> list = sysUserService.listSysUser(brushUtils);
        return CommonResult.successReturn(new PageInfo(list));
    }


    /**删除账号
     *
     * @param sysUser
     * @return
     */
    @PostMapping("/deleteSysUser")
    public CommonResult<String> deleteSysUser(@RequestBody SysUser sysUser) {
        sysUser.setDelFlag(1);
        sysUserService.updateByPrimaryKeySelective(sysUser);
        return CommonResult.successReturn("删除成功","删除成功");
    }

    /**添加账号
     *
     * @param sysUserVo
     * @param session
     * @return
     */
    @PostMapping("/insertUser")
    public CommonResult<String> insertUser(@RequestBody SysUserVo sysUserVo, HttpSession session) {
        sysUserVo.setPassWord("123456");
        //密码MD5加密
        if (sysUserVo.getPassWord() != null && !StringUtils.equals(sysUserVo.getPassWord(), "")) {
            sysUserVo.setPassWord(Md5Utils.md5(sysUserVo.getPassWord()).toUpperCase());
        }
        int i = sysUserService.insertUser(sysUserVo,session);
        if (i == 140) {
            return CommonResult.errorReturn(140,"手机号已被注册请更换手机号");
        } else if (i > 0) {
            return CommonResult.successReturn("添加成功","添加成功");
        } else {
            return CommonResult.successReturn("添加失败","添加失败");
        }

    }

    /**修改账号
     *
     * @param sysUser
     * @param session
     * @return
     */
    @PostMapping("/updateUser")
    public CommonResult<String> updateUser(@RequestBody SysUserVo sysUser, HttpSession session) {
        if (sysUser.getPassWord() != null) {
            sysUser.setPassWord(Md5Utils.md5(sysUser.getPassWord()).toUpperCase());
        }
        int i = sysUserService.updateUser(sysUser,session);
        if (i == 140) {
            return CommonResult.errorReturn(140,"手机号已被注册请更换手机号");
        } else if (i > 0) {
            return CommonResult.successReturn("修改成功","修改成功");
        } else {
            return CommonResult.successReturn("修改失败","修改成功");
        }
    }

    /**账号信息
     *
     * @param sysUser
     * @return
     */
    @PostMapping("/getUser")
    public CommonResult<SysUser> getUser(@RequestBody SysUser sysUser){
        //获取用户信息
        SysUserVo sysUserVo = sysUserService.getUserInfo(sysUser.getId());
        return CommonResult.successReturn(sysUserVo);
    }

    /**
     * 验证用户信息，用于登陆
     * @param sysUser
     * @return
     */
    @PostMapping("/verificationUser")
    public CommonResult<String> verificationUser(@RequestBody SysUser sysUser, HttpSession session){
        //验证用户信息
        UsernamePasswordToken usernamePasswordToken=new UsernamePasswordToken(sysUser.getLoginName(),Md5Utils.md5(sysUser.getPassWord()));
        Subject subject = SecurityUtils.getSubject();
        Map<String,Object> map = new HashMap<String,Object>();
        try {
            //完成登录
            subject.login(usernamePasswordToken);
            SysUser user=(SysUser) subject.getPrincipal();;
            session.setAttribute("user", user);
            iRedisService.set(user.getId().toString(),session.getId());
            return CommonResult.successReturn("登陆成功","登陆成功");
        } catch(Exception e) {
            return CommonResult.errorReturn(150,e.getMessage());
        }

    }
    /**
     * 退出
     * @return
     */
    @PostMapping("/logout")
    public CommonResult<String> logout(HttpSession session){
        session.removeAttribute("user");
        return CommonResult.successReturn("退出成功");
    }

    /**
     * 修改用户手机号
     * @param phone 手机号
     * @return
     */
    @PostMapping("/changePhoneNumber")
    public CommonResult<String> changePhoneNumber(@RequestBody Map<String, String> phone, HttpSession session){

        String number = phone.get("phoneNumber");

        SysUser user = (SysUser) session.getAttribute("user");
        if (!StringUtils.isEmpty(number)) {
            user.setPhone(number);

            sysUserService.updateByPrimaryKey(user);

            return CommonResult.successReturn("手机号码修改成功", "手机号码修改成功");
        }

        return CommonResult.errorReturn(12005, "手机号码修改失败");
    }

    @PostMapping("/getUserName")
    public CommonResult<SysUser> getUserName(HttpSession session){
        SysUser sysUser = (SysUser) session.getAttribute("user");
        return CommonResult.successReturn(sysUser);
    }
}
