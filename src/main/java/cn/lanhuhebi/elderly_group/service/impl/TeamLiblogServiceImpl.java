package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.TeamLiblogDao;
import cn.lanhuhebi.elderly_group.model.pojo.TeamLiblog;
import cn.lanhuhebi.elderly_group.service.TeamLiblogService;
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
public class TeamLiblogServiceImpl implements TeamLiblogService {

    @Resource
    private TeamLiblogDao teamLiblogDao;

    public TeamLiblog getTeamLiblogById(String id){
        return teamLiblogDao.getTeamLiblogById(id);
    }

    public Integer addTeamLiblog(TeamLiblog teamLiblog){
            return teamLiblogDao.addTeamLiblog(teamLiblog);
    }

    public Integer updateTeamLiblog(TeamLiblog teamLiblog){
        return teamLiblogDao.updateTeamLiblog(teamLiblog);
    }

    public Integer delTeamLiblogById(String id){
        return teamLiblogDao.delTeamLiblogById(id);
    }

}
