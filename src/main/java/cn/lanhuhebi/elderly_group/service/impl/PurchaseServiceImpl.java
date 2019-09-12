package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.PurchaseDao;
import cn.lanhuhebi.elderly_group.model.dto.PurchaseVo;
import cn.lanhuhebi.elderly_group.model.pojo.Purchase;
import cn.lanhuhebi.elderly_group.service.PurchaseService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class PurchaseServiceImpl implements PurchaseService {

    @Resource
    private PurchaseDao purchaseDao;
    @Override
    public int addOnePurchase(Purchase purchase) {
        return purchaseDao.addOnePurchase(purchase);
    }

    @Override
    public Purchase queryOneByFlyId(Integer fly_id) {
        return this.purchaseDao.queryOneByPurchaseFlyId(fly_id);
    }

    @Override
    public List<PurchaseVo> queryAll(Integer fly_id) {
        return purchaseDao.queryAll(fly_id);
    }

    @Override
    public int addPurchaseVo(Purchase purchase) {
        return purchaseDao.addPurchaseVo(purchase);
    }

    @Override
    public List<PurchaseVo> detailPurchaseVo0(Integer fly_id) {
        return purchaseDao.detailPurchaseVo0(fly_id);
    }

    @Override
    public List<PurchaseVo> detailPurchaseVo1(Integer fly_id) {
        return purchaseDao.detailPurchaseVo1(fly_id);
    }

    @Override
    public List<PurchaseVo> queryAll1() {
        return purchaseDao.queryAll1();
    }

    @Override
    public int searchCountByStatus1() {
        return purchaseDao.searchCountByStatus1();
    }

    @Override
    public List<PurchaseVo> queryAll0() {
        return purchaseDao.queryAll0();
    }

    @Override
    public int searchCountByStatus0() {
        return purchaseDao.searchCountByStatus0();
    }
}
