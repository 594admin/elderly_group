package cn.lanhuhebi.elderly_group.model.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Feedback
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Feedback {

    //反馈ID
    private Integer fbkId;

    //反馈人(员工ID)
    private Integer fbkPerson;

    //联系方式
    private String fbkPhone;

    //反馈人姓名
    private String fbkName;

    //反馈信息1
    private String fbkData1;

    //反馈信息2
    private String fbkData2;

    //反馈信息3
    private String fbkData3;

    //反馈信息4
    private String fbkData4;

    //反馈信息5
    private String fbkData5;

    //反馈信息6
    private String fbkData6;

    //反馈时间
    private Date fbkCreaDate;

    //get set 方法
    public Feedback setFbkId (Integer fbkId){
        this.fbkId=fbkId;
        return this;
    }

    public Integer getFbkId(){
        return this.fbkId;
    }

    public Feedback setFbkPerson (Integer fbkPerson){
        this.fbkPerson=fbkPerson;
        return this;
    }

    public Integer getFbkPerson(){
        return this.fbkPerson;
    }

    public Feedback setFbkPhone (String fbkPhone){
        this.fbkPhone=fbkPhone;
        return this;
    }

    public String getFbkPhone(){
        return this.fbkPhone;
    }

    public Feedback setFbkName (String fbkName){
        this.fbkName=fbkName;
        return this;
    }

    public String getFbkName(){
        return this.fbkName;
    }

    public Feedback setFbkData1 (String fbkData1){
        this.fbkData1=fbkData1;
        return this;
    }

    public String getFbkData1(){
        return this.fbkData1;
    }

    public Feedback setFbkData2 (String fbkData2){
        this.fbkData2=fbkData2;
        return this;
    }

    public String getFbkData2(){
        return this.fbkData2;
    }

    public Feedback setFbkData3 (String fbkData3){
        this.fbkData3=fbkData3;
        return this;
    }

    public String getFbkData3(){
        return this.fbkData3;
    }

    public Feedback setFbkData4 (String fbkData4){
        this.fbkData4=fbkData4;
        return this;
    }

    public String getFbkData4(){
        return this.fbkData4;
    }

    public Feedback setFbkData5 (String fbkData5){
        this.fbkData5=fbkData5;
        return this;
    }

    public String getFbkData5(){
        return this.fbkData5;
    }

    public Feedback setFbkData6 (String fbkData6){
        this.fbkData6=fbkData6;
        return this;
    }

    public String getFbkData6(){
        return this.fbkData6;
    }

    public Feedback setFbkCreaDate (Date fbkCreaDate){
        this.fbkCreaDate=fbkCreaDate;
        return this;
    }

    public Date getFbkCreaDate(){
        return this.fbkCreaDate;
    }

}
