package com.ai.mnt.persistence.sensor;


import org.apache.ibatis.annotations.Param;

import com.ai.mnt.model.sensor.WsnTempData;
import com.ai.mnt.persistence.base.CrudMapper;

public interface WsnTempDataMapper extends CrudMapper<WsnTempData, Integer>{

    WsnTempData findByWareId(@Param("wareId") String wareId);

    String findNewDataById(String wareId);
    
    
}
