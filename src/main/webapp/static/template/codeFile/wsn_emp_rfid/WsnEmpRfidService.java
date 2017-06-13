package com.ai.mnt.service.device;

import java.util.List;
import com.ai.mnt.model.device.WsnEmpRfid;

/**
 * @Title: WsnEmpRfidService 
 * @Description: WsnEmpRfidService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-10-20
 */

public interface WsnEmpRfidService {
    
    /**
     * 获取所有标签人员关联列表
     * @return List<WsnEmpRfid>
     */
    public List<WsnEmpRfid> findAllWsnEmpRfid();
    
    
    /**
     * 获取标签人员关联列表
     * @param device
     * @return List<WsnEmpRfid>
     */
    public List<WsnEmpRfid> findWsnEmpRfidList(WsnEmpRfid wsnEmpRfid);
    
    /**
     * 通过主键ID获取标签人员关联
     * @param rfEmpId Primary key
     * @return WsnEmpRfid
     */
    public WsnEmpRfid findWsnEmpRfidByRfEmpId(Integer rfEmpId);
    
    /**
     * 添加标签人员关联
     * @param WsnEmpRfid
     */
    public void saveWsnEmpRfid(WsnEmpRfid wsnEmpRfid);
    
    /**
     * 更新标签人员关联
     * 根据WsnEmpRfid的主键更新主键以外的其他字段
     * @param WsnEmpRfid
     */
    public void updateWsnEmpRfidByRfEmpId(WsnEmpRfid wsnEmpRfid);
    
    /**
     * 根据主键批量删除标签人员关联 
     * 非物理删除 修改删除标识
     * @param rfEmpId Primary key
     */
    public void deleteWsnEmpRfidByRfEmpIds(String rfEmpIds);
}
