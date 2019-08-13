package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.EquipmentDao;
import cn.lanhuhebi.elderly_group.model.pojo.Equipment;
import cn.lanhuhebi.elderly_group.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @ClassName EquipmentServiceImpl
 * @Author Oblivion
 * @Date 2019/8/13
 * @Version 1.0
 **/
@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Resource
    private EquipmentDao equipmentDao;

    @Override
    public List<Equipment> getAllEquipment(Equipment equipment, int page) {
        return equipmentDao.getAllEquipment(equipment, page);
    }

    @Override
    public int addEquipment(Equipment equipment) {
        return equipmentDao.addEquipment(equipment);
    }
}
