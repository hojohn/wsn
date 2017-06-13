package com.ai.mnt.model.sensor;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: WsnNoise 
 * @Description: WsnNoise Model
 * @Author: Auto Generate.
 * @Date: 2017-4-20
 */
public class WsnNoise implements Serializable{

    private static final long serialVersionUID = 1L;

    /**传感器编号*/
    private String wareId;

    /**网关*/
    private String objId;

    /**传感器噪音值*/
    private String noiseValue;

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

    public String getNoiseValue() {
        return noiseValue;
    }

    public void setNoiseValue(String noiseValue) {
        this.noiseValue = noiseValue;
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