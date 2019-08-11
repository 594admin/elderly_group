package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.TeamEpt;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface TeamEptDao {

	TeamEpt getTeamEptById(@Param(value = "id") String id);

	Integer addTeamEpt(TeamEpt teamEpt);

	Integer updateTeamEpt(TeamEpt teamEpt);

	Integer delTeamEptById(@Param(value = "id") String id);

}
