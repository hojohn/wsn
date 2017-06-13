package com.ai.mnt.web.collect;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ai.mnt.model.collect.WsnTempData2;
import com.ai.mnt.model.device.WsnSensor;
import com.ai.mnt.model.sensor.WsnTempData;
import com.ai.mnt.service.device.WsnSensorService;


@RequestMapping("/collect")
@Controller
public class Collection {
    @Autowired 
    WsnSensorService wsnSensorService;
    
    public static int[] database={0,0};
    public static int[] node={0,0,0,0,0,0};
    public static int[] node2={0,0};
    private dataStruct datastruct=new dataStruct();
    private Dao dao;
    @RequestMapping("/Insert")
    public String showCamreaPage(Model model,String databasename,String wareid,String nodeid,String value ) {
        datastruct.setDatabasename(databasename);
        datastruct.setNodeid(nodeid);
        datastruct.setValue(value);
        datastruct.setWareid(wareid);
        /*  dao=new DAOImpl();
        dao.updateNode(datastruct.getNodeid());
        if(datastruct.getDatabasename().trim().equals("mnt_dev")&&database[0]==1)
          dao.insert(datastruct,node);
        if(datastruct.getDatabasename().trim().equals("RFID")&&database[0]==1)
          dao.insertRFID(datastruct,node);  */
        WsnTempData2 wsnTempData = new WsnTempData2();
        wsnTempData.setWareId(wareid);
        wsnTempData.setTemperatureValue(value);
        wsnSensorService.saveTempData(wsnTempData,node,datastruct,node2);
        return "collect/collection_page";
    }  
}
