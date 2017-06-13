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

import com.ai.mnt.model.sensor.WsnHeart;
import com.ai.mnt.service.sensor.WsnHeartService;

/**
 * @Title: WsnHeartController 
 * @Description: WsnHeartController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2017-4-20
 */

@Controller
@RequestMapping("/sensor")
public class WsnHeartController {

    @Autowired
    WsnHeartService wsnHeartService;
    
    /**
     * 温度数据表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnHeartPage(Model model) {
        return "sensor/info/sensor_info_query";
    }
    
    /**
     * 获取温度数据表列表
     * @param wsnHeart
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnHeartList(WsnHeart wsnHeart) {
        List<WsnHeart> wsnHeartList = wsnHeartService.findWsnHeartList(wsnHeart);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnHeartList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 温度数据表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnHeartAddPage(Model model) {
        return "sensor/info/sensor_info_add";
    }
    
    /**
     * 温度数据表保存
     * @param wsnHeart
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnHeart(WsnHeart wsnHeart) {
        wsnHeartService.saveWsnHeart(wsnHeart);
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
    public String showWsnHeartUpdatePage(Model model, @PathVariable String id) {
        WsnHeart wsnHeart = wsnHeartService.findWsnHeartById(Integer.parseInt(id));
        model.addAttribute("wsnHeart", wsnHeart);
        return "sensor/info/sensor_info_update";
    }
    
    /**
     * 温度数据表根据主键更新
     * @param wsnHeart
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnHeart(WsnHeart wsnHeart) {
        wsnHeartService.updateWsnHeartById(wsnHeart);
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
    public Map<String, Object> deleteWsnHeartByIds(@PathVariable String ids) {
        wsnHeartService.deleteWsnHeartByIds(ids);
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
    public String queryWsnHeartById(Model model, @PathVariable String id) {
        WsnHeart wsnHeart = new WsnHeart();
        wsnHeart.setId(Integer.parseInt(id));
        List<WsnHeart> wsnHeartList = wsnHeartService.findWsnHeartList(wsnHeart);
        if(wsnHeartList != null && wsnHeartList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnHeart", wsnHeartList.get(0));
        }
        return "sensor/info/sensor_info_info";
    }
}
