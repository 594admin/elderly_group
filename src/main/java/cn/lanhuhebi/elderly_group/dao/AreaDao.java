package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Area;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface AreaDao {

	Area getAreaById(@Param(value = "id") String id);

	Integer addArea(Area area);

	Integer updateArea(Area area);

	Integer delAreaById(@Param(value = "id") String id);

}
