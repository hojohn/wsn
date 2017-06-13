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

import com.ai.mnt.model.device.WsnHardwareInfo;
import com.ai.mnt.service.device.WsnHardwareInfoService;

/**
 * @Title: WsnHardwareInfoController 
 * @Description: WsnHardwareInfoController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-11-29
 */

@Controller
@RequestMapping("/device")
public class WsnHardwareInfoController {

    @Autowired
    WsnHardwareInfoService wsnHardwareInfoService;
    
    /**
     * 硬件信息表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/hardware/page")
    public String showWsnHardwareInfoPage(Model model) {
        return "device/hardware/device_hardware_query";
    }
    
    /**
     * 获取硬件信息表列表
     * @param wsnHardwareInfo
     * @return Map<String, Object>
     */
    @RequestMapping("/hardware/query")
    @ResponseBody
    public Map<String, Object> getWsnHardwareInfoList(WsnHardwareInfo wsnHardwareInfo) {
        List<WsnHardwareInfo> wsnHardwareInfoList = wsnHardwareInfoService.findWsnHardwareInfoList(wsnHardwareInfo);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnHardwareInfoList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 硬件信息表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/hardware/add_page")
    public String showWsnHardwareInfoAddPage(Model model) {
        return "device/hardware/device_hardware_add";
    }
    
    /**
     * 硬件信息表保存
     * @param wsnHardwareInfo
     * @return Map<String, Object>
     */
    @RequestMapping("/hardware/add")
    @ResponseBody
    public Map<String, Object> saveWsnHardwareInfo(WsnHardwareInfo wsnHardwareInfo) {
        wsnHardwareInfoService.saveWsnHardwareInfo(wsnHardwareInfo);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 硬件信息表更新界面跳转
     * @param  model
     * @param  wareId
     * @return
     */
    @RequestMapping("/hardware/update_page/{wareId}")
    public String showWsnHardwareInfoUpdatePage(Model model, @PathVariable String wareId) {
        WsnHardwareInfo wsnHardwareInfo = wsnHardwareInfoService.findWsnHardwareInfoByWareId(Integer.parseInt(wareId));
        model.addAttribute("wsnHardwareInfo", wsnHardwareInfo);
        return "device/hardware/device_hardware_update";
    }
    
    /**
     * 硬件信息表根据主键更新
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
    
    /**
     * 硬件信息表根据主键批量删除
     * @param wareIds
     * @return Map<String, Object>
     */
    @RequestMapping("/hardware/delete/{wareIds}")
    @ResponseBody
    public Map<String, Object> deleteWsnHardwareInfoByWareIds(@PathVariable String wareIds) {
        wsnHardwareInfoService.deleteWsnHardwareInfoByWareIds(wareIds);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询硬件信息表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/hardware/{wareId}/page")
    public String queryWsnHardwareInfoByWareId(Model model, @PathVariable String wareId) {
        WsnHardwareInfo wsnHardwareInfo = new WsnHardwareInfo();
        wsnHardwareInfo.setWareId(Integer.parseInt(wareId));
        List<WsnHardwareInfo> wsnHardwareInfoList = wsnHardwareInfoService.findWsnHardwareInfoList(wsnHardwareInfo);
        if(wsnHardwareInfoList != null && wsnHardwareInfoList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnHardwareInfo", wsnHardwareInfoList.get(0));
        }
        return "device/hardware/device_hardware_info";
    }
}
