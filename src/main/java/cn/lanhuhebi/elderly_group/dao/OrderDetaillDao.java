package cn.lanhuhebi.elderly_group.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper

public interface OrderDetaillDao {


    //添加
    int addOrderDetail(@Param("od_or_id")Integer od_or_id);

}
