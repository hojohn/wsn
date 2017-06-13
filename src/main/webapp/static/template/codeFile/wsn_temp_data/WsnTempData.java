package com.ai.mnt.model.temp;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: WsnTempData 
 * @Description: WsnTempData Model
 * @Author: Auto Generate.
 * @Date: 2016-12-24
 */
public class WsnTempData implements Serializable{

    private static final long serialVersionUID = 1L;

    /***/
    private String wareId;

    /***/
    private String objId;

    /***/
    private String temperatureValue;

    /***/
    private String rate;

    /***/
    private Integer state;

    /***/
    private Date createTime;

    /***/
    private String field;

    /***/
    private Integer id;

    /***/
    private Date max(createTime);


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

    public String getTemperatureValue() {
        return temperatureValue;
    }

    public void setTemperatureValue(String temperatureValue) {
        this.temperatureValue = temperatureValue;
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

    public Date getMax(createTime)() {
        return max(createTime);
    }

    public void setMax(createTime)(Date max(createTime)) {
        this.max(createTime) = max(createTime);
    }


}