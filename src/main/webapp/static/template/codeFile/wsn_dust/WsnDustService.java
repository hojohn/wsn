package com.ai.mnt.service.sensor;

import java.util.List;
import com.ai.mnt.model.sensor.WsnDust;

/**
 * @Title: WsnDustService 
 * @Description: WsnDustService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

public interface WsnDustService {
    
    /**
     * 获取所有粉尘数据表列表
     * @return List<WsnDust>
     */
    public List<WsnDust> findAllWsnDust();
    
    
    /**
     * 获取粉尘数据表列表
     * @param sensor
     * @return List<WsnDust>
     */
    public List<WsnDust> findWsnDustList(WsnDust wsnDust);
    
    /**
     * 通过主键ID获取粉尘数据表
     * @param id Primary key
     * @return WsnDust
     */
    public WsnDust findWsnDustById(Integer id);
    
    /**
     * 添加粉尘数据表
     * @param WsnDust
     */
    public void saveWsnDust(WsnDust wsnDust);
    
    /**
     * 更新粉尘数据表
     * 根据WsnDust的主键更新主键以外的其他字段
     * @param WsnDust
     */
    public void updateWsnDustById(WsnDust wsnDust);
    
    /**
     * 根据主键批量删除粉尘数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteWsnDustByIds(String ids);
}
