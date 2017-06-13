package com.ai.mnt.service.sensor.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sensor.WsnHeart;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sensor.WsnHeartMapper;
import com.ai.mnt.service.sensor.WsnHeartService;

/**
 * @Title: WsnHeartServiceImpl 
 * @Description: WsnHeartServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2017-4-20
 */
@Service
public class WsnHeartServiceImpl implements WsnHeartService{

    @Autowired
    WsnHeartMapper wsnHeartMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有温度数据表列表
     * @return List<WsnHeart>
     */
    @Override
    public List<WsnHeart> findAllWsnHeart() {
        List<WsnHeart> wsnHeartList = wsnHeartMapper.findAll();
        //cvtContentList(wsnHeartList);
        return wsnHeartList;
    }

    /**
     * 获取温度数据表列表
     * @param sensor
     * @return List<WsnHeart>
     */
    @Override
    public List<WsnHeart> findWsnHeartList(WsnHeart wsnHeart) {
        List<WsnHeart> wsnHeartList = wsnHeartMapper.findList(wsnHeart);
        //cvtContentList(wsnHeartList);
        return wsnHeartList;
    }

    /**
     * 通过主键ID获取温度数据表
     * @param id Primary key
     * @return WsnHeart
     */
    @Override
    public WsnHeart findWsnHeartById(Integer id) {
        WsnHeart wsnHeart = wsnHeartMapper.findByPrimaryKey(id);
        return wsnHeart;
    }

    /**
     * 添加温度数据表
     * @param WsnHeart
     */
    @Override
    public void saveWsnHeart(WsnHeart wsnHeart) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnHeart.setDeleteFlag("0");
        wsnHeart.setCreator(currentUser.getUserName());
        wsnHeart.setModifier(currentUser.getUserName());
        wsnHeart.setCreateDate(new Date());
        wsnHeart.setModifyDate(new Date());
        wsnHeartMapper.save(wsnHeart);
        
    }

    /**
     * 更新温度数据表
     * 根据WsnHeart的主键更新主键以外的其他字段
     * @param WsnHeart
     */
    @Override
    public void updateWsnHeartById(WsnHeart wsnHeart) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnHeart.setModifier(currentUser.getUserName());
        wsnHeart.setModifyDate(new Date());
        wsnHeartMapper.updateByPrimaryKey(wsnHeart);
        
    }

    /**
     * 根据主键批量删除温度数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnHeartByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnHeart wsnHeart = new WsnHeart();
        wsnHeart.setDeleteFlag("1");
        wsnHeart.setModifier(currentUser.getUserName());
        wsnHeart.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnHeart.setId(Integer.parseInt(id));
            wsnHeartMapper.updateByPrimaryKey(wsnHeart);
        }
    }
    
    //private void cvtContentList(List<WsnHeart> WsnHeartList) {
    //    for(WsnHeart wsnHeart : WsnHeartList) {
    //    }
    //}
}

