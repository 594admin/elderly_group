package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.FamilyDao;
import cn.lanhuhebi.elderly_group.model.pojo.Family;
import cn.lanhuhebi.elderly_group.service.FamilyService;
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
public class FamilyServiceImpl implements FamilyService {

    @Resource
    private FamilyDao familyDao;

    public Family getFamilyById(String id){
        return familyDao.getFamilyById(id);
    }

    public Integer addFamily(Family family){
            return familyDao.addFamily(family);
    }

    public Integer updateFamily(Family family){
        return familyDao.updateFamily(family);
    }

    public Integer delFamilyById(String id){
        return familyDao.delFamilyById(id);
    }

}
