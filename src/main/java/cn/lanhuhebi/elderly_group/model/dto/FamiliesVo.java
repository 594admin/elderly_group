package cn.lanhuhebi.elderly_group.model.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @ClassName FamilyVo
 * @Author LiuXin
 * @Date 2019/8/30 0030
 * @Version 1.0
 **/
public class FamiliesVo {

    private String name,phone,card,house;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

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
