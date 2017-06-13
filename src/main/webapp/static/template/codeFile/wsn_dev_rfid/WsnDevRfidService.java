package com.ai.mnt.service.device;

import java.util.List;
import com.ai.mnt.model.device.WsnDevRfid;

/**
 * @Title: WsnDevRfidService 
 * @Description: WsnDevRfidService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-10-20
 */

public interface WsnDevRfidService {
    
    /**
     * 获取所有标签设备关联列表
     * @return List<WsnDevRfid>
     */
    public List<WsnDevRfid> findAllWsnDevRfid();
    
    
    /**
     * 获取标签设备关联列表
     * @param device
     * @return List<WsnDevRfid>
     */
    public List<WsnDevRfid> findWsnDevRfidList(WsnDevRfid wsnDevRfid);
    
    /**
     * 通过主键ID获取标签设备关联
     * @param rfDevId Primary key
     * @return WsnDevRfid
     */
    public WsnDevRfid findWsnDevRfidByRfDevId(Integer rfDevId);
    
    /**
     * 添加标签设备关联
     * @param WsnDevRfid
     */
    public void saveWsnDevRfid(WsnDevRfid wsnDevRfid);
    
    /**
     * 更新标签设备关联
     * 根据WsnDevRfid的主键更新主键以外的其他字段
     * @param WsnDevRfid
     */
    public void updateWsnDevRfidByRfDevId(WsnDevRfid wsnDevRfid);
    
    /**
     * 根据主键批量删除标签设备关联 
     * 非物理删除 修改删除标识
     * @param rfDevId Primary key
     */
    public void deleteWsnDevRfidByRfDevIds(String rfDevIds);
}
