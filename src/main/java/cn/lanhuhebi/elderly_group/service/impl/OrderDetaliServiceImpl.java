package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.OrderDetaillDao;
import cn.lanhuhebi.elderly_group.service.OrderDetaliService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class OrderDetaliServiceImpl implements OrderDetaliService {

    @Autowired
    private OrderDetaillDao detaillDao;
    @Override
    public int addOrderDetail(Integer od_or_id) {

        return this.detaillDao.addOrderDetail(od_or_id);
    }
}
