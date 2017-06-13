package com.ai.mnt.service.sensor;

import java.util.List;
import com.ai.mnt.model.sensor.WsnHumidity;

/**
 * @Title: WsnHumidityService 
 * @Description: WsnHumidityService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

public interface WsnHumidityService {
    
    /**
     * 获取所有湿度数据表列表
     * @return List<WsnHumidity>
     */
    public List<WsnHumidity> findAllWsnHumidity();
    
    
    /**
     * 获取湿度数据表列表
     * @param sensor
     * @return List<WsnHumidity>
     */
    public List<WsnHumidity> findWsnHumidityList(WsnHumidity wsnHumidity);
    
    /**
     * 通过主键ID获取湿度数据表
     * @param id Primary key
     * @return WsnHumidity
     */
    public WsnHumidity findWsnHumidityById(Integer id);
    
    /**
     * 添加湿度数据表
     * @param WsnHumidity
     */
    public void saveWsnHumidity(WsnHumidity wsnHumidity);
    
    /**
     * 更新湿度数据表
     * 根据WsnHumidity的主键更新主键以外的其他字段
     * @param WsnHumidity
     */
    public void updateWsnHumidityById(WsnHumidity wsnHumidity);
    
    /**
     * 根据主键批量删除湿度数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteWsnHumidityByIds(String ids);
}
