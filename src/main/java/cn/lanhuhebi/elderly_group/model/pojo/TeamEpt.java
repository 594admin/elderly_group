package cn.lanhuhebi.elderly_group.model.pojo;

/**
 * @ClassName TeamEpt
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class TeamEpt {

    //小组设备库存ID
    private Integer temEptId;

    //类型
    private Integer temEptType;

    //厂家
    private Integer temEptFacty;

    //型号
    private String temEptModel;

    //单价
    private Double temEptPrice;

    //库存
    private Integer temEptStock;

    //编号
    private Integer temEptNum;

    //get set 方法
    public TeamEpt setTemEptId (Integer temEptId){
        this.temEptId=temEptId;
        return this;
    }

    public Integer getTemEptId(){
        return this.temEptId;
    }

    public TeamEpt setTemEptType (Integer temEptType){
        this.temEptType=temEptType;
        return this;
    }

    public Integer getTemEptType(){
        return this.temEptType;
    }

    public TeamEpt setTemEptFacty (Integer temEptFacty){
        this.temEptFacty=temEptFacty;
        return this;
    }

    public Integer getTemEptFacty(){
        return this.temEptFacty;
    }

    public TeamEpt setTemEptModel (String temEptModel){
        this.temEptModel=temEptModel;
        return this;
    }

    public String getTemEptModel(){
        return this.temEptModel;
    }

    public TeamEpt setTemEptPrice (Double temEptPrice){
        this.temEptPrice=temEptPrice;
        return this;
    }

    public Double getTemEptPrice(){
        return this.temEptPrice;
    }

    public TeamEpt setTemEptStock (Integer temEptStock){
        this.temEptStock=temEptStock;
        return this;
    }

    public Integer getTemEptStock(){
        return this.temEptStock;
    }

    public TeamEpt setTemEptNum (Integer temEptNum){
        this.temEptNum=temEptNum;
        return this;
    }

    public Integer getTemEptNum(){
        return this.temEptNum;
    }

}
