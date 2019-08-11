package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.CaDao;
import cn.lanhuhebi.elderly_group.model.pojo.Ca;
import cn.lanhuhebi.elderly_group.service.CaService;
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
public class CaServiceImpl implements CaService {

    @Resource
    private CaDao caDao;

    public Ca getCaById(String id){
        return caDao.getCaById(id);
    }

    public Integer addCa(Ca ca){
            return caDao.addCa(ca);
    }

    public Integer updateCa(Ca ca){
        return caDao.updateCa(ca);
    }

    public Integer delCaById(String id){
        return caDao.delCaById(id);
    }

}
