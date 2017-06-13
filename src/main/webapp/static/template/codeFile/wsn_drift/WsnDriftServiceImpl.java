package com.ai.mnt.service.sensor.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sensor.WsnDrift;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sensor.WsnDriftMapper;
import com.ai.mnt.service.sensor.WsnDriftService;

/**
 * @Title: WsnDriftServiceImpl 
 * @Description: WsnDriftServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */
@Service
public class WsnDriftServiceImpl implements WsnDriftService{

    @Autowired
    WsnDriftMapper wsnDriftMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有位移数据表列表
     * @return List<WsnDrift>
     */
    @Override
    public List<WsnDrift> findAllWsnDrift() {
        List<WsnDrift> wsnDriftList = wsnDriftMapper.findAll();
        //cvtContentList(wsnDriftList);
        return wsnDriftList;
    }

    /**
     * 获取位移数据表列表
     * @param sensor
     * @return List<WsnDrift>
     */
    @Override
    public List<WsnDrift> findWsnDriftList(WsnDrift wsnDrift) {
        List<WsnDrift> wsnDriftList = wsnDriftMapper.findList(wsnDrift);
        //cvtContentList(wsnDriftList);
        return wsnDriftList;
    }

    /**
     * 通过主键ID获取位移数据表
     * @param id Primary key
     * @return WsnDrift
     */
    @Override
    public WsnDrift findWsnDriftById(Integer id) {
        WsnDrift wsnDrift = wsnDriftMapper.findByPrimaryKey(id);
        return wsnDrift;
    }

    /**
     * 添加位移数据表
     * @param WsnDrift
     */
    @Override
    public void saveWsnDrift(WsnDrift wsnDrift) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnDrift.setDeleteFlag("0");
        wsnDrift.setCreator(currentUser.getUserName());
        wsnDrift.setModifier(currentUser.getUserName());
        wsnDrift.setCreateDate(new Date());
        wsnDrift.setModifyDate(new Date());
        wsnDriftMapper.save(wsnDrift);
        
    }

    /**
     * 更新位移数据表
     * 根据WsnDrift的主键更新主键以外的其他字段
     * @param WsnDrift
     */
    @Override
    public void updateWsnDriftById(WsnDrift wsnDrift) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnDrift.setModifier(currentUser.getUserName());
        wsnDrift.setModifyDate(new Date());
        wsnDriftMapper.updateByPrimaryKey(wsnDrift);
        
    }

    /**
     * 根据主键批量删除位移数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnDriftByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnDrift wsnDrift = new WsnDrift();
        wsnDrift.setDeleteFlag("1");
        wsnDrift.setModifier(currentUser.getUserName());
        wsnDrift.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnDrift.setId(Integer.parseInt(id));
            wsnDriftMapper.updateByPrimaryKey(wsnDrift);
        }
    }
    
    //private void cvtContentList(List<WsnDrift> WsnDriftList) {
    //    for(WsnDrift wsnDrift : WsnDriftList) {
    //    }
    //}
}

