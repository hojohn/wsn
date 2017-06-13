package com.ai.mnt.service.sensor;

import java.util.List;
import com.ai.mnt.model.sensor.WsnPressure;

/**
 * @Title: WsnPressureService 
 * @Description: WsnPressureService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

public interface WsnPressureService {
    
    /**
     * 获取所有压力数据表列表
     * @return List<WsnPressure>
     */
    public List<WsnPressure> findAllWsnPressure();
    
    
    /**
     * 获取压力数据表列表
     * @param sensor
     * @return List<WsnPressure>
     */
    public List<WsnPressure> findWsnPressureList(WsnPressure wsnPressure);
    
    /**
     * 通过主键ID获取压力数据表
     * @param id Primary key
     * @return WsnPressure
     */
    public WsnPressure findWsnPressureById(Integer id);
    
    /**
     * 添加压力数据表
     * @param WsnPressure
     */
    public void saveWsnPressure(WsnPressure wsnPressure);
    
    /**
     * 更新压力数据表
     * 根据WsnPressure的主键更新主键以外的其他字段
     * @param WsnPressure
     */
    public void updateWsnPressureById(WsnPressure wsnPressure);
    
    /**
     * 根据主键批量删除压力数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteWsnPressureByIds(String ids);
}
