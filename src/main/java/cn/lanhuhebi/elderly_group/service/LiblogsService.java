package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Liblogs;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface LiblogsService {

    Liblogs getLiblogsById(String id);

    Integer addLiblogs(Liblogs liblogs);

    Integer updateLiblogs(Liblogs liblogs);

    Integer delLiblogsById(String id);

}
