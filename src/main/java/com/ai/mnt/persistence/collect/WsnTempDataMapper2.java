package com.ai.mnt.persistence.collect;


import org.apache.ibatis.annotations.Param;

import com.ai.mnt.model.collect.WsnTempData2;
import com.ai.mnt.model.sensor.WsnTempData;
import com.ai.mnt.persistence.base.CrudMapper;

public interface WsnTempDataMapper2 extends CrudMapper<WsnTempData2, Integer>{

    WsnTempData findByWareId(@Param("wareId") String wareId);

    String findNewDataById(String wareId);
    
    
}
