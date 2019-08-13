package cn.lanhuhebi.elderly_group.model.pojo;
import java.util.Date;

/**
 * @ClassName Dist
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Dist {

    //分配记录ID
    private Integer distId;

    //户信息ID
    private Integer distFlyId;

    //分配时间
    private Date distDistDate;

    //分配状态
    private Integer distStatus;

    //安装工(员工ID数组)
    private String distInstaller;

    //get set 方法
    public Dist setDistId (Integer distId){
        this.distId=distId;
        return this;
    }

    public Integer getDistId(){
        return this.distId;
    }

    public Dist setDistFlyId (Integer distFlyId){
        this.distFlyId=distFlyId;
        return this;
    }

    public Integer getDistFlyId(){
        return this.distFlyId;
    }

    public Dist setDistDistDate (Date distDistDate){
        this.distDistDate=distDistDate;
        return this;
    }

    public Date getDistDistDate(){
        return this.distDistDate;
    }

    public Dist setDistStatus (Integer distStatus){
        this.distStatus=distStatus;
        return this;
    }

    public Integer getDistStatus(){
        return this.distStatus;
    }

    public Dist setDistInstaller (String distInstaller){
        this.distInstaller=distInstaller;
        return this;
    }

    public String getDistInstaller(){
        return this.distInstaller;
    }

}
