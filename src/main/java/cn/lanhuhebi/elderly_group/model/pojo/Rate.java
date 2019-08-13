package cn.lanhuhebi.elderly_group.model.pojo;
import java.io.Serializable;
import java.util.Date;

/**
 * @ClassName Rate
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public class Rate {

    //频次ID
    private Integer rateId;

    //频次
    private String rateVal;

    //get set 方法
    public Rate setRateId (Integer rateId){
        this.rateId=rateId;
        return this;
    }

    public Integer getRateId(){
        return this.rateId;
    }

    public Rate setRateVal (String rateVal){
        this.rateVal=rateVal;
        return this;
    }

    public String getRateVal(){
        return this.rateVal;
    }

}
