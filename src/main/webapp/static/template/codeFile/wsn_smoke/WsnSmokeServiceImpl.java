package com.ai.mnt.service.sensor.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sensor.WsnSmoke;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sensor.WsnSmokeMapper;
import com.ai.mnt.service.sensor.WsnSmokeService;

/**
 * @Title: WsnSmokeServiceImpl 
 * @Description: WsnSmokeServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */
@Service
public class WsnSmokeServiceImpl implements WsnSmokeService{

    @Autowired
    WsnSmokeMapper wsnSmokeMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有烟雾数据表列表
     * @return List<WsnSmoke>
     */
    @Override
    public List<WsnSmoke> findAllWsnSmoke() {
        List<WsnSmoke> wsnSmokeList = wsnSmokeMapper.findAll();
        //cvtContentList(wsnSmokeList);
        return wsnSmokeList;
    }

    /**
     * 获取烟雾数据表列表
     * @param sensor
     * @return List<WsnSmoke>
     */
    @Override
    public List<WsnSmoke> findWsnSmokeList(WsnSmoke wsnSmoke) {
        List<WsnSmoke> wsnSmokeList = wsnSmokeMapper.findList(wsnSmoke);
        //cvtContentList(wsnSmokeList);
        return wsnSmokeList;
    }

    /**
     * 通过主键ID获取烟雾数据表
     * @param id Primary key
     * @return WsnSmoke
     */
    @Override
    public WsnSmoke findWsnSmokeById(Integer id) {
        WsnSmoke wsnSmoke = wsnSmokeMapper.findByPrimaryKey(id);
        return wsnSmoke;
    }

    /**
     * 添加烟雾数据表
     * @param WsnSmoke
     */
    @Override
    public void saveWsnSmoke(WsnSmoke wsnSmoke) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnSmoke.setDeleteFlag("0");
        wsnSmoke.setCreator(currentUser.getUserName());
        wsnSmoke.setModifier(currentUser.getUserName());
        wsnSmoke.setCreateDate(new Date());
        wsnSmoke.setModifyDate(new Date());
        wsnSmokeMapper.save(wsnSmoke);
        
    }

    /**
     * 更新烟雾数据表
     * 根据WsnSmoke的主键更新主键以外的其他字段
     * @param WsnSmoke
     */
    @Override
    public void updateWsnSmokeById(WsnSmoke wsnSmoke) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnSmoke.setModifier(currentUser.getUserName());
        wsnSmoke.setModifyDate(new Date());
        wsnSmokeMapper.updateByPrimaryKey(wsnSmoke);
        
    }

    /**
     * 根据主键批量删除烟雾数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnSmokeByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnSmoke wsnSmoke = new WsnSmoke();
        wsnSmoke.setDeleteFlag("1");
        wsnSmoke.setModifier(currentUser.getUserName());
        wsnSmoke.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnSmoke.setId(Integer.parseInt(id));
            wsnSmokeMapper.updateByPrimaryKey(wsnSmoke);
        }
    }
    
    //private void cvtContentList(List<WsnSmoke> WsnSmokeList) {
    //    for(WsnSmoke wsnSmoke : WsnSmokeList) {
    //    }
    //}
}

