package com.ai.mnt.model.device;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: WsnRfid 
 * @Description: WsnRfid Model
 * @Author: Auto Generate.
 * @Date: 2016-10-18
 */
public class WsnRfid implements Serializable{

    private static final long serialVersionUID = 1L;

    /**rfid主键*/
    private Integer rfidId;

    /**RFID标签序列号*/
    private String rfidSequence;

    /**RFID绑定编号*/
    private String rfidBindNumber;

    /**描述*/
    private String rfidDesc;

    /**RFID类型，1人员，2设备*/
    private String rfidType;

    /**删除标志，1删除，0未删除*/
    private String deleteFlag;

    /**创建人*/
    private String creator;

    /**创建时间*/
    private Date createDate;

    /**修改人*/
    private String modifier;

    /**修改时间*/
    private Date modifyDate;


    public Integer getRfidId() {
        return rfidId;
    }

    public void setRfidId(Integer rfidId) {
        this.rfidId = rfidId;
    }

    public String getRfidSequence() {
        return rfidSequence;
    }

    public void setRfidSequence(String rfidSequence) {
        this.rfidSequence = rfidSequence;
    }

    public String getRfidBindNumber() {
        return rfidBindNumber;
    }

    public void setRfidBindNumber(String rfidBindNumber) {
        this.rfidBindNumber = rfidBindNumber;
    }

    public String getRfidDesc() {
        return rfidDesc;
    }

    public void setRfidDesc(String rfidDesc) {
        this.rfidDesc = rfidDesc;
    }

    public String getRfidType() {
        return rfidType;
    }

    public void setRfidType(String rfidType) {
        this.rfidType = rfidType;
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