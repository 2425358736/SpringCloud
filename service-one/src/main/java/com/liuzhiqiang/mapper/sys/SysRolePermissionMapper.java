package com.liuzhiqiang.mapper.sys;

import com.liuzhiqiang.domain.sys.SysPermission;
import com.liuzhiqiang.domain.sys.SysRole;
import com.liuzhiqiang.domain.sys.SysRolePermission;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface SysRolePermissionMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Tue Nov 27 09:50:22 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Tue Nov 27 09:50:22 CST 2018
     */
    int insert(SysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Tue Nov 27 09:50:22 CST 2018
     */
    int insertSelective(SysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Tue Nov 27 09:50:22 CST 2018
     */
    SysRolePermission selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Tue Nov 27 09:50:22 CST 2018
     */
    int updateByPrimaryKeySelective(SysRolePermission record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_role_permission
     *
     * @mbg.generated Tue Nov 27 09:50:22 CST 2018
     */
    int updateByPrimaryKey(SysRolePermission record);

    void deleteRoleId(@Param("id") Long id);

    List<SysPermission> rolePermissionList(SysRole sysRole);
}