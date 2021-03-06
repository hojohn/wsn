package com.ai.mnt.persistence.device;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.ai.mnt.model.device.WsnDeviceRepair;
import com.ai.mnt.persistence.base.CrudMapper;

/**
 * @Title: WsnDeviceRepairMapper 
 * @Description: WsnDeviceRepairMapper Persistence
 * @Author: Auto Generate. HE
 * @Date: 2016-10-15
 */
@Repository
public interface WsnDeviceRepairMapper extends CrudMapper<WsnDeviceRepair, Integer>{

    List<WsnDeviceRepair> findByRfid(Integer deviceRfid);


   // List<WsnDeviceRepair> findListByRfid(int deviceRfid);
    
    
}