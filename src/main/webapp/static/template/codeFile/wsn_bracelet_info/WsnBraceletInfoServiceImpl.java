package com.ai.mnt.service.bracelet.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.bracelet.WsnBraceletInfo;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.bracelet.WsnBraceletInfoMapper;
import com.ai.mnt.service.bracelet.WsnBraceletInfoService;

/**
 * @Title: WsnBraceletInfoServiceImpl 
 * @Description: WsnBraceletInfoServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-7
 */
@Service
public class WsnBraceletInfoServiceImpl implements WsnBraceletInfoService{

    @Autowired
    WsnBraceletInfoMapper wsnBraceletInfoMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有可穿戴设备信息表列表
     * @return List<WsnBraceletInfo>
     */
    @Override
    public List<WsnBraceletInfo> findAllWsnBraceletInfo() {
        List<WsnBraceletInfo> wsnBraceletInfoList = wsnBraceletInfoMapper.findAll();
        //cvtContentList(wsnBraceletInfoList);
        return wsnBraceletInfoList;
    }

    /**
     * 获取可穿戴设备信息表列表
     * @param bracelet
     * @return List<WsnBraceletInfo>
     */
    @Override
    public List<WsnBraceletInfo> findWsnBraceletInfoList(WsnBraceletInfo wsnBraceletInfo) {
        List<WsnBraceletInfo> wsnBraceletInfoList = wsnBraceletInfoMapper.findList(wsnBraceletInfo);
        //cvtContentList(wsnBraceletInfoList);
        return wsnBraceletInfoList;
    }

    /**
     * 通过主键ID获取可穿戴设备信息表
     * @param bwareId Primary key
     * @return WsnBraceletInfo
     */
    @Override
    public WsnBraceletInfo findWsnBraceletInfoByBwareId(Integer bwareId) {
        WsnBraceletInfo wsnBraceletInfo = wsnBraceletInfoMapper.findByPrimaryKey(bwareId);
        return wsnBraceletInfo;
    }

    /**
     * 添加可穿戴设备信息表
     * @param WsnBraceletInfo
     */
    @Override
    public void saveWsnBraceletInfo(WsnBraceletInfo wsnBraceletInfo) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnBraceletInfo.setDeleteFlag("0");
        wsnBraceletInfo.setCreator(currentUser.getUserName());
        wsnBraceletInfo.setModifier(currentUser.getUserName());
        wsnBraceletInfo.setCreateDate(new Date());
        wsnBraceletInfo.setModifyDate(new Date());
        wsnBraceletInfoMapper.save(wsnBraceletInfo);
        
    }

    /**
     * 更新可穿戴设备信息表
     * 根据WsnBraceletInfo的主键更新主键以外的其他字段
     * @param WsnBraceletInfo
     */
    @Override
    public void updateWsnBraceletInfoByBwareId(WsnBraceletInfo wsnBraceletInfo) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnBraceletInfo.setModifier(currentUser.getUserName());
        wsnBraceletInfo.setModifyDate(new Date());
        wsnBraceletInfoMapper.updateByPrimaryKey(wsnBraceletInfo);
        
    }

    /**
     * 根据主键批量删除可穿戴设备信息表 
     * 非物理删除 修改删除标识
     * @param bwareId Primary key
     */
    @Override
    public void deleteWsnBraceletInfoByBwareIds(String bwareIds) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnBraceletInfo wsnBraceletInfo = new WsnBraceletInfo();
        wsnBraceletInfo.setDeleteFlag("1");
        wsnBraceletInfo.setModifier(currentUser.getUserName());
        wsnBraceletInfo.setModifyDate(new Date());
        String[] bwareIdAry = bwareIds.split(",");
        for(String bwareId : bwareIdAry) {
            wsnBraceletInfo.setBwareId(Integer.parseInt(bwareId));
            wsnBraceletInfoMapper.updateByPrimaryKey(wsnBraceletInfo);
        }
    }
    
    //private void cvtContentList(List<WsnBraceletInfo> WsnBraceletInfoList) {
    //    for(WsnBraceletInfo wsnBraceletInfo : WsnBraceletInfoList) {
    //    }
    //}
}

