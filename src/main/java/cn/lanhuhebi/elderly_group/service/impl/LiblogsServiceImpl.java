package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.LiblogsDao;
import cn.lanhuhebi.elderly_group.model.pojo.Liblogs;
import cn.lanhuhebi.elderly_group.service.LiblogsService;
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
public class LiblogsServiceImpl implements LiblogsService {

    @Resource
    private LiblogsDao liblogsDao;

    public Liblogs getLiblogsById(String id){
        return liblogsDao.getLiblogsById(id);
    }

    public Integer addLiblogs(Liblogs liblogs){
            return liblogsDao.addLiblogs(liblogs);
    }

    public Integer updateLiblogs(Liblogs liblogs){
        return liblogsDao.updateLiblogs(liblogs);
    }

    public Integer delLiblogsById(String id){
        return liblogsDao.delLiblogsById(id);
    }

}
