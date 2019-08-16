package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.pojo.Equipment;

import java.util.List;

public interface EquipmentDao {

    List<Equipment> getAllEquipment();

    int addEquipment(Equipment equipment);

    int updateStock(Equipment equipment);

    double getEptPrice(Equipment equipment);
}
