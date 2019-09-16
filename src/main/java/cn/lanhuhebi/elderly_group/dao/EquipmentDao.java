package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.pojo.Equipment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EquipmentDao {

    List<Equipment> getAllEquipment();

    int addEquipment(Equipment equipment);

    int updateStock(Equipment equipment);

    Equipment getEptPrice(Equipment equipment);

    Integer getEptByMTF(Equipment equipment);

//    小组库存执行入库操作库存
    int updStock(@Param("ept_stock") Integer num, @Param("ept_id") Integer eptId);
}
