package com.liuzhiqiang.service.sys.impl;

import com.liuzhiqiang.domain.sys.SysPermission;
import com.liuzhiqiang.domain.sys.SysRole;
import com.liuzhiqiang.domain.sys.SysRolePermission;
import com.liuzhiqiang.domain.sys.vo.SysRoleVo;
import com.liuzhiqiang.mapper.sys.SysRolePermissionMapper;
import com.liuzhiqiang.service.sys.SysRolePermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by SCKJ on 2018/2/26.
 */
@Transactional(readOnly = true, rollbackFor = Exception.class)
@Service
public class SysRolePermissionImpl implements SysRolePermissionService {

    @Autowired
    public SysRolePermissionMapper sysRolePermissionMapper;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysRolePermissionMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int insert(SysRolePermission record) {
        return sysRolePermissionMapper.insert(record);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int insertSelective(SysRoleVo sysRole) {
        sysRole.getPermissionVoListStr().forEach(str -> {
            SysRolePermission sysRolePermission = new SysRolePermission();
            sysRolePermission.setRoleId(sysRole.getId());
            sysRolePermission.setPermissionId(Long.parseLong(str));
            sysRolePermission.setCreateBy(sysRole.getCreateBy() != null ? sysRole.getCreateBy() : sysRole.getUpdateBy() );
            sysRolePermissionMapper.insertSelective(sysRolePermission);
        });
        return 0;
    }

    @Override
    public SysRolePermission selectByPrimaryKey(Long id) {
        return sysRolePermissionMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(SysRolePermission record) {
        return sysRolePermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(SysRolePermission record) {
        return sysRolePermissionMapper.updateByPrimaryKey(record);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public void deleteRoleId(Long id) {
        sysRolePermissionMapper.deleteRoleId(id);
    }

    @Override
    public List<SysPermission> rolePermissionList(SysRole sysRole) {
        return sysRolePermissionMapper.rolePermissionList(sysRole);
    }
}
