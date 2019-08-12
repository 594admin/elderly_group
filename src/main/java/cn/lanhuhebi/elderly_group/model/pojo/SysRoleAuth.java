package cn.lanhuhebi.elderly_group.model.pojo;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class SysRoleAuth {

    //角色ID
    private Integer roleId;

    //权限ID
    private Integer authId;

    //get set 方法
    public SysRoleAuth setRoleId (Integer roleId){
        this.roleId=roleId;
        return this;
    }

    public Integer getRoleId(){
        return this.roleId;
    }

    public SysRoleAuth setAuthId (Integer authId){
        this.authId=authId;
        return this;
    }

    public Integer getAuthId(){
        return this.authId;
    }

}
