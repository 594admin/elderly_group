package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Rate;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface RateService {

    Rate getRateById(String id);

    Integer addRate(Rate rate);

    Integer updateRate(Rate rate);

    Integer delRateById(String id);

}
