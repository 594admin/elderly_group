package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.RateDao;
import cn.lanhuhebi.elderly_group.model.pojo.Rate;
import cn.lanhuhebi.elderly_group.service.RateService;
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
public class RateServiceImpl implements RateService {

    @Resource
    private RateDao rateDao;

    public Rate getRateById(String id){
        return rateDao.getRateById(id);
    }

    public Integer addRate(Rate rate){
            return rateDao.addRate(rate);
    }

    public Integer updateRate(Rate rate){
        return rateDao.updateRate(rate);
    }

    public Integer delRateById(String id){
        return rateDao.delRateById(id);
    }

}
