package com.ai.mnt.persistence.collect;


import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import com.ai.mnt.model.collect.WsnNoise2;
import com.ai.mnt.model.sensor.WsnNoise;
import com.ai.mnt.model.sensor.WsnOxygen;
import com.ai.mnt.persistence.base.CrudMapper;

/**
 * @Title: WsnNoiseMapper 
 * @Description: WsnNoiseMapper Persistence
 * @Author: Auto Generate. HE
 * @Date: 2017-4-20
 */
@Repository
public interface WsnNoiseMapper2 extends CrudMapper<WsnNoise2, Integer>{
    
    List<WsnNoise> findList(@Param("wareId")String wareId,@Param("bDate") Date bDate, @Param("eDate")Date eDate);

    Float calAvg(@Param("wareId")String wareId,@Param("bDate") String bDate, @Param("eDate")String eDate);

    String findNew(@Param("wareId")String wareId);

}