package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.pojo.Purchase;
import org.apache.ibatis.annotations.Param;

public interface PurchaseDao {

    int addOnePurchase(Purchase purchase);

    //查询一条数据

    Purchase queryOneByPurchaseFlyId(@Param("fly_id")Integer fly_id);


}
