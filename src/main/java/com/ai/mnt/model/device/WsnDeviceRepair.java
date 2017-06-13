package com.ai.mnt.model.device;

import java.io.Serializable;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * @Title: WsnDeviceRepair 
 * @Description: WsnDeviceRepair Model
 * @Author: Auto Generate.
 * @Date: 2016-10-15
 */
public class WsnDeviceRepair implements Serializable{

    private static final long serialVersionUID = 1L;

    /**维修编号*/
    private Integer repairId;

    /**设备RFID*/
    private Integer deviceRfid;

    /**维修信息*/
    private String repairInfo;

    /**维修时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date repairTime;

    /**维修人员*/
    private String repairPerson;

    /**删除标识，1删除，0未删除*/
    private String deleteFlag;

    /**创建人*/
    private String creator;

    /**记录创建时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date createDate;

    /**记录修改人*/
    private String modifier;

    /**记录修改时间*/
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date modifyDate;


    public Integer getRepairId() {
        return repairId;
    }

    public void setRepairId(Integer repairId) {
        this.repairId = repairId;
    }

    public Integer getDeviceRfid() {
        return deviceRfid;
    }

    public void setDeviceRfid(Integer deviceRfid) {
        this.deviceRfid = deviceRfid;
    }

    public String getRepairInfo() {
        return repairInfo;
    }

    public void setRepairInfo(String repairInfo) {
        this.repairInfo = repairInfo;
    }

    public Date getRepairTime() {
        return repairTime;
    }

    public void setRepairTime(Date repairTime) {
        this.repairTime = repairTime;
    }

    public String getRepairPerson() {
        return repairPerson;
    }

    public void setRepairPerson(String repairPerson) {
        this.repairPerson = repairPerson;
    }

    public String getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(String deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
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


}