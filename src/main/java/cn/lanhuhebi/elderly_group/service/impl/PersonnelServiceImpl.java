package cn.lanhuhebi.elderly_group.service.impl;

import cn.lanhuhebi.elderly_group.dao.PersonnelDao;
import cn.lanhuhebi.elderly_group.model.pojo.Personnel;
import cn.lanhuhebi.elderly_group.service.PersonnelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName PersonnelServiceImpl
 * @Author Oblivion
 * @Date 2019/8/12
 * @Version 1.0
 **/

@Service("PersonnelServiceImpl")
public class PersonnelServiceImpl implements PersonnelService {
    @Autowired
    private PersonnelDao personnelDao;


    @Override
    public Personnel login(String account) {
        return personnelDao.login(account);
    }

    @Override
    public List<Personnel> listPersonnel() {
        return personnelDao.listPersonnel();
    }
}
