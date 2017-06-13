package com.ai.mnt.service.sensor.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sensor.WsnTemperature;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sensor.WsnTemperatureMapper;
import com.ai.mnt.service.sensor.WsnTemperatureService;

/**
 * @Title: WsnTemperatureServiceImpl 
 * @Description: WsnTemperatureServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */
@Service
public class WsnTemperatureServiceImpl implements WsnTemperatureService{

    @Autowired
    WsnTemperatureMapper wsnTemperatureMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有温度数据表列表
     * @return List<WsnTemperature>
     */
    @Override
    public List<WsnTemperature> findAllWsnTemperature() {
        List<WsnTemperature> wsnTemperatureList = wsnTemperatureMapper.findAll();
        //cvtContentList(wsnTemperatureList);
        return wsnTemperatureList;
    }

    /**
     * 获取温度数据表列表
     * @param sensor
     * @return List<WsnTemperature>
     */
    @Override
    public List<WsnTemperature> findWsnTemperatureList(WsnTemperature wsnTemperature) {
        List<WsnTemperature> wsnTemperatureList = wsnTemperatureMapper.findList(wsnTemperature);
        //cvtContentList(wsnTemperatureList);
        return wsnTemperatureList;
    }

    /**
     * 通过主键ID获取温度数据表
     * @param id Primary key
     * @return WsnTemperature
     */
    @Override
    public WsnTemperature findWsnTemperatureById(Integer id) {
        WsnTemperature wsnTemperature = wsnTemperatureMapper.findByPrimaryKey(id);
        return wsnTemperature;
    }

    /**
     * 添加温度数据表
     * @param WsnTemperature
     */
    @Override
    public void saveWsnTemperature(WsnTemperature wsnTemperature) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnTemperature.setDeleteFlag("0");
        wsnTemperature.setCreator(currentUser.getUserName());
        wsnTemperature.setModifier(currentUser.getUserName());
        wsnTemperature.setCreateDate(new Date());
        wsnTemperature.setModifyDate(new Date());
        wsnTemperatureMapper.save(wsnTemperature);
        
    }

    /**
     * 更新温度数据表
     * 根据WsnTemperature的主键更新主键以外的其他字段
     * @param WsnTemperature
     */
    @Override
    public void updateWsnTemperatureById(WsnTemperature wsnTemperature) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnTemperature.setModifier(currentUser.getUserName());
        wsnTemperature.setModifyDate(new Date());
        wsnTemperatureMapper.updateByPrimaryKey(wsnTemperature);
        
    }

    /**
     * 根据主键批量删除温度数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnTemperatureByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnTemperature wsnTemperature = new WsnTemperature();
        wsnTemperature.setDeleteFlag("1");
        wsnTemperature.setModifier(currentUser.getUserName());
        wsnTemperature.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnTemperature.setId(Integer.parseInt(id));
            wsnTemperatureMapper.updateByPrimaryKey(wsnTemperature);
        }
    }
    
    //private void cvtContentList(List<WsnTemperature> WsnTemperatureList) {
    //    for(WsnTemperature wsnTemperature : WsnTemperatureList) {
    //    }
    //}
}

