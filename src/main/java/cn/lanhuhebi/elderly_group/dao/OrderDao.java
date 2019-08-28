package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.dto.Family_purchase_order;
import cn.lanhuhebi.elderly_group.model.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

    int addOrder(Order order);

    List<Family_purchase_order> queryAllOrder(@Param("fly_id") Integer fly_id);

    //根据fly_if删除订单

    int deleteOrderByFlyId(@Param("fly_id")Integer fly_id);
}
