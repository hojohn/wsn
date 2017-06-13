package com.ai.mnt.service.collect.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.collect.WsnTray;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.collect.WsnTrayMapper;
import com.ai.mnt.service.collect.WsnTrayService;

/**
 * @Title: WsnTrayServiceImpl 
 * @Description: WsnTrayServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2017-4-25
 */
@Service
public class WsnTrayServiceImpl implements WsnTrayService{

    @Autowired
    WsnTrayMapper wsnTrayMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有状态列表
     * @return List<WsnTray>
     */
    @Override
    public List<WsnTray> findAllWsnTray() {
        List<WsnTray> wsnTrayList = wsnTrayMapper.findAll();
        //cvtContentList(wsnTrayList);
        return wsnTrayList;
    }

    /**
     * 获取状态列表
     * @param collect
     * @return List<WsnTray>
     */
    @Override
    public List<WsnTray> findWsnTrayList(WsnTray wsnTray) {
        List<WsnTray> wsnTrayList = wsnTrayMapper.findList(wsnTray);
        //cvtContentList(wsnTrayList);
        return wsnTrayList;
    }

    /**
     * 通过主键ID获取状态
     * @param wareId Primary key
     * @return WsnTray
     */
    @Override
    public WsnTray findWsnTrayByWareId(Integer wareId) {
        WsnTray wsnTray = wsnTrayMapper.findByPrimaryKey(wareId);
        return wsnTray;
    }

    /**
     * 添加状态
     * @param WsnTray
     */
    @Override
    public void saveWsnTray(WsnTray wsnTray) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnTray.setDeleteFlag("0");
        wsnTray.setCreator(currentUser.getUserName());
        wsnTray.setModifier(currentUser.getUserName());
        wsnTray.setCreateDate(new Date());
        wsnTray.setModifyDate(new Date());
        wsnTrayMapper.save(wsnTray);
        
    }

    /**
     * 更新状态
     * 根据WsnTray的主键更新主键以外的其他字段
     * @param WsnTray
     */
    @Override
    public void updateWsnTrayByWareId(WsnTray wsnTray) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnTray.setModifier(currentUser.getUserName());
        wsnTray.setModifyDate(new Date());
        wsnTrayMapper.updateByPrimaryKey(wsnTray);
        
    }

    /**
     * 根据主键批量删除状态 
     * 非物理删除 修改删除标识
     * @param wareId Primary key
     */
    @Override
    public void deleteWsnTrayByWareIds(String wareIds) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnTray wsnTray = new WsnTray();
        wsnTray.setDeleteFlag("1");
        wsnTray.setModifier(currentUser.getUserName());
        wsnTray.setModifyDate(new Date());
        String[] wareIdAry = wareIds.split(",");
        for(String wareId : wareIdAry) {
            wsnTray.setWareId(Integer.parseInt(wareId));
            wsnTrayMapper.updateByPrimaryKey(wsnTray);
        }
    }
    
    //private void cvtContentList(List<WsnTray> WsnTrayList) {
    //    for(WsnTray wsnTray : WsnTrayList) {
    //    }
    //}
}

