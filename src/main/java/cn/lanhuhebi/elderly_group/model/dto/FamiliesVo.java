package cn.lanhuhebi.elderly_group.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName FamilyVo
 * @Author LiuXin
 * @Date 2019/8/30 0030
 * @Version 1.0
 **/
public class FamiliesVo{

    private String name,phone,card,house;

    private Integer fly_id,fly_area_id,fly_ispoor,fly_tem_id,fly_status,
            fly_purse_id;
    private  String fly_address,fly_notes,
            fly_data1,fly_data2,fly_data3,fly_data4,fly_data5,fly_data6;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday,fly_date;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCard() {
        return card;
    }

    public void setCard(String card) {
        this.card = card;
    }

    public String getHouse() {
        return house;
    }

    public void setHouse(String house) {
        this.house = house;
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

    public String getFly_address() {
        return fly_address;
    }

    public void setFly_address(String fly_address) {
        this.fly_address = fly_address;
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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Date getFly_date() {
        return fly_date;
    }

    public void setFly_date(Date fly_date) {
        this.fly_date = fly_date;
    }
}
