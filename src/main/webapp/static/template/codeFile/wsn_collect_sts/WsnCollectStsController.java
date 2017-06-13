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

import com.ai.mnt.model.collect.WsnCollectSts;
import com.ai.mnt.service.collect.WsnCollectStsService;

/**
 * @Title: WsnCollectStsController 
 * @Description: WsnCollectStsController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2017-3-10
 */

@Controller
@RequestMapping("/collect")
public class WsnCollectStsController {

    @Autowired
    WsnCollectStsService wsnCollectStsService;
    
    /**
     * 状态表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/status/page")
    public String showWsnCollectStsPage(Model model) {
        return "collect/status/collect_status_query";
    }
    
    /**
     * 获取状态表列表
     * @param wsnCollectSts
     * @return Map<String, Object>
     */
    @RequestMapping("/status/query")
    @ResponseBody
    public Map<String, Object> getWsnCollectStsList(WsnCollectSts wsnCollectSts) {
        List<WsnCollectSts> wsnCollectStsList = wsnCollectStsService.findWsnCollectStsList(wsnCollectSts);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnCollectStsList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 状态表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/status/add_page")
    public String showWsnCollectStsAddPage(Model model) {
        return "collect/status/collect_status_add";
    }
    
    /**
     * 状态表保存
     * @param wsnCollectSts
     * @return Map<String, Object>
     */
    @RequestMapping("/status/add")
    @ResponseBody
    public Map<String, Object> saveWsnCollectSts(WsnCollectSts wsnCollectSts) {
        wsnCollectStsService.saveWsnCollectSts(wsnCollectSts);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 状态表更新界面跳转
     * @param  model
     * @param  id
     * @return
     */
    @RequestMapping("/status/update_page/{id}")
    public String showWsnCollectStsUpdatePage(Model model, @PathVariable String id) {
        WsnCollectSts wsnCollectSts = wsnCollectStsService.findWsnCollectStsById(Integer.parseInt(id));
        model.addAttribute("wsnCollectSts", wsnCollectSts);
        return "collect/status/collect_status_update";
    }
    
    /**
     * 状态表根据主键更新
     * @param wsnCollectSts
     * @return
     */
    @RequestMapping("/status/update")
    @ResponseBody
    public Map<String, Object> updateWsnCollectSts(WsnCollectSts wsnCollectSts) {
        wsnCollectStsService.updateWsnCollectStsById(wsnCollectSts);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 状态表根据主键批量删除
     * @param ids
     * @return Map<String, Object>
     */
    @RequestMapping("/status/delete/{ids}")
    @ResponseBody
    public Map<String, Object> deleteWsnCollectStsByIds(@PathVariable String ids) {
        wsnCollectStsService.deleteWsnCollectStsByIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询状态表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/status/{id}/page")
    public String queryWsnCollectStsById(Model model, @PathVariable String id) {
        WsnCollectSts wsnCollectSts = new WsnCollectSts();
        wsnCollectSts.setId(Integer.parseInt(id));
        List<WsnCollectSts> wsnCollectStsList = wsnCollectStsService.findWsnCollectStsList(wsnCollectSts);
        if(wsnCollectStsList != null && wsnCollectStsList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnCollectSts", wsnCollectStsList.get(0));
        }
        return "collect/status/collect_status_info";
    }
}
