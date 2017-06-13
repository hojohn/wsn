package com.ai.mnt.model.device;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: WsnMonitorObj 
 * @Description: WsnMonitorObj Model
 * @Author: Auto Generate.
 * @Date: 2016-10-27
 */
public class WsnMonitorObj implements Serializable{

    private static final long serialVersionUID = 1L;

    /**监控对象ID*/
    private String monitorObjId;

    /**监控对象名*/
    private String monitorObjName;

    /**监控对象位置*/
    private String monitorObjPlace;

    /**监控对象内容*/
    private String monitorObjContent;

    /**备注*/
    private String remark;

    /**修改人*/
    private String modifier;

    /**修改时间*/
    private Date modifyDate;

    private String rfidId;
    //info1
    private String info1 ;
    public String getMonitorObjId() {
        return monitorObjId;
    }

    public void setMonitorObjId(String monitorObjId) {
        this.monitorObjId = monitorObjId;
    }

    public String getMonitorObjName() {
        return monitorObjName;
    }

    public void setMonitorObjName(String monitorObjName) {
        this.monitorObjName = monitorObjName;
    }

    public String getMonitorObjPlace() {
        return monitorObjPlace;
    }

    public void setMonitorObjPlace(String monitorObjPlace) {
        this.monitorObjPlace = monitorObjPlace;
    }

    public String getMonitorObjContent() {
        return monitorObjContent;
    }

    public void setMonitorObjContent(String monitorObjContent) {
        this.monitorObjContent = monitorObjContent;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getModifier() {
        return modifier;
    }

    public void setModifier(String modifier) {
        this.modifier = modifier;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getInfo1() {
        return info1;
    }

    public void setInfo1(String info1) {
        this.info1 = info1;
    }

    public String getRfidId() {
        return rfidId;
    }

    public void setRfidId(String rfidId) {
        this.rfidId = rfidId;
    }


}