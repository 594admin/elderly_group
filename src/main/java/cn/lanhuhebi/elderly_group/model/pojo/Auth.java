package cn.lanhuhebi.elderly_group.model.pojo;

/**
 * @ClassName Auth
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
    //权限平台  1、PC端 2、移动端
    private Integer authDuan;
    //上级菜单
    private Integer authModel;

    public Integer getAuthDuan() {
        return authDuan;
    }

    public Auth setAuthDuan(Integer authDuan) {
        this.authDuan = authDuan;
        return this;
    }

    public Integer getAuthModel() {
        return authModel;
    }

    public Auth setAuthModel(Integer authModel) {
        this.authModel = authModel;
        return this;
    }

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
