package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.EquipmentDao;
import cn.lanhuhebi.elderly_group.dao.FamilyDao;
import cn.lanhuhebi.elderly_group.model.dto.Family_team_area;
import cn.lanhuhebi.elderly_group.model.pojo.Equipment;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.service.FamilyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FamilyServiceImpl implements FamilyService {

    @Resource
    private FamilyDao familyDao;
    @Resource
    private EquipmentDao equipmentDao;
    @Override
    public List<Family_team_area> queryAllFamily() {

        return familyDao.queryAllFamily();
    }

    @Override
    public boolean updateFamilyStatus(Integer fly_id) {
        if(familyDao.updateFamilyStatus(fly_id)>0){
            return true;
        }else{

        return false;
        }
    }

    @Override
    public boolean addFamily(Family family) {
        if(familyDao.addFamily(family)>0){
            return true;
        }else{

        return false;
        }
    }

    @Override
    public int addFamFirst(Family family) {
        return familyDao.addFamFirst(family);
    }

    @Override
    public Family queryOneByName(String fly_name) {
        return familyDao.queryOneByName(fly_name);
    }

    @Override
    public Equipment getEptPrice(Equipment equipment) {
        return equipmentDao.getEptPrice(equipment);
    }

    @Override
    public int updateFamilyData(Family family) {
        return familyDao.updateFamilyData(family);
    }

    @Override
    public Family queryOneById(Integer fly_id) {
        return this.familyDao.queryOneById(fly_id);
    }

    @Override
    public int updateFamilyAddStatus(Integer fly_status, Integer fly_id) {
        return this.familyDao.updateFamilyAddStatus(fly_status,fly_id);
    }
}
