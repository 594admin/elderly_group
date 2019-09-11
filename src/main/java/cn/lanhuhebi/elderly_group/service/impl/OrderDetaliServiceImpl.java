package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.OrderDetaillDao;
import cn.lanhuhebi.elderly_group.service.OrderDetaliService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class OrderDetaliServiceImpl implements OrderDetaliService {

    @Resource
    private OrderDetaillDao detaillDao;
    @Override
    public int addOrderDetail(Integer od_or_id) {

        return this.detaillDao.addOrderDetail(od_or_id);
    }

    @Override
    public boolean updateOrderDetail(Integer odId, String odEmpNo, String odPhoto) {
        return detaillDao.updateOrderDetail(odId, odEmpNo, odPhoto)>0;
    }
}
