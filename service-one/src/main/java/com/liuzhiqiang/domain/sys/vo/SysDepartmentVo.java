package com.liuzhiqiang.domain.sys.vo;

import com.liuzhiqiang.domain.sys.SysDepartment;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lzq on 2018/9/9.
 */
@Data
public class SysDepartmentVo extends SysDepartment {

    private List<SysPermissionVo> children = new ArrayList<>();

    private String parentName;
}
