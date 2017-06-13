package com.ai.mnt.service.sensor.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sensor.WsnDust;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sensor.WsnDustMapper;
import com.ai.mnt.service.sensor.WsnDustService;

/**
 * @Title: WsnDustServiceImpl 
 * @Description: WsnDustServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */
@Service
public class WsnDustServiceImpl implements WsnDustService{

    @Autowired
    WsnDustMapper wsnDustMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有粉尘数据表列表
     * @return List<WsnDust>
     */
    @Override
    public List<WsnDust> findAllWsnDust() {
        List<WsnDust> wsnDustList = wsnDustMapper.findAll();
        //cvtContentList(wsnDustList);
        return wsnDustList;
    }

    /**
     * 获取粉尘数据表列表
     * @param sensor
     * @return List<WsnDust>
     */
    @Override
    public List<WsnDust> findWsnDustList(WsnDust wsnDust) {
        List<WsnDust> wsnDustList = wsnDustMapper.findList(wsnDust);
        //cvtContentList(wsnDustList);
        return wsnDustList;
    }

    /**
     * 通过主键ID获取粉尘数据表
     * @param id Primary key
     * @return WsnDust
     */
    @Override
    public WsnDust findWsnDustById(Integer id) {
        WsnDust wsnDust = wsnDustMapper.findByPrimaryKey(id);
        return wsnDust;
    }

    /**
     * 添加粉尘数据表
     * @param WsnDust
     */
    @Override
    public void saveWsnDust(WsnDust wsnDust) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnDust.setDeleteFlag("0");
        wsnDust.setCreator(currentUser.getUserName());
        wsnDust.setModifier(currentUser.getUserName());
        wsnDust.setCreateDate(new Date());
        wsnDust.setModifyDate(new Date());
        wsnDustMapper.save(wsnDust);
        
    }

    /**
     * 更新粉尘数据表
     * 根据WsnDust的主键更新主键以外的其他字段
     * @param WsnDust
     */
    @Override
    public void updateWsnDustById(WsnDust wsnDust) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnDust.setModifier(currentUser.getUserName());
        wsnDust.setModifyDate(new Date());
        wsnDustMapper.updateByPrimaryKey(wsnDust);
        
    }

    /**
     * 根据主键批量删除粉尘数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnDustByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnDust wsnDust = new WsnDust();
        wsnDust.setDeleteFlag("1");
        wsnDust.setModifier(currentUser.getUserName());
        wsnDust.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnDust.setId(Integer.parseInt(id));
            wsnDustMapper.updateByPrimaryKey(wsnDust);
        }
    }
    
    //private void cvtContentList(List<WsnDust> WsnDustList) {
    //    for(WsnDust wsnDust : WsnDustList) {
    //    }
    //}
}

