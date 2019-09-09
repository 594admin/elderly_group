package cn.lanhuhebi.elderly_group.model.dto;

import com.alibaba.fastjson.annotation.JSONField;

import java.io.Serializable;
import java.util.Date;

public class InstallVo implements Serializable {
    //分配Id
    private Integer distId;
    //分配员工数组
    private String distInstaller;

    //安装表主键
    private Integer illId;
    //户Id
    private Integer flyId;
    //户姓名
    private String flyName;
    //户门牌号
    private String flyDoorNum;
    //户主手机号
    private String flyPhone;
    //户主身份证号
    private String flyIDcard;
    //负责小组ID
    private Integer temId;
    //负责小组名称
    private String temName;
    //户生日
    @JSONField(format="yyyy-MM-dd")
    private Date flyBirthday;
    //户地址
    private Integer flyAreaId;
    //安装状态
    private Integer illStatus;

    //户的全地址拼接
    private String flyAddress;
    //安装协议
    private String purseInstptl;

    //采购单ID
    private Integer illPurseId;

    public Integer getDistId() {
        return distId;
    }

    public InstallVo setDistId(Integer distId) {
        this.distId = distId;
        return this;
    }

    public String getDistInstaller() {
        return distInstaller;
    }

    public InstallVo setDistInstaller(String distInstaller) {
        this.distInstaller = distInstaller;
        return this;
    }

    public Integer getIllId() {
        return illId;
    }

    public InstallVo setIllId(Integer illId) {
        this.illId = illId;
        return this;
    }

    public Integer getFlyId() {
        return flyId;
    }

    public InstallVo setFlyId(Integer flyId) {
        this.flyId = flyId;
        return this;
    }

    public String getFlyName() {
        return flyName;
    }

    public InstallVo setFlyName(String flyName) {
        this.flyName = flyName;
        return this;
    }

    public String getFlyDoorNum() {
        return flyDoorNum;
    }

    public InstallVo setFlyDoorNum(String flyDoorNum) {
        this.flyDoorNum = flyDoorNum;
        return this;
    }

    public String getFlyPhone() {
        return flyPhone;
    }

    public InstallVo setFlyPhone(String flyPhone) {
        this.flyPhone = flyPhone;
        return this;
    }

    public String getFlyIDcard() {
        return flyIDcard;
    }

    public InstallVo setFlyIDcard(String flyIDcard) {
        this.flyIDcard = flyIDcard;
        return this;
    }

    public Integer getTemId() {
        return temId;
    }

    public InstallVo setTemId(Integer temId) {
        this.temId = temId;
        return this;
    }

    public String getTemName() {
        return temName;
    }

    public InstallVo setTemName(String temName) {
        this.temName = temName;
        return this;
    }
    public Date getFlyBirthday() {
        return flyBirthday;
    }

    public InstallVo setFlyBirthday(Date flyBirthday) {
        this.flyBirthday = flyBirthday;
        return this;
    }

    public Integer getFlyAreaId() {
        return flyAreaId;
    }

    public InstallVo setFlyAreaId(Integer flyAreaId) {
        this.flyAreaId = flyAreaId;
        return this;
    }

    public Integer getIllStatus() {
        return illStatus;
    }

    public InstallVo setIllStatus(Integer illStatus) {
        this.illStatus = illStatus;
        return this;
    }

    public String getFlyAddress() {
        return flyAddress;
    }

    public InstallVo setFlyAddress(String flyAddress) {
        this.flyAddress = flyAddress;
        return this;
    }

    public String getPurseInstptl() {
        return purseInstptl;
    }

    public InstallVo setPurseInstptl(String purseInstptl) {
        this.purseInstptl = purseInstptl;
        return this;
    }

    public Integer getIllPurseId() {
        return illPurseId;
    }

    public InstallVo setIllPurseId(Integer illPurseId) {
        this.illPurseId = illPurseId;
        return this;
    }
}
