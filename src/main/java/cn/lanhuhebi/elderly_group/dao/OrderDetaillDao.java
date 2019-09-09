package cn.lanhuhebi.elderly_group.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
@Mapper

public interface OrderDetaillDao {

    /**
     * 安装时查询当前采购单的订单明细
     * @param purId
     * @return
     */
    List<OrderDetailVo> getOrderDetailVo(@Param("purId")Integer purId);


    /**
     *
     * @param od_or_id
     * @return
     */
    int addOrderDetail(@Param("od_or_id")Integer od_or_id);

}
