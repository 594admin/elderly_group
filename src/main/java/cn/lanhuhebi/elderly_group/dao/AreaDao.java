package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.pojo.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaDao {
    //查询所有的省
    List<Area> queryAllSheng();
    //根据上级id查询所有下级
    List<Area> queryAllXiaByShang(@Param("areaid")Integer areaid);


}
