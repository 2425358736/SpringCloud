package com.liuzhiqiang.service.sys;



import com.liuzhiqiang.domain.sys.SysPermission;
import com.liuzhiqiang.domain.sys.SysRole;
import com.liuzhiqiang.domain.sys.SysRolePermission;
import com.liuzhiqiang.domain.sys.vo.SysRoleVo;

import java.util.List;

/**
 * Created by 刘志强 on 2018/2/24.
 */

public interface SysRolePermissionService {
    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(SysRolePermission record);

    /**
     *
     * @param sysRole
     * @param
     * @return
     */
    int insertSelective(SysRoleVo sysRole);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    SysRolePermission selectByPrimaryKey(Long id);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(SysRolePermission record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(SysRolePermission record);

    void deleteRoleId(Long id);

    List<SysPermission> rolePermissionList(SysRole sysRole);
}