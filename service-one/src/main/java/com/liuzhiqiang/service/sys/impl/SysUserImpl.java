package com.liuzhiqiang.service.sys.impl;

import com.liuzhiqiang.config.page.PageHelper;
import com.liuzhiqiang.domain.sys.SysDepartment;
import com.liuzhiqiang.domain.sys.SysUser;
import com.liuzhiqiang.domain.sys.SysUserRole;
import com.liuzhiqiang.domain.sys.vo.SysDepartmentVo;
import com.liuzhiqiang.domain.sys.vo.SysUserVo;
import com.liuzhiqiang.mapper.sys.SysDepartmentMapper;
import com.liuzhiqiang.mapper.sys.SysUserMapper;
import com.liuzhiqiang.service.sys.SysUserRoleService;
import com.liuzhiqiang.service.sys.SysUserService;
import com.liuzhiqiang.until.BrushUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.List;

/**
 * Created by SCKJ on 2018/2/26.
 */
@Transactional(readOnly = true, rollbackFor = Exception.class)
@Service
public class SysUserImpl implements SysUserService {
    @Autowired
    public SysUserMapper sysUserMapper;
    @Autowired
    public SysUserRoleService sysUserRoleService;
    @Autowired
    public SysDepartmentMapper sysDepartmentMapper;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysUserMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int insert(SysUser record) {
        return sysUserMapper.insert(record);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int insertSelective(SysUser record) {
        return sysUserMapper.insertSelective(record);
    }

    @Override
    public SysUser selectByPrimaryKey(Long id) {
        return sysUserMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(SysUser record) {
        return sysUserMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(SysUser record) {
        return sysUserMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SysUserVo> listSysUser(BrushUtils brushUtils) {
        PageHelper.startPage(brushUtils.getPagination());
        return sysUserMapper.listSysUser(brushUtils);
    }

    @Override
    public SysUserVo getUserInfo(Long id) {
        return sysUserMapper.getUserInfo(id);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int insertUser(SysUserVo sysUserVo, HttpSession session) {
        SysUser sysUser1 = sysUserMapper.verificationPhone(sysUserVo);
        if (sysUser1 == null) {
            //添加用户信息
            int i = sysUserMapper.insertSelective(sysUserVo);
            //添加用户角色中间表
            sysUserRoleService.insertSelective(sysUserVo, session);
            return i;
        } else {
            return 140;
        }
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int updateUser(SysUserVo sysUser, HttpSession session) {
        SysUser sysUser1 = sysUserMapper.verificationPhone(sysUser);
        if (sysUser1 == null) {
            //修改用户信息
            int i = sysUserMapper.updateByPrimaryKeySelective(sysUser);
            if (sysUser.getRoleId() != null) {
                //修改用户角色中间表
                SysUserRole sysUserRole = sysUserRoleService.selectUserRoleUserId(sysUser.getId());
                if (sysUserRole != null) {
                    sysUserRole.setUserId(sysUser.getId());
                    sysUserRole.setDepartmentId(sysUser.getDepartmentId());
                    sysUserRole.setRoleId(sysUser.getRoleId());
                    sysUserRole.setUpdateBy(((SysUser)session.getAttribute("user")).getId());
                    sysUserRole.setUpdateDate(new Date());
                    sysUserRoleService.updateByPrimaryKeySelective(sysUserRole,session);
                } else {
                    sysUserRoleService.insertSelective(sysUser, session);
                }
            }
            return i;
        } else {
            return 140;
        }
    }

}
