package com.ai.mnt.service.collect;

import java.util.List;
import com.ai.mnt.model.collect.WsnCollectSts;

/**
 * @Title: WsnCollectStsService 
 * @Description: WsnCollectStsService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2017-3-10
 */

public interface WsnCollectStsService {
    
    /**
     * 获取所有状态表列表
     * @return List<WsnCollectSts>
     */
    public List<WsnCollectSts> findAllWsnCollectSts();
    
    
    /**
     * 获取状态表列表
     * @param collect
     * @return List<WsnCollectSts>
     */
    public List<WsnCollectSts> findWsnCollectStsList(WsnCollectSts wsnCollectSts);
    
    /**
     * 通过主键ID获取状态表
     * @param id Primary key
     * @return WsnCollectSts
     */
    public WsnCollectSts findWsnCollectStsById(Integer id);
    
    /**
     * 添加状态表
     * @param WsnCollectSts
     */
    public void saveWsnCollectSts(WsnCollectSts wsnCollectSts);
    
    /**
     * 更新状态表
     * 根据WsnCollectSts的主键更新主键以外的其他字段
     * @param WsnCollectSts
     */
    public void updateWsnCollectStsById(WsnCollectSts wsnCollectSts);
    
    /**
     * 根据主键批量删除状态表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteWsnCollectStsByIds(String ids);
}
