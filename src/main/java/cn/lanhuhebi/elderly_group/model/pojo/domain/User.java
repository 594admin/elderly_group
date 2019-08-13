package cn.lanhuhebi.elderly_group.model.pojo.domain;

import cn.lanhuhebi.elderly_group.model.pojo.Auth;
import cn.lanhuhebi.elderly_group.model.pojo.Role;

import java.util.Date;
import java.util.List;

/**
 * @author dxq
 * @date 2019-08-13 - 19:27
 */
public class User {
    //员工ID
    private Integer preId;

    //姓名
    private String preName;

    //联系方式
    private String prePhone;

    //邮箱
    private String preEmail;

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

    private String prePassword;

    private Role role;

    private List<Auth> auths;

    public Integer getPreId() {
        return preId;
    }

    public void setPreId(Integer preId) {
        this.preId = preId;
    }

    public String getPreName() {
        return preName;
    }

    public void setPreName(String preName) {
        this.preName = preName;
    }

    public String getPrePhone() {
        return prePhone;
    }

    public void setPrePhone(String prePhone) {
        this.prePhone = prePhone;
    }

    public String getPreEmail() {
        return preEmail;
    }

    public void setPreEmail(String preEmail) {
        this.preEmail = preEmail;
    }

    public Integer getPreGender() {
        return preGender;
    }

    public void setPreGender(Integer preGender) {
        this.preGender = preGender;
    }

    public Integer getPreRoleId() {
        return preRoleId;
    }

    public void setPreRoleId(Integer preRoleId) {
        this.preRoleId = preRoleId;
    }

    public Integer getPreStatus() {
        return preStatus;
    }

    public void setPreStatus(Integer preStatus) {
        this.preStatus = preStatus;
    }

    public Date getPreCreaDate() {
        return preCreaDate;
    }

    public void setPreCreaDate(Date preCreaDate) {
        this.preCreaDate = preCreaDate;
    }

    public Date getPreUpdaDate() {
        return preUpdaDate;
    }

    public void setPreUpdaDate(Date preUpdaDate) {
        this.preUpdaDate = preUpdaDate;
    }

    public String getPrePassword() {
        return prePassword;
    }

    public void setPrePassword(String prePassword) {
        this.prePassword = prePassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public List<Auth> getAuths() {
        return auths;
    }

    public void setAuths(List<Auth> auths) {
        this.auths = auths;
    }
}
