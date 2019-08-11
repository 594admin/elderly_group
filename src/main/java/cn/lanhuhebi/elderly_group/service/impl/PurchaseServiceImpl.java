package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.PurchaseDao;
import cn.lanhuhebi.elderly_group.model.pojo.Purchase;
import cn.lanhuhebi.elderly_group.service.PurchaseService;
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
public class PurchaseServiceImpl implements PurchaseService {

    @Resource
    private PurchaseDao purchaseDao;

    public Purchase getPurchaseById(String id){
        return purchaseDao.getPurchaseById(id);
    }

    public Integer addPurchase(Purchase purchase){
            return purchaseDao.addPurchase(purchase);
    }

    public Integer updatePurchase(Purchase purchase){
        return purchaseDao.updatePurchase(purchase);
    }

    public Integer delPurchaseById(String id){
        return purchaseDao.delPurchaseById(id);
    }

}
