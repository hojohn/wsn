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

import com.ai.mnt.model.sec.Fxdjpgzbtx;
import com.ai.mnt.service.sec.FxdjpgzbtxService;

/**
 * @Title: FxdjpgzbtxController 
 * @Description: FxdjpgzbtxController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2017-5-16
 */

@Controller
@RequestMapping("/sec")
public class FxdjpgzbtxController {

    @Autowired
    FxdjpgzbtxService fxdjpgzbtxService;
    
    /**
     * 危险物料风险度表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showFxdjpgzbtxPage(Model model) {
        return "sec/info/sec_info_query";
    }
    
    /**
     * 获取危险物料风险度表列表
     * @param fxdjpgzbtx
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getFxdjpgzbtxList(Fxdjpgzbtx fxdjpgzbtx) {
        List<Fxdjpgzbtx> fxdjpgzbtxList = fxdjpgzbtxService.findFxdjpgzbtxList(fxdjpgzbtx);
        Map<String, Object> map = new HashMap<>();
        map.put("data", fxdjpgzbtxList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 危险物料风险度表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showFxdjpgzbtxAddPage(Model model) {
        return "sec/info/sec_info_add";
    }
    
    /**
     * 危险物料风险度表保存
     * @param fxdjpgzbtx
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveFxdjpgzbtx(Fxdjpgzbtx fxdjpgzbtx) {
        fxdjpgzbtxService.saveFxdjpgzbtx(fxdjpgzbtx);
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
    public String showFxdjpgzbtxUpdatePage(Model model, @PathVariable String id) {
        Fxdjpgzbtx fxdjpgzbtx = fxdjpgzbtxService.findFxdjpgzbtxById(Integer.parseInt(id));
        model.addAttribute("fxdjpgzbtx", fxdjpgzbtx);
        return "sec/info/sec_info_update";
    }
    
    /**
     * 危险物料风险度表根据主键更新
     * @param fxdjpgzbtx
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateFxdjpgzbtx(Fxdjpgzbtx fxdjpgzbtx) {
        fxdjpgzbtxService.updateFxdjpgzbtxById(fxdjpgzbtx);
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
    public Map<String, Object> deleteFxdjpgzbtxByIds(@PathVariable String ids) {
        fxdjpgzbtxService.deleteFxdjpgzbtxByIds(ids);
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
    public String queryFxdjpgzbtxById(Model model, @PathVariable String id) {
        Fxdjpgzbtx fxdjpgzbtx = new Fxdjpgzbtx();
        fxdjpgzbtx.setId(Integer.parseInt(id));
        List<Fxdjpgzbtx> fxdjpgzbtxList = fxdjpgzbtxService.findFxdjpgzbtxList(fxdjpgzbtx);
        if(fxdjpgzbtxList != null && fxdjpgzbtxList.size() > 0) { //只会有一条数据
            model.addAttribute("fxdjpgzbtx", fxdjpgzbtxList.get(0));
        }
        return "sec/info/sec_info_info";
    }
}
