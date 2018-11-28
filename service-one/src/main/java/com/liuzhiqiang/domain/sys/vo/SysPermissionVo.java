package com.liuzhiqiang.domain.sys.vo;
import com.liuzhiqiang.domain.sys.SysPermission;

import java.util.ArrayList;
import java.util.List;

/**
 * 开发公司：青岛上朝信息科技有限公司
 * 版权：青岛上朝信息科技有限公司
 * <p>
 * 类功能描述
 *
 * @author 刘志强
 * @created 2018/2/27.
 */

public class SysPermissionVo extends SysPermission {

    private Long id;

    private List<SysPermissionVo> children = new ArrayList<>();

    private String parentName;

    private String name;

    private String icon;

    private String path;

    private String perName;

    private String perImg;

    private String perUrl;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIcon() {
        return icon;
    }

    public void setIcon(String icon) {
        this.icon = icon;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String getPerName() {
        return perName;
    }

    @Override
    public void setPerName(String perName) {
        this.name = perName;
        this.perName = perName;
    }

    @Override
    public String getPerImg() {
        return perImg;
    }

    @Override
    public void setPerImg(String perImg) {
        this.icon = perImg;
        this.perImg = perImg;
    }

    @Override
    public String getPerUrl() {
        return perUrl;
    }

    @Override
    public void setPerUrl(String perUrl) {
        this.path = perUrl;
        this.perUrl = perUrl;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public void setId(Long id) {
        this.id = id;
    }

    public List<SysPermissionVo> getChildren() {
        return children;
    }

    public void setChildren(List<SysPermissionVo> children) {
        this.children = children;
    }
}
