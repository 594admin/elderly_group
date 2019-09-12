package cn.lanhuhebi.elderly_group.model.pojo;

/**
 * @ClassName TeamEpt
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class TeamEpt {

    //小组设备库存ID
    private Integer tem_ept_id;

    //类型
    private String tem_ept_type;

    //厂家
    private String tem_ept_facty;

    //型号
    private String tem_ept_model;

    //单价
    private Double tem_ept_price;

    //库存
    private Integer tem_ept_stock;

    //编号
    private String tem_ept_num;

    //get set 方法
    public Integer getTem_ept_id() {
        return tem_ept_id;
    }

    public void setTem_ept_id(Integer tem_ept_id) {
        this.tem_ept_id = tem_ept_id;
    }

    public String getTem_ept_type() {
        return tem_ept_type;
    }

    public void setTem_ept_type(String tem_ept_type) {
        this.tem_ept_type = tem_ept_type;
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

    public Double getTem_ept_price() {
        return tem_ept_price;
    }

    public void setTem_ept_price(Double tem_ept_price) {
        this.tem_ept_price = tem_ept_price;
    }

    public Integer getTem_ept_stock() {
        return tem_ept_stock;
    }

    public void setTem_ept_stock(Integer tem_ept_stock) {
        this.tem_ept_stock = tem_ept_stock;
    }

    public String getTem_ept_num() {
        return tem_ept_num;
    }

    public void setTem_ept_num(String tem_ept_num) {
        this.tem_ept_num = tem_ept_num;
    }

    public TeamEpt(Integer tem_ept_id, Integer tem_ept_stock) {
        this.tem_ept_id = tem_ept_id;
        this.tem_ept_stock = tem_ept_stock;
    }

    public TeamEpt() {
    }
}