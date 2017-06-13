package com.ai.mnt.service.device;

import java.util.List;

import com.ai.mnt.model.device.WsnDevice;

/**
 * @Title: WsnDeviceService 
 * @Description: WsnDeviceService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-10-4
 */

public interface WsnDeviceService {
    
    /**
     * 获取所有设备信息列表
     * @return List<WsnDevice>
     */
    public List<WsnDevice> findAllWsnDevice();
    
    
    /**
     * 获取设备信息列表
     * @param device
     * @return List<WsnDevice>
     */
    public List<WsnDevice> findWsnDeviceList(WsnDevice wsnDevice);
    
    /**
     * 通过主键ID获取设备信息
     * @param deviceId Primary key
     * @return WsnDevice
     */
    public WsnDevice findWsnDeviceByDeviceId(Integer deviceId);
    
    /**
     * 添加设备信息
     * @param WsnDevice
     */
    public void saveWsnDevice(WsnDevice wsnDevice);
    
    /**
     * 更新设备信息
     * 根据WsnDevice的主键更新主键以外的其他字段
     * @param WsnDevice
     */
    public void updateWsnDeviceByDeviceId(WsnDevice wsnDevice);
    
    /**
     * 根据主键批量删除设备信息 
     * 非物理删除 修改删除标识
     * @param deviceId Primary key
     */
    public void deleteWsnDeviceByDeviceIds(String deviceIds);


    public void saveWsnDevicebind(WsnDevice wsnDevice, String deviceRfid);
}
