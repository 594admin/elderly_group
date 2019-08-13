package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.FamilyDao;
import cn.lanhuhebi.elderly_group.model.dto.Family_team_area;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.service.FamilyService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
@Service
public class FamilyServiceImpl implements FamilyService {

    @Resource
    private FamilyDao familyDao;
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
}
