package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Rateupdalog;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface RateupdalogDao {

	Rateupdalog getRateupdalogById(@Param(value = "id") String id);

	Integer addRateupdalog(Rateupdalog rateupdalog);

	Integer updateRateupdalog(Rateupdalog rateupdalog);

	Integer delRateupdalogById(@Param(value = "id") String id);

}
