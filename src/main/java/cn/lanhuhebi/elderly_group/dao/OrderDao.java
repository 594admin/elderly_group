package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Order;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface OrderDao {

	Order getOrderById(@Param(value = "id") String id);

	Integer addOrder(Order order);

	Integer updateOrder(Order order);

	Integer delOrderById(@Param(value = "id") String id);

}
