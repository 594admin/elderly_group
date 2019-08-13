package cn.lanhuhebi.elderly_group.service;

import cn.lanhuhebi.elderly_group.model.pojo.Equipment;

import java.util.List;

public interface EquipmentService {

    List<Equipment> getAllEquipment(Equipment equipment, int page);

    int addEquipment(Equipment equipment);
}
