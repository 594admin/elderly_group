package cn.lanhuhebi.elderly_group.model.pojo;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * @ClassName Install
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Install {

    //安装记录ID
    private Integer illId;
    //户Id
    private Integer illFlyId;
    //采购单ID
    private Integer illPurseId;
    //分配记录ID
    private Integer illDistId;

    //安装时间
    @JSONField(format="yyyy-MM-dd")
    private Date illInstallDate;

    //安装状态
    private Integer illStatus;

    public Integer getIllId() {
        return illId;
    }

    public Install setIllId(Integer illId) {
        this.illId = illId;
        return this;
    }

    public Integer getIllFlyId() {
        return illFlyId;
    }

    public Install setIllFlyId(Integer illFlyId) {
        this.illFlyId = illFlyId;
        return this;
    }

    public Integer getIllPurseId() {
        return illPurseId;
    }

    public Install setIllPurseId(Integer illPurseId) {
        this.illPurseId = illPurseId;
        return this;
    }

    public Integer getIllDistId() {
        return illDistId;
    }

    public Install setIllDistId(Integer illDistId) {
        this.illDistId = illDistId;
        return this;
    }

    public Date getIllInstallDate() {
        return illInstallDate;
    }

    public Install setIllInstallDate(Date illInstallDate) {
        this.illInstallDate = illInstallDate;
        return this;
    }

    public Integer getIllStatus() {
        return illStatus;
    }

    public Install setIllStatus(Integer illStatus) {
        this.illStatus = illStatus;
        return this;
    }
}
