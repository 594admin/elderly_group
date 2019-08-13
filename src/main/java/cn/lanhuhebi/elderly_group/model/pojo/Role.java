package cn.lanhuhebi.elderly_group.model.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Role
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Role {

    //角色ID
    private Integer roleId;

    //角色名称
    private String roleName;

    //get set 方法
    public Role setRoleId (Integer roleId){
        this.roleId=roleId;
        return this;
    }

    public Integer getRoleId(){
        return this.roleId;
    }

    public Role setRoleName (String roleName){
        this.roleName=roleName;
        return this;
    }

    public String getRoleName(){
        return this.roleName;
    }

}
