package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Team;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface TeamService {

    Team getTeamById(String id);

    Integer addTeam(Team team);

    Integer updateTeam(Team team);

    Integer delTeamById(String id);

}
