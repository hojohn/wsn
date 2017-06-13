package com.ai.mnt.persistence.collect;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ai.mnt.model.collect.WsnTemperature2;
import com.ai.mnt.model.sensor.WsnTemperature;
import com.ai.mnt.persistence.base.CrudMapper;

/**
 * @Title: WsnTemperatureMapper 
 * @Description: WsnTemperatureMapper Persistence
 * @Author: Auto Generate. HE
 * @Date: 2016-12-21
 */
@Repository
public interface WsnTemperatureMapper2 extends CrudMapper<WsnTemperature2, Integer>{

    List<WsnTemperature> findList1(@Param("wareId")String wareId,@Param("bDate") Date bDate, @Param("eDate")Date eDate);

    Float calAvg(@Param("wareId")String wareId,@Param("bDate") String bDate, @Param("eDate")String eDate);

    String findNew(@Param("wareId")String wareId);

    
    
}