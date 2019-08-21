package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.dto.Family_purchase_order;
import cn.lanhuhebi.elderly_group.model.pojo.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderDao {

    int addOrder(Order order);

    List<Family_purchase_order> queryAllOrder(@Param("fly_id") Integer fly_id);
}
