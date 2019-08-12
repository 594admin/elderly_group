package cn.lanhuhebi.elderly_group.model.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Family {

    //户信息ID
    private Integer flyId;

    //户主
    private String flyName;

    //地域ID
    private Integer flyAreaId;

    //联系电话
    private String flyPhone;

    //身份证
    private String flyIDcard;

    //住址
    private String flyAddress;

    //门牌号
    private String flyDoorNum;

    //出生日期
    private Date flyBirthday;

    //是否贫困
    private Integer flyIspoor;

    //备注
    private String flyNotes;

    //小组ID
    private Integer flyTemId;

    //建筑面积
    private Integer flyBuldArea;

    //采暖面积
    private Integer flyHeatArea;

    //状态
    private Integer flyStatus;

    //采购ID
    private Integer flyPurseId;

    //身份证正面
    private String flyData1;

    //身份证反面
    private String flyData2;

    //户口本主页
    private String flyData3;

    //户口本其他页
    private String flyData4;

    //付款收据
    private String flyData5;

    //安装协议
    private String flyData6;

    //get set 方法
    public Family setFlyId (Integer flyId){
        this.flyId=flyId;
        return this;
    }

    public Integer getFlyId(){
        return this.flyId;
    }

    public Family setFlyName (String flyName){
        this.flyName=flyName;
        return this;
    }

    public String getFlyName(){
        return this.flyName;
    }

    public Family setFlyAreaId (Integer flyAreaId){
        this.flyAreaId=flyAreaId;
        return this;
    }

    public Integer getFlyAreaId(){
        return this.flyAreaId;
    }

    public Family setFlyPhone (String flyPhone){
        this.flyPhone=flyPhone;
        return this;
    }

    public String getFlyPhone(){
        return this.flyPhone;
    }

    public Family setFlyIDcard (String flyIDcard){
        this.flyIDcard=flyIDcard;
        return this;
    }

    public String getFlyIDcard(){
        return this.flyIDcard;
    }

    public Family setFlyAddress (String flyAddress){
        this.flyAddress=flyAddress;
        return this;
    }

    public String getFlyAddress(){
        return this.flyAddress;
    }

    public Family setFlyDoorNum (String flyDoorNum){
        this.flyDoorNum=flyDoorNum;
        return this;
    }

    public String getFlyDoorNum(){
        return this.flyDoorNum;
    }

    public Family setFlyBirthday (Date flyBirthday){
        this.flyBirthday=flyBirthday;
        return this;
    }

    public Date getFlyBirthday(){
        return this.flyBirthday;
    }

    public Family setFlyIspoor (Integer flyIspoor){
        this.flyIspoor=flyIspoor;
        return this;
    }

    public Integer getFlyIspoor(){
        return this.flyIspoor;
    }

    public Family setFlyNotes (String flyNotes){
        this.flyNotes=flyNotes;
        return this;
    }

    public String getFlyNotes(){
        return this.flyNotes;
    }

    public Family setFlyTemId (Integer flyTemId){
        this.flyTemId=flyTemId;
        return this;
    }

    public Integer getFlyTemId(){
        return this.flyTemId;
    }

    public Family setFlyBuldArea (Integer flyBuldArea){
        this.flyBuldArea=flyBuldArea;
        return this;
    }

    public Integer getFlyBuldArea(){
        return this.flyBuldArea;
    }

    public Family setFlyHeatArea (Integer flyHeatArea){
        this.flyHeatArea=flyHeatArea;
        return this;
    }

    public Integer getFlyHeatArea(){
        return this.flyHeatArea;
    }

    public Family setFlyStatus (Integer flyStatus){
        this.flyStatus=flyStatus;
        return this;
    }

    public Integer getFlyStatus(){
        return this.flyStatus;
    }

    public Family setFlyPurseId (Integer flyPurseId){
        this.flyPurseId=flyPurseId;
        return this;
    }

    public Integer getFlyPurseId(){
        return this.flyPurseId;
    }

    public Family setFlyData1 (String flyData1){
        this.flyData1=flyData1;
        return this;
    }

    public String getFlyData1(){
        return this.flyData1;
    }

    public Family setFlyData2 (String flyData2){
        this.flyData2=flyData2;
        return this;
    }

    public String getFlyData2(){
        return this.flyData2;
    }

    public Family setFlyData3 (String flyData3){
        this.flyData3=flyData3;
        return this;
    }

    public String getFlyData3(){
        return this.flyData3;
    }

    public Family setFlyData4 (String flyData4){
        this.flyData4=flyData4;
        return this;
    }

    public String getFlyData4(){
        return this.flyData4;
    }

    public Family setFlyData5 (String flyData5){
        this.flyData5=flyData5;
        return this;
    }

    public String getFlyData5(){
        return this.flyData5;
    }

    public Family setFlyData6 (String flyData6){
        this.flyData6=flyData6;
        return this;
    }

    public String getFlyData6(){
        return this.flyData6;
    }

}
