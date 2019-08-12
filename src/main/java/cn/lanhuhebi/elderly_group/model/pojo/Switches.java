package cn.lanhuhebi.elderly_group.model.pojo;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Switches {

    //智能开关ID
    private Integer shId;

    //编号
    private Integer shNum;

    //频次ID
    private Integer shRateId;

    //状态
    private Integer shStatus;

    //get set 方法
    public Switches setShId (Integer shId){
        this.shId=shId;
        return this;
    }

    public Integer getShId(){
        return this.shId;
    }

    public Switches setShNum (Integer shNum){
        this.shNum=shNum;
        return this;
    }

    public Integer getShNum(){
        return this.shNum;
    }

    public Switches setShRateId (Integer shRateId){
        this.shRateId=shRateId;
        return this;
    }

    public Integer getShRateId(){
        return this.shRateId;
    }

    public Switches setShStatus (Integer shStatus){
        this.shStatus=shStatus;
        return this;
    }

    public Integer getShStatus(){
        return this.shStatus;
    }

}
