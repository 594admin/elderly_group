package cn.lanhuhebi.elderly_group.model.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Area {

    //地域ID
    private Integer areaId;

    //地域名
    private String areaName;

    //地域级别
    private Integer areaLevel;

    //上级地域ID
    private Integer areaParID;

    //get set 方法
    public Area setAreaId (Integer areaId){
        this.areaId=areaId;
        return this;
    }

    public Integer getAreaId(){
        return this.areaId;
    }

    public Area setAreaName (String areaName){
        this.areaName=areaName;
        return this;
    }

    public String getAreaName(){
        return this.areaName;
    }

    public Area setAreaLevel (Integer areaLevel){
        this.areaLevel=areaLevel;
        return this;
    }

    public Integer getAreaLevel(){
        return this.areaLevel;
    }

    public Area setAreaParID (Integer areaParID){
        this.areaParID=areaParID;
        return this;
    }

    public Integer getAreaParID(){
        return this.areaParID;
    }

}
