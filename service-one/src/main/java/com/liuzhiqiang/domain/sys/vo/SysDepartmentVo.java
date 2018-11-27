package com.liuzhiqiang.domain.sys.vo;

import com.liuzhiqiang.domain.sys.SysDepartment;
import lombok.Data;

/**
 * Created by lzq on 2018/9/9.
 */
@Data
public class SysDepartmentVo extends SysDepartment {

    /**
     * 集团名称
     */
    private String groupName;

}
