package com.ai.mnt.service.sensor.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sensor.WsnCarbondioxide;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sensor.WsnCarbondioxideMapper;
import com.ai.mnt.service.sensor.WsnCarbondioxideService;

/**
 * @Title: WsnCarbondioxideServiceImpl 
 * @Description: WsnCarbondioxideServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */
@Service
public class WsnCarbondioxideServiceImpl implements WsnCarbondioxideService{

    @Autowired
    WsnCarbondioxideMapper wsnCarbondioxideMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有二氧化碳数据表列表
     * @return List<WsnCarbondioxide>
     */
    @Override
    public List<WsnCarbondioxide> findAllWsnCarbondioxide() {
        List<WsnCarbondioxide> wsnCarbondioxideList = wsnCarbondioxideMapper.findAll();
        //cvtContentList(wsnCarbondioxideList);
        return wsnCarbondioxideList;
    }

    /**
     * 获取二氧化碳数据表列表
     * @param sensor
     * @return List<WsnCarbondioxide>
     */
    @Override
    public List<WsnCarbondioxide> findWsnCarbondioxideList(WsnCarbondioxide wsnCarbondioxide) {
        List<WsnCarbondioxide> wsnCarbondioxideList = wsnCarbondioxideMapper.findList(wsnCarbondioxide);
        //cvtContentList(wsnCarbondioxideList);
        return wsnCarbondioxideList;
    }

    /**
     * 通过主键ID获取二氧化碳数据表
     * @param id Primary key
     * @return WsnCarbondioxide
     */
    @Override
    public WsnCarbondioxide findWsnCarbondioxideById(Integer id) {
        WsnCarbondioxide wsnCarbondioxide = wsnCarbondioxideMapper.findByPrimaryKey(id);
        return wsnCarbondioxide;
    }

    /**
     * 添加二氧化碳数据表
     * @param WsnCarbondioxide
     */
    @Override
    public void saveWsnCarbondioxide(WsnCarbondioxide wsnCarbondioxide) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnCarbondioxide.setDeleteFlag("0");
        wsnCarbondioxide.setCreator(currentUser.getUserName());
        wsnCarbondioxide.setModifier(currentUser.getUserName());
        wsnCarbondioxide.setCreateDate(new Date());
        wsnCarbondioxide.setModifyDate(new Date());
        wsnCarbondioxideMapper.save(wsnCarbondioxide);
        
    }

    /**
     * 更新二氧化碳数据表
     * 根据WsnCarbondioxide的主键更新主键以外的其他字段
     * @param WsnCarbondioxide
     */
    @Override
    public void updateWsnCarbondioxideById(WsnCarbondioxide wsnCarbondioxide) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnCarbondioxide.setModifier(currentUser.getUserName());
        wsnCarbondioxide.setModifyDate(new Date());
        wsnCarbondioxideMapper.updateByPrimaryKey(wsnCarbondioxide);
        
    }

    /**
     * 根据主键批量删除二氧化碳数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnCarbondioxideByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnCarbondioxide wsnCarbondioxide = new WsnCarbondioxide();
        wsnCarbondioxide.setDeleteFlag("1");
        wsnCarbondioxide.setModifier(currentUser.getUserName());
        wsnCarbondioxide.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnCarbondioxide.setId(Integer.parseInt(id));
            wsnCarbondioxideMapper.updateByPrimaryKey(wsnCarbondioxide);
        }
    }
    
    //private void cvtContentList(List<WsnCarbondioxide> WsnCarbondioxideList) {
    //    for(WsnCarbondioxide wsnCarbondioxide : WsnCarbondioxideList) {
    //    }
    //}
}

