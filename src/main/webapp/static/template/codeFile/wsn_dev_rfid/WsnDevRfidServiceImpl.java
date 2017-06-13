package com.ai.mnt.service.device.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.device.WsnDevRfid;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.device.WsnDevRfidMapper;
import com.ai.mnt.service.device.WsnDevRfidService;

/**
 * @Title: WsnDevRfidServiceImpl 
 * @Description: WsnDevRfidServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-20
 */
@Service
public class WsnDevRfidServiceImpl implements WsnDevRfidService{

    @Autowired
    WsnDevRfidMapper wsnDevRfidMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有标签设备关联列表
     * @return List<WsnDevRfid>
     */
    @Override
    public List<WsnDevRfid> findAllWsnDevRfid() {
        List<WsnDevRfid> wsnDevRfidList = wsnDevRfidMapper.findAll();
        //cvtContentList(wsnDevRfidList);
        return wsnDevRfidList;
    }

    /**
     * 获取标签设备关联列表
     * @param device
     * @return List<WsnDevRfid>
     */
    @Override
    public List<WsnDevRfid> findWsnDevRfidList(WsnDevRfid wsnDevRfid) {
        List<WsnDevRfid> wsnDevRfidList = wsnDevRfidMapper.findList(wsnDevRfid);
        //cvtContentList(wsnDevRfidList);
        return wsnDevRfidList;
    }

    /**
     * 通过主键ID获取标签设备关联
     * @param rfDevId Primary key
     * @return WsnDevRfid
     */
    @Override
    public WsnDevRfid findWsnDevRfidByRfDevId(Integer rfDevId) {
        WsnDevRfid wsnDevRfid = wsnDevRfidMapper.findByPrimaryKey(rfDevId);
        return wsnDevRfid;
    }

    /**
     * 添加标签设备关联
     * @param WsnDevRfid
     */
    @Override
    public void saveWsnDevRfid(WsnDevRfid wsnDevRfid) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnDevRfid.setDeleteFlag("0");
        wsnDevRfid.setCreator(currentUser.getUserName());
        wsnDevRfid.setModifier(currentUser.getUserName());
        wsnDevRfid.setCreateDate(new Date());
        wsnDevRfid.setModifyDate(new Date());
        wsnDevRfidMapper.save(wsnDevRfid);
        
    }

    /**
     * 更新标签设备关联
     * 根据WsnDevRfid的主键更新主键以外的其他字段
     * @param WsnDevRfid
     */
    @Override
    public void updateWsnDevRfidByRfDevId(WsnDevRfid wsnDevRfid) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnDevRfid.setModifier(currentUser.getUserName());
        wsnDevRfid.setModifyDate(new Date());
        wsnDevRfidMapper.updateByPrimaryKey(wsnDevRfid);
        
    }

    /**
     * 根据主键批量删除标签设备关联 
     * 非物理删除 修改删除标识
     * @param rfDevId Primary key
     */
    @Override
    public void deleteWsnDevRfidByRfDevIds(String rfDevIds) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnDevRfid wsnDevRfid = new WsnDevRfid();
        wsnDevRfid.setDeleteFlag("1");
        wsnDevRfid.setModifier(currentUser.getUserName());
        wsnDevRfid.setModifyDate(new Date());
        String[] rfDevIdAry = rfDevIds.split(",");
        for(String rfDevId : rfDevIdAry) {
            wsnDevRfid.setRfDevId(Integer.parseInt(rfDevId));
            wsnDevRfidMapper.updateByPrimaryKey(wsnDevRfid);
        }
    }
    
    //private void cvtContentList(List<WsnDevRfid> WsnDevRfidList) {
    //    for(WsnDevRfid wsnDevRfid : WsnDevRfidList) {
    //    }
    //}
}

