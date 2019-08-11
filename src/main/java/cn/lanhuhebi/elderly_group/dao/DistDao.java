package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Dist;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface DistDao {

	Dist getDistById(@Param(value = "id") String id);

	Integer addDist(Dist dist);

	Integer updateDist(Dist dist);

	Integer delDistById(@Param(value = "id") String id);

}
