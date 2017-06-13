package com.ai.mnt.service.bracelet.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.bracelet.WsnBraceletInfo;
import com.ai.mnt.model.collect.WsnCollectSts;
import com.ai.mnt.model.collect.WsnTray;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.bracelet.WsnBraceletInfoMapper;
import com.ai.mnt.persistence.collect.WsnCollectStsMapper;
import com.ai.mnt.persistence.collect.WsnTrayMapper;
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
    
    @Autowired
    WsnCollectStsMapper wsnCollectStsMapper;
    
    @Autowired
    WsnTrayMapper wsnTrayMapper;
   
    
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
        WsnBraceletInfo wsnBraceletInfo = wsnBraceletInfoMapper.findByWareId(bwareId);
        return wsnBraceletInfo;
    }

    /**
     * 添加可穿戴设备信息表
     * @param WsnBraceletInfo
     */
    @Override
    public void saveWsnBraceletInfo(WsnBraceletInfo wsnBraceletInfo) {
        
        wsnBraceletInfoMapper.save(wsnBraceletInfo);
        
    }

    /**
     * 更新可穿戴设备信息表
     * 根据WsnBraceletInfo的主键更新主键以外的其他字段
     * @param WsnBraceletInfo
     */
    @Override
    public void updateWsnBraceletInfoByBwareId(WsnBraceletInfo wsnBraceletInfo) {
        wsnBraceletInfoMapper.updateByPrimaryKey(wsnBraceletInfo);
        
    }

    @Override
    public void deleteWsnBraceletInfoByBwareIds(String bwareIds) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public List<WsnBraceletInfo> findWsnBraceletInfoByBware(String id) {
       List<WsnBraceletInfo> wsnBraceletInfos = wsnBraceletInfoMapper.findByBware(id);
        return wsnBraceletInfos;
    }

    @Override
    public List<WsnCollectSts> findCollect() {
        List<WsnCollectSts> list = wsnCollectStsMapper.findAll();
        return list;
    }

    @Override
    public void saveWsnSts(WsnCollectSts wsnCollectSts) {
        //wsnCollectStsMapper.save(wsnCollectSts);
        wsnCollectStsMapper.updateByPrimaryKey(wsnCollectSts);
        
    }

  
    @Override
    public List<WsnTray> FindCollect() {
        // TODO Auto-generated method stub 增加的 查更新的时间的
        List<WsnTray> list =wsnTrayMapper.findAll();
        return list;
    }

   

   
}

