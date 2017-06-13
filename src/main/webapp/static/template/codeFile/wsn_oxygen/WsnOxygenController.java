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

import com.ai.mnt.model.sensor.WsnOxygen;
import com.ai.mnt.service.sensor.WsnOxygenService;

/**
 * @Title: WsnOxygenController 
 * @Description: WsnOxygenController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

@Controller
@RequestMapping("/sensor")
public class WsnOxygenController {

    @Autowired
    WsnOxygenService wsnOxygenService;
    
    /**
     * 氧气数据表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnOxygenPage(Model model) {
        return "sensor/info/sensor_info_query";
    }
    
    /**
     * 获取氧气数据表列表
     * @param wsnOxygen
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnOxygenList(WsnOxygen wsnOxygen) {
        List<WsnOxygen> wsnOxygenList = wsnOxygenService.findWsnOxygenList(wsnOxygen);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnOxygenList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 氧气数据表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnOxygenAddPage(Model model) {
        return "sensor/info/sensor_info_add";
    }
    
    /**
     * 氧气数据表保存
     * @param wsnOxygen
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnOxygen(WsnOxygen wsnOxygen) {
        wsnOxygenService.saveWsnOxygen(wsnOxygen);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 氧气数据表更新界面跳转
     * @param  model
     * @param  id
     * @return
     */
    @RequestMapping("/info/update_page/{id}")
    public String showWsnOxygenUpdatePage(Model model, @PathVariable String id) {
        WsnOxygen wsnOxygen = wsnOxygenService.findWsnOxygenById(Integer.parseInt(id));
        model.addAttribute("wsnOxygen", wsnOxygen);
        return "sensor/info/sensor_info_update";
    }
    
    /**
     * 氧气数据表根据主键更新
     * @param wsnOxygen
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnOxygen(WsnOxygen wsnOxygen) {
        wsnOxygenService.updateWsnOxygenById(wsnOxygen);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 氧气数据表根据主键批量删除
     * @param ids
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{ids}")
    @ResponseBody
    public Map<String, Object> deleteWsnOxygenByIds(@PathVariable String ids) {
        wsnOxygenService.deleteWsnOxygenByIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询氧气数据表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{id}/page")
    public String queryWsnOxygenById(Model model, @PathVariable String id) {
        WsnOxygen wsnOxygen = new WsnOxygen();
        wsnOxygen.setId(Integer.parseInt(id));
        List<WsnOxygen> wsnOxygenList = wsnOxygenService.findWsnOxygenList(wsnOxygen);
        if(wsnOxygenList != null && wsnOxygenList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnOxygen", wsnOxygenList.get(0));
        }
        return "sensor/info/sensor_info_info";
    }
}
