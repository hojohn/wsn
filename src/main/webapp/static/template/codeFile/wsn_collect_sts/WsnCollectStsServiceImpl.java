package com.ai.mnt.service.collect.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.collect.WsnCollectSts;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.collect.WsnCollectStsMapper;
import com.ai.mnt.service.collect.WsnCollectStsService;

/**
 * @Title: WsnCollectStsServiceImpl 
 * @Description: WsnCollectStsServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2017-3-10
 */
@Service
public class WsnCollectStsServiceImpl implements WsnCollectStsService{

    @Autowired
    WsnCollectStsMapper wsnCollectStsMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有状态表列表
     * @return List<WsnCollectSts>
     */
    @Override
    public List<WsnCollectSts> findAllWsnCollectSts() {
        List<WsnCollectSts> wsnCollectStsList = wsnCollectStsMapper.findAll();
        //cvtContentList(wsnCollectStsList);
        return wsnCollectStsList;
    }

    /**
     * 获取状态表列表
     * @param collect
     * @return List<WsnCollectSts>
     */
    @Override
    public List<WsnCollectSts> findWsnCollectStsList(WsnCollectSts wsnCollectSts) {
        List<WsnCollectSts> wsnCollectStsList = wsnCollectStsMapper.findList(wsnCollectSts);
        //cvtContentList(wsnCollectStsList);
        return wsnCollectStsList;
    }

    /**
     * 通过主键ID获取状态表
     * @param id Primary key
     * @return WsnCollectSts
     */
    @Override
    public WsnCollectSts findWsnCollectStsById(Integer id) {
        WsnCollectSts wsnCollectSts = wsnCollectStsMapper.findByPrimaryKey(id);
        return wsnCollectSts;
    }

    /**
     * 添加状态表
     * @param WsnCollectSts
     */
    @Override
    public void saveWsnCollectSts(WsnCollectSts wsnCollectSts) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnCollectSts.setDeleteFlag("0");
        wsnCollectSts.setCreator(currentUser.getUserName());
        wsnCollectSts.setModifier(currentUser.getUserName());
        wsnCollectSts.setCreateDate(new Date());
        wsnCollectSts.setModifyDate(new Date());
        wsnCollectStsMapper.save(wsnCollectSts);
        
    }

    /**
     * 更新状态表
     * 根据WsnCollectSts的主键更新主键以外的其他字段
     * @param WsnCollectSts
     */
    @Override
    public void updateWsnCollectStsById(WsnCollectSts wsnCollectSts) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnCollectSts.setModifier(currentUser.getUserName());
        wsnCollectSts.setModifyDate(new Date());
        wsnCollectStsMapper.updateByPrimaryKey(wsnCollectSts);
        
    }

    /**
     * 根据主键批量删除状态表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnCollectStsByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnCollectSts wsnCollectSts = new WsnCollectSts();
        wsnCollectSts.setDeleteFlag("1");
        wsnCollectSts.setModifier(currentUser.getUserName());
        wsnCollectSts.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnCollectSts.setId(Integer.parseInt(id));
            wsnCollectStsMapper.updateByPrimaryKey(wsnCollectSts);
        }
    }
    
    //private void cvtContentList(List<WsnCollectSts> WsnCollectStsList) {
    //    for(WsnCollectSts wsnCollectSts : WsnCollectStsList) {
    //    }
    //}
}

