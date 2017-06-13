package com.ai.mnt.model.device;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: WsnHardwareInfo 
 * @Description: WsnHardwareInfo Model
 * @Author: Auto Generate.
 * @Date: 2016-11-29
 */
public class WsnHardwareInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    /**硬件编号*/
    private String wareId;

    /**硬件名称*/
    private String wareName;

    /**硬件类型*/
    private Integer typeId;

    /**网关编号*/
    private String objId;

    /**关键标志*/
    private String wareKey;

    /**硬件信息*/
    private String wareInfo;

    /**更新时间*/
    private  updateTime;

    /**状态，1被占用，0未占用*/
    private Integer state;

    /**备注1*/
    private String remark1;

    /**备注2*/
    private String remark2;

    /**信息1*/
    private String infoOne;

    /**信息2*/
    private String infoTwo;

    /**信息3*/
    private String infoThree;

    /**信息4*/
    private String infoFour;

    /**信息5*/
    private String infoFive;

    /**ip地址*/
    private String netIp;

    /**rfid外键*/
    private Integer rfidId;

    /**员工外键*/
    private Integer employeeId;


    public String getWareId() {
        return wareId;
    }

    public void setWareId(String wareId) {
        this.wareId = wareId;
    }

    public String getWareName() {
        return wareName;
    }

    public void setWareName(String wareName) {
        this.wareName = wareName;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getWareKey() {
        return wareKey;
    }

    public void setWareKey(String wareKey) {
        this.wareKey = wareKey;
    }

    public String getWareInfo() {
        return wareInfo;
    }

    public void setWareInfo(String wareInfo) {
        this.wareInfo = wareInfo;
    }

    public  getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime( updateTime) {
        this.updateTime = updateTime;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
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

    public String getInfoOne() {
        return infoOne;
    }

    public void setInfoOne(String infoOne) {
        this.infoOne = infoOne;
    }

    public String getInfoTwo() {
        return infoTwo;
    }

    public void setInfoTwo(String infoTwo) {
        this.infoTwo = infoTwo;
    }

    public String getInfoThree() {
        return infoThree;
    }

    public void setInfoThree(String infoThree) {
        this.infoThree = infoThree;
    }

    public String getInfoFour() {
        return infoFour;
    }

    public void setInfoFour(String infoFour) {
        this.infoFour = infoFour;
    }

    public String getInfoFive() {
        return infoFive;
    }

    public void setInfoFive(String infoFive) {
        this.infoFive = infoFive;
    }

    public String getNetIp() {
        return netIp;
    }

    public void setNetIp(String netIp) {
        this.netIp = netIp;
    }

    public Integer getRfidId() {
        return rfidId;
    }

    public void setRfidId(Integer rfidId) {
        this.rfidId = rfidId;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }


}