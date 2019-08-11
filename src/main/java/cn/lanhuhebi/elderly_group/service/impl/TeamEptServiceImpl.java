package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.TeamEptDao;
import cn.lanhuhebi.elderly_group.model.pojo.TeamEpt;
import cn.lanhuhebi.elderly_group.service.TeamEptService;
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
public class TeamEptServiceImpl implements TeamEptService {

    @Resource
    private TeamEptDao teamEptDao;

    public TeamEpt getTeamEptById(String id){
        return teamEptDao.getTeamEptById(id);
    }

    public Integer addTeamEpt(TeamEpt teamEpt){
            return teamEptDao.addTeamEpt(teamEpt);
    }

    public Integer updateTeamEpt(TeamEpt teamEpt){
        return teamEptDao.updateTeamEpt(teamEpt);
    }

    public Integer delTeamEptById(String id){
        return teamEptDao.delTeamEptById(id);
    }

}
