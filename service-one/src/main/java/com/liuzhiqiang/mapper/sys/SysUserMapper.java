package com.liuzhiqiang.mapper.sys;

import com.liuzhiqiang.domain.sys.SysUser;
import com.liuzhiqiang.domain.sys.vo.SysUserVo;
import com.liuzhiqiang.until.BrushUtils;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

@Mapper
public interface SysUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbg.generated Tue Nov 27 09:50:35 CST 2018
     */
    int deleteByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbg.generated Tue Nov 27 09:50:35 CST 2018
     */
    int insert(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbg.generated Tue Nov 27 09:50:35 CST 2018
     */
    int insertSelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbg.generated Tue Nov 27 09:50:35 CST 2018
     */
    SysUser selectByPrimaryKey(Long id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbg.generated Tue Nov 27 09:50:35 CST 2018
     */
    int updateByPrimaryKeySelective(SysUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table sys_user
     *
     * @mbg.generated Tue Nov 27 09:50:35 CST 2018
     */
    int updateByPrimaryKey(SysUser record);

    List<SysUserVo> listSysUser(BrushUtils brushUtils);

    SysUserVo getUserInfo(@Param("id") Long id);

    SysUserVo verificationUser(SysUser sysUserc);

    /**
     * 根据用户ID查询权限（permission）
     * @param id
     * @return
     */
    Set<String> findPermissionByUserId(Long id);

    int changePassword(SysUser record);

    List<SysUserVo> listUserRole(@Param("roleId") Long roleId);

    SysUser verificationPhone(SysUserVo sysUser);

    List<SysUserVo> listSysUserPer(@Param("per") String per);
}