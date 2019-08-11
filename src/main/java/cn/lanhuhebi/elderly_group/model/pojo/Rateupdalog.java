package cn.lanhuhebi.elderly_group.model.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName 
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
    private Integer uplogPreId;

    //get set 方法
    public Rateupdalog setUplogId (Integer uplogId){
        this.uplogId=uplogId;
        return this;
    }

    public Integer getUplogId(){
        return this.uplogId;
    }

    public Rateupdalog setUplogOperaDate (Date uplogOperaDate){
        this.uplogOperaDate=uplogOperaDate;
        return this;
    }

    public Date getUplogOperaDate(){
        return this.uplogOperaDate;
    }

    public Rateupdalog setUplogBefore (String uplogBefore){
        this.uplogBefore=uplogBefore;
        return this;
    }

    public String getUplogBefore(){
        return this.uplogBefore;
    }

    public Rateupdalog setUplogAfter (String uplogAfter){
        this.uplogAfter=uplogAfter;
        return this;
    }

    public String getUplogAfter(){
        return this.uplogAfter;
    }

    public Rateupdalog setUplogPreId (Integer uplogPreId){
        this.uplogPreId=uplogPreId;
        return this;
    }

    public Integer getUplogPreId(){
        return this.uplogPreId;
    }

}
