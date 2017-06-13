package com.ai.mnt.service.sec;

import java.util.List;
import com.ai.mnt.model.sec.SafeEval;

/**
 * @Title: SafeEvalService 
 * @Description: SafeEvalService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2017-5-16
 */

public interface SafeEvalService {
    
    /**
     * 获取所有危险物料风险度表列表
     * @return List<SafeEval>
     */
    public List<SafeEval> findAllSafeEval();
    
    
    /**
     * 获取危险物料风险度表列表
     * @param sec
     * @return List<SafeEval>
     */
    public List<SafeEval> findSafeEvalList(SafeEval safeEval);
    
    /**
     * 通过主键ID获取危险物料风险度表
     * @param id Primary key
     * @return SafeEval
     */
    public SafeEval findSafeEvalById(Integer id);
    
    /**
     * 添加危险物料风险度表
     * @param SafeEval
     */
    public void saveSafeEval(SafeEval safeEval);
    
    /**
     * 更新危险物料风险度表
     * 根据SafeEval的主键更新主键以外的其他字段
     * @param SafeEval
     */
    public void updateSafeEvalById(SafeEval safeEval);
    
    /**
     * 根据主键批量删除危险物料风险度表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteSafeEvalByIds(String ids);
}
