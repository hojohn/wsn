package com.ai.mnt.model.employee;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: WsnTrain 
 * @Description: WsnTrain Model
 * @Author: Auto Generate.
 * @Date: 2016-10-16
 */
public class WsnTrain implements Serializable{

    private static final long serialVersionUID = 1L;

    /**培训编码*/
    private Integer trainId;

    /**培新名称*/
    private String trainName;

    /**培训内容*/
    private String trainContent;

    /**培训课时*/
    private String trainHours;

    /**培训教师*/
    private String trainTeacher;

    /**培训方式*/
    private String trainMethod;

    /**培训时间*/
    private Date trainDate;

    /**备注*/
    private String remark;

    /**删除标识，1删除，0未删除*/
    private String deleteFlag;

    /**创建人*/
    private String creator;

    /**创建时间*/
    private Date createDate;

    /**修改人*/
    private String modifier;

    /**修改时间*/
    private Date modifyDate;


    public Integer getTrainId() {
        return trainId;
    }

    public void setTrainId(Integer trainId) {
        this.trainId = trainId;
    }

    public String getTrainName() {
        return trainName;
    }

    public void setTrainName(String trainName) {
        this.trainName = trainName;
    }

    public String getTrainContent() {
        return trainContent;
    }

    public void setTrainContent(String trainContent) {
        this.trainContent = trainContent;
    }

    public String getTrainHours() {
        return trainHours;
    }

    public void setTrainHours(String trainHours) {
        this.trainHours = trainHours;
    }

    public String getTrainTeacher() {
        return trainTeacher;
    }

    public void setTrainTeacher(String trainTeacher) {
        this.trainTeacher = trainTeacher;
    }

    public String getTrainMethod() {
        return trainMethod;
    }

    public void setTrainMethod(String trainMethod) {
        this.trainMethod = trainMethod;
    }

    public Date getTrainDate() {
        return trainDate;
    }

    public void setTrainDate(Date trainDate) {
        this.trainDate = trainDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
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