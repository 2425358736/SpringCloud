package com.liuzhiqiang.config.springCloudConfig;

import com.liuzhiqiang.domain.sys.SysDepartment;
import com.liuzhiqiang.domain.sys.SysPermission;
import com.liuzhiqiang.domain.sys.vo.SysUserVo;
import org.springframework.security.core.userdetails.UserDetails;
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
    @Override
    public SysUserVo loadUserByUsername(String s) throws UsernameNotFoundException {
        SysUserVo sysUserVo = new SysUserVo();
        sysUserVo.setId(new Long("1"));
        sysUserVo.setPhone("1111");
        sysUserVo.setPassWord("2222");
        SysPermission sysPermission = new SysPermission();
        sysPermission.setPermissionCode("2222");
        List list = new ArrayList();
        list.add(sysPermission);
        sysUserVo.setAuthorities(list);
        System.out.println(sysUserVo.getUsername());
        System.out.println(sysUserVo.getPassword());
        return sysUserVo;
    }
}
