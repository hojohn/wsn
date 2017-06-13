package com.ai.mnt.service.sec.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sec.SafeEval;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sec.SafeEvalMapper;
import com.ai.mnt.service.sec.SafeEvalService;

/**
 * @Title: SafeEvalServiceImpl 
 * @Description: SafeEvalServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2017-5-16
 */
@Service
public class SafeEvalServiceImpl implements SafeEvalService{

    @Autowired
    SafeEvalMapper safeEvalMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有危险物料风险度表列表
     * @return List<SafeEval>
     */
    @Override
    public List<SafeEval> findAllSafeEval() {
        List<SafeEval> safeEvalList = safeEvalMapper.findAll();
        //cvtContentList(safeEvalList);
        return safeEvalList;
    }

    /**
     * 获取危险物料风险度表列表
     * @param sec
     * @return List<SafeEval>
     */
    @Override
    public List<SafeEval> findSafeEvalList(SafeEval safeEval) {
        List<SafeEval> safeEvalList = safeEvalMapper.findList(safeEval);
        //cvtContentList(safeEvalList);
        return safeEvalList;
    }

    /**
     * 通过主键ID获取危险物料风险度表
     * @param id Primary key
     * @return SafeEval
     */
    @Override
    public SafeEval findSafeEvalById(Integer id) {
        SafeEval safeEval = safeEvalMapper.findByPrimaryKey(id);
        return safeEval;
    }

    /**
     * 添加危险物料风险度表
     * @param SafeEval
     */
    @Override
    public void saveSafeEval(SafeEval safeEval) {
        SysUser currentUser = userRealm.getCurrentUser();
        safeEval.setDeleteFlag("0");
        safeEval.setCreator(currentUser.getUserName());
        safeEval.setModifier(currentUser.getUserName());
        safeEval.setCreateDate(new Date());
        safeEval.setModifyDate(new Date());
        safeEvalMapper.save(safeEval);
        
    }

    /**
     * 更新危险物料风险度表
     * 根据SafeEval的主键更新主键以外的其他字段
     * @param SafeEval
     */
    @Override
    public void updateSafeEvalById(SafeEval safeEval) {
        SysUser currentUser = userRealm.getCurrentUser();
        safeEval.setModifier(currentUser.getUserName());
        safeEval.setModifyDate(new Date());
        safeEvalMapper.updateByPrimaryKey(safeEval);
        
    }

    /**
     * 根据主键批量删除危险物料风险度表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteSafeEvalByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        SafeEval safeEval = new SafeEval();
        safeEval.setDeleteFlag("1");
        safeEval.setModifier(currentUser.getUserName());
        safeEval.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            safeEval.setId(Integer.parseInt(id));
            safeEvalMapper.updateByPrimaryKey(safeEval);
        }
    }
    
    //private void cvtContentList(List<SafeEval> SafeEvalList) {
    //    for(SafeEval safeEval : SafeEvalList) {
    //    }
    //}
}

