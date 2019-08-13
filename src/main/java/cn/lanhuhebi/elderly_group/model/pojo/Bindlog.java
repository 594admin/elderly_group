package cn.lanhuhebi.elderly_group.model.pojo;
import java.util.Date;

/**
 * @ClassName Bindlog
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Bindlog {

    //智能开关绑定日志ID
    private Integer bindId;

    //开关ID
    private Integer bindShId;

    //绑定时间
    private Date bindCreaDate;

    //户信息ID
    private Integer bindFlyId;

    //小组设备ID
    private Integer bindTemEptId;

    //员工ID
    private Integer bindPreId;

    //get set 方法
    public Bindlog setBindId (Integer bindId){
        this.bindId=bindId;
        return this;
    }

    public Integer getBindId(){
        return this.bindId;
    }

    public Bindlog setBindShId (Integer bindShId){
        this.bindShId=bindShId;
        return this;
    }

    public Integer getBindShId(){
        return this.bindShId;
    }

    public Bindlog setBindCreaDate (Date bindCreaDate){
        this.bindCreaDate=bindCreaDate;
        return this;
    }

    public Date getBindCreaDate(){
        return this.bindCreaDate;
    }

    public Bindlog setBindFlyId (Integer bindFlyId){
        this.bindFlyId=bindFlyId;
        return this;
    }

    public Integer getBindFlyId(){
        return this.bindFlyId;
    }

    public Bindlog setBindTemEptId (Integer bindTemEptId){
        this.bindTemEptId=bindTemEptId;
        return this;
    }

    public Integer getBindTemEptId(){
        return this.bindTemEptId;
    }

    public Bindlog setBindPreId (Integer bindPreId){
        this.bindPreId=bindPreId;
        return this;
    }

    public Integer getBindPreId(){
        return this.bindPreId;
    }

}
