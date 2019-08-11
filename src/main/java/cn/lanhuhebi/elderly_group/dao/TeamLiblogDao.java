package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.TeamLiblog;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface TeamLiblogDao {

	TeamLiblog getTeamLiblogById(@Param(value = "id") String id);

	Integer addTeamLiblog(TeamLiblog teamLiblog);

	Integer updateTeamLiblog(TeamLiblog teamLiblog);

	Integer delTeamLiblogById(@Param(value = "id") String id);

}
