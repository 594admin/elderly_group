package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.PurchaseDao;
import cn.lanhuhebi.elderly_group.model.pojo.Purchase;
import cn.lanhuhebi.elderly_group.service.PurchaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Resource
    private PurchaseDao purchaseDao;
    @Override
    public int addOnePurchase(Purchase purchase) {
        return purchaseDao.addOnePurchase(purchase);
    }
}
