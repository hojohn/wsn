package com.ai.mnt.service.device.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.device.WsnDeviceRepair;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.device.WsnDeviceRepairMapper;
import com.ai.mnt.service.device.WsnDeviceRepairService;

/**
 * @Title: WsnDeviceRepairServiceImpl 
 * @Description: WsnDeviceRepairServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-15
 */
@Service
public class WsnDeviceRepairServiceImpl implements WsnDeviceRepairService{

    @Autowired
    WsnDeviceRepairMapper wsnDeviceRepairMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有维修记录列表
     * @return List<WsnDeviceRepair>
     */
    @Override
    public List<WsnDeviceRepair> findAllWsnDeviceRepair() {
        List<WsnDeviceRepair> wsnDeviceRepairList = wsnDeviceRepairMapper.findAll();
        //cvtContentList(wsnDeviceRepairList);
        return wsnDeviceRepairList;
    }

    /**
     * 获取维修记录列表
     * @param device
     * @return List<WsnDeviceRepair>
     */
    @Override
    public List<WsnDeviceRepair> findWsnDeviceRepairList(WsnDeviceRepair wsnDeviceRepair) {
        List<WsnDeviceRepair> wsnDeviceRepairList = wsnDeviceRepairMapper.findList(wsnDeviceRepair);
        //cvtContentList(wsnDeviceRepairList);
        return wsnDeviceRepairList;
    }

    /**
     * 通过主键ID获取维修记录
     * @param repairId Primary key
     * @return WsnDeviceRepair
     */
    @Override
    public WsnDeviceRepair findWsnDeviceRepairByRepairId(Integer repairId) {
        WsnDeviceRepair wsnDeviceRepair = wsnDeviceRepairMapper.findByPrimaryKey(repairId);
        return wsnDeviceRepair;
    }

    /**
     * 添加维修记录
     * @param WsnDeviceRepair
     */
    @Override
    public void saveWsnDeviceRepair(WsnDeviceRepair wsnDeviceRepair) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnDeviceRepair.setDeleteFlag("0");
        wsnDeviceRepair.setCreator(currentUser.getUserName());
        wsnDeviceRepair.setModifier(currentUser.getUserName());
        wsnDeviceRepair.setCreateDate(new Date());
        wsnDeviceRepair.setModifyDate(new Date());
        wsnDeviceRepairMapper.save(wsnDeviceRepair);
        
    }

    /**
     * 更新维修记录
     * 根据WsnDeviceRepair的主键更新主键以外的其他字段
     * @param WsnDeviceRepair
     */
    @Override
    public void updateWsnDeviceRepairByRepairId(WsnDeviceRepair wsnDeviceRepair) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnDeviceRepair.setModifier(currentUser.getUserName());
        wsnDeviceRepair.setModifyDate(new Date());
        wsnDeviceRepairMapper.updateByPrimaryKey(wsnDeviceRepair);
        
    }

    /**
     * 根据主键批量删除维修记录 
     * 非物理删除 修改删除标识
     * @param repairId Primary key
     */
    @Override
    public void deleteWsnDeviceRepairByRepairIds(String repairIds) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnDeviceRepair wsnDeviceRepair = new WsnDeviceRepair();
        wsnDeviceRepair.setDeleteFlag("1");
        wsnDeviceRepair.setModifier(currentUser.getUserName());
        wsnDeviceRepair.setModifyDate(new Date());
        String[] repairIdAry = repairIds.split(",");
        for(String repairId : repairIdAry) {
            wsnDeviceRepair.setRepairId(Integer.parseInt(repairId));
            wsnDeviceRepairMapper.updateByPrimaryKey(wsnDeviceRepair);
        }
    }
    
    //private void cvtContentList(List<WsnDeviceRepair> WsnDeviceRepairList) {
    //    for(WsnDeviceRepair wsnDeviceRepair : WsnDeviceRepairList) {
    //    }
    //}
}

