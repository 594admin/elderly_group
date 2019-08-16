package cn.lanhuhebi.elderly_group.model.pojo;
import java.util.Date;

/**
 * @ClassName Liblogs
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Liblogs {

    //出入库日志ID
    private Integer libId;

    //操作类型 1: 出库; 2: 入库
    private Integer libType;

    //操作时间
    private Date libCreaDate;

    //操作人(员工ID)
    private Integer libOperator;

    //设备ID
    private Integer libEptId;

    //操作数量
    private Integer libNum;

    //get set 方法
    public Liblogs setLibId (Integer libId){
        this.libId=libId;
        return this;
    }

    public Integer getLibId(){
        return this.libId;
    }

    public Liblogs setLibType (Integer libType){
        this.libType=libType;
        return this;
    }

    public Integer getLibType(){
        return this.libType;
    }

    public Liblogs setLibCreaDate (Date libCreaDate){
        this.libCreaDate=libCreaDate;
        return this;
    }

    public Date getLibCreaDate(){
        return this.libCreaDate;
    }

    public Liblogs setLibOperator (Integer libOperator){
        this.libOperator=libOperator;
        return this;
    }

    public Integer getLibOperator(){
        return this.libOperator;
    }

    public Liblogs setLibEptId (Integer libEptId){
        this.libEptId=libEptId;
        return this;
    }

    public Integer getLibEptId(){
        return this.libEptId;
    }

    public Liblogs setLibNum (Integer libNum){
        this.libNum=libNum;
        return this;
    }

    public Integer getLibNum(){
        return this.libNum;
    }

}
