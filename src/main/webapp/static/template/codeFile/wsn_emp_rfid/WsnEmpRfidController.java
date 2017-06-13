package com.ai.mnt.web.device;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.model.device.WsnEmpRfid;
import com.ai.mnt.service.device.WsnEmpRfidService;

/**
 * @Title: WsnEmpRfidController 
 * @Description: WsnEmpRfidController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-20
 */

@Controller
@RequestMapping("/device")
public class WsnEmpRfidController {

    @Autowired
    WsnEmpRfidService wsnEmpRfidService;
    
    /**
     * 标签人员关联界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/rfid/page")
    public String showWsnEmpRfidPage(Model model) {
        return "device/rfid/device_rfid_query";
    }
    
    /**
     * 获取标签人员关联列表
     * @param wsnEmpRfid
     * @return Map<String, Object>
     */
    @RequestMapping("/rfid/query")
    @ResponseBody
    public Map<String, Object> getWsnEmpRfidList(WsnEmpRfid wsnEmpRfid) {
        List<WsnEmpRfid> wsnEmpRfidList = wsnEmpRfidService.findWsnEmpRfidList(wsnEmpRfid);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnEmpRfidList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 标签人员关联新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/rfid/add_page")
    public String showWsnEmpRfidAddPage(Model model) {
        return "device/rfid/device_rfid_add";
    }
    
    /**
     * 标签人员关联保存
     * @param wsnEmpRfid
     * @return Map<String, Object>
     */
    @RequestMapping("/rfid/add")
    @ResponseBody
    public Map<String, Object> saveWsnEmpRfid(WsnEmpRfid wsnEmpRfid) {
        wsnEmpRfidService.saveWsnEmpRfid(wsnEmpRfid);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 标签人员关联更新界面跳转
     * @param  model
     * @param  rfEmpId
     * @return
     */
    @RequestMapping("/rfid/update_page/{rfEmpId}")
    public String showWsnEmpRfidUpdatePage(Model model, @PathVariable String rfEmpId) {
        WsnEmpRfid wsnEmpRfid = wsnEmpRfidService.findWsnEmpRfidByRfEmpId(Integer.parseInt(rfEmpId));
        model.addAttribute("wsnEmpRfid", wsnEmpRfid);
        return "device/rfid/device_rfid_update";
    }
    
    /**
     * 标签人员关联根据主键更新
     * @param wsnEmpRfid
     * @return
     */
    @RequestMapping("/rfid/update")
    @ResponseBody
    public Map<String, Object> updateWsnEmpRfid(WsnEmpRfid wsnEmpRfid) {
        wsnEmpRfidService.updateWsnEmpRfidByRfEmpId(wsnEmpRfid);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 标签人员关联根据主键批量删除
     * @param rfEmpIds
     * @return Map<String, Object>
     */
    @RequestMapping("/rfid/delete/{rfEmpIds}")
    @ResponseBody
    public Map<String, Object> deleteWsnEmpRfidByRfEmpIds(@PathVariable String rfEmpIds) {
        wsnEmpRfidService.deleteWsnEmpRfidByRfEmpIds(rfEmpIds);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询标签人员关联详细信息
     * @param model
     * @return
     */
    @RequestMapping("/rfid/{rfEmpId}/page")
    public String queryWsnEmpRfidByRfEmpId(Model model, @PathVariable String rfEmpId) {
        WsnEmpRfid wsnEmpRfid = new WsnEmpRfid();
        wsnEmpRfid.setRfEmpId(Integer.parseInt(rfEmpId));
        List<WsnEmpRfid> wsnEmpRfidList = wsnEmpRfidService.findWsnEmpRfidList(wsnEmpRfid);
        if(wsnEmpRfidList != null && wsnEmpRfidList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnEmpRfid", wsnEmpRfidList.get(0));
        }
        return "device/rfid/device_rfid_info";
    }
}
