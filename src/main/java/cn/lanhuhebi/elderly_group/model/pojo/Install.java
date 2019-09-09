package cn.lanhuhebi.elderly_group.model.pojo;
import java.util.Date;

/**
 * @ClassName Install
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Install {

    //安装记录ID
    private Integer illId;

    //订单ID
    private Integer illOrId;

    //分配记录ID
    private Integer illDistId;

    //安装时间
    private Date illInstallDate;

    //安装状态
    private Integer illStatus;
    //采购单ID
    private Integer illPurseId;


    //get set 方法


    public Integer getIllPurseId() {
        return illPurseId;
    }

    public Install setIllPurseId(Integer illPurseId) {
        this.illPurseId = illPurseId;
        return this;
    }

    public Install setIllId (Integer illId){
        this.illId=illId;
        return this;
    }

    public Integer getIllId(){
        return this.illId;
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
