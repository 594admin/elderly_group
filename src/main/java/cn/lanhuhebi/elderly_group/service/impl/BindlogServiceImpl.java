package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.BindlogDao;
import cn.lanhuhebi.elderly_group.model.pojo.Bindlog;
import cn.lanhuhebi.elderly_group.service.BindlogService;
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
public class BindlogServiceImpl implements BindlogService {

    @Resource
    private BindlogDao bindlogDao;

    public Bindlog getBindlogById(String id){
        return bindlogDao.getBindlogById(id);
    }

    public Integer addBindlog(Bindlog bindlog){
            return bindlogDao.addBindlog(bindlog);
    }

    public Integer updateBindlog(Bindlog bindlog){
        return bindlogDao.updateBindlog(bindlog);
    }

    public Integer delBindlogById(String id){
        return bindlogDao.delBindlogById(id);
    }

}
