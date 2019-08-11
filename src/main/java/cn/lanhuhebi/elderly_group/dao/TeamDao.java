package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Team;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface TeamDao {

	Team getTeamById(@Param(value = "id") String id);

	Integer addTeam(Team team);

	Integer updateTeam(Team team);

	Integer delTeamById(@Param(value = "id") String id);

}
