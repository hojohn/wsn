package com.ai.mnt.service.device;

import java.util.List;
import com.ai.mnt.model.device.WsnRfid;

/**
 * @Title: WsnRfidService 
 * @Description: WsnRfidService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-10-18
 */

public interface WsnRfidService {
    
    /**
     * 获取所有RFID管理列表
     * @return List<WsnRfid>
     */
    public List<WsnRfid> findAllWsnRfid();
    
    
    /**
     * 获取RFID管理列表
     * @param device
     * @return List<WsnRfid>
     */
    public List<WsnRfid> findWsnRfidList(WsnRfid wsnRfid);
    
    /**
     * 通过主键ID获取RFID管理
     * @param rfidId Primary key
     * @return WsnRfid
     */
    public WsnRfid findWsnRfidByRfidId(Integer rfidId);
    
    /**
     * 添加RFID管理
     * @param WsnRfid
     */
    public void saveWsnRfid(WsnRfid wsnRfid);
    
    /**
     * 更新RFID管理
     * 根据WsnRfid的主键更新主键以外的其他字段
     * @param WsnRfid
     */
    public void updateWsnRfidByRfidId(WsnRfid wsnRfid);
    
    /**
     * 根据主键批量删除RFID管理 
     * 非物理删除 修改删除标识
     * @param rfidId Primary key
     */
    public void deleteWsnRfidByRfidIds(String rfidIds);
}
