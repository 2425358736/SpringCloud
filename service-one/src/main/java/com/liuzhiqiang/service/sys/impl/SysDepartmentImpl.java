package com.liuzhiqiang.service.sys.impl;

import com.liuzhiqiang.config.page.PageHelper;
import com.liuzhiqiang.domain.sys.SysDepartment;
import com.liuzhiqiang.domain.sys.SysUser;
import com.liuzhiqiang.domain.sys.vo.SysDepartmentVo;
import com.liuzhiqiang.domain.sys.vo.SysPermissionVo;
import com.liuzhiqiang.domain.sys.vo.SysRoleVo;
import com.liuzhiqiang.domain.sys.vo.SysUserVo;
import com.liuzhiqiang.mapper.sys.SysDepartmentMapper;
import com.liuzhiqiang.mapper.sys.SysRoleMapper;
import com.liuzhiqiang.mapper.sys.SysUserMapper;
import com.liuzhiqiang.service.sys.SysDepartmentService;
import com.liuzhiqiang.until.BrushUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by 刘志强 on 2018/2/26.
 */
@Transactional(readOnly = true, rollbackFor = Exception.class)
@Service
public class SysDepartmentImpl implements SysDepartmentService {
    @Autowired
    public SysDepartmentMapper sysDepartmentMapper;
    @Autowired
    public SysRoleMapper sysRoleMapper;
    @Autowired
    public SysUserMapper sysUserMapper;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysDepartmentMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int insert(SysDepartment record) {
        return sysDepartmentMapper.insert(record);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int insertSelective(SysDepartment record) {
        return sysDepartmentMapper.insertSelective(record);
    }

    @Override
    public SysDepartmentVo selectByPrimaryKey(Long id) {
        SysDepartmentVo sysDepartmentVo= sysDepartmentMapper.selectByPrimaryKey(id);
        return sysDepartmentVo;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(SysDepartment record) {
        return sysDepartmentMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(SysDepartment record) {
        return sysDepartmentMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SysDepartmentVo> listDepartment(BrushUtils brushUtils) {
        PageHelper.startPage(brushUtils.getPagination());
        return sysDepartmentMapper.listDepartment(brushUtils);
    }

    @Override
    public List<SysDepartmentVo> getDepartmentTree(HttpSession session) {
        List<SysDepartmentVo> list = sysDepartmentMapper.departmentListAll();
        list.forEach(sysDepartmentVo -> {
            List<SysRoleVo> list1 = sysRoleMapper.listRoleDepartment(sysDepartmentVo.getId());
            list1.forEach(sysRoleVo -> {
                List<SysUserVo> list2 = sysUserMapper.listUserRole(sysRoleVo.getId());
                sysRoleVo.setUserVoList(list2);
            });
        });
        return list;
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int deleteDepartment(SysDepartment sysDepartment) {
        List<SysRoleVo> list = sysRoleMapper.listRoleDepartment(sysDepartment.getId());
        int i;
        if (list.size() > 0) {
            i = 320;
        } else {
            i = sysDepartmentMapper.updateByPrimaryKeySelective(sysDepartment);
        }
        return i;
    }

    @Override
    public List<SysDepartmentVo> departmentListAll() {
        List<SysDepartmentVo> listAll = sysDepartmentMapper.departmentListAll();
        return listAll;
    }

    @Override
    public List<SysDepartmentVo> departmentListAllTree() {
        List<SysDepartmentVo> listAll = sysDepartmentMapper.departmentListAll();
        List<SysDepartmentVo> list = recursion(listAll, new Long(0));
        return list;
    }

    public List recursion(List<SysDepartmentVo> listAll, Long parentId) {
        List<SysDepartmentVo> list = new LinkedList<>();
        listAll.forEach(sysDepartmentVo -> {
            if (StringUtils.equals(String.valueOf(sysDepartmentVo.getParentId()), String.valueOf(parentId))) {
                list.add(sysDepartmentVo);
                sysDepartmentVo.setChildren(recursion(listAll, sysDepartmentVo.getId()));
            }
        });
        return list;
    }

    /**
     * 向上查询部门
     * @param id
     */
    public void getParentArr(Long id, ArrayList<String> list) {
        list.add(0,String.valueOf(id));
        SysDepartment sysDepartment = sysDepartmentMapper.selectByPrimaryKey(id);
        if (sysDepartment.getParentId() != 0) {
            this.getParentArr(sysDepartment.getParentId(),list);
        }
    }
}
