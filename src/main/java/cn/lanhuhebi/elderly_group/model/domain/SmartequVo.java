package cn.lanhuhebi.elderly_group.model.domain;

import java.util.Date;

/**
 * @author dxq
 * @date 2019-09-03 - 13:26
 */
public class SmartequVo {

    private Integer id;

    private String euqId;

    private Date binddate;

    private Integer flyId;

    private String eptId;

    private String eptType;

    @Override
    public String toString() {
        return "SmartequVo{" +
                "id=" + id +
                ", euqId='" + euqId + '\'' +
                ", binddate=" + binddate +
                ", flyId=" + flyId +
                ", eptId='" + eptId + '\'' +
                ", eptType='" + eptType + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEuqId() {
        return euqId;
    }

    public void setEuqId(String euqId) {
        this.euqId = euqId;
    }

    public Date getBinddate() {
        return binddate;
    }

    public void setBinddate(Date binddate) {
        this.binddate = binddate;
    }

    public Integer getFlyId() {
        return flyId;
    }

    public void setFlyId(Integer flyId) {
        this.flyId = flyId;
    }

    public String getEptId() {
        return eptId;
    }

    public void setEptId(String eptId) {
        this.eptId = eptId;
    }

    public String getEptType() {
        return eptType;
    }

    public void setEptType(String eptType) {
        this.eptType = eptType;
    }
}
