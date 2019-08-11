package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Order;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface OrderService {

    Order getOrderById(String id);

    Integer addOrder(Order order);

    Integer updateOrder(Order order);

    Integer delOrderById(String id);

}
