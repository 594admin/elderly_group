package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.pojo.Liblogs;
import org.apache.ibatis.annotations.Param;

public interface LiblogsDao {

    int addLiblogs(Liblogs liblogs);

    //    添加出库日志
    int addLogs(@Param("lib_type") Integer lib_type, @Param("lib_operator") Integer lib_operator, @Param("lib_pur_id") Integer lib_pur_id);
}
