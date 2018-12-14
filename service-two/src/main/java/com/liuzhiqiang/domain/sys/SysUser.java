package com.liuzhiqiang.domain.sys;

import lombok.Data;

@Data
public class SysUser {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.id
     *
     * @mbg.generated Wed Dec 12 17:48:02 CST 2018
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.login_name
     *
     * @mbg.generated Wed Dec 12 17:48:03 CST 2018
     */
    private String loginName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.pass_word
     *
     * @mbg.generated Wed Dec 12 17:48:03 CST 2018
     */
    private String passWord;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.job_num
     *
     * @mbg.generated Wed Dec 12 17:48:03 CST 2018
     */
    private String jobNum;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.name
     *
     * @mbg.generated Wed Dec 12 17:48:03 CST 2018
     */
    private String name;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.email
     *
     * @mbg.generated Wed Dec 12 17:48:03 CST 2018
     */
    private String email;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.phone
     *
     * @mbg.generated Wed Dec 12 17:48:03 CST 2018
     */
    private String phone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.user_telephone
     *
     * @mbg.generated Wed Dec 12 17:48:03 CST 2018
     */
    private String userTelephone;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.picture
     *
     * @mbg.generated Wed Dec 12 17:48:03 CST 2018
     */
    private String picture;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.user_type
     *
     * @mbg.generated Wed Dec 12 17:48:03 CST 2018
     */
    private Integer userType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.login_flag
     *
     * @mbg.generated Wed Dec 12 17:48:03 CST 2018
     */
    private Integer loginFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.remark
     *
     * @mbg.generated Wed Dec 12 17:48:03 CST 2018
     */
    private String remark;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.del_flag
     *
     * @mbg.generated Wed Dec 12 17:48:03 CST 2018
     */
    private Integer delFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_user.logon_failure
     *
     * @mbg.generated Wed Dec 12 17:48:03 CST 2018
     */
    private Integer logonFailure;

}