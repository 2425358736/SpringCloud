package com.liuzhiqiang.domain.sys;

import lombok.Data;

import java.util.Date;

@Data
public class SysRolePermission {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_permission.id
     *
     * @mbg.generated Tue Nov 27 09:50:22 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_permission.role_id
     *
     * @mbg.generated Tue Nov 27 09:50:22 CST 2018
     */
    private Long roleId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_permission.permission_id
     *
     * @mbg.generated Tue Nov 27 09:50:22 CST 2018
     */
    private Long permissionId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_permission.create_by
     *
     * @mbg.generated Tue Nov 27 09:50:22 CST 2018
     */
    private Long createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_permission.create_date
     *
     * @mbg.generated Tue Nov 27 09:50:22 CST 2018
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_permission.update_by
     *
     * @mbg.generated Tue Nov 27 09:50:22 CST 2018
     */
    private Long updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_permission.update_date
     *
     * @mbg.generated Tue Nov 27 09:50:22 CST 2018
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_role_permission.del_flag
     *
     * @mbg.generated Tue Nov 27 09:50:22 CST 2018
     */
    private Integer delFlag;
}