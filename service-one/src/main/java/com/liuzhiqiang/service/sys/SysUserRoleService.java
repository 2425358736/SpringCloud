package com.liuzhiqiang.service.sys;

import com.liuzhiqiang.domain.sys.SysUserRole;
import com.liuzhiqiang.domain.sys.vo.SysUserVo;

import javax.servlet.http.HttpSession;

/**
 * Created by 刘志强 on 2018/2/24.
 */


public interface SysUserRoleService {
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
    int insert(SysUserRole record);

    /**
     *
     * @param sysUserVo
     * @param session
     * @return
     */
    int insertSelective(SysUserVo sysUserVo, HttpSession session);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    SysUserRole selectByPrimaryKey(Long id);

    /**
     *
     * @param sysUserRole
     * @param session
     * @return
     */
    int updateByPrimaryKeySelective(SysUserRole sysUserRole, HttpSession session);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(SysUserRole record);

    SysUserRole selectUserRoleUserId(Long id);
}