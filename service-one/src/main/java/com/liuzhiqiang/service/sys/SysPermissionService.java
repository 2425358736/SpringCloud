package com.liuzhiqiang.service.sys;


import com.liuzhiqiang.domain.sys.SysPermission;
import com.liuzhiqiang.domain.sys.vo.SysPermissionVo;

import java.util.List;

/**
 * Created by 刘志强 on 2018/2/24.
 */

public interface SysPermissionService {
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
    int insert(SysPermission record);

    /**
     *
     * @param record
     */
    int insertSelective(SysPermission record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    SysPermission selectByPrimaryKey(Long id);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(SysPermission record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(SysPermission record);

    List<SysPermissionVo> listPermission(Long userId);

    List<SysPermissionVo> companyListPermission();

    List<SysPermissionVo> perList(String str);

    int insertPer(SysPermission sysPermission);

    int updatePer(SysPermission sysPermission);
}