package com.ai.mnt.persistence.device;


import org.springframework.stereotype.Repository;

import com.ai.mnt.model.device.WsnMonitorObj;
import com.ai.mnt.persistence.base.CrudMapper;

/**
 * @Title: WsnMonitorObjMapper 
 * @Description: WsnMonitorObjMapper Persistence
 * @Author: Auto Generate. HE
 * @Date: 2016-10-27
 */
@Repository
public interface WsnMonitorObjMapper extends CrudMapper<WsnMonitorObj, Integer>{

    public WsnMonitorObj findByPrimary(String monitorObjId);
    
    
}