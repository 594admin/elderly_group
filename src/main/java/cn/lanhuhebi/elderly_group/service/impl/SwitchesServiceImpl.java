package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.SwitchesDao;
import cn.lanhuhebi.elderly_group.model.pojo.Switches;
import cn.lanhuhebi.elderly_group.service.SwitchesService;
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
public class SwitchesServiceImpl implements SwitchesService {

    @Resource
    private SwitchesDao switchesDao;

    public Switches getSwitchesById(String id){
        return switchesDao.getSwitchesById(id);
    }

    public Integer addSwitches(Switches switches){
            return switchesDao.addSwitches(switches);
    }

    public Integer updateSwitches(Switches switches){
        return switchesDao.updateSwitches(switches);
    }

    public Integer delSwitchesById(String id){
        return switchesDao.delSwitchesById(id);
    }

}
