package com.ai.mnt.model.sensor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: WsnMethane 
 * @Description: WsnMethane Model
 * @Author: Auto Generate.
 * @Date: 2016-12-21
 */
public class WsnMethane implements Serializable{

    private static final long serialVersionUID = 1L;

    /**传感器编号*/
    private String wareId;

    /**网关*/
    private String objId;

    /**传感器甲烷值*/
    private String methaneValue;

    /**频率*/
    private String rate;

    /**状态：0正常，1损坏，2丢失*/
    private Integer state;

    /**采集时间*/
    private Date createTime;

    /**备用*/
    private String field;

    /**主键*/
    private Integer id;


    public String getWareId() {
        return wareId;
    }

    public void setWareId(String wareId) {
        this.wareId = wareId;
    }

    public String getObjId() {
        return objId;
    }

    public void setObjId(String objId) {
        this.objId = objId;
    }

    public String getMethaneValue() {
        return methaneValue;
    }

    public void setMethaneValue(String methaneValue) {
        this.methaneValue = methaneValue;
    }

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


}