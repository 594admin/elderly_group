package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.DistDao;
import cn.lanhuhebi.elderly_group.model.pojo.Dist;
import cn.lanhuhebi.elderly_group.service.DistService;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
@Service
public class DistServiceImpl implements DistService {

    @Resource
    private DistDao distDao;

    public Dist getDistById(String id){
        return distDao.getDistById(id);
    }

    public Integer addDist(Dist dist){
            return distDao.addDist(dist);
    }

    public Integer updateDist(Dist dist){
        return distDao.updateDist(dist);
    }

    public Integer delDistById(String id){
        return distDao.delDistById(id);
    }

}
