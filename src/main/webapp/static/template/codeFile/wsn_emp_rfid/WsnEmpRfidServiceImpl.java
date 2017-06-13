package com.ai.mnt.service.device.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.device.WsnEmpRfid;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.device.WsnEmpRfidMapper;
import com.ai.mnt.service.device.WsnEmpRfidService;

/**
 * @Title: WsnEmpRfidServiceImpl 
 * @Description: WsnEmpRfidServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-20
 */
@Service
public class WsnEmpRfidServiceImpl implements WsnEmpRfidService{

    @Autowired
    WsnEmpRfidMapper wsnEmpRfidMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有标签人员关联列表
     * @return List<WsnEmpRfid>
     */
    @Override
    public List<WsnEmpRfid> findAllWsnEmpRfid() {
        List<WsnEmpRfid> wsnEmpRfidList = wsnEmpRfidMapper.findAll();
        //cvtContentList(wsnEmpRfidList);
        return wsnEmpRfidList;
    }

    /**
     * 获取标签人员关联列表
     * @param device
     * @return List<WsnEmpRfid>
     */
    @Override
    public List<WsnEmpRfid> findWsnEmpRfidList(WsnEmpRfid wsnEmpRfid) {
        List<WsnEmpRfid> wsnEmpRfidList = wsnEmpRfidMapper.findList(wsnEmpRfid);
        //cvtContentList(wsnEmpRfidList);
        return wsnEmpRfidList;
    }

    /**
     * 通过主键ID获取标签人员关联
     * @param rfEmpId Primary key
     * @return WsnEmpRfid
     */
    @Override
    public WsnEmpRfid findWsnEmpRfidByRfEmpId(Integer rfEmpId) {
        WsnEmpRfid wsnEmpRfid = wsnEmpRfidMapper.findByPrimaryKey(rfEmpId);
        return wsnEmpRfid;
    }

    /**
     * 添加标签人员关联
     * @param WsnEmpRfid
     */
    @Override
    public void saveWsnEmpRfid(WsnEmpRfid wsnEmpRfid) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnEmpRfid.setDeleteFlag("0");
        wsnEmpRfid.setCreator(currentUser.getUserName());
        wsnEmpRfid.setModifier(currentUser.getUserName());
        wsnEmpRfid.setCreateDate(new Date());
        wsnEmpRfid.setModifyDate(new Date());
        wsnEmpRfidMapper.save(wsnEmpRfid);
        
    }

    /**
     * 更新标签人员关联
     * 根据WsnEmpRfid的主键更新主键以外的其他字段
     * @param WsnEmpRfid
     */
    @Override
    public void updateWsnEmpRfidByRfEmpId(WsnEmpRfid wsnEmpRfid) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnEmpRfid.setModifier(currentUser.getUserName());
        wsnEmpRfid.setModifyDate(new Date());
        wsnEmpRfidMapper.updateByPrimaryKey(wsnEmpRfid);
        
    }

    /**
     * 根据主键批量删除标签人员关联 
     * 非物理删除 修改删除标识
     * @param rfEmpId Primary key
     */
    @Override
    public void deleteWsnEmpRfidByRfEmpIds(String rfEmpIds) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnEmpRfid wsnEmpRfid = new WsnEmpRfid();
        wsnEmpRfid.setDeleteFlag("1");
        wsnEmpRfid.setModifier(currentUser.getUserName());
        wsnEmpRfid.setModifyDate(new Date());
        String[] rfEmpIdAry = rfEmpIds.split(",");
        for(String rfEmpId : rfEmpIdAry) {
            wsnEmpRfid.setRfEmpId(Integer.parseInt(rfEmpId));
            wsnEmpRfidMapper.updateByPrimaryKey(wsnEmpRfid);
        }
    }
    
    //private void cvtContentList(List<WsnEmpRfid> WsnEmpRfidList) {
    //    for(WsnEmpRfid wsnEmpRfid : WsnEmpRfidList) {
    //    }
    //}
}

