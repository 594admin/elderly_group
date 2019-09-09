package cn.lanhuhebi.elderly_group.model.dto;

public class OrderDetailVo {
    //订单明细表Id
    private Integer odId;
    //设备编号
    private String odEmpNo;
    //人机照片
    private String odPhoto;
    //订单Id
    private Integer odOrId;
    //采购单Id
    private Integer orPurseId;
    //设备ID
    private Integer eptId;
    //类型
    private String eptType;
    //厂家
    private String eptFacty;
    //型号
    private String eptModel;

    public Integer getOdId() {
        return odId;
    }

    public OrderDetailVo setOdId(Integer odId) {
        this.odId = odId;
        return this;
    }

    public String getOdEmpNo() {
        return odEmpNo;
    }

    public OrderDetailVo setOdEmpNo(String odEmpNo) {
        this.odEmpNo = odEmpNo;
        return this;
    }

    public String getOdPhoto() {
        return odPhoto;
    }

    public OrderDetailVo setOdPhoto(String odPhoto) {
        this.odPhoto = odPhoto;
        return this;
    }

    public Integer getOdOrId() {
        return odOrId;
    }

    public OrderDetailVo setOdOrId(Integer odOrId) {
        this.odOrId = odOrId;
        return this;
    }

    public Integer getOrPurseId() {
        return orPurseId;
    }

    public OrderDetailVo setOrPurseId(Integer orPurseId) {
        this.orPurseId = orPurseId;
        return this;
    }

    public Integer getEptId() {
        return eptId;
    }

    public OrderDetailVo setEptId(Integer eptId) {
        this.eptId = eptId;
        return this;
    }

    public String getEptType() {
        return eptType;
    }

    public OrderDetailVo setEptType(String eptType) {
        this.eptType = eptType;
        return this;
    }

    public String getEptFacty() {
        return eptFacty;
    }

    public OrderDetailVo setEptFacty(String eptFacty) {
        this.eptFacty = eptFacty;
        return this;
    }

    public String getEptModel() {
        return eptModel;
    }

    public OrderDetailVo setEptModel(String eptModel) {
        this.eptModel = eptModel;
        return this;
    }
}
