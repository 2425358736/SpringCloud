package com.liuzhiqiang.controller.sys;

import com.github.pagehelper.PageInfo;
import com.liuzhiqiang.controller.BaseController;
import com.liuzhiqiang.domain.sys.SysPermission;
import com.liuzhiqiang.domain.sys.SysRole;
import com.liuzhiqiang.domain.sys.SysUser;
import com.liuzhiqiang.domain.sys.vo.SysRoleVo;
import com.liuzhiqiang.service.sys.SysRolePermissionService;
import com.liuzhiqiang.service.sys.SysRoleService;
import com.liuzhiqiang.until.BrushUtils;
import com.liuzhiqiang.until.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;


/**
 * Created by SCKJ on 2018/2/26.
 * 角色管理
 */
@RestController
@RequestMapping("/system")
@CrossOrigin
public class SysRoleController extends BaseController {
    @Autowired
    public SysRoleService sysRoleService;
    @Autowired
    public SysRolePermissionService sysRolePermissionService;

    /**角色列表查询
     *
     * @return
     */
    @PostMapping("/roleList")
    public CommonResult<PageInfo> roleList(@RequestBody BrushUtils brushUtils) {
        List<SysRoleVo> list = sysRoleService.listRole(brushUtils);
        return CommonResult.successReturn(new PageInfo(list));
    }

    /**角色添加
     *
     * @param sysRole
     * @return
     */
    @PostMapping("/insertRole")
    public CommonResult<String> insertRole(@RequestBody SysRoleVo sysRole, HttpSession session) {
        sysRole.setCreateBy(((SysUser)session.getAttribute("user")).getId());
        int i = sysRoleService.insertRole(sysRole);
        if (i > 0) {
            return CommonResult.successReturn("添加成功","添加成功");
        } else {
            return CommonResult.successReturn("添加失败","添加失败");
        }
    }

    /**角色修改
     *
     * @param sysRole
     * @return
     */
    @PostMapping("/updateRole")
    public CommonResult<String> updateRole(@RequestBody SysRoleVo sysRole, HttpSession session) {
        // 修改角色
        sysRole.setUpdateBy(((SysUser)session.getAttribute("user")).getId());
        sysRole.setUpdateDate(new Date());
        int i = sysRoleService.updateRole(sysRole);
        if (i > 0) {
            return CommonResult.successReturn("修改成功","修改成功");
        } else {
            return CommonResult.successReturn("修改失败","修改失败");
        }
    }

    /**角色删除
     *
     * @param sysRole
     * @return
     */
    @PostMapping("/deleteRole")
    public CommonResult<String> deleteRole(@RequestBody SysRole sysRole) {
        sysRole.setDelFlag(1);
        int i = sysRoleService.deleteRole(sysRole);
        if (i > 0) {
            if (i == 302) {
                return CommonResult.successReturn("该角色下存在未删除的账号信息，为保系统正常使用，请先删除角色下的账号。", "该角色下存在未删除的账号信息，为保系统正常使用，请先删除角色下的账号。");
            } else {
                return CommonResult.successReturn("删除成功", "删除成功");
            }
        } else {
            return CommonResult.successReturn("删除成功","删除成功");
        }
    }

    /**角色权限查询
     *
     * @param sysRole
     * @return
     */
    @PostMapping("/rolePermissionList")
    public CommonResult<List> rolePermissionList(@RequestBody SysRole sysRole) {
        List<SysPermission> list = sysRolePermissionService.rolePermissionList(sysRole);
        return CommonResult.successReturn(list);
    }


    /**角色信息
     *
     * @param sysRoleVo
     * @return
     */
    @PostMapping("/getRole")
    public CommonResult<SysRole> getRole(@RequestBody SysRoleVo sysRoleVo) {
        SysRole sysRole = sysRoleService.getRoleInfo(sysRoleVo.getId());
        return CommonResult.successReturn(sysRole);
    }

    /**
     * 部门角色查询
     */
    @PostMapping("/roleListDepartment")
    public CommonResult<List> roleListDepartment(@RequestBody SysRole SysRole) {
        List<SysRoleVo> list = sysRoleService.roleListDepartment(SysRole.getDepartmentId());
        return CommonResult.successReturn(list);
    }
}
