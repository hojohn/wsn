package com.ai.mnt.service.device.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.device.WsnGeteway;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.device.WsnGetewayMapper;
import com.ai.mnt.service.device.WsnGetewayService;

/**
 * @Title: WsnGetewayServiceImpl 
 * @Description: WsnGetewayServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-28
 */
@Service
public class WsnGetewayServiceImpl implements WsnGetewayService{

    @Autowired
    WsnGetewayMapper wsnGetewayMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有网关表列表
     * @return List<WsnGeteway>
     */
    @Override
    public List<WsnGeteway> findAllWsnGeteway() {
        List<WsnGeteway> wsnGetewayList = wsnGetewayMapper.findAll();
        //cvtContentList(wsnGetewayList);
        return wsnGetewayList;
    }

    /**
     * 获取网关表列表
     * @param device
     * @return List<WsnGeteway>
     */
    @Override
    public List<WsnGeteway> findWsnGetewayList(WsnGeteway wsnGeteway) {
        List<WsnGeteway> wsnGetewayList = wsnGetewayMapper.findList(wsnGeteway);
        //cvtContentList(wsnGetewayList);
        return wsnGetewayList;
    }

    /**
     * 通过主键ID获取网关表
     * @param gatewayId Primary key
     * @return WsnGeteway
     */
    @Override
    public WsnGeteway findWsnGetewayByGatewayId(Integer gatewayId) {
        WsnGeteway wsnGeteway = wsnGetewayMapper.findByPrimaryKey(gatewayId);
        return wsnGeteway;
    }

    /**
     * 添加网关表
     * @param WsnGeteway
     */
    @Override
    public void saveWsnGeteway(WsnGeteway wsnGeteway) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnGeteway.setDeleteFlag("0");
        wsnGeteway.setCreator(currentUser.getUserName());
        wsnGeteway.setModifier(currentUser.getUserName());
        wsnGeteway.setCreateDate(new Date());
        wsnGeteway.setModifyDate(new Date());
        wsnGetewayMapper.save(wsnGeteway);
        
    }

    /**
     * 更新网关表
     * 根据WsnGeteway的主键更新主键以外的其他字段
     * @param WsnGeteway
     */
    @Override
    public void updateWsnGetewayByGatewayId(WsnGeteway wsnGeteway) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnGeteway.setModifier(currentUser.getUserName());
        wsnGeteway.setModifyDate(new Date());
        wsnGetewayMapper.updateByPrimaryKey(wsnGeteway);
        
    }

    /**
     * 根据主键批量删除网关表 
     * 非物理删除 修改删除标识
     * @param gatewayId Primary key
     */
    @Override
    public void deleteWsnGetewayByGatewayIds(String gatewayIds) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnGeteway wsnGeteway = new WsnGeteway();
        wsnGeteway.setDeleteFlag("1");
        wsnGeteway.setModifier(currentUser.getUserName());
        wsnGeteway.setModifyDate(new Date());
        String[] gatewayIdAry = gatewayIds.split(",");
        for(String gatewayId : gatewayIdAry) {
            wsnGeteway.setGatewayId(Integer.parseInt(gatewayId));
            wsnGetewayMapper.updateByPrimaryKey(wsnGeteway);
        }
    }
    
    //private void cvtContentList(List<WsnGeteway> WsnGetewayList) {
    //    for(WsnGeteway wsnGeteway : WsnGetewayList) {
    //    }
    //}
}

