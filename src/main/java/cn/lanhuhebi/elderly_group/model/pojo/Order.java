package cn.lanhuhebi.elderly_group.model.pojo;

/**
 * @ClassName Order
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Order {

    //订单ID
    private Integer orId;

    //小组设备ID
    private Integer orEptId;

    //数量
    private Integer orEptNum;

    //价格
    private Double orEptPrice;

    //采购ID
    private Integer orPurseId;

    //get set 方法
    public Order setOrId (Integer orId){
        this.orId=orId;
        return this;
    }

    public Integer getOrId(){
        return this.orId;
    }

    public Order setOrEptId (Integer orEptId){
        this.orEptId=orEptId;
        return this;
    }

    public Integer getOrEptId(){
        return this.orEptId;
    }

    public Order setOrEptNum (Integer orEptNum){
        this.orEptNum=orEptNum;
        return this;
    }

    public Integer getOrEptNum(){
        return this.orEptNum;
    }

    public Order setOrEptPrice (Double orEptPrice){
        this.orEptPrice=orEptPrice;
        return this;
    }

    public Double getOrEptPrice(){
        return this.orEptPrice;
    }

    public Order setOrPurseId (Integer orPurseId){
        this.orPurseId=orPurseId;
        return this;
    }

    public Integer getOrPurseId(){
        return this.orPurseId;
    }

}
