package cn.lanhuhebi.elderly_group.dao;
import cn.lanhuhebi.elderly_group.model.pojo.Install;
import org.apache.ibatis.annotations.Param;

/**
 * @ClassName 
 * @Author Oblivion
 * @Date 2019/8/11
 * @Version 1.0
 **/
public interface InstallDao {

	Install getInstallById(@Param(value = "id") String id);

	Integer addInstall(Install install);

	Integer updateInstall(Install install);

	Integer delInstallById(@Param(value = "id") String id);

}
