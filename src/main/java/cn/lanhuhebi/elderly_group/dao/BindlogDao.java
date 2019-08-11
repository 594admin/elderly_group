package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Bindlog;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface BindlogDao {

	Bindlog getBindlogById(@Param(value = "id") String id);

	Integer addBindlog(Bindlog bindlog);

	Integer updateBindlog(Bindlog bindlog);

	Integer delBindlogById(@Param(value = "id") String id);

}
