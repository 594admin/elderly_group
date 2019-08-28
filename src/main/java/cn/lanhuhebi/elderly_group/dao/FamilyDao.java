package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.dto.Family_team_area;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FamilyDao {

    //查询所有用户信息
    List<Family_team_area> queryAllFamily();
    Family_team_area queryOneFamilyErea(@Param("fly_id")Integer fly_id);
    //根据名字查询一条数据
    Family queryOneByName(@Param("fly_name")String fly_name);
    //根据主键id查询一个对象
    Family queryOneById(@Param("fly_id")Integer fly_id);
    //删除用户
    int updateFamilyStatus(@Param("fly_id")Integer fly_id);
    //根据修改状态
    int updateFamilyAddStatus(@Param("fly_status")Integer fly_status,@Param("fly_id")Integer fly_id);
    //添加户基础信息
    int addFamFirst(Family family);

    int addFamily(Family family);
    //户资料上传
    int updateFamilyData(Family family);








}
