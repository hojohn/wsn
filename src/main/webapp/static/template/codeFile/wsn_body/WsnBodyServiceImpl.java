package com.ai.mnt.service.sensor.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sensor.WsnBody;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sensor.WsnBodyMapper;
import com.ai.mnt.service.sensor.WsnBodyService;

/**
 * @Title: WsnBodyServiceImpl 
 * @Description: WsnBodyServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2017-4-20
 */
@Service
public class WsnBodyServiceImpl implements WsnBodyService{

    @Autowired
    WsnBodyMapper wsnBodyMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有温度数据表列表
     * @return List<WsnBody>
     */
    @Override
    public List<WsnBody> findAllWsnBody() {
        List<WsnBody> wsnBodyList = wsnBodyMapper.findAll();
        //cvtContentList(wsnBodyList);
        return wsnBodyList;
    }

    /**
     * 获取温度数据表列表
     * @param sensor
     * @return List<WsnBody>
     */
    @Override
    public List<WsnBody> findWsnBodyList(WsnBody wsnBody) {
        List<WsnBody> wsnBodyList = wsnBodyMapper.findList(wsnBody);
        //cvtContentList(wsnBodyList);
        return wsnBodyList;
    }

    /**
     * 通过主键ID获取温度数据表
     * @param id Primary key
     * @return WsnBody
     */
    @Override
    public WsnBody findWsnBodyById(Integer id) {
        WsnBody wsnBody = wsnBodyMapper.findByPrimaryKey(id);
        return wsnBody;
    }

    /**
     * 添加温度数据表
     * @param WsnBody
     */
    @Override
    public void saveWsnBody(WsnBody wsnBody) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnBody.setDeleteFlag("0");
        wsnBody.setCreator(currentUser.getUserName());
        wsnBody.setModifier(currentUser.getUserName());
        wsnBody.setCreateDate(new Date());
        wsnBody.setModifyDate(new Date());
        wsnBodyMapper.save(wsnBody);
        
    }

    /**
     * 更新温度数据表
     * 根据WsnBody的主键更新主键以外的其他字段
     * @param WsnBody
     */
    @Override
    public void updateWsnBodyById(WsnBody wsnBody) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnBody.setModifier(currentUser.getUserName());
        wsnBody.setModifyDate(new Date());
        wsnBodyMapper.updateByPrimaryKey(wsnBody);
        
    }

    /**
     * 根据主键批量删除温度数据表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteWsnBodyByIds(String ids) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnBody wsnBody = new WsnBody();
        wsnBody.setDeleteFlag("1");
        wsnBody.setModifier(currentUser.getUserName());
        wsnBody.setModifyDate(new Date());
        String[] idAry = ids.split(",");
        for(String id : idAry) {
            wsnBody.setId(Integer.parseInt(id));
            wsnBodyMapper.updateByPrimaryKey(wsnBody);
        }
    }
    
    //private void cvtContentList(List<WsnBody> WsnBodyList) {
    //    for(WsnBody wsnBody : WsnBodyList) {
    //    }
    //}
}

