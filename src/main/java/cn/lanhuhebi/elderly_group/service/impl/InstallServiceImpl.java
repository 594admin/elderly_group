package cn.lanhuhebi.elderly_group.service.impl;
import cn.lanhuhebi.elderly_group.dao.InstallDao;
import cn.lanhuhebi.elderly_group.model.pojo.Install;
import cn.lanhuhebi.elderly_group.service.InstallService;
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
public class InstallServiceImpl implements InstallService {

    @Resource
    private InstallDao installDao;

    public Install getInstallById(String id){
        return installDao.getInstallById(id);
    }

    public Integer addInstall(Install install){
            return installDao.addInstall(install);
    }

    public Integer updateInstall(Install install){
        return installDao.updateInstall(install);
    }

    public Integer delInstallById(String id){
        return installDao.delInstallById(id);
    }

}
