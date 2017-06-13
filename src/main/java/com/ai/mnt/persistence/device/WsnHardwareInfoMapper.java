package com.ai.mnt.persistence.device;


import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;

import com.ai.mnt.model.device.WsnHardwareInfo;
import com.ai.mnt.persistence.base.CrudMapper;

/**
 * @Title: WsnHardwareInfoMapper 
 * @Description: WsnHardwareInfoMapper Persistence
 * @Author: Auto Generate. HE
 * @Date: 2016-10-28
 */
@Repository
public interface WsnHardwareInfoMapper extends CrudMapper<WsnHardwareInfo, Integer>{

   public WsnHardwareInfo findTxtByPrimaryKey(Integer wareId);

public List<WsnHardwareInfo> findListByInfo3(String infoThree);

public List<WsnHardwareInfo> findListByInfo2(String infoThree);

public List<WsnHardwareInfo> findListByInfo1(String info1);

public List<WsnHardwareInfo> findByRemark2(String opt);
//
public WsnHardwareInfo findByPrimary(String wareId);

public List<WsnHardwareInfo> findSensorByType(int i);
    
public List<Map<String,Object>> findDubug(int i);
    
}