package com.ai.mnt.service.sensor;

import java.util.List;
import com.ai.mnt.model.sensor.WsnDrift;

/**
 * @Title: WsnDriftService 
 * @Description: WsnDriftService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

public interface WsnDriftService {
    
    /**
     * 获取所有位移数据表列表
     * @return List<WsnDrift>
     */
    public List<WsnDrift> findAllWsnDrift();
    
    
    /**
     * 获取位移数据表列表
     * @param sensor
     * @return List<WsnDrift>
     */
    public List<WsnDrift> findWsnDriftList(WsnDrift wsnDrift);
    
    /**
     * 通过主键ID获取位移数据表
     * @param id Primary key
     * @return WsnDrift
     */
    public WsnDrift findWsnDriftById(Integer id);
    
    /**
     * 添加位移数据表
     * @param WsnDrift
     */
    public void saveWsnDrift(WsnDrift wsnDrift);
    
    /**
     * 更新位移数据表
     * 根据WsnDrift的主键更新主键以外的其他字段
     * @param WsnDrift
     */
    public void updateWsnDriftById(WsnDrift wsnDrift);
    
    /**
     * 根据主键批量删除位移数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteWsnDriftByIds(String ids);
}
