package com.liuzhiqiang.domain.sys.vo;

import com.liuzhiqiang.domain.sys.SysPermission;
import com.liuzhiqiang.domain.sys.SysUser;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

/**
 * Created by lzq on 2018/9/9.
 */
@Data
public class SysUserVo extends SysUser implements UserDetails{

    //部门名称
    private String departmentName;
    //角色名称
    private String roleName;
    //部门id
    private Long departmentId;
    //角色id
    private Long roleId;

    private List<SysPermission> authorities;

    public void setAuthorities(List<SysPermission> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return getPassWord();
    }

    @Override
    public String getUsername() {
        return getPhone();
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
