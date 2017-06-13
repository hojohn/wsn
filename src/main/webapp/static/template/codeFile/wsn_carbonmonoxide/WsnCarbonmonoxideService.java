package com.ai.mnt.service.sensor;

import java.util.List;
import com.ai.mnt.model.sensor.WsnCarbonmonoxide;

/**
 * @Title: WsnCarbonmonoxideService 
 * @Description: WsnCarbonmonoxideService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

public interface WsnCarbonmonoxideService {
    
    /**
     * 获取所有一氧化碳数据表列表
     * @return List<WsnCarbonmonoxide>
     */
    public List<WsnCarbonmonoxide> findAllWsnCarbonmonoxide();
    
    
    /**
     * 获取一氧化碳数据表列表
     * @param sensor
     * @return List<WsnCarbonmonoxide>
     */
    public List<WsnCarbonmonoxide> findWsnCarbonmonoxideList(WsnCarbonmonoxide wsnCarbonmonoxide);
    
    /**
     * 通过主键ID获取一氧化碳数据表
     * @param id Primary key
     * @return WsnCarbonmonoxide
     */
    public WsnCarbonmonoxide findWsnCarbonmonoxideById(Integer id);
    
    /**
     * 添加一氧化碳数据表
     * @param WsnCarbonmonoxide
     */
    public void saveWsnCarbonmonoxide(WsnCarbonmonoxide wsnCarbonmonoxide);
    
    /**
     * 更新一氧化碳数据表
     * 根据WsnCarbonmonoxide的主键更新主键以外的其他字段
     * @param WsnCarbonmonoxide
     */
    public void updateWsnCarbonmonoxideById(WsnCarbonmonoxide wsnCarbonmonoxide);
    
    /**
     * 根据主键批量删除一氧化碳数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteWsnCarbonmonoxideByIds(String ids);
}
