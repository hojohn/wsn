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

import com.ai.mnt.model.device.WsnDevice;
import com.ai.mnt.service.device.WsnDeviceService;

/**
 * @Title: WsnDeviceController 
 * @Description: WsnDeviceController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-19
 */

@Controller
@RequestMapping("/device")
public class WsnDeviceController {

    @Autowired
    WsnDeviceService wsnDeviceService;
    
    /**
     * 设备信息界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnDevicePage(Model model) {
        return "device/info/device_info_query";
    }
    
    /**
     * 获取设备信息列表
     * @param wsnDevice
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnDeviceList(WsnDevice wsnDevice) {
        List<WsnDevice> wsnDeviceList = wsnDeviceService.findWsnDeviceList(wsnDevice);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnDeviceList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 设备信息新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnDeviceAddPage(Model model) {
        return "device/info/device_info_add";
    }
    
    /**
     * 设备信息保存
     * @param wsnDevice
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnDevice(WsnDevice wsnDevice) {
        wsnDeviceService.saveWsnDevice(wsnDevice);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 设备信息更新界面跳转
     * @param  model
     * @param  deviceId
     * @return
     */
    @RequestMapping("/info/update_page/{deviceId}")
    public String showWsnDeviceUpdatePage(Model model, @PathVariable String deviceId) {
        WsnDevice wsnDevice = wsnDeviceService.findWsnDeviceByDeviceId(Integer.parseInt(deviceId));
        model.addAttribute("wsnDevice", wsnDevice);
        return "device/info/device_info_update";
    }
    
    /**
     * 设备信息根据主键更新
     * @param wsnDevice
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnDevice(WsnDevice wsnDevice) {
        wsnDeviceService.updateWsnDeviceByDeviceId(wsnDevice);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 设备信息根据主键批量删除
     * @param deviceIds
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{deviceIds}")
    @ResponseBody
    public Map<String, Object> deleteWsnDeviceByDeviceIds(@PathVariable String deviceIds) {
        wsnDeviceService.deleteWsnDeviceByDeviceIds(deviceIds);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询设备信息详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{deviceId}/page")
    public String queryWsnDeviceByDeviceId(Model model, @PathVariable String deviceId) {
        WsnDevice wsnDevice = new WsnDevice();
        wsnDevice.setDeviceId(Integer.parseInt(deviceId));
        List<WsnDevice> wsnDeviceList = wsnDeviceService.findWsnDeviceList(wsnDevice);
        if(wsnDeviceList != null && wsnDeviceList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnDevice", wsnDeviceList.get(0));
        }
        return "device/info/device_info_info";
    }
}
