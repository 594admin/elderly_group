package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Equipment;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface EquipmentDao {

	Equipment getEquipmentById(@Param(value = "id") String id);

	Integer addEquipment(Equipment equipment);

	Integer updateEquipment(Equipment equipment);

	Integer delEquipmentById(@Param(value = "id") String id);

}
