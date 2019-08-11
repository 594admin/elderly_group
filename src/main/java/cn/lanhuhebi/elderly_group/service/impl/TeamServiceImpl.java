package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.TeamDao;
import cn.lanhuhebi.elderly_group.model.pojo.Team;
import cn.lanhuhebi.elderly_group.service.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
@Service
public class TeamServiceImpl implements TeamService {

    @Resource
    private TeamDao teamDao;

    public Team getTeamById(String id){
        return teamDao.getTeamById(id);
    }

    public Integer addTeam(Team team){
            return teamDao.addTeam(team);
    }

    public Integer updateTeam(Team team){
        return teamDao.updateTeam(team);
    }

    public Integer delTeamById(String id){
        return teamDao.delTeamById(id);
    }

}
