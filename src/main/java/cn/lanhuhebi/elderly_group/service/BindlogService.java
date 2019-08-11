package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Bindlog;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface BindlogService {

    Bindlog getBindlogById(String id);

    Integer addBindlog(Bindlog bindlog);

    Integer updateBindlog(Bindlog bindlog);

    Integer delBindlogById(String id);

}
