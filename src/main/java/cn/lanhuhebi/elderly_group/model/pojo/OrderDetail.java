package cn.lanhuhebi.elderly_group.model.pojo;

import java.io.Serializable;

public class OrderDetail implements Serializable {
    //订单明细表Id
    private Integer odId;
    //设备编号
    private String odEmpNo;
    //人机照片
    private String odPhoto;
    //订单Id
    private Integer odOrId;

    public Integer getOdId() {
        return odId;
    }

    public OrderDetail setOdId(Integer odId) {
        this.odId = odId;
        return this;
    }

    public String getOdEmpNo() {
        return odEmpNo;
    }

    public OrderDetail setOdEmpNo(String odEmpNo) {
        this.odEmpNo = odEmpNo;
        return this;
    }

    public String getOdPhoto() {
        return odPhoto;
    }

    public OrderDetail setOdPhoto(String odPhoto) {
        this.odPhoto = odPhoto;
        return this;
    }

    public Integer getOdOrId() {
        return odOrId;
    }

    public OrderDetail setOdOrId(Integer odOrId) {
        this.odOrId = odOrId;
        return this;
    }
}
