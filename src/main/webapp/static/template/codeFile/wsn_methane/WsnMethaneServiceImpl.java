package com.ai.mnt.service.sensor.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sensor.WsnMethane;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sensor.WsnMethaneMapper;
import com.ai.mnt.service.sensor.WsnMethaneService;

/**
 * @Title: WsnMethaneServiceImpl 
 * @Description: WsnMethaneServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */
@Service
public class WsnMethaneServiceImpl implements WsnMethaneService{

    @Autowired
    WsnMethaneMapper wsnMethaneMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有甲烷数据表列表
     * @return List<WsnMethane>
     */
    @Override
    public List<WsnMethane> findAllWsnMethane() {
        List<WsnMethane> wsnMethaneList = wsnMethaneMapper.findAll();
        //cvtContentList(wsnMethaneList);
        return wsnMethaneList;
    }

    /**
     * 获取甲烷数据表列表
     * @param sensor
     * @return List<WsnMethane>
     */
    @Override
    public List<WsnMethane> findWsnMethaneList(WsnMethane wsnMethane) {
        List<WsnMethane> wsnMethaneList = wsnMethaneMapper.findList(wsnMethane);
        //cvtContentList(wsnMethaneList);
        return wsnMethaneList;
    }

    /**
     * 通过主键ID获取甲烷数据表
     * @param id Primary key
     * @return WsnMethane
     */
    @Override
    public WsnMethane findWsnMethaneById(Integer id) {
        WsnMethane wsnMethane = wsnMethaneMapper.findByPrimaryKey(id);
        return wsnMethane;
    }

    /**
     * 添加甲烷数据表
     * @param WsnMethane
     */
    @Override
    public void saveWsnMethane(WsnMethane wsnMethane) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnMethane.setDeleteFlag("0");
        wsnMethane.setCreator(currentUser.getUserName());
        wsnMethane.setModifier(currentUser.getUserName());
        wsnMethane.setCreateDate(new Date());
        wsnMethane.setModifyDate(new Date());
        wsnMethaneMapper.save(wsnMethane);
        
    }

    /**
     * 更新甲烷数据表
     * 根据WsnMethane的主键更新主键以外的其他字段
     * @param WsnMethane
     */
    @Override
    public void updateWsnMethaneById(WsnMethane wsnMethane) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnMethane.setModifier(currentUser.getUserName());
        wsnMethane.setModifyDate(new Date());
        wsnMethaneMapper.updateByPrimaryKey(wsnMethane);
        
    }

    /**
     * 根据主键批量删除甲烷数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnMethaneByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnMethane wsnMethane = new WsnMethane();
        wsnMethane.setDeleteFlag("1");
        wsnMethane.setModifier(currentUser.getUserName());
        wsnMethane.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnMethane.setId(Integer.parseInt(id));
            wsnMethaneMapper.updateByPrimaryKey(wsnMethane);
        }
    }
    
    //private void cvtContentList(List<WsnMethane> WsnMethaneList) {
    //    for(WsnMethane wsnMethane : WsnMethaneList) {
    //    }
    //}
}

