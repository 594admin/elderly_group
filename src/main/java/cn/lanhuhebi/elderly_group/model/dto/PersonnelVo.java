package cn.lanhuhebi.elderly_group.model.dto;

import java.io.Serializable;
import java.util.Date;

public class PersonnelVo implements Serializable {
    //员工ID
    private Integer preId;

    //姓名
    private String preName;

    //联系方式
    private String prePhone;

    //邮箱
    private String preEmail;

    //密码
    private String prePassword;

    //性别
    private Integer preGender;

    //角色ID
    private Integer preRoleId;

    //状态
    private Integer preStatus;

    //创建时间
    private Date preCreaDate;

    //修改时间
    private Date preUpdaDate;

    public Integer getPreId() {
        return preId;
    }

    public PersonnelVo setPreId(Integer preId) {
        this.preId = preId;
        return this;
    }

    public String getPreName() {
        return preName;
    }

    public PersonnelVo setPreName(String preName) {
        this.preName = preName;
        return this;
    }

    public String getPrePhone() {
        return prePhone;
    }

    public PersonnelVo setPrePhone(String prePhone) {
        this.prePhone = prePhone;
        return this;
    }

    public String getPreEmail() {
        return preEmail;
    }

    public PersonnelVo setPreEmail(String preEmail) {
        this.preEmail = preEmail;
        return this;
    }

    public String getPrePassword() {
        return prePassword;
    }

    public PersonnelVo setPrePassword(String prePassword) {
        this.prePassword = prePassword;
        return this;
    }

    public Integer getPreGender() {
        return preGender;
    }

    public PersonnelVo setPreGender(Integer preGender) {
        this.preGender = preGender;
        return this;
    }

    public Integer getPreRoleId() {
        return preRoleId;
    }

    public PersonnelVo setPreRoleId(Integer preRoleId) {
        this.preRoleId = preRoleId;
        return this;
    }

    public Integer getPreStatus() {
        return preStatus;
    }

    public PersonnelVo setPreStatus(Integer preStatus) {
        this.preStatus = preStatus;
        return this;
    }

    public Date getPreCreaDate() {
        return preCreaDate;
    }

    public PersonnelVo setPreCreaDate(Date preCreaDate) {
        this.preCreaDate = preCreaDate;
        return this;
    }

    public Date getPreUpdaDate() {
        return preUpdaDate;
    }

    public PersonnelVo setPreUpdaDate(Date preUpdaDate) {
        this.preUpdaDate = preUpdaDate;
        return this;
    }
}
