package com.ai.mnt.service.device.impl;


import java.util.List;
import java.util.Date;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.device.WsnHardwareInfo;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.device.WsnHardwareInfoMapper;
import com.ai.mnt.service.device.WsnHardwareInfoService;
import com.ai.mnt.web.debug.PingIP;
import com.mysql.fabric.xmlrpc.base.Data;

/**
 * @Title: WsnHardwareInfoServiceImpl 
 * @Description: WsnHardwareInfoServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-28
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
     *  @Override
    public WsnHardwareInfo findWsnHardwareInfoByWare(String wareId) {
        WsnHardwareInfo wsnHardwareInfos = wsnHardwareInfoMapper.findByPrimary(wareId);
        return wsnHardwareInfos;
    }
     * 
     * @param wareId Primary key
     * @return WsnHardwareInfo
     */
    @Override
    public WsnHardwareInfo findWsnHardwareInfoByWareId(String wareId) {
        WsnHardwareInfo wsnHardwareInfo = wsnHardwareInfoMapper.findByPrimary(wareId);
        return wsnHardwareInfo;
    }
    
    /**
     * 通过主键ID获取硬件信息表=============================
     * @param wareId Primary key
     * @return WsnHardwareInfo
     */
    @Override
    public WsnHardwareInfo findWsnHardwareInfoByWareId2(Integer wareId) {
        WsnHardwareInfo wsnHardwareInfo = wsnHardwareInfoMapper.findTxtByPrimaryKey(wareId);
        System.out.println(wsnHardwareInfo.getGetewaytxt());
        return wsnHardwareInfo;
    }

    /**
     * 添加硬件信息表
     * @param WsnHardwareInfo
     */
    @Override
    public void saveWsnHardwareInfo(WsnHardwareInfo wsnHardwareInfo) {
        wsnHardwareInfoMapper.save(wsnHardwareInfo);
        
    }

    /**
     * 更新硬件信息表
     * 根据WsnHardwareInfo的主键更新主键以外的其他字段
     * @param WsnHardwareInfo
     */
    @Override
    public void updateWsnHardwareInfoByWareId(WsnHardwareInfo wsnHardwareInfo) {
        wsnHardwareInfo.setUpdateTime(new Date());
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
       
        String[] wareIdAry = wareIds.split(",");
       
    }

    @Override
    public List<WsnHardwareInfo> findWsnHardwareInfoListByInfo3(String wareId) {
        List<WsnHardwareInfo> sensorList= wsnHardwareInfoMapper.findListByInfo3(wareId);
        return sensorList;
    }

    @Override
    public List<WsnHardwareInfo> findWsnHardwareInfoListByInfo2(String infoThree) {
        List<WsnHardwareInfo> temList= wsnHardwareInfoMapper.findListByInfo2(infoThree);
        return temList;
    }

    @Override
    public List<WsnHardwareInfo> findWsnHardwareInfoListByInfo1(String info1) {
        List<WsnHardwareInfo>senList = wsnHardwareInfoMapper.findListByInfo1(info1);
        return senList;
    }

    @Override
    public List<WsnHardwareInfo> findWsnHardByObj(String opt) {
        List<WsnHardwareInfo>wsnHardwareInfos = wsnHardwareInfoMapper.findByRemark2(opt);
        return wsnHardwareInfos;
    }
//
    @Override
    public WsnHardwareInfo findWsnHardwareInfoByWare(String wareId) {
        WsnHardwareInfo wsnHardwareInfos = wsnHardwareInfoMapper.findByPrimary(wareId);
        return wsnHardwareInfos;
    }

    @Override
    public List<WsnHardwareInfo> findSensorByType(int i) {
        List<WsnHardwareInfo>wsnHardwareInfos= wsnHardwareInfoMapper.findSensorByType(i);
        return wsnHardwareInfos;
    }
    
    //调取cmd
    @Override
    public List<Map<String,Object>> findAllWsnDebugInfo(int i) {
        // TODO Auto-generated method stub
        List<Map<String,Object>> wsnDebugInfos=wsnHardwareInfoMapper.findDubug(i);
        return wsnDebugInfos;
    }
    @Override
    public List<Map<String, Object>> state(List<Map<String, Object>> wsnMonitorObjList) {
        // TODO Auto-generated method stub
        PingIP pingIP=new PingIP(wsnMonitorObjList);
        List<Map<String, Object>> state=pingIP.startPing();
        return state;
    }
    
}

