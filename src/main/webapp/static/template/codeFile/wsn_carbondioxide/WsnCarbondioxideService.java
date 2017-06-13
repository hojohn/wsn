package com.ai.mnt.service.sensor;

import java.util.List;
import com.ai.mnt.model.sensor.WsnCarbondioxide;

/**
 * @Title: WsnCarbondioxideService 
 * @Description: WsnCarbondioxideService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

public interface WsnCarbondioxideService {
    
    /**
     * 获取所有二氧化碳数据表列表
     * @return List<WsnCarbondioxide>
     */
    public List<WsnCarbondioxide> findAllWsnCarbondioxide();
    
    
    /**
     * 获取二氧化碳数据表列表
     * @param sensor
     * @return List<WsnCarbondioxide>
     */
    public List<WsnCarbondioxide> findWsnCarbondioxideList(WsnCarbondioxide wsnCarbondioxide);
    
    /**
     * 通过主键ID获取二氧化碳数据表
     * @param id Primary key
     * @return WsnCarbondioxide
     */
    public WsnCarbondioxide findWsnCarbondioxideById(Integer id);
    
    /**
     * 添加二氧化碳数据表
     * @param WsnCarbondioxide
     */
    public void saveWsnCarbondioxide(WsnCarbondioxide wsnCarbondioxide);
    
    /**
     * 更新二氧化碳数据表
     * 根据WsnCarbondioxide的主键更新主键以外的其他字段
     * @param WsnCarbondioxide
     */
    public void updateWsnCarbondioxideById(WsnCarbondioxide wsnCarbondioxide);
    
    /**
     * 根据主键批量删除二氧化碳数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteWsnCarbondioxideByIds(String ids);
}
