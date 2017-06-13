package com.ai.mnt.service.device;

import java.util.List;
import com.ai.mnt.model.device.WsnGeteway;

/**
 * @Title: WsnGetewayService 
 * @Description: WsnGetewayService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-10-28
 */

public interface WsnGetewayService {
    
    /**
     * 获取所有网关表列表
     * @return List<WsnGeteway>
     */
    public List<WsnGeteway> findAllWsnGeteway();
    
    
    /**
     * 获取网关表列表
     * @param device
     * @return List<WsnGeteway>
     */
    public List<WsnGeteway> findWsnGetewayList(WsnGeteway wsnGeteway);
    
    /**
     * 通过主键ID获取网关表
     * @param gatewayId Primary key
     * @return WsnGeteway
     */
    public WsnGeteway findWsnGetewayByGatewayId(Integer gatewayId);
    
    /**
     * 添加网关表
     * @param WsnGeteway
     */
    public void saveWsnGeteway(WsnGeteway wsnGeteway);
    
    /**
     * 更新网关表
     * 根据WsnGeteway的主键更新主键以外的其他字段
     * @param WsnGeteway
     */
    public void updateWsnGetewayByGatewayId(WsnGeteway wsnGeteway);
    
    /**
     * 根据主键批量删除网关表 
     * 非物理删除 修改删除标识
     * @param gatewayId Primary key
     */
    public void deleteWsnGetewayByGatewayIds(String gatewayIds);
}
