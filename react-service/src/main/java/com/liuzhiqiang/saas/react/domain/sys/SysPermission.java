package com.liuzhiqiang.saas.react.domain.sys;

import java.util.Date;

public class SysPermission {
    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.id
     *
     * @mbg.generated
     */
    private Long id;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.restaurant_id
     *
     * @mbg.generated
     */
    private Long restaurantId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.per_level
     *
     * @mbg.generated
     */
    private Integer perLevel;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.per_name
     *
     * @mbg.generated
     */
    private String perName;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.permission_code
     *
     * @mbg.generated
     */
    private String permissionCode;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.per_type
     *
     * @mbg.generated
     */
    private Byte perType;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.per_img
     *
     * @mbg.generated
     */
    private String perImg;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.per_url
     *
     * @mbg.generated
     */
    private String perUrl;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.sort
     *
     * @mbg.generated
     */
    private Integer sort;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.parent_id
     *
     * @mbg.generated
     */
    private Integer parentId;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.create_by
     *
     * @mbg.generated
     */
    private Long createBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.create_date
     *
     * @mbg.generated
     */
    private Date createDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.update_by
     *
     * @mbg.generated
     */
    private Long updateBy;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.update_date
     *
     * @mbg.generated
     */
    private Date updateDate;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.del_flag
     *
     * @mbg.generated
     */
    private Byte delFlag;

    /**
     *
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column sys_permission.remark
     *
     * @mbg.generated
     */
    private String remark;

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.id
     *
     * @return the value of sys_permission.id
     *
     * @mbg.generated
     */
    public Long getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.id
     *
     * @param id the value for sys_permission.id
     *
     * @mbg.generated
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.restaurant_id
     *
     * @return the value of sys_permission.restaurant_id
     *
     * @mbg.generated
     */
    public Long getRestaurantId() {
        return restaurantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.restaurant_id
     *
     * @param restaurantId the value for sys_permission.restaurant_id
     *
     * @mbg.generated
     */
    public void setRestaurantId(Long restaurantId) {
        this.restaurantId = restaurantId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.per_level
     *
     * @return the value of sys_permission.per_level
     *
     * @mbg.generated
     */
    public Integer getPerLevel() {
        return perLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.per_level
     *
     * @param perLevel the value for sys_permission.per_level
     *
     * @mbg.generated
     */
    public void setPerLevel(Integer perLevel) {
        this.perLevel = perLevel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.per_name
     *
     * @return the value of sys_permission.per_name
     *
     * @mbg.generated
     */
    public String getPerName() {
        return perName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.per_name
     *
     * @param perName the value for sys_permission.per_name
     *
     * @mbg.generated
     */
    public void setPerName(String perName) {
        this.perName = perName == null ? null : perName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.permission_code
     *
     * @return the value of sys_permission.permission_code
     *
     * @mbg.generated
     */
    public String getPermissionCode() {
        return permissionCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.permission_code
     *
     * @param permissionCode the value for sys_permission.permission_code
     *
     * @mbg.generated
     */
    public void setPermissionCode(String permissionCode) {
        this.permissionCode = permissionCode == null ? null : permissionCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.per_type
     *
     * @return the value of sys_permission.per_type
     *
     * @mbg.generated
     */
    public Byte getPerType() {
        return perType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.per_type
     *
     * @param perType the value for sys_permission.per_type
     *
     * @mbg.generated
     */
    public void setPerType(Byte perType) {
        this.perType = perType;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.per_img
     *
     * @return the value of sys_permission.per_img
     *
     * @mbg.generated
     */
    public String getPerImg() {
        return perImg;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.per_img
     *
     * @param perImg the value for sys_permission.per_img
     *
     * @mbg.generated
     */
    public void setPerImg(String perImg) {
        this.perImg = perImg == null ? null : perImg.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.per_url
     *
     * @return the value of sys_permission.per_url
     *
     * @mbg.generated
     */
    public String getPerUrl() {
        return perUrl;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.per_url
     *
     * @param perUrl the value for sys_permission.per_url
     *
     * @mbg.generated
     */
    public void setPerUrl(String perUrl) {
        this.perUrl = perUrl == null ? null : perUrl.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.sort
     *
     * @return the value of sys_permission.sort
     *
     * @mbg.generated
     */
    public Integer getSort() {
        return sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.sort
     *
     * @param sort the value for sys_permission.sort
     *
     * @mbg.generated
     */
    public void setSort(Integer sort) {
        this.sort = sort;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.parent_id
     *
     * @return the value of sys_permission.parent_id
     *
     * @mbg.generated
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.parent_id
     *
     * @param parentId the value for sys_permission.parent_id
     *
     * @mbg.generated
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.create_by
     *
     * @return the value of sys_permission.create_by
     *
     * @mbg.generated
     */
    public Long getCreateBy() {
        return createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.create_by
     *
     * @param createBy the value for sys_permission.create_by
     *
     * @mbg.generated
     */
    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.create_date
     *
     * @return the value of sys_permission.create_date
     *
     * @mbg.generated
     */
    public Date getCreateDate() {
        return createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.create_date
     *
     * @param createDate the value for sys_permission.create_date
     *
     * @mbg.generated
     */
    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.update_by
     *
     * @return the value of sys_permission.update_by
     *
     * @mbg.generated
     */
    public Long getUpdateBy() {
        return updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.update_by
     *
     * @param updateBy the value for sys_permission.update_by
     *
     * @mbg.generated
     */
    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.update_date
     *
     * @return the value of sys_permission.update_date
     *
     * @mbg.generated
     */
    public Date getUpdateDate() {
        return updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.update_date
     *
     * @param updateDate the value for sys_permission.update_date
     *
     * @mbg.generated
     */
    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.del_flag
     *
     * @return the value of sys_permission.del_flag
     *
     * @mbg.generated
     */
    public Byte getDelFlag() {
        return delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.del_flag
     *
     * @param delFlag the value for sys_permission.del_flag
     *
     * @mbg.generated
     */
    public void setDelFlag(Byte delFlag) {
        this.delFlag = delFlag;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column sys_permission.remark
     *
     * @return the value of sys_permission.remark
     *
     * @mbg.generated
     */
    public String getRemark() {
        return remark;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column sys_permission.remark
     *
     * @param remark the value for sys_permission.remark
     *
     * @mbg.generated
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }
}