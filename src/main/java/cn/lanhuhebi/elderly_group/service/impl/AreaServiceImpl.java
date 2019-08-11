package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.AreaDao;
import cn.lanhuhebi.elderly_group.model.pojo.Area;
import cn.lanhuhebi.elderly_group.service.AreaService;
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
public class AreaServiceImpl implements AreaService {

    @Resource
    private AreaDao areaDao;

    public Area getAreaById(String id){
        return areaDao.getAreaById(id);
    }

    public Integer addArea(Area area){
            return areaDao.addArea(area);
    }

    public Integer updateArea(Area area){
        return areaDao.updateArea(area);
    }

    public Integer delAreaById(String id){
        return areaDao.delAreaById(id);
    }

}
