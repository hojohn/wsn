package com.ai.mnt.service.device;

import java.util.List;
import com.ai.mnt.model.device.WsnDeviceRepair;

/**
 * @Title: WsnDeviceRepairService 
 * @Description: WsnDeviceRepairService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-10-15
 */

public interface WsnDeviceRepairService {
    
    /**
     * 获取所有维修记录列表
     * @return List<WsnDeviceRepair>
     */
    public List<WsnDeviceRepair> findAllWsnDeviceRepair();
    
    
    /**
     * 获取维修记录列表
     * @param device
     * @return List<WsnDeviceRepair>
     */
    public List<WsnDeviceRepair> findWsnDeviceRepairList(WsnDeviceRepair wsnDeviceRepair);
    
    /**
     * 通过主键ID获取维修记录
     * @param repairId Primary key
     * @return WsnDeviceRepair
     */
    public WsnDeviceRepair findWsnDeviceRepairByRepairId(Integer repairId);
    
    /**
     * 添加维修记录
     * @param WsnDeviceRepair
     */
    public void saveWsnDeviceRepair(WsnDeviceRepair wsnDeviceRepair);
    
    /**
     * 更新维修记录
     * 根据WsnDeviceRepair的主键更新主键以外的其他字段
     * @param WsnDeviceRepair
     */
    public void updateWsnDeviceRepairByRepairId(WsnDeviceRepair wsnDeviceRepair);
    
    /**
     * 根据主键批量删除维修记录 
     * 非物理删除 修改删除标识
     * @param repairId Primary key
     */
    public void deleteWsnDeviceRepairByRepairIds(String repairIds);




   // public List<WsnDeviceRepair> findWsnDeviceRepairListByRfid(int deviceRfid);
}
