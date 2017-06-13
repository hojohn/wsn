package com.ai.mnt.service.device.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.exception.MntDataAccessException;
import com.ai.mnt.model.device.WsnDevice;
import com.ai.mnt.model.device.WsnRfid;
import com.ai.mnt.model.device.WsnDevRfid;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.device.WsnDevRfidMapper;
import com.ai.mnt.persistence.device.WsnDeviceMapper;
import com.ai.mnt.persistence.device.WsnRfidMapper;
import com.ai.mnt.service.device.WsnDeviceService;

/**
 * @Title: WsnDeviceServiceImpl 
 * @Description: WsnDeviceServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-4
 */
@Service
public class WsnDeviceServiceImpl implements WsnDeviceService{

    @Autowired
    WsnDeviceMapper wsnDeviceMapper;
    
    @Autowired
    WsnRfidMapper wsnRfidMapper;
    
    @Autowired
    WsnDevRfidMapper wsnDevRfidMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有设备信息列表
     * @return List<WsnDevice>
     */
    @Override
    public List<WsnDevice> findAllWsnDevice() {
        List<WsnDevice> wsnDeviceList = wsnDeviceMapper.findAll();
        //cvtContentList(wsnDeviceList);
        return wsnDeviceList;
    }

    /**
     * 获取设备信息列表
     * @param device
     * @return List<WsnDevice>
     */
    @Override
    public List<WsnDevice> findWsnDeviceList(WsnDevice wsnDevice) {
        List<WsnDevice> wsnDeviceList = wsnDeviceMapper.findList(wsnDevice);
        //cvtContentList(wsnDeviceList);
        return wsnDeviceList;
    }

    /**
     * 通过主键ID获取设备信息
     * @param deviceId Primary key
     * @return WsnDevice
     */
    @Override
    public WsnDevice findWsnDeviceByDeviceId(Integer deviceId) {
        WsnDevice wsnDevice = wsnDeviceMapper.findByPrimaryKey(deviceId);
        return wsnDevice;
    }

    /**
     * 添加设备信息
     * @param WsnDevice
     */
    @Override
    public void saveWsnDevice(WsnDevice wsnDevice) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnDevice.setDeleteFlag("0");
        wsnDevice.setCreator(currentUser.getUserName());
        wsnDevice.setModifier(currentUser.getUserName());
        wsnDevice.setCreateDate(new Date());
        wsnDevice.setModifyDate(new Date());
        wsnDeviceMapper.save(wsnDevice);
        
    }

    /**
     * 更新设备信息
     * 根据WsnDevice的主键更新主键以外的其他字段
     * @param WsnDevice
     */
    @Override
    public void updateWsnDeviceByDeviceId(WsnDevice wsnDevice) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnDevice.setModifier(currentUser.getUserName());
        wsnDevice.setModifyDate(new Date());
        wsnDeviceMapper.updateByPrimaryKey(wsnDevice);
        
    }

    /**
     * 根据主键批量删除设备信息 
     * 非物理删除 修改删除标识
     * @param deviceId Primary key
     */
    @Override
    public void deleteWsnDeviceByDeviceIds(String deviceIds) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnDevice wsnDevice = new WsnDevice();
        wsnDevice.setDeleteFlag("1");
        wsnDevice.setModifier(currentUser.getUserName());
        wsnDevice.setModifyDate(new Date());
        String[] deviceIdAry = deviceIds.split(",");
        for(String deviceId : deviceIdAry) {
            wsnDevice.setDeviceId(Integer.parseInt(deviceId));
            wsnDeviceMapper.updateByPrimaryKey(wsnDevice);
        }
    }

    @Override
    public void saveWsnDevicebind(WsnDevice wsnDevice, String deviceRfid)
            throws MntDataAccessException{
        WsnRfid wsnRfid = new WsnRfid();
        wsnRfid.setRfidBindNumber(deviceRfid);
        List<WsnRfid>wsnRfidList = wsnRfidMapper.findList(wsnRfid);
        if (wsnRfidList.size() ==0 || wsnRfidList ==null) {
            throw new MntDataAccessException("该RFID不存在");
        }
        System.out.println(wsnRfidList.size()+"--------------");
        int rfid = wsnRfidList.get(0).getRfidId();
        System.out.println(rfid);
        WsnDevRfid wsnDevRfid = new WsnDevRfid();
        wsnDevRfid.setRfidId(rfid);
        wsnDevRfid.setDeviceId(wsnDevice.getDeviceId());
        wsnDevRfidMapper.save(wsnDevRfid);
        
    }
    
    //private void cvtContentList(List<WsnDevice> WsnDeviceList) {
    //    for(WsnDevice wsnDevice : WsnDeviceList) {
    //    }
    //}Integer.parseInt(deviceId)
}

