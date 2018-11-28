package com.liuzhiqiang.controller.sys;
import com.liuzhiqiang.controller.BaseController;
import com.liuzhiqiang.domain.sys.SysPermission;
import com.liuzhiqiang.domain.sys.SysUser;
import com.liuzhiqiang.domain.sys.vo.SysPermissionVo;
import com.liuzhiqiang.service.sys.SysPermissionService;
import com.liuzhiqiang.until.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * 开发公司：青岛上朝信息科技有限公司
 * 版权：青岛上朝信息科技有限公司
 * <p>
 * 类功能描述
 *权限管理
 * @author 刘志强
 * @created 2018/2/27.
 */
@RestController
@RequestMapping("/system")
@CrossOrigin
public class SysPermissionController extends BaseController {
    @Autowired
    public SysPermissionService sysPermissionService;


    /**
     * 权限列表
     */
    @PostMapping("/perList")
    public CommonResult<List> perList() {
        List<SysPermissionVo> list = sysPermissionService.perList("1,2");
        return CommonResult.successReturn(list);
    }

    @PostMapping("/perListAll")
    public CommonResult<List> perListAll() {
        List<SysPermissionVo> list = sysPermissionService.perList("1,2,3");
        return CommonResult.successReturn(list);
    }


    /**
     * 添加权限
     */
    @PostMapping("/insertPer")
    public CommonResult<String> insertPer(@RequestBody SysPermission sysPermission, HttpSession session) {
        sysPermission.setCreateBy(((SysUser)session.getAttribute("user")).getId());
        int i = sysPermissionService.insertPer(sysPermission);
        if (i > 0) {
            return CommonResult.successReturn("添加成功", "添加成功");
        } else {
            return CommonResult.successReturn("添加成功","添加成功");
        }
    }


    /**
     * 修改权限
     */
    @PostMapping("/updatePer")
    public CommonResult<String> updatePer(@RequestBody SysPermission sysPermission, HttpSession session) {
        sysPermission.setUpdateBy(((SysUser)session.getAttribute("user")).getId());
        sysPermission.setUpdateDate(new Date());
        int i = sysPermissionService.updatePer(sysPermission);
        if (i > 0) {
            if (i == 302) {
                return CommonResult.successReturn("该权限下有子权限，请先删除子权限", "该权限下有子权限，请先删除子权限");
            } else {
                return CommonResult.successReturn("修改成功", "修改成功");
            }
        } else {
            return CommonResult.successReturn("修改成功","修改成功");
        }
    }

    /**查询用户权限树结构
     *
     * @param session
     * @return
     */
    @PostMapping("/listPermission")
    public CommonResult<List> listPermission(HttpSession session) {
        SysUser sysUser = (SysUser)session.getAttribute("user");
        List<SysPermissionVo> list = sysPermissionService.listPermission(sysUser.getId());
        return CommonResult.successReturn(list);
    }


    /**查询权限
     *
     * @return
     */
    @PostMapping("/companyListPermission")
    public CommonResult<List> companyListPermission() {
        List<SysPermissionVo> list = sysPermissionService.companyListPermission();
        return CommonResult.successReturn(list);
    }

}
