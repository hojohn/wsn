package com.ai.mnt.service.device.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.device.WsnSensor;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.device.WsnSensorMapper;
import com.ai.mnt.service.device.WsnSensorService;

/**
 * @Title: WsnSensorServiceImpl 
 * @Description: WsnSensorServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-30
 */
@Service
public class WsnSensorServiceImpl implements WsnSensorService{

    @Autowired
    WsnSensorMapper wsnSensorMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有职业卫生传感器列表
     * @return List<WsnSensor>
     */
    @Override
    public List<WsnSensor> findAllWsnSensor() {
        List<WsnSensor> wsnSensorList = wsnSensorMapper.findAll();
        //cvtContentList(wsnSensorList);
        return wsnSensorList;
    }

    /**
     * 获取职业卫生传感器列表
     * @param device
     * @return List<WsnSensor>
     */
    @Override
    public List<WsnSensor> findWsnSensorList(WsnSensor wsnSensor) {
        List<WsnSensor> wsnSensorList = wsnSensorMapper.findList(wsnSensor);
        //cvtContentList(wsnSensorList);
        return wsnSensorList;
    }

    /**
     * 通过主键ID获取职业卫生传感器
     * @param id Primary key
     * @return WsnSensor
     */
    @Override
    public WsnSensor findWsnSensorById(Integer id) {
        WsnSensor wsnSensor = wsnSensorMapper.findByPrimaryKey(id);
        return wsnSensor;
    }

    /**
     * 添加职业卫生传感器
     * @param WsnSensor
     */
    @Override
    public void saveWsnSensor(WsnSensor wsnSensor) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnSensor.setDeleteFlag("0");
        wsnSensor.setCreator(currentUser.getUserName());
        wsnSensor.setModifier(currentUser.getUserName());
        wsnSensor.setCreateDate(new Date());
        wsnSensor.setModifyDate(new Date());
        wsnSensorMapper.save(wsnSensor);
        
    }

    /**
     * 更新职业卫生传感器
     * 根据WsnSensor的主键更新主键以外的其他字段
     * @param WsnSensor
     */
    @Override
    public void updateWsnSensorById(WsnSensor wsnSensor) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnSensor.setModifier(currentUser.getUserName());
        wsnSensor.setModifyDate(new Date());
        wsnSensorMapper.updateByPrimaryKey(wsnSensor);
        
    }

    /**
     * 根据主键批量删除职业卫生传感器 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnSensorByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnSensor wsnSensor = new WsnSensor();
        wsnSensor.setDeleteFlag("1");
        wsnSensor.setModifier(currentUser.getUserName());
        wsnSensor.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnSensor.setId(Integer.parseInt(id));
            wsnSensorMapper.updateByPrimaryKey(wsnSensor);
        }
    }
    
    //private void cvtContentList(List<WsnSensor> WsnSensorList) {
    //    for(WsnSensor wsnSensor : WsnSensorList) {
    //    }
    //}
}

