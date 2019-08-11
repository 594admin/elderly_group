package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.TeamEpt;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface TeamEptService {

    TeamEpt getTeamEptById(String id);

    Integer addTeamEpt(TeamEpt teamEpt);

    Integer updateTeamEpt(TeamEpt teamEpt);

    Integer delTeamEptById(String id);

}
