package com.liuzhiqiang.config.springCloudConfig;

import com.liuzhiqiang.domain.sys.SysPermission;
import com.liuzhiqiang.domain.sys.vo.SysPermissionVo;
import com.liuzhiqiang.domain.sys.vo.SysUserVo;
import com.liuzhiqiang.mapper.sys.SysPermissionMapper;
import com.liuzhiqiang.service.sys.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzq on 2018/12/4.
 */
@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    @Autowired
    public SysUserService sysUserService;
    @Autowired
    public SysPermissionMapper sysPermissionMapper;
    @Override
    public SysUserVo loadUserByUsername(String loginName) throws UsernameNotFoundException {
        SysUserVo sysUserVo = sysUserService.getUserInfoLoginName(loginName);
        List<SysPermissionVo> list = sysPermissionMapper.listPermission(sysUserVo.getId());
        sysUserVo.setAuthorities(list);
        return sysUserVo;
    }
}
