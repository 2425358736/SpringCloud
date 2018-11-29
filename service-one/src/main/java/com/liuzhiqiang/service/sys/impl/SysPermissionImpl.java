package com.liuzhiqiang.service.sys.impl;

import com.liuzhiqiang.domain.sys.SysPermission;
import com.liuzhiqiang.domain.sys.vo.SysPermissionVo;
import com.liuzhiqiang.mapper.sys.SysPermissionMapper;
import com.liuzhiqiang.service.sys.SysPermissionService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by SCKJ on 2018/2/26.
 */
@Transactional(readOnly = true, rollbackFor = Exception.class)
@Service
public class SysPermissionImpl implements SysPermissionService {
    @Autowired
    public SysPermissionMapper sysPermissionMapper;

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int deleteByPrimaryKey(Long id) {
        return sysPermissionMapper.deleteByPrimaryKey(id);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int insert(SysPermission record) {
        return sysPermissionMapper.insert(record);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int insertSelective(SysPermission record) {
        return sysPermissionMapper.insertSelective(record);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public SysPermission selectByPrimaryKey(Long id) {
        return sysPermissionMapper.selectByPrimaryKey(id);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKeySelective(SysPermission record) {
        return sysPermissionMapper.updateByPrimaryKeySelective(record);
    }

    @Transactional(readOnly = false, rollbackFor = Exception.class)
    @Override
    public int updateByPrimaryKey(SysPermission record) {
        return sysPermissionMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<SysPermissionVo> listPermission(Long userId) {
        return sysPermissionMapper.listPermission(userId);
    }

    @Override
    public List<SysPermissionVo> companyListPermission() {
        return sysPermissionMapper.companyListPermission();
    }

    @Override
    public List<SysPermissionVo> perList(String str) {
        List<SysPermissionVo> listAll =  sysPermissionMapper.perList(str);
        List<SysPermissionVo> list = recursion(listAll, new Long(0));
        return list;
    }

    public List recursion(List<SysPermissionVo> listAll, Long parentId) {
        List<SysPermissionVo> list = new LinkedList<>();
        listAll.forEach(sysPermissionVo -> {
            if (StringUtils.equals(String.valueOf(sysPermissionVo.getParentId()), String.valueOf(parentId))) {
                list.add(sysPermissionVo);
                sysPermissionVo.setChildren(recursion(listAll, sysPermissionVo.getId()));
            }
        });
        return list;
    }


    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int insertPer(SysPermission sysPermission) {
        int i = sysPermissionMapper.insertSelective(sysPermission);
        return i;
    }

    @Override
    @Transactional(readOnly = false, rollbackFor = Exception.class)
    public int updatePer(SysPermission sysPermission) {
        int i = 0;
        if (sysPermission.getDelFlag() != null && sysPermission.getDelFlag() == 1) {
            List<SysPermission> list = sysPermissionMapper.getSysPermissionSun(sysPermission.getId());
            if (list.size() > 0) {
                i = 302;
            } else {
                i = sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
            }
        } else {
            i = sysPermissionMapper.updateByPrimaryKeySelective(sysPermission);
        }
        return i;
    }
}
