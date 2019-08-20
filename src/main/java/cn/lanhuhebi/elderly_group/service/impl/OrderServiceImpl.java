package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.OrderDao;
import cn.lanhuhebi.elderly_group.model.pojo.Order;
import cn.lanhuhebi.elderly_group.service.OrderService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class OrderServiceImpl implements OrderService {
    @Resource
    private OrderDao orderDao;
    @Override
    public int addOrder(Order order) {
        return this.orderDao.addOrder(order);
    }
}
