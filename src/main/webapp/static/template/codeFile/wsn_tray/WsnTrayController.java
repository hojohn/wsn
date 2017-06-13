package com.ai.mnt.web.collect;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.model.collect.WsnTray;
import com.ai.mnt.service.collect.WsnTrayService;

/**
 * @Title: WsnTrayController 
 * @Description: WsnTrayController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2017-4-25
 */

@Controller
@RequestMapping("/collect")
public class WsnTrayController {

    @Autowired
    WsnTrayService wsnTrayService;
    
    /**
     * 状态界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnTrayPage(Model model) {
        return "collect/info/collect_info_query";
    }
    
    /**
     * 获取状态列表
     * @param wsnTray
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnTrayList(WsnTray wsnTray) {
        List<WsnTray> wsnTrayList = wsnTrayService.findWsnTrayList(wsnTray);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnTrayList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 状态新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnTrayAddPage(Model model) {
        return "collect/info/collect_info_add";
    }
    
    /**
     * 状态保存
     * @param wsnTray
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnTray(WsnTray wsnTray) {
        wsnTrayService.saveWsnTray(wsnTray);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 状态更新界面跳转
     * @param  model
     * @param  wareId
     * @return
     */
    @RequestMapping("/info/update_page/{wareId}")
    public String showWsnTrayUpdatePage(Model model, @PathVariable String wareId) {
        WsnTray wsnTray = wsnTrayService.findWsnTrayByWareId(Integer.parseInt(wareId));
        model.addAttribute("wsnTray", wsnTray);
        return "collect/info/collect_info_update";
    }
    
    /**
     * 状态根据主键更新
     * @param wsnTray
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnTray(WsnTray wsnTray) {
        wsnTrayService.updateWsnTrayByWareId(wsnTray);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 状态根据主键批量删除
     * @param wareIds
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{wareIds}")
    @ResponseBody
    public Map<String, Object> deleteWsnTrayByWareIds(@PathVariable String wareIds) {
        wsnTrayService.deleteWsnTrayByWareIds(wareIds);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询状态详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{wareId}/page")
    public String queryWsnTrayByWareId(Model model, @PathVariable String wareId) {
        WsnTray wsnTray = new WsnTray();
        wsnTray.setWareId(Integer.parseInt(wareId));
        List<WsnTray> wsnTrayList = wsnTrayService.findWsnTrayList(wsnTray);
        if(wsnTrayList != null && wsnTrayList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnTray", wsnTrayList.get(0));
        }
        return "collect/info/collect_info_info";
    }
}
