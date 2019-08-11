package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Area;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface AreaService {

    Area getAreaById(String id);

    Integer addArea(Area area);

    Integer updateArea(Area area);

    Integer delAreaById(String id);

}
