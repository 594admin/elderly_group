package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.pojo.Team;

import java.util.List;

public interface TeamDao {

    //查询所有工程小组
    List<Team> queryAllTeam();

}
