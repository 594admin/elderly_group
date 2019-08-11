package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Equipment;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface EquipmentService {

    Equipment getEquipmentById(String id);

    Integer addEquipment(Equipment equipment);

    Integer updateEquipment(Equipment equipment);

    Integer delEquipmentById(String id);

}
