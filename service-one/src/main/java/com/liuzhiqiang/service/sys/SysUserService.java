package com.liuzhiqiang.service.sys;

import com.liuzhiqiang.domain.sys.SysUser;
import com.liuzhiqiang.domain.sys.vo.SysUserVo;
import com.liuzhiqiang.until.BrushUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 刘志强 on 2018/2/24.
 */


public interface SysUserService {
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
    int insert(SysUser record);

    /**
     *
     * @param record
     */
    int insertSelective(SysUser record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    SysUser selectByPrimaryKey(Long id);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(SysUser record);

    List<SysUserVo> listSysUser(BrushUtils brushUtils);

    SysUserVo getUserInfo(Long id);

    int insertUser(SysUserVo sysUserVo, HttpSession session);

    int updateUser(SysUserVo sysUser, HttpSession session);
}