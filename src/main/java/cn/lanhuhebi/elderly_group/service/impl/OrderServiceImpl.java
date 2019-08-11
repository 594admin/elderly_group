package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.OrderDao;
import cn.lanhuhebi.elderly_group.model.pojo.Order;
import cn.lanhuhebi.elderly_group.service.OrderService;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
@Service
public class OrderServiceImpl implements OrderService {

    @Resource
    private OrderDao orderDao;

    public Order getOrderById(String id){
        return orderDao.getOrderById(id);
    }

    public Integer addOrder(Order order){
            return orderDao.addOrder(order);
    }

    public Integer updateOrder(Order order){
        return orderDao.updateOrder(order);
    }

    public Integer delOrderById(String id){
        return orderDao.delOrderById(id);
    }

}
