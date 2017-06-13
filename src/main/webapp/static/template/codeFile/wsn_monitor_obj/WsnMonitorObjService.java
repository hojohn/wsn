package com.ai.mnt.service.device;

import java.util.List;
import com.ai.mnt.model.device.WsnMonitorObj;

/**
 * @Title: WsnMonitorObjService 
 * @Description: WsnMonitorObjService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-10-27
 */

public interface WsnMonitorObjService {
    
    /**
     * 获取所有监控对象列表
     * @return List<WsnMonitorObj>
     */
    public List<WsnMonitorObj> findAllWsnMonitorObj();
    
    
    /**
     * 获取监控对象列表
     * @param device
     * @return List<WsnMonitorObj>
     */
    public List<WsnMonitorObj> findWsnMonitorObjList(WsnMonitorObj wsnMonitorObj);
    
    /**
     * 通过主键ID获取监控对象
     * @param monitorObjId Primary key
     * @return WsnMonitorObj
     */
    public WsnMonitorObj findWsnMonitorObjByMonitorObjId(Integer monitorObjId);
    
    /**
     * 添加监控对象
     * @param WsnMonitorObj
     */
    public void saveWsnMonitorObj(WsnMonitorObj wsnMonitorObj);
    
    /**
     * 更新监控对象
     * 根据WsnMonitorObj的主键更新主键以外的其他字段
     * @param WsnMonitorObj
     */
    public void updateWsnMonitorObjByMonitorObjId(WsnMonitorObj wsnMonitorObj);
    
    /**
     * 根据主键批量删除监控对象 
     * 非物理删除 修改删除标识
     * @param monitorObjId Primary key
     */
    public void deleteWsnMonitorObjByMonitorObjIds(String monitorObjIds);
}
