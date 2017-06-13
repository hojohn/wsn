package com.ai.mnt.service.sensor;

import java.util.List;
import com.ai.mnt.model.sensor.WsnSmoke;

/**
 * @Title: WsnSmokeService 
 * @Description: WsnSmokeService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

public interface WsnSmokeService {
    
    /**
     * 获取所有烟雾数据表列表
     * @return List<WsnSmoke>
     */
    public List<WsnSmoke> findAllWsnSmoke();
    
    
    /**
     * 获取烟雾数据表列表
     * @param sensor
     * @return List<WsnSmoke>
     */
    public List<WsnSmoke> findWsnSmokeList(WsnSmoke wsnSmoke);
    
    /**
     * 通过主键ID获取烟雾数据表
     * @param id Primary key
     * @return WsnSmoke
     */
    public WsnSmoke findWsnSmokeById(Integer id);
    
    /**
     * 添加烟雾数据表
     * @param WsnSmoke
     */
    public void saveWsnSmoke(WsnSmoke wsnSmoke);
    
    /**
     * 更新烟雾数据表
     * 根据WsnSmoke的主键更新主键以外的其他字段
     * @param WsnSmoke
     */
    public void updateWsnSmokeById(WsnSmoke wsnSmoke);
    
    /**
     * 根据主键批量删除烟雾数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteWsnSmokeByIds(String ids);
}
