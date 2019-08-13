package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.dto.Family_team_area;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FamilyDao {

    //查询所有用户信息
    List<Family_team_area> queryAllFamily();
    //删除用户
    int updateFamilyStatus(@Param("fly_id")Integer fly_id);
    //添加一条记录
    int addFamily(@Param("family")Family family);



}
