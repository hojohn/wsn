package com.ai.mnt.service.sensor.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sensor.WsnNoise;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sensor.WsnNoiseMapper;
import com.ai.mnt.service.sensor.WsnNoiseService;

/**
 * @Title: WsnNoiseServiceImpl 
 * @Description: WsnNoiseServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2017-4-20
 */
@Service
public class WsnNoiseServiceImpl implements WsnNoiseService{

    @Autowired
    WsnNoiseMapper wsnNoiseMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有温度数据表列表
     * @return List<WsnNoise>
     */
    @Override
    public List<WsnNoise> findAllWsnNoise() {
        List<WsnNoise> wsnNoiseList = wsnNoiseMapper.findAll();
        //cvtContentList(wsnNoiseList);
        return wsnNoiseList;
    }

    /**
     * 获取温度数据表列表
     * @param sensor
     * @return List<WsnNoise>
     */
    @Override
    public List<WsnNoise> findWsnNoiseList(WsnNoise wsnNoise) {
        List<WsnNoise> wsnNoiseList = wsnNoiseMapper.findList(wsnNoise);
        //cvtContentList(wsnNoiseList);
        return wsnNoiseList;
    }

    /**
     * 通过主键ID获取温度数据表
     * @param id Primary key
     * @return WsnNoise
     */
    @Override
    public WsnNoise findWsnNoiseById(Integer id) {
        WsnNoise wsnNoise = wsnNoiseMapper.findByPrimaryKey(id);
        return wsnNoise;
    }

    /**
     * 添加温度数据表
     * @param WsnNoise
     */
    @Override
    public void saveWsnNoise(WsnNoise wsnNoise) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnNoise.setDeleteFlag("0");
        wsnNoise.setCreator(currentUser.getUserName());
        wsnNoise.setModifier(currentUser.getUserName());
        wsnNoise.setCreateDate(new Date());
        wsnNoise.setModifyDate(new Date());
        wsnNoiseMapper.save(wsnNoise);
        
    }

    /**
     * 更新温度数据表
     * 根据WsnNoise的主键更新主键以外的其他字段
     * @param WsnNoise
     */
    @Override
    public void updateWsnNoiseById(WsnNoise wsnNoise) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnNoise.setModifier(currentUser.getUserName());
        wsnNoise.setModifyDate(new Date());
        wsnNoiseMapper.updateByPrimaryKey(wsnNoise);
        
    }

    /**
     * 根据主键批量删除温度数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnNoiseByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnNoise wsnNoise = new WsnNoise();
        wsnNoise.setDeleteFlag("1");
        wsnNoise.setModifier(currentUser.getUserName());
        wsnNoise.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnNoise.setId(Integer.parseInt(id));
            wsnNoiseMapper.updateByPrimaryKey(wsnNoise);
        }
    }
    
    //private void cvtContentList(List<WsnNoise> WsnNoiseList) {
    //    for(WsnNoise wsnNoise : WsnNoiseList) {
    //    }
    //}
}

