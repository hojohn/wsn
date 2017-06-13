package com.ai.mnt.service.sensor.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sensor.WsnHumidity;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sensor.WsnHumidityMapper;
import com.ai.mnt.service.sensor.WsnHumidityService;

/**
 * @Title: WsnHumidityServiceImpl 
 * @Description: WsnHumidityServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */
@Service
public class WsnHumidityServiceImpl implements WsnHumidityService{

    @Autowired
    WsnHumidityMapper wsnHumidityMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有湿度数据表列表
     * @return List<WsnHumidity>
     */
    @Override
    public List<WsnHumidity> findAllWsnHumidity() {
        List<WsnHumidity> wsnHumidityList = wsnHumidityMapper.findAll();
        //cvtContentList(wsnHumidityList);
        return wsnHumidityList;
    }

    /**
     * 获取湿度数据表列表
     * @param sensor
     * @return List<WsnHumidity>
     */
    @Override
    public List<WsnHumidity> findWsnHumidityList(WsnHumidity wsnHumidity) {
        List<WsnHumidity> wsnHumidityList = wsnHumidityMapper.findList(wsnHumidity);
        //cvtContentList(wsnHumidityList);
        return wsnHumidityList;
    }

    /**
     * 通过主键ID获取湿度数据表
     * @param id Primary key
     * @return WsnHumidity
     */
    @Override
    public WsnHumidity findWsnHumidityById(Integer id) {
        WsnHumidity wsnHumidity = wsnHumidityMapper.findByPrimaryKey(id);
        return wsnHumidity;
    }

    /**
     * 添加湿度数据表
     * @param WsnHumidity
     */
    @Override
    public void saveWsnHumidity(WsnHumidity wsnHumidity) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnHumidity.setDeleteFlag("0");
        wsnHumidity.setCreator(currentUser.getUserName());
        wsnHumidity.setModifier(currentUser.getUserName());
        wsnHumidity.setCreateDate(new Date());
        wsnHumidity.setModifyDate(new Date());
        wsnHumidityMapper.save(wsnHumidity);
        
    }

    /**
     * 更新湿度数据表
     * 根据WsnHumidity的主键更新主键以外的其他字段
     * @param WsnHumidity
     */
    @Override
    public void updateWsnHumidityById(WsnHumidity wsnHumidity) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnHumidity.setModifier(currentUser.getUserName());
        wsnHumidity.setModifyDate(new Date());
        wsnHumidityMapper.updateByPrimaryKey(wsnHumidity);
        
    }

    /**
     * 根据主键批量删除湿度数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnHumidityByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnHumidity wsnHumidity = new WsnHumidity();
        wsnHumidity.setDeleteFlag("1");
        wsnHumidity.setModifier(currentUser.getUserName());
        wsnHumidity.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnHumidity.setId(Integer.parseInt(id));
            wsnHumidityMapper.updateByPrimaryKey(wsnHumidity);
        }
    }
    
    //private void cvtContentList(List<WsnHumidity> WsnHumidityList) {
    //    for(WsnHumidity wsnHumidity : WsnHumidityList) {
    //    }
    //}
}

