package com.ai.mnt.service.sensor.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sensor.WsnPressure;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sensor.WsnPressureMapper;
import com.ai.mnt.service.sensor.WsnPressureService;

/**
 * @Title: WsnPressureServiceImpl 
 * @Description: WsnPressureServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */
@Service
public class WsnPressureServiceImpl implements WsnPressureService{

    @Autowired
    WsnPressureMapper wsnPressureMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有压力数据表列表
     * @return List<WsnPressure>
     */
    @Override
    public List<WsnPressure> findAllWsnPressure() {
        List<WsnPressure> wsnPressureList = wsnPressureMapper.findAll();
        //cvtContentList(wsnPressureList);
        return wsnPressureList;
    }

    /**
     * 获取压力数据表列表
     * @param sensor
     * @return List<WsnPressure>
     */
    @Override
    public List<WsnPressure> findWsnPressureList(WsnPressure wsnPressure) {
        List<WsnPressure> wsnPressureList = wsnPressureMapper.findList(wsnPressure);
        //cvtContentList(wsnPressureList);
        return wsnPressureList;
    }

    /**
     * 通过主键ID获取压力数据表
     * @param id Primary key
     * @return WsnPressure
     */
    @Override
    public WsnPressure findWsnPressureById(Integer id) {
        WsnPressure wsnPressure = wsnPressureMapper.findByPrimaryKey(id);
        return wsnPressure;
    }

    /**
     * 添加压力数据表
     * @param WsnPressure
     */
    @Override
    public void saveWsnPressure(WsnPressure wsnPressure) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnPressure.setDeleteFlag("0");
        wsnPressure.setCreator(currentUser.getUserName());
        wsnPressure.setModifier(currentUser.getUserName());
        wsnPressure.setCreateDate(new Date());
        wsnPressure.setModifyDate(new Date());
        wsnPressureMapper.save(wsnPressure);
        
    }

    /**
     * 更新压力数据表
     * 根据WsnPressure的主键更新主键以外的其他字段
     * @param WsnPressure
     */
    @Override
    public void updateWsnPressureById(WsnPressure wsnPressure) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnPressure.setModifier(currentUser.getUserName());
        wsnPressure.setModifyDate(new Date());
        wsnPressureMapper.updateByPrimaryKey(wsnPressure);
        
    }

    /**
     * 根据主键批量删除压力数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnPressureByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnPressure wsnPressure = new WsnPressure();
        wsnPressure.setDeleteFlag("1");
        wsnPressure.setModifier(currentUser.getUserName());
        wsnPressure.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnPressure.setId(Integer.parseInt(id));
            wsnPressureMapper.updateByPrimaryKey(wsnPressure);
        }
    }
    
    //private void cvtContentList(List<WsnPressure> WsnPressureList) {
    //    for(WsnPressure wsnPressure : WsnPressureList) {
    //    }
    //}
}

