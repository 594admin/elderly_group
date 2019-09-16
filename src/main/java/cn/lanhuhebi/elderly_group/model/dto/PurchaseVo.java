package cn.lanhuhebi.elderly_group.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Timestamp;

public class PurchaseVo {

    private Integer fly_id;
    private String fly_name;
    private String fly_phone,fly_address,fly__notes,fly_IDcard,fly_doorNum;
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Timestamp fly_birthday;
//    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private Timestamp tem_lib_creaDate;
    private Integer k_status,total,tem_ept_id,purse_id,k_ept_id,kid,k_ept_num,k_purse_id;
    private String purse_instPtl,purse_ept_No,purse_photo,tem_ept_facty,tem_ept_model,tem_ept_type,pre_name;

    public Integer getK_status() {
        return k_status;
    }

    public void setK_status(Integer k_status) {
        this.k_status = k_status;
    }

    public Integer getK_ept_id() {
        return k_ept_id;
    }

    public void setK_ept_id(Integer k_ept_id) {
        this.k_ept_id = k_ept_id;
    }

    public Integer getKid() {
        return kid;
    }

    public void setKid(Integer kid) {
        this.kid = kid;
    }

    public Integer getK_ept_num() {
        return k_ept_num;
    }

    public void setK_ept_num(Integer k_ept_num) {
        this.k_ept_num = k_ept_num;
    }

    public Integer getK_purse_id() {
        return k_purse_id;
    }

    public void setK_purse_id(Integer k_purse_id) {
        this.k_purse_id = k_purse_id;
    }

    public Integer getPurse_id() {
        return purse_id;
    }

    public void setPurse_id(Integer purse_id) {
        this.purse_id = purse_id;
    }

    public Integer getTem_ept_id() {
        return tem_ept_id;
    }

    public void setTem_ept_id(Integer tem_ept_id) {
        this.tem_ept_id = tem_ept_id;
    }

    public String getTem_ept_facty() {
        return tem_ept_facty;
    }

    public void setTem_ept_facty(String tem_ept_facty) {
        this.tem_ept_facty = tem_ept_facty;
    }

    public String getTem_ept_model() {
        return tem_ept_model;
    }

    public void setTem_ept_model(String tem_ept_model) {
        this.tem_ept_model = tem_ept_model;
    }

    public String getTem_ept_type() {
        return tem_ept_type;
    }

    public void setTem_ept_type(String tem_ept_type) {
        this.tem_ept_type = tem_ept_type;
    }

    public String getPre_name() {
        return pre_name;
    }

    public void setPre_name(String pre_name) {
        this.pre_name = pre_name;
    }

    public Timestamp getTem_lib_creaDate() {
        return tem_lib_creaDate;
    }

    public void setTem_lib_creaDate(Timestamp tem_lib_creaDate) {
        this.tem_lib_creaDate = tem_lib_creaDate;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getFly_id() {
        return fly_id;
    }

    public void setFly_id(Integer fly_id) {
        this.fly_id = fly_id;
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

    public String getFly_address() {
        return fly_address;
    }

    public void setFly_address(String fly_address) {
        this.fly_address = fly_address;
    }

    public String getFly__notes() {
        return fly__notes;
    }

    public void setFly__notes(String fly__notes) {
        this.fly__notes = fly__notes;
    }

    public String getFly_IDcard() {
        return fly_IDcard;
    }

    public void setFly_IDcard(String fly_IDcard) {
        this.fly_IDcard = fly_IDcard;
    }

    public String getFly_doorNum() {
        return fly_doorNum;
    }

    public void setFly_doorNum(String fly_doorNum) {
        this.fly_doorNum = fly_doorNum;
    }

    public Timestamp getFly_birthday() {
        return fly_birthday;
    }

    public void setFly_birthday(Timestamp fly_birthday) {
        this.fly_birthday = fly_birthday;
    }

    public String getPurse_instPtl() {
        return purse_instPtl;
    }

    public void setPurse_instPtl(String purse_instPtl) {
        this.purse_instPtl = purse_instPtl;
    }

    public String getPurse_ept_No() {
        return purse_ept_No;
    }

    public void setPurse_ept_No(String purse_ept_No) {
        this.purse_ept_No = purse_ept_No;
    }

    public String getPurse_photo() {
        return purse_photo;
    }

    public void setPurse_photo(String purse_photo) {
        this.purse_photo = purse_photo;
    }


}
