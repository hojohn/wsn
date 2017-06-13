package com.ai.mnt.model.device;

import java.io.Serializable;
import java.util.Date;

/**
 * @Title: WsnHardwareType 
 * @Description: WsnHardwareType Model
 * @Author: Auto Generate.
 * @Date: 2016-10-28
 */
public class WsnHardwareType implements Serializable{

    private static final long serialVersionUID = 1L;

    /**硬件类型ID*/
    private Integer typeId;

    /**硬件名称*/
    private String typeName;

    /**备注*/
    private String remark;


    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }


}