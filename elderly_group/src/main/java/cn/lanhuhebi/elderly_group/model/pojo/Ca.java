package cn.lanhuhebi.elderly_group.model.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Ca {

    //采集ID
    private Integer caId;

    //采集时间
    private Date caCreaDate;

    //设备编号
    private String caEptNum;

    //状态
    private Integer caStatus;

    //室内温度
    private Integer caTemp;

    //电流
    private Integer caEle;

    //电能
    private Integer caEnergy;

    //get set 方法
    public Ca setCaId (Integer caId){
        this.caId=caId;
        return this;
    }

    public Integer getCaId(){
        return this.caId;
    }

    public Ca setCaCreaDate (Date caCreaDate){
        this.caCreaDate=caCreaDate;
        return this;
    }

    public Date getCaCreaDate(){
        return this.caCreaDate;
    }

    public Ca setCaEptNum (String caEptNum){
        this.caEptNum=caEptNum;
        return this;
    }

    public String getCaEptNum(){
        return this.caEptNum;
    }

    public Ca setCaStatus (Integer caStatus){
        this.caStatus=caStatus;
        return this;
    }

    public Integer getCaStatus(){
        return this.caStatus;
    }

    public Ca setCaTemp (Integer caTemp){
        this.caTemp=caTemp;
        return this;
    }

    public Integer getCaTemp(){
        return this.caTemp;
    }

    public Ca setCaEle (Integer caEle){
        this.caEle=caEle;
        return this;
    }

    public Integer getCaEle(){
        return this.caEle;
    }

    public Ca setCaEnergy (Integer caEnergy){
        this.caEnergy=caEnergy;
        return this;
    }

    public Integer getCaEnergy(){
        return this.caEnergy;
    }

}
