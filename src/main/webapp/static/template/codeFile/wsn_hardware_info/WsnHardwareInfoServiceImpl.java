package com.ai.mnt.service.device.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.device.WsnHardwareInfo;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.device.WsnHardwareInfoMapper;
import com.ai.mnt.service.device.WsnHardwareInfoService;

/**
 * @Title: WsnHardwareInfoServiceImpl 
 * @Description: WsnHardwareInfoServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-11-29
 */
@Service
public class WsnHardwareInfoServiceImpl implements WsnHardwareInfoService{

    @Autowired
    WsnHardwareInfoMapper wsnHardwareInfoMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有硬件信息表列表
     * @return List<WsnHardwareInfo>
     */
    @Override
    public List<WsnHardwareInfo> findAllWsnHardwareInfo() {
        List<WsnHardwareInfo> wsnHardwareInfoList = wsnHardwareInfoMapper.findAll();
        //cvtContentList(wsnHardwareInfoList);
        return wsnHardwareInfoList;
    }

    /**
     * 获取硬件信息表列表
     * @param device
     * @return List<WsnHardwareInfo>
     */
    @Override
    public List<WsnHardwareInfo> findWsnHardwareInfoList(WsnHardwareInfo wsnHardwareInfo) {
        List<WsnHardwareInfo> wsnHardwareInfoList = wsnHardwareInfoMapper.findList(wsnHardwareInfo);
        //cvtContentList(wsnHardwareInfoList);
        return wsnHardwareInfoList;
    }

    /**
     * 通过主键ID获取硬件信息表
     * @param wareId Primary key
     * @return WsnHardwareInfo
     */
    @Override
    public WsnHardwareInfo findWsnHardwareInfoByWareId(Integer wareId) {
        WsnHardwareInfo wsnHardwareInfo = wsnHardwareInfoMapper.findByPrimaryKey(wareId);
        return wsnHardwareInfo;
    }

    /**
     * 添加硬件信息表
     * @param WsnHardwareInfo
     */
    @Override
    public void saveWsnHardwareInfo(WsnHardwareInfo wsnHardwareInfo) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnHardwareInfo.setDeleteFlag("0");
        wsnHardwareInfo.setCreator(currentUser.getUserName());
        wsnHardwareInfo.setModifier(currentUser.getUserName());
        wsnHardwareInfo.setCreateDate(new Date());
        wsnHardwareInfo.setModifyDate(new Date());
        wsnHardwareInfoMapper.save(wsnHardwareInfo);
        
    }

    /**
     * 更新硬件信息表
     * 根据WsnHardwareInfo的主键更新主键以外的其他字段
     * @param WsnHardwareInfo
     */
    @Override
    public void updateWsnHardwareInfoByWareId(WsnHardwareInfo wsnHardwareInfo) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnHardwareInfo.setModifier(currentUser.getUserName());
        wsnHardwareInfo.setModifyDate(new Date());
        wsnHardwareInfoMapper.updateByPrimaryKey(wsnHardwareInfo);
        
    }

    /**
     * 根据主键批量删除硬件信息表 
     * 非物理删除 修改删除标识
     * @param wareId Primary key
     */
    @Override
    public void deleteWsnHardwareInfoByWareIds(String wareIds) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnHardwareInfo wsnHardwareInfo = new WsnHardwareInfo();
        wsnHardwareInfo.setDeleteFlag("1");
        wsnHardwareInfo.setModifier(currentUser.getUserName());
        wsnHardwareInfo.setModifyDate(new Date());
        String[] wareIdAry = wareIds.split(",");
        for(String wareId : wareIdAry) {
            wsnHardwareInfo.setWareId(Integer.parseInt(wareId));
            wsnHardwareInfoMapper.updateByPrimaryKey(wsnHardwareInfo);
        }
    }
    
    //private void cvtContentList(List<WsnHardwareInfo> WsnHardwareInfoList) {
    //    for(WsnHardwareInfo wsnHardwareInfo : WsnHardwareInfoList) {
    //    }
    //}
}

