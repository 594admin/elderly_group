package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Auth;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface AuthDao {

	Auth getAuthById(@Param(value = "id") String id);

	Integer addAuth(Auth auth);

	Integer updateAuth(Auth auth);

	Integer delAuthById(@Param(value = "id") String id);

}
