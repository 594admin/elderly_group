package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.pojo.Area;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface AreaService {

    List<Area> queryAllXiaJiByShang(@Param("areaid")Integer areaid);


}
