package com.ai.mnt.service.device;

import java.util.List;
import java.util.Map;

import com.ai.mnt.model.device.WsnHardwareInfo;

/**
 * @Title: WsnHardwareInfoService 
 * @Description: WsnHardwareInfoService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-10-28
 */

public interface WsnHardwareInfoService {
    
    /**
     * 获取所有硬件信息表列表
     * @return List<WsnHardwareInfo>
     */
    public List<WsnHardwareInfo> findAllWsnHardwareInfo();
    
    
    /**
     * 获取硬件信息表列表
     * @param device
     * @return List<WsnHardwareInfo>
     */
    public List<WsnHardwareInfo> findWsnHardwareInfoList(WsnHardwareInfo wsnHardwareInfo);
    
    /**
     * 通过主键ID获取硬件信息表
     * 
     * @param wareId Primary key
     * @return WsnHardwareInfo
     */
    public WsnHardwareInfo findWsnHardwareInfoByWareId(String wareId);
    
    /**
     * 通过主键ID获取硬件信息表
     * @param wareId Primary key
     * @return WsnHardwareInfo
     */
    public WsnHardwareInfo findWsnHardwareInfoByWareId2(Integer wareId);
    /**
     * 添加硬件信息表
     * @param WsnHardwareInfo
     */
    public void saveWsnHardwareInfo(WsnHardwareInfo wsnHardwareInfo);
    
    /**
     * 更新硬件信息表
     * 根据WsnHardwareInfo的主键更新主键以外的其他字段
     * @param WsnHardwareInfo
     */
    public void updateWsnHardwareInfoByWareId(WsnHardwareInfo wsnHardwareInfo);
    
    /**
     * 根据主键批量删除硬件信息表 
     * 非物理删除 修改删除标识
     * @param wareId Primary key
     */
    public void deleteWsnHardwareInfoByWareIds(String wareIds);

    
    public List<WsnHardwareInfo> findWsnHardwareInfoListByInfo3(String infoThree);


    public List<WsnHardwareInfo> findWsnHardwareInfoListByInfo2(String infoThree);


    public List<WsnHardwareInfo> findWsnHardwareInfoListByInfo1(String info1);

    /**
     * 根据对监控象获取硬件信息表列表
     * @param opt
     * @return List<WsnHardwareInfo>
     */
    public List<WsnHardwareInfo> findWsnHardByObj(String opt);


    /**
     * 根据主键获取硬件信息
     * @param wareId
     * @return WsnHardwareInfo
     */
    public WsnHardwareInfo findWsnHardwareInfoByWare(String wareId);

    /**
     * 根据设备类型获取硬件信息表列表
     * @param i
     * @return List<WsnHardwareInfo>
     */
    public List<WsnHardwareInfo> findSensorByType(int i);
    
    
    public List<Map<String,Object>> findAllWsnDebugInfo(int i);
    /**
     * 根据监控对象状态
     * @param wsnMonitorObjList
     * @return List<Map<String, Object>>
     */
    public List<Map<String, Object>> state(List<Map<String, Object>> wsnMonitorObjList);
}
