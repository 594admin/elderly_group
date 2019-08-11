package cn.lanhuhebi.elderly_group.service;
import cn.lanhuhebi.elderly_group.model.pojo.Install;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface InstallService {

    Install getInstallById(String id);

    Integer addInstall(Install install);

    Integer updateInstall(Install install);

    Integer delInstallById(String id);

}
