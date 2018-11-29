package com.liuzhiqiang.controller.sys;

import com.github.pagehelper.PageInfo;
import com.liuzhiqiang.controller.BaseController;
import com.liuzhiqiang.domain.sys.SysDepartment;
import com.liuzhiqiang.domain.sys.SysUser;
import com.liuzhiqiang.domain.sys.vo.SysDepartmentVo;
import com.liuzhiqiang.service.sys.SysDepartmentService;
import com.liuzhiqiang.until.BrushUtils;
import com.liuzhiqiang.until.CommonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by 刘志强 on 2018/2/26
 * 部门管理.
 */
@RestController
@RequestMapping("/system")
@CrossOrigin
public class SysDepartmentController extends BaseController {
    @Autowired
    public SysDepartmentService sysDepartmentService;

    /**
     * 部门列表查询
     * @param
     * @return
     */
    @PostMapping("/departmentList")
    public CommonResult<PageInfo> departmentList(@RequestBody BrushUtils brushUtils) {
        List<SysDepartmentVo> list = sysDepartmentService.listDepartment(brushUtils);
        return CommonResult.successReturn(new PageInfo(list));
    }


    /**
     * 删除部门
     * @param sysDepartment
     * @return
     */
    @PostMapping("/deleteDepartment")
    public CommonResult<String> deleteDepartment(@RequestBody SysDepartment sysDepartment, HttpSession session) {
        int i = sysDepartmentService.deleteDepartment(sysDepartment);
        if (i > 0) {
            if (i == 320) {
                return CommonResult.successReturn("该部门下存在未删除的部门或角色信息，为保系统正常使用，请先删除下级部门或角色。", "该部门下存在未删除的部门或角色信息，为保系统正常使用，请先删除下级部门或角色。");
            } else {
                return CommonResult.successReturn("删除成功", "删除成功");
            }
        } else {
            return CommonResult.successReturn("删除成功","删除成功");
        }
    }

    /**
     * 添加部门
     * @param sysDepartment
     * @param session
     * @return
     */
    @PostMapping("/insertDepartment")
    public CommonResult<String> insertDepartment(@RequestBody SysDepartment sysDepartment, HttpSession session) {
        sysDepartment.setCreateBy(((SysUser)session.getAttribute("user")).getId());
        sysDepartment.setUpdateDate(new Date());
        sysDepartmentService.insertSelective(sysDepartment);
        return CommonResult.successReturn("添加成功","添加成功");
    }

    /**
     * 修改部门
     * @param sysDepartment
     * @param session
     * @return
     */
    @PostMapping("/updateDepartment")
    public CommonResult<String> updateDepartment(@RequestBody SysDepartment sysDepartment, HttpSession session) {
        sysDepartment.setUpdateBy(((SysUser)session.getAttribute("user")).getId());
        sysDepartment.setUpdateDate(new Date());
        int i = sysDepartmentService.updateByPrimaryKeySelective(sysDepartment);
        if (i > 0) {
            return CommonResult.successReturn("修改成功", "修改成功");
        } else {
            return CommonResult.successReturn("修改失败", "修改失败");
        }
    }
    /**
     * 查询部门详情
     * @param sysDepartment1
     * @return
     */
    @PostMapping("/getDepartment")
    public CommonResult<SysDepartmentVo> getDepartment(@RequestBody SysDepartment sysDepartment1){
        SysDepartmentVo sysDepartmentVo = sysDepartmentService.selectByPrimaryKey(sysDepartment1.getId());;
        return CommonResult.successReturn(sysDepartmentVo);
    }

    /**
     * 部门角色账号树结构
     * @param session
     * @return
     */
    @PostMapping("/getDepartmentTree")
    public CommonResult<List> getDepartmentTree(HttpSession session){
        List<SysDepartmentVo> list = sysDepartmentService.getDepartmentTree(session);
        return CommonResult.successReturn(list);
    }


    /**
     * 部门列表查询不分页
     * @return
     */
    @PostMapping("/departmentListAll")
    public CommonResult<List> departmentListAll() {
        List<SysDepartmentVo> list = sysDepartmentService.departmentListAll();
        return CommonResult.successReturn(list);
    }


    /**
     * 部门树结构
     * @return
     */
    @PostMapping("/departmentListAllTree")
    public CommonResult<List> departmentListAllTree() {
        List<SysDepartmentVo> list = sysDepartmentService.departmentListAllTree();
        return CommonResult.successReturn(list);
    }
}
