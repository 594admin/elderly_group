package cn.lanhuhebi.elderly_group.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper

public interface OrderDetaillDao {


    /**
     *
     * @param od_or_id
     * @return
     */
    int addOrderDetail(@Param("od_or_id")Integer od_or_id);

}
