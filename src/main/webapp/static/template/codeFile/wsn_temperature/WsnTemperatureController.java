package com.ai.mnt.web.sensor;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.model.sensor.WsnTemperature;
import com.ai.mnt.service.sensor.WsnTemperatureService;

/**
 * @Title: WsnTemperatureController 
 * @Description: WsnTemperatureController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

@Controller
@RequestMapping("/sensor")
public class WsnTemperatureController {

    @Autowired
    WsnTemperatureService wsnTemperatureService;
    
    /**
     * 温度数据表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnTemperaturePage(Model model) {
        return "sensor/info/sensor_info_query";
    }
    
    /**
     * 获取温度数据表列表
     * @param wsnTemperature
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnTemperatureList(WsnTemperature wsnTemperature) {
        List<WsnTemperature> wsnTemperatureList = wsnTemperatureService.findWsnTemperatureList(wsnTemperature);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnTemperatureList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 温度数据表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnTemperatureAddPage(Model model) {
        return "sensor/info/sensor_info_add";
    }
    
    /**
     * 温度数据表保存
     * @param wsnTemperature
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnTemperature(WsnTemperature wsnTemperature) {
        wsnTemperatureService.saveWsnTemperature(wsnTemperature);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 温度数据表更新界面跳转
     * @param  model
     * @param  id
     * @return
     */
    @RequestMapping("/info/update_page/{id}")
    public String showWsnTemperatureUpdatePage(Model model, @PathVariable String id) {
        WsnTemperature wsnTemperature = wsnTemperatureService.findWsnTemperatureById(Integer.parseInt(id));
        model.addAttribute("wsnTemperature", wsnTemperature);
        return "sensor/info/sensor_info_update";
    }
    
    /**
     * 温度数据表根据主键更新
     * @param wsnTemperature
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnTemperature(WsnTemperature wsnTemperature) {
        wsnTemperatureService.updateWsnTemperatureById(wsnTemperature);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 温度数据表根据主键批量删除
     * @param ids
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{ids}")
    @ResponseBody
    public Map<String, Object> deleteWsnTemperatureByIds(@PathVariable String ids) {
        wsnTemperatureService.deleteWsnTemperatureByIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询温度数据表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{id}/page")
    public String queryWsnTemperatureById(Model model, @PathVariable String id) {
        WsnTemperature wsnTemperature = new WsnTemperature();
        wsnTemperature.setId(Integer.parseInt(id));
        List<WsnTemperature> wsnTemperatureList = wsnTemperatureService.findWsnTemperatureList(wsnTemperature);
        if(wsnTemperatureList != null && wsnTemperatureList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnTemperature", wsnTemperatureList.get(0));
        }
        return "sensor/info/sensor_info_info";
    }
}
