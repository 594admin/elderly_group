package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Liblogs;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface LiblogsDao {

	Liblogs getLiblogsById(@Param(value = "id") String id);

	Integer addLiblogs(Liblogs liblogs);

	Integer updateLiblogs(Liblogs liblogs);

	Integer delLiblogsById(@Param(value = "id") String id);

}
