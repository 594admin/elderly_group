package cn.lanhuhebi.elderly_group.model.pojo;
import java.util.Date;

/**
 * @ClassName Personnel
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Personnel {

    //员工ID
    private Integer preId;

    //姓名
    private String preName;

    //联系方式
    private String prePhone;

    //邮箱
    private String preEmail;

    //密码
    private String prePassword;

    //性别
    private Integer preGender;

    //角色ID
    private Integer preRoleId;

    //状态
    private Integer preStatus;

    //创建时间
    private Date preCreaDate;

    //修改时间
    private Date preUpdaDate;

    @Override
    public String toString() {
        return "Personnel{" +
                "preId=" + preId +
                ", preName='" + preName + '\'' +
                ", prePhone='" + prePhone + '\'' +
                ", preEmail='" + preEmail + '\'' +
                ", prePassword='" + prePassword + '\'' +
                ", preGender=" + preGender +
                ", preRoleId=" + preRoleId +
                ", preStatus=" + preStatus +
                ", preCreaDate=" + preCreaDate +
                ", preUpdaDate=" + preUpdaDate +
                '}';
    }

    //get set 方法
    public Personnel setPreId (Integer preId){
        this.preId=preId;
        return this;
    }

    public Integer getPreId(){
        return this.preId;
    }

    public Personnel setPreName (String preName){
        this.preName=preName;
        return this;
    }

    public String getPreName(){
        return this.preName;
    }

    public Personnel setPrePhone (String prePhone){
        this.prePhone=prePhone;
        return this;
    }

    public String getPrePhone(){
        return this.prePhone;
    }

    public Personnel setPreEmail (String preEmail){
        this.preEmail=preEmail;
        return this;
    }

    public String getPreEmail(){
        return this.preEmail;
    }

    public Personnel setPrePassword (String prePassword){
        this.prePassword=prePassword;
        return this;
    }

    public String getPrePassword(){
        return this.prePassword;
    }

    public Personnel setPreGender (Integer preGender){
        this.preGender=preGender;
        return this;
    }

    public Integer getPreGender(){
        return this.preGender;
    }

    public Personnel setPreRoleId (Integer preRoleId){
        this.preRoleId=preRoleId;
        return this;
    }

    public Integer getPreRoleId(){
        return this.preRoleId;
    }

    public Personnel setPreStatus (Integer preStatus){
        this.preStatus=preStatus;
        return this;
    }

    public Integer getPreStatus(){
        return this.preStatus;
    }

    public Personnel setPreCreaDate (Date preCreaDate){
        this.preCreaDate=preCreaDate;
        return this;
    }

    public Date getPreCreaDate(){
        return this.preCreaDate;
    }

    public Personnel setPreUpdaDate (Date preUpdaDate){
        this.preUpdaDate=preUpdaDate;
        return this;
    }

    public Date getPreUpdaDate(){
        return this.preUpdaDate;
    }

}
