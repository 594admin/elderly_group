package cn.lanhuhebi.elderly_group.model.pojo;
import java.sql.Timestamp;

/**
 * @ClassName Feedback
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Feedback {

    //反馈ID
    private Integer fbk_id;

    //反馈人(员工ID)
    private Integer fbk_person;

    //联系方式
    private String fbk_phone;

    //反馈人姓名
    private String fbk_name;

    //反馈信息1
    private String fbk_data;

    //    图片
    private String fbk_pic;

    //反馈时间
    private Timestamp fbk_creaDate;

    //get set 方法
    public Integer getFbk_id() {
        return fbk_id;
    }

    public void setFbk_id(Integer fbk_id) {
        this.fbk_id = fbk_id;
    }

    public Integer getFbk_person() {
        return fbk_person;
    }

    public void setFbk_person(Integer fbk_person) {
        this.fbk_person = fbk_person;
    }

    public String getFbk_phone() {
        return fbk_phone;
    }

    public void setFbk_phone(String fbk_phone) {
        this.fbk_phone = fbk_phone;
    }

    public String getFbk_name() {
        return fbk_name;
    }

    public void setFbk_name(String fbk_name) {
        this.fbk_name = fbk_name;
    }

    public String getFbk_data() {
        return fbk_data;
    }

    public void setFbk_data(String fbk_data) {
        this.fbk_data = fbk_data;
    }

    public String getFbk_pic() {
        return fbk_pic;
    }

    public void setFbk_pic(String fbk_pic) {
        this.fbk_pic = fbk_pic;
    }

    public Timestamp getFbk_creaDate() {
        return fbk_creaDate;
    }

    public void setFbk_creaDate(Timestamp fbk_creaDate) {
        this.fbk_creaDate = fbk_creaDate;
    }

    @Override
    public String toString() {
        return "Feedback{" +
                "fbk_id=" + fbk_id +
                ", fbk_person=" + fbk_person +
                ", fbk_phone='" + fbk_phone + '\'' +
                ", fbk_name='" + fbk_name + '\'' +
                ", fbk_data='" + fbk_data + '\'' +
                ", fbk_pic='" + fbk_pic + '\'' +
                ", fbk_creaDate=" + fbk_creaDate +
                '}';
    }
}
