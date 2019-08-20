package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.dto.Family_team_area;
import cn.lanhuhebi.elderly_group.model.pojo.Equipment;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface FamilyService {
    //查询所有用户信息
    List<Family_team_area> queryAllFamily();
    //删除用户
    boolean updateFamilyStatus(@Param("fly_id")Integer fly_id);
    //添加一条记录
    boolean addFamily( Family family);
    //添加户基础信息
    int addFamFirst(Family family);
    //根据名字查询一条数据
    Family queryOneByName(@Param("fly_name")String fly_name);
    //获得指定设备的价格
    Equipment getEptPrice(Equipment equipment);
    //户资料上传
    int updateFamilyData(Family family);
    //根据主键id查询一个对象
    Family queryOneById(@Param("fly_id")Integer fly_id);
    //根据修改状态
    int updateFamilyAddStatus(@Param("fly_status")Integer fly_status,@Param("fly_id")Integer fly_id);


}
