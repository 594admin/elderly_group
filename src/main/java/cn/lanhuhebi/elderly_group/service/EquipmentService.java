package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.pojo.Equipment;
import cn.lanhuhebi.elderly_group.model.pojo.Liblogs;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;

import java.util.List;

public interface EquipmentService {

    List<Equipment> getAllEquipment();

    String addEquipment(Equipment equipment);

    boolean updateStock(Equipment equipment, Liblogs liblogs, Personnel personnel);

}
