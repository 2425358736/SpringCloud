package com.liuzhiqiang.service.sys.impl;

import com.liuzhiqiang.domain.sys.SysUser;
import com.liuzhiqiang.domain.sys.SysUserRole;
import com.liuzhiqiang.domain.sys.vo.SysUserVo;
import com.liuzhiqiang.mapper.sys.SysUserRoleMapper;
import com.liuzhiqiang.service.sys.SysDepartmentService;
import com.liuzhiqiang.service.sys.SysUserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;

/**
 * 开发公司：青岛上朝信息科技有限公司
 * 版权：青岛上朝信息科技有限公司
 * <p>
 * @author 刘志强
 * @created 2018/2/27.
 */
@Transactional(readOnly = true, rollbackFor = Exception.class)
@Service
public class SysUserRoleImpl implements SysUserRoleService {

    @Autowired
    public SysUserRoleMapper sysUserRoleMapper;
    @Autowired
    public SysDepartmentService sysDepartmentService;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysUserRoleMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int insert(SysUserRole record) {
        return sysUserRoleMapper.insert(record);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int insertSelective(SysUserVo sysUserVo, HttpSession session) {
        SysUserRole sysUserRole = new SysUserRole();
        sysUserRole.setUserId(sysUserVo.getId());
        sysUserRole.setDepartmentId(sysUserVo.getDepartmentId());
        sysUserRole.setRoleId(sysUserVo.getRoleId());
        sysUserRole.setCreateBy(((SysUser)session.getAttribute("user")).getId());
        sysUserRole.setCreateDate(new Date());
        return sysUserRoleMapper.insertSelective(sysUserRole);
    }

    @Override
    public SysUserRole selectByPrimaryKey(Long id) {
        return sysUserRoleMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(SysUserRole sysUserRole, HttpSession session) {
        return sysUserRoleMapper.updateByPrimaryKeySelective(sysUserRole);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(SysUserRole record) {
        return sysUserRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public SysUserRole selectUserRoleUserId(Long id) {
        return sysUserRoleMapper.selectUserRoleUserId(id);
    }
}
