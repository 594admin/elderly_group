package cn.lanhuhebi.elderly_group.model.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Auth {

    //权限ID
    private Integer authId;

    //权限名
    private String authName;

    //权限类型
    private Integer authType;

    //get set 方法
    public Auth setAuthId (Integer authId){
        this.authId=authId;
        return this;
    }

    public Integer getAuthId(){
        return this.authId;
    }

    public Auth setAuthName (String authName){
        this.authName=authName;
        return this;
    }

    public String getAuthName(){
        return this.authName;
    }

    public Auth setAuthType (Integer authType){
        this.authType=authType;
        return this;
    }

    public Integer getAuthType(){
        return this.authType;
    }

}
