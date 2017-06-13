package com.ai.mnt.service.employee;

import java.util.List;
import com.ai.mnt.model.employee.WsnTrain;

/**
 * @Title: WsnTrainService 
 * @Description: WsnTrainService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-10-16
 */

public interface WsnTrainService {
    
    /**
     * 获取所有培训教育列表
     * @return List<WsnTrain>
     */
    public List<WsnTrain> findAllWsnTrain();
    
    
    /**
     * 获取培训教育列表
     * @param employee
     * @return List<WsnTrain>
     */
    public List<WsnTrain> findWsnTrainList(WsnTrain wsnTrain);
    
    /**
     * 通过主键ID获取培训教育
     * @param trainId Primary key
     * @return WsnTrain
     */
    public WsnTrain findWsnTrainByTrainId(Integer trainId);
    
    /**
     * 添加培训教育
     * @param WsnTrain
     */
    public void saveWsnTrain(WsnTrain wsnTrain);
    
    /**
     * 更新培训教育
     * 根据WsnTrain的主键更新主键以外的其他字段
     * @param WsnTrain
     */
    public void updateWsnTrainByTrainId(WsnTrain wsnTrain);
    
    /**
     * 根据主键批量删除培训教育 
     * 非物理删除 修改删除标识
     * @param trainId Primary key
     */
    public void deleteWsnTrainByTrainIds(String trainIds);
}
