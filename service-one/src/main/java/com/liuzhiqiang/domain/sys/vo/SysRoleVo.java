package com.liuzhiqiang.domain.sys.vo;
import com.liuzhiqiang.domain.sys.SysRole;
import lombok.Data;

import java.util.List;

/**
 * Created by SCKJ on 2018/2/26.
 */
@Data
public class SysRoleVo extends SysRole {
    /**
     * 部门名称
      */
    private String departmentName;

    /**
     * 角色下用户
     */
    private List<SysUserVo> userVoList;

    /**
     * 角色下权限
     */
    private List<SysPermissionVo> permissionVoList;

    /**
     * 角色下权限
     */
    private List<String> permissionVoListStr;
}
