package com.ai.mnt.web.sec;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.model.sec.SafeEval;
import com.ai.mnt.service.sec.SafeEvalService;

/**
 * @Title: SafeEvalController 
 * @Description: SafeEvalController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2017-5-16
 */

@Controller
@RequestMapping("/sec")
public class SafeEvalController {

    @Autowired
    SafeEvalService safeEvalService;
    
    /**
     * 危险物料风险度表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showSafeEvalPage(Model model) {
        return "sec/info/sec_info_query";
    }
    
    /**
     * 获取危险物料风险度表列表
     * @param safeEval
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getSafeEvalList(SafeEval safeEval) {
        List<SafeEval> safeEvalList = safeEvalService.findSafeEvalList(safeEval);
        Map<String, Object> map = new HashMap<>();
        map.put("data", safeEvalList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 危险物料风险度表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showSafeEvalAddPage(Model model) {
        return "sec/info/sec_info_add";
    }
    
    /**
     * 危险物料风险度表保存
     * @param safeEval
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveSafeEval(SafeEval safeEval) {
        safeEvalService.saveSafeEval(safeEval);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 危险物料风险度表更新界面跳转
     * @param  model
     * @param  id
     * @return
     */
    @RequestMapping("/info/update_page/{id}")
    public String showSafeEvalUpdatePage(Model model, @PathVariable String id) {
        SafeEval safeEval = safeEvalService.findSafeEvalById(Integer.parseInt(id));
        model.addAttribute("safeEval", safeEval);
        return "sec/info/sec_info_update";
    }
    
    /**
     * 危险物料风险度表根据主键更新
     * @param safeEval
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateSafeEval(SafeEval safeEval) {
        safeEvalService.updateSafeEvalById(safeEval);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 危险物料风险度表根据主键批量删除
     * @param ids
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{ids}")
    @ResponseBody
    public Map<String, Object> deleteSafeEvalByIds(@PathVariable String ids) {
        safeEvalService.deleteSafeEvalByIds(ids);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询危险物料风险度表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{id}/page")
    public String querySafeEvalById(Model model, @PathVariable String id) {
        SafeEval safeEval = new SafeEval();
        safeEval.setId(Integer.parseInt(id));
        List<SafeEval> safeEvalList = safeEvalService.findSafeEvalList(safeEval);
        if(safeEvalList != null && safeEvalList.size() > 0) { //只会有一条数据
            model.addAttribute("safeEval", safeEvalList.get(0));
        }
        return "sec/info/sec_info_info";
    }
}
