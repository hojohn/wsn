package com.ai.mnt.model.bracelet;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Title: WsnBraceletInfo 
 * @Description: WsnBraceletInfo Model
 * @Author: Auto Generate.
 * @Date: 2016-12-7
 */
public class WsnBraceletInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    /**硬件编号*/
    private String bwareId;

    /**硬件类型*/
    private Integer typeId;

    /**rfid标签外键*/
    private Integer rfidId;

    /**员工id外键*/
    private String employeeId;

    /**更新时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    /**监控对象外键*/
    private String objId;

    /**传感器名字*/
    private String sensorName;

    /**硬件名*/
    private String wareName;

    /**硬件信息*/
    private String wareInfo;

    /**状态*/
    private String state;

    /**网关*/
    private String netIp;

    /**包含设备固定的*/
    private String infoOne;

    /**采样周期*/
    private String sampleData;

    /**阈值*/
    private String alrmData;

    /**度量单位*/
    private String metricData;

    /**备用字段1*/
    private String remark1;

    /**备用字段2*/
    private String remark2;


    public String getBwareId() {
        return bwareId;
    }

    public void setBwareId(String bwareId) {
        this.bwareId = bwareId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getRfidId() {
        return rfidId;
    }

    public void setRfidId(Integer rfidId) {
        this.rfidId = rfidId;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getSensorName() {
        return sensorName;
    }

    public void setSensorName(String sensorName) {
        this.sensorName = sensorName;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public String getWareInfo() {
        return wareInfo;
    }

    public void setWareInfo(String wareInfo) {
        this.wareInfo = wareInfo;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getNetIp() {
        return netIp;
    }

    public void setNetIp(String netIp) {
        this.netIp = netIp;
    }

    public String getInfoOne() {
        return infoOne;
    }

    public void setInfoOne(String infoOne) {
        this.infoOne = infoOne;
    }

    public String getSampleData() {
        return sampleData;
    }

    public void setSampleData(String sampleData) {
        this.sampleData = sampleData;
    }

    public String getAlrmData() {
        return alrmData;
    }

    public void setAlrmData(String alrmData) {
        this.alrmData = alrmData;
    }

    public String getMetricData() {
        return metricData;
    }

    public void setMetricData(String metricData) {
        this.metricData = metricData;
    }

    public String getRemark1() {
        return remark1;
    }

    public void setRemark1(String remark1) {
        this.remark1 = remark1;
    }

    public String getRemark2() {
        return remark2;
    }

    public void setRemark2(String remark2) {
        this.remark2 = remark2;
    }


}