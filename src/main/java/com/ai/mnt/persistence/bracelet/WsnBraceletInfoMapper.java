package com.ai.mnt.persistence.bracelet;


import java.util.List;

import org.springframework.stereotype.Repository;

import com.ai.mnt.model.bracelet.WsnBraceletInfo;
import com.ai.mnt.persistence.base.CrudMapper;

/**
 * @Title: WsnBraceletInfoMapper 
 * @Description: WsnBraceletInfoMapper Persistence
 * @Author: Auto Generate. HE
 * @Date: 2016-12-7
 */
@Repository
public interface WsnBraceletInfoMapper extends CrudMapper<WsnBraceletInfo, String>{

    WsnBraceletInfo findByWareId(Integer bwareId);

    List<WsnBraceletInfo> findByBware(String id);
    
    
}