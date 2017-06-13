package com.ai.mnt.web.employee;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ai.mnt.model.employee.WsnEmployee;
import com.ai.mnt.service.employee.WsnEmployeeService;

/**
 * @Title: WsnEmployeeController 
 * @Description: WsnEmployeeController ControllerPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-16
 */

@Controller
@RequestMapping("/employee")
public class WsnEmployeeController {

    @Autowired
    WsnEmployeeService wsnEmployeeService;
    
    /**
     * 作业人员信息界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/page")
    public String showWsnEmployeePage(Model model) {
        return "wsn_employee/info/employee_info_query";
    }
    
    /**
     * 获取作业人员信息列表
     * @param wsnEmployee
     * @return Map<String, Object>
     */
    @RequestMapping("/info/query")
    @ResponseBody
    public Map<String, Object> getWsnEmployeeList(WsnEmployee wsnEmployee) {
        List<WsnEmployee> wsnEmployeeList = wsnEmployeeService.findWsnEmployeeList(wsnEmployee);
        Map<String, Object> map = new HashMap<>();
        map.put("data", wsnEmployeeList);
        map.put("status", "1");
        return map;
    }
    
    /**
     * 作业人员信息新增界面跳转
     * @param  model
     * @return String
     */
    @RequestMapping("/info/add_page")
    public String showWsnEmployeeAddPage(Model model) {
        return "wsn_employee/info/employee_info_add";
    }
    
    /**
     * 作业人员信息保存
     * @param wsnEmployee
     * @return Map<String, Object>
     */
    @RequestMapping("/info/add")
    @ResponseBody
    public Map<String, Object> saveWsnEmployee(WsnEmployee wsnEmployee) {
        wsnEmployeeService.saveWsnEmployee(wsnEmployee);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 作业人员信息更新界面跳转
     * @param  model
     * @param  personId
     * @return
     */
    @RequestMapping("/info/update_page/{personId}")
    public String showWsnEmployeeUpdatePage(Model model, @PathVariable String personId) {
        WsnEmployee wsnEmployee = wsnEmployeeService.findWsnEmployeeByPersonId(Integer.parseInt(personId));
        model.addAttribute("wsnEmployee", wsnEmployee);
        return "wsn_employee/info/employee_info_update";
    }
    
    /**
     * 作业人员信息根据主键更新
     * @param wsnEmployee
     * @return
     */
    @RequestMapping("/info/update")
    @ResponseBody
    public Map<String, Object> updateWsnEmployee(WsnEmployee wsnEmployee) {
        wsnEmployeeService.updateWsnEmployeeByPersonId(wsnEmployee);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 作业人员信息根据主键批量删除
     * @param personIds
     * @return Map<String, Object>
     */
    @RequestMapping("/info/delete/{personIds}")
    @ResponseBody
    public Map<String, Object> deleteWsnEmployeeByPersonIds(@PathVariable String personIds) {
        wsnEmployeeService.deleteWsnEmployeeByPersonIds(personIds);
        Map<String, Object> map = new HashMap<>();
        map.put("status", "1");
        return map;
    }
    
    /**
     * 根据主键查询作业人员信息详细信息
     * @param model
     * @return
     */
    @RequestMapping("/info/{personId}/page")
    public String queryWsnEmployeeByPersonId(Model model, @PathVariable String personId) {
        WsnEmployee wsnEmployee = new WsnEmployee();
        wsnEmployee.setPersonId(Integer.parseInt(personId));
        List<WsnEmployee> wsnEmployeeList = wsnEmployeeService.findWsnEmployeeList(wsnEmployee);
        if(wsnEmployeeList != null && wsnEmployeeList.size() > 0) { //只会有一条数据
            model.addAttribute("wsnEmployee", wsnEmployeeList.get(0));
        }
        return "wsn_employee/info/employee_info_info";
    }
}
