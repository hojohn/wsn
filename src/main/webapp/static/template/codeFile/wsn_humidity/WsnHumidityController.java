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

import com.ai.mnt.model.sensor.WsnHumidity;
import com.ai.mnt.service.sensor.WsnHumidityService;

/**
 * @Title: WsnHumidityController 
 * @Description: WsnHumidityController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

@Controller
@RequestMapping("/sensor")
public class WsnHumidityController {

    @Autowired
    WsnHumidityService wsnHumidityService;
    
    /**
     * 湿度数据表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnHumidityPage(Model model) {
        return "sensor/info/sensor_info_query";
    }
    
    /**
     * 获取湿度数据表列表
     * @param wsnHumidity
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnHumidityList(WsnHumidity wsnHumidity) {
        List<WsnHumidity> wsnHumidityList = wsnHumidityService.findWsnHumidityList(wsnHumidity);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnHumidityList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 湿度数据表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnHumidityAddPage(Model model) {
        return "sensor/info/sensor_info_add";
    }
    
    /**
     * 湿度数据表保存
     * @param wsnHumidity
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnHumidity(WsnHumidity wsnHumidity) {
        wsnHumidityService.saveWsnHumidity(wsnHumidity);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 湿度数据表更新界面跳转
     * @param  model
     * @param  id
     * @return
     */
    @RequestMapping("/info/update_page/{id}")
    public String showWsnHumidityUpdatePage(Model model, @PathVariable String id) {
        WsnHumidity wsnHumidity = wsnHumidityService.findWsnHumidityById(Integer.parseInt(id));
        model.addAttribute("wsnHumidity", wsnHumidity);
        return "sensor/info/sensor_info_update";
    }
    
    /**
     * 湿度数据表根据主键更新
     * @param wsnHumidity
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnHumidity(WsnHumidity wsnHumidity) {
        wsnHumidityService.updateWsnHumidityById(wsnHumidity);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 湿度数据表根据主键批量删除
     * @param ids
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{ids}")
    @ResponseBody
    public Map<String, Object> deleteWsnHumidityByIds(@PathVariable String ids) {
        wsnHumidityService.deleteWsnHumidityByIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询湿度数据表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{id}/page")
    public String queryWsnHumidityById(Model model, @PathVariable String id) {
        WsnHumidity wsnHumidity = new WsnHumidity();
        wsnHumidity.setId(Integer.parseInt(id));
        List<WsnHumidity> wsnHumidityList = wsnHumidityService.findWsnHumidityList(wsnHumidity);
        if(wsnHumidityList != null && wsnHumidityList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnHumidity", wsnHumidityList.get(0));
        }
        return "sensor/info/sensor_info_info";
    }
}
