package com.ai.mnt.service.employee.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.employee.WsnTrain;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.employee.WsnTrainMapper;
import com.ai.mnt.service.employee.WsnTrainService;

/**
 * @Title: WsnTrainServiceImpl 
 * @Description: WsnTrainServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-16
 */
@Service
public class WsnTrainServiceImpl implements WsnTrainService{

    @Autowired
    WsnTrainMapper wsnTrainMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有培训教育列表
     * @return List<WsnTrain>
     */
    @Override
    public List<WsnTrain> findAllWsnTrain() {
        List<WsnTrain> wsnTrainList = wsnTrainMapper.findAll();
        //cvtContentList(wsnTrainList);
        return wsnTrainList;
    }

    /**
     * 获取培训教育列表
     * @param employee
     * @return List<WsnTrain>
     */
    @Override
    public List<WsnTrain> findWsnTrainList(WsnTrain wsnTrain) {
        List<WsnTrain> wsnTrainList = wsnTrainMapper.findList(wsnTrain);
        //cvtContentList(wsnTrainList);
        return wsnTrainList;
    }

    /**
     * 通过主键ID获取培训教育
     * @param trainId Primary key
     * @return WsnTrain
     */
    @Override
    public WsnTrain findWsnTrainByTrainId(Integer trainId) {
        WsnTrain wsnTrain = wsnTrainMapper.findByPrimaryKey(trainId);
        return wsnTrain;
    }

    /**
     * 添加培训教育
     * @param WsnTrain
     */
    @Override
    public void saveWsnTrain(WsnTrain wsnTrain) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnTrain.setDeleteFlag("0");
        wsnTrain.setCreator(currentUser.getUserName());
        wsnTrain.setModifier(currentUser.getUserName());
        wsnTrain.setCreateDate(new Date());
        wsnTrain.setModifyDate(new Date());
        wsnTrainMapper.save(wsnTrain);
        
    }

    /**
     * 更新培训教育
     * 根据WsnTrain的主键更新主键以外的其他字段
     * @param WsnTrain
     */
    @Override
    public void updateWsnTrainByTrainId(WsnTrain wsnTrain) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnTrain.setModifier(currentUser.getUserName());
        wsnTrain.setModifyDate(new Date());
        wsnTrainMapper.updateByPrimaryKey(wsnTrain);
        
    }

    /**
     * 根据主键批量删除培训教育 
     * 非物理删除 修改删除标识
     * @param trainId Primary key
     */
    @Override
    public void deleteWsnTrainByTrainIds(String trainIds) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnTrain wsnTrain = new WsnTrain();
        wsnTrain.setDeleteFlag("1");
        wsnTrain.setModifier(currentUser.getUserName());
        wsnTrain.setModifyDate(new Date());
        String[] trainIdAry = trainIds.split(",");
        for(String trainId : trainIdAry) {
            wsnTrain.setTrainId(Integer.parseInt(trainId));
            wsnTrainMapper.updateByPrimaryKey(wsnTrain);
        }
    }
    
    //private void cvtContentList(List<WsnTrain> WsnTrainList) {
    //    for(WsnTrain wsnTrain : WsnTrainList) {
    //    }
    //}
}

