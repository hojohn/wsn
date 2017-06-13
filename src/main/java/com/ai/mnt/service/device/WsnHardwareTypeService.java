package com.ai.mnt.service.device;

import java.util.List;
import com.ai.mnt.model.device.WsnHardwareType;

/**
 * @Title: WsnHardwareTypeService 
 * @Description: WsnHardwareTypeService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-10-28
 */

public interface WsnHardwareTypeService {
    
    /**
     * 获取所有硬件类型列表
     * @return List<WsnHardwareType>
     */
    public List<WsnHardwareType> findAllWsnHardwareType();
    
    
    /**
     * 获取硬件类型列表
     * @param device
     * @return List<WsnHardwareType>
     */
    public List<WsnHardwareType> findWsnHardwareTypeList(WsnHardwareType wsnHardwareType);
    
    /**
     * 通过主键ID获取硬件类型
     * @param typeId Primary key
     * @return WsnHardwareType
     */
    public WsnHardwareType findWsnHardwareTypeByTypeId(Integer typeId);
    
    /**
     * 添加硬件类型
     * @param WsnHardwareType
     */
    public void saveWsnHardwareType(WsnHardwareType wsnHardwareType);
    
    /**
     * 更新硬件类型
     * 根据WsnHardwareType的主键更新主键以外的其他字段
     * @param WsnHardwareType
     */
    public void updateWsnHardwareTypeByTypeId(WsnHardwareType wsnHardwareType);
    
    /**
     * 根据主键批量删除硬件类型 
     * 非物理删除 修改删除标识
     * @param typeId Primary key
     */
    public void deleteWsnHardwareTypeByTypeIds(String typeIds);
}
