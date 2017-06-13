package com.ai.mnt.service.collect;

import java.util.List;
import com.ai.mnt.model.collect.WsnTray;

/**
 * @Title: WsnTrayService 
 * @Description: WsnTrayService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2017-4-25
 */

public interface WsnTrayService {
    
    /**
     * 获取所有状态列表
     * @return List<WsnTray>
     */
    public List<WsnTray> findAllWsnTray();
    
    
    /**
     * 获取状态列表
     * @param collect
     * @return List<WsnTray>
     */
    public List<WsnTray> findWsnTrayList(WsnTray wsnTray);
    
    /**
     * 通过主键ID获取状态
     * @param wareId Primary key
     * @return WsnTray
     */
    public WsnTray findWsnTrayByWareId(Integer wareId);
    
    /**
     * 添加状态
     * @param WsnTray
     */
    public void saveWsnTray(WsnTray wsnTray);
    
    /**
     * 更新状态
     * 根据WsnTray的主键更新主键以外的其他字段
     * @param WsnTray
     */
    public void updateWsnTrayByWareId(WsnTray wsnTray);
    
    /**
     * 根据主键批量删除状态 
     * 非物理删除 修改删除标识
     * @param wareId Primary key
     */
    public void deleteWsnTrayByWareIds(String wareIds);
}
