package cn.lanhuhebi.elderly_group.model.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Install {

    //安装记录ID
    private Integer illId;

    //户信息ID
    private Integer illFlyId;

    //订单ID
    private Integer illOrId;

    //分配记录ID
    private Integer illDistId;

    //安装时间
    private Date illInstallDate;

    //安装状态
    private Integer illStatus;

    //get set 方法
    public Install setIllId (Integer illId){
        this.illId=illId;
        return this;
    }

    public Integer getIllId(){
        return this.illId;
    }

    public Install setIllFlyId (Integer illFlyId){
        this.illFlyId=illFlyId;
        return this;
    }

    public Integer getIllFlyId(){
        return this.illFlyId;
    }

    public Install setIllOrId (Integer illOrId){
        this.illOrId=illOrId;
        return this;
    }

    public Integer getIllOrId(){
        return this.illOrId;
    }

    public Install setIllDistId (Integer illDistId){
        this.illDistId=illDistId;
        return this;
    }

    public Integer getIllDistId(){
        return this.illDistId;
    }

    public Install setIllInstallDate (Date illInstallDate){
        this.illInstallDate=illInstallDate;
        return this;
    }

    public Date getIllInstallDate(){
        return this.illInstallDate;
    }

    public Install setIllStatus (Integer illStatus){
        this.illStatus=illStatus;
        return this;
    }

    public Integer getIllStatus(){
        return this.illStatus;
    }

}
