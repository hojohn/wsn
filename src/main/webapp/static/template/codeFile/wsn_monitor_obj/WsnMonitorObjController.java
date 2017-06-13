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

import com.ai.mnt.model.device.WsnMonitorObj;
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
    
    /**
     * 监控对象界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/monitor/page")
    public String showWsnMonitorObjPage(Model model) {
        return "device/monitor/device_monitor_query";
    }
    
    /**
     * 获取监控对象列表
     * @param wsnMonitorObj
     * @return Map<String, Object>
     */
    @RequestMapping("/monitor/query")
    @ResponseBody
    public Map<String, Object> getWsnMonitorObjList(WsnMonitorObj wsnMonitorObj) {
        List<WsnMonitorObj> wsnMonitorObjList = wsnMonitorObjService.findWsnMonitorObjList(wsnMonitorObj);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnMonitorObjList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 监控对象新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/monitor/add_page")
    public String showWsnMonitorObjAddPage(Model model) {
        return "device/monitor/device_monitor_add";
    }
    
    /**
     * 监控对象保存
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
     * 监控对象更新界面跳转
     * @param  model
     * @param  monitorObjId
     * @return
     */
    @RequestMapping("/monitor/update_page/{monitorObjId}")
    public String showWsnMonitorObjUpdatePage(Model model, @PathVariable String monitorObjId) {
        WsnMonitorObj wsnMonitorObj = wsnMonitorObjService.findWsnMonitorObjByMonitorObjId(Integer.parseInt(monitorObjId));
        model.addAttribute("wsnMonitorObj", wsnMonitorObj);
        return "device/monitor/device_monitor_update";
    }
    
    /**
     * 监控对象根据主键更新
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
    
    /**
     * 监控对象根据主键批量删除
     * @param monitorObjIds
     * @return Map<String, Object>
     */
    @RequestMapping("/monitor/delete/{monitorObjIds}")
    @ResponseBody
    public Map<String, Object> deleteWsnMonitorObjByMonitorObjIds(@PathVariable String monitorObjIds) {
        wsnMonitorObjService.deleteWsnMonitorObjByMonitorObjIds(monitorObjIds);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询监控对象详细信息
     * @param model
     * @return
     */
    @RequestMapping("/monitor/{monitorObjId}/page")
    public String queryWsnMonitorObjByMonitorObjId(Model model, @PathVariable String monitorObjId) {
        WsnMonitorObj wsnMonitorObj = new WsnMonitorObj();
        wsnMonitorObj.setMonitorObjId(Integer.parseInt(monitorObjId));
        List<WsnMonitorObj> wsnMonitorObjList = wsnMonitorObjService.findWsnMonitorObjList(wsnMonitorObj);
        if(wsnMonitorObjList != null && wsnMonitorObjList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnMonitorObj", wsnMonitorObjList.get(0));
        }
        return "device/monitor/device_monitor_info";
    }
}
