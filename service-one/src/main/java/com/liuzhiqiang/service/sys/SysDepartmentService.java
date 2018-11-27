package com.liuzhiqiang.service.sys;



import com.liuzhiqiang.domain.sys.SysDepartment;
import com.liuzhiqiang.domain.sys.vo.SysDepartmentVo;
import com.liuzhiqiang.until.BrushUtils;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * Created by 刘志强 on 2018/2/24.
 */

public interface SysDepartmentService {
    /**
     * 根据主键删除数据库的记录
     *
     * @param id
     */
    int deleteByPrimaryKey(Long id);

    /**
     * 插入数据库记录
     *
     * @param record
     */
    int insert(SysDepartment record);

    /**
     *
     * @param record
     */
    int insertSelective(SysDepartment record);

    /**
     * 根据主键获取一条数据库记录
     *
     * @param id
     */
    SysDepartmentVo selectByPrimaryKey(Long id);

    /**
     *
     * @param record
     */
    int updateByPrimaryKeySelective(SysDepartment record);

    /**
     * 根据主键来更新数据库记录
     *
     * @param record
     */
    int updateByPrimaryKey(SysDepartment record);

    List<SysDepartmentVo> listDepartment(BrushUtils brushUtils);

    List<SysDepartmentVo> getDepartmentTree(HttpSession session);

    int deleteDepartment(SysDepartment sysDepartment);

    List<SysDepartmentVo> departmentListAll();
}