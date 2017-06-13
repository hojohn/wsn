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

import com.ai.mnt.model.sensor.WsnMethane;
import com.ai.mnt.service.sensor.WsnMethaneService;

/**
 * @Title: WsnMethaneController 
 * @Description: WsnMethaneController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */

@Controller
@RequestMapping("/sensor")
public class WsnMethaneController {

    @Autowired
    WsnMethaneService wsnMethaneService;
    
    /**
     * 甲烷数据表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnMethanePage(Model model) {
        return "sensor/info/sensor_info_query";
    }
    
    /**
     * 获取甲烷数据表列表
     * @param wsnMethane
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnMethaneList(WsnMethane wsnMethane) {
        List<WsnMethane> wsnMethaneList = wsnMethaneService.findWsnMethaneList(wsnMethane);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnMethaneList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 甲烷数据表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnMethaneAddPage(Model model) {
        return "sensor/info/sensor_info_add";
    }
    
    /**
     * 甲烷数据表保存
     * @param wsnMethane
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnMethane(WsnMethane wsnMethane) {
        wsnMethaneService.saveWsnMethane(wsnMethane);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 甲烷数据表更新界面跳转
     * @param  model
     * @param  id
     * @return
     */
    @RequestMapping("/info/update_page/{id}")
    public String showWsnMethaneUpdatePage(Model model, @PathVariable String id) {
        WsnMethane wsnMethane = wsnMethaneService.findWsnMethaneById(Integer.parseInt(id));
        model.addAttribute("wsnMethane", wsnMethane);
        return "sensor/info/sensor_info_update";
    }
    
    /**
     * 甲烷数据表根据主键更新
     * @param wsnMethane
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnMethane(WsnMethane wsnMethane) {
        wsnMethaneService.updateWsnMethaneById(wsnMethane);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 甲烷数据表根据主键批量删除
     * @param ids
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{ids}")
    @ResponseBody
    public Map<String, Object> deleteWsnMethaneByIds(@PathVariable String ids) {
        wsnMethaneService.deleteWsnMethaneByIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询甲烷数据表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{id}/page")
    public String queryWsnMethaneById(Model model, @PathVariable String id) {
        WsnMethane wsnMethane = new WsnMethane();
        wsnMethane.setId(Integer.parseInt(id));
        List<WsnMethane> wsnMethaneList = wsnMethaneService.findWsnMethaneList(wsnMethane);
        if(wsnMethaneList != null && wsnMethaneList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnMethane", wsnMethaneList.get(0));
        }
        return "sensor/info/sensor_info_info";
    }
}
