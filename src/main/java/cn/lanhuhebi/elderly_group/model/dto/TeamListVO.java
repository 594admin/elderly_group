package cn.lanhuhebi.elderly_group.model.dto;

import cn.lanhuhebi.elderly_group.model.pojo.Personnel;

import java.util.Date;
import java.util.List;

/**
 * @author FanWeichong
 * @date 2019-08-18 22:41
 */
public class TeamListVO {
    //工程小组ID
    private Integer tid;
    //工程小组名称
    private String tname;
    //工程小组组长
    private String leader;
    //工程小组成员
    private List<Personnel> member;
    //创建时间
    private Date  createTime;
    //创建人
    private String creator;

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getLeader() {
        return leader;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public List<Personnel> getMember() {
        return member;
    }

    public void setMember(List<Personnel> member) {
        this.member = member;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }
}
