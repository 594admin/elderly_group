package cn.lanhuhebi.elderly_group.model.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName TeamLiblog
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class TeamLiblog {

    //小组出入库日志ID
    private Integer temLibId;

    //出入库类型
    private Integer temLibType;

    //操作时间
    private Date temLibCreaDate;

    //操作人(员工ID)
    private Integer temLibOperator;

    //设备ID
    private Integer temLibEptId;

    //操作数量
    private Integer temLibNum;

    //采购ID
    private Integer temLibPurseId;

    //get set 方法
    public TeamLiblog setTemLibId (Integer temLibId){
        this.temLibId=temLibId;
        return this;
    }

    public Integer getTemLibId(){
        return this.temLibId;
    }

    public TeamLiblog setTemLibType (Integer temLibType){
        this.temLibType=temLibType;
        return this;
    }

    public Integer getTemLibType(){
        return this.temLibType;
    }

    public TeamLiblog setTemLibCreaDate (Date temLibCreaDate){
        this.temLibCreaDate=temLibCreaDate;
        return this;
    }

    public Date getTemLibCreaDate(){
        return this.temLibCreaDate;
    }

    public TeamLiblog setTemLibOperator (Integer temLibOperator){
        this.temLibOperator=temLibOperator;
        return this;
    }

    public Integer getTemLibOperator(){
        return this.temLibOperator;
    }

    public TeamLiblog setTemLibEptId (Integer temLibEptId){
        this.temLibEptId=temLibEptId;
        return this;
    }

    public Integer getTemLibEptId(){
        return this.temLibEptId;
    }

    public TeamLiblog setTemLibNum (Integer temLibNum){
        this.temLibNum=temLibNum;
        return this;
    }

    public Integer getTemLibNum(){
        return this.temLibNum;
    }

    public TeamLiblog setTemLibPurseId (Integer temLibPurseId){
        this.temLibPurseId=temLibPurseId;
        return this;
    }

    public Integer getTemLibPurseId(){
        return this.temLibPurseId;
    }

}
