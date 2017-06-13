package com.ai.mnt.model.device;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: WsnEmpRfid 
 * @Description: WsnEmpRfid Model
 * @Author: Auto Generate.
 * @Date: 2016-10-20
 */
public class WsnEmpRfid implements Serializable{

    private static final long serialVersionUID = 1L;

    /**标签人员关联ID*/
    private Integer rfEmpId;

    /**标签ID*/
    private Integer rfidId;

    /**人员ID*/
    private Integer personId;


    public Integer getRfEmpId() {
        return rfEmpId;
    }

    public void setRfEmpId(Integer rfEmpId) {
        this.rfEmpId = rfEmpId;
    }

    public Integer getRfidId() {
        return rfidId;
    }

    public void setRfidId(Integer rfidId) {
        this.rfidId = rfidId;
    }

    public Integer getPersonId() {
        return personId;
    }

    public void setPersonId(Integer personId) {
        this.personId = personId;
    }


}