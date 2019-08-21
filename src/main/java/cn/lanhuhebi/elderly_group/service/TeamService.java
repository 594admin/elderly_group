package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.dto.TeamListVO;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.model.pojo.Team;

import java.util.List;

public interface TeamService {

    //查询所有工程小组
    List<Team> queryAllTeam();

    //查询所有组长
    List<Personnel> queryAllTeamLeader();
    //查询所有信息员（未入组的）
    List<Personnel> queryAllInformationer();
    //查询所有库管员（未入组的）
    List<Personnel> queryAllWarehouseManager();
    //查询所有安装工（未入组的）
    List<Personnel> queryAllInstaller();
    //查询所有工程小组（TeamListVO中所有信息）
    List<TeamListVO> queryAllTeamVO();
    //查询单个工程小组实体（TeamListVO）
    TeamListVO getTeamVOById(Integer tid);
    //新增工程小组
    int addTeam(String teamName, Integer teamLeader,
                Integer[] informationer, Integer[] warehousemanager,
                Integer[] installer,Integer creatorId);
    //修改工程小组
    int updTeam(Integer teamId,String teamName,Integer teamLeader,
                Integer[] informationer,Integer[] warehousemanager,
                Integer[] installer,Integer creatorId);
    //根据组ID查询组名、组长ID、组ID
    Team getTeamById(Integer id);
    //根据组ID查询本组信息员ID、姓名
    List<Personnel> getInformationerByTeamId(Integer id);
    //根据组ID查询本组库管员ID、姓名
    List<Personnel> getWarehouseManagerByTeamId(Integer id);
    //根据组ID查询本组安装工ID、姓名
    List<Personnel> getInstallerByTeamId(Integer id);

}
