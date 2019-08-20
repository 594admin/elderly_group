package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.TeamDao;
import cn.lanhuhebi.elderly_group.model.dto.TeamListVO;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.model.pojo.Team;
import cn.lanhuhebi.elderly_group.service.TeamService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

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

    @Override
    public List<Personnel> queryAllTeamLeader() {
        return teamDao.queryAllTeamLeader();
    }

    @Override
    public List<Personnel> queryAllInformationer() {
        return teamDao.queryAllInformationer();
    }

    @Override
    public List<Personnel> queryAllWarehouseManager() {
        return teamDao.queryAllWarehouseManager();
    }

    @Override
    public List<Personnel> queryAllInstaller() {
        return teamDao.queryAllInstaller();
    }

    @Override
    public List<TeamListVO> queryAllTeamVO() {
        return teamDao.queryAllTeamVO();
    }

    @Override
    public TeamListVO getTeamVOById(Integer tid) {
        return null;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int addTeam(String teamName, Integer teamLeader, Integer[] informationer, Integer[] warehousemanager, Integer[] installer, Integer creatorId){
        teamDao.addTeamTable(teamName,teamLeader,creatorId);
        Integer teamId=teamDao.getTeamIdByCreateDate();
        for (int i = 0; i < informationer.length; i++) {
            teamDao.addMember(informationer[i],teamId);
        }
        for (int i = 0; i < warehousemanager.length; i++) {
            teamDao.addMember(warehousemanager[i],teamId);
        }
        for (int i = 0; i < installer.length; i++) {
            teamDao.addMember(installer[i],teamId);
        }

        return 0;
    }

    @Override
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public int updTeam(Integer teamId, String teamName, Integer teamLeader, Integer[] informationer, Integer[] warehousemanager, Integer[] installer,Integer creatorId) {
        teamDao.updTeamTable(teamId,teamName,teamLeader,creatorId);
        teamDao.delMember(teamId);
        for (int i = 0; i < informationer.length; i++) {
            teamDao.addMember(informationer[i],teamId);
        }
        for (int i = 0; i < warehousemanager.length; i++) {
            teamDao.addMember(warehousemanager[i],teamId);
        }
        for (int i = 0; i < installer.length; i++) {
            teamDao.addMember(installer[i],teamId);
        }
        return 0;
    }


    @Override
    public Team getTeamById(Integer id) {
        return teamDao.getTeamById(id);
    }

    @Override
    public List<Personnel> getInformationerByTeamId(Integer id) {
        return teamDao.getInformationerByTeamId(id);
    }

    @Override
    public List<Personnel> getWarehouseManagerByTeamId(Integer id) {
        return teamDao.getWarehouseManagerByTeamId(id);
    }

    @Override
    public List<Personnel> getInstallerByTeamId(Integer id) {
        return teamDao.getInstallerByTeamId(id);
    }
}
