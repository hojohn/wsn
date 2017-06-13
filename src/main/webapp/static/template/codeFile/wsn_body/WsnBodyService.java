package com.ai.mnt.service.sensor;

import java.util.List;
import com.ai.mnt.model.sensor.WsnBody;

/**
 * @Title: WsnBodyService 
 * @Description: WsnBodyService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2017-4-20
 */

public interface WsnBodyService {
    
    /**
     * 获取所有温度数据表列表
     * @return List<WsnBody>
     */
    public List<WsnBody> findAllWsnBody();
    
    
    /**
     * 获取温度数据表列表
     * @param sensor
     * @return List<WsnBody>
     */
    public List<WsnBody> findWsnBodyList(WsnBody wsnBody);
    
    /**
     * 通过主键ID获取温度数据表
     * @param id Primary key
     * @return WsnBody
     */
    public WsnBody findWsnBodyById(Integer id);
    
    /**
     * 添加温度数据表
     * @param WsnBody
     */
    public void saveWsnBody(WsnBody wsnBody);
    
    /**
     * 更新温度数据表
     * 根据WsnBody的主键更新主键以外的其他字段
     * @param WsnBody
     */
    public void updateWsnBodyById(WsnBody wsnBody);
    
    /**
     * 根据主键批量删除温度数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteWsnBodyByIds(String ids);
}
