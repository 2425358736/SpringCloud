package com.liuzhiqiang.service.sys.impl;

import com.liuzhiqiang.config.page.PageHelper;
import com.liuzhiqiang.domain.sys.SysDepartment;
import com.liuzhiqiang.domain.sys.SysRole;
import com.liuzhiqiang.domain.sys.vo.SysRoleVo;
import com.liuzhiqiang.domain.sys.vo.SysUserVo;
import com.liuzhiqiang.mapper.sys.SysDepartmentMapper;
import com.liuzhiqiang.mapper.sys.SysRoleMapper;
import com.liuzhiqiang.mapper.sys.SysUserMapper;
import com.liuzhiqiang.service.sys.SysRolePermissionService;
import com.liuzhiqiang.service.sys.SysRoleService;
import com.liuzhiqiang.until.BrushUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * Created by SCKJ on 2018/2/26.
 */
@Transactional(readOnly = true, rollbackFor = Exception.class)
@Service
public class SysRoleImpl implements SysRoleService {
    @Autowired
    public SysRoleMapper sysRoleMapper;
    @Autowired
    public SysRolePermissionService sysRolePermissionService;
    @Autowired
    public SysUserMapper sysUserMapper;
    @Autowired
    public SysDepartmentMapper sysDepartmentMapper;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysRoleMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int insert(SysRole record) {
        return sysRoleMapper.insert(record);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int insertSelective(SysRole record) {
        record.setUpdateDate(new Date());
        return sysRoleMapper.insertSelective(record);
    }

    @Override
    public SysRole selectByPrimaryKey(Long id) {
        return sysRoleMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(SysRole record) {
        record.setUpdateDate(new Date());
        return sysRoleMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(SysRole record) {
        return sysRoleMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SysRoleVo> listRole(BrushUtils brushUtils) {
        if(brushUtils != null) {
            PageHelper.startPage(brushUtils.getPagination());
        }
        return sysRoleMapper.listRole(brushUtils);
    }

    @Override
    public SysRole getRoleInfo(Long id) {
        return sysRoleMapper.getRoleInfo(id);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int insertRole(SysRoleVo sysRole) {
        SysDepartment sysDepartment = sysDepartmentMapper.selectByPrimaryKey(sysRole.getDepartmentId());
        // 添加角色
        int i = sysRoleMapper.insertSelective(sysRole);
        //添加角色权限
        sysRolePermissionService.insertSelective(sysRole);
        return i;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int updateRole(SysRoleVo sysRole) {
        int i = sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        // 删除相关角色权限表数据
        sysRolePermissionService.deleteRoleId(sysRole.getId());
        //添加角色权限
        sysRolePermissionService.insertSelective(sysRole);
        return i;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int deleteRole(SysRole sysRole) {
        List<SysUserVo> list = sysUserMapper.listUserRole(sysRole.getId());
        int i = 0;
        if (list.size() > 0) {
            i = 302;
        } else {
            i = sysRoleMapper.updateByPrimaryKeySelective(sysRole);
        }
        return i;
    }

    @Override
    public List<SysRoleVo> roleListDepartment(Long departmentId) {
        return sysRoleMapper.listRoleDepartment(departmentId);
    }
}
