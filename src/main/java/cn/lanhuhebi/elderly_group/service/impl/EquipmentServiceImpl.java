package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.EquipmentDao;
import cn.lanhuhebi.elderly_group.model.pojo.Equipment;
import cn.lanhuhebi.elderly_group.service.EquipmentService;
import org.springframework.stereotype.Service;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
@Service
public class EquipmentServiceImpl implements EquipmentService {

    @Resource
    private EquipmentDao equipmentDao;

    public Equipment getEquipmentById(String id){
        return equipmentDao.getEquipmentById(id);
    }

    public Integer addEquipment(Equipment equipment){
            return equipmentDao.addEquipment(equipment);
    }

    public Integer updateEquipment(Equipment equipment){
        return equipmentDao.updateEquipment(equipment);
    }

    public Integer delEquipmentById(String id){
        return equipmentDao.delEquipmentById(id);
    }

}
