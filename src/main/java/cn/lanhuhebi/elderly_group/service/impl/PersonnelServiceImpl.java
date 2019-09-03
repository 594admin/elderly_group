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

    @Override
    public boolean addPersonnel(Personnel personnel) {
        return personnelDao.addPersonnel(personnel) > 0;
    }

    @Override
    public boolean checkPhone(String prePhone) {
        String checkPhone = personnelDao.checkPhone(prePhone);
        return checkPhone != null && !checkPhone.equals("");
    }

    @Override
    public Personnel getPersonnleOne(String prePhone) {
        return personnelDao.getPersonnleOne(prePhone);
    }

    @Override
    public boolean checkEmail(String preEmail) {
        String checkEmail = personnelDao.checkEmail(preEmail);
        return checkEmail != null && !checkEmail.equals("");
    }

    @Override
    public Personnel getPersonnelOne(Integer preId) {
        return personnelDao.getPersonnelOne(preId);
    }

    @Override
    public boolean updatePersonnel(Personnel personnel) {
        return personnelDao.updatePersonnel(personnel) > 0;
    }

    @Override
    public Integer checkPhoneByPreId(String prePhone, Integer preId) {
        return personnelDao.checkPhoneByPreId(prePhone, preId);
    }

    @Override
    public Integer checkEmailByPreId(String preEmail, Integer preId) {
        return personnelDao.checkEmailByPreId(preEmail, preId);
    }

    @Override
    public boolean addPerRole(Integer roleId, Integer preId) {
        return personnelDao.addPerRole(roleId, preId) > 0;
    }

    @Override
    public int queryTeamId(Integer pre_id) {
        return personnelDao.queryTeamId(pre_id);
    }
}
