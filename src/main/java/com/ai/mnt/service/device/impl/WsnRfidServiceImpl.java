package com.ai.mnt.service.device.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.device.WsnRfid;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.device.WsnRfidMapper;
import com.ai.mnt.service.device.WsnRfidService;

/**
 * @Title: WsnRfidServiceImpl 
 * @Description: WsnRfidServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-18
 */
@Service
public class WsnRfidServiceImpl implements WsnRfidService{

    @Autowired
    WsnRfidMapper wsnRfidMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有RFID管理列表
     * @return List<WsnRfid>
     */
    @Override
    public List<WsnRfid> findAllWsnRfid() {
        List<WsnRfid> wsnRfidList = wsnRfidMapper.findAll();
        //cvtContentList(wsnRfidList);
        return wsnRfidList;
    }

    /**
     * 获取RFID管理列表
     * @param device
     * @return List<WsnRfid>
     */
    @Override
    public List<WsnRfid> findWsnRfidList(WsnRfid wsnRfid) {
        List<WsnRfid> wsnRfidList = wsnRfidMapper.findList(wsnRfid);
        //cvtContentList(wsnRfidList);
        return wsnRfidList;
    }

    /**
     * 通过主键ID获取RFID管理
     * @param rfidId Primary key
     * @return WsnRfid
     */
    @Override
    public WsnRfid findWsnRfidByRfidId(Integer rfidId) {
        WsnRfid wsnRfid = wsnRfidMapper.findByPrimaryKey(rfidId);
        return wsnRfid;
    }

    /**
     * 添加RFID管理
     * @param WsnRfid
     */
    @Override
    public void saveWsnRfid(WsnRfid wsnRfid) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnRfid.setDeleteFlag("0");
        wsnRfid.setCreator(currentUser.getUserName());
        wsnRfid.setModifier(currentUser.getUserName());
        wsnRfid.setCreateDate(new Date());
        wsnRfid.setModifyDate(new Date());
        wsnRfidMapper.save(wsnRfid);
        
    }

    /**
     * 更新RFID管理
     * 根据WsnRfid的主键更新主键以外的其他字段
     * @param WsnRfid
     */
    @Override
    public void updateWsnRfidByRfidId(WsnRfid wsnRfid) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnRfid.setModifier(currentUser.getUserName());
        wsnRfid.setModifyDate(new Date());
        wsnRfidMapper.updateByPrimaryKey(wsnRfid);
        
    }

    /**
     * 根据主键批量删除RFID管理 
     * 非物理删除 修改删除标识
     * @param rfidId Primary key
     */
    @Override
    public void deleteWsnRfidByRfidIds(String rfidIds) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnRfid wsnRfid = new WsnRfid();
        wsnRfid.setDeleteFlag("1");
        wsnRfid.setModifier(currentUser.getUserName());
        wsnRfid.setModifyDate(new Date());
        String[] rfidIdAry = rfidIds.split(",");
        for(String rfidId : rfidIdAry) {
            wsnRfid.setRfidId(Integer.parseInt(rfidId));
            wsnRfidMapper.updateByPrimaryKey(wsnRfid);
        }
    }
    
    //private void cvtContentList(List<WsnRfid> WsnRfidList) {
    //    for(WsnRfid wsnRfid : WsnRfidList) {
    //    }
    //}
}

