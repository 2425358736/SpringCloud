package com.liuzhiqiang.service.sys;

import com.liuzhiqiang.domain.sys.SysRole;
import com.liuzhiqiang.domain.sys.vo.SysRoleVo;
import com.liuzhiqiang.until.BrushUtils;

import java.util.List;

/**
 * Created by 刘志强 on 2018/2/24.
 */

public interface SysRoleService {
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
    int insert(SysRole record);

    /**
     *
     * @param record
     */
    int insertSelective(SysRole record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    SysRole selectByPrimaryKey(Long id);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(SysRole record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(SysRole record);

    List<SysRoleVo> listRole(BrushUtils brushUtils);

    SysRole getRoleInfo(Long id);

    int insertRole(SysRoleVo sysRole);

    int updateRole(SysRoleVo sysRole);

    int deleteRole(SysRole sysRole);

    List<SysRoleVo> roleListDepartment(Long departmentId);
}