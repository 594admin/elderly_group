package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.PersonnelDao;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.service.PersonnelService;
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
public class PersonnelServiceImpl implements PersonnelService {

    @Resource
    private PersonnelDao personnelDao;

    public Personnel getPersonnelById(String id){
        return personnelDao.getPersonnelById(id);
    }

    public Integer addPersonnel(Personnel personnel){
            return personnelDao.addPersonnel(personnel);
    }

    public Integer updatePersonnel(Personnel personnel){
        return personnelDao.updatePersonnel(personnel);
    }

    public Integer delPersonnelById(String id){
        return personnelDao.delPersonnelById(id);
    }

}
