package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.pojo.Purchase;
import org.apache.ibatis.annotations.Param;

public interface PurchaseService {

    int addOnePurchase(Purchase purchase);

    Purchase queryOneByFlyId(@Param("fly_id")Integer fly_id);

}
