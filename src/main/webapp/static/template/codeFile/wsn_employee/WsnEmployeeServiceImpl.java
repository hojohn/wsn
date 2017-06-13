package com.ai.mnt.service.employee.impl;


import java.util.List;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.employee.WsnEmployee;
import com.ai.mnt.model.sys.SysUser;
import com.ai.mnt.persistence.employee.WsnEmployeeMapper;
import com.ai.mnt.service.employee.WsnEmployeeService;

/**
 * @Title: WsnEmployeeServiceImpl 
 * @Description: WsnEmployeeServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-16
 */
@Service
public class WsnEmployeeServiceImpl implements WsnEmployeeService{

    @Autowired
    WsnEmployeeMapper wsnEmployeeMapper;
    
    @Autowired
    UserRealm userRealm;
    
    /**
     * 获取所有作业人员信息列表
     * @return List<WsnEmployee>
     */
    @Override
    public List<WsnEmployee> findAllWsnEmployee() {
        List<WsnEmployee> wsnEmployeeList = wsnEmployeeMapper.findAll();
        //cvtContentList(wsnEmployeeList);
        return wsnEmployeeList;
    }

    /**
     * 获取作业人员信息列表
     * @param employee
     * @return List<WsnEmployee>
     */
    @Override
    public List<WsnEmployee> findWsnEmployeeList(WsnEmployee wsnEmployee) {
        List<WsnEmployee> wsnEmployeeList = wsnEmployeeMapper.findList(wsnEmployee);
        //cvtContentList(wsnEmployeeList);
        return wsnEmployeeList;
    }

    /**
     * 通过主键ID获取作业人员信息
     * @param personId Primary key
     * @return WsnEmployee
     */
    @Override
    public WsnEmployee findWsnEmployeeByPersonId(Integer personId) {
        WsnEmployee wsnEmployee = wsnEmployeeMapper.findByPrimaryKey(personId);
        return wsnEmployee;
    }

    /**
     * 添加作业人员信息
     * @param WsnEmployee
     */
    @Override
    public void saveWsnEmployee(WsnEmployee wsnEmployee) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnEmployee.setDeleteFlag("0");
        wsnEmployee.setCreator(currentUser.getUserName());
        wsnEmployee.setModifier(currentUser.getUserName());
        wsnEmployee.setCreateDate(new Date());
        wsnEmployee.setModifyDate(new Date());
        wsnEmployeeMapper.save(wsnEmployee);
        
    }

    /**
     * 更新作业人员信息
     * 根据WsnEmployee的主键更新主键以外的其他字段
     * @param WsnEmployee
     */
    @Override
    public void updateWsnEmployeeByPersonId(WsnEmployee wsnEmployee) {
        SysUser currentUser = userRealm.getCurrentUser();
        wsnEmployee.setModifier(currentUser.getUserName());
        wsnEmployee.setModifyDate(new Date());
        wsnEmployeeMapper.updateByPrimaryKey(wsnEmployee);
        
    }

    /**
     * 根据主键批量删除作业人员信息 
     * 非物理删除 修改删除标识
     * @param personId Primary key
     */
    @Override
    public void deleteWsnEmployeeByPersonIds(String personIds) {
        SysUser currentUser = userRealm.getCurrentUser();
        WsnEmployee wsnEmployee = new WsnEmployee();
        wsnEmployee.setDeleteFlag("1");
        wsnEmployee.setModifier(currentUser.getUserName());
        wsnEmployee.setModifyDate(new Date());
        String[] personIdAry = personIds.split(",");
        for(String personId : personIdAry) {
            wsnEmployee.setPersonId(Integer.parseInt(personId));
            wsnEmployeeMapper.updateByPrimaryKey(wsnEmployee);
        }
    }
    
    //private void cvtContentList(List<WsnEmployee> WsnEmployeeList) {
    //    for(WsnEmployee wsnEmployee : WsnEmployeeList) {
    //    }
    //}
}

