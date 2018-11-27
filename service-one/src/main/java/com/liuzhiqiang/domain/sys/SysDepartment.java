package com.liuzhiqiang.domain.sys;

import lombok.Data;

import java.util.Date;

@Data
public class SysDepartment {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_department.id
     *
     * @mbg.generated Tue Nov 27 09:49:33 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_department.department_number
     *
     * @mbg.generated Tue Nov 27 09:49:33 CST 2018
     */
    private String departmentNumber;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_department.department_name
     *
     * @mbg.generated Tue Nov 27 09:49:33 CST 2018
     */
    private String departmentName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_department.parent_id
     *
     * @mbg.generated Tue Nov 27 09:49:33 CST 2018
     */
    private Long parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_department.remarks
     *
     * @mbg.generated Tue Nov 27 09:49:33 CST 2018
     */
    private String remarks;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_department.create_by
     *
     * @mbg.generated Tue Nov 27 09:49:33 CST 2018
     */
    private Long createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_department.create_date
     *
     * @mbg.generated Tue Nov 27 09:49:33 CST 2018
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_department.update_by
     *
     * @mbg.generated Tue Nov 27 09:49:33 CST 2018
     */
    private Long updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_department.update_date
     *
     * @mbg.generated Tue Nov 27 09:49:33 CST 2018
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_department.del_flag
     *
     * @mbg.generated Tue Nov 27 09:49:33 CST 2018
     */
    private Integer delFlag;
}