package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Dist;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface DistService {

    Dist getDistById(String id);

    Integer addDist(Dist dist);

    Integer updateDist(Dist dist);

    Integer delDistById(String id);

}
