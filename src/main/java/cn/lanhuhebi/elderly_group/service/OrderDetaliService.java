package cn.lanhuhebi.elderly_group.service;

import org.apache.ibatis.annotations.Param;

public interface OrderDetaliService {
    /**
     *
     * @param od_or_id
     * @return
     */
    int addOrderDetail(@Param("od_or_id")Integer od_or_id);
}
