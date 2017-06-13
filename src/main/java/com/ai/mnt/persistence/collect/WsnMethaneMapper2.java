package com.ai.mnt.persistence.collect;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ai.mnt.model.collect.WsnMethane2;
import com.ai.mnt.model.sensor.WsnCarbonmonoxide;
import com.ai.mnt.model.sensor.WsnMethane;
import com.ai.mnt.persistence.base.CrudMapper;

/**
 * @Title: WsnMethaneMapper 
 * @Description: WsnMethaneMapper Persistence
 * @Author: Auto Generate. HE
 * @Date: 2016-12-21
 */
@Repository
public interface WsnMethaneMapper2 extends CrudMapper<WsnMethane2, Integer>{

    List<WsnMethane> findList(@Param("wareId")String wareId,@Param("bDate") Date bDate, @Param("eDate")Date eDate);

    Float calAvg(@Param("wareId")String wareId,@Param("bDate") String bDate, @Param("eDate")String eDate);

    String findNew(@Param("wareId")String wareId);
    
    
}