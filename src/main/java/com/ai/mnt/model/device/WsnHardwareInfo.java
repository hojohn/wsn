package com.ai.mnt.model.device;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
/**
 * @Title: WsnHardwareInfo 
 * @Description: WsnHardwareInfo Model
 * @Author: Auto Generate.
 * @Date: 2016-10-28
 */
public class WsnHardwareInfo implements Serializable{

    private static final long serialVersionUID = 1L;

    /**硬件编号*/
    private String wareId;

    /**硬件名称*/
    private String wareName;

    /**硬件类型*/
    private Integer typeId;

    /**监控对象*/
    private String objId;
    
    private String netIp;
    private String rfidId;
    private Integer employeeId;

    public String getObjId() {
        return objId;
    }
    public void setObjId(String objId) {
        this.objId = objId;
    }
    public String getNetIp() {
        return netIp;
    }
    public void setNetIp(String netIp) {
        this.netIp = netIp;
    }
    public String getRfidId() {
        return rfidId;
    }
    public void setRfidId(String rfidId) {
        this.rfidId = rfidId;
    }
    public Integer getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }
    /**关键标志*/
    private String wareKey;

    /**硬件信息*/
    private String wareInfo;

    /**更新时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date updateTime;

    /**状态，1被占用，0未占用*/
    private String state;

    /**备注1*/
    private String remark1;

    /**备注2*/
    private String remark2;
    
    private String infoOne ;
    private String infoTwo ;
    private String infoThree ;
    private String infoFour ;
    private String infoFive ;
    private String stateTxt;
 //   private String getewayTxt;
    private String typeTxt;
    
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
    //=========================================
    private String getewaytxt ;
    private WsnGeteway wsnGeteway = new WsnGeteway();
    
    
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
    public Date getUpdateTime() {
        return updateTime;
    }
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }
    public String getState() {
        return state;
    }
    public void setState(String state) {
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
    public String getGetewaytxt() {
        return getewaytxt;
    }
    public void setGetewaytxt(String getewaytxt) {
        this.getewaytxt = getewaytxt;
    }
    public WsnGeteway getWsnGeteway() {
        return wsnGeteway;
    }
    public void setWsnGeteway(WsnGeteway wsnGeteway) {
        this.wsnGeteway = wsnGeteway;
    }
    public static long getSerialversionuid() {
        return serialVersionUID;
    }
    public String getStateTxt() {
        return stateTxt;
    }
    public void setStateTxt(String stateTxt) {
        this.stateTxt = stateTxt;
    }
    public String getTypeTxt() {
        return typeTxt;
    }
    public void setTypeTxt(String typeTxt) {
        this.typeTxt = typeTxt;
    }
   
    
   

}