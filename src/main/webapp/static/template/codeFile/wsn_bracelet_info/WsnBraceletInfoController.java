package com.ai.mnt.web.bracelet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.model.bracelet.WsnBraceletInfo;
import com.ai.mnt.service.bracelet.WsnBraceletInfoService;

/**
 * @Title: WsnBraceletInfoController 
 * @Description: WsnBraceletInfoController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-12-7
 */

@Controller
@RequestMapping("/bracelet")
public class WsnBraceletInfoController {

    @Autowired
    WsnBraceletInfoService wsnBraceletInfoService;
    
    /**
     * 可穿戴设备信息表界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnBraceletInfoPage(Model model) {
        return "bracelet/info/bracelet_info_query";
    }
    
    /**
     * 获取可穿戴设备信息表列表
     * @param wsnBraceletInfo
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnBraceletInfoList(WsnBraceletInfo wsnBraceletInfo) {
        List<WsnBraceletInfo> wsnBraceletInfoList = wsnBraceletInfoService.findWsnBraceletInfoList(wsnBraceletInfo);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnBraceletInfoList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 可穿戴设备信息表新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnBraceletInfoAddPage(Model model) {
        return "bracelet/info/bracelet_info_add";
    }
    
    /**
     * 可穿戴设备信息表保存
     * @param wsnBraceletInfo
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnBraceletInfo(WsnBraceletInfo wsnBraceletInfo) {
        wsnBraceletInfoService.saveWsnBraceletInfo(wsnBraceletInfo);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 可穿戴设备信息表更新界面跳转
     * @param  model
     * @param  bwareId
     * @return
     */
    @RequestMapping("/info/update_page/{bwareId}")
    public String showWsnBraceletInfoUpdatePage(Model model, @PathVariable String bwareId) {
        WsnBraceletInfo wsnBraceletInfo = wsnBraceletInfoService.findWsnBraceletInfoByBwareId(Integer.parseInt(bwareId));
        model.addAttribute("wsnBraceletInfo", wsnBraceletInfo);
        return "bracelet/info/bracelet_info_update";
    }
    
    /**
     * 可穿戴设备信息表根据主键更新
     * @param wsnBraceletInfo
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnBraceletInfo(WsnBraceletInfo wsnBraceletInfo) {
        wsnBraceletInfoService.updateWsnBraceletInfoByBwareId(wsnBraceletInfo);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 可穿戴设备信息表根据主键批量删除
     * @param bwareIds
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{bwareIds}")
    @ResponseBody
    public Map<String, Object> deleteWsnBraceletInfoByBwareIds(@PathVariable String bwareIds) {
        wsnBraceletInfoService.deleteWsnBraceletInfoByBwareIds(bwareIds);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询可穿戴设备信息表详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{bwareId}/page")
    public String queryWsnBraceletInfoByBwareId(Model model, @PathVariable String bwareId) {
        WsnBraceletInfo wsnBraceletInfo = new WsnBraceletInfo();
        wsnBraceletInfo.setBwareId(Integer.parseInt(bwareId));
        List<WsnBraceletInfo> wsnBraceletInfoList = wsnBraceletInfoService.findWsnBraceletInfoList(wsnBraceletInfo);
        if(wsnBraceletInfoList != null && wsnBraceletInfoList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnBraceletInfo", wsnBraceletInfoList.get(0));
        }
        return "bracelet/info/bracelet_info_info";
    }
}
