package cn.lanhuhebi.elderly_group.model.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName Family
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Family {

    //fly_status状态说明:0删除1完成2录入户基础信息3录入设备采购信息
    private Integer fly_id,fly_area_id,fly_ispoor,fly_tem_id,fly_status,
            fly_purse_id;
    private  String fly_name,fly_phone,fly_IDcard,fly_address,fly_doorNum,fly_notes,
            fly_data1,fly_data2,fly_data3,fly_data4,fly_data5,fly_data6;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fly_birthday,fly_date;

    public Date getFly_date() {
        return fly_date;
    }

    public void setFly_date(Date fly_date) {
        this.fly_date = fly_date;
    }

    public void setFly_buldArea(Double fly_buldArea) {
        this.fly_buldArea = fly_buldArea;
    }

    public void setFly_heatArea(Double fly_heatArea) {
        this.fly_heatArea = fly_heatArea;
    }

    private Double fly_buldArea,fly_heatArea;

    public double getFly_buldArea() {
        return fly_buldArea;
    }

    public void setFly_buldArea(double fly_buldArea) {
        this.fly_buldArea = fly_buldArea;
    }

    public double getFly_heatArea() {
        return fly_heatArea;
    }

    public void setFly_heatArea(double fly_heatArea) {
        this.fly_heatArea = fly_heatArea;
    }

    public Integer getFly_id() {
        return fly_id;
    }

    public void setFly_id(Integer fly_id) {
        this.fly_id = fly_id;
    }

    public Integer getFly_area_id() {
        return fly_area_id;
    }

    public void setFly_area_id(Integer fly_area_id) {
        this.fly_area_id = fly_area_id;
    }

    public Integer getFly_ispoor() {
        return fly_ispoor;
    }

    public void setFly_ispoor(Integer fly_ispoor) {
        this.fly_ispoor = fly_ispoor;
    }

    public Integer getFly_tem_id() {
        return fly_tem_id;
    }

    public void setFly_tem_id(Integer fly_tem_id) {
        this.fly_tem_id = fly_tem_id;
    }

    public Integer getFly_status() {
        return fly_status;
    }

    public void setFly_status(Integer fly_status) {
        this.fly_status = fly_status;
    }

    public Integer getFly_purse_id() {
        return fly_purse_id;
    }

    public void setFly_purse_id(Integer fly_purse_id) {
        this.fly_purse_id = fly_purse_id;
    }

    public String getFly_name() {
        return fly_name;
    }

    public void setFly_name(String fly_name) {
        this.fly_name = fly_name;
    }

    public String getFly_phone() {
        return fly_phone;
    }

    public void setFly_phone(String fly_phone) {
        this.fly_phone = fly_phone;
    }

    public String getFly_IDcard() {
        return fly_IDcard;
    }

    public void setFly_IDcard(String fly_IDcard) {
        this.fly_IDcard = fly_IDcard;
    }

    public String getFly_address() {
        return fly_address;
    }

    public void setFly_address(String fly_address) {
        this.fly_address = fly_address;
    }

    public String getFly_doorNum() {
        return fly_doorNum;
    }


    public void setFly_doorNum(String fly_doorNum) {
        this.fly_doorNum = fly_doorNum;
    }

    public String getFly_notes() {
        return fly_notes;
    }

    public void setFly_notes(String fly_notes) {
        this.fly_notes = fly_notes;
    }

    public String getFly_data1() {
        return fly_data1;
    }

    public void setFly_data1(String fly_data1) {
        this.fly_data1 = fly_data1;
    }

    public String getFly_data2() {
        return fly_data2;
    }

    public void setFly_data2(String fly_data2) {
        this.fly_data2 = fly_data2;
    }

    public String getFly_data3() {
        return fly_data3;
    }

    public void setFly_data3(String fly_data3) {
        this.fly_data3 = fly_data3;
    }

    public String getFly_data4() {
        return fly_data4;
    }

    public void setFly_data4(String fly_data4) {
        this.fly_data4 = fly_data4;
    }

    public String getFly_data5() {
        return fly_data5;
    }

    public void setFly_data5(String fly_data5) {
        this.fly_data5 = fly_data5;
    }

    public String getFly_data6() {
        return fly_data6;
    }

    public void setFly_data6(String fly_data6) {
        this.fly_data6 = fly_data6;
    }

    public Date getFly_birthday() {
        return fly_birthday;
    }

    public void setFly_birthday(Date fly_birthday) {
        this.fly_birthday = fly_birthday;
    }

    @Override
    public String toString() {
        return "Family{" +
                "fly_id=" + fly_id +
                ", fly_area_id=" + fly_area_id +
                ", fly_ispoor=" + fly_ispoor +
                ", fly_tem_id=" + fly_tem_id +
                ", fly_status=" + fly_status +
                ", fly_purse_id=" + fly_purse_id +
                ", fly_name='" + fly_name + '\'' +
                ", fly_phone='" + fly_phone + '\'' +
                ", fly_IDcard='" + fly_IDcard + '\'' +
                ", fly_address='" + fly_address + '\'' +
                ", fly_doorNum='" + fly_doorNum + '\'' +
                ", fly_notes='" + fly_notes + '\'' +
                ", fly_data1='" + fly_data1 + '\'' +
                ", fly_data2='" + fly_data2 + '\'' +
                ", fly_data3='" + fly_data3 + '\'' +
                ", fly_data4='" + fly_data4 + '\'' +
                ", fly_data5='" + fly_data5 + '\'' +
                ", fly_data6='" + fly_data6 + '\'' +
                ", fly_birthday=" + fly_birthday +
                ", fly_date=" + fly_date +
                ", fly_buldArea=" + fly_buldArea +
                ", fly_heatArea=" + fly_heatArea +
                '}';
    }
}
