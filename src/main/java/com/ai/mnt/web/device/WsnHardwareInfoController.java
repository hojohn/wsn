package com.ai.mnt.web.device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.model.device.WsnGeteway;
import com.ai.mnt.model.device.WsnHardwareInfo;
import com.ai.mnt.service.device.WsnGetewayService;
import com.ai.mnt.service.device.WsnHardwareInfoService;

/**
 * @Title: WsnHardwareInfoController 
 * @Description: WsnHardwareInfoController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-28
 */

@Controller
@RequestMapping("/device")
public class WsnHardwareInfoController {

    @Autowired
    WsnHardwareInfoService wsnHardwareInfoService;
    
    @Autowired
    WsnGetewayService wsnGetewayService;
    
    
    
    /**
     * 硬件信息表保存
     * @param wsnHardwareInfo
     * @return Map<String, Object>
     */
    @RequestMapping("/hardware/add")
    @ResponseBody
    public Map<String, Object> saveWsnHardwareInfo(WsnHardwareInfo wsnHardwareInfo) {
        //wsnHardwareInfoService.updateWsnHardwareInfoByWareId(wsnHardwareInfo);
        wsnHardwareInfoService.saveWsnHardwareInfo(wsnHardwareInfo);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
   
    
    /**
     * ok
     * 移动节点信息表根据主键更新===========增加的时候===========================================
     * @param wsnHardwareInfo
     * @return
     */
    @RequestMapping("/move_node/update")
    @ResponseBody
    public Map<String, Object> updateWsnMoveNodeInfo(WsnHardwareInfo wsnHardwareInfo) {
        wsnHardwareInfoService.saveWsnHardwareInfo(wsnHardwareInfo);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    /**
     * 
     * ok
     * 传感器信息表根据主键更新=========节点/ 终端的修改=============================================
     * @param wsnHardwareInfo
     * @return
     */
    @RequestMapping("/hardware/update")
    @ResponseBody
    public Map<String, Object> updateWsnHardwareInfo(WsnHardwareInfo wsnHardwareInfo) {
        wsnHardwareInfoService.updateWsnHardwareInfoByWareId(wsnHardwareInfo);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    
}
