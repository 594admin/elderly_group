package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.TeamLiblog;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface TeamLiblogService {

    TeamLiblog getTeamLiblogById(String id);

    Integer addTeamLiblog(TeamLiblog teamLiblog);

    Integer updateTeamLiblog(TeamLiblog teamLiblog);

    Integer delTeamLiblogById(String id);

}
