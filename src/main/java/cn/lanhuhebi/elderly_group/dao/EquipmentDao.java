package cn.lanhuhebi.elderly_group.dao;

import cn.lanhuhebi.elderly_group.model.pojo.Equipment;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface EquipmentDao {

    List<Equipment> getAllEquipment(@Param("ept") Equipment equipment, @Param("page") int page);

    int addEquipment(Equipment equipment);
}
