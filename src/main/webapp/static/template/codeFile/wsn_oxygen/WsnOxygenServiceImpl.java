package com.ai.mnt.service.sensor.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sensor.WsnOxygen;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sensor.WsnOxygenMapper;
import com.ai.mnt.service.sensor.WsnOxygenService;

/**
 * @Title: WsnOxygenServiceImpl 
 * @Description: WsnOxygenServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */
@Service
public class WsnOxygenServiceImpl implements WsnOxygenService{

    @Autowired
    WsnOxygenMapper wsnOxygenMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有氧气数据表列表
     * @return List<WsnOxygen>
     */
    @Override
    public List<WsnOxygen> findAllWsnOxygen() {
        List<WsnOxygen> wsnOxygenList = wsnOxygenMapper.findAll();
        //cvtContentList(wsnOxygenList);
        return wsnOxygenList;
    }

    /**
     * 获取氧气数据表列表
     * @param sensor
     * @return List<WsnOxygen>
     */
    @Override
    public List<WsnOxygen> findWsnOxygenList(WsnOxygen wsnOxygen) {
        List<WsnOxygen> wsnOxygenList = wsnOxygenMapper.findList(wsnOxygen);
        //cvtContentList(wsnOxygenList);
        return wsnOxygenList;
    }

    /**
     * 通过主键ID获取氧气数据表
     * @param id Primary key
     * @return WsnOxygen
     */
    @Override
    public WsnOxygen findWsnOxygenById(Integer id) {
        WsnOxygen wsnOxygen = wsnOxygenMapper.findByPrimaryKey(id);
        return wsnOxygen;
    }

    /**
     * 添加氧气数据表
     * @param WsnOxygen
     */
    @Override
    public void saveWsnOxygen(WsnOxygen wsnOxygen) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnOxygen.setDeleteFlag("0");
        wsnOxygen.setCreator(currentUser.getUserName());
        wsnOxygen.setModifier(currentUser.getUserName());
        wsnOxygen.setCreateDate(new Date());
        wsnOxygen.setModifyDate(new Date());
        wsnOxygenMapper.save(wsnOxygen);
        
    }

    /**
     * 更新氧气数据表
     * 根据WsnOxygen的主键更新主键以外的其他字段
     * @param WsnOxygen
     */
    @Override
    public void updateWsnOxygenById(WsnOxygen wsnOxygen) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnOxygen.setModifier(currentUser.getUserName());
        wsnOxygen.setModifyDate(new Date());
        wsnOxygenMapper.updateByPrimaryKey(wsnOxygen);
        
    }

    /**
     * 根据主键批量删除氧气数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnOxygenByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnOxygen wsnOxygen = new WsnOxygen();
        wsnOxygen.setDeleteFlag("1");
        wsnOxygen.setModifier(currentUser.getUserName());
        wsnOxygen.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnOxygen.setId(Integer.parseInt(id));
            wsnOxygenMapper.updateByPrimaryKey(wsnOxygen);
        }
    }
    
    //private void cvtContentList(List<WsnOxygen> WsnOxygenList) {
    //    for(WsnOxygen wsnOxygen : WsnOxygenList) {
    //    }
    //}
}

