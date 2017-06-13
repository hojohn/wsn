package com.ai.mnt.service.sensor;

import java.util.List;
import com.ai.mnt.model.sensor.WsnTemperature;

/**
 * @Title: WsnTemperatureService 
 * @Description: WsnTemperatureService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

public interface WsnTemperatureService {
    
    /**
     * 获取所有温度数据表列表
     * @return List<WsnTemperature>
     */
    public List<WsnTemperature> findAllWsnTemperature();
    
    
    /**
     * 获取温度数据表列表
     * @param sensor
     * @return List<WsnTemperature>
     */
    public List<WsnTemperature> findWsnTemperatureList(WsnTemperature wsnTemperature);
    
    /**
     * 通过主键ID获取温度数据表
     * @param id Primary key
     * @return WsnTemperature
     */
    public WsnTemperature findWsnTemperatureById(Integer id);
    
    /**
     * 添加温度数据表
     * @param WsnTemperature
     */
    public void saveWsnTemperature(WsnTemperature wsnTemperature);
    
    /**
     * 更新温度数据表
     * 根据WsnTemperature的主键更新主键以外的其他字段
     * @param WsnTemperature
     */
    public void updateWsnTemperatureById(WsnTemperature wsnTemperature);
    
    /**
     * 根据主键批量删除温度数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteWsnTemperatureByIds(String ids);
}
