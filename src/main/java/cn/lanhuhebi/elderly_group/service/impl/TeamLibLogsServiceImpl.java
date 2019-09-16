package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.TeameptDao;
import cn.lanhuhebi.elderly_group.dao.TeamlLibLogsDao;
import cn.lanhuhebi.elderly_group.model.pojo.TeamLiblog;
import cn.lanhuhebi.elderly_group.service.TeamLibLogsService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class TeamLibLogsServiceImpl implements TeamLibLogsService {

    @Resource
    private TeamlLibLogsDao teamlLibLogsDao;

    @Override
    public int addLogs(Integer temLibType, Integer temLibOperator, Integer temLibEptId, Integer temLibPurseId, Integer temLibNum) {
        return teamlLibLogsDao.addLogs(temLibType, temLibOperator, temLibEptId, temLibPurseId, temLibNum);
    }
}
