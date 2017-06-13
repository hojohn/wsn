package com.ai.mnt.service.employee;

import java.util.List;
import com.ai.mnt.model.employee.WsnEmployee;

/**
 * @Title: WsnEmployeeService 
 * @Description: WsnEmployeeService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-10-16
 */

public interface WsnEmployeeService {
    
    /**
     * 获取所有作业人员信息列表
     * @return List<WsnEmployee>
     */
    public List<WsnEmployee> findAllWsnEmployee();
    
    
    /**
     * 获取作业人员信息列表
     * @param employee
     * @return List<WsnEmployee>
     */
    public List<WsnEmployee> findWsnEmployeeList(WsnEmployee wsnEmployee);
    
    /**
     * 通过主键ID获取作业人员信息
     * @param personId Primary key
     * @return WsnEmployee
     */
    public WsnEmployee findWsnEmployeeByPersonId(Integer personId);
    
    /**
     * 添加作业人员信息
     * @param WsnEmployee
     */
    public void saveWsnEmployee(WsnEmployee wsnEmployee);
    
    /**
     * 更新作业人员信息
     * 根据WsnEmployee的主键更新主键以外的其他字段
     * @param WsnEmployee
     */
    public void updateWsnEmployeeByPersonId(WsnEmployee wsnEmployee);
    
    /**
     * 根据主键批量删除作业人员信息 
     * 非物理删除 修改删除标识
     * @param personId Primary key
     */
    public void deleteWsnEmployeeByPersonIds(String personIds);
}
