package com.ai.mnt.service.bracelet;

import java.util.List;
import com.ai.mnt.model.bracelet.WsnBraceletInfo;

/**
 * @Title: WsnBraceletInfoService 
 * @Description: WsnBraceletInfoService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-12-7
 */

public interface WsnBraceletInfoService {
    
    /**
     * 获取所有可穿戴设备信息表列表
     * @return List<WsnBraceletInfo>
     */
    public List<WsnBraceletInfo> findAllWsnBraceletInfo();
    
    
    /**
     * 获取可穿戴设备信息表列表
     * @param bracelet
     * @return List<WsnBraceletInfo>
     */
    public List<WsnBraceletInfo> findWsnBraceletInfoList(WsnBraceletInfo wsnBraceletInfo);
    
    /**
     * 通过主键ID获取可穿戴设备信息表
     * @param bwareId Primary key
     * @return WsnBraceletInfo
     */
    public WsnBraceletInfo findWsnBraceletInfoByBwareId(Integer bwareId);
    
    /**
     * 添加可穿戴设备信息表
     * @param WsnBraceletInfo
     */
    public void saveWsnBraceletInfo(WsnBraceletInfo wsnBraceletInfo);
    
    /**
     * 更新可穿戴设备信息表
     * 根据WsnBraceletInfo的主键更新主键以外的其他字段
     * @param WsnBraceletInfo
     */
    public void updateWsnBraceletInfoByBwareId(WsnBraceletInfo wsnBraceletInfo);
    
    /**
     * 根据主键批量删除可穿戴设备信息表 
     * 非物理删除 修改删除标识
     * @param bwareId Primary key
     */
    public void deleteWsnBraceletInfoByBwareIds(String bwareIds);
}
