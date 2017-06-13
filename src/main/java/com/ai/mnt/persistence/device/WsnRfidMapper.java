package com.ai.mnt.persistence.device;


import org.springframework.stereotype.Repository;

import com.ai.mnt.model.device.WsnRfid;
import com.ai.mnt.persistence.base.CrudMapper;

/**
 * @Title: WsnRfidMapper 
 * @Description: WsnRfidMapper Persistence
 * @Author: Auto Generate. HE
 * @Date: 2016-10-18
 */
@Repository
public interface WsnRfidMapper extends CrudMapper<WsnRfid, Integer>{

    WsnRfid findByDeviceBindNumber(String deviceRfid);
    
    
}