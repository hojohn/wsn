package com.ai.mnt.service.sensor;

import java.util.List;
import com.ai.mnt.model.sensor.WsnHeart;

/**
 * @Title: WsnHeartService 
 * @Description: WsnHeartService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2017-4-20
 */

public interface WsnHeartService {
    
    /**
     * 获取所有温度数据表列表
     * @return List<WsnHeart>
     */
    public List<WsnHeart> findAllWsnHeart();
    
    
    /**
     * 获取温度数据表列表
     * @param sensor
     * @return List<WsnHeart>
     */
    public List<WsnHeart> findWsnHeartList(WsnHeart wsnHeart);
    
    /**
     * 通过主键ID获取温度数据表
     * @param id Primary key
     * @return WsnHeart
     */
    public WsnHeart findWsnHeartById(Integer id);
    
    /**
     * 添加温度数据表
     * @param WsnHeart
     */
    public void saveWsnHeart(WsnHeart wsnHeart);
    
    /**
     * 更新温度数据表
     * 根据WsnHeart的主键更新主键以外的其他字段
     * @param WsnHeart
     */
    public void updateWsnHeartById(WsnHeart wsnHeart);
    
    /**
     * 根据主键批量删除温度数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteWsnHeartByIds(String ids);
}
