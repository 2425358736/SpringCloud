package com.liuzhiqiang.domain.sys.vo;

import com.liuzhiqiang.domain.sys.SysUser;
import lombok.Data;

/**
 * Created by lzq on 2018/9/9.
 */
@Data
public class SysUserVo extends SysUser {

    //部门名称
    private String departmentName;
    //角色名称
    private String roleName;
    //部门id
    private Long departmentId;
    //角色id
    private Long roleId;
}
