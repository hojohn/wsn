package com.ai.mnt.service.sensor;

import java.util.List;
import com.ai.mnt.model.sensor.WsnNoise;

/**
 * @Title: WsnNoiseService 
 * @Description: WsnNoiseService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2017-4-20
 */

public interface WsnNoiseService {
    
    /**
     * 获取所有温度数据表列表
     * @return List<WsnNoise>
     */
    public List<WsnNoise> findAllWsnNoise();
    
    
    /**
     * 获取温度数据表列表
     * @param sensor
     * @return List<WsnNoise>
     */
    public List<WsnNoise> findWsnNoiseList(WsnNoise wsnNoise);
    
    /**
     * 通过主键ID获取温度数据表
     * @param id Primary key
     * @return WsnNoise
     */
    public WsnNoise findWsnNoiseById(Integer id);
    
    /**
     * 添加温度数据表
     * @param WsnNoise
     */
    public void saveWsnNoise(WsnNoise wsnNoise);
    
    /**
     * 更新温度数据表
     * 根据WsnNoise的主键更新主键以外的其他字段
     * @param WsnNoise
     */
    public void updateWsnNoiseById(WsnNoise wsnNoise);
    
    /**
     * 根据主键批量删除温度数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteWsnNoiseByIds(String ids);
}
