package cn.lanhuhebi.elderly_group.model.dto;

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

//    private Integer fly_id,fly_area_id,fly_ispoor,fly_tem_id,fly_status,
//            fly_purse_id;
//    private  String fly_address,fly_notes,
//            fly_data1,fly_data2,fly_data3,fly_data4,fly_data5,fly_data6;
//    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
//    private  Date fly_date;

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

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

}
