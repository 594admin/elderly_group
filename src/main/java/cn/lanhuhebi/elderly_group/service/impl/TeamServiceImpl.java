package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.TeamDao;
import cn.lanhuhebi.elderly_group.model.pojo.Team;
import cn.lanhuhebi.elderly_group.service.TeamService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class TeamServiceImpl implements TeamService {

    @Resource
    private TeamDao teamDao;
    @Override
    public List<Team> queryAllTeam() {
        return teamDao.queryAllTeam();
    }
}
