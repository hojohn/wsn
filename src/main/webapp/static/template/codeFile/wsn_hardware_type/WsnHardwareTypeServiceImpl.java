package com.ai.mnt.service.device.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.device.WsnHardwareType;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.device.WsnHardwareTypeMapper;
import com.ai.mnt.service.device.WsnHardwareTypeService;

/**
 * @Title: WsnHardwareTypeServiceImpl 
 * @Description: WsnHardwareTypeServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-28
 */
@Service
public class WsnHardwareTypeServiceImpl implements WsnHardwareTypeService{

    @Autowired
    WsnHardwareTypeMapper wsnHardwareTypeMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有硬件类型列表
     * @return List<WsnHardwareType>
     */
    @Override
    public List<WsnHardwareType> findAllWsnHardwareType() {
        List<WsnHardwareType> wsnHardwareTypeList = wsnHardwareTypeMapper.findAll();
        //cvtContentList(wsnHardwareTypeList);
        return wsnHardwareTypeList;
    }

    /**
     * 获取硬件类型列表
     * @param device
     * @return List<WsnHardwareType>
     */
    @Override
    public List<WsnHardwareType> findWsnHardwareTypeList(WsnHardwareType wsnHardwareType) {
        List<WsnHardwareType> wsnHardwareTypeList = wsnHardwareTypeMapper.findList(wsnHardwareType);
        //cvtContentList(wsnHardwareTypeList);
        return wsnHardwareTypeList;
    }

    /**
     * 通过主键ID获取硬件类型
     * @param typeId Primary key
     * @return WsnHardwareType
     */
    @Override
    public WsnHardwareType findWsnHardwareTypeByTypeId(Integer typeId) {
        WsnHardwareType wsnHardwareType = wsnHardwareTypeMapper.findByPrimaryKey(typeId);
        return wsnHardwareType;
    }

    /**
     * 添加硬件类型
     * @param WsnHardwareType
     */
    @Override
    public void saveWsnHardwareType(WsnHardwareType wsnHardwareType) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnHardwareType.setDeleteFlag("0");
        wsnHardwareType.setCreator(currentUser.getUserName());
        wsnHardwareType.setModifier(currentUser.getUserName());
        wsnHardwareType.setCreateDate(new Date());
        wsnHardwareType.setModifyDate(new Date());
        wsnHardwareTypeMapper.save(wsnHardwareType);
        
    }

    /**
     * 更新硬件类型
     * 根据WsnHardwareType的主键更新主键以外的其他字段
     * @param WsnHardwareType
     */
    @Override
    public void updateWsnHardwareTypeByTypeId(WsnHardwareType wsnHardwareType) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnHardwareType.setModifier(currentUser.getUserName());
        wsnHardwareType.setModifyDate(new Date());
        wsnHardwareTypeMapper.updateByPrimaryKey(wsnHardwareType);
        
    }

    /**
     * 根据主键批量删除硬件类型 
     * 非物理删除 修改删除标识
     * @param typeId Primary key
     */
    @Override
    public void deleteWsnHardwareTypeByTypeIds(String typeIds) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnHardwareType wsnHardwareType = new WsnHardwareType();
        wsnHardwareType.setDeleteFlag("1");
        wsnHardwareType.setModifier(currentUser.getUserName());
        wsnHardwareType.setModifyDate(new Date());
        String[] typeIdAry = typeIds.split(",");
        for(String typeId : typeIdAry) {
            wsnHardwareType.setTypeId(Integer.parseInt(typeId));
            wsnHardwareTypeMapper.updateByPrimaryKey(wsnHardwareType);
        }
    }
    
    //private void cvtContentList(List<WsnHardwareType> WsnHardwareTypeList) {
    //    for(WsnHardwareType wsnHardwareType : WsnHardwareTypeList) {
    //    }
    //}
}

