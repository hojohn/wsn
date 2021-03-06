package com.ai.mnt.service.device;

import java.util.List;

import com.ai.mnt.model.collect.WsnTempData2;
import com.ai.mnt.model.device.WsnSensor;
import com.ai.mnt.model.sensor.WsnTempData;
import com.ai.mnt.model.sensor.WsnTemperature;
import com.ai.mnt.web.collect.dataStruct;

/**
 * @Title: WsnSensorService 
 * @Description: WsnSensorService ServicePackage
 * @Author: Auto Generate.
 * @Date: 2016-10-30
 */

public interface WsnSensorService {
    
    /**
     * 获取所有职业卫生传感器列表
     * @return List<WsnSensor>
     */
    public List<WsnSensor> findAllWsnSensor();
    
    
    /**
     * 获取职业卫生传感器列表
     * @param device
     * @return List<WsnSensor>
     */
    public List<WsnSensor> findWsnSensorList(WsnSensor wsnSensor);
    
    /**
     * 通过主键ID获取职业卫生传感器
     * @param id Primary key
     * @return WsnSensor
     */
    public WsnSensor findWsnSensorById(Integer id);
    
    /**
     * 添加职业卫生传感器
     * @param WsnSensor
     */
   // public void saveWsnSensor(WsnSensor wsnSensor);
    
    /**
     * 更新职业卫生传感器
     * 根据WsnSensor的主键更新主键以外的其他字段
     * @param WsnSensor
     */
   // public void updateWsnSensorById(WsnSensor wsnSensor);
    
    /**
     * 根据主键批量删除职业卫生传感器 
     * 非物理删除 修改删除标识
     * @param id Primary key
     */
   // public void deleteWsnSensorByIds(String ids);


    public Float findDataAvg(WsnSensor wsnSensor);


    public List<WsnTemperature> findWsnSensorDataList(WsnSensor wsnSensor);


    public String findDate(String wareId);


    public List<WsnTempData> findAllllll();


    public WsnTempData findWsnSensorByWareId(String wareId);


    public String findNewDataById(String wareId);

    public void saveTempData(WsnTempData2 wsnTempData,int[] Node,dataStruct dataStruct,int[] Node2);
   
}
