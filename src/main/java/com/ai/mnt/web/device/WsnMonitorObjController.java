package com.ai.mnt.web.device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.model.device.WsnHardwareInfo;
import com.ai.mnt.model.device.WsnMonitorObj;
import com.ai.mnt.service.device.WsnHardwareInfoService;
import com.ai.mnt.service.device.WsnMonitorObjService;

/**
 * @Title: WsnMonitorObjController 
 * @Description: WsnMonitorObjController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-27
 */

@Controller
@RequestMapping("/device")
public class WsnMonitorObjController {

    @Autowired
    WsnMonitorObjService wsnMonitorObjService;
    
    @Autowired
    WsnHardwareInfoService wsnHardwareInfoService;
   
    
    /**
     * 仓库跳转  
     * 
     * 
     * @param  model
     * @return String
     */
    @RequestMapping("/monitor/add_page")
    public String showWsnMonitorObjAddPage(Model model ,@RequestParam("id") String id) {
        String monitorObjId = id;
        WsnMonitorObj wsnMonitorObj = wsnMonitorObjService.findWsnMonitorObjByMonitorObjId(monitorObjId);
       // model.addAttribute("wsnMonitorObj", wsnMonitorObj);
        
        if (wsnMonitorObj==null) {
            return "wsn_device/monitor/device_monitor_add";
        }else {
            model.addAttribute("wsnMonitorObj", wsnMonitorObj);
            WsnHardwareInfo wsnHardwareInfo = new WsnHardwareInfo();
            wsnHardwareInfo.setTypeId(1);
            wsnHardwareInfo.setObjId(monitorObjId);
            List<WsnHardwareInfo>senList = wsnHardwareInfoService.findWsnHardwareInfoList(wsnHardwareInfo);
            model.addAttribute("senList", senList);
            return "wsn_device/monitor/device_monitor_info";
        }
    }
    
    
    /**
     * 仓库修改
     * 
     * 
     * @param  model
     * @return String
     */
    @RequestMapping("/monitor/update_page")
    public String showWsnMonitorObjUpdate(Model model,WsnMonitorObj wsnMonitorObj) {
    System.out.println(wsnMonitorObj.getMonitorObjId());
        WsnMonitorObj wsnMonitorObj1 = wsnMonitorObjService.findWsnMonitorObjByMonitorObjId(wsnMonitorObj.getMonitorObjId());
        List<WsnHardwareInfo>senList = wsnHardwareInfoService.findWsnHardwareInfoListByInfo1(wsnMonitorObj.getMonitorObjId());
        model.addAttribute("senList", senList);
        model.addAttribute("wsnMonitorObj", wsnMonitorObj1);
        
        return "wsn_device/monitor/device_monitor_update";
    }
    

    
    /**
     * 监控对象保存 第一次增加
     * 
     * 
     * @param wsnMonitorObj
     * @return Map<String, Object>
     */
    @RequestMapping("/monitor/add")
    @ResponseBody
    public Map<String, Object> saveWsnMonitorObj(WsnMonitorObj wsnMonitorObj) {
        wsnMonitorObjService.saveWsnMonitorObj(wsnMonitorObj);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }

    
    /**
     * 监控对象根据主键更新
     * 
     * 
     * @param wsnMonitorObj
     * @return
     */
    @RequestMapping("/monitor/update")
    @ResponseBody
    public Map<String, Object> updateWsnMonitorObj(WsnMonitorObj wsnMonitorObj) {
        wsnMonitorObjService.updateWsnMonitorObjByMonitorObjId(wsnMonitorObj);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
  
}
