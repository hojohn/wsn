package com.ai.mnt.service.sensor.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sensor.WsnCarbonmonoxide;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sensor.WsnCarbonmonoxideMapper;
import com.ai.mnt.service.sensor.WsnCarbonmonoxideService;

/**
 * @Title: WsnCarbonmonoxideServiceImpl 
 * @Description: WsnCarbonmonoxideServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */
@Service
public class WsnCarbonmonoxideServiceImpl implements WsnCarbonmonoxideService{

    @Autowired
    WsnCarbonmonoxideMapper wsnCarbonmonoxideMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有一氧化碳数据表列表
     * @return List<WsnCarbonmonoxide>
     */
    @Override
    public List<WsnCarbonmonoxide> findAllWsnCarbonmonoxide() {
        List<WsnCarbonmonoxide> wsnCarbonmonoxideList = wsnCarbonmonoxideMapper.findAll();
        //cvtContentList(wsnCarbonmonoxideList);
        return wsnCarbonmonoxideList;
    }

    /**
     * 获取一氧化碳数据表列表
     * @param sensor
     * @return List<WsnCarbonmonoxide>
     */
    @Override
    public List<WsnCarbonmonoxide> findWsnCarbonmonoxideList(WsnCarbonmonoxide wsnCarbonmonoxide) {
        List<WsnCarbonmonoxide> wsnCarbonmonoxideList = wsnCarbonmonoxideMapper.findList(wsnCarbonmonoxide);
        //cvtContentList(wsnCarbonmonoxideList);
        return wsnCarbonmonoxideList;
    }

    /**
     * 通过主键ID获取一氧化碳数据表
     * @param id Primary key
     * @return WsnCarbonmonoxide
     */
    @Override
    public WsnCarbonmonoxide findWsnCarbonmonoxideById(Integer id) {
        WsnCarbonmonoxide wsnCarbonmonoxide = wsnCarbonmonoxideMapper.findByPrimaryKey(id);
        return wsnCarbonmonoxide;
    }

    /**
     * 添加一氧化碳数据表
     * @param WsnCarbonmonoxide
     */
    @Override
    public void saveWsnCarbonmonoxide(WsnCarbonmonoxide wsnCarbonmonoxide) {
        SysUser currentUser = userRealm.getCurrentUser();
      /*  wsnCarbonmonoxide.setDeleteFlag("0");
        wsnCarbonmonoxide.setCreator(currentUser.getUserName());
        wsnCarbonmonoxide.setModifier(currentUser.getUserName());
        wsnCarbonmonoxide.setCreateDate(new Date());
        wsnCarbonmonoxide.setModifyDate(new Date());*/
        wsnCarbonmonoxideMapper.save(wsnCarbonmonoxide);
        
    }

    /**
     * 更新一氧化碳数据表
     * 根据WsnCarbonmonoxide的主键更新主键以外的其他字段
     * @param WsnCarbonmonoxide
     */
    @Override
    public void updateWsnCarbonmonoxideById(WsnCarbonmonoxide wsnCarbonmonoxide) {
        SysUser currentUser = userRealm.getCurrentUser();
        /*wsnCarbonmonoxide.setModifier(currentUser.getUserName());
        wsnCarbonmonoxide.setModifyDate(new Date());*/
        wsnCarbonmonoxideMapper.updateByPrimaryKey(wsnCarbonmonoxide);
        
    }

    /**
     * 根据主键批量删除一氧化碳数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnCarbonmonoxideByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnCarbonmonoxide wsnCarbonmonoxide = new WsnCarbonmonoxide();
      /*  wsnCarbonmonoxide.setDeleteFlag("1");
        wsnCarbonmonoxide.setModifier(currentUser.getUserName());
        wsnCarbonmonoxide.setModifyDate(new Date());*/
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnCarbonmonoxide.setId(Integer.parseInt(id));
            wsnCarbonmonoxideMapper.updateByPrimaryKey(wsnCarbonmonoxide);
        }
    }
    
    //private void cvtContentList(List<WsnCarbonmonoxide> WsnCarbonmonoxideList) {
    //    for(WsnCarbonmonoxide wsnCarbonmonoxide : WsnCarbonmonoxideList) {
    //    }
    //}
}

