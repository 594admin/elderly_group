package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Rateupdalog;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface RateupdalogService {

    Rateupdalog getRateupdalogById(String id);

    Integer addRateupdalog(Rateupdalog rateupdalog);

    Integer updateRateupdalog(Rateupdalog rateupdalog);

    Integer delRateupdalogById(String id);

}
