package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Switches;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface SwitchesDao {

	Switches getSwitchesById(@Param(value = "id") String id);

	Integer addSwitches(Switches switches);

	Integer updateSwitches(Switches switches);

	Integer delSwitchesById(@Param(value = "id") String id);

}
