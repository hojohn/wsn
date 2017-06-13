package com.ai.mnt.service.sensor;

import java.util.List;
import com.ai.mnt.model.sensor.WsnOxygen;

/**
 * @Title: WsnOxygenService 
 * @Description: WsnOxygenService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

public interface WsnOxygenService {
    
    /**
     * 获取所有氧气数据表列表
     * @return List<WsnOxygen>
     */
    public List<WsnOxygen> findAllWsnOxygen();
    
    
    /**
     * 获取氧气数据表列表
     * @param sensor
     * @return List<WsnOxygen>
     */
    public List<WsnOxygen> findWsnOxygenList(WsnOxygen wsnOxygen);
    
    /**
     * 通过主键ID获取氧气数据表
     * @param id Primary key
     * @return WsnOxygen
     */
    public WsnOxygen findWsnOxygenById(Integer id);
    
    /**
     * 添加氧气数据表
     * @param WsnOxygen
     */
    public void saveWsnOxygen(WsnOxygen wsnOxygen);
    
    /**
     * 更新氧气数据表
     * 根据WsnOxygen的主键更新主键以外的其他字段
     * @param WsnOxygen
     */
    public void updateWsnOxygenById(WsnOxygen wsnOxygen);
    
    /**
     * 根据主键批量删除氧气数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteWsnOxygenByIds(String ids);
}
