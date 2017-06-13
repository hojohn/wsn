package com.ai.mnt.service.device.impl;


import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ai.mnt.common.shiro.UserRealm;
import com.ai.mnt.model.collect.WsnTempData2;
import com.ai.mnt.model.collect.WsnTray;
import com.ai.mnt.model.device.WsnHardwareInfo;
import com.ai.mnt.model.device.WsnSensor;
import com.ai.mnt.model.sensor.WsnBody;
import com.ai.mnt.model.sensor.WsnCarbondioxide;
import com.ai.mnt.model.sensor.WsnCarbonmonoxide;
import com.ai.mnt.model.sensor.WsnDrift;
import com.ai.mnt.model.sensor.WsnDust;
import com.ai.mnt.model.sensor.WsnHeart;
import com.ai.mnt.model.sensor.WsnHumidity;
import com.ai.mnt.model.sensor.WsnMethane;
import com.ai.mnt.model.sensor.WsnNoise;
import com.ai.mnt.model.sensor.WsnOxygen;
import com.ai.mnt.model.sensor.WsnPressure;
import com.ai.mnt.model.sensor.WsnSmoke;
import com.ai.mnt.model.sensor.WsnTempData;
import com.ai.mnt.model.sensor.WsnTemperature;
import com.ai.mnt.persistence.collect.WsnBodyMapper2;
import com.ai.mnt.persistence.collect.WsnDustMapper2;
import com.ai.mnt.persistence.collect.WsnHeartMapper2;
import com.ai.mnt.persistence.collect.WsnNoiseMapper2;
import com.ai.mnt.persistence.collect.WsnTrayMapper;
import com.ai.mnt.persistence.device.WsnHardwareInfoMapper;
import com.ai.mnt.persistence.device.WsnSensorMapper;
import com.ai.mnt.persistence.sensor.WsnBodyMapper;
import com.ai.mnt.persistence.sensor.WsnCarbondioxideMapper;
import com.ai.mnt.persistence.sensor.WsnCarbonmonoxideMapper;
import com.ai.mnt.persistence.sensor.WsnDriftMapper;
import com.ai.mnt.persistence.sensor.WsnDustMapper;
import com.ai.mnt.persistence.sensor.WsnHeartMapper;
import com.ai.mnt.persistence.sensor.WsnHumidityMapper;
import com.ai.mnt.persistence.sensor.WsnMethaneMapper;
import com.ai.mnt.persistence.sensor.WsnNoiseMapper;
import com.ai.mnt.persistence.sensor.WsnOxygenMapper;
import com.ai.mnt.persistence.sensor.WsnPressureMapper;
import com.ai.mnt.persistence.sensor.WsnSmokeMapper;
import com.ai.mnt.persistence.sensor.WsnTempDataMapper;
import com.ai.mnt.persistence.sensor.WsnTemperatureMapper;
import com.ai.mnt.service.device.WsnSensorService;
import com.ai.mnt.web.collect.dataStruct;
import com.ai.mnt.web.collect.read_CH4_Consentration;
import com.ai.mnt.web.collect.read_CO_Consentration;
import com.b510.tray.NowTime;

/**
 * @Title: WsnSensorServiceImpl 
 * @Description: WsnSensorServiceImpl ServiceImplPackage
 * @Author: Auto Generate.
 * @Date: 2016-10-30
 */
@Service
public class WsnSensorServiceImpl implements WsnSensorService{

    @Autowired
    WsnSensorMapper wsnSensorMapper;
    
    @Autowired
    UserRealm userRealm;
    
    @Autowired
    WsnCarbondioxideMapper wsnCarbondioxideMapper;
    @Autowired
    com.ai.mnt.persistence.collect.WsnCarbondioxideMapper2 WsnCarbondioxideMapper2;
    
    @Autowired
    WsnCarbonmonoxideMapper wsnCarbonmonoxideMapper;
    @Autowired
    com.ai.mnt.persistence.collect.WsnCarbonmonoxideMapper2 WsnCarbonmonoxideMapper2;
    
    @Autowired
    WsnDriftMapper wsnDriftMapper;
    @Autowired
    com.ai.mnt.persistence.collect.WsnDriftMapper2 WsnDriftMapper2;
    
    
    @Autowired
    WsnDustMapper wsnDustMapper;
    
    @Autowired 
    com.ai.mnt.persistence.collect.WsnDustMapper2 wsnDustMapper2; 
    
    @Autowired
    WsnHumidityMapper wsnHumidityMapper;
    @Autowired
    com.ai.mnt.persistence.collect.WsnHumidityMapper2 WsnHumidityMapper2;
    
    @Autowired
    WsnMethaneMapper wsnMethaneMapper;
    @Autowired
    com.ai.mnt.persistence.collect.WsnMethaneMapper2 WsnMethaneMapper2;
    
    @Autowired
    WsnOxygenMapper wsnOxygenMapper;
    @Autowired
    com.ai.mnt.persistence.collect.WsnOxygenMapper2 WsnOxygenMapper2;
    
    @Autowired
    WsnPressureMapper wsnPressureMapper;
    @Autowired
    com.ai.mnt.persistence.collect.WsnPressureMapper2 WsnPressureMapper2;
    
    @Autowired
    WsnSmokeMapper wsnSmokeMapper;
    @Autowired
    com.ai.mnt.persistence.collect.WsnSmokeMapper2 WsnSmokeMapper2;
    
    @Autowired
    WsnTemperatureMapper wsnTemperatureMapper;
    @Autowired
    com.ai.mnt.persistence.collect.WsnTemperatureMapper2 WsnTemperatureMapper2;
    
    @Autowired
    WsnTempDataMapper wsnTempDataMapper;
    @Autowired
    com.ai.mnt.persistence.collect.WsnTempDataMapper2 wsnTempDataMapper2;
    
    @Autowired
    WsnNoiseMapper wsnNoiseMapper;
    @Autowired
    com.ai.mnt.persistence.collect.WsnNoiseMapper2 WsnNoiseMapper2;
    
    @Autowired
    WsnHeartMapper wsnHeartMapper;
    @Autowired
    com.ai.mnt.persistence.collect.WsnHeartMapper2 WsnHeartMapper2;
    
    @Autowired
    WsnBodyMapper wsnBodyMapper;
    @Autowired
    com.ai.mnt.persistence.collect.WsnBodyMapper2 WsnBodyMapper2;
    
    @Autowired
    WsnHardwareInfoMapper wsnHardwareInfoMapper;
    
    @Autowired
    WsnTrayMapper wsnTrayMapper;
    
    @Override
    public List<WsnTemperature> findWsnSensorDataList(WsnSensor wsnSensor) {
        String wareId = wsnSensor.getSensor();
        Date bDate = wsnSensor.getBeginDate1();
        Date eDate = wsnSensor.getEndDate1();
        String ss = wsnSensor.getSensor().substring(4, 6);
        
        WsnHardwareInfo wsnHardwareInfo = new WsnHardwareInfo();
        wsnHardwareInfo = wsnHardwareInfoMapper.findByPrimary(wareId);
        
        if (ss.equals("CO")) {
            List<WsnCarbonmonoxide> coList= wsnCarbonmonoxideMapper.findList(wareId,bDate,eDate);
            List<WsnTemperature>senList = new ArrayList<WsnTemperature>();
            for (WsnCarbonmonoxide w : coList) {
               WsnTemperature sensorData = new WsnTemperature();
               sensorData.setId(w.getId());
               sensorData.setObjId(w.getObjId());
               sensorData.setRate(wsnHardwareInfo.getRemark1());
               sensorData.setState(w.getState());
               sensorData.setCreateTime(w.getCreateTime());
               sensorData.setTemperatureValue(w.getCarbonmonoxideValue());
               sensorData.setWareId(w.getWareId());
               
               senList.add(sensorData);
            }
            
            return senList;
        }else if (ss.equals("EY")) {
            List<WsnTemperature>senList = new ArrayList<WsnTemperature>();
            List<WsnCarbondioxide> erList= wsnCarbondioxideMapper.findList(wareId,bDate,eDate);
            for (WsnCarbondioxide w : erList) {
                WsnTemperature sensorData = new WsnTemperature();
                sensorData.setId(w.getId());
                sensorData.setObjId(w.getObjId());
                sensorData.setRate(wsnHardwareInfo.getRemark1());
                sensorData.setState(w.getState());
                sensorData.setCreateTime(w.getCreateTime());
                sensorData.setTemperatureValue(w.getCarbondioxideValue());
                sensorData.setWareId(w.getWareId());
                
                senList.add(sensorData);
             }
            
            return senList; 
        }else if (ss.equals("WD")) {
            List<WsnTemperature> wdList= wsnTemperatureMapper.findList1(wareId,bDate,eDate);
            return wdList; 
         }else if (ss.equals("SD")) {
             List<WsnTemperature>senList = new ArrayList<WsnTemperature>();
             List<WsnHumidity> sdList= wsnHumidityMapper.findList(wareId,bDate,eDate);
             for (WsnHumidity w : sdList) {
                 WsnTemperature sensorData = new WsnTemperature();
                 sensorData.setId(w.getId());
                 sensorData.setObjId(w.getObjId());
                 sensorData.setRate(wsnHardwareInfo.getRemark1());
                 sensorData.setState(w.getState());
                 sensorData.setCreateTime(w.getCreateTime());
                 sensorData.setTemperatureValue(w.getHumidityValue());
                 sensorData.setWareId(w.getWareId());
                 
                 senList.add(sensorData);
              }
             return senList; 
         }else if (ss.equals("YL")) {
             List<WsnTemperature>senList = new ArrayList<WsnTemperature>();
             List<WsnPressure> ylList= wsnPressureMapper.findList(wareId,bDate,eDate);
             for (WsnPressure w : ylList) {
                 WsnTemperature sensorData = new WsnTemperature();
                 sensorData.setId(w.getId());
                 sensorData.setObjId(w.getObjId());
                 sensorData.setRate(wsnHardwareInfo.getRemark1());
                 sensorData.setState(w.getState());
                 sensorData.setCreateTime(w.getCreateTime());
                 sensorData.setTemperatureValue(w.getPressureValue());
                 sensorData.setWareId(w.getWareId());
                 
                 senList.add(sensorData);
              }
             return senList; 
         }else if (ss.equals("YQ")) {
             List<WsnTemperature>senList = new ArrayList<WsnTemperature>();
             List<WsnOxygen> yqList= wsnOxygenMapper.findList(wareId,bDate,eDate);
             for (WsnOxygen w : yqList) {
                 WsnTemperature sensorData = new WsnTemperature();
                 sensorData.setId(w.getId());
                 sensorData.setObjId(w.getObjId());
                 sensorData.setRate(wsnHardwareInfo.getRemark1());
                 sensorData.setState(w.getState());
                 sensorData.setCreateTime(w.getCreateTime());
                 sensorData.setTemperatureValue(w.getOxygenValue());
                 sensorData.setWareId(w.getWareId());
                 
                 senList.add(sensorData);
              }
             return senList; 
         }else if (ss.equals("JW")) {
             List<WsnTemperature>senList = new ArrayList<WsnTemperature>();
             List<WsnMethane> jwList= wsnMethaneMapper.findList(wareId,bDate,eDate);
             for (WsnMethane w : jwList) {
                 WsnTemperature sensorData = new WsnTemperature();
                 sensorData.setId(w.getId());
                 sensorData.setObjId(w.getObjId());
                 sensorData.setRate(wsnHardwareInfo.getRemark1());
                 sensorData.setState(w.getState());
                 sensorData.setCreateTime(w.getCreateTime());
                 sensorData.setTemperatureValue(w.getMethaneValue());
                 sensorData.setWareId(w.getWareId());
                 
                 senList.add(sensorData);
              }
             return senList; 
         }else if (ss.equals("YW")) {
             List<WsnTemperature>senList = new ArrayList<WsnTemperature>();
             List<WsnSmoke> ywList= wsnSmokeMapper.findList(wareId,bDate,eDate);
             for (WsnSmoke w : ywList) {
                 WsnTemperature sensorData = new WsnTemperature();
                 sensorData.setId(w.getId());
                 sensorData.setObjId(w.getObjId());
                 sensorData.setRate(wsnHardwareInfo.getRemark1());
                 sensorData.setState(w.getState());
                 sensorData.setCreateTime(w.getCreateTime());
                 sensorData.setTemperatureValue(w.getSmokeValue());
                 sensorData.setWareId(w.getWareId());
                 senList.add(sensorData);
              }
             return senList; 
         }else if (ss.equals("FC")) {
             List<WsnTemperature>senList = new ArrayList<WsnTemperature>();
             List<WsnDust> fcList= wsnDustMapper.findList(wareId,bDate,eDate);
             for (WsnDust w : fcList) {
                 WsnTemperature sensorData = new WsnTemperature();
                 sensorData.setId(w.getId());
                 sensorData.setObjId(w.getObjId());
                 sensorData.setRate(wsnHardwareInfo.getRemark1());
                 sensorData.setState(w.getState());
                 sensorData.setCreateTime(w.getCreateTime());
                 sensorData.setTemperatureValue(w.getDustValue());
                 sensorData.setWareId(w.getWareId());
                 
                 senList.add(sensorData);
              }
             return senList; 
         }else if (ss.equals("WY")) {
             List<WsnTemperature>senList = new ArrayList<WsnTemperature>();
             List<WsnDrift> wyList= wsnDriftMapper.findList(wareId,bDate,eDate);
             
             
             for (WsnDrift w : wyList) {
                 WsnTemperature sensorData = new WsnTemperature();
                 sensorData.setId(w.getId());
                 sensorData.setObjId(w.getObjId());
                 sensorData.setRate(wsnHardwareInfo.getRemark1());
                 sensorData.setState(w.getState());
                 sensorData.setCreateTime(w.getCreateTime());
                 sensorData.setTemperatureValue(w.getDriftValue());
                 sensorData.setWareId(w.getWareId());
                 senList.add(sensorData );
                 //senList.add(sensorData);
              }
             return senList; 
         }else if (ss.equals("ZS")) {
             List<WsnTemperature>senList = new ArrayList<WsnTemperature>();
             List<WsnNoise> zsList= wsnNoiseMapper.findList(wareId,bDate,eDate);
             for (WsnNoise w : zsList) {
                 WsnTemperature sensorData = new WsnTemperature();
                 sensorData.setId(w.getId());
                 sensorData.setObjId(w.getObjId());
                 sensorData.setRate(wsnHardwareInfo.getRemark1());
                 sensorData.setState(w.getState());
                 sensorData.setCreateTime(w.getCreateTime());
                 sensorData.setTemperatureValue(w.getNoiseValue());
                 sensorData.setWareId(w.getWareId());
                 senList.add(sensorData );
                 //senList.add(sensorData);
              }
             return senList; 
         }else if (ss.equals("XT")) {
             List<WsnTemperature>senList = new ArrayList<WsnTemperature>();
             List<WsnHeart> zsList= wsnHeartMapper.findList(wareId,bDate,eDate);
             for (WsnHeart w : zsList) {
                 WsnTemperature sensorData = new WsnTemperature();
                 sensorData.setId(w.getId());
                 sensorData.setObjId(w.getObjId());
                 sensorData.setRate(wsnHardwareInfo.getRemark1());
                 sensorData.setState(w.getState());
                 sensorData.setCreateTime(w.getCreateTime());
                 sensorData.setTemperatureValue(w.getHeartValue());
                 sensorData.setWareId(w.getWareId());
                 senList.add(sensorData );
                 //senList.add(sensorData);
              }
             return senList; 
         }else if (ss.equals("TW")) {
             List<WsnTemperature>senList = new ArrayList<WsnTemperature>();
             List<WsnBody> twList= wsnBodyMapper.findList(wareId,bDate,eDate);
             for (WsnBody w : twList) {
                 WsnTemperature sensorData = new WsnTemperature();
                 sensorData.setId(w.getId());
                 sensorData.setObjId(w.getObjId());
                 sensorData.setRate(wsnHardwareInfo.getRemark1());
                 sensorData.setState(w.getState());
                 sensorData.setCreateTime(w.getCreateTime());
                 sensorData.setTemperatureValue(w.getBodyValue());
                 sensorData.setWareId(w.getWareId());
                 senList.add(sensorData );
                 //senList.add(sensorData);
              }
             return senList; 
         }
         
         else {
            return null;
        }
    }
    
    /**
     * 获取所有职业卫生传感器列表
     * @return List<WsnSensor>
     */
    @Override
    public List<WsnSensor> findAllWsnSensor() {
        List<WsnSensor> wsnSensorList = wsnSensorMapper.findAll();
        //cvtContentList(wsnSensorList);
        return wsnSensorList;
    }

    /**
     * 获取职业卫生传感器列表
     * @param device
     * @return List<WsnSensor>
     */
    @Override
    public List<WsnSensor> findWsnSensorList(WsnSensor wsnSensor) {
        List<WsnSensor> wsnSensorList = wsnSensorMapper.findList(wsnSensor);
        //cvtContentList(wsnSensorList);
        return wsnSensorList;
    }

    /**
     * 通过主键ID获取职业卫生传感器
     * @param id Primary key
     * @return WsnSensor
     */
    @Override
    public WsnSensor findWsnSensorById(Integer id) {
        WsnSensor wsnSensor = wsnSensorMapper.findByPrimaryKey(id);
        return wsnSensor;
    }

   
   

    @Override
    public Float findDataAvg(WsnSensor wsnSensor) {
        String wareId = wsnSensor.getSensor();
        String bDate = wsnSensor.getBeginDate();
        String eDate = wsnSensor.getEndDate();
        String ss = wsnSensor.getSensor().substring(4, 6);
        
        if (ss.equals("CO")) {
            Float yFloat= wsnCarbonmonoxideMapper.calAvg(wareId,bDate,eDate);
            return yFloat;
        }else if (ss.equals("EY")) {
            Float yFloat= wsnCarbondioxideMapper.calAvg(wareId,bDate,eDate);
            return yFloat;
        }else if (ss.equals("WD")) {
            Float yFloat= wsnTemperatureMapper.calAvg(wareId,bDate,eDate);
            return yFloat; 
         }else if (ss.equals("SD")) {
             Float yFloat= wsnHumidityMapper.calAvg(wareId,bDate,eDate);
             return yFloat; 
         }else if (ss.equals("YL")) {
             Float yFloat= wsnPressureMapper.calAvg(wareId,bDate,eDate);
             return yFloat;
         }else if (ss.equals("YQ")) {
             Float yFloat= wsnOxygenMapper.calAvg(wareId,bDate,eDate);
             return yFloat;
         }else if (ss.equals("JW")) {
             Float yFloat= wsnMethaneMapper.calAvg(wareId,bDate,eDate);
             return yFloat;
         }else if (ss.equals("YW")) {
             Float yFloat= wsnSmokeMapper.calAvg(wareId,bDate,eDate);
             return yFloat;
         }else if (ss.equals("FC")) {
             Float yFloat= wsnDustMapper.calAvg(wareId,bDate,eDate);
             return yFloat;
         }else if (ss.equals("WY")) {
             Float yFloat= wsnDriftMapper.calAvg(wareId,bDate,eDate);
             return yFloat;
         }else if (ss.equals("ZS")) {
             Float yFloat= wsnNoiseMapper.calAvg(wareId,bDate,eDate);
             return yFloat;
         }else if (ss.equals("TW")) {
             Float yFloat= wsnBodyMapper.calAvg(wareId,bDate,eDate);
             return yFloat;
         }else if (ss.equals("XT")) {
             Float yFloat= wsnHeartMapper.calAvg(wareId,bDate,eDate);
             return yFloat;
         }
         else {
            return null;
        }
        
        //Float yFloat = wsnSensorMapper.calAvg(wsnSensor) ;
        //return yFloat;
    }

    @Override
    public String findDate(String wareId) {
        String ss = wareId.substring(4, 6);
        if (ss.equals("WD")) {
            String newData = wsnTemperatureMapper.findNew(wareId);
            return newData;
        }else if (ss.equals("SD")) {
            String newData = wsnHumidityMapper.findNew(wareId);
            return newData;
        }else if (ss.equals("YL")) {
            String newData = wsnPressureMapper.findNew(wareId);
            return newData;
        }else if (ss.equals("CO")) {
            String newData = wsnCarbonmonoxideMapper.findNew(wareId);
            return newData;
        }else if (ss.equals("EY")) {
            String newData = wsnCarbondioxideMapper.findNew(wareId);
            return newData;
        }else if (ss.equals("YQ")) {
            String newData = wsnOxygenMapper.findNew(wareId);
            return newData;
        }else if (ss.equals("JW")) {
            String newData = wsnMethaneMapper.findNew(wareId);
            return newData;
        }else if (ss.equals("YW")) {
            String newData = wsnSmokeMapper.findNew(wareId);
            return newData;
        }else if (ss.equals("FC")) {
            String newData = wsnDustMapper.findNew(wareId);
            return newData;
        }else if (ss.equals("WY")) {
            String newData = wsnDriftMapper.findNew(wareId);
            return newData;
        }else if (ss.equals("ZS")) {
            String newData = wsnNoiseMapper.findNew(wareId);
            return newData;
        }else if (ss.equals("TW")) {
            String newData = wsnBodyMapper.findNew(wareId);
            return newData;
        }else if (ss.equals("XT")) {
            String newData = wsnHeartMapper.findNew(wareId);
            return newData;
        }
        
        else {
            return "";
        }
       // return null;
    }

    @Override
    public List<WsnTempData> findAllllll() {
        List<WsnTempData> sssList = wsnTempDataMapper.findAll();
        return sssList;
    }

    @Override
    public WsnTempData findWsnSensorByWareId(String wareId) {
        WsnTempData wsnTempData = wsnTempDataMapper.findByWareId(wareId);
        return wsnTempData;
    }

    @Override
    public String findNewDataById(String wareId) {
        String newData;
        try {
             newData = wsnTempDataMapper.findByWareId(wareId).getTemperatureValue();
           
        } catch (Exception e) {
            newData = "";
        }
        
        return newData;
        
    }

    @Override
    public void saveTempData(WsnTempData2 wsnTempData,int[] Node,dataStruct dataStruct,int[] Node2) {
        read_CH4_Consentration CH4=new read_CH4_Consentration();
        read_CO_Consentration CO=new read_CO_Consentration();
        NowTime time=new NowTime();
        WsnTray wsnTray=new WsnTray();
        wsnTray.setWareId(dataStruct.getNodeid());
        wsnTray.setWareTime(time.getTime());
        wsnTempData.setCreateTime(time.getTime());
        String[] ware=dataStruct.getWareid().split("_");
        String obj=ware[1].substring(0, 2);
        int node=Integer.valueOf(dataStruct.getNodeid().trim().split("_")[2]);
        wsnTrayMapper.updateByPrimaryKey(wsnTray);
        if(obj.trim().equals("FC")&&Node2[node-1]==1){//粉尘
        com.ai.mnt.model.collect.WsnDust2 wsnDust = new com.ai.mnt.model.collect.WsnDust2();
        wsnDust.setWareId(wsnTempData.getWareId());
        wsnDust.setDustValue(wsnTempData.getTemperatureValue());
        wsnDust.setCreateTime(time.getTime());
        wsnDust.setState(0);
        wsnDustMapper2.save(wsnDust);
        wsnTempDataMapper2.updateByPrimaryKey(wsnTempData);
        }
        if(obj.trim().equals("SD")&& Node[node-1]==1){//湿度
            com.ai.mnt.model.collect.WsnHumidity2 wsnHumidity=new com.ai.mnt.model.collect.WsnHumidity2();
            wsnHumidity.setWareId(wsnTempData.getWareId());
            wsnHumidity.setHumidityValue(wsnTempData.getTemperatureValue());
            wsnHumidity.setCreateTime(time.getTime());
            wsnHumidity.setState(0);
            WsnHumidityMapper2.save(wsnHumidity);
            wsnTempDataMapper2.updateByPrimaryKey(wsnTempData);
        }
        if(obj.trim().equals("WD")&& Node[node-1]==1){//温度
            com.ai.mnt.model.collect.WsnTemperature2 wsnTemperature=new com.ai.mnt.model.collect.WsnTemperature2();
            wsnTemperature.setWareId(wsnTempData.getWareId());
            wsnTemperature.setTemperatureValue(wsnTempData.getTemperatureValue());
            wsnTemperature.setCreateTime(time.getTime());
            wsnTemperature.setState(0);
            WsnTemperatureMapper2.save(wsnTemperature);
            wsnTempDataMapper2.updateByPrimaryKey(wsnTempData);
        }
        if(obj.trim().equals("YQ")&& Node[node-1]==1){//氧气
            com.ai.mnt.model.collect.WsnOxygen2 wsnOxygen=new com.ai.mnt.model.collect.WsnOxygen2();
            wsnOxygen.setWareId(wsnTempData.getWareId());
            wsnOxygen.setOxygenValue(wsnTempData.getTemperatureValue());
            wsnOxygen.setCreateTime(time.getTime());
            wsnOxygen.setState(0);
            WsnOxygenMapper2.save(wsnOxygen);
            wsnTempDataMapper2.updateByPrimaryKey(wsnTempData);
        }
        if(obj.trim().equals("EY")&& Node[node-1]==1){//二氧化碳
            com.ai.mnt.model.collect.WsnCarbondioxide2 wsnCarbondioxide=new com.ai.mnt.model.collect.WsnCarbondioxide2();
            wsnCarbondioxide.setWareId(wsnTempData.getWareId());
            wsnCarbondioxide.setCarbondioxideValue(wsnTempData.getTemperatureValue());
            wsnCarbondioxide.setCreateTime(time.getTime());
            wsnCarbondioxide.setState(0);
            WsnCarbondioxideMapper2.save(wsnCarbondioxide);
            wsnTempDataMapper2.updateByPrimaryKey(wsnTempData);
        }
        if(obj.trim().equals("CO")&& Node[node-1]==1){//一氧化碳
            com.ai.mnt.model.collect.WsnCarbonmonoxide2 wsnCarbonmonoxide=new com.ai.mnt.model.collect.WsnCarbonmonoxide2();
            wsnCarbonmonoxide.setWareId(wsnTempData.getWareId());
            wsnCarbonmonoxide.setCarbonmonoxideValue(wsnTempData.getTemperatureValue());
            wsnCarbonmonoxide.setCreateTime(time.getTime());
            wsnCarbonmonoxide.setState(0);
            WsnCarbonmonoxideMapper2.save(wsnCarbonmonoxide);
            wsnTempDataMapper2.updateByPrimaryKey(wsnTempData);
        }
        if(obj.trim().equals("WY")&& Node[node-1]==1){//位移
            com.ai.mnt.model.collect.WsnDrift2 wsnDrift=new com.ai.mnt.model.collect.WsnDrift2();
            wsnDrift.setWareId(wsnTempData.getWareId());
            wsnDrift.setDriftValue(wsnTempData.getTemperatureValue());
            wsnDrift.setCreateTime(time.getTime());
            wsnDrift.setState(0);
            WsnDriftMapper2.save(wsnDrift);
            wsnTempDataMapper2.updateByPrimaryKey(wsnTempData);
        }
        if(obj.trim().equals("JW")&& Node[node-1]==1){//甲烷
            com.ai.mnt.model.collect.WsnMethane2 wsnMethane=new com.ai.mnt.model.collect.WsnMethane2();
            wsnMethane.setWareId(wsnTempData.getWareId());
            wsnMethane.setMethaneValue(wsnTempData.getTemperatureValue());
            wsnMethane.setCreateTime(time.getTime());
            wsnMethane.setState(0);
            WsnMethaneMapper2.save(wsnMethane);
            wsnTempDataMapper2.updateByPrimaryKey(wsnTempData);
        }
        if(obj.trim().equals("YL")&& Node[node-1]==1){//压力
            com.ai.mnt.model.collect.WsnPressure2 wsnPressure=new com.ai.mnt.model.collect.WsnPressure2();
            wsnPressure.setWareId(wsnTempData.getWareId());
            wsnPressure.setPressureValue(wsnTempData.getTemperatureValue());
            wsnPressure.setCreateTime(time.getTime());
            wsnPressure.setState(0);
            WsnPressureMapper2.save(wsnPressure);
            wsnTempDataMapper2.updateByPrimaryKey(wsnTempData);
        }
        if(obj.trim().equals("YW")&& Node[node-1]==1){//烟雾
            com.ai.mnt.model.collect.WsnSmoke2 wsnSmoke=new com.ai.mnt.model.collect.WsnSmoke2();
            wsnSmoke.setWareId(wsnTempData.getWareId());
            wsnSmoke.setSmokeValue(wsnTempData.getTemperatureValue());
            wsnSmoke.setCreateTime(time.getTime());
            wsnSmoke.setState(0);
            WsnSmokeMapper2.save(wsnSmoke);
            wsnTempDataMapper2.updateByPrimaryKey(wsnTempData);
        }
        
        if(obj.trim().equals("XT")&&Node2[node-1]==1){//xintiao
            com.ai.mnt.model.collect.WsnHeart2 wsnHeart=new com.ai.mnt.model.collect.WsnHeart2();
            wsnHeart.setWareId(wsnTempData.getWareId());
            wsnHeart.setHeartValue(wsnTempData.getTemperatureValue());
            wsnHeart.setCreateTime(time.getTime());
            wsnHeart.setState(0);
            WsnHeartMapper2.save(wsnHeart);
            wsnTempDataMapper2.updateByPrimaryKey(wsnTempData);
            
        }
        if(obj.trim().equals("TW")&&Node2[node-1]==1){
            com.ai.mnt.model.collect.WsnBody2 wsnBody=new com.ai.mnt.model.collect.WsnBody2();
            wsnBody.setWareId(wsnTempData.getWareId());
            wsnBody.setBodyValue(wsnTempData.getTemperatureValue());
            wsnBody.setCreateTime(time.getTime());
            wsnBody.setState(0);
            WsnBodyMapper2.save(wsnBody);
            wsnTempDataMapper2.updateByPrimaryKey(wsnTempData);
            
        }
        if(obj.trim().equals("ZS")&&Node2[node-1]==1){
            com.ai.mnt.model.collect.WsnNoise2 wsnNoise=new com.ai.mnt.model.collect.WsnNoise2();
            wsnNoise.setWareId(wsnTempData.getWareId());
            wsnNoise.setNoiseValue(wsnTempData.getTemperatureValue());
            wsnNoise.setCreateTime(time.getTime());
            wsnNoise.setState(0);
            WsnNoiseMapper2.save(wsnNoise);
            wsnTempDataMapper2.updateByPrimaryKey(wsnTempData);
        }
    }

   
    
}

