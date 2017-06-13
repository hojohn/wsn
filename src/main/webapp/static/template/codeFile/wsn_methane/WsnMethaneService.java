package com.ai.mnt.service.sensor;

import java.util.List;
import com.ai.mnt.model.sensor.WsnMethane;

/**
 * @Title: WsnMethaneService 
 * @Description: WsnMethaneService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

public interface WsnMethaneService {
    
    /**
     * 获取所有甲烷数据表列表
     * @return List<WsnMethane>
     */
    public List<WsnMethane> findAllWsnMethane();
    
    
    /**
     * 获取甲烷数据表列表
     * @param sensor
     * @return List<WsnMethane>
     */
    public List<WsnMethane> findWsnMethaneList(WsnMethane wsnMethane);
    
    /**
     * 通过主键ID获取甲烷数据表
     * @param id Primary key
     * @return WsnMethane
     */
    public WsnMethane findWsnMethaneById(Integer id);
    
    /**
     * 添加甲烷数据表
     * @param WsnMethane
     */
    public void saveWsnMethane(WsnMethane wsnMethane);
    
    /**
     * 更新甲烷数据表
     * 根据WsnMethane的主键更新主键以外的其他字段
     * @param WsnMethane
     */
    public void updateWsnMethaneById(WsnMethane wsnMethane);
    
    /**
     * 根据主键批量删除甲烷数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteWsnMethaneByIds(String ids);
}
