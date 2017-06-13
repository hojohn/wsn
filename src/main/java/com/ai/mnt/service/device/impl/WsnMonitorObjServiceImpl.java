package com.ai.mnt.service.device.impl;


import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.device.WsnMonitorObj;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.device.WsnMonitorObjMapper;
import com.ai.mnt.service.device.WsnMonitorObjService;

/**
 * @Title: WsnMonitorObjServiceImpl 
 * @Description: WsnMonitorObjServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-27
 */
@Service
public class WsnMonitorObjServiceImpl implements WsnMonitorObjService{

    @Autowired
    WsnMonitorObjMapper wsnMonitorObjMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有监控对象列表
     * @return List<WsnMonitorObj>
     */
    @Override
    public List<WsnMonitorObj> findAllWsnMonitorObj() {
        List<WsnMonitorObj> wsnMonitorObjList = wsnMonitorObjMapper.findAll();
        //cvtContentList(wsnMonitorObjList);
        return wsnMonitorObjList;
    }

    /**
     * 获取监控对象列表
     * @param device
     * @return List<WsnMonitorObj>
     */
    @Override
    public List<WsnMonitorObj> findWsnMonitorObjList(WsnMonitorObj wsnMonitorObj) {
        List<WsnMonitorObj> wsnMonitorObjList = wsnMonitorObjMapper.findList(wsnMonitorObj);
        //cvtContentList(wsnMonitorObjList);
        return wsnMonitorObjList;
    }

    /**
     * 通过主键ID获取监控对象
     * @param monitorObjId Primary key
     * @return WsnMonitorObj
     */
    @Override
    public WsnMonitorObj findWsnMonitorObjByMonitorObjId(String monitorObjId) {
        WsnMonitorObj wsnMonitorObj = wsnMonitorObjMapper.findByPrimary(monitorObjId);
        return wsnMonitorObj;
    }

    /**
     * 添加监控对象
     * @param WsnMonitorObj
     */
    @Override
    public void saveWsnMonitorObj(WsnMonitorObj wsnMonitorObj) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnMonitorObj.setModifier(currentUser.getUserName());
        wsnMonitorObj.setModifyDate(new Date());
        wsnMonitorObjMapper.save(wsnMonitorObj);
        
    }

    /**
     * 更新监控对象
     * 根据WsnMonitorObj的主键更新主键以外的其他字段
     * @param WsnMonitorObj
     */
    @Override
    public void updateWsnMonitorObjByMonitorObjId(WsnMonitorObj wsnMonitorObj) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnMonitorObj.setModifier(currentUser.getUserName());
        wsnMonitorObj.setModifyDate(new Date());
        wsnMonitorObjMapper.updateByPrimaryKey(wsnMonitorObj);
        
    }

    /**
     * 根据主键批量删除监控对象 
     * 非物理删除 修改删除标识
     * @param monitorObjId Primary key
     */
    @Override
    public void deleteWsnMonitorObjByMonitorObjIds(String monitorObjIds) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnMonitorObj wsnMonitorObj = new WsnMonitorObj();
        wsnMonitorObj.setModifier(currentUser.getUserName());
        wsnMonitorObj.setModifyDate(new Date());
        String[] monitorObjIdAry = monitorObjIds.split(",");
        for(String monitorObjId : monitorObjIdAry) {
            wsnMonitorObj.setMonitorObjId(monitorObjId);
            wsnMonitorObjMapper.updateByPrimaryKey(wsnMonitorObj);
        }
    }
    
    //private void cvtContentList(List<WsnMonitorObj> WsnMonitorObjList) {
    //    for(WsnMonitorObj wsnMonitorObj : WsnMonitorObjList) {
    //    }
    //}
}

