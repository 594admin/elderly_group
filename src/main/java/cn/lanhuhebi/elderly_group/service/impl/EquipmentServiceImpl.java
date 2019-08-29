package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.EquipmentDao;
import cn.lanhuhebi.elderly_group.dao.LiblogsDao;
import cn.lanhuhebi.elderly_group.model.pojo.Equipment;
import cn.lanhuhebi.elderly_group.model.pojo.Liblogs;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.service.EquipmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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

    @Autowired
    private EquipmentDao equipmentDao;

    @Autowired
    private LiblogsDao liblogsDao;

    @Override
    public List<Equipment> getAllEquipment() {
        return equipmentDao.getAllEquipment();
    }

    @Override
    public boolean addEquipment(Equipment equipment) {
        return equipmentDao.addEquipment(equipment) == 1 ? true : false;
    }

    @Override
    @Transactional
    public boolean updateStock(Equipment equipment, Liblogs liblogs, Personnel personnel) {
        System.out.println("库存:" + equipment.getEptStock());
        System.out.println("操作:" + liblogs.getLibNum());
        equipment.setEptStock(equipment.getEptStock() + liblogs.getLibNum() * (liblogs.getLibType() == 1 ? -1 : 1));
        int i = equipmentDao.updateStock(equipment);
        liblogs.setLibOperator(personnel.getPreId());
        liblogs.setLibEptId(equipment.getEptId());
        int j = liblogsDao.addLiblogs(liblogs);
        return i == 1 && j == 1 ? true : false;
    }

}