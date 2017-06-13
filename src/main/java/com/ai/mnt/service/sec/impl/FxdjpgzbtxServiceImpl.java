package com.ai.mnt.service.sec.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.sec.Fxdjpgzbtx;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.sec.FxdjpgzbtxMapper;
import com.ai.mnt.service.sec.FxdjpgzbtxService;

/**
 * @Title: FxdjpgzbtxServiceImpl 
 * @Description: FxdjpgzbtxServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2017-5-16
 */
@Service
public class FxdjpgzbtxServiceImpl implements FxdjpgzbtxService{

    @Autowired
    FxdjpgzbtxMapper fxdjpgzbtxMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有危险物料风险度表列表
     * @return List<Fxdjpgzbtx>
     */
    @Override
    public List<Fxdjpgzbtx> findAllFxdjpgzbtx() {
        List<Fxdjpgzbtx> fxdjpgzbtxList = fxdjpgzbtxMapper.findAll();
        //cvtContentList(fxdjpgzbtxList);
        return fxdjpgzbtxList;
    }

    /**
     * 获取危险物料风险度表列表
     * @param sec
     * @return List<Fxdjpgzbtx>
     */
    @Override
    public List<Fxdjpgzbtx> findFxdjpgzbtxList(Fxdjpgzbtx fxdjpgzbtx) {
        List<Fxdjpgzbtx> fxdjpgzbtxList = fxdjpgzbtxMapper.findList(fxdjpgzbtx);
        //cvtContentList(fxdjpgzbtxList);
        return fxdjpgzbtxList;
    }

    /**
     * 通过主键ID获取危险物料风险度表
     * @param id Primary key
     * @return Fxdjpgzbtx
     */
    @Override
    public Fxdjpgzbtx findFxdjpgzbtxById(Integer id) {
       // Fxdjpgzbtx fxdjpgzbtx = fxdjpgzbtxMapper.findByPrimaryKey(id);
       // return fxdjpgzbtx;
        return null;
    }

    /**
     * 添加危险物料风险度表
     * @param Fxdjpgzbtx
     */
    @Override
    public void saveFxdjpgzbtx(Fxdjpgzbtx fxdjpgzbtx) {
        SysUser currentUser = userRealm.getCurrentUser();
        
        fxdjpgzbtxMapper.save(fxdjpgzbtx);
        
    }

    /**
     * 更新危险物料风险度表
     * 根据Fxdjpgzbtx的主键更新主键以外的其他字段
     * @param Fxdjpgzbtx
     */
    @Override
    public void updateFxdjpgzbtxById(Fxdjpgzbtx fxdjpgzbtx) {
        
        fxdjpgzbtxMapper.updateByPrimaryKey(fxdjpgzbtx);
        
    }

    /**
     * 根据主键批量删除危险物料风险度表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    @Override
    public void deleteFxdjpgzbtxByIds(String ids) {
       
    }

    @Override
    public Fxdjpgzbtx searchOne(Long id) {
       Fxdjpgzbtx fxdjpgzbtx = fxdjpgzbtxMapper.findByPrimaryKey(id);
        return fxdjpgzbtx;
    }
    
    //private void cvtContentList(List<Fxdjpgzbtx> FxdjpgzbtxList) {
    //    for(Fxdjpgzbtx fxdjpgzbtx : FxdjpgzbtxList) {
    //    }
    //}
}

