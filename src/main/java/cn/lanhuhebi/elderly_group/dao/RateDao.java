package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Rate;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface RateDao {

	Rate getRateById(@Param(value = "id") String id);

	Integer addRate(Rate rate);

	Integer updateRate(Rate rate);

	Integer delRateById(@Param(value = "id") String id);

}
