package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Purchase;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface PurchaseService {

    Purchase getPurchaseById(String id);

    Integer addPurchase(Purchase purchase);

    Integer updatePurchase(Purchase purchase);

    Integer delPurchaseById(String id);

}
