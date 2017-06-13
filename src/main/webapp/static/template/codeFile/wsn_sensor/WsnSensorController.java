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

import com.ai.mnt.model.device.WsnSensor;
import com.ai.mnt.service.device.WsnSensorService;

/**
 * @Title: WsnSensorController 
 * @Description: WsnSensorController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-30
 */

@Controller
@RequestMapping("/device")
public class WsnSensorController {

    @Autowired
    WsnSensorService wsnSensorService;
    
    /**
     * 职业卫生传感器界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/sensor/page")
    public String showWsnSensorPage(Model model) {
        return "device/sensor/device_sensor_query";
    }
    
    /**
     * 获取职业卫生传感器列表
     * @param wsnSensor
     * @return Map<String, Object>
     */
    @RequestMapping("/sensor/query")
    @ResponseBody
    public Map<String, Object> getWsnSensorList(WsnSensor wsnSensor) {
        List<WsnSensor> wsnSensorList = wsnSensorService.findWsnSensorList(wsnSensor);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnSensorList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 职业卫生传感器新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/sensor/add_page")
    public String showWsnSensorAddPage(Model model) {
        return "device/sensor/device_sensor_add";
    }
    
    /**
     * 职业卫生传感器保存
     * @param wsnSensor
     * @return Map<String, Object>
     */
    @RequestMapping("/sensor/add")
    @ResponseBody
    public Map<String, Object> saveWsnSensor(WsnSensor wsnSensor) {
        wsnSensorService.saveWsnSensor(wsnSensor);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 职业卫生传感器更新界面跳转
     * @param  model
     * @param  id
     * @return
     */
    @RequestMapping("/sensor/update_page/{id}")
    public String showWsnSensorUpdatePage(Model model, @PathVariable String id) {
        WsnSensor wsnSensor = wsnSensorService.findWsnSensorById(Integer.parseInt(id));
        model.addAttribute("wsnSensor", wsnSensor);
        return "device/sensor/device_sensor_update";
    }
    
    /**
     * 职业卫生传感器根据主键更新
     * @param wsnSensor
     * @return
     */
    @RequestMapping("/sensor/update")
    @ResponseBody
    public Map<String, Object> updateWsnSensor(WsnSensor wsnSensor) {
        wsnSensorService.updateWsnSensorById(wsnSensor);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 职业卫生传感器根据主键批量删除
     * @param ids
     * @return Map<String, Object>
     */
    @RequestMapping("/sensor/delete/{ids}")
    @ResponseBody
    public Map<String, Object> deleteWsnSensorByIds(@PathVariable String ids) {
        wsnSensorService.deleteWsnSensorByIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询职业卫生传感器详细信息
     * @param model
     * @return
     */
    @RequestMapping("/sensor/{id}/page")
    public String queryWsnSensorById(Model model, @PathVariable String id) {
        WsnSensor wsnSensor = new WsnSensor();
        wsnSensor.setId(Integer.parseInt(id));
        List<WsnSensor> wsnSensorList = wsnSensorService.findWsnSensorList(wsnSensor);
        if(wsnSensorList != null && wsnSensorList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnSensor", wsnSensorList.get(0));
        }
        return "device/sensor/device_sensor_info";
    }
}
