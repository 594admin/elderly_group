package cn.lanhuhebi.elderly_group.model.pojo;
import java.util.Date;

/**
 * @ClassName Rateupdalog
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Rateupdalog {

    //修改频次日志ID
    private Integer uplogId;

    //操作时间
    private Date uplogOperaDate;

    //设置前频次
    private String uplogBefore;

    //设置后频次
    private String uplogAfter;

    //员工ID
    private String uplogPreId;

    public Integer getUplogId() {
        return uplogId;
    }

    public void setUplogId(Integer uplogId) {
        this.uplogId = uplogId;
    }

    public Date getUplogOperaDate() {
        return uplogOperaDate;
    }

    public void setUplogOperaDate(Date uplogOperaDate) {
        this.uplogOperaDate = uplogOperaDate;
    }

    public String getUplogBefore() {
        return uplogBefore;
    }

    public void setUplogBefore(String uplogBefore) {
        this.uplogBefore = uplogBefore;
    }

    public String getUplogAfter() {
        return uplogAfter;
    }

    public void setUplogAfter(String uplogAfter) {
        this.uplogAfter = uplogAfter;
    }

    public String getUplogPreId() {
        return uplogPreId;
    }

    public void setUplogPreId(String uplogPreId) {
        this.uplogPreId = uplogPreId;
    }
}
