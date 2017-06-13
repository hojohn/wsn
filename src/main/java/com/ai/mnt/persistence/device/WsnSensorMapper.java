package com.ai.mnt.persistence.device;


import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ai.mnt.model.device.WsnSensor;
import com.ai.mnt.persistence.base.CrudMapper;

/**
 * @Title: WsnSensorMapper 
 * @Description: WsnSensorMapper Persistence
 * @Author: Auto Generate. HE
 * @Date: 2016-10-30
 */
@Repository
public interface WsnSensorMapper extends CrudMapper<WsnSensor, Integer>{
    //@Param(value="beginDate")String beginDate,@Param(value="endDate")String endDate
    public Float calAvg(WsnSensor wsnSensor);

    public String findNew(@Param(value="wareId")String wareId);
    
    
}