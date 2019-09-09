package cn.lanhuhebi.elderly_group.service;

import org.apache.ibatis.annotations.Param;

public interface OrderDetaliService {
    //添加
    int addOrderDetail(@Param("od_or_id")Integer od_or_id);
}
