package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Purchase;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface PurchaseDao {

	Purchase getPurchaseById(@Param(value = "id") String id);

	Integer addPurchase(Purchase purchase);

	Integer updatePurchase(Purchase purchase);

	Integer delPurchaseById(@Param(value = "id") String id);

}
