package com.ai.mnt.service.sec;

import java.util.List;
import com.ai.mnt.model.sec.Fxdjpgzbtx;

/**
 * @Title: FxdjpgzbtxService 
 * @Description: FxdjpgzbtxService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2017-5-16
 */

public interface FxdjpgzbtxService {
    
    /**
     * 获取所有危险物料风险度表列表
     * @return List<Fxdjpgzbtx>
     */
    public List<Fxdjpgzbtx> findAllFxdjpgzbtx();
    
    
    /**
     * 获取危险物料风险度表列表
     * @param sec
     * @return List<Fxdjpgzbtx>
     */
    public List<Fxdjpgzbtx> findFxdjpgzbtxList(Fxdjpgzbtx fxdjpgzbtx);
    
    /**
     * 通过主键ID获取危险物料风险度表
     * @param id Primary key
     * @return Fxdjpgzbtx
     */
    public Fxdjpgzbtx findFxdjpgzbtxById(Integer id);
    
    /**
     * 添加危险物料风险度表
     * @param Fxdjpgzbtx
     */
    public void saveFxdjpgzbtx(Fxdjpgzbtx fxdjpgzbtx);
    
    /**
     * 更新危险物料风险度表
     * 根据Fxdjpgzbtx的主键更新主键以外的其他字段
     * @param Fxdjpgzbtx
     */
    public void updateFxdjpgzbtxById(Fxdjpgzbtx fxdjpgzbtx);
    
    /**
     * 根据主键批量删除危险物料风险度表 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
    public void deleteFxdjpgzbtxByIds(String ids);
}
