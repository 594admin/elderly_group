package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.RateupdalogDao;
import cn.lanhuhebi.elderly_group.model.pojo.Rateupdalog;
import cn.lanhuhebi.elderly_group.service.RateupdalogService;
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
public class RateupdalogServiceImpl implements RateupdalogService {

    @Resource
    private RateupdalogDao rateupdalogDao;

    public Rateupdalog getRateupdalogById(String id){
        return rateupdalogDao.getRateupdalogById(id);
    }

    public Integer addRateupdalog(Rateupdalog rateupdalog){
            return rateupdalogDao.addRateupdalog(rateupdalog);
    }

    public Integer updateRateupdalog(Rateupdalog rateupdalog){
        return rateupdalogDao.updateRateupdalog(rateupdalog);
    }

    public Integer delRateupdalogById(String id){
        return rateupdalogDao.delRateupdalogById(id);
    }

}
